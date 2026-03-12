package io.grpc.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ClientInterceptor;
import io.grpc.ClientTransportFilter;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.grpc.NameResolverRegistry;
import io.grpc.ProxyDetector;
import io.grpc.internal.ExponentialBackoffPolicy;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class ManagedChannelImplBuilder extends ManagedChannelBuilder<ManagedChannelImplBuilder> {
    private static final long DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES = 1048576;
    private static final long DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES = 16777216;
    private static final String DIRECT_ADDRESS_SCHEME = "directaddress";
    private static final Method GET_CLIENT_INTERCEPTOR_METHOD;
    private boolean authorityCheckerDisabled;
    @Nullable
    String authorityOverride;
    @Nullable
    BinaryLog binlog;
    @Nullable
    final CallCredentials callCredentials;
    private final ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider;
    @Nullable
    final ChannelCredentials channelCredentials;
    InternalChannelz channelz;
    private final ClientTransportFactoryBuilder clientTransportFactoryBuilder;
    CompressorRegistry compressorRegistry;
    DecompressorRegistry decompressorRegistry;
    String defaultLbPolicy;
    @Nullable
    Map<String, ?> defaultServiceConfig;
    @Nullable
    private final SocketAddress directServerAddress;
    ObjectPool<? extends Executor> executorPool;
    boolean fullStreamDecompression;
    long idleTimeoutMillis;
    private final List<ClientInterceptor> interceptors;
    boolean lookUpServiceConfig;
    int maxHedgedAttempts;
    int maxRetryAttempts;
    int maxTraceEvents;
    NameResolverRegistry nameResolverRegistry;
    ObjectPool<? extends Executor> offloadExecutorPool;
    long perRpcBufferLimit;
    @Nullable
    ProxyDetector proxyDetector;
    private boolean recordFinishedRpcs;
    private boolean recordRealTimeMetrics;
    private boolean recordRetryMetrics;
    private boolean recordStartedRpcs;
    long retryBufferSize;
    boolean retryEnabled;
    private boolean statsEnabled;
    final String target;
    private boolean tracingEnabled;
    final List<ClientTransportFilter> transportFilters;
    @Nullable
    String userAgent;
    private static final Logger log = Logger.getLogger(ManagedChannelImplBuilder.class.getName());
    static final long IDLE_MODE_MAX_TIMEOUT_DAYS = 30;
    static final long IDLE_MODE_DEFAULT_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(IDLE_MODE_MAX_TIMEOUT_DAYS);
    static final long IDLE_MODE_MIN_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(1);
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();

    /* loaded from: classes3.dex */
    public interface ChannelBuilderDefaultPortProvider {
        int getDefaultPort();
    }

    /* loaded from: classes3.dex */
    public interface ClientTransportFactoryBuilder {
        ClientTransportFactory buildClientTransportFactory();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelImplBuilder defaultServiceConfig(@Nullable Map map) {
        return defaultServiceConfig2((Map<String, ?>) map);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelImplBuilder intercept(List list) {
        return intercept2((List<ClientInterceptor>) list);
    }

    static {
        Method method;
        try {
            method = Class.forName("io.grpc.census.InternalCensusStatsAccessor").getDeclaredMethod("getClientInterceptor", Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE);
        } catch (ClassNotFoundException e) {
            log.log(Level.FINE, "Unable to apply census stats", (Throwable) e);
            method = null;
            GET_CLIENT_INTERCEPTOR_METHOD = method;
        } catch (NoSuchMethodException e2) {
            log.log(Level.FINE, "Unable to apply census stats", (Throwable) e2);
            method = null;
            GET_CLIENT_INTERCEPTOR_METHOD = method;
        }
        GET_CLIENT_INTERCEPTOR_METHOD = method;
    }

    public static ManagedChannelBuilder<?> forAddress(String str, int i) {
        throw new UnsupportedOperationException("ClientTransportFactoryBuilder is required, use a constructor");
    }

    public static ManagedChannelBuilder<?> forTarget(String str) {
        throw new UnsupportedOperationException("ClientTransportFactoryBuilder is required, use a constructor");
    }

    /* loaded from: classes3.dex */
    public static class UnsupportedClientTransportFactoryBuilder implements ClientTransportFactoryBuilder {
        @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
        public ClientTransportFactory buildClientTransportFactory() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public static final class FixedPortProvider implements ChannelBuilderDefaultPortProvider {
        private final int port;

        public FixedPortProvider(int i) {
            this.port = i;
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider
        public int getDefaultPort() {
            return this.port;
        }
    }

    /* loaded from: classes3.dex */
    private static final class ManagedChannelDefaultPortProvider implements ChannelBuilderDefaultPortProvider {
        @Override // io.grpc.internal.ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider
        public int getDefaultPort() {
            return 443;
        }

        private ManagedChannelDefaultPortProvider() {
        }
    }

    public ManagedChannelImplBuilder(String str, ClientTransportFactoryBuilder clientTransportFactoryBuilder, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider) {
        this(str, null, null, clientTransportFactoryBuilder, channelBuilderDefaultPortProvider);
    }

    public ManagedChannelImplBuilder(String str, @Nullable ChannelCredentials channelCredentials, @Nullable CallCredentials callCredentials, ClientTransportFactoryBuilder clientTransportFactoryBuilder, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider) {
        ObjectPool<? extends Executor> objectPool = DEFAULT_EXECUTOR_POOL;
        this.executorPool = objectPool;
        this.offloadExecutorPool = objectPool;
        this.interceptors = new ArrayList();
        this.nameResolverRegistry = NameResolverRegistry.getDefaultRegistry();
        this.transportFilters = new ArrayList();
        this.defaultLbPolicy = GrpcUtil.DEFAULT_LB_POLICY;
        this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        this.idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
        this.maxRetryAttempts = 5;
        this.maxHedgedAttempts = 5;
        this.retryBufferSize = DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES;
        this.perRpcBufferLimit = DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES;
        this.retryEnabled = true;
        this.channelz = InternalChannelz.instance();
        this.lookUpServiceConfig = true;
        this.statsEnabled = true;
        this.recordStartedRpcs = true;
        this.recordFinishedRpcs = true;
        this.recordRealTimeMetrics = false;
        this.recordRetryMetrics = true;
        this.tracingEnabled = true;
        this.target = (String) Preconditions.checkNotNull(str, TypedValues.AttributesType.S_TARGET);
        this.channelCredentials = channelCredentials;
        this.callCredentials = callCredentials;
        this.clientTransportFactoryBuilder = (ClientTransportFactoryBuilder) Preconditions.checkNotNull(clientTransportFactoryBuilder, "clientTransportFactoryBuilder");
        this.directServerAddress = null;
        if (channelBuilderDefaultPortProvider != null) {
            this.channelBuilderDefaultPortProvider = channelBuilderDefaultPortProvider;
        } else {
            this.channelBuilderDefaultPortProvider = new ManagedChannelDefaultPortProvider();
        }
    }

    static String makeTargetStringForDirectAddress(SocketAddress socketAddress) {
        try {
            return new URI(DIRECT_ADDRESS_SCHEME, "", "/" + socketAddress, null).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public ManagedChannelImplBuilder(SocketAddress socketAddress, String str, ClientTransportFactoryBuilder clientTransportFactoryBuilder, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider) {
        this(socketAddress, str, null, null, clientTransportFactoryBuilder, channelBuilderDefaultPortProvider);
    }

    public ManagedChannelImplBuilder(SocketAddress socketAddress, String str, @Nullable ChannelCredentials channelCredentials, @Nullable CallCredentials callCredentials, ClientTransportFactoryBuilder clientTransportFactoryBuilder, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider) {
        ObjectPool<? extends Executor> objectPool = DEFAULT_EXECUTOR_POOL;
        this.executorPool = objectPool;
        this.offloadExecutorPool = objectPool;
        this.interceptors = new ArrayList();
        this.nameResolverRegistry = NameResolverRegistry.getDefaultRegistry();
        this.transportFilters = new ArrayList();
        this.defaultLbPolicy = GrpcUtil.DEFAULT_LB_POLICY;
        this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        this.idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
        this.maxRetryAttempts = 5;
        this.maxHedgedAttempts = 5;
        this.retryBufferSize = DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES;
        this.perRpcBufferLimit = DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES;
        this.retryEnabled = true;
        this.channelz = InternalChannelz.instance();
        this.lookUpServiceConfig = true;
        this.statsEnabled = true;
        this.recordStartedRpcs = true;
        this.recordFinishedRpcs = true;
        this.recordRealTimeMetrics = false;
        this.recordRetryMetrics = true;
        this.tracingEnabled = true;
        this.target = makeTargetStringForDirectAddress(socketAddress);
        this.channelCredentials = channelCredentials;
        this.callCredentials = callCredentials;
        this.clientTransportFactoryBuilder = (ClientTransportFactoryBuilder) Preconditions.checkNotNull(clientTransportFactoryBuilder, "clientTransportFactoryBuilder");
        this.directServerAddress = socketAddress;
        NameResolverRegistry nameResolverRegistry = new NameResolverRegistry();
        nameResolverRegistry.register(new DirectAddressNameResolverProvider(socketAddress, str));
        this.nameResolverRegistry = nameResolverRegistry;
        if (channelBuilderDefaultPortProvider != null) {
            this.channelBuilderDefaultPortProvider = channelBuilderDefaultPortProvider;
        } else {
            this.channelBuilderDefaultPortProvider = new ManagedChannelDefaultPortProvider();
        }
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder directExecutor() {
        return executor(MoreExecutors.directExecutor());
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder executor(Executor executor) {
        if (executor != null) {
            this.executorPool = new FixedObjectPool(executor);
        } else {
            this.executorPool = DEFAULT_EXECUTOR_POOL;
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder offloadExecutor(Executor executor) {
        if (executor != null) {
            this.offloadExecutorPool = new FixedObjectPool(executor);
        } else {
            this.offloadExecutorPool = DEFAULT_EXECUTOR_POOL;
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    /* renamed from: intercept  reason: avoid collision after fix types in other method */
    public ManagedChannelImplBuilder intercept2(List<ClientInterceptor> list) {
        this.interceptors.addAll(list);
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder intercept(ClientInterceptor... clientInterceptorArr) {
        return intercept2(Arrays.asList(clientInterceptorArr));
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder addTransportFilter(ClientTransportFilter clientTransportFilter) {
        this.transportFilters.add((ClientTransportFilter) Preconditions.checkNotNull(clientTransportFilter, "transport filter"));
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    @Deprecated
    public ManagedChannelImplBuilder nameResolverFactory(NameResolver.Factory factory) {
        SocketAddress socketAddress = this.directServerAddress;
        Preconditions.checkState(socketAddress == null, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", socketAddress);
        if (factory != null) {
            NameResolverRegistry nameResolverRegistry = new NameResolverRegistry();
            if (factory instanceof NameResolverProvider) {
                nameResolverRegistry.register((NameResolverProvider) factory);
            } else {
                nameResolverRegistry.register(new NameResolverFactoryToProviderFacade(factory));
            }
            this.nameResolverRegistry = nameResolverRegistry;
        } else {
            this.nameResolverRegistry = NameResolverRegistry.getDefaultRegistry();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagedChannelImplBuilder nameResolverRegistry(NameResolverRegistry nameResolverRegistry) {
        this.nameResolverRegistry = nameResolverRegistry;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder defaultLoadBalancingPolicy(String str) {
        SocketAddress socketAddress = this.directServerAddress;
        Preconditions.checkState(socketAddress == null, "directServerAddress is set (%s), which forbids the use of load-balancing policy", socketAddress);
        Preconditions.checkArgument(str != null, "policy cannot be null");
        this.defaultLbPolicy = str;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        if (decompressorRegistry != null) {
            this.decompressorRegistry = decompressorRegistry;
        } else {
            this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder compressorRegistry(CompressorRegistry compressorRegistry) {
        if (compressorRegistry != null) {
            this.compressorRegistry = compressorRegistry;
        } else {
            this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder userAgent(@Nullable String str) {
        this.userAgent = str;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder overrideAuthority(String str) {
        this.authorityOverride = checkAuthority(str);
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder idleTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "idle timeout is %s, but must be positive", j);
        if (timeUnit.toDays(j) >= IDLE_MODE_MAX_TIMEOUT_DAYS) {
            this.idleTimeoutMillis = -1L;
        } else {
            this.idleTimeoutMillis = Math.max(timeUnit.toMillis(j), IDLE_MODE_MIN_TIMEOUT_MILLIS);
        }
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder maxRetryAttempts(int i) {
        this.maxRetryAttempts = i;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder maxHedgedAttempts(int i) {
        this.maxHedgedAttempts = i;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder retryBufferSize(long j) {
        Preconditions.checkArgument(j > 0, "retry buffer size must be positive");
        this.retryBufferSize = j;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder perRpcBufferLimit(long j) {
        Preconditions.checkArgument(j > 0, "per RPC buffer limit must be positive");
        this.perRpcBufferLimit = j;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder disableRetry() {
        this.retryEnabled = false;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder enableRetry() {
        this.retryEnabled = true;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder setBinaryLog(BinaryLog binaryLog) {
        this.binlog = binaryLog;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder maxTraceEvents(int i) {
        Preconditions.checkArgument(i >= 0, "maxTraceEvents must be non-negative");
        this.maxTraceEvents = i;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder proxyDetector(@Nullable ProxyDetector proxyDetector) {
        this.proxyDetector = proxyDetector;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    /* renamed from: defaultServiceConfig  reason: avoid collision after fix types in other method */
    public ManagedChannelImplBuilder defaultServiceConfig2(@Nullable Map<String, ?> map) {
        this.defaultServiceConfig = checkMapEntryTypes(map);
        return this;
    }

    @Nullable
    private static Map<String, ?> checkMapEntryTypes(@Nullable Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Preconditions.checkArgument(entry.getKey() instanceof String, "The key of the entry '%s' is not of String type", entry);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                linkedHashMap.put(str, null);
            } else if (value instanceof Map) {
                linkedHashMap.put(str, checkMapEntryTypes((Map) value));
            } else if (value instanceof List) {
                linkedHashMap.put(str, checkListEntryTypes((List) value));
            } else if (value instanceof String) {
                linkedHashMap.put(str, value);
            } else if (value instanceof Double) {
                linkedHashMap.put(str, value);
            } else if (value instanceof Boolean) {
                linkedHashMap.put(str, value);
            } else {
                throw new IllegalArgumentException("The value of the map entry '" + entry + "' is of type '" + value.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static List<?> checkListEntryTypes(List<?> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            if (obj == null) {
                arrayList.add(null);
            } else if (obj instanceof Map) {
                arrayList.add(checkMapEntryTypes((Map) obj));
            } else if (obj instanceof List) {
                arrayList.add(checkListEntryTypes((List) obj));
            } else if (obj instanceof String) {
                arrayList.add(obj);
            } else if (obj instanceof Double) {
                arrayList.add(obj);
            } else if (obj instanceof Boolean) {
                arrayList.add(obj);
            } else {
                throw new IllegalArgumentException("The entry '" + obj + "' is of type '" + obj.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImplBuilder disableServiceConfigLookUp() {
        this.lookUpServiceConfig = false;
        return this;
    }

    public void setStatsEnabled(boolean z) {
        this.statsEnabled = z;
    }

    public void setStatsRecordStartedRpcs(boolean z) {
        this.recordStartedRpcs = z;
    }

    public void setStatsRecordFinishedRpcs(boolean z) {
        this.recordFinishedRpcs = z;
    }

    public void setStatsRecordRealTimeMetrics(boolean z) {
        this.recordRealTimeMetrics = z;
    }

    public void setStatsRecordRetryMetrics(boolean z) {
        this.recordRetryMetrics = z;
    }

    public void setTracingEnabled(boolean z) {
        this.tracingEnabled = z;
    }

    String checkAuthority(String str) {
        return this.authorityCheckerDisabled ? str : GrpcUtil.checkAuthority(str);
    }

    public ManagedChannelImplBuilder disableCheckAuthority() {
        this.authorityCheckerDisabled = true;
        return this;
    }

    public ManagedChannelImplBuilder enableCheckAuthority() {
        this.authorityCheckerDisabled = false;
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannel build() {
        return new ManagedChannelOrphanWrapper(new ManagedChannelImpl(this, this.clientTransportFactoryBuilder.buildClientTransportFactory(), new ExponentialBackoffPolicy.Provider(), SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR), GrpcUtil.STOPWATCH_SUPPLIER, getEffectiveInterceptors(), TimeProvider.SYSTEM_TIME_PROVIDER));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.List<io.grpc.ClientInterceptor> getEffectiveInterceptors() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<io.grpc.ClientInterceptor> r1 = r9.interceptors
            r0.<init>(r1)
            java.util.List r1 = io.grpc.InternalGlobalInterceptors.getClientInterceptors()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L14
            r0.addAll(r1)
            r1 = r2
            goto L15
        L14:
            r1 = r3
        L15:
            r4 = 0
            java.lang.String r5 = "Unable to apply census stats"
            if (r1 != 0) goto L65
            boolean r6 = r9.statsEnabled
            if (r6 == 0) goto L65
            java.lang.reflect.Method r6 = io.grpc.internal.ManagedChannelImplBuilder.GET_CLIENT_INTERCEPTOR_METHOD
            if (r6 == 0) goto L5f
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            boolean r8 = r9.recordStartedRpcs     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            r7[r3] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            boolean r8 = r9.recordFinishedRpcs     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            r7[r2] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            boolean r2 = r9.recordRealTimeMetrics     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            r8 = 2
            r7[r8] = r2     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            boolean r2 = r9.recordRetryMetrics     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            r8 = 3
            r7[r8] = r2     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            java.lang.Object r2 = r6.invoke(r4, r7)     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            io.grpc.ClientInterceptor r2 = (io.grpc.ClientInterceptor) r2     // Catch: java.lang.reflect.InvocationTargetException -> L4e java.lang.IllegalAccessException -> L57
            goto L60
        L4e:
            r2 = move-exception
            java.util.logging.Logger r6 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r5, r2)
            goto L5f
        L57:
            r2 = move-exception
            java.util.logging.Logger r6 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r5, r2)
        L5f:
            r2 = r4
        L60:
            if (r2 == 0) goto L65
            r0.add(r3, r2)
        L65:
            if (r1 != 0) goto Lab
            boolean r1 = r9.tracingEnabled
            if (r1 == 0) goto Lab
            java.lang.String r1 = "io.grpc.census.InternalCensusTracingAccessor"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8c java.lang.NoSuchMethodException -> L95 java.lang.ClassNotFoundException -> L9e
            java.lang.String r2 = "getClientInterceptor"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8c java.lang.NoSuchMethodException -> L95 java.lang.ClassNotFoundException -> L9e
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8c java.lang.NoSuchMethodException -> L95 java.lang.ClassNotFoundException -> L9e
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8c java.lang.NoSuchMethodException -> L95 java.lang.ClassNotFoundException -> L9e
            java.lang.Object r1 = r1.invoke(r4, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8c java.lang.NoSuchMethodException -> L95 java.lang.ClassNotFoundException -> L9e
            io.grpc.ClientInterceptor r1 = (io.grpc.ClientInterceptor) r1     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8c java.lang.NoSuchMethodException -> L95 java.lang.ClassNotFoundException -> L9e
            r4 = r1
            goto La6
        L83:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r2.log(r6, r5, r1)
            goto La6
        L8c:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r2.log(r6, r5, r1)
            goto La6
        L95:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r2.log(r6, r5, r1)
            goto La6
        L9e:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r2.log(r6, r5, r1)
        La6:
            if (r4 == 0) goto Lab
            r0.add(r3, r4)
        Lab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ManagedChannelImplBuilder.getEffectiveInterceptors():java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDefaultPort() {
        return this.channelBuilderDefaultPortProvider.getDefaultPort();
    }

    /* loaded from: classes3.dex */
    private static class DirectAddressNameResolverProvider extends NameResolverProvider {
        final SocketAddress address;
        final String authority;
        final Collection<Class<? extends SocketAddress>> producedSocketAddressTypes;

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            return ManagedChannelImplBuilder.DIRECT_ADDRESS_SCHEME;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.NameResolverProvider
        public boolean isAvailable() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.NameResolverProvider
        public int priority() {
            return 5;
        }

        DirectAddressNameResolverProvider(SocketAddress socketAddress, String str) {
            this.address = socketAddress;
            this.authority = str;
            this.producedSocketAddressTypes = Collections.singleton(socketAddress.getClass());
        }

        @Override // io.grpc.NameResolver.Factory
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            return new NameResolver() { // from class: io.grpc.internal.ManagedChannelImplBuilder.DirectAddressNameResolverProvider.1
                @Override // io.grpc.NameResolver
                public void shutdown() {
                }

                @Override // io.grpc.NameResolver
                public String getServiceAuthority() {
                    return DirectAddressNameResolverProvider.this.authority;
                }

                @Override // io.grpc.NameResolver
                public void start(NameResolver.Listener2 listener2) {
                    listener2.onResult(NameResolver.ResolutionResult.newBuilder().setAddresses(Collections.singletonList(new EquivalentAddressGroup(DirectAddressNameResolverProvider.this.address))).setAttributes(Attributes.EMPTY).build());
                }
            };
        }

        @Override // io.grpc.NameResolverProvider
        public Collection<Class<? extends SocketAddress>> getProducedSocketAddressTypes() {
            return this.producedSocketAddressTypes;
        }
    }

    public ObjectPool<? extends Executor> getOffloadExecutorPool() {
        return this.offloadExecutorPool;
    }
}
