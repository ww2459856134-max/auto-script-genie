package com.auto.exceldeps.log4j.util;

/* loaded from: classes.dex */
public class InternalException extends RuntimeException {
    private static final long serialVersionUID = 6366395965071580537L;

    public InternalException(String str) {
        super(str);
    }

    public InternalException(String str, Throwable th) {
        super(str, th);
    }

    public InternalException(Throwable th) {
        super(th);
    }
}
