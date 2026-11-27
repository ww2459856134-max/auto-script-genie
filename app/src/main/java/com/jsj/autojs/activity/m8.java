package com.jsj.autojs.activity;

import com.jsj.autojs.activity.A68c0a83b53;
import com.jsj.autojs.model.ScriptModel;
import java.util.Collection;

/* loaded from: classes.dex */
class m8 implements Runnable {
    final /* synthetic */ Collection c;
    final /* synthetic */ A68c0a83b53.b d;

    m8(A68c0a83b53.b bVar, Collection collection) {
        this.d = bVar;
        this.c = collection;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.isEmpty()) {
            A68c0a83b53.this.S();
            return;
        }
        ScriptModel.ContentBean contentBean = (ScriptModel.ContentBean) this.c.iterator().next();
        this.c.remove(contentBean);
        A68c0a83b53.this.r0(contentBean.getId(), this);
    }
}
