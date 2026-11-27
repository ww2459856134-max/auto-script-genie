package org.apache.xmlbeans.impl.regex;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.Chars;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes.dex */
class Token implements Serializable {
    static final int ANCHOR = 8;
    static final int BACKREFERENCE = 12;
    static final int CHAR = 0;
    static final int CHAR_FINAL_QUOTE = 30;
    static final int CHAR_INIT_QUOTE = 29;
    static final int CHAR_LETTER = 31;
    static final int CHAR_MARK = 32;
    static final int CHAR_NUMBER = 33;
    static final int CHAR_OTHER = 35;
    static final int CHAR_PUNCTUATION = 36;
    static final int CHAR_SEPARATOR = 34;
    static final int CHAR_SYMBOL = 37;
    static final int CLOSURE = 3;
    static final int CONCAT = 1;
    static final int CONDITION = 26;
    static final boolean COUNTTOKENS = true;
    static final int DOT = 11;
    static final int EMPTY = 7;
    static final int FC_ANY = 2;
    static final int FC_CONTINUE = 0;
    static final int FC_TERMINAL = 1;
    static final int INDEPENDENT = 24;
    static final int LOOKAHEAD = 20;
    static final int LOOKBEHIND = 22;
    static final int MODIFIERGROUP = 25;
    static final int NEGATIVELOOKAHEAD = 21;
    static final int NEGATIVELOOKBEHIND = 23;
    private static final int NONBMP_BLOCK_START = 84;
    static final int NONGREEDYCLOSURE = 9;
    static final int NRANGE = 5;
    static final int PAREN = 6;
    static final int RANGE = 4;
    static final int STRING = 10;
    static final int UNION = 2;
    static final int UTF16_MAX = 1114111;
    private static final String[] blockNames;
    static final String blockRanges = "\u0000\u007f\u0080ÿĀſƀɏɐʯʰ˿̀ͯͰϿЀӿ\u0530֏\u0590\u05ff\u0600ۿ܀ݏހ\u07bfऀॿঀ\u09ff\u0a00\u0a7f\u0a80૿\u0b00\u0b7f\u0b80\u0bffఀ౿ಀ\u0cffഀൿ\u0d80\u0dff\u0e00\u0e7f\u0e80\u0effༀ\u0fffက႟Ⴀჿᄀᇿሀ\u137fᎠ\u13ff᐀ᙿ\u1680\u169fᚠ\u16ffក\u17ff᠀\u18afḀỿἀ\u1fff\u2000\u206f⁰\u209f₠\u20cf⃐\u20ff℀⅏⅐\u218f←⇿∀⋿⌀⏿␀\u243f⑀\u245f①⓿─╿▀▟■◿☀⛿✀➿⠀⣿⺀\u2eff⼀\u2fdf⿰\u2fff\u3000〿\u3040ゟ゠ヿ\u3100ㄯ\u3130\u318f㆐㆟ㆠㆿ㈀㋿㌀㏿㐀䶵一鿿ꀀ\ua48f꒐\ua4cf가힣\ue000\uf8ff豈\ufaffﬀﭏﭐ﷿︠︯︰﹏﹐\ufe6fﹰ\ufefe\ufeff\ufeff\uff00\uffef";
    private static final Hashtable categories;
    private static final Hashtable categories2;
    private static final String[] categoryNames;
    static final int[] nonBMPBlockRanges;
    static Hashtable nonxs = null;
    static Token token_0to9 = null;
    private static Token token_ccs = null;
    private static Token token_grapheme = null;
    static Token token_not_0to9 = null;
    static Token token_not_spaces = null;
    static Token token_not_wordchars = null;
    static Token token_spaces = null;
    static Token token_wordchars = null;
    static int tokens = 0;
    static final String viramaString = "्্੍્୍்్್്ฺ྄";
    int type;
    static Token token_empty = new Token(7);
    static Token token_linebeginning = createAnchor(94);
    static Token token_linebeginning2 = createAnchor(64);
    static Token token_lineend = createAnchor(36);
    static Token token_stringbeginning = createAnchor(65);
    static Token token_stringend = createAnchor(122);
    static Token token_stringend2 = createAnchor(90);
    static Token token_wordedge = createAnchor(98);
    static Token token_not_wordedge = createAnchor(66);
    static Token token_wordbeginning = createAnchor(60);
    static Token token_wordend = createAnchor(62);
    static Token token_dot = new Token(11);

    static class CharToken extends Token implements Serializable {
        int chardata;

