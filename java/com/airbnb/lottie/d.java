package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;
import com.airbnb.lottie.LottieAnimationView;

/* loaded from: classes.dex */
class d implements Parcelable.Creator<LottieAnimationView.e> {
    d() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LottieAnimationView.e createFromParcel(Parcel parcel) {
        return new LottieAnimationView.e(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LottieAnimationView.e[] newArray(int i2) {
        return new LottieAnimationView.e[i2];
    }
}
