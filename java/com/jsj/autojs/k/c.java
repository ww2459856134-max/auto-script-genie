package com.jsj.autojs.k;

import android.os.Bundle;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface c extends IInterface {
    int a() throws RemoteException;

    Bundle f(ParcelFileDescriptor parcelFileDescriptor, String str) throws RemoteException;
}
