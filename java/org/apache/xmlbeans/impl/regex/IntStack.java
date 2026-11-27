package org.apache.xmlbeans.impl.regex;

import com.auto.exceldeps.log4j.util.Chars;

/* loaded from: classes.dex */
final class IntStack {
    private int[] fData;
    private int fDepth;

    IntStack() {
    }

    private void ensureCapacity(int i2) {
        int[] iArr = this.fData;
        if (iArr == null) {
            this.fData = new int[32];
        } else if (iArr.length <= i2) {
            int[] iArr2 = new int[iArr.length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.fData = iArr2;
        }
    }

    public void clear() {
        this.fDepth = 0;
    }

    public int elementAt(int i2) {
        return this.fData[i2];
    }

    public int peek() {
        return this.fData[this.fDepth - 1];
    }

    public int pop() {
        int[] iArr = this.fData;
        int i2 = this.fDepth - 1;
        this.fDepth = i2;
        return iArr[i2];
    }

    public void print() {
        System.out.print('(');
        System.out.print(this.fDepth);
        System.out.print(") {");
        int i2 = 0;
        while (true) {
            if (i2 >= this.fDepth) {
                break;
            }
            if (i2 == 3) {
                System.out.print(" ...");
                break;
            }
            System.out.print(Chars.SPACE);
            System.out.print(this.fData[i2]);
            if (i2 < this.fDepth - 1) {
                System.out.print(',');
            }
            i2++;
        }
        System.out.print(" }");
        System.out.println();
    }

    public void push(int i2) {
        ensureCapacity(this.fDepth + 1);
        int[] iArr = this.fData;
        int i3 = this.fDepth;
        this.fDepth = i3 + 1;
        iArr[i3] = i2;
    }

    public int size() {
        return this.fDepth;
    }
}
