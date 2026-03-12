package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class AFe1nSDK {
    final ExecutorService getCurrencyIso4217Code;
    public Executor AFAdRevenueData = Executors.newSingleThreadExecutor();
    final Timer getMediationNetwork = new Timer(true);
    public final List<AFe1sSDK> getMonetizationNetwork = new CopyOnWriteArrayList();
    final Set<AFe1mSDK> getRevenue = new CopyOnWriteArraySet();
    final Set<AFe1mSDK> areAllFieldsValid = Collections.newSetFromMap(new ConcurrentHashMap());
    final NavigableSet<AFe1lSDK<?>> component2 = new ConcurrentSkipListSet();
    final NavigableSet<AFe1lSDK<?>> component4 = new ConcurrentSkipListSet();
    final List<AFe1lSDK<?>> component1 = new ArrayList();
    final Set<AFe1lSDK<?>> component3 = Collections.newSetFromMap(new ConcurrentHashMap());

    public AFe1nSDK(ExecutorService executorService) {
        this.getCurrencyIso4217Code = executorService;
    }

    /* renamed from: com.appsflyer.internal.AFe1nSDK$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements Runnable {
        private /* synthetic */ AFe1lSDK getRevenue;

        public AnonymousClass3(AFe1lSDK aFe1lSDK) {
            this.getRevenue = aFe1lSDK;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean add;
            synchronized (AFe1nSDK.this.component2) {
                if (AFe1nSDK.this.component3.contains(this.getRevenue)) {
                    AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, new StringBuilder("tried to add already running task: ").append(this.getRevenue).toString());
                    return;
                }
                if (!AFe1nSDK.this.component2.contains(this.getRevenue) && !AFe1nSDK.this.component4.contains(this.getRevenue)) {
                    AFe1nSDK aFe1nSDK = AFe1nSDK.this;
                    AFe1lSDK aFe1lSDK = this.getRevenue;
                    for (AFe1mSDK aFe1mSDK : aFe1lSDK.getRevenue) {
                        if (aFe1nSDK.areAllFieldsValid.contains(aFe1mSDK)) {
                            aFe1lSDK.getMediationNetwork.add(aFe1mSDK);
                        }
                    }
                    if (AFe1nSDK.this.getCurrencyIso4217Code(this.getRevenue)) {
                        add = AFe1nSDK.this.component2.add(this.getRevenue);
                    } else {
                        add = AFe1nSDK.this.component4.add(this.getRevenue);
                        if (add) {
                            AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, new StringBuilder("new task was blocked: ").append(this.getRevenue).toString());
                            this.getRevenue.getMonetizationNetwork();
                        }
                    }
                    if (add) {
                        AFe1nSDK.this.component2.addAll(AFe1nSDK.this.component1);
                        AFe1nSDK.this.component1.clear();
                    } else {
                        AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, new StringBuilder("task not added, it's already in the queue: ").append(this.getRevenue).toString());
                    }
                    if (add) {
                        AFe1nSDK.this.areAllFieldsValid.add(this.getRevenue.getCurrencyIso4217Code);
                        AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, new StringBuilder("new task added: ").append(this.getRevenue).toString());
                        for (AFe1sSDK aFe1sSDK : AFe1nSDK.this.getMonetizationNetwork) {
                        }
                        AFe1nSDK aFe1nSDK2 = AFe1nSDK.this;
                        aFe1nSDK2.getCurrencyIso4217Code.submit(new AnonymousClass4());
                        AFe1nSDK aFe1nSDK3 = AFe1nSDK.this;
                        synchronized (aFe1nSDK3.component2) {
                            for (int size = (aFe1nSDK3.component2.size() + aFe1nSDK3.component4.size()) - 40; size > 0; size--) {
                                boolean z = !aFe1nSDK3.component4.isEmpty();
                                boolean isEmpty = true ^ aFe1nSDK3.component2.isEmpty();
                                if (isEmpty && z) {
                                    if (aFe1nSDK3.component2.first().compareTo(aFe1nSDK3.component4.first()) > 0) {
                                        aFe1nSDK3.getMediationNetwork(aFe1nSDK3.component2);
                                    } else {
                                        aFe1nSDK3.getMediationNetwork(aFe1nSDK3.component4);
                                    }
                                } else if (isEmpty) {
                                    aFe1nSDK3.getMediationNetwork(aFe1nSDK3.component2);
                                } else if (z) {
                                    aFe1nSDK3.getMediationNetwork(aFe1nSDK3.component4);
                                }
                            }
                        }
                        return;
                    }
                    AFLogger.INSTANCE.w(AFg1cSDK.QUEUE, new StringBuilder("QUEUE: tried to add already pending task: ").append(this.getRevenue).toString());
                    return;
                }
                AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, new StringBuilder("tried to add already scheduled task: ").append(this.getRevenue).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.appsflyer.internal.AFe1nSDK$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (AFe1nSDK.this.component2) {
                final AFe1lSDK<?> pollFirst = AFe1nSDK.this.component2.pollFirst();
                if (pollFirst == null) {
                    return;
                }
                AFe1nSDK.this.component3.add(pollFirst);
                long currencyIso4217Code = pollFirst.getCurrencyIso4217Code();
                AFe1oSDK aFe1oSDK = new AFe1oSDK(Thread.currentThread());
                if (currencyIso4217Code > 0) {
                    AFe1nSDK.this.getMediationNetwork.schedule(aFe1oSDK, currencyIso4217Code);
                }
                final AFe1nSDK aFe1nSDK = AFe1nSDK.this;
                aFe1nSDK.AFAdRevenueData.execute(new Runnable() { // from class: com.appsflyer.internal.AFe1nSDK.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        for (AFe1sSDK aFe1sSDK : AFe1nSDK.this.getMonetizationNetwork) {
                        }
                    }
                });
                if (!AFe1nSDK.this.component2.isEmpty()) {
                    AFe1nSDK aFe1nSDK2 = AFe1nSDK.this;
                    aFe1nSDK2.getCurrencyIso4217Code.submit(new AnonymousClass4());
                }
                try {
                    AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, "starting task execution: ".concat(String.valueOf(pollFirst)));
                    final AFe1uSDK call = pollFirst.call();
                    aFe1oSDK.cancel();
                    final AFe1nSDK aFe1nSDK3 = AFe1nSDK.this;
                    aFe1nSDK3.AFAdRevenueData.execute(new Runnable() { // from class: com.appsflyer.internal.AFe1nSDK.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, new StringBuilder("execution finished for ").append(pollFirst).append(", result: ").append(call).toString());
                            AFe1nSDK.this.component3.remove(pollFirst);
                            for (AFe1sSDK aFe1sSDK : AFe1nSDK.this.getMonetizationNetwork) {
                                aFe1sSDK.getMonetizationNetwork(pollFirst, call);
                            }
                            if (call == AFe1uSDK.SUCCESS) {
                                AFe1nSDK.this.getRevenue.add(pollFirst.getCurrencyIso4217Code);
                                AFe1nSDK.this.getMonetizationNetwork();
                            } else if (pollFirst.AFAdRevenueData()) {
                                if (AFe1nSDK.getRevenue(pollFirst)) {
                                    synchronized (AFe1nSDK.this.component2) {
                                        AFe1nSDK.this.component1.add(pollFirst);
                                        for (AFe1sSDK aFe1sSDK2 : AFe1nSDK.this.getMonetizationNetwork) {
                                        }
                                    }
                                }
                            } else {
                                AFe1nSDK.this.getRevenue.add(pollFirst.getCurrencyIso4217Code);
                                AFe1nSDK.this.getMonetizationNetwork();
                            }
                        }
                    });
                } catch (InterruptedIOException | InterruptedException unused) {
                    AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, "task was interrupted: ".concat(String.valueOf(pollFirst)));
                    pollFirst.AFAdRevenueData = AFe1uSDK.TIMEOUT;
                    final AFe1nSDK aFe1nSDK4 = AFe1nSDK.this;
                    final AFe1uSDK aFe1uSDK = AFe1uSDK.TIMEOUT;
                    aFe1nSDK4.AFAdRevenueData.execute(new Runnable() { // from class: com.appsflyer.internal.AFe1nSDK.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, new StringBuilder("execution finished for ").append(pollFirst).append(", result: ").append(aFe1uSDK).toString());
                            AFe1nSDK.this.component3.remove(pollFirst);
                            for (AFe1sSDK aFe1sSDK : AFe1nSDK.this.getMonetizationNetwork) {
                                aFe1sSDK.getMonetizationNetwork(pollFirst, aFe1uSDK);
                            }
                            if (aFe1uSDK == AFe1uSDK.SUCCESS) {
                                AFe1nSDK.this.getRevenue.add(pollFirst.getCurrencyIso4217Code);
                                AFe1nSDK.this.getMonetizationNetwork();
                            } else if (pollFirst.AFAdRevenueData()) {
                                if (AFe1nSDK.getRevenue(pollFirst)) {
                                    synchronized (AFe1nSDK.this.component2) {
                                        AFe1nSDK.this.component1.add(pollFirst);
                                        for (AFe1sSDK aFe1sSDK2 : AFe1nSDK.this.getMonetizationNetwork) {
                                        }
                                    }
                                }
                            } else {
                                AFe1nSDK.this.getRevenue.add(pollFirst.getCurrencyIso4217Code);
                                AFe1nSDK.this.getMonetizationNetwork();
                            }
                        }
                    });
                } catch (Throwable unused2) {
                    aFe1oSDK.cancel();
                    final AFe1nSDK aFe1nSDK5 = AFe1nSDK.this;
                    final AFe1uSDK aFe1uSDK2 = AFe1uSDK.FAILURE;
                    aFe1nSDK5.AFAdRevenueData.execute(new Runnable() { // from class: com.appsflyer.internal.AFe1nSDK.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AFLogger.INSTANCE.d(AFg1cSDK.QUEUE, new StringBuilder("execution finished for ").append(pollFirst).append(", result: ").append(aFe1uSDK2).toString());
                            AFe1nSDK.this.component3.remove(pollFirst);
                            for (AFe1sSDK aFe1sSDK : AFe1nSDK.this.getMonetizationNetwork) {
                                aFe1sSDK.getMonetizationNetwork(pollFirst, aFe1uSDK2);
                            }
                            if (aFe1uSDK2 == AFe1uSDK.SUCCESS) {
                                AFe1nSDK.this.getRevenue.add(pollFirst.getCurrencyIso4217Code);
                                AFe1nSDK.this.getMonetizationNetwork();
                            } else if (pollFirst.AFAdRevenueData()) {
                                if (AFe1nSDK.getRevenue(pollFirst)) {
                                    synchronized (AFe1nSDK.this.component2) {
                                        AFe1nSDK.this.component1.add(pollFirst);
                                        for (AFe1sSDK aFe1sSDK2 : AFe1nSDK.this.getMonetizationNetwork) {
                                        }
                                    }
                                }
                            } else {
                                AFe1nSDK.this.getRevenue.add(pollFirst.getCurrencyIso4217Code);
                                AFe1nSDK.this.getMonetizationNetwork();
                            }
                        }
                    });
                }
            }
        }
    }

    final void getMonetizationNetwork() {
        synchronized (this.component2) {
            Iterator<AFe1lSDK<?>> it = this.component4.iterator();
            boolean z = false;
            while (it.hasNext()) {
                AFe1lSDK<?> next = it.next();
                if (getCurrencyIso4217Code(next)) {
                    it.remove();
                    this.component2.add(next);
                    z = true;
                }
            }
            if (z) {
                this.getCurrencyIso4217Code.submit(new AnonymousClass4());
            }
        }
    }

    final void getMediationNetwork(NavigableSet<AFe1lSDK<?>> navigableSet) {
        AFe1lSDK<?> pollFirst = navigableSet.pollFirst();
        this.getRevenue.add(pollFirst.getCurrencyIso4217Code);
        for (AFe1sSDK aFe1sSDK : this.getMonetizationNetwork) {
            aFe1sSDK.getMediationNetwork(pollFirst);
        }
    }

    final boolean getCurrencyIso4217Code(AFe1lSDK<?> aFe1lSDK) {
        return this.getRevenue.containsAll(aFe1lSDK.getMediationNetwork);
    }

    public static boolean getRevenue(AFe1lSDK<?> aFe1lSDK) {
        return ((aFe1lSDK instanceof AFf1tSDK) && aFe1lSDK.getCurrencyIso4217Code == AFe1mSDK.ARS_VALIDATE) ? false : true;
    }
}
