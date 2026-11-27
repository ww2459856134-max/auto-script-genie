package com.auto.exceldeps.log4j.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BooleanSupplier;

/* loaded from: classes.dex */
public class LazyBoolean implements BooleanSupplier {
    private volatile boolean initialized;
    private final Lock lock = new ReentrantLock();
    private final BooleanSupplier supplier;
    private volatile boolean value;

    public LazyBoolean(BooleanSupplier booleanSupplier) {
        this.supplier = booleanSupplier;
    }

    @Override // java.util.function.BooleanSupplier
    public boolean getAsBoolean() {
        boolean z = !this.initialized;
        boolean z2 = this.value;
        if (z) {
            this.lock.lock();
            try {
                if (!this.initialized) {
                    boolean asBoolean = this.supplier.getAsBoolean();
                    this.value = asBoolean;
                    this.initialized = true;
                    z2 = asBoolean;
                }
            } finally {
                this.lock.unlock();
            }
        }
        return z2;
    }

    public void reset() {
        this.initialized = false;
    }

    public void setAsBoolean(boolean z) {
        this.lock.lock();
        try {
            this.initialized = false;
            this.value = z;
            this.initialized = true;
        } finally {
            this.lock.unlock();
        }
    }
}
