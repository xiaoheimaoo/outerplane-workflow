package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;
/* loaded from: classes3.dex */
public class LimboDocumentChange {
    private final DocumentKey key;
    private final Type type;

    /* loaded from: classes3.dex */
    public enum Type {
        ADDED,
        REMOVED
    }

    public LimboDocumentChange(Type type, DocumentKey documentKey) {
        this.type = type;
        this.key = documentKey;
    }

    public Type getType() {
        return this.type;
    }

    public DocumentKey getKey() {
        return this.key;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LimboDocumentChange) {
            LimboDocumentChange limboDocumentChange = (LimboDocumentChange) obj;
            return this.type.equals(limboDocumentChange.getType()) && this.key.equals(limboDocumentChange.getKey());
        }
        return false;
    }

    public int hashCode() {
        return ((2077 + this.type.hashCode()) * 31) + this.key.hashCode();
    }
}
