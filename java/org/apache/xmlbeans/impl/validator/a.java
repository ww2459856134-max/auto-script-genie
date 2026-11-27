package org.apache.xmlbeans.impl.validator;

import java.util.function.Function;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.common.QNameHelper;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return QNameHelper.pretty((QName) obj);
    }
}