        CharToken(int i2, int i3) {
            super(i2);
            this.chardata = i3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getChar() {
            return this.chardata;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        boolean match(int i2) {
            if (this.type == 0) {
                return i2 == this.chardata;
            }
            throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i2) {
            int i3 = this.type;
            if (i3 != 0) {
                if (i3 != 8) {
                    return null;
                }
                if (this == Token.token_linebeginning || this == Token.token_lineend) {
                    return "" + ((char) this.chardata);
                }
                return "\\" + ((char) this.chardata);
            }
            int i4 = this.chardata;
            if (i4 == 9) {
                return "\\t";
            }
            if (i4 == 10) {
                return "\\n";
            }
            if (i4 == 12) {
                return "\\f";
            }
            if (i4 == 13) {
                return "\\r";
            }
            if (i4 == 27) {
                return "\\e";
            }
            if (i4 != 46 && i4 != 63 && i4 != 91 && i4 != 92 && i4 != 123 && i4 != 124) {
                switch (i4) {
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                        break;
                    default:
                        if (i4 < 65536) {
                            return "" + ((char) this.chardata);
                        }
                        String str = "0" + Integer.toHexString(this.chardata);
                        return "\\v" + str.substring(str.length() - 6, str.length());
                }
            }
            return "\\" + ((char) this.chardata);
        }
    }

    static class ClosureToken extends Token implements Serializable {
        Token child;
        int max;
        int min;

        ClosureToken(int i2, Token token) {
            super(i2);
            this.child = token;
            setMin(-1);
            setMax(-1);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i2) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final int getMax() {
            return this.max;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final int getMin() {
            return this.min;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final void setMax(int i2) {
            this.max = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final void setMin(int i2) {
            this.min = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i2) {
            if (this.type == 3) {
                if (getMin() < 0 && getMax() < 0) {
                    return this.child.toString(i2) + "*";
                }
                if (getMin() == getMax()) {
                    return this.child.toString(i2) + "{" + getMin() + "}";
                }
                if (getMin() >= 0 && getMax() >= 0) {
                    return this.child.toString(i2) + "{" + getMin() + "," + getMax() + "}";
                }
                if (getMin() < 0 || getMax() >= 0) {
                    throw new RuntimeException("Token#toString(): CLOSURE " + getMin() + ", " + getMax());
                }
                return this.child.toString(i2) + "{" + getMin() + ",}";
            }
            if (getMin() < 0 && getMax() < 0) {
                return this.child.toString(i2) + "*?";
            }
            if (getMin() == getMax()) {
                return this.child.toString(i2) + "{" + getMin() + "}?";
            }
            if (getMin() >= 0 && getMax() >= 0) {
                return this.child.toString(i2) + "{" + getMin() + "," + getMax() + "}?";
            }
            if (getMin() < 0 || getMax() >= 0) {
                throw new RuntimeException("Token#toString(): NONGREEDYCLOSURE " + getMin() + ", " + getMax());
            }
            return this.child.toString(i2) + "{" + getMin() + ",}?";
        }
    }

    static class ConcatToken extends Token implements Serializable {
        Token child;
        Token child2;

        ConcatToken(Token token, Token token2) {
            super(1);
            this.child = token;
            this.child2 = token2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i2) {
            return i2 == 0 ? this.child : this.child2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i2) {
            Token token = this.child2;
            if (token.type == 3 && token.getChild(0) == this.child) {
                return this.child.toString(i2) + "+";
            }
            Token token2 = this.child2;
            if (token2.type == 9 && token2.getChild(0) == this.child) {
                return this.child.toString(i2) + "+?";
            }
            return this.child.toString(i2) + this.child2.toString(i2);
        }
    }

    static class ConditionToken extends Token implements Serializable {
        Token condition;
        Token no;
        int refNumber;
        Token yes;

        ConditionToken(int i2, Token token, Token token2, Token token3) {
            super(26);
            this.refNumber = i2;
            this.condition = token;
            this.yes = token2;
            this.no = token3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i2) {
            if (i2 == 0) {
                return this.yes;
            }
            if (i2 == 1) {
                return this.no;
            }
            throw new RuntimeException("Internal Error: " + i2);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return this.no == null ? 1 : 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i2) {
            String str;
            if (this.refNumber > 0) {
                str = "(?(" + this.refNumber + ")";
            } else if (this.condition.type == 8) {
                str = "(?(" + this.condition + ")";
            } else {
                str = "(?" + this.condition;
            }
            if (this.no == null) {
                return str + this.yes + ")";
            }
            return str + this.yes + "|" + this.no + ")";
        }
    }

    static class FixedStringContainer {
        Token token = null;
        int options = 0;

        FixedStringContainer() {
        }
    }

    static class ModifierToken extends Token implements Serializable {
        int add;
        Token child;
        int mask;

        ModifierToken(Token token, int i2, int i3) {
            super(25);
            this.child = token;
            this.add = i2;
            this.mask = i3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i2) {
            return this.child;
        }

        int getOptions() {
            return this.add;
        }

        int getOptionsMask() {
            return this.mask;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("(?");
            int i3 = this.add;
            sb.append(i3 == 0 ? "" : REUtil.createOptionString(i3));
            int i4 = this.mask;
            sb.append(i4 != 0 ? REUtil.createOptionString(i4) : "");
            sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            sb.append(this.child.toString(i2));
            sb.append(")");
            return sb.toString();
        }
    }

    static class ParenToken extends Token implements Serializable {
        Token child;
        int parennumber;

        ParenToken(int i2, Token token, int i3) {
            super(i2);
            this.child = token;
            this.parennumber = i3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i2) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getParenNumber() {
            return this.parennumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i2) {
            int i3 = this.type;
            if (i3 == 6) {
                if (this.parennumber == 0) {
                    return "(?:" + this.child.toString(i2) + ")";
                }
                return "(" + this.child.toString(i2) + ")";
            }
            switch (i3) {
                case 20:
                    return "(?=" + this.child.toString(i2) + ")";
                case 21:
                    return "(?!" + this.child.toString(i2) + ")";
                case 22:
                    return "(?<=" + this.child.toString(i2) + ")";
                case 23:
                    return "(?<!" + this.child.toString(i2) + ")";
                case 24:
                    return "(?>" + this.child.toString(i2) + ")";
                default:
                    return null;
            }
        }
    }

    static class StringToken extends Token implements Serializable {
        int refNumber;
        String string;

        StringToken(int i2, String str, int i3) {
            super(i2);
            this.string = str;
            this.refNumber = i3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getReferenceNumber() {
            return this.refNumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        String getString() {
            return this.string;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i2) {
            if (this.type != 12) {
                return REUtil.quoteMeta(this.string);
            }
            return "\\" + this.refNumber;
        }
    }

    static class UnionToken extends Token implements Serializable {
        Vector children;

        UnionToken(int i2) {
            super(i2);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        void addChild(Token token) {
            int i2;
            StringBuilder sb;
            if (token == null) {
                return;
            }
            if (this.children == null) {
                this.children = new Vector();
            }
            if (this.type == 2) {
                this.children.addElement(token);
                return;
            }
            if (token.type == 1) {
                for (int i3 = 0; i3 < token.size(); i3++) {
                    addChild(token.getChild(i3));
                }
                return;
            }
            int size = this.children.size();
            if (size == 0) {
                this.children.addElement(token);
                return;
            }
            int i4 = size - 1;
            Token tokenCreateString = (Token) this.children.elementAt(i4);
            int i5 = tokenCreateString.type;
            if ((i5 != 0 && i5 != 10) || ((i2 = token.type) != 0 && i2 != 10)) {
                this.children.addElement(token);
                return;
            }
            int length = i2 == 0 ? 2 : token.getString().length();
            if (tokenCreateString.type == 0) {
                sb = new StringBuilder(length + 2);
                int i6 = tokenCreateString.getChar();
                if (i6 >= 65536) {
                    sb.append(REUtil.decomposeToSurrogates(i6));
                } else {
                    sb.append((char) i6);
                }
                tokenCreateString = Token.createString(null);
                this.children.setElementAt(tokenCreateString, i4);
            } else {
                sb = new StringBuilder(tokenCreateString.getString().length() + length);
                sb.append(tokenCreateString.getString());
            }
            if (token.type == 0) {
                int i7 = token.getChar();
                if (i7 >= 65536) {
                    sb.append(REUtil.decomposeToSurrogates(i7));
                } else {
                    sb.append((char) i7);
                }
            } else {
                sb.append(token.getString());
            }
            ((StringToken) tokenCreateString).string = new String(sb);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i2) {
            return (Token) this.children.elementAt(i2);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            Vector vector = this.children;
            if (vector == null) {
                return 0;
            }
            return vector.size();
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i2) {
            if (this.type != 1) {
                if (this.children.size() == 2 && getChild(1).type == 7) {
                    return getChild(0).toString(i2) + "?";
                }
                if (this.children.size() == 2 && getChild(0).type == 7) {
                    return getChild(1).toString(i2) + "??";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(((Token) this.children.elementAt(0)).toString(i2));
                for (int i3 = 1; i3 < this.children.size(); i3++) {
                    sb.append('|');
                    sb.append(((Token) this.children.elementAt(i3)).toString(i2));
                }
                return new String(sb);
            }
            if (this.children.size() != 2) {
                StringBuilder sb2 = new StringBuilder();
                for (int i4 = 0; i4 < this.children.size(); i4++) {
                    sb2.append(((Token) this.children.elementAt(i4)).toString(i2));
                }
                return new String(sb2);
            }
            Token child = getChild(0);
            Token child2 = getChild(1);
            if (child2.type == 3 && child2.getChild(0) == child) {
                return child.toString(i2) + "+";
            }
            if (child2.type == 9 && child2.getChild(0) == child) {
                return child.toString(i2) + "+?";
            }
            return child.toString(i2) + child2.toString(i2);
        }
    }

    static {
        RangeToken rangeTokenCreateRange = createRange();
        token_0to9 = rangeTokenCreateRange;
        rangeTokenCreateRange.addRange(48, 57);
        RangeToken rangeTokenCreateRange2 = createRange();
        token_wordchars = rangeTokenCreateRange2;
        rangeTokenCreateRange2.addRange(48, 57);
        token_wordchars.addRange(65, 90);
        token_wordchars.addRange(95, 95);
        token_wordchars.addRange(97, 122);
        RangeToken rangeTokenCreateRange3 = createRange();
        token_spaces = rangeTokenCreateRange3;
        rangeTokenCreateRange3.addRange(9, 9);
        token_spaces.addRange(10, 10);
        token_spaces.addRange(12, 12);
        token_spaces.addRange(13, 13);
        token_spaces.addRange(32, 32);
        token_not_0to9 = complementRanges(token_0to9);
        token_not_wordchars = complementRanges(token_wordchars);
        token_not_spaces = complementRanges(token_spaces);
        categories = new Hashtable();
        categories2 = new Hashtable();
        categoryNames = new String[]{"Cn", "Lu", "Ll", "Lt", "Lm", "Lo", "Mn", "Me", "Mc", "Nd", "Nl", "No", "Zs", "Zl", "Zp", "Cc", "Cf", null, "Co", "Cs", "Pd", "Ps", "Pe", "Pc", "Po", "Sm", "Sc", "Sk", "So", "Pi", "Pf", "L", "M", "N", "Z", "C", "P", "S"};
        blockNames = new String[]{"Basic Latin", "Latin-1 Supplement", "Latin Extended-A", "Latin Extended-B", "IPA Extensions", "Spacing Modifier Letters", "Combining Diacritical Marks", "Greek", "Cyrillic", "Armenian", "Hebrew", "Arabic", "Syriac", "Thaana", "Devanagari", "Bengali", "Gurmukhi", "Gujarati", "Oriya", "Tamil", "Telugu", "Kannada", "Malayalam", "Sinhala", "Thai", "Lao", "Tibetan", "Myanmar", "Georgian", "Hangul Jamo", "Ethiopic", "Cherokee", "Unified Canadian Aboriginal Syllabics", "Ogham", "Runic", "Khmer", "Mongolian", "Latin Extended Additional", "Greek Extended", "General Punctuation", "Superscripts and Subscripts", "Currency Symbols", "Combining Marks for Symbols", "Letterlike Symbols", "Number Forms", "Arrows", "Mathematical Operators", "Miscellaneous Technical", "Control Pictures", "Optical Character Recognition", "Enclosed Alphanumerics", "Box Drawing", "Block Elements", "Geometric Shapes", "Miscellaneous Symbols", "Dingbats", "Braille Patterns", "CJK Radicals Supplement", "Kangxi Radicals", "Ideographic Description Characters", "CJK Symbols and Punctuation", "Hiragana", "Katakana", "Bopomofo", "Hangul Compatibility Jamo", "Kanbun", "Bopomofo Extended", "Enclosed CJK Letters and Months", "CJK Compatibility", "CJK Unified Ideographs Extension A", "CJK Unified Ideographs", "Yi Syllables", "Yi Radicals", "Hangul Syllables", "Private Use", "CJK Compatibility Ideographs", "Alphabetic Presentation Forms", "Arabic Presentation Forms-A", "Combining Half Marks", "CJK Compatibility Forms", "Small Form Variants", "Arabic Presentation Forms-B", "Specials", "Halfwidth and Fullwidth Forms", "Old Italic", "Gothic", "Deseret", "Byzantine Musical Symbols", "Musical Symbols", "Mathematical Alphanumeric Symbols", "CJK Unified Ideographs Extension B", "CJK Compatibility Ideographs Supplement", "Tags"};
        nonBMPBlockRanges = new int[]{66304, 66351, 66352, 66383, 66560, 66639, 118784, 119039, 119040, 119295, 119808, 120831, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 173782, 194560, 195103, 917504, 917631};
        nonxs = null;
        token_grapheme = null;
        token_ccs = null;
    }

    protected Token(int i2) {
        this.type = i2;
    }

    static Token complementRanges(Token token) {
        return RangeToken.complementRanges(token);
    }

    private static CharToken createAnchor(int i2) {
        tokens++;
        return new CharToken(8, i2);
    }

    static StringToken createBackReference(int i2) {
        tokens++;
        return new StringToken(12, null, i2);
    }

    static CharToken createChar(int i2) {
        tokens++;
        return new CharToken(0, i2);
    }

    static ClosureToken createClosure(Token token) {
        tokens++;
        return new ClosureToken(3, token);
    }

    static ConcatToken createConcat(Token token, Token token2) {
        tokens++;
        return new ConcatToken(token, token2);
    }

    static ConditionToken createCondition(int i2, Token token, Token token2, Token token3) {
        tokens++;
        return new ConditionToken(i2, token, token2, token3);
    }

    static Token createEmpty() {
        return token_empty;
    }

    static ParenToken createLook(int i2, Token token) {
        tokens++;
        return new ParenToken(i2, token, 0);
    }

    static ModifierToken createModifierGroup(Token token, int i2, int i3) {
        tokens++;
        return new ModifierToken(token, i2, i3);
    }

    static ClosureToken createNGClosure(Token token) {
        tokens++;
        return new ClosureToken(9, token);
    }

    static RangeToken createNRange() {
        tokens++;
        return new RangeToken(5);
    }

    static ParenToken createParen(Token token, int i2) {
        tokens++;
        return new ParenToken(6, token, i2);
    }

    static RangeToken createRange() {
        tokens++;
        return new RangeToken(4);
    }

    static StringToken createString(String str) {
        tokens++;
        return new StringToken(10, str, 0);
    }

    static UnionToken createUnion() {
        tokens++;
        return new UnionToken(2);
    }

    static synchronized Token getCombiningCharacterSequence() {
        Token token = token_ccs;
        if (token != null) {
            return token;
        }
        ConcatToken concatTokenCreateConcat = createConcat(getRange("M", false), createClosure(getRange("M", true)));
        token_ccs = concatTokenCreateConcat;
        return concatTokenCreateConcat;
    }

    static synchronized Token getGraphemePattern() {
        Token token = token_grapheme;
        if (token != null) {
            return token;
        }
        RangeToken rangeTokenCreateRange = createRange();
        rangeTokenCreateRange.mergeRanges(getRange("ASSIGNED", true));
        rangeTokenCreateRange.subtractRanges(getRange("M", true));
        rangeTokenCreateRange.subtractRanges(getRange("C", true));
        RangeToken rangeTokenCreateRange2 = createRange();
        for (int i2 = 0; i2 < 11; i2++) {
            viramaString.charAt(i2);
            rangeTokenCreateRange2.addRange(i2, i2);
        }
        RangeToken rangeTokenCreateRange3 = createRange();
        rangeTokenCreateRange3.mergeRanges(getRange("M", true));
        rangeTokenCreateRange3.addRange(4448, 4607);
        rangeTokenCreateRange3.addRange(65438, 65439);
        UnionToken unionTokenCreateUnion = createUnion();
        unionTokenCreateUnion.addChild(rangeTokenCreateRange);
        unionTokenCreateUnion.addChild(token_empty);
        UnionToken unionTokenCreateUnion2 = createUnion();
        unionTokenCreateUnion2.addChild(createConcat(rangeTokenCreateRange2, getRange("L", true)));
        unionTokenCreateUnion2.addChild(rangeTokenCreateRange3);
        ConcatToken concatTokenCreateConcat = createConcat(unionTokenCreateUnion, createClosure(unionTokenCreateUnion2));
        token_grapheme = concatTokenCreateConcat;
        return concatTokenCreateConcat;
    }

    protected static RangeToken getRange(String str, boolean z) {
        Hashtable hashtable = categories;
        if (hashtable.isEmpty()) {
            synchronized (hashtable) {
                int length = categoryNames.length;
                Token[] tokenArr = new Token[length];
                for (int i2 = 0; i2 < length; i2++) {
                    tokenArr[i2] = createRange();
                }
                int i3 = 0;
                while (true) {
                    char c = Chars.DQUOTE;
                    if (i3 < 65536) {
                        int type = Character.getType((char) i3);
                        if (type == 21 || type == 22) {
                            if (i3 == 171 || i3 == 8216 || i3 == 8219 || i3 == 8220 || i3 == 8223 || i3 == 8249) {
                                type = 29;
                            }
                            if (i3 == 187 || i3 == 8217 || i3 == 8221 || i3 == 8250) {
                                type = 30;
                            }
                        }
                        tokenArr[type].addRange(i3, i3);
                        switch (type) {
                            case 0:
                            case 15:
                            case 16:
                            case 18:
                            case 19:
                                c = '#';
                                break;
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                c = 31;
                                break;
                            case 6:
                            case 7:
                            case 8:
                                c = ' ';
                                break;
                            case 9:
                            case 10:
                            case 11:
                                c = '!';
                                break;
                            case 12:
                            case 13:
                            case 14:
                                break;
                            case 17:
                            default:
                                throw new RuntimeException("org.apache.xerces.utils.regex.Token#getRange(): Unknown Unicode category: " + type);
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 29:
                            case 30:
                                c = '$';
                                break;
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                                c = '%';
                                break;
                        }
                        tokenArr[c].addRange(i3, i3);
                        i3++;
                    } else {
                        tokenArr[0].addRange(WXMediaMessage.THUMB_LENGTH_LIMIT, UTF16_MAX);
                        for (int i4 = 0; i4 < length; i4++) {
                            String[] strArr = categoryNames;
                            if (strArr[i4] != null) {
                                if (i4 == 0) {
                                    tokenArr[i4].addRange(WXMediaMessage.THUMB_LENGTH_LIMIT, UTF16_MAX);
                                }
                                categories.put(strArr[i4], tokenArr[i4]);
                                categories2.put(strArr[i4], complementRanges(tokenArr[i4]));
                            }
                        }
                        StringBuilder sb = new StringBuilder(50);
                        int i5 = 0;
                        while (true) {
                            String[] strArr2 = blockNames;
                            if (i5 < strArr2.length) {
                                RangeToken rangeTokenCreateRange = createRange();
                                if (i5 < 84) {
                                    int i6 = i5 * 2;
                                    rangeTokenCreateRange.addRange(blockRanges.charAt(i6), blockRanges.charAt(i6 + 1));
                                } else {
                                    int i7 = (i5 - 84) * 2;
                                    int[] iArr = nonBMPBlockRanges;
                                    rangeTokenCreateRange.addRange(iArr[i7], iArr[i7 + 1]);
                                }
                                String str2 = strArr2[i5];
                                if (str2.equals("Specials")) {
                                    rangeTokenCreateRange.addRange(65520, 65533);
                                }
                                if (str2.equals("Private Use")) {
                                    rangeTokenCreateRange.addRange(983040, 1048573);
                                    rangeTokenCreateRange.addRange(1048576, 1114109);
                                }
                                categories.put(str2, rangeTokenCreateRange);
                                categories2.put(str2, complementRanges(rangeTokenCreateRange));
                                sb.setLength(0);
                                sb.append("Is");
                                if (str2.indexOf(32) >= 0) {
                                    for (int i8 = 0; i8 < str2.length(); i8++) {
                                        if (str2.charAt(i8) != ' ') {
                                            sb.append(str2.charAt(i8));
                                        }
                                    }
                                } else {
                                    sb.append(str2);
                                }
                                setAlias(sb.toString(), str2, true);
                                i5++;
                            } else {
                                setAlias("ASSIGNED", "Cn", false);
                                setAlias("UNASSIGNED", "Cn", true);
                                RangeToken rangeTokenCreateRange2 = createRange();
                                rangeTokenCreateRange2.addRange(0, UTF16_MAX);
                                Hashtable hashtable2 = categories;
                                hashtable2.put("ALL", rangeTokenCreateRange2);
                                Hashtable hashtable3 = categories2;
                                hashtable3.put("ALL", complementRanges(rangeTokenCreateRange2));
                                registerNonXS("ASSIGNED");
                                registerNonXS("UNASSIGNED");
                                registerNonXS("ALL");
                                RangeToken rangeTokenCreateRange3 = createRange();
                                rangeTokenCreateRange3.mergeRanges(tokenArr[1]);
                                rangeTokenCreateRange3.mergeRanges(tokenArr[2]);
                                rangeTokenCreateRange3.mergeRanges(tokenArr[5]);
                                hashtable2.put("IsAlpha", rangeTokenCreateRange3);
                                hashtable3.put("IsAlpha", complementRanges(rangeTokenCreateRange3));
                                registerNonXS("IsAlpha");
                                RangeToken rangeTokenCreateRange4 = createRange();
                                rangeTokenCreateRange4.mergeRanges(rangeTokenCreateRange3);
                                rangeTokenCreateRange4.mergeRanges(tokenArr[9]);
                                hashtable2.put("IsAlnum", rangeTokenCreateRange4);
                                hashtable3.put("IsAlnum", complementRanges(rangeTokenCreateRange4));
                                registerNonXS("IsAlnum");
                                RangeToken rangeTokenCreateRange5 = createRange();
                                rangeTokenCreateRange5.mergeRanges(token_spaces);
                                rangeTokenCreateRange5.mergeRanges(tokenArr[34]);
                                hashtable2.put("IsSpace", rangeTokenCreateRange5);
                                hashtable3.put("IsSpace", complementRanges(rangeTokenCreateRange5));
                                registerNonXS("IsSpace");
                                RangeToken rangeTokenCreateRange6 = createRange();
                                rangeTokenCreateRange6.mergeRanges(rangeTokenCreateRange4);
                                rangeTokenCreateRange6.addRange(95, 95);
                                hashtable2.put("IsWord", rangeTokenCreateRange6);
                                hashtable3.put("IsWord", complementRanges(rangeTokenCreateRange6));
                                registerNonXS("IsWord");
                                RangeToken rangeTokenCreateRange7 = createRange();
                                rangeTokenCreateRange7.addRange(0, 127);
                                hashtable2.put("IsASCII", rangeTokenCreateRange7);
                                hashtable3.put("IsASCII", complementRanges(rangeTokenCreateRange7));
                                registerNonXS("IsASCII");
                                RangeToken rangeTokenCreateRange8 = createRange();
                                rangeTokenCreateRange8.mergeRanges(tokenArr[35]);
                                rangeTokenCreateRange8.addRange(32, 32);
                                hashtable2.put("IsGraph", complementRanges(rangeTokenCreateRange8));
                                hashtable3.put("IsGraph", rangeTokenCreateRange8);
                                registerNonXS("IsGraph");
                                RangeToken rangeTokenCreateRange9 = createRange();
                                rangeTokenCreateRange9.addRange(48, 57);
                                rangeTokenCreateRange9.addRange(65, 70);
                                rangeTokenCreateRange9.addRange(97, 102);
                                hashtable2.put("IsXDigit", complementRanges(rangeTokenCreateRange9));
                                hashtable3.put("IsXDigit", rangeTokenCreateRange9);
                                registerNonXS("IsXDigit");
                                setAlias("IsDigit", "Nd", true);
                                setAlias("IsUpper", "Lu", true);
                                setAlias("IsLower", "Ll", true);
                                setAlias("IsCntrl", "C", true);
                                setAlias("IsPrint", "C", false);
                                setAlias("IsPunct", "P", true);
                                registerNonXS("IsDigit");
                                registerNonXS("IsUpper");
                                registerNonXS("IsLower");
                                registerNonXS("IsCntrl");
                                registerNonXS("IsPrint");
                                registerNonXS("IsPunct");
                                setAlias("alpha", "IsAlpha", true);
                                setAlias("alnum", "IsAlnum", true);
                                setAlias("ascii", "IsASCII", true);
                                setAlias("cntrl", "IsCntrl", true);
                                setAlias("digit", "IsDigit", true);
                                setAlias("graph", "IsGraph", true);
                                setAlias("lower", "IsLower", true);
                                setAlias("print", "IsPrint", true);
                                setAlias("punct", "IsPunct", true);
                                setAlias("space", "IsSpace", true);
                                setAlias("upper", "IsUpper", true);
                                setAlias("word", "IsWord", true);
                                setAlias("xdigit", "IsXDigit", true);
                                registerNonXS("alpha");
                                registerNonXS("alnum");
                                registerNonXS("ascii");
                                registerNonXS("cntrl");
                                registerNonXS("digit");
                                registerNonXS("graph");
                                registerNonXS("lower");
                                registerNonXS("print");
                                registerNonXS("punct");
                                registerNonXS("space");
                                registerNonXS("upper");
                                registerNonXS("word");
                                registerNonXS("xdigit");
                            }
                        }
                    }
                }
            }
        }
        return z ? (RangeToken) categories.get(str) : (RangeToken) categories2.get(str);
    }

    protected static boolean isRegisterNonXS(String str) {
        Hashtable hashtable = nonxs;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str);
    }

    private static final boolean isSet(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    private final boolean isShorterThan(Token token) {
        if (token == null) {
            return false;
        }
        if (this.type != 10) {
            throw new RuntimeException("Internal Error: Illegal type: " + this.type);
        }
        int length = getString().length();
        if (token.type == 10) {
            return length < token.getString().length();
        }
        throw new RuntimeException("Internal Error: Illegal type: " + token.type);
    }

    protected static void registerNonXS(String str) {
        if (nonxs == null) {
            nonxs = new Hashtable();
        }
        nonxs.put(str, str);
    }

    private static void setAlias(String str, String str2, boolean z) {
        Hashtable hashtable = categories;
        Token token = (Token) hashtable.get(str2);
        Hashtable hashtable2 = categories2;
        Token token2 = (Token) hashtable2.get(str2);
        if (z) {
            hashtable.put(str, token);
            hashtable2.put(str, token2);
        } else {
            hashtable2.put(str, token);
            hashtable.put(str, token2);
        }
    }

    void addChild(Token token) {
        throw new RuntimeException("Not supported.");
    }

    protected void addRange(int i2, int i3) {
        throw new RuntimeException("Not supported.");
    }

    final int analyzeFirstCharacter(RangeToken rangeToken, int i2) {
        int i3 = this.type;
        switch (i3) {
            case 0:
                int i4 = getChar();
                rangeToken.addRange(i4, i4);
                if (i4 < 65536 && isSet(i2, 2)) {
                    char upperCase = Character.toUpperCase((char) i4);
                    rangeToken.addRange(upperCase, upperCase);
                    char lowerCase = Character.toLowerCase(upperCase);
                    rangeToken.addRange(lowerCase, lowerCase);
                }
                return 1;
            case 1:
                int iAnalyzeFirstCharacter = 0;
                for (int i5 = 0; i5 < size() && (iAnalyzeFirstCharacter = getChild(i5).analyzeFirstCharacter(rangeToken, i2)) == 0; i5++) {
                }
                return iAnalyzeFirstCharacter;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                int iAnalyzeFirstCharacter2 = 0;
                boolean z = false;
                for (int i6 = 0; i6 < size() && (iAnalyzeFirstCharacter2 = getChild(i6).analyzeFirstCharacter(rangeToken, i2)) != 2; i6++) {
                    if (iAnalyzeFirstCharacter2 == 0) {
                        z = true;
                    }
                }
                if (z) {
                    return 0;
                }
                return iAnalyzeFirstCharacter2;
            case 3:
            case 9:
                getChild(0).analyzeFirstCharacter(rangeToken, i2);
                return 0;
            case 4:
                if (isSet(i2, 2)) {
                    rangeToken.mergeRanges(((RangeToken) this).getCaseInsensitiveToken());
                } else {
                    rangeToken.mergeRanges(this);
                }
                return 1;
            case 5:
                if (isSet(i2, 2)) {
                    rangeToken.mergeRanges(complementRanges(((RangeToken) this).getCaseInsensitiveToken()));
                } else {
                    rangeToken.mergeRanges(complementRanges(this));
                }
                return 1;
            case 6:
                break;
            case 7:
            case 8:
                return 0;
            case 10:
                int iCharAt = getString().charAt(0);
                if (REUtil.isHighSurrogate(iCharAt) && getString().length() >= 2) {
                    char cCharAt = getString().charAt(1);
                    if (REUtil.isLowSurrogate(cCharAt)) {
                        iCharAt = REUtil.composeFromSurrogates(iCharAt, cCharAt);
                    }
                }
                rangeToken.addRange(iCharAt, iCharAt);
                if (iCharAt < 65536 && isSet(i2, 2)) {
                    char upperCase2 = Character.toUpperCase((char) iCharAt);
                    rangeToken.addRange(upperCase2, upperCase2);
                    char lowerCase2 = Character.toLowerCase(upperCase2);
                    rangeToken.addRange(lowerCase2, lowerCase2);
                }
                return 1;
            case 11:
                if (isSet(i2, 4)) {
                }
                return 0;
            case 12:
                rangeToken.addRange(0, UTF16_MAX);
                return 2;
            default:
                switch (i3) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        return 0;
                    case 24:
                        break;
                    case 25:
                        ModifierToken modifierToken = (ModifierToken) this;
                        return getChild(0).analyzeFirstCharacter(rangeToken, (i2 | modifierToken.getOptions()) & (~modifierToken.getOptionsMask()));
                    case 26:
                        int iAnalyzeFirstCharacter3 = getChild(0).analyzeFirstCharacter(rangeToken, i2);
                        if (size() == 1) {
                            return 0;
                        }
                        if (iAnalyzeFirstCharacter3 == 2) {
                            return iAnalyzeFirstCharacter3;
                        }
                        int iAnalyzeFirstCharacter4 = getChild(1).analyzeFirstCharacter(rangeToken, i2);
                        return iAnalyzeFirstCharacter4 == 2 ? iAnalyzeFirstCharacter4 : (iAnalyzeFirstCharacter3 == 0 || iAnalyzeFirstCharacter4 == 0) ? 0 : 1;
                    default:
                        throw new RuntimeException("Token#analyzeHeadCharacter(): Invalid Type: " + this.type);
                }
        }
        return getChild(0).analyzeFirstCharacter(rangeToken, i2);
    }

    protected void compactRanges() {
        throw new RuntimeException("Not supported.");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void findFixedString(FixedStringContainer fixedStringContainer, int i2) {
        int i3 = this.type;
        Token token = null;
        switch (i3) {
            case 0:
                fixedStringContainer.token = null;
                return;
            case 1:
                int i4 = 0;
                for (int i5 = 0; i5 < size(); i5++) {
                    getChild(i5).findFixedString(fixedStringContainer, i2);
                    if (token == null || token.isShorterThan(fixedStringContainer.token)) {
                        token = fixedStringContainer.token;
                        i4 = fixedStringContainer.options;
                    }
                }
                fixedStringContainer.token = token;
                fixedStringContainer.options = i4;
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
                fixedStringContainer.token = null;
                return;
            case 6:
                getChild(0).findFixedString(fixedStringContainer, i2);
                return;
            case 10:
                fixedStringContainer.token = this;
                fixedStringContainer.options = i2;
                return;
            default:
                switch (i3) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 26:
                        break;
                    case 24:
                        break;
                    case 25:
                        ModifierToken modifierToken = (ModifierToken) this;
                        getChild(0).findFixedString(fixedStringContainer, (i2 | modifierToken.getOptions()) & (~modifierToken.getOptionsMask()));
                        return;
                    default:
                        throw new RuntimeException("Token#findFixedString(): Invalid Type: " + this.type);
                }
        }
    }

    int getChar() {
        return -1;
    }

    Token getChild(int i2) {
        return null;
    }

    int getMax() {
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int getMaxLength() {
        int i2 = this.type;
        switch (i2) {
            case 0:
                return 1;
            case 1:
                int i3 = 0;
                for (int i4 = 0; i4 < size(); i4++) {
                    int maxLength = getChild(i4).getMaxLength();
                    if (maxLength < 0) {
                        return -1;
                    }
                    i3 += maxLength;
                }
                return i3;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                int maxLength2 = getChild(0).getMaxLength();
                for (int i5 = 1; maxLength2 >= 0 && i5 < size(); i5++) {
                    int maxLength3 = getChild(i5).getMaxLength();
                    if (maxLength3 < 0) {
                        return -1;
                    }
                    if (maxLength3 > maxLength2) {
                        maxLength2 = maxLength3;
                    }
                }
                return maxLength2;
            case 3:
            case 9:
                if (getMax() >= 0) {
                    return getMax() * getChild(0).getMaxLength();
                }
                return -1;
            case 4:
            case 5:
            case 11:
                return 2;
            case 6:
                return getChild(0).getMaxLength();
            case 7:
            case 8:
                return 0;
            case 10:
                return getString().length();
            case 12:
                return -1;
            default:
                switch (i2) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        return 0;
                    case 24:
                    case 25:
                        break;
                    case 26:
                        break;
                    default:
                        throw new RuntimeException("Token#getMaxLength(): Invalid Type: " + this.type);
                }
        }
    }

    int getMin() {
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int getMinLength() {
        int i2 = this.type;
        switch (i2) {
            case 0:
            case 4:
            case 5:
            case 11:
                return 1;
            case 1:
                int minLength = 0;
                for (int i3 = 0; i3 < size(); i3++) {
                    minLength += getChild(i3).getMinLength();
                }
                return minLength;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                int minLength2 = getChild(0).getMinLength();
                for (int i4 = 1; i4 < size(); i4++) {
                    int minLength3 = getChild(i4).getMinLength();
                    if (minLength3 < minLength2) {
                        minLength2 = minLength3;
                    }
                }
                return minLength2;
            case 3:
            case 9:
                if (getMin() >= 0) {
                    return getMin() * getChild(0).getMinLength();
                }
                return 0;
            case 6:
                return getChild(0).getMinLength();
            case 7:
            case 8:
                return 0;
            case 10:
                return getString().length();
            case 12:
                return 0;
            default:
                switch (i2) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    case 24:
                    case 25:
                        break;
                    case 26:
                        break;
                    default:
                        throw new RuntimeException("Token#getMinLength(): Invalid Type: " + this.type);
                }
        }
    }

    int getParenNumber() {
        return 0;
    }

    int getReferenceNumber() {
        return 0;
    }

    String getString() {
        return null;
    }

    protected void intersectRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    boolean match(int i2) {
        throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type);
    }

    protected void mergeRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    void setMax(int i2) {
    }

    void setMin(int i2) {
    }

    int size() {
        return 0;
    }

    protected void sortRanges() {
        throw new RuntimeException("Not supported.");
    }

    protected void subtractRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i2) {
        return this.type == 11 ? "." : "";
    }

    static UnionToken createConcat() {
        tokens++;
        return new UnionToken(1);
    }

    protected static RangeToken getRange(String str, boolean z, boolean z2) {
        RangeToken range = getRange(str, z);
        if (z2 && range != null && isRegisterNonXS(str)) {
            return null;
        }
        return range;
    }
}
