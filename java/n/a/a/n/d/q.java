package n.a.a.n.d;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/* loaded from: classes.dex */
final class q extends Format {
    private final n.a.a.n.b.u c;
    final /* synthetic */ w d;

    /* synthetic */ q(w wVar, n.a.a.n.b.u uVar, p pVar) {
        this(wVar, uVar);
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (this.d.g) {
            stringBuffer.append(this.c.a);
            return stringBuffer;
        }
        stringBuffer.append(this.c.a.trim());
        return stringBuffer;
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return null;
    }

    private q(w wVar, n.a.a.n.b.u uVar) {
        this.d = wVar;
        this.c = uVar;
    }
}
