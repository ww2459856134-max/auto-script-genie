package com.jsj.autojs.activity;

import com.jsj.autojs.activity.Abc651937bc;
import com.jsj.autojs.model.ScriptModel;
import java.util.Collection;

/* loaded from: classes.dex */
class n8 implements Runnable {
    final /* synthetic */ Collection c;
    final /* synthetic */ Abc651937bc.b d;

    n8(Abc651937bc.b bVar, Collection collection) {
        this.d = bVar;
        this.c = collection;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.isEmpty()) {
            Abc651937bc.this.S();
            return;
        }
        ScriptModel.ContentBean contentBean = (ScriptModel.ContentBean) this.c.iterator().next();
        this.c.remove(contentBean);
        Abc651937bc.this.o0(contentBean.getId(), this);
    }
}
