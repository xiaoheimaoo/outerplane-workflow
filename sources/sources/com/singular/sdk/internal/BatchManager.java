package com.singular.sdk.internal;

import android.content.Context;
import com.singular.sdk.internal.Constants;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BatchManager {
    private static final String SEND_ID = "send_id";
    private static BatchManager instance;
    private static final SingularLog logger = SingularLog.getLogger("BatchManager");
    private BatchManagerPersistence batchManagerPersistence;
    private Context context;
    private NetworkSender networkSender;
    private RegularFlowSender regularFlowSender;
    private long sendId;
    private Semaphore sendIdMutex = new Semaphore(1, true);
    private Semaphore sendMutex = new Semaphore(1, true);
    private String[] batchFields = {"ad_platform", Constants.ADMON_CURRENCY, Constants.REVENUE_CURRENCY_KEY};
    private Map<String, BaseApi> eventsDataStructure = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public interface NetworkSender {
        boolean sendApi(BaseApi baseApi);
    }

    /* loaded from: classes3.dex */
    public interface RegularFlowSender {
        void sendApi(BaseApi baseApi);
    }

    static /* synthetic */ void access$900(BatchManager batchManager, Throwable th) {
        batchManager.reportException(th);
    }

    private String prepareKey(BaseApi baseApi) throws JSONException {
        String[] strArr;
        logger.debug("prepareKey for API: " + baseApi.toJsonAsString());
        JSONObject jSONObject = new JSONObject((String) baseApi.get(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(SEND_ID, this.sendId);
        for (String str : this.batchFields) {
            try {
                jSONObject2.put(str, jSONObject.getString(str));
            } catch (JSONException e) {
                logger.error(Utils.formatException(e));
            }
        }
        logger.debug("prepareKey result: " + jSONObject2.toString());
        return jSONObject2.toString();
    }

    public static BatchManager getInstance() {
        if (instance == null) {
            instance = new BatchManager();
        }
        return instance;
    }

    private BatchManager() {
    }

    public void setup(Context context) {
        this.batchManagerPersistence = new BatchManagerPersistenceSqlite(context);
        this.networkSender = new NetworkSender() { // from class: com.singular.sdk.internal.BatchManager.1
            @Override // com.singular.sdk.internal.BatchManager.NetworkSender
            public boolean sendApi(BaseApi baseApi) {
                try {
                    JSONObject globalPropertiesJSON = SingularInstance.getInstance().getGlobalPropertiesJSON();
                    if (globalPropertiesJSON.length() != 0) {
                        baseApi.put(Constants.GLOBAL_PROPERTIES_KEY, globalPropertiesJSON.toString());
                    }
                    return baseApi.makeRequest(SingularInstance.getInstance());
                } catch (IOException e) {
                    BatchManager.logger.error(Utils.formatException(e));
                    return false;
                }
            }
        };
        this.regularFlowSender = new RegularFlowSender() { // from class: com.singular.sdk.internal.BatchManager.2
            @Override // com.singular.sdk.internal.BatchManager.RegularFlowSender
            public void sendApi(BaseApi baseApi) {
                SingularInstance.getInstance().getApiManager().enqueue(baseApi);
            }
        };
        this.sendId = this.batchManagerPersistence.getSendId();
        this.context = context;
        loadFromPersistence();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void batchEvent(BaseApi baseApi) throws JSONException, IOException {
        try {
            this.sendIdMutex.acquire();
        } catch (InterruptedException e) {
            logger.error(Utils.formatException(e));
        }
        long currentTimeMillis = System.currentTimeMillis();
        String prepareKey = prepareKey(baseApi);
        SingularLog singularLog = logger;
        singularLog.debug("batchEvent: " + baseApi.toJsonAsString());
        singularLog.debug("batchEvent: key: " + prepareKey);
        JSONObject jSONObject = new JSONObject((String) baseApi.get(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY));
        if (this.eventsDataStructure.containsKey(prepareKey)) {
            BaseApi baseApi2 = this.eventsDataStructure.get(prepareKey);
            JSONObject jSONObject2 = new JSONObject((String) baseApi2.get(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY));
            jSONObject2.put(Constants.REVENUE_AMOUNT_KEY, jSONObject2.getDouble(Constants.REVENUE_AMOUNT_KEY) + jSONObject.getDouble(Constants.REVENUE_AMOUNT_KEY));
            jSONObject2.put(Constants.ADMON_REVENUE, jSONObject2.getDouble(Constants.ADMON_REVENUE) + jSONObject.getDouble(Constants.ADMON_REVENUE));
            jSONObject2.put(Constants.ADMON_COUNT, jSONObject2.getInt(Constants.ADMON_COUNT) + 1);
            jSONObject2.put(Constants.ADMON_LAST_UPDATE_TIMESTAMP, currentTimeMillis);
            baseApi2.put(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, jSONObject2.toString());
            singularLog.debug("batchEvent: added to existing event: " + baseApi2.toJsonAsString());
            this.sendIdMutex.release();
            this.batchManagerPersistence.updateEvent(prepareKey, baseApi2.toJsonAsString());
        } else {
            JSONObject jSONObject3 = new JSONObject(prepareKey);
            jSONObject3.remove(SEND_ID);
            double d = jSONObject.getDouble(Constants.REVENUE_AMOUNT_KEY);
            double d2 = jSONObject.getDouble(Constants.ADMON_REVENUE);
            jSONObject3.put(Constants.REVENUE_AMOUNT_KEY, d);
            jSONObject3.put(Constants.ADMON_REVENUE, d2);
            jSONObject3.put(Constants.ADMON_COUNT, 1);
            jSONObject3.put(Constants.ADMON_IS_ADMON_REVENUE, jSONObject.getBoolean(Constants.ADMON_IS_ADMON_REVENUE));
            jSONObject3.put(Constants.IS_REVENUE_EVENT_KEY, jSONObject.getBoolean(Constants.IS_REVENUE_EVENT_KEY));
            jSONObject3.put(Constants.ADMON_FIRST_UPDATE_TIMESTAMP, currentTimeMillis);
            jSONObject3.put(Constants.ADMON_LAST_UPDATE_TIMESTAMP, currentTimeMillis);
            baseApi.put(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, jSONObject3.toString());
            baseApi.put(Constants.EVENT_INDEX, "a" + String.valueOf(Utils.getAdmonEventIndex(this.context)));
            if (ConfigManager.getInstance().isAdmonEventsDebug()) {
                baseApi.put(Constants.ADMON_EVENT_DEBUG_PARAM, "true");
            }
            this.eventsDataStructure.put(prepareKey, baseApi);
            this.sendIdMutex.release();
            this.batchManagerPersistence.addEvent(prepareKey, baseApi.toJsonAsString());
            singularLog.debug("batchEvent: created 1st event: " + baseApi.toJsonAsString());
        }
    }

    private void loadFromPersistence() {
        logger.debug("loadFromPersistence");
        for (Map.Entry<String, String> entry : this.batchManagerPersistence.getAllEvents()) {
            try {
                this.eventsDataStructure.put(entry.getKey(), BaseApi.from(entry.getValue()));
            } catch (Throwable th) {
                logger.error(Utils.formatException(th));
            }
        }
        logger.debug("loadFromPersistence: loaded " + this.eventsDataStructure.size() + " entries");
    }

    public void addToBatch(final BaseApi baseApi) {
        final boolean isAggregateAdmonEvents = ConfigManager.getInstance().isAggregateAdmonEvents();
        final boolean isAdmonEventsDebug = ConfigManager.getInstance().isAdmonEventsDebug();
        if (isAggregateAdmonEvents && isAdmonEventsDebug && baseApi.isAdmonEvent()) {
            try {
                this.regularFlowSender.sendApi(BaseApi.from(baseApi.toJsonAsString()));
            } catch (IOException e) {
                logger.error("IOExceptionException", e);
            } catch (Throwable th) {
                logger.error("Throwable", th);
            }
        }
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.BatchManager.3
                @Override // java.lang.Runnable
                public void run() {
                    BatchManager.logger.debug("addToBatch api: " + baseApi.toJsonAsString());
                    if (!isAggregateAdmonEvents || !baseApi.isAdmonEvent()) {
                        BatchManager.logger.debug("addToBatch: no need to batch: batching enabled: " + isAggregateAdmonEvents + " is Admon event: " + baseApi.isAdmonEvent());
                        BatchManager.this.regularFlowSender.sendApi(baseApi);
                        return;
                    }
                    BatchManager.logger.debug("addToBatch: event needs to be batched");
                    try {
                        BatchManager.this.batchEvent(baseApi);
                    } catch (Throwable th2) {
                        BatchManager.logger.debug("addToBatch: exception: " + th2.getMessage());
                        if (isAdmonEventsDebug) {
                            return;
                        }
                        BatchManager.this.regularFlowSender.sendApi(baseApi);
                    }
                }
            });
        } catch (Throwable th2) {
            logger.error(Utils.formatException(th2));
            reportException(th2);
        }
    }

    public void sendEvents() {
        if (ConfigManager.getInstance().isAggregateAdmonEvents()) {
            try {
                Executors.newSingleThreadExecutor().execute(new AnonymousClass4());
            } catch (Throwable th) {
                logger.error(Utils.formatException(th));
                reportException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.singular.sdk.internal.BatchManager$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BatchManager.this.sendMutex.acquire();
                BatchManager.this.sendIdMutex.acquire();
                BatchManager batchManager = BatchManager.this;
                batchManager.sendId = batchManager.batchManagerPersistence.incSendId();
                BatchManager.this.sendIdMutex.release();
                BatchManager.logger.debug("sendEvents: total events to send " + BatchManager.this.eventsDataStructure.size());
                final ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                String[] strArr = (String[]) BatchManager.this.eventsDataStructure.keySet().toArray(new String[0]);
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < strArr.length; i++) {
                    if (new JSONObject(strArr[i]).getLong(BatchManager.SEND_ID) < BatchManager.this.sendId) {
                        linkedList.add(strArr[i]);
                    }
                }
                String[] strArr2 = (String[]) linkedList.toArray(new String[0]);
                final Semaphore semaphore = new Semaphore(0, true);
                for (final String str : strArr2) {
                    final BaseApi baseApi = (BaseApi) BatchManager.this.eventsDataStructure.get(str);
                    BatchManager.logger.debug("sendEvents: sending event with key: " + str + " and body: " + baseApi.toString());
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.BatchManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BatchManager.this.networkSender.sendApi(baseApi)) {
                                BatchManager.logger.debug("sendEvents: sending event with key: " + str + " is successful");
                                newSingleThreadExecutor.execute(new Runnable() { // from class: com.singular.sdk.internal.BatchManager.4.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            BatchManager.this.eventsDataStructure.remove(str);
                                            BatchManager.this.batchManagerPersistence.deleteEvent(str);
                                        } finally {
                                            try {
                                            } finally {
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                            BatchManager.logger.debug("sendEvents: sending event with key: " + str + " has failed");
                            semaphore.release();
                        }
                    });
                }
                semaphore.tryAcquire(strArr2.length, 60L, TimeUnit.SECONDS);
                BatchManager.this.sendMutex.release();
                BatchManager.this.sendIdMutex.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportException(Throwable th) {
        try {
            SingularExceptionReporter.getReporter(this.context, false).reportException(th);
        } catch (RuntimeException unused) {
        }
    }
}
