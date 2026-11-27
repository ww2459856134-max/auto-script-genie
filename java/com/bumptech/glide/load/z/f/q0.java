package com.bumptech.glide.load.z.f;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class q0 implements Lock {
    q0() {
    }

    @Override // java.util.concurrent.locks.Lock
    public void lock() {
    }

    @Override // java.util.concurrent.locks.Lock
    public void lockInterruptibly() throws InterruptedException {
    }

    @Override // java.util.concurrent.locks.Lock
    public Condition newCondition() {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock() {
        return true;
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock(long j2, TimeUnit timeUnit) throws InterruptedException {
        return true;
    }

    @Override // java.util.concurrent.locks.Lock
    public void unlock() {
    }
}
