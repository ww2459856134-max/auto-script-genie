package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.l0.c;
import com.google.gson.l0.d;
import com.google.gson.x;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private final a<T> a;
    private final List<DateFormat> b;

    public static abstract class a<T extends Date> {
        protected abstract T a(Date date);
    }

    private Date e(com.google.gson.l0.b bVar) throws IOException {
        String strJ = bVar.J();
        synchronized (this.b) {
            Iterator<DateFormat> it = this.b.iterator();
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
    public T b(com.google.gson.l0.b bVar) throws IOException {
        if (bVar.L() == c.NULL) {
            bVar.H();
            return null;
        }
        return (T) this.a.a(e(bVar));
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.w();
            return;
        }
        DateFormat dateFormat = this.b.get(0);
        synchronized (this.b) {
            str = dateFormat.format(date);
        }
        dVar.N(str);
    }

    public String toString() {
        DateFormat dateFormat = this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
