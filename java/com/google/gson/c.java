package com.google.gson;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
enum c extends j {
    c(String str, int i2) {
        super(str, i2, null);
    }

    @Override // com.google.gson.k
    public String a(Field field) {
        return field.getName();
    }
}
