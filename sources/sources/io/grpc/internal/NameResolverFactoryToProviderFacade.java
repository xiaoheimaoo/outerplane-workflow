package io.grpc.internal;

import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import java.net.URI;
/* loaded from: classes3.dex */
public class NameResolverFactoryToProviderFacade extends NameResolverProvider {
    private NameResolver.Factory factory;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public NameResolverFactoryToProviderFacade(NameResolver.Factory factory) {
        this.factory = factory;
    }

    @Override // io.grpc.NameResolver.Factory
    public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
        return this.factory.newNameResolver(uri, args);
    }

    @Override // io.grpc.NameResolver.Factory
    public String getDefaultScheme() {
        return this.factory.getDefaultScheme();
    }
}
