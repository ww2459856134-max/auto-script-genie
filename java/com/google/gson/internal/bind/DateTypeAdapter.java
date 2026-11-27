package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.internal.a0;
import com.google.gson.internal.j0;
import com.google.gson.l0.c;
import com.google.gson.l0.d;
import com.google.gson.x;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final i0 b = new i0() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.i0
        public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
            if (aVar.d() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };
    private final List<DateFormat> a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (a0.d()) {
            arrayList.add(j0.c(2, 2));
        }
    }

    private Date e(com.google.gson.l0.b bVar) throws IOException {
        String strJ = bVar.J();
        synchronized (this.a) {
            Iterator<DateFormat> it = this.a.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(strJ);
                } catch (ParseException unused) {
                }
            }
            try {
                return com.google.gson.internal.bind.c.a.c(strJ, new ParsePosition(0));
            } catch (ParseException e) {
                throw new x("Failed parsing '" + strJ + "' as Date; at path " + bVar.q(), e);
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(com.google.gson.l0.b bVar) throws IOException {
        if (bVar.L() != c.NULL) {
            return e(bVar);
        }
        bVar.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.w();
            return;
        }
        DateFormat dateFormat = this.a.get(0);
        synchronized (this.a) {
            str = dateFormat.format(date);
        }
        dVar.N(str);
    }
}
