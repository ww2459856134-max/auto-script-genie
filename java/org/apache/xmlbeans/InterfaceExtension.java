package org.apache.xmlbeans;

/* loaded from: classes.dex */
public interface InterfaceExtension {

    public interface MethodSignature {
        String[] getExceptionTypes();

        String getName();

        String[] getParameterNames();

        String[] getParameterTypes();

        String getReturnType();
    }

    String getInterface();

    MethodSignature[] getMethods();

    String getStaticHandler();
}
