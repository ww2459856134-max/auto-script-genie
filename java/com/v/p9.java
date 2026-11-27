package com.v;

import com.adapter.NodeListAdapter;

/* loaded from: classes.dex */
public final /* synthetic */ class p9 implements Runnable {
    public final /* synthetic */ NodeListAdapter c;

    public /* synthetic */ p9(NodeListAdapter nodeListAdapter) {
        this.c = nodeListAdapter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.notifyDataSetChanged();
    }
}
