package com.bluetooth.cursor;

import android.os.Bundle;

/* loaded from: classes.dex */
public class BluetoothHidClientAct extends t {
    @Override // com.bluetooth.cursor.t, com.yl.ui.p, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getIntent().putExtra("clientOnly", true);
        super.onCreate(bundle);
    }
}
