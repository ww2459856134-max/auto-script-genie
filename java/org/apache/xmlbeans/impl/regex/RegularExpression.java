package org.apache.xmlbeans.impl.regex;

import java.io.Serializable;
import java.text.CharacterIterator;
import java.util.Locale;
import java.util.Stack;
import org.apache.xmlbeans.impl.regex.Op;
import org.apache.xmlbeans.impl.regex.Token;

/* loaded from: classes.dex */
public class RegularExpression implements Serializable {
    static final int CARRIAGE_RETURN = 13;
    static final boolean DEBUG = false;
    static final int EXTENDED_COMMENT = 16;
    static final int IGNORE_CASE = 2;
    static final int LINE_FEED = 10;
    static final int LINE_SEPARATOR = 8232;
    static final int MULTIPLE_LINES = 8;
    static final int PARAGRAPH_SEPARATOR = 8233;
    static final int PROHIBIT_FIXED_STRING_OPTIMIZATION = 256;
    static final int PROHIBIT_HEAD_CHARACTER_OPTIMIZATION = 128;
    static final int SINGLE_LINE = 4;
    static final int SPECIAL_COMMA = 1024;
    static final int UNICODE_WORD_BOUNDARY = 64;
    static final int USE_UNICODE_CATEGORY = 32;
    private static final int WT_IGNORE = 0;
    private static final int WT_LETTER = 1;
    private static final int WT_OTHER = 2;
    static final int XMLSCHEMA_MODE = 512;
    private static final long serialVersionUID = 6242499334195006401L;
    transient Context context;
    transient RangeToken firstChar;
    transient String fixedString;
    transient boolean fixedStringOnly;
    transient int fixedStringOptions;
    transient BMPattern fixedStringTable;
    boolean hasBackReferences;
    transient int minlength;
    int nofparen;
    transient int numberOfClosures;
    transient Op operations;
    int options;
    String regex;
    Token tokentree;

    static final class ClosureContext {
        int[] offsets = new int[4];
        int currentIndex = 0;

        ClosureContext() {
        }

        private int[] expandOffsets() {
            int[] iArr = this.offsets;
            int[] iArr2 = new int[iArr.length << 1];
            System.arraycopy(iArr, 0, iArr2, 0, this.currentIndex);
            return iArr2;
        }

        void addOffset(int i2) {
            if (this.currentIndex == this.offsets.length) {
                this.offsets = expandOffsets();
            }
            int[] iArr = this.offsets;
            int i3 = this.currentIndex;
            this.currentIndex = i3 + 1;
            iArr[i3] = i2;
        }

        boolean contains(int i2) {
            for (int i3 = 0; i3 < this.currentIndex; i3++) {
                if (this.offsets[i3] == i2) {
                    return true;
                }
            }
            return false;
        }

        void reset() {
            this.currentIndex = 0;
        }
    }

    static abstract class ExpressionTarget {
        ExpressionTarget() {
        }

        abstract char charAt(int i2);

        abstract boolean regionMatches(boolean z, int i2, int i3, int i4, int i5);

        abstract boolean regionMatches(boolean z, int i2, int i3, String str, int i4);
    }

    static final class StringTarget extends ExpressionTarget {
        private String target;

        StringTarget(String str) {
            this.target = str;
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        char charAt(int i2) {
            return this.target.charAt(i2);
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean z, int i2, int i3, String str, int i4) {
            if (i3 - i2 < i4) {
                return false;
            }
            return z ? this.target.regionMatches(true, i2, str, 0, i4) : this.target.regionMatches(i2, str, 0, i4);
        }

        void resetTarget(String str) {
            this.target = str;
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean z, int i2, int i3, int i4, int i5) {
            if (i3 - i2 < i5) {
                return false;
            }
            if (z) {
                String str = this.target;
                return str.regionMatches(true, i2, str, i4, i5);
            }
            String str2 = this.target;
            return str2.regionMatches(i2, str2, i4, i5);
        }
    }

    public RegularExpression(String str) throws ParseException {
        this(str, null);
    }

    private synchronized void compile(Token token) {
        if (this.operations != null) {
            return;
        }
        this.numberOfClosures = 0;
        this.operations = compile(token, null, false);
    }

    private static final int getPreviousWordType(ExpressionTarget expressionTarget, int i2, int i3, int i4, int i5) {
        int i6 = i4 - 1;
        int wordType = getWordType(expressionTarget, i2, i3, i6, i5);
        while (wordType == 0) {
            i6--;
            wordType = getWordType(expressionTarget, i2, i3, i6, i5);
        }
        return wordType;
    }

    private static final int getWordType(ExpressionTarget expressionTarget, int i2, int i3, int i4, int i5) {
        if (i4 < i2 || i4 >= i3) {
            return 2;
        }
        return getWordType0(expressionTarget.charAt(i4), i5);
    }

    private static int getWordType0(char c, int i2) {
        if (!isSet(i2, 64)) {
            return isSet(i2, 32) ? Token.getRange("IsWord", true).match(c) ? 1 : 2 : isWordChar(c) ? 1 : 2;
        }
        int type = Character.getType(c);
        if (type == 15) {
            switch (c) {
            }
        }
        if (type != 16) {
            switch (type) {
            }
        }
        return 0;
    }

    private static boolean isEOLChar(int i2) {
        return i2 == 10 || i2 == 13 || i2 == LINE_SEPARATOR || i2 == PARAGRAPH_SEPARATOR;
    }

