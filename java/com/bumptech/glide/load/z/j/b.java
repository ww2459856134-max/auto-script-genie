package com.bumptech.glide.load.z.j;

import java.nio.ByteBuffer;
import java.util.Queue;

/* loaded from: classes.dex */
class b {
    private final Queue<com.bumptech.glide.v.e> a = com.bumptech.glide.b0.p.e(0);

    b() {
    }

    synchronized com.bumptech.glide.v.e a(ByteBuffer byteBuffer) {
        com.bumptech.glide.v.e eVarPoll;
        eVarPoll = this.a.poll();
        if (eVarPoll == null) {
            eVarPoll = new com.bumptech.glide.v.e();
        }
        eVarPoll.p(byteBuffer);
        return eVarPoll;
    }

    synchronized void b(com.bumptech.glide.v.e eVar) {
        eVar.a();
        this.a.offer(eVar);
    }
}
