package org.apache.xmlbeans.impl.regex;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.xmlbeans.impl.regex.Token;

/* loaded from: classes.dex */
class RegexParser {
    private static final String BUNDLE_PKG = "org.apache.xmlbeans.impl.regex.message";
    protected static final int S_INBRACKETS = 1;
    protected static final int S_INXBRACKETS = 2;
    protected static final int S_NORMAL = 0;
    static final int T_BACKSOLIDUS = 10;
    static final int T_CARET = 11;
    static final int T_CHAR = 0;
    static final int T_COMMENT = 21;
    static final int T_CONDITION = 23;
    static final int T_DOLLAR = 12;
    static final int T_DOT = 8;
    static final int T_EOF = 1;
    static final int T_INDEPENDENT = 18;
    static final int T_LBRACKET = 9;
    static final int T_LOOKAHEAD = 14;
    static final int T_LOOKBEHIND = 16;
    static final int T_LPAREN = 6;
    static final int T_LPAREN2 = 13;
    static final int T_MODIFIERS = 22;
    static final int T_NEGATIVELOOKAHEAD = 15;
    static final int T_NEGATIVELOOKBEHIND = 17;
    static final int T_OR = 2;
    static final int T_PLUS = 4;
    static final int T_POSIX_CHARCLASS_START = 20;
    static final int T_QUESTION = 5;
    static final int T_RPAREN = 7;
    static final int T_SET_OPERATIONS = 19;
    static final int T_STAR = 3;
    static final int T_XMLSCHEMA_CC_SUBTRACTION = 24;
    int chardata;
    boolean hasBackReferences;
    int nexttoken;
    int offset;
    int options;
    String regex;
    int regexlen;
    ResourceBundle resources;
    int context = 0;
    int parennumber = 1;
    Vector references = null;

    static class ReferencePosition {
        int position;
        int refNumber;

        ReferencePosition(int i2, int i3) {
            this.refNumber = i2;
            this.position = i3;
        }
    }

    public RegexParser() {
        setLocale(Locale.getDefault());
    }

    private static final int hexChar(int i2) {
        if (i2 < 48 || i2 > 102) {
            return -1;
        }
        if (i2 <= 57) {
            return i2 - 48;
        }
        int i3 = 65;
        if (i2 < 65) {
            return -1;
        }
        if (i2 > 70) {
            i3 = 97;
            if (i2 < 97) {
                return -1;
            }
        }
        return (i2 - i3) + 10;
    }

    private boolean isSet(int i2) {
        return (this.options & i2) == i2;
    }

    boolean checkQuestion(int i2) {
        return i2 < this.regexlen && this.regex.charAt(i2) == '?';
    }