    private static boolean isSet(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    private static boolean isWordChar(int i2) {
        if (i2 == 95) {
            return true;
        }
        if (i2 < 48 || i2 > 122) {
            return false;
        }
        if (i2 <= 57) {
            return true;
        }
        if (i2 < 65) {
            return false;
        }
        return i2 <= 90 || i2 >= 97;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0251, code lost:
    
        throw new java.lang.RuntimeException("Internal Error: Reference number must be more than zero: " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02f5, code lost:
    
        if (isEOLChar(r0) != false) goto L171;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:189:0x033a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:190:0x033d. Please report as an issue. */
    /* JADX WARN: Path cross not found for [B:12:0x0036, B:141:0x02a9], limit reached: 249 */
    /* JADX WARN: Path cross not found for [B:13:0x0038, B:131:0x0285], limit reached: 249 */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0356 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0322 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x019a -> B:183:0x0322). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int match(Context context, Op op, int i2, int i3, int i4) {
        boolean z;
        int i5;
        int i6;
        Op op2;
        Op opElementAt;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Op op3;
        int i12;
        Op child;
        Op child2;
        ExpressionTarget expressionTarget = context.target;
        Stack stack = new Stack();
        IntStack intStack = new IntStack();
        boolean zIsSet = isSet(i4, 2);
        int i13 = 0;
        Op child3 = op;
        int iPop = i2;
        int iPop2 = i3;
        int iPop3 = i4;
        boolean z2 = false;
        while (true) {
            if (child3 == null || iPop > (i7 = context.limit) || iPop < context.start) {
                z = true;
                i5 = 15;
                int i14 = iPop3;
                i6 = (child3 != null || (isSet(i14, 512) && iPop != context.limit)) ? -1 : iPop;
                iPop3 = i14;
            } else {
                int i15 = child3.type;
                if (i15 == 0) {
                    z = true;
                    i5 = 15;
                    int i16 = iPop3;
                    int i17 = iPop2 > 0 ? iPop : iPop - 1;
                    if (i17 >= i7 || i17 < 0) {
                        i8 = i16;
                    } else {
                        i8 = i16;
                        if (!isSet(i8, 4)) {
                            int iCharAt = expressionTarget.charAt(i17);
                            if (REUtil.isHighSurrogate(iCharAt) && (i9 = i17 + iPop2) >= 0 && i9 < context.limit) {
                                iCharAt = REUtil.composeFromSurrogates(iCharAt, expressionTarget.charAt(i9));
                                i17 = i9;
                            }
                        } else if (REUtil.isHighSurrogate(expressionTarget.charAt(i17)) && (i10 = i17 + iPop2) >= 0 && i10 < context.limit) {
                            i17 = i10;
                        }
                        if (iPop2 > 0) {
                            i17++;
                        }
                        child3 = child3.next;
                        iPop = i17;
                        iPop3 = i8;
                        i6 = -1;
                        while (z2) {
                        }
                        i13 = 0;
                    }
                    iPop3 = i8;
                    i6 = -1;
                } else if (i15 != 1) {
                    if (i15 != 15) {
                        if (i15 != 16) {
                            switch (i15) {
                                case 3:
                                case 4:
                                    i5 = 15;
                                    i11 = iPop3;
                                    z = true;
                                    int i18 = iPop2 > 0 ? iPop : iPop - 1;
                                    if (i18 < i7 && i18 >= 0) {
                                        int iCharAt2 = expressionTarget.charAt(iPop);
                                        if (REUtil.isHighSurrogate(iCharAt2) && (i12 = i18 + iPop2) < context.limit && i12 >= 0) {
                                            iCharAt2 = REUtil.composeFromSurrogates(iCharAt2, expressionTarget.charAt(i12));
                                            i18 = i12;
                                        }
                                        if (child3.getToken().match(iCharAt2)) {
                                            if (iPop2 > 0) {
                                                i18++;
                                            }
                                            iPop3 = i11;
                                            child3 = child3.next;
                                            iPop = i18;
                                            i6 = -1;
                                            break;
                                        }
                                    }
                                    iPop3 = i11;
                                    i6 = -1;
                                    break;
                                case 5:
                                    i5 = 15;
                                    i11 = iPop3;
                                    z = true;
                                    if (matchAnchor(expressionTarget, child3, context, iPop, iPop3)) {
                                        op3 = child3.next;
                                        break;
                                    }
                                    iPop3 = i11;
                                    i6 = -1;
                                    break;
                                case 6:
                                    String string = child3.getString();
                                    int length = string.length();
                                    if (iPop2 > 0) {
                                        z = true;
                                        i5 = 15;
                                        i11 = iPop3;
                                        if (expressionTarget.regionMatches(zIsSet, iPop, context.limit, string, length)) {
                                            iPop += length;
                                            op3 = child3.next;
                                            break;
                                        }
                                        iPop3 = i11;
                                        i6 = -1;
                                        break;
                                    } else {
                                        i5 = 15;
                                        i11 = iPop3;
                                        z = true;
                                        int i19 = iPop - length;
                                        if (expressionTarget.regionMatches(zIsSet, i19, context.limit, string, length)) {
                                            iPop = i19;
                                            op3 = child3.next;
                                        }
                                        iPop3 = i11;
                                        i6 = -1;
                                    }
                                case 7:
                                    int data = child3.getData();
                                    if (!context.closureContexts[data].contains(iPop)) {
                                        context.closureContexts[data].addOffset(iPop);
                                        stack.push(child3);
                                        intStack.push(iPop);
                                        child = child3.getChild();
                                        child3 = child;
                                        i5 = 15;
                                        i6 = -1;
                                        break;
                                    }
                                    i5 = 15;
                                    i6 = -1;
                                    z2 = true;
                                case 8:
                                case 10:
                                    stack.push(child3);
                                    intStack.push(iPop);
                                    child = child3.next;
                                    child3 = child;
                                    i5 = 15;
                                    i6 = -1;
                                    break;
                                case 9:
                                    stack.push(child3);
                                    intStack.push(iPop);
                                    child = child3.getChild();
                                    child3 = child;
                                    i5 = 15;
                                    i6 = -1;
                                    break;
                                case 11:
                                    if (child3.size() != 0) {
                                        stack.push(child3);
                                        intStack.push(i13);
                                        intStack.push(iPop);
                                        child = child3.elementAt(i13);
                                        child3 = child;
                                        i5 = 15;
                                        i6 = -1;
                                        break;
                                    }
                                    i5 = 15;
                                    i6 = -1;
                                    z2 = true;
                                default:
                                    switch (i15) {
                                        case 20:
                                        case 21:
                                        case 22:
                                        case 23:
                                            stack.push(child3);
                                            intStack.push(iPop2);
                                            intStack.push(iPop);
                                            int i20 = child3.type;
                                            int i21 = (i20 == 20 || i20 == 21) ? 1 : -1;
                                            child2 = child3.getChild();
                                            iPop2 = i21;
                                            child3 = child2;
                                            i5 = 15;
                                            i6 = -1;
                                            break;
                                        case 24:
                                            stack.push(child3);
                                            intStack.push(iPop);
                                            child = child3.getChild();
                                            child3 = child;
                                            i5 = 15;
                                            i6 = -1;
                                            break;
                                        case 25:
                                            int data2 = (child3.getData() | iPop3) & (~child3.getData2());
                                            stack.push(child3);
                                            intStack.push(iPop3);
                                            intStack.push(iPop);
                                            child2 = child3.getChild();
                                            iPop3 = data2;
                                            child3 = child2;
                                            i5 = 15;
                                            i6 = -1;
                                            break;
                                        case 26:
                                            Op.ConditionOp conditionOp = (Op.ConditionOp) child3;
                                            int i22 = conditionOp.refNumber;
                                            if (i22 <= 0) {
                                                stack.push(child3);
                                                intStack.push(iPop);
                                                child = conditionOp.condition;
                                            } else {
                                                if (i22 >= this.nofparen) {
                                                    throw new RuntimeException("Internal Error: Reference number must be more than zero: " + conditionOp.refNumber);
                                                }
                                                Match match = context.match;
                                                if (match == null || match.getBeginning(i22) < 0 || context.match.getEnd(conditionOp.refNumber) < 0) {
                                                    Op op4 = conditionOp.no;
                                                    child = op4 != null ? op4 : conditionOp.next;
                                                } else {
                                                    child = conditionOp.yes;
                                                }
                                            }
                                            child3 = child;
                                            i5 = 15;
                                            i6 = -1;
                                            break;
                                        default:
                                            throw new RuntimeException("Unknown operation type: " + child3.type);
                                    }
                            }
                        } else {
                            i5 = 15;
                            i11 = iPop3;
                            z = true;
                            int data3 = child3.getData();
                            if (data3 > 0 && data3 < this.nofparen) {
                                Match match2 = context.match;
                                if (match2 != null) {
                                    if (match2.getBeginning(data3) >= 0 && context.match.getEnd(data3) >= 0) {
                                        int beginning = context.match.getBeginning(data3);
                                        int end = context.match.getEnd(data3) - beginning;
                                        if (iPop2 <= 0) {
                                            int i23 = iPop - end;
                                            if (expressionTarget.regionMatches(zIsSet, i23, context.limit, beginning, end)) {
                                                iPop = i23;
                                                child3 = child3.next;
                                            }
                                        } else if (expressionTarget.regionMatches(zIsSet, iPop, context.limit, beginning, end)) {
                                            iPop += end;
                                            child3 = child3.next;
                                        }
                                    }
                                    iPop3 = i11;
                                    i6 = -1;
                                }
                                iPop3 = i11;
                                i6 = -1;
                            }
                        }
                        while (z2) {
                            if (stack.isEmpty()) {
                                return i6;
                            }
                            child3 = (Op) stack.pop();
                            iPop = intStack.pop();
                            int i24 = child3.type;
                            if (i24 != i5) {
                                switch (i24) {
                                    case 7:
                                    case 9:
                                        if (i6 >= 0) {
                                            break;
                                        } else {
                                            child3 = child3.next;
                                            z2 = false;
                                            break;
                                        }
                                    case 8:
                                    case 10:
                                        if (i6 >= 0) {
                                            break;
                                        } else {
                                            child3 = child3.getChild();
                                            z2 = false;
                                            break;
                                        }
                                    case 11:
                                        int iPop4 = intStack.pop();
                                        if (i6 < 0) {
                                            int i25 = iPop4 + 1;
                                            if (i25 >= child3.size()) {
                                                i6 = -1;
                                                break;
                                            } else {
                                                stack.push(child3);
                                                intStack.push(i25);
                                                intStack.push(iPop);
                                                opElementAt = child3.elementAt(i25);
                                                child3 = opElementAt;
                                                z2 = false;
                                                break;
                                            }
                                        } else {
                                            continue;
                                        }
                                    default:
                                        switch (i24) {
                                            case 20:
                                            case 22:
                                                iPop2 = intStack.pop();
                                                if (i6 >= 0) {
                                                    op2 = child3.next;
                                                    child3 = op2;
                                                    z2 = false;
                                                }
                                                i6 = -1;
                                                break;
                                            case 21:
                                            case 23:
                                                iPop2 = intStack.pop();
                                                if (i6 < 0) {
                                                    op2 = child3.next;
                                                    child3 = op2;
                                                    z2 = false;
                                                }
                                                i6 = -1;
                                                break;
                                            case 24:
                                                if (i6 >= 0) {
                                                    break;
                                                } else {
                                                    child3 = child3.next;
                                                    iPop = i6;
                                                    z2 = false;
                                                    break;
                                                }
                                            case 25:
                                                iPop3 = intStack.pop();
                                                if (i6 >= 0) {
                                                }
                                                break;
                                            case 26:
                                                Op.ConditionOp conditionOp2 = (Op.ConditionOp) child3;
                                                if (i6 >= 0) {
                                                    opElementAt = conditionOp2.yes;
                                                } else {
                                                    opElementAt = conditionOp2.no;
                                                    if (opElementAt == null) {
                                                        opElementAt = conditionOp2.next;
                                                    }
                                                }
                                                child3 = opElementAt;
                                                z2 = false;
                                                break;
                                        }
                                }
                                while (z2) {
                                }
                            } else {
                                int data4 = child3.getData();
                                int iPop5 = intStack.pop();
                                Match match3 = context.match;
                                if (match3 != null && i6 < 0) {
                                    if (data4 > 0) {
                                        match3.setBeginning(data4, iPop5);
                                    } else {
                                        match3.setEnd(-data4, iPop5);
                                    }
                                }
                            }
                        }
                        i13 = 0;
                    } else {
                        i5 = 15;
                        i11 = iPop3;
                        int data5 = child3.getData();
                        Match match4 = context.match;
                        if (match4 != null) {
                            if (data5 > 0) {
                                intStack.push(match4.getBeginning(data5));
                                context.match.setBeginning(data5, iPop);
                            } else {
                                int i26 = -data5;
                                intStack.push(match4.getEnd(i26));
                                context.match.setEnd(i26, iPop);
                            }
                            stack.push(child3);
                            intStack.push(iPop);
                        }
                        op3 = child3.next;
                    }
                    iPop3 = i11;
                    child3 = op3;
                    i6 = -1;
                    while (z2) {
                    }
                    i13 = 0;
                } else {
                    z = true;
                    i5 = 15;
                    i11 = iPop3;
                    int i27 = iPop2 > 0 ? iPop : iPop - 1;
                    if (i27 < i7 && i27 >= 0 && matchChar(child3.getData(), expressionTarget.charAt(i27), zIsSet)) {
                        iPop += iPop2;
                        op3 = child3.next;
                        iPop3 = i11;
                        child3 = op3;
                        i6 = -1;
                        while (z2) {
                        }
                        i13 = 0;
                    }
                    iPop3 = i11;
                    i6 = -1;
                }
            }
            z2 = z;
            while (z2) {
            }
            i13 = 0;
        }
    }

    private boolean matchChar(int i2, int i3, boolean z) {
        return z ? matchIgnoreCase(i2, i3) : i2 == i3;
    }

    private static boolean matchIgnoreCase(int i2, int i3) {
        if (i2 == i3) {
            return true;
        }
        if (i2 > 65535 || i3 > 65535) {
            return false;
        }
        char upperCase = Character.toUpperCase((char) i2);
        char upperCase2 = Character.toUpperCase((char) i3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RegularExpression)) {
            return false;
        }
        RegularExpression regularExpression = (RegularExpression) obj;
        return this.regex.equals(regularExpression.regex) && this.options == regularExpression.options;
    }

    public int getNumberOfGroups() {
        return this.nofparen;
    }

    public String getOptions() {
        return REUtil.createOptionString(this.options);
    }

    public String getPattern() {
        return this.regex;
    }

    public int hashCode() {
        return (this.regex + "/" + getOptions()).hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    boolean matchAnchor(ExpressionTarget expressionTarget, Op op, Context context, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int wordType;
        int wordType2;
        int data = op.getData();
        if (data != 36) {
            if (data != 60) {
                if (data != 62) {
                    if (data == 90) {
                        int i8 = context.limit;
                        if (i2 != i8 && (((i7 = i2 + 1) != i8 || !isEOLChar(expressionTarget.charAt(i2))) && (i2 + 2 != context.limit || expressionTarget.charAt(i2) != '\r' || expressionTarget.charAt(i7) != '\n'))) {
                            return false;
                        }
                    } else if (data != 94) {
                        if (data != 98) {
                            if (data != 122) {
                                switch (data) {
                                    case 64:
                                        int i9 = context.start;
                                        if (i2 != i9 && (i2 <= i9 || !isEOLChar(expressionTarget.charAt(i2 - 1)))) {
                                            return false;
                                        }
                                        break;
                                    case 65:
                                        if (i2 != context.start) {
                                            return false;
                                        }
                                        break;
                                    case 66:
                                        if (!(context.length == 0 || (wordType2 = getWordType(expressionTarget, context.start, context.limit, i2, i3)) == 0 || wordType2 == getPreviousWordType(expressionTarget, context.start, context.limit, i2, i3))) {
                                            return false;
                                        }
                                        break;
                                }
                            } else if (i2 != context.limit) {
                                return false;
                            }
                        } else if (context.length == 0 || (wordType = getWordType(expressionTarget, context.start, context.limit, i2, i3)) == 0 || wordType == getPreviousWordType(expressionTarget, context.start, context.limit, i2, i3)) {
                            return false;
                        }
                    } else if (isSet(i3, 8)) {
                        int i10 = context.start;
                        if (i2 != i10 && (i2 <= i10 || i2 >= context.limit || !isEOLChar(expressionTarget.charAt(i2 - 1)))) {
                            return false;
                        }
                    } else if (i2 != context.start) {
                        return false;
                    }
                } else if (context.length == 0 || i2 == (i6 = context.start) || getWordType(expressionTarget, i6, context.limit, i2, i3) != 2 || getPreviousWordType(expressionTarget, context.start, context.limit, i2, i3) != 1) {
                    return false;
                }
            } else if (context.length == 0 || i2 == (i5 = context.limit) || getWordType(expressionTarget, context.start, i5, i2, i3) != 1 || getPreviousWordType(expressionTarget, context.start, context.limit, i2, i3) != 2) {
                return false;
            }
        } else if (isSet(i3, 8)) {
            int i11 = context.limit;
            if (i2 != i11 && (i2 >= i11 || !isEOLChar(expressionTarget.charAt(i2)))) {
                return false;
            }
        } else {
            int i12 = context.limit;
            if (i2 != i12 && (((i4 = i2 + 1) != i12 || !isEOLChar(expressionTarget.charAt(i2))) && (i2 + 2 != context.limit || expressionTarget.charAt(i2) != '\r' || expressionTarget.charAt(i4) != '\n'))) {
                return false;
            }
        }
        return true;
    }

    public boolean matches(char[] cArr) {
        return matches(cArr, 0, cArr.length, (Match) null);
    }

    void prepare() {
        int i2;
        compile(this.tokentree);
        this.minlength = this.tokentree.getMinLength();
        this.firstChar = null;
        if (!isSet(this.options, 128) && !isSet(this.options, 512)) {
            RangeToken rangeTokenCreateRange = Token.createRange();
            if (this.tokentree.analyzeFirstCharacter(rangeTokenCreateRange, this.options) == 1) {
                rangeTokenCreateRange.compactRanges();
                this.firstChar = rangeTokenCreateRange;
            }
        }
        Op op = this.operations;
        if (op != null && (((i2 = op.type) == 6 || i2 == 1) && op.next == null)) {
            this.fixedStringOnly = true;
            if (i2 == 6) {
                this.fixedString = op.getString();
            } else if (op.getData() >= 65536) {
                this.fixedString = REUtil.decomposeToSurrogates(this.operations.getData());
            } else {
                this.fixedString = new String(new char[]{(char) this.operations.getData()});
            }
            int i3 = this.options;
            this.fixedStringOptions = i3;
            this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(i3, 2));
            return;
        }
        if (isSet(this.options, 256) || isSet(this.options, 512)) {
            return;
        }
        Token.FixedStringContainer fixedStringContainer = new Token.FixedStringContainer();
        this.tokentree.findFixedString(fixedStringContainer, this.options);
        Token token = fixedStringContainer.token;
        String string = token == null ? null : token.getString();
        this.fixedString = string;
        this.fixedStringOptions = fixedStringContainer.options;
        if (string != null && string.length() < 2) {
            this.fixedString = null;
        }
        String str = this.fixedString;
        if (str != null) {
            this.fixedStringTable = new BMPattern(str, 256, isSet(this.fixedStringOptions, 2));
        }
    }

    public void setPattern(String str) throws ParseException {
        setPattern(str, Locale.getDefault());
    }

    public String toString() {
        return this.tokentree.toString(this.options);
    }

    static final class CharArrayTarget extends ExpressionTarget {
        char[] target;

        CharArrayTarget(char[] cArr) {
            this.target = cArr;
        }

        private boolean regionMatchesIgnoreCase(int i2, int i3, String str, int i4) {
            char upperCase;
            char upperCase2;
            int i5 = 0;
            while (true) {
                int i6 = i4 - 1;
                if (i4 <= 0) {
                    return true;
                }
                int i7 = i2 + 1;
                char c = this.target[i2];
                int i8 = i5 + 1;
                char cCharAt = str.charAt(i5);
                if (c != cCharAt && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(cCharAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
                i5 = i8;
                i4 = i6;
                i2 = i7;
            }
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        char charAt(int i2) {
            return this.target[i2];
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean z, int i2, int i3, String str, int i4) {
            if (i2 < 0 || i3 - i2 < i4) {
                return false;
            }
            return z ? regionMatchesIgnoreCase(i2, i3, str, i4) : regionMatches(i2, i3, str, i4);
        }

        void resetTarget(char[] cArr) {
            this.target = cArr;
        }

        private boolean regionMatches(int i2, int i3, String str, int i4) {
            int i5 = 0;
            while (true) {
                int i6 = i4 - 1;
                if (i4 <= 0) {
                    return true;
                }
                int i7 = i2 + 1;
                int i8 = i5 + 1;
                if (this.target[i2] != str.charAt(i5)) {
                    return false;
                }
                i5 = i8;
                i4 = i6;
                i2 = i7;
            }
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean z, int i2, int i3, int i4, int i5) {
            if (i2 < 0 || i3 - i2 < i5) {
                return false;
            }
            if (z) {
                return regionMatchesIgnoreCase(i2, i3, i4, i5);
            }
            return regionMatches(i2, i3, i4, i5);
        }

        private boolean regionMatches(int i2, int i3, int i4, int i5) {
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return true;
                }
                char[] cArr = this.target;
                int i7 = i2 + 1;
                int i8 = i4 + 1;
                if (cArr[i2] != cArr[i4]) {
                    return false;
                }
                i5 = i6;
                i2 = i7;
                i4 = i8;
            }
        }

        private boolean regionMatchesIgnoreCase(int i2, int i3, int i4, int i5) {
            char upperCase;
            char upperCase2;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return true;
                }
                char[] cArr = this.target;
                int i7 = i2 + 1;
                char c = cArr[i2];
                int i8 = i4 + 1;
                char c2 = cArr[i4];
                if (c != c2 && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(c2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
                i5 = i6;
                i2 = i7;
                i4 = i8;
            }
        }
    }

    static final class CharacterIteratorTarget extends ExpressionTarget {
        CharacterIterator target;

        CharacterIteratorTarget(CharacterIterator characterIterator) {
            this.target = characterIterator;
        }

        private boolean regionMatchesIgnoreCase(int i2, int i3, String str, int i4) {
            char upperCase;
            char upperCase2;
            int i5 = 0;
            while (true) {
                int i6 = i4 - 1;
                if (i4 <= 0) {
                    return true;
                }
                int i7 = i2 + 1;
                char index = this.target.setIndex(i2);
                int i8 = i5 + 1;
                char cCharAt = str.charAt(i5);
                if (index != cCharAt && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(cCharAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
                i5 = i8;
                i4 = i6;
                i2 = i7;
            }
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        char charAt(int i2) {
            return this.target.setIndex(i2);
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean z, int i2, int i3, String str, int i4) {
            if (i2 < 0 || i3 - i2 < i4) {
                return false;
            }
            return z ? regionMatchesIgnoreCase(i2, i3, str, i4) : regionMatches(i2, i3, str, i4);
        }

        void resetTarget(CharacterIterator characterIterator) {
            this.target = characterIterator;
        }

        private boolean regionMatches(int i2, int i3, String str, int i4) {
            int i5 = 0;
            while (true) {
                int i6 = i4 - 1;
                if (i4 <= 0) {
                    return true;
                }
                int i7 = i2 + 1;
                int i8 = i5 + 1;
                if (this.target.setIndex(i2) != str.charAt(i5)) {
                    return false;
                }
                i5 = i8;
                i4 = i6;
                i2 = i7;
            }
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean z, int i2, int i3, int i4, int i5) {
            if (i2 < 0 || i3 - i2 < i5) {
                return false;
            }
            if (z) {
                return regionMatchesIgnoreCase(i2, i3, i4, i5);
            }
            return regionMatches(i2, i3, i4, i5);
        }

        private boolean regionMatches(int i2, int i3, int i4, int i5) {
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return true;
                }
                int i7 = i2 + 1;
                int i8 = i4 + 1;
                if (this.target.setIndex(i2) != this.target.setIndex(i4)) {
                    return false;
                }
                i5 = i6;
                i2 = i7;
                i4 = i8;
            }
        }

        private boolean regionMatchesIgnoreCase(int i2, int i3, int i4, int i5) {
            char upperCase;
            char upperCase2;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return true;
                }
                int i7 = i2 + 1;
                char index = this.target.setIndex(i2);
                int i8 = i4 + 1;
                char index2 = this.target.setIndex(i4);
                if (index != index2 && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(index2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
                i5 = i6;
                i2 = i7;
                i4 = i8;
            }
        }
    }

    public RegularExpression(String str, String str2) throws ParseException {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(str, str2);
    }

    public boolean matches(char[] cArr, int i2, int i3) {
        return matches(cArr, i2, i3, (Match) null);
    }

    public void setPattern(String str, Locale locale) throws ParseException {
        setPattern(str, this.options, locale);
    }

    private void setPattern(String str, int i2, Locale locale) throws ParseException {
        this.regex = str;
        this.options = i2;
        RegexParser parserForXMLSchema = isSet(i2, 512) ? new ParserForXMLSchema(locale) : new RegexParser(locale);
        this.tokentree = parserForXMLSchema.parse(this.regex, this.options);
        this.nofparen = parserForXMLSchema.parennumber;
        this.hasBackReferences = parserForXMLSchema.hasBackReferences;
        this.operations = null;
        this.context = null;
    }

    public boolean matches(char[] cArr, Match match) {
        return matches(cArr, 0, cArr.length, match);
    }

    boolean equals(String str, int i2) {
        return this.regex.equals(str) && this.options == i2;
    }

    public boolean matches(char[] cArr, int i2, int i3, Match match) {
        Context context;
        int i4;
        int iMatch;
        int iMatch2;
        int i5;
        synchronized (this) {
            if (this.operations == null) {
                prepare();
            }
            if (this.context == null) {
                this.context = new Context();
            }
        }
        synchronized (this.context) {
            Context context2 = this.context;
            if (context2.inuse) {
                context2 = new Context();
            }
            context = context2;
            context.reset(cArr, i2, i3, this.numberOfClosures);
        }
        if (match != null) {
            match.setNumberOfGroups(this.nofparen);
            match.setSource(cArr);
        } else if (this.hasBackReferences) {
            match = new Match();
            match.setNumberOfGroups(this.nofparen);
        }
        context.match = match;
        if (isSet(this.options, 512)) {
            int iMatch3 = match(context, this.operations, context.start, 1, this.options);
            if (iMatch3 != context.limit) {
                return false;
            }
            Match match2 = context.match;
            if (match2 != null) {
                match2.setBeginning(0, context.start);
                context.match.setEnd(0, iMatch3);
            }
            context.setInUse(false);
            return true;
        }
        if (this.fixedStringOnly) {
            int iMatches = this.fixedStringTable.matches(cArr, context.start, context.limit);
            if (iMatches >= 0) {
                Match match3 = context.match;
                if (match3 != null) {
                    match3.setBeginning(0, iMatches);
                    context.match.setEnd(0, iMatches + this.fixedString.length());
                }
                context.setInUse(false);
                return true;
            }
            context.setInUse(false);
            return false;
        }
        if (this.fixedString != null && this.fixedStringTable.matches(cArr, context.start, context.limit) < 0) {
            context.setInUse(false);
            return false;
        }
        int i6 = context.limit - this.minlength;
        int iMatch4 = -1;
        Op op = this.operations;
        if (op != null && op.type == 7 && op.getChild().type == 0) {
            if (isSet(this.options, 4)) {
                i4 = context.start;
                iMatch = match(context, this.operations, i4, 1, this.options);
            } else {
                boolean z = true;
                iMatch2 = -1;
                i5 = context.start;
                while (i5 <= i6) {
                    if (isEOLChar(cArr[i5])) {
                        z = true;
                    } else {
                        if (z) {
                            iMatch2 = match(context, this.operations, i5, 1, this.options);
                            if (iMatch2 >= 0) {
                                break;
                            }
                        }
                        z = false;
                    }
                    i5++;
                }
                iMatch = iMatch2;
                i4 = i5;
            }
        } else {
            RangeToken rangeToken = this.firstChar;
            if (rangeToken != null) {
                iMatch2 = -1;
                i5 = context.start;
                while (i5 <= i6) {
                    char c = cArr[i5];
                    boolean zIsHighSurrogate = REUtil.isHighSurrogate(c);
                    int iComposeFromSurrogates = c;
                    if (zIsHighSurrogate) {
                        int i7 = i5 + 1;
                        iComposeFromSurrogates = c;
                        if (i7 < context.limit) {
                            iComposeFromSurrogates = REUtil.composeFromSurrogates(c, cArr[i7]);
                        }
                    }
                    if (rangeToken.match(iComposeFromSurrogates)) {
                        iMatch2 = match(context, this.operations, i5, 1, this.options);
                        if (iMatch2 >= 0) {
                            break;
                        }
                    }
                    i5++;
                }
                iMatch = iMatch2;
                i4 = i5;
            } else {
                i4 = context.start;
                while (i4 <= i6) {
                    iMatch4 = match(context, this.operations, i4, 1, this.options);
                    if (iMatch4 >= 0) {
                        break;
                    }
                    i4++;
                }
                iMatch = iMatch4;
            }
        }
        if (iMatch >= 0) {
            Match match4 = context.match;
            if (match4 != null) {
                match4.setBeginning(0, i4);
                context.match.setEnd(0, iMatch);
            }
            context.setInUse(false);
            return true;
        }
        context.setInUse(false);
        return false;
    }

    private Op compile(Token token, Op op, boolean z) {
        Op opCreateChar;
        Op.ChildOp childOpCreateClosure;
        Op opCompile;
        int i2 = token.type;
        int i3 = 0;
        switch (i2) {
            case 0:
                opCreateChar = Op.createChar(token.getChar());
                opCreateChar.next = op;
                break;
            case 1:
                if (!z) {
                    for (int size = token.size() - 1; size >= 0; size--) {
                        op = compile(token.getChild(size), op, false);
                    }
                    return op;
                }
                while (i3 < token.size()) {
                    op = compile(token.getChild(i3), op, true);
                    i3++;
                }
                return op;
            case 2:
                Op.UnionOp unionOpCreateUnion = Op.createUnion(token.size());
                while (i3 < token.size()) {
                    unionOpCreateUnion.addElement(compile(token.getChild(i3), op, z));
                    i3++;
                }
                return unionOpCreateUnion;
            case 3:
            case 9:
                Token child = token.getChild(0);
                int min = token.getMin();
                int max = token.getMax();
                if (min >= 0 && min == max) {
                    while (i3 < min) {
                        op = compile(child, op, z);
                        i3++;
                    }
                    return op;
                }
                if (min > 0 && max > 0) {
                    max -= min;
                }
                if (max > 0) {
                    Op op2 = op;
                    int i4 = 0;
                    while (i4 < max) {
                        Op.ChildOp childOpCreateQuestion = Op.createQuestion(token.type == 9);
                        childOpCreateQuestion.next = op;
                        childOpCreateQuestion.setChild(compile(child, op2, z));
                        i4++;
                        op2 = childOpCreateQuestion;
                    }
                    opCompile = op2;
                } else {
                    if (token.type == 9) {
                        childOpCreateClosure = Op.createNonGreedyClosure();
                    } else {
                        int i5 = this.numberOfClosures;
                        this.numberOfClosures = i5 + 1;
                        childOpCreateClosure = Op.createClosure(i5);
                    }
                    childOpCreateClosure.next = op;
                    childOpCreateClosure.setChild(compile(child, childOpCreateClosure, z));
                    opCompile = childOpCreateClosure;
                }
                if (min <= 0) {
                    return opCompile;
                }
                while (i3 < min) {
                    opCompile = compile(child, opCompile, z);
                    i3++;
                }
                return opCompile;
            case 4:
            case 5:
                opCreateChar = Op.createRange(token);
                opCreateChar.next = op;
                break;
            case 6:
                if (token.getParenNumber() == 0) {
                    return compile(token.getChild(0), op, z);
                }
                if (z) {
                    return Op.createCapture(-token.getParenNumber(), compile(token.getChild(0), Op.createCapture(token.getParenNumber(), op), z));
                }
                return Op.createCapture(token.getParenNumber(), compile(token.getChild(0), Op.createCapture(-token.getParenNumber(), op), z));
            case 7:
                return op;
            case 8:
                opCreateChar = Op.createAnchor(token.getChar());
                opCreateChar.next = op;
                break;
            case 10:
                opCreateChar = Op.createString(token.getString());
                opCreateChar.next = op;
                break;
            case 11:
                opCreateChar = Op.createDot();
                opCreateChar.next = op;
                break;
            case 12:
                opCreateChar = Op.createBackReference(token.getReferenceNumber());
                opCreateChar.next = op;
                break;
            default:
                switch (i2) {
                    case 20:
                        return Op.createLook(20, op, compile(token.getChild(0), null, false));
                    case 21:
                        return Op.createLook(21, op, compile(token.getChild(0), null, false));
                    case 22:
                        return Op.createLook(22, op, compile(token.getChild(0), null, true));
                    case 23:
                        return Op.createLook(23, op, compile(token.getChild(0), null, true));
                    case 24:
                        return Op.createIndependent(op, compile(token.getChild(0), null, z));
                    case 25:
                        Op opCompile2 = compile(token.getChild(0), null, z);
                        Token.ModifierToken modifierToken = (Token.ModifierToken) token;
                        return Op.createModifier(op, opCompile2, modifierToken.getOptions(), modifierToken.getOptionsMask());
                    case 26:
                        Token.ConditionToken conditionToken = (Token.ConditionToken) token;
                        int i6 = conditionToken.refNumber;
                        Token token2 = conditionToken.condition;
                        Op opCompile3 = token2 == null ? null : compile(token2, null, z);
                        Op opCompile4 = compile(conditionToken.yes, op, z);
                        Token token3 = conditionToken.no;
                        return Op.createCondition(op, i6, opCompile3, opCompile4, token3 != null ? compile(token3, op, z) : null);
                    default:
                        throw new RuntimeException("Unknown token type: " + token.type);
                }
        }
        return opCreateChar;
    }

    static final class Context {
        private CharArrayTarget charArrayTarget;
        private CharacterIteratorTarget characterIteratorTarget;
        ClosureContext[] closureContexts;
        boolean inuse = false;
        int length;
        int limit;
        Match match;
        int start;
        private StringTarget stringTarget;
        ExpressionTarget target;

        Context() {
        }

        private void resetCommon(int i2) {
            this.length = this.limit - this.start;
            setInUse(true);
            this.match = null;
            ClosureContext[] closureContextArr = this.closureContexts;
            if (closureContextArr == null || closureContextArr.length != i2) {
                this.closureContexts = new ClosureContext[i2];
            }
            for (int i3 = 0; i3 < i2; i3++) {
                ClosureContext[] closureContextArr2 = this.closureContexts;
                if (closureContextArr2[i3] == null) {
                    closureContextArr2[i3] = new ClosureContext();
                } else {
                    closureContextArr2[i3].reset();
                }
            }
        }

        void reset(CharacterIterator characterIterator, int i2, int i3, int i4) {
            CharacterIteratorTarget characterIteratorTarget = this.characterIteratorTarget;
            if (characterIteratorTarget == null) {
                this.characterIteratorTarget = new CharacterIteratorTarget(characterIterator);
            } else {
                characterIteratorTarget.resetTarget(characterIterator);
            }
            this.target = this.characterIteratorTarget;
            this.start = i2;
            this.limit = i3;
            resetCommon(i4);
        }

        synchronized void setInUse(boolean z) {
            this.inuse = z;
        }

        void reset(String str, int i2, int i3, int i4) {
            StringTarget stringTarget = this.stringTarget;
            if (stringTarget == null) {
                this.stringTarget = new StringTarget(str);
            } else {
                stringTarget.resetTarget(str);
            }
            this.target = this.stringTarget;
            this.start = i2;
            this.limit = i3;
            resetCommon(i4);
        }

        void reset(char[] cArr, int i2, int i3, int i4) {
            CharArrayTarget charArrayTarget = this.charArrayTarget;
            if (charArrayTarget == null) {
                this.charArrayTarget = new CharArrayTarget(cArr);
            } else {
                charArrayTarget.resetTarget(cArr);
            }
            this.target = this.charArrayTarget;
            this.start = i2;
            this.limit = i3;
            resetCommon(i4);
        }
    }

    public RegularExpression(String str, String str2, Locale locale) throws ParseException {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(str, str2, locale);
    }

    public void setPattern(String str, String str2) throws ParseException {
        setPattern(str, str2, Locale.getDefault());
    }

    public void setPattern(String str, String str2, Locale locale) throws ParseException {
        setPattern(str, REUtil.parseOptions(str2), locale);
    }

    RegularExpression(String str, Token token, int i2, boolean z, int i3) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        this.regex = str;
        this.tokentree = token;
        this.nofparen = i2;
        this.options = i3;
        this.hasBackReferences = z;
    }

    public boolean matches(String str) {
        return matches(str, 0, str.length(), (Match) null);
    }

    public boolean matches(String str, int i2, int i3) {
        return matches(str, i2, i3, (Match) null);
    }

    public boolean matches(String str, Match match) {
        return matches(str, 0, str.length(), match);
    }

    public boolean matches(String str, int i2, int i3, Match match) {
        Context context;
        int i4;
        int iMatch;
        int iMatch2;
        int i5;
        int i6;
        synchronized (this) {
            if (this.operations == null) {
                prepare();
            }
            if (this.context == null) {
                this.context = new Context();
            }
        }
        synchronized (this.context) {
            Context context2 = this.context;
            if (context2.inuse) {
                context2 = new Context();
            }
            context = context2;
            context.reset(str, i2, i3, this.numberOfClosures);
        }
        if (match != null) {
            match.setNumberOfGroups(this.nofparen);
            match.setSource(str);
        } else if (this.hasBackReferences) {
            match = new Match();
            match.setNumberOfGroups(this.nofparen);
        }
        context.match = match;
        if (isSet(this.options, 512)) {
            int iMatch3 = match(context, this.operations, context.start, 1, this.options);
            if (iMatch3 != context.limit) {
                return false;
            }
            Match match2 = context.match;
            if (match2 != null) {
                match2.setBeginning(0, context.start);
                context.match.setEnd(0, iMatch3);
            }
            context.setInUse(false);
            return true;
        }
        if (this.fixedStringOnly) {
            int iMatches = this.fixedStringTable.matches(str, context.start, context.limit);
            if (iMatches >= 0) {
                Match match3 = context.match;
                if (match3 != null) {
                    match3.setBeginning(0, iMatches);
                    context.match.setEnd(0, iMatches + this.fixedString.length());
                }
                context.setInUse(false);
                return true;
            }
            context.setInUse(false);
            return false;
        }
        if (this.fixedString != null && this.fixedStringTable.matches(str, context.start, context.limit) < 0) {
            context.setInUse(false);
            return false;
        }
        int i7 = context.limit - this.minlength;
        int iMatch4 = -1;
        Op op = this.operations;
        if (op != null && op.type == 7 && op.getChild().type == 0) {
            if (isSet(this.options, 4)) {
                i4 = context.start;
                iMatch = match(context, this.operations, i4, 1, this.options);
            } else {
                boolean z = true;
                iMatch2 = -1;
                i5 = context.start;
                while (i5 <= i7) {
                    if (isEOLChar(str.charAt(i5))) {
                        z = true;
                    } else {
                        if (z) {
                            iMatch2 = match(context, this.operations, i5, 1, this.options);
                            if (iMatch2 >= 0) {
                                break;
                            }
                        }
                        z = false;
                    }
                    i5++;
                }
                iMatch = iMatch2;
                i4 = i5;
            }
        } else {
            RangeToken rangeToken = this.firstChar;
            if (rangeToken != null) {
                iMatch2 = -1;
                i5 = context.start;
                while (i5 <= i7) {
                    int iCharAt = str.charAt(i5);
                    if (REUtil.isHighSurrogate(iCharAt) && (i6 = i5 + 1) < context.limit) {
                        iCharAt = REUtil.composeFromSurrogates(iCharAt, str.charAt(i6));
                    }
                    if (rangeToken.match(iCharAt)) {
                        iMatch2 = match(context, this.operations, i5, 1, this.options);
                        if (iMatch2 >= 0) {
                            break;
                        }
                    }
                    i5++;
                }
                iMatch = iMatch2;
                i4 = i5;
            } else {
                i4 = context.start;
                while (i4 <= i7) {
                    iMatch4 = match(context, this.operations, i4, 1, this.options);
                    if (iMatch4 >= 0) {
                        break;
                    }
                    i4++;
                }
                iMatch = iMatch4;
            }
        }
        if (iMatch >= 0) {
            Match match4 = context.match;
            if (match4 != null) {
                match4.setBeginning(0, i4);
                context.match.setEnd(0, iMatch);
            }
            context.setInUse(false);
            return true;
        }
        context.setInUse(false);
        return false;
    }

    public boolean matches(CharacterIterator characterIterator) {
        return matches(characterIterator, (Match) null);
    }

    public boolean matches(CharacterIterator characterIterator, Match match) {
        Context context;
        int i2;
        int iMatch;
        int iMatch2;
        int i3;
        int i4;
        int beginIndex = characterIterator.getBeginIndex();
        int endIndex = characterIterator.getEndIndex();
        synchronized (this) {
            if (this.operations == null) {
                prepare();
            }
            if (this.context == null) {
                this.context = new Context();
            }
        }
        synchronized (this.context) {
            Context context2 = this.context;
            if (context2.inuse) {
                context2 = new Context();
            }
            context = context2;
            context.reset(characterIterator, beginIndex, endIndex, this.numberOfClosures);
        }
        if (match != null) {
            match.setNumberOfGroups(this.nofparen);
            match.setSource(characterIterator);
        } else if (this.hasBackReferences) {
            match = new Match();
            match.setNumberOfGroups(this.nofparen);
        }
        context.match = match;
        if (isSet(this.options, 512)) {
            int iMatch3 = match(context, this.operations, context.start, 1, this.options);
            if (iMatch3 != context.limit) {
                return false;
            }
            Match match2 = context.match;
            if (match2 != null) {
                match2.setBeginning(0, context.start);
                context.match.setEnd(0, iMatch3);
            }
            context.setInUse(false);
            return true;
        }
        if (this.fixedStringOnly) {
            int iMatches = this.fixedStringTable.matches(characterIterator, context.start, context.limit);
            if (iMatches >= 0) {
                Match match3 = context.match;
                if (match3 != null) {
                    match3.setBeginning(0, iMatches);
                    context.match.setEnd(0, iMatches + this.fixedString.length());
                }
                context.setInUse(false);
                return true;
            }
            context.setInUse(false);
            return false;
        }
        if (this.fixedString != null && this.fixedStringTable.matches(characterIterator, context.start, context.limit) < 0) {
            context.setInUse(false);
            return false;
        }
        int i5 = context.limit - this.minlength;
        int iMatch4 = -1;
        Op op = this.operations;
        if (op != null && op.type == 7 && op.getChild().type == 0) {
            if (isSet(this.options, 4)) {
                i2 = context.start;
                iMatch = match(context, this.operations, i2, 1, this.options);
            } else {
                boolean z = true;
                iMatch2 = -1;
                i3 = context.start;
                while (i3 <= i5) {
                    if (isEOLChar(characterIterator.setIndex(i3))) {
                        z = true;
                    } else {
                        if (z) {
                            iMatch2 = match(context, this.operations, i3, 1, this.options);
                            if (iMatch2 >= 0) {
                                break;
                            }
                        }
                        z = false;
                    }
                    i3++;
                }
                iMatch = iMatch2;
                i2 = i3;
            }
        } else {
            RangeToken rangeToken = this.firstChar;
            if (rangeToken != null) {
                iMatch2 = -1;
                i3 = context.start;
                while (i3 <= i5) {
                    int index = characterIterator.setIndex(i3);
                    if (REUtil.isHighSurrogate(index) && (i4 = i3 + 1) < context.limit) {
                        index = REUtil.composeFromSurrogates(index, characterIterator.setIndex(i4));
                    }
                    if (rangeToken.match(index)) {
                        iMatch2 = match(context, this.operations, i3, 1, this.options);
                        if (iMatch2 >= 0) {
                            break;
                        }
                    }
                    i3++;
                }
                iMatch = iMatch2;
                i2 = i3;
            } else {
                i2 = context.start;
                while (i2 <= i5) {
                    iMatch4 = match(context, this.operations, i2, 1, this.options);
                    if (iMatch4 >= 0) {
                        break;
                    }
                    i2++;
                }
                iMatch = iMatch4;
            }
        }
        if (iMatch >= 0) {
            Match match4 = context.match;
            if (match4 != null) {
                match4.setBeginning(0, i2);
                context.match.setEnd(0, iMatch);
            }
            context.setInUse(false);
            return true;
        }
        context.setInUse(false);
        return false;
    }
}
