package io.grpc.okhttp;

import io.grpc.ServerCredentials;
import io.grpc.ServerProvider;
import io.grpc.okhttp.OkHttpServerBuilder;
import java.net.InetSocketAddress;
/* loaded from: classes.dex */
public final class OkHttpServerProvider extends ServerProvider {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.ServerProvider
    public boolean isAvailable() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.ServerProvider
    public int priority() {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.ServerProvider
    public OkHttpServerBuilder builderForPort(int i) {
        throw new UnsupportedOperationException("Use Grpc.newServerBuilderForPort() instead");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.ServerProvider
    public ServerProvider.NewServerBuilderResult newServerBuilderForPort(int i, ServerCredentials serverCredentials) {
        OkHttpServerBuilder.HandshakerSocketFactoryResult handshakerSocketFactoryFrom = OkHttpServerBuilder.handshakerSocketFactoryFrom(serverCredentials);
        if (handshakerSocketFactoryFrom.error != null) {
            return ServerProvider.NewServerBuilderResult.error(handshakerSocketFactoryFrom.error);
        }
        return ServerProvider.NewServerBuilderResult.serverBuilder(new OkHttpServerBuilder(new InetSocketAddress(i), handshakerSocketFactoryFrom.factory));
    }
}
