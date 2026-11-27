package i.e.a.l;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public abstract class c {
    public static Object a(Object obj, int i2) throws NegativeArraySizeException {
        if (obj == null) {
            throw new IllegalArgumentException("Null array");
        }
        int length = Array.getLength(obj);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), i2 + length);
        System.arraycopy(obj, 0, objNewInstance, 0, length);
        return objNewInstance;
    }

    public static char[] b(char[] cArr, int i2) {
        if (cArr == null) {
            return new char[i2];
        }
        int length = cArr.length;
        char[] cArr2 = new char[i2 + length];
        System.arraycopy(cArr, 0, cArr2, 0, length);
        return cArr2;
    }

    public static int[] c(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        int length = iArr.length;
        int[] iArr2 = new int[i2 + length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }
}
