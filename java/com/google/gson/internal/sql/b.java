package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
class b extends DefaultDateTypeAdapter.a<Timestamp> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Timestamp a(Date date) {
        return new Timestamp(date.getTime());
    }
}
