package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.lang.ref.SoftReference;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class CharUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CHARUTIL_INITIAL_BUFSIZE = 32768;
    private static final int MAX_COPY = 64;
    private static final ThreadLocal<SoftReference<CharUtil>> tl_charUtil = ThreadLocal.withInitial(new Supplier() { // from class: org.apache.xmlbeans.impl.store.q
        @Override // java.util.function.Supplier
        public final Object get() {
            return CharUtil.a();
        }
    });
    public int _cchSrc;
    private final int _charBufSize;
    private final CharIterator _charIter = new CharIterator();
    private char[] _currentBuffer;
    private int _currentOffset;
    public int _offSrc;

    public static final class CharIterator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int _cchRoot;
        private int _maxPos;
        private int _minPos;
        private int _offLeaf;
        private int _offRoot;
        private int _pos;
        private char[] _srcLeafChars;
        private String _srcLeafString;
        private Object _srcRoot;

        private char currentChar() {
            int i2 = (this._offLeaf + this._pos) - this._minPos;
            char[] cArr = this._srcLeafChars;
            return cArr == null ? this._srcLeafString.charAt(i2) : cArr[i2];
        }

        public boolean hasNext() {
            return this._pos < this._cchRoot;
        }

        public boolean hasPrev() {
            return this._pos > 0;
        }

        public void init(Object obj, int i2, int i3) {
            init(obj, i2, i3, 0);
        }

        public void movePos(int i2) {
            if (i2 < this._minPos || i2 > this._maxPos) {
                Object obj = this._srcRoot;
                int i3 = this._offRoot;
                int i4 = i3 + i2;
                int i5 = this._cchRoot;
                this._offLeaf = i3;
                while (obj instanceof CharJoin) {
                    CharJoin charJoin = (CharJoin) obj;
                    int i6 = charJoin._cchLeft;
                    if (i4 < i6) {
                        Object obj2 = charJoin._srcLeft;
                        int i7 = charJoin._offLeft;
                        this._offLeaf = i7;
                        i4 += i7;
                        obj = obj2;
                        i5 = i6;
                    } else {
                        Object obj3 = charJoin._srcRight;
                        int i8 = charJoin._offRight;
                        this._offLeaf = i8;
                        i4 -= i6 - i8;
                        i5 -= i6;
                        obj = obj3;
                    }
                }
                int i9 = i2 - (i4 - this._offLeaf);
                this._minPos = i9;
                int i10 = i9 + i5;
                this._maxPos = i10;
                if (i2 < this._cchRoot) {
                    this._maxPos = i10 - 1;
                }
                this._srcLeafChars = null;
                this._srcLeafString = null;
                if (obj instanceof char[]) {
                    this._srcLeafChars = (char[]) obj;
                } else {
                    this._srcLeafString = (String) obj;
                }
            }
            this._pos = i2;
        }

        public char next() {
            char cCurrentChar = currentChar();
            movePos(this._pos + 1);
            return cCurrentChar;
        }

        public char prev() {
            movePos(this._pos - 1);
            return currentChar();
        }

        public void release() {
            this._srcRoot = null;
            this._srcLeafString = null;
            this._srcLeafChars = null;
        }

        public void init(Object obj, int i2, int i3, int i4) {
            release();
            this._srcRoot = obj;
            this._offRoot = i2;
            this._cchRoot = i3;
            this._maxPos = -1;
            this._minPos = -1;
            movePos(i4);
        }
    }

    public static final class CharJoin {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int MAX_DEPTH = 64;
        public final int _cchLeft;
        public final int _depth;
        public final int _offLeft;
        public final int _offRight;
        public final Object _srcLeft;
        public final Object _srcRight;

        public CharJoin(Object obj, int i2, int i3, Object obj2, int i4) {
            int i5;
            this._srcLeft = obj;
            this._offLeft = i2;
            this._cchLeft = i3;
            this._srcRight = obj2;
            this._offRight = i4;
            int i6 = obj instanceof CharJoin ? ((CharJoin) obj)._depth : 0;
            if ((obj2 instanceof CharJoin) && (i5 = ((CharJoin) obj2)._depth) > i6) {
                i6 = i5;
            }
            this._depth = i6 + 1;
        }

        private int cchRight(int i2, int i3) {
            return Math.max(0, (i3 - this._cchLeft) - i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dumpChars(PrintStream printStream, int i2, int i3) {
            printStream.print("( ");
            CharUtil.dumpChars(printStream, this._srcLeft, this._offLeft, this._cchLeft);
            printStream.print(", ");
            CharUtil.dumpChars(printStream, this._srcRight, this._offRight, cchRight(i2, i3));
            printStream.print(" )");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getChars(char[] cArr, int i2, int i3, int i4) {
            int i5 = this._cchLeft;
            if (i3 >= i5) {
                CharUtil.getChars(cArr, i2, this._srcRight, (this._offRight + i3) - i5, i4);
                return;
            }
            int iMin = Math.min(i5 - i3, i4);
            CharUtil.getChars(cArr, i2, this._srcLeft, this._offLeft + i3, iMin);
            if (i4 > iMin) {
                CharUtil.getChars(cArr, i2 + iMin, this._srcRight, this._offRight, i4 - iMin);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getString(StringBuffer stringBuffer, int i2, int i3) {
            int i4 = this._cchLeft;
            if (i2 >= i4) {
                CharUtil.getString(stringBuffer, this._srcRight, (this._offRight + i2) - i4, i3);
                return;
            }
            int iMin = Math.min(i4 - i2, i3);
            CharUtil.getString(stringBuffer, this._srcLeft, this._offLeft + i2, iMin);
            if (i3 > iMin) {
                CharUtil.getString(stringBuffer, this._srcRight, this._offRight, i3 - iMin);
            }
        }

        public int depth() {
            Object obj = this._srcLeft;
            int iDepth = obj instanceof CharJoin ? ((CharJoin) obj).depth() : 0;
            Object obj2 = this._srcRight;
            if (obj2 instanceof CharJoin) {
                iDepth = Math.max(((CharJoin) obj2).depth(), iDepth);
            }
            return iDepth + 1;
        }

        public boolean isValid(int i2, int i3) {
            if (this._depth > 2) {
                return true;
            }
            if (i2 < 0 || i3 < 0 || !CharUtil.isValid(this._srcLeft, this._offLeft, this._cchLeft)) {
                return false;
            }
            return CharUtil.isValid(this._srcRight, this._offRight, cchRight(i2, i3));
        }
    }

    public CharUtil(int i2) {
        this._charBufSize = i2;
    }

    static /* synthetic */ SoftReference a() {
        return new SoftReference(new CharUtil(CHARUTIL_INITIAL_BUFSIZE));
    }

    private char[] allocate(int i2) {
        if (this._currentBuffer == null) {
            this._currentBuffer = new char[Math.max(i2, this._charBufSize)];
            this._currentOffset = 0;
        }
        int i3 = this._currentOffset;
        this._offSrc = i3;
        int iMin = Math.min(this._currentBuffer.length - i3, i2);
        this._cchSrc = iMin;
        char[] cArr = this._currentBuffer;
        int i4 = this._currentOffset + iMin;
        this._currentOffset = i4;
        if (i4 == cArr.length) {
            this._currentBuffer = null;
            this._currentOffset = 0;
        }
        return cArr;
    }

    private boolean canAllocate(int i2) {
        char[] cArr = this._currentBuffer;
        return cArr == null || cArr.length - this._currentOffset >= i2;
    }

    public static void clearThreadLocals() {
        tl_charUtil.remove();
    }

    public static void dump(Object obj, int i2, int i3) {
        dumpChars(System.out, obj, i2, i3);
        System.out.println();
    }

    public static void dumpChars(PrintStream printStream, Object obj, int i2, int i3) {
        int i4;
        int i5;
        printStream.print("off=" + i2 + ", cch=" + i3 + ", ");
        if (obj == null) {
            printStream.print("<null-src>");
            return;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            printStream.print("String");
            if (!(i2 == 0 && i3 == str.length()) && (i2 < 0 || i2 > str.length() || (i5 = i2 + i3) < 0 || i5 > str.length())) {
                printStream.print(" (Error)");
                return;
            } else {
                dumpText(printStream, str.substring(i2, i3 + i2));
                return;
            }
        }
        if (!(obj instanceof char[])) {
            if (!(obj instanceof CharJoin)) {
                printStream.print("Unknown text source");
                return;
            } else {
                printStream.print("CharJoin");
                ((CharJoin) obj).dumpChars(printStream, i2, i3);
                return;
            }
        }
        char[] cArr = (char[]) obj;
        printStream.print("char[]");
        if (!(i2 == 0 && i3 == cArr.length) && (i2 < 0 || i2 > cArr.length || (i4 = i2 + i3) < 0 || i4 > cArr.length)) {
            printStream.print(" (Error)");
        } else {
            dumpText(printStream, new String(cArr, i2, i3));
        }
    }

    private static void dumpText(PrintStream printStream, String str) {
        printStream.print("\"");
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                break;
            }
            char cCharAt = str.charAt(i2);
            if (i2 == 36) {
                printStream.print("...");
                break;
            }
            if (cCharAt == '\t') {
                printStream.print("\\t");
            } else if (cCharAt == '\n') {
                printStream.print("\\n");
            } else if (cCharAt == '\f') {
                printStream.print("\\f");
            } else if (cCharAt == '\r') {
                printStream.print("\\r");
            } else if (cCharAt != '\"') {
                printStream.print(cCharAt);
            } else {
                printStream.print("\\\"");
            }
            i2++;
        }
        printStream.print("\"");
    }

    public static void getChars(char[] cArr, int i2, Object obj, int i3, int i4) {
        if (i4 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            System.arraycopy((char[]) obj, i3, cArr, i2, i4);
        } else if (obj instanceof String) {
            ((String) obj).getChars(i3, i4 + i3, cArr, i2);
        } else {
            ((CharJoin) obj).getChars(cArr, i2, i3, i4);
        }
    }

    public static void getString(StringBuffer stringBuffer, Object obj, int i2, int i3) {
        if (i3 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            stringBuffer.append((char[]) obj, i2, i3);
            return;
        }
        if (!(obj instanceof String)) {
            ((CharJoin) obj).getString(stringBuffer, i2, i3);
            return;
        }
        String str = (String) obj;
        if (i2 == 0 && i3 == str.length()) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append((CharSequence) str, i2, i3 + i2);
        }
    }

    public static CharUtil getThreadLocalCharUtil() {
        ThreadLocal<SoftReference<CharUtil>> threadLocal = tl_charUtil;
        CharUtil charUtil = threadLocal.get().get();
        if (charUtil != null) {
            return charUtil;
        }
        CharUtil charUtil2 = new CharUtil(CHARUTIL_INITIAL_BUFSIZE);
        threadLocal.set(new SoftReference<>(charUtil2));
        return charUtil2;
    }

    public static boolean isValid(Object obj, int i2, int i3) {
        if (i3 >= 0 && i2 >= 0) {
            if (obj == null) {
                return i2 == 0 && i3 == 0;
            }
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                return i2 <= cArr.length && i2 + i3 <= cArr.length;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                return i2 <= str.length() && i2 + i3 <= str.length();
            }
            if (obj instanceof CharJoin) {
                return ((CharJoin) obj).isValid(i2, i3);
            }
        }
        return false;
    }

    public static boolean isWhiteSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    public CharIterator getCharIterator(Object obj, int i2, int i3) {
        this._charIter.init(obj, i2, i3);
        return this._charIter;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object insertChars(int i2, Object obj, int i3, int i4, Object obj2, int i5, int i6) {
        CharJoin charJoin;
        CharJoin charJoin2;
        if (i6 == 0) {
            this._cchSrc = i4;
            this._offSrc = i3;
            return obj;
        }
        if (i4 == 0) {
            this._cchSrc = i6;
            this._offSrc = i5;
            return obj2;
        }
        int i7 = i4 + i6;
        this._cchSrc = i7;
        if (i7 <= 64 && canAllocate(i7)) {
            char[] cArrAllocate = allocate(this._cchSrc);
            getChars(cArrAllocate, this._offSrc, obj, i3, i2);
            getChars(cArrAllocate, this._offSrc + i2, obj2, i5, i6);
            getChars(cArrAllocate, this._offSrc + i2 + i6, obj, i3 + i2, i4 - i2);
            return cArrAllocate;
        }
        this._offSrc = 0;
        if (i2 == 0) {
            charJoin2 = new CharJoin(obj2, i5, i6, obj, i3);
        } else {
            if (i2 != i4) {
                charJoin = new CharJoin(new CharJoin(obj, i3, i2, obj2, i5), 0, i2 + i6, obj, i3 + i2);
                return charJoin._depth <= 64 ? saveChars(charJoin, this._offSrc, this._cchSrc) : charJoin;
            }
            charJoin2 = new CharJoin(obj, i3, i4, obj2, i5);
        }
        charJoin = charJoin2;
        if (charJoin._depth <= 64) {
        }
    }

    public final boolean isWhiteSpace(Object obj, int i2, int i3) {
        boolean z = true;
        if (i3 <= 0) {
            return true;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            while (i3 > 0) {
                int i4 = i2 + 1;
                if (!isWhiteSpace(cArr[i2])) {
                    return false;
                }
                i3--;
                i2 = i4;
            }
            return true;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            while (i3 > 0) {
                int i5 = i2 + 1;
                if (!isWhiteSpace(str.charAt(i2))) {
                    return false;
                }
                i3--;
                i2 = i5;
            }
            return true;
        }
        this._charIter.init(obj, i2, i3);
        while (true) {
            if (!this._charIter.hasNext()) {
                break;
            }
            if (!isWhiteSpace(this._charIter.next())) {
                z = false;
                break;
            }
        }
        this._charIter.release();
        return z;
    }

    public Object removeChars(int i2, int i3, Object obj, int i4, int i5) {
        int i6 = i5 - i3;
        this._cchSrc = i6;
        if (i6 == 0) {
            this._offSrc = 0;
            return null;
        }
        if (i2 == 0) {
            this._offSrc = i4 + i3;
            return obj;
        }
        if (i2 + i3 == i5) {
            this._offSrc = i4;
            return obj;
        }
        if (i6 <= 64 && canAllocate(i6)) {
            char[] cArrAllocate = allocate(i6);
            getChars(cArrAllocate, this._offSrc, obj, i4, i2);
            getChars(cArrAllocate, this._offSrc + i2, obj, i4 + i2 + i3, (i5 - i2) - i3);
            return cArrAllocate;
        }
        CharJoin charJoin = new CharJoin(obj, i4, i2, obj, i4 + i2 + i3);
        if (charJoin._depth > 64) {
            return saveChars(charJoin, 0, this._cchSrc);
        }
        this._offSrc = 0;
        return charJoin;
    }

    public Object saveChars(Object obj, int i2, int i3) {
        return saveChars(obj, i2, i3, null, 0, 0);
    }

    public Object stripLeft(Object obj, int i2, int i3) {
        if (i3 > 0) {
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                while (i3 > 0 && isWhiteSpace(cArr[i2])) {
                    i3--;
                    i2++;
                }
            } else if (obj instanceof String) {
                String str = (String) obj;
                while (i3 > 0 && isWhiteSpace(str.charAt(i2))) {
                    i3--;
                    i2++;
                }
            } else {
                this._charIter.init(obj, i2, i3);
                int i4 = 0;
                while (this._charIter.hasNext() && isWhiteSpace(this._charIter.next())) {
                    i4++;
                }
                this._charIter.release();
                i2 += i4;
            }
        }
        if (i3 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i2;
        this._cchSrc = i3;
        return obj;
    }

    public Object stripRight(Object obj, int i2, int i3) {
        if (i3 > 0) {
            this._charIter.init(obj, i2, i3, i3);
            while (this._charIter.hasPrev() && isWhiteSpace(this._charIter.prev())) {
                i3--;
            }
            this._charIter.release();
        }
        if (i3 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i2;
        this._cchSrc = i3;
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object saveChars(Object obj, int i2, int i3, Object obj2, int i4, int i5) {
        Object obj3;
        Object obj4;
        char[] cArrAllocate = allocate(i3);
        int i6 = this._offSrc;
        int i7 = this._cchSrc;
        getChars(cArrAllocate, i6, obj, i2, i7);
        int i8 = i7 + i5;
        int i9 = 0;
        if (i5 == 0) {
            obj3 = cArrAllocate;
        } else if (obj2 != cArrAllocate || i4 + i5 != i6) {
            if (obj2 instanceof CharJoin) {
                CharJoin charJoin = (CharJoin) obj2;
                if (charJoin._srcRight == cArrAllocate && ((i4 + i5) - charJoin._cchLeft) + charJoin._offRight == i6) {
                    i6 = i4;
                    obj3 = obj2;
                }
            }
            CharJoin charJoin2 = new CharJoin(obj2, i4, i5, cArrAllocate, i6);
            int i10 = charJoin2._depth;
            Object objSaveChars = charJoin2;
            if (i10 > 64) {
                objSaveChars = saveChars(charJoin2, 0, i8);
            }
            i6 = 0;
            obj3 = objSaveChars;
        }
        int i11 = i3 - i7;
        if (i11 > 0) {
            char[] cArrAllocate2 = allocate(i11);
            int i12 = this._offSrc;
            getChars(cArrAllocate2, i12, obj, i2 + (i3 - i11), i11);
            CharJoin charJoin3 = new CharJoin(obj3, i6, i8, cArrAllocate2, i12);
            i8 += i11;
            int i13 = charJoin3._depth;
            Object objSaveChars2 = charJoin3;
            if (i13 > 64) {
                objSaveChars2 = saveChars(charJoin3, 0, i8);
            }
            obj4 = objSaveChars2;
        } else {
            i9 = i6;
            obj4 = obj3;
        }
        this._offSrc = i9;
        this._cchSrc = i8;
        return obj4;
    }

    public CharIterator getCharIterator(Object obj, int i2, int i3, int i4) {
        this._charIter.init(obj, i2, i3, i4);
        return this._charIter;
    }

    public static String getString(Object obj, int i2, int i3) {
        if (i3 == 0) {
            return "";
        }
        if (obj instanceof char[]) {
            return new String((char[]) obj, i2, i3);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return (i2 == 0 && i3 == str.length()) ? str : str.substring(i2, i3 + i2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        ((CharJoin) obj).getString(stringBuffer, i2, i3);
        return stringBuffer.toString();
    }
}
