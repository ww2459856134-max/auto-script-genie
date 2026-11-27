package com.jsj.autojs.k;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes.dex */
class a implements c {
    public static c b;
    private IBinder a;

    a(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // com.jsj.autojs.k.c
    public int a() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.jsj.autojs.ocrplugin.IPaddleOcrService");
            if (!this.a.transact(1, parcelObtain, parcelObtain2, 0) && b.h() != null) {
                return b.h().a();
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    @Override // com.jsj.autojs.k.c
    public Bundle f(ParcelFileDescriptor parcelFileDescriptor, String str) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.jsj.autojs.ocrplugin.IPaddleOcrService");
            if (parcelFileDescriptor != null) {
                parcelObtain.writeInt(1);
                parcelFileDescriptor.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeString(str);
            if (!this.a.transact(3, parcelObtain, parcelObtain2, 0) && b.h() != null) {
                return b.h().f(parcelFileDescriptor, str);
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
