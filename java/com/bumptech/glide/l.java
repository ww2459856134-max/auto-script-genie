package com.bumptech.glide;

import com.bumptech.glide.load.y.p0;
import java.util.List;

/* loaded from: classes.dex */
public class l extends j {
    public l(Object obj) {
        super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
    }

    public <M> l(M m2, List<p0<M, ?>> list) {
        super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
    }

    public l(Class<?> cls, Class<?> cls2) {
        super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
    }
}
