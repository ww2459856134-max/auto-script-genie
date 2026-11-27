package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Date;

/* loaded from: classes.dex */
class a extends DefaultDateTypeAdapter.a<Date> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Date a(java.util.Date date) {
        return new Date(date.getTime());
    }
}