    int decodeEscaped() throws ParseException {
        int iHexChar;
        int iHexChar2;
        int iHexChar3;
        int iHexChar4;
        int iHexChar5;
        int iHexChar6;
        int iHexChar7;
        int iHexChar8;
        int iHexChar9;
        int iHexChar10;
        int iHexChar11;
        if (read() != 10) {
            throw ex("parser.next.1", this.offset - 1);
        }
        int i2 = this.chardata;
        if (i2 != 65 && i2 != 90) {
            if (i2 == 110) {
                return 10;
            }
            if (i2 == 114) {
                return 13;
            }
            if (i2 == 120) {
                next();
                if (read() != 0) {
                    throw ex("parser.descape.1", this.offset - 1);
                }
                if (this.chardata == 123) {
                    int i3 = 0;
                    while (true) {
                        next();
                        if (read() != 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int iHexChar12 = hexChar(this.chardata);
                        if (iHexChar12 < 0) {
                            if (this.chardata != 125) {
                                throw ex("parser.descape.3", this.offset - 1);
                            }
                            if (i3 <= 1114111) {
                                return i3;
                            }
                            throw ex("parser.descape.4", this.offset - 1);
                        }
                        int i4 = i3 * 16;
                        if (i3 > i4) {
                            throw ex("parser.descape.2", this.offset - 1);
                        }
                        i3 = i4 + iHexChar12;
                    }
                } else {
                    if (read() != 0 || (iHexChar = hexChar(this.chardata)) < 0) {
                        throw ex("parser.descape.1", this.offset - 1);
                    }
                    next();
                    if (read() != 0 || (iHexChar2 = hexChar(this.chardata)) < 0) {
                        throw ex("parser.descape.1", this.offset - 1);
                    }
                }
            } else if (i2 != 122) {
                if (i2 == 101) {
                    return 27;
                }
                if (i2 == 102) {
                    return 12;
                }
                switch (i2) {
                    case 116:
                        return 9;
                    case 117:
                        next();
                        if (read() != 0 || (iHexChar3 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (iHexChar4 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i5 = (iHexChar3 * 16) + iHexChar4;
                        next();
                        if (read() != 0 || (iHexChar5 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        iHexChar = (i5 * 16) + iHexChar5;
                        next();
                        if (read() != 0 || (iHexChar2 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        break;
                    case 118:
                        next();
                        if (read() != 0 || (iHexChar6 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (iHexChar7 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i6 = (iHexChar6 * 16) + iHexChar7;
                        next();
                        if (read() != 0 || (iHexChar8 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i7 = (i6 * 16) + iHexChar8;
                        next();
                        if (read() != 0 || (iHexChar9 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i8 = (i7 * 16) + iHexChar9;
                        next();
                        if (read() != 0 || (iHexChar10 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i9 = (i8 * 16) + iHexChar10;
                        next();
                        if (read() != 0 || (iHexChar11 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i10 = iHexChar11 + (i9 * 16);
                        if (i10 <= 1114111) {
                            return i10;
                        }
                        throw ex("parser.descappe.4", this.offset - 1);
                    default:
                        return i2;
                }
            }
            return iHexChar2 + (iHexChar * 16);
        }
        throw ex("parser.descape.5", this.offset - 2);
    }

    final ParseException ex(String str, int i2) {
        return new ParseException(this.resources.getString(str), i2);
    }

    Token getTokenForShorthand(int i2) {
        if (i2 == 68) {
            return isSet(32) ? Token.getRange("Nd", false) : Token.token_not_0to9;
        }
        if (i2 == 83) {
            return isSet(32) ? Token.getRange("IsSpace", false) : Token.token_not_spaces;
        }
        if (i2 == 87) {
            return isSet(32) ? Token.getRange("IsWord", false) : Token.token_not_wordchars;
        }
        if (i2 == 100) {
            return isSet(32) ? Token.getRange("Nd", true) : Token.token_0to9;
        }
        if (i2 == 115) {
            return isSet(32) ? Token.getRange("IsSpace", true) : Token.token_spaces;
        }
        if (i2 == 119) {
            return isSet(32) ? Token.getRange("IsWord", true) : Token.token_wordchars;
        }
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(i2, 16));
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void next() {
        int i2;
        int i3;
        int i4;
        char cCharAt;
        int i5 = this.offset;
        if (i5 >= this.regexlen) {
            this.chardata = -1;
            this.nexttoken = 1;
            return;
        }
        String str = this.regex;
        this.offset = i5 + 1;
        char cCharAt2 = str.charAt(i5);
        this.chardata = cCharAt2;
        int i6 = 10;
        if (this.context == 1) {
            if (cCharAt2 != '-') {
                if (cCharAt2 != '[') {
                    if (cCharAt2 == '\\') {
                        int i7 = this.offset;
                        if (i7 >= this.regexlen) {
                            throw ex("parser.next.1", i7 - 1);
                        }
                        String str2 = this.regex;
                        this.offset = i7 + 1;
                        this.chardata = str2.charAt(i7);
                    }
                    if (REUtil.isHighSurrogate(cCharAt2) && (i4 = this.offset) < this.regexlen) {
                        cCharAt = this.regex.charAt(i4);
                        if (REUtil.isLowSurrogate(cCharAt)) {
                            this.chardata = REUtil.composeFromSurrogates(cCharAt2, cCharAt);
                            this.offset++;
                        }
                    }
                } else {
                    if (!isSet(512) && (i3 = this.offset) < this.regexlen && this.regex.charAt(i3) == ':') {
                        this.offset++;
                        i6 = 20;
                    }
                    if (REUtil.isHighSurrogate(cCharAt2)) {
                        cCharAt = this.regex.charAt(i4);
                        if (REUtil.isLowSurrogate(cCharAt)) {
                        }
                    }
                }
                i6 = 0;
            } else if (isSet(512) && (i2 = this.offset) < this.regexlen && this.regex.charAt(i2) == '[') {
                this.offset++;
                i6 = 24;
            } else {
                i6 = 0;
            }
            this.nexttoken = i6;
            return;
        }
        if (cCharAt2 == '$') {
            i6 = 12;
        } else if (cCharAt2 == '.') {
            i6 = 8;
        } else if (cCharAt2 == '?') {
            i6 = 5;
        } else if (cCharAt2 == '^') {
            i6 = 11;
        } else if (cCharAt2 == '|') {
            i6 = 2;
        } else if (cCharAt2 == '[') {
            i6 = 9;
        } else if (cCharAt2 != '\\') {
            switch (cCharAt2) {
                case '(':
                    i6 = 6;
                    int i8 = this.offset;
                    if (i8 < this.regexlen && this.regex.charAt(i8) == '?') {
                        int i9 = this.offset + 1;
                        this.offset = i9;
                        if (i9 >= this.regexlen) {
                            throw ex("parser.next.2", i9 - 1);
                        }
                        String str3 = this.regex;
                        this.offset = i9 + 1;
                        char cCharAt3 = str3.charAt(i9);
                        if (cCharAt3 == '!') {
                            i6 = 15;
                            break;
                        } else if (cCharAt3 == '#') {
                            do {
                                int i10 = this.offset;
                                if (i10 < this.regexlen) {
                                    String str4 = this.regex;
                                    this.offset = i10 + 1;
                                    cCharAt3 = str4.charAt(i10);
                                }
                                if (cCharAt3 == ')') {
                                    throw ex("parser.next.4", this.offset - 1);
                                }
                                i6 = 21;
                                break;
                            } while (cCharAt3 != ')');
                            if (cCharAt3 == ')') {
                            }
                        } else if (cCharAt3 == ':') {
                            i6 = 13;
                            break;
                        } else if (cCharAt3 == '[') {
                            i6 = 19;
                            break;
                        } else {
                            switch (cCharAt3) {
                                case '<':
                                    int i11 = this.offset;
                                    if (i11 >= this.regexlen) {
                                        throw ex("parser.next.2", i11 - 3);
                                    }
                                    String str5 = this.regex;
                                    this.offset = i11 + 1;
                                    char cCharAt4 = str5.charAt(i11);
                                    if (cCharAt4 == '=') {
                                        i6 = 16;
                                        break;
                                    } else {
                                        if (cCharAt4 != '!') {
                                            throw ex("parser.next.3", this.offset - 3);
                                        }
                                        i6 = 17;
                                        break;
                                    }
                                case '=':
                                    i6 = 14;
                                    break;
                                case '>':
                                    i6 = 18;
                                    break;
                                default:
                                    if (cCharAt3 == '-' || (('a' <= cCharAt3 && cCharAt3 <= 'z') || ('A' <= cCharAt3 && cCharAt3 <= 'Z'))) {
                                        this.offset--;
                                        i6 = 22;
                                        break;
                                    } else {
                                        if (cCharAt3 != '(') {
                                            throw ex("parser.next.2", this.offset - 2);
                                        }
                                        i6 = 23;
                                        break;
                                    }
                            }
                        }
                    }
                    break;
                case ')':
                    i6 = 7;
                    break;
                case '*':
                    i6 = 3;
                    break;
                case '+':
                    i6 = 4;
                    break;
                default:
                    i6 = 0;
                    break;
            }
        } else {
            int i12 = this.offset;
            if (i12 >= this.regexlen) {
                throw ex("parser.next.1", i12 - 1);
            }
            String str6 = this.regex;
            this.offset = i12 + 1;
            this.chardata = str6.charAt(i12);
        }
        this.nexttoken = i6;
    }

    synchronized Token parse(String str, int i2) throws ParseException {
        Token regex;
        this.options = i2;
        this.offset = 0;
        setContext(0);
        this.parennumber = 1;
        this.hasBackReferences = false;
        this.regex = str;
        if (isSet(16)) {
            this.regex = REUtil.stripExtendedComment(this.regex);
        }
        this.regexlen = this.regex.length();
        next();
        regex = parseRegex();
        int i3 = this.offset;
        if (i3 != this.regexlen) {
            throw ex("parser.parse.1", i3);
        }
        if (this.references != null) {
            for (int i4 = 0; i4 < this.references.size(); i4++) {
                ReferencePosition referencePosition = (ReferencePosition) this.references.elementAt(i4);
                if (this.parennumber <= referencePosition.refNumber) {
                    throw ex("parser.parse.2", referencePosition.position);
                }
            }
            this.references.removeAllElements();
        }
        return regex;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Token parseAtom() throws ParseException {
        Token tokenProcessBacksolidus_pP;
        int i2 = read();
        if (i2 == 0) {
            int i3 = this.chardata;
            if (i3 == 93 || i3 == 123 || i3 == 125) {
                throw ex("parser.atom.4", this.offset - 1);
            }
            Token.CharToken charTokenCreateChar = Token.createChar(i3);
            int i4 = this.chardata;
            next();
            if (!REUtil.isHighSurrogate(i4) || read() != 0 || !REUtil.isLowSurrogate(this.chardata)) {
                return charTokenCreateChar;
            }
            Token.ParenToken parenTokenCreateParen = Token.createParen(Token.createString(new String(new char[]{(char) i4, (char) this.chardata})), 0);
            next();
            return parenTokenCreateParen;
        }
        if (i2 == 6) {
            return processParen();
        }
        if (i2 == 13) {
            return processParen2();
        }
        if (i2 == 18) {
            return processIndependent();
        }
        if (i2 == 19) {
            return parseSetOperations();
        }
        if (i2 == 22) {
            return processModifiers();
        }
        if (i2 == 23) {
            return processCondition();
        }
        switch (i2) {
            case 8:
                next();
                return Token.token_dot;
            case 9:
                return parseCharacterClass(true);
            case 10:
                int i5 = this.chardata;
                if (i5 == 67) {
                    return processBacksolidus_C();
                }
                if (i5 != 68) {
                    if (i5 == 73) {
                        return processBacksolidus_I();
                    }
                    if (i5 == 80) {
                        int i6 = this.offset;
                        tokenProcessBacksolidus_pP = processBacksolidus_pP(i5);
                        if (tokenProcessBacksolidus_pP == null) {
                            throw ex("parser.atom.5", i6);
                        }
                    } else if (i5 != 83) {
                        if (i5 == 105) {
                            return processBacksolidus_i();
                        }
                        if (i5 == 110) {
                            int iDecodeEscaped = decodeEscaped();
                            tokenProcessBacksolidus_pP = iDecodeEscaped < 65536 ? Token.createChar(iDecodeEscaped) : Token.createString(REUtil.decomposeToSurrogates(iDecodeEscaped));
                        } else if (i5 != 112) {
                            if (i5 != 87) {
                                if (i5 == 88) {
                                    return processBacksolidus_X();
                                }
                                switch (i5) {
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                        return processBackreference();
                                    default:
                                        switch (i5) {
                                            case 99:
                                                return processBacksolidus_c();
                                            case 100:
                                                break;
                                            case 101:
                                            case 102:
                                                break;
                                            case 103:
                                                return processBacksolidus_g();
                                            default:
                                                switch (i5) {
                                                    case 114:
                                                    case 116:
                                                    case 117:
                                                    case 118:
                                                    case 120:
                                                        break;
                                                    case 115:
                                                    case 119:
                                                        break;
                                                    default:
                                                        tokenProcessBacksolidus_pP = Token.createChar(i5);
                                                        break;
                                                }
                                        }
                                }
                            }
                        }
                    }
                    next();
                    return tokenProcessBacksolidus_pP;
                }
                Token tokenForShorthand = getTokenForShorthand(i5);
                next();
                return tokenForShorthand;
            default:
                throw ex("parser.atom.4", this.offset - 1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x016e, code lost:
    
        if (read() == 1) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0170, code lost:
    
        if (r17 != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0172, code lost:
    
        if (r6 == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0174, code lost:
    
        r5.subtractRanges(r2);
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0178, code lost:
    
        r2.sortRanges();
        r2.compactRanges();
        setContext(0);
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0184, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x018b, code lost:
    
        throw ex("parser.cc.2", r16.offset);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00fd, code lost:
    
        throw ex("parser.cc.1", r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected RangeToken parseCharacterClass(boolean z) throws ParseException {
        RangeToken rangeTokenCreateRange;
        boolean z2;
        boolean z3;
        boolean z4;
        setContext(1);
        next();
        RangeToken rangeTokenCreateRange2 = null;
        if (read() == 0 && this.chardata == 94) {
            next();
            if (z) {
                rangeTokenCreateRange = Token.createNRange();
            } else {
                rangeTokenCreateRange2 = Token.createRange();
                rangeTokenCreateRange2.addRange(0, 1114111);
                rangeTokenCreateRange = Token.createRange();
            }
            z2 = true;
        } else {
            rangeTokenCreateRange = Token.createRange();
            z2 = false;
        }
        boolean z5 = true;
        while (true) {
            int i2 = read();
            if (i2 == 1 || (i2 == 0 && this.chardata == 93 && !z5)) {
                break;
            }
            int iProcessCIinCharacterClass = this.chardata;
            if (i2 != 10) {
                if (i2 == 20) {
                    int iIndexOf = this.regex.indexOf(58, this.offset);
                    if (iIndexOf < 0) {
                        throw ex("parser.cc.1", this.offset);
                    }
                    if (this.regex.charAt(this.offset) == '^') {
                        this.offset++;
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    RangeToken range = Token.getRange(this.regex.substring(this.offset, iIndexOf), z3, isSet(512));
                    if (range == null) {
                        throw ex("parser.cc.3", this.offset);
                    }
                    rangeTokenCreateRange.mergeRanges(range);
                    int i3 = iIndexOf + 1;
                    if (i3 >= this.regexlen || this.regex.charAt(i3) != ']') {
                        break;
                    }
                    this.offset = iIndexOf + 2;
                }
            } else if (iProcessCIinCharacterClass == 67) {
                iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                z4 = iProcessCIinCharacterClass < 0;
            } else if (iProcessCIinCharacterClass == 68) {
                rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
            } else if (iProcessCIinCharacterClass != 73) {
                if (iProcessCIinCharacterClass != 80) {
                    if (iProcessCIinCharacterClass != 83 && iProcessCIinCharacterClass != 87) {
                        if (iProcessCIinCharacterClass != 105) {
                            if (iProcessCIinCharacterClass != 112) {
                                if (iProcessCIinCharacterClass != 115 && iProcessCIinCharacterClass != 119) {
                                    if (iProcessCIinCharacterClass != 99) {
                                        if (iProcessCIinCharacterClass != 100) {
                                            iProcessCIinCharacterClass = decodeEscaped();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                }
                int i4 = this.offset;
                RangeToken rangeTokenProcessBacksolidus_pP = processBacksolidus_pP(iProcessCIinCharacterClass);
                if (rangeTokenProcessBacksolidus_pP == null) {
                    throw ex("parser.atom.5", i4);
                }
                rangeTokenCreateRange.mergeRanges(rangeTokenProcessBacksolidus_pP);
            }
            next();
            if (!z4) {
                if (read() == 0 && this.chardata == 45) {
                    next();
                    int i5 = read();
                    if (i5 == 1) {
                        throw ex("parser.cc.2", this.offset);
                    }
                    if (i5 == 0 && this.chardata == 93) {
                        rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        rangeTokenCreateRange.addRange(45, 45);
                    } else {
                        int iDecodeEscaped = this.chardata;
                        if (i5 == 10) {
                            iDecodeEscaped = decodeEscaped();
                        }
                        next();
                        rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iDecodeEscaped);
                    }
                } else {
                    rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                }
            }
            if (isSet(1024) && read() == 0 && this.chardata == 44) {
                next();
            }
            z5 = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Token parseFactor() throws ParseException {
        int i2;
        int i3;
        int i4;
        switch (read()) {
            case 10:
                int i5 = this.chardata;
                if (i5 == 60) {
                    return processBacksolidus_lt();
                }
                if (i5 == 62) {
                    return processBacksolidus_gt();
                }
                if (i5 == 90) {
                    return processBacksolidus_Z();
                }
                if (i5 == 98) {
                    return processBacksolidus_b();
                }
                if (i5 == 122) {
                    return processBacksolidus_z();
                }
                if (i5 == 65) {
                    return processBacksolidus_A();
                }
                if (i5 == 66) {
                    return processBacksolidus_B();
                }
                break;
            case 11:
                return processCaret();
            case 12:
                return processDollar();
            case 14:
                return processLookahead();
            case 15:
                return processNegativelookahead();
            case 16:
                return processLookbehind();
            case 17:
                return processNegativelookbehind();
            case 21:
                next();
                return Token.createEmpty();
        }
        Token atom = parseAtom();
        int i6 = read();
        if (i6 != 0) {
            if (i6 == 3) {
                return processStar(atom);
            }
            if (i6 == 4) {
                return processPlus(atom);
            }
            if (i6 == 5) {
                return processQuestion(atom);
            }
        } else if (this.chardata == 123 && (i2 = this.offset) < this.regexlen) {
            int i7 = i2 + 1;
            char cCharAt = this.regex.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                throw ex("parser.quantifier.1", this.offset);
            }
            int i8 = cCharAt - '0';
            while (i7 < this.regexlen) {
                int i9 = i7 + 1;
                cCharAt = this.regex.charAt(i7);
                if (cCharAt < '0' || cCharAt > '9') {
                    i7 = i9;
                    if (cCharAt == ',') {
                        i3 = i8;
                    } else {
                        if (i7 >= this.regexlen) {
                            throw ex("parser.quantifier.3", this.offset);
                        }
                        int i10 = i7 + 1;
                        cCharAt = this.regex.charAt(i7);
                        if (cCharAt < '0' || cCharAt > '9') {
                            i4 = -1;
                        } else {
                            i4 = cCharAt - '0';
                            while (i10 < this.regexlen) {
                                int i11 = i10 + 1;
                                cCharAt = this.regex.charAt(i10);
                                if (cCharAt < '0' || cCharAt > '9') {
                                    i10 = i11;
                                    if (i8 > i4) {
                                        throw ex("parser.quantifier.4", this.offset);
                                    }
                                } else {
                                    i4 = ((i4 * 10) + cCharAt) - 48;
                                    if (i4 < 0) {
                                        throw ex("parser.quantifier.5", this.offset);
                                    }
                                    i10 = i11;
                                }
                            }
                            if (i8 > i4) {
                            }
                        }
                        i3 = i4;
                        i7 = i10;
                    }
                    if (cCharAt == '}') {
                        throw ex("parser.quantifier.2", this.offset);
                    }
                    if (checkQuestion(i7)) {
                        atom = Token.createNGClosure(atom);
                        this.offset = i7 + 1;
                    } else {
                        atom = Token.createClosure(atom);
                        this.offset = i7;
                    }
                    atom.setMin(i8);
                    atom.setMax(i3);
                    next();
                } else {
                    i8 = ((i8 * 10) + cCharAt) - 48;
                    if (i8 < 0) {
                        throw ex("parser.quantifier.5", this.offset);
                    }
                    i7 = i9;
                }
            }
            if (cCharAt == ',') {
            }
            if (cCharAt == '}') {
            }
        }
        return atom;
    }

    Token parseRegex() throws ParseException {
        Token term = parseTerm();
        Token.UnionToken unionTokenCreateUnion = null;
        while (read() == 2) {
            next();
            if (unionTokenCreateUnion == null) {
                unionTokenCreateUnion = Token.createUnion();
                unionTokenCreateUnion.addChild(term);
                term = unionTokenCreateUnion;
            }
            term.addChild(parseTerm());
        }
        return term;
    }

    protected RangeToken parseSetOperations() throws ParseException {
        RangeToken characterClass = parseCharacterClass(false);
        while (true) {
            int i2 = read();
            if (i2 == 7) {
                next();
                return characterClass;
            }
            int i3 = this.chardata;
            if ((i2 != 0 || (i3 != 45 && i3 != 38)) && i2 != 4) {
                throw ex("parser.ope.2", this.offset - 1);
            }
            next();
            if (read() != 9) {
                throw ex("parser.ope.1", this.offset - 1);
            }
            RangeToken characterClass2 = parseCharacterClass(false);
            if (i2 == 4) {
                characterClass.mergeRanges(characterClass2);
            } else if (i3 == 45) {
                characterClass.subtractRanges(characterClass2);
            } else {
                if (i3 != 38) {
                    throw new RuntimeException("ASSERT");
                }
                characterClass.intersectRanges(characterClass2);
            }
        }
    }

    Token parseTerm() throws ParseException {
        int i2 = read();
        if (i2 == 2 || i2 == 7 || i2 == 1) {
            return Token.createEmpty();
        }
        Token factor = parseFactor();
        Token.UnionToken unionTokenCreateConcat = null;
        while (true) {
            int i3 = read();
            if (i3 == 2 || i3 == 7 || i3 == 1) {
                break;
            }
            if (unionTokenCreateConcat == null) {
                unionTokenCreateConcat = Token.createConcat();
                unionTokenCreateConcat.addChild(factor);
                factor = unionTokenCreateConcat;
            }
            unionTokenCreateConcat.addChild(parseFactor());
        }
        return factor;
    }

    Token processBackreference() throws ParseException {
        int i2 = this.chardata - 48;
        Token.StringToken stringTokenCreateBackReference = Token.createBackReference(i2);
        this.hasBackReferences = true;
        if (this.references == null) {
            this.references = new Vector();
        }
        this.references.addElement(new ReferencePosition(i2, this.offset - 2));
        next();
        return stringTokenCreateBackReference;
    }

    Token processBacksolidus_A() throws ParseException {
        next();
        return Token.token_stringbeginning;
    }

    Token processBacksolidus_B() throws ParseException {
        next();
        return Token.token_not_wordedge;
    }

    Token processBacksolidus_C() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    Token processBacksolidus_I() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    Token processBacksolidus_X() throws ParseException {
        next();
        return Token.getCombiningCharacterSequence();
    }

    Token processBacksolidus_Z() throws ParseException {
        next();
        return Token.token_stringend2;
    }

    Token processBacksolidus_b() throws ParseException {
        next();
        return Token.token_wordedge;
    }

    Token processBacksolidus_c() throws ParseException {
        int i2 = this.offset;
        if (i2 < this.regexlen) {
            String str = this.regex;
            this.offset = i2 + 1;
            char cCharAt = str.charAt(i2);
            if ((65504 & cCharAt) == 64) {
                next();
                return Token.createChar(cCharAt - '@');
            }
        }
        throw ex("parser.atom.1", this.offset - 1);
    }

    Token processBacksolidus_g() throws ParseException {
        next();
        return Token.getGraphemePattern();
    }

    Token processBacksolidus_gt() throws ParseException {
        next();
        return Token.token_wordend;
    }

    Token processBacksolidus_i() throws ParseException {
        Token.CharToken charTokenCreateChar = Token.createChar(105);
        next();
        return charTokenCreateChar;
    }

    Token processBacksolidus_lt() throws ParseException {
        next();
        return Token.token_wordbeginning;
    }

    protected RangeToken processBacksolidus_pP(int i2) throws ParseException {
        next();
        if (read() != 0 || this.chardata != 123) {
            throw ex("parser.atom.2", this.offset - 1);
        }
        boolean z = i2 == 112;
        int i3 = this.offset;
        int iIndexOf = this.regex.indexOf(125, i3);
        if (iIndexOf < 0) {
            throw ex("parser.atom.3", this.offset);
        }
        String strSubstring = this.regex.substring(i3, iIndexOf);
        this.offset = iIndexOf + 1;
        return Token.getRange(strSubstring, z, isSet(512));
    }

    Token processBacksolidus_z() throws ParseException {
        next();
        return Token.token_stringend;
    }

    int processCIinCharacterClass(RangeToken rangeToken, int i2) {
        return decodeEscaped();
    }

    Token processCaret() throws ParseException {
        next();
        return Token.token_linebeginning;
    }

    Token processCondition() throws ParseException {
        Token factor;
        int i2 = this.offset;
        if (i2 + 1 >= this.regexlen) {
            throw ex("parser.factor.4", i2);
        }
        int i3 = -1;
        char cCharAt = this.regex.charAt(i2);
        Token child = null;
        if ('1' > cCharAt || cCharAt > '9') {
            if (cCharAt == '?') {
                this.offset--;
            }
            next();
            factor = parseFactor();
            int i4 = factor.type;
            if (i4 != 8) {
                switch (i4) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ex("parser.factor.5", this.offset);
                }
            } else if (read() != 7) {
                throw ex("parser.factor.1", this.offset - 1);
            }
        } else {
            i3 = cCharAt - '0';
            this.hasBackReferences = true;
            if (this.references == null) {
                this.references = new Vector();
            }
            this.references.addElement(new ReferencePosition(i3, this.offset));
            int i5 = this.offset + 1;
            this.offset = i5;
            if (this.regex.charAt(i5) != ')') {
                throw ex("parser.factor.1", this.offset);
            }
            this.offset++;
            factor = null;
        }
        next();
        Token regex = parseRegex();
        if (regex.type == 2) {
            if (regex.size() != 2) {
                throw ex("parser.factor.6", this.offset);
            }
            child = regex.getChild(1);
            regex = regex.getChild(0);
        }
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return Token.createCondition(i3, factor, regex, child);
    }

    Token processDollar() throws ParseException {
        next();
        return Token.token_lineend;
    }

    Token processIndependent() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(24, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processLookahead() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(20, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processLookbehind() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(22, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processModifiers() throws ParseException {
        int optionValue;
        int optionValue2;
        int i2 = 0;
        char cCharAt = 65535;
        int i3 = 0;
        while (true) {
            int i4 = this.offset;
            if (i4 >= this.regexlen || (optionValue2 = REUtil.getOptionValue((cCharAt = this.regex.charAt(i4)))) == 0) {
                break;
            }
            i3 |= optionValue2;
            this.offset++;
        }
        int i5 = this.offset;
        if (i5 >= this.regexlen) {
            throw ex("parser.factor.2", i5 - 1);
        }
        if (cCharAt == '-') {
            this.offset = i5 + 1;
            while (true) {
                int i6 = this.offset;
                if (i6 >= this.regexlen || (optionValue = REUtil.getOptionValue((cCharAt = this.regex.charAt(i6)))) == 0) {
                    break;
                }
                i2 |= optionValue;
                this.offset++;
            }
            int i7 = this.offset;
            if (i7 >= this.regexlen) {
                throw ex("parser.factor.2", i7 - 1);
            }
        }
        if (cCharAt != ':') {
            if (cCharAt != ')') {
                throw ex("parser.factor.3", this.offset);
            }
            this.offset++;
            next();
            return Token.createModifierGroup(parseRegex(), i3, i2);
        }
        this.offset++;
        next();
        Token.ModifierToken modifierTokenCreateModifierGroup = Token.createModifierGroup(parseRegex(), i3, i2);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return modifierTokenCreateModifierGroup;
    }

    Token processNegativelookahead() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(21, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processNegativelookbehind() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(23, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    Token processParen() throws ParseException {
        next();
        int i2 = this.parennumber;
        this.parennumber = i2 + 1;
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), i2);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    Token processParen2() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), 0);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    Token processPlus(Token token) throws ParseException {
        next();
        if (read() != 5) {
            return Token.createConcat(token, Token.createClosure(token));
        }
        next();
        return Token.createConcat(token, Token.createNGClosure(token));
    }

    Token processQuestion(Token token) throws ParseException {
        next();
        Token.UnionToken unionTokenCreateUnion = Token.createUnion();
        if (read() == 5) {
            next();
            unionTokenCreateUnion.addChild(Token.createEmpty());
            unionTokenCreateUnion.addChild(token);
        } else {
            unionTokenCreateUnion.addChild(token);
            unionTokenCreateUnion.addChild(Token.createEmpty());
        }
        return unionTokenCreateUnion;
    }

    Token processStar(Token token) throws ParseException {
        next();
        if (read() != 5) {
            return Token.createClosure(token);
        }
        next();
        return Token.createNGClosure(token);
    }

    final int read() {
        return this.nexttoken;
    }

    protected final void setContext(int i2) {
        this.context = i2;
    }

    public void setLocale(Locale locale) {
        this.resources = ResourceBundle.getBundle(BUNDLE_PKG, locale, RegexParser.class.getClassLoader());
    }

    public RegexParser(Locale locale) {
        setLocale(locale);
    }
}
