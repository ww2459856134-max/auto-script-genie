package org.apache.xmlbeans.impl.regex;

import java.util.Hashtable;
import java.util.Locale;
import org.apache.xmlbeans.impl.regex.Token;

/* loaded from: classes.dex */
class ParserForXMLSchema extends RegexParser {
    private static final String DIGITS = "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩";
    private static final String LETTERS = "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣";
    private static final String NAMECHARS = "-.0:AZ__az··ÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁːˑ̀͠͡ͅΆΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁ҃҆ҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆֹֻֽֿֿׁׂ֑֣֡ׄׄאתװײءغـْ٠٩ٰڷںھۀێېۓە۪ۭۨ۰۹ँःअह़्॑॔क़ॣ०९ঁঃঅঌএঐওনপরললশহ়়াৄেৈো্ৗৗড়ঢ়য়ৣ০ৱਂਂਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹ਼਼ਾੂੇੈੋ੍ਖ਼ੜਫ਼ਫ਼੦ੴઁઃઅઋઍઍએઑઓનપરલળવહ઼ૅેૉો્ૠૠ૦૯ଁଃଅଌଏଐଓନପରଲଳଶହ଼ୃେୈୋ୍ୖୗଡ଼ଢ଼ୟୡ୦୯ஂஃஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹாூெைொ்ௗௗ௧௯ఁఃఅఌఎఐఒనపళవహాౄెైొ్ౕౖౠౡ౦౯ಂಃಅಌಎಐಒನಪಳವಹಾೄೆೈೊ್ೕೖೞೞೠೡ೦೯ംഃഅഌഎഐഒനപഹാൃെൈൊ്ൗൗൠൡ൦൯กฮะฺเ๎๐๙ກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະູົຽເໄໆໆ່ໍ໐໙༘༙༠༩༹༹༵༵༷༷༾ཇཉཀྵ྄ཱ྆ྋྐྕྗྗྙྭྱྷྐྵྐྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼ⃐⃜⃡⃡ΩΩKÅ℮℮ↀↂ々々〇〇〡〯〱〵ぁゔ゙゚ゝゞァヺーヾㄅㄬ一龥가힣";
    private static final String SPACES = "\t\n\r\r  ";
    private static Hashtable ranges;
    private static Hashtable ranges2;

    public ParserForXMLSchema() {
    }

    protected static synchronized RangeToken getRange(String str, boolean z) {
        if (ranges == null) {
            ranges = new Hashtable();
            ranges2 = new Hashtable();
            RangeToken rangeTokenCreateRange = Token.createRange();
            setupRange(rangeTokenCreateRange, SPACES);
            ranges.put("xml:isSpace", rangeTokenCreateRange);
            ranges2.put("xml:isSpace", Token.complementRanges(rangeTokenCreateRange));
            RangeToken rangeTokenCreateRange2 = Token.createRange();
            setupRange(rangeTokenCreateRange2, DIGITS);
            ranges.put("xml:isDigit", rangeTokenCreateRange2);
            ranges2.put("xml:isDigit", Token.complementRanges(rangeTokenCreateRange2));
            RangeToken rangeTokenCreateRange3 = Token.createRange();
            setupRange(rangeTokenCreateRange3, DIGITS);
            ranges.put("xml:isDigit", rangeTokenCreateRange3);
            ranges2.put("xml:isDigit", Token.complementRanges(rangeTokenCreateRange3));
            RangeToken rangeTokenCreateRange4 = Token.createRange();
            setupRange(rangeTokenCreateRange4, LETTERS);
            rangeTokenCreateRange4.mergeRanges((Token) ranges.get("xml:isDigit"));
            ranges.put("xml:isWord", rangeTokenCreateRange4);
            ranges2.put("xml:isWord", Token.complementRanges(rangeTokenCreateRange4));
            RangeToken rangeTokenCreateRange5 = Token.createRange();
            setupRange(rangeTokenCreateRange5, NAMECHARS);
            ranges.put("xml:isNameChar", rangeTokenCreateRange5);
            ranges2.put("xml:isNameChar", Token.complementRanges(rangeTokenCreateRange5));
            RangeToken rangeTokenCreateRange6 = Token.createRange();
            setupRange(rangeTokenCreateRange6, LETTERS);
            rangeTokenCreateRange6.addRange(95, 95);
            rangeTokenCreateRange6.addRange(58, 58);
            ranges.put("xml:isInitialNameChar", rangeTokenCreateRange6);
            ranges2.put("xml:isInitialNameChar", Token.complementRanges(rangeTokenCreateRange6));
        }
        return z ? (RangeToken) ranges.get(str) : (RangeToken) ranges2.get(str);
    }

    static void setupRange(Token token, String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2 += 2) {
            token.addRange(str.charAt(i2), str.charAt(i2 + 1));
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    boolean checkQuestion(int i2) {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    int decodeEscaped() throws ParseException {
        if (read() != 10) {
            throw ex("parser.next.1", this.offset - 1);
        }
        int i2 = this.chardata;
        if (i2 != 45 && i2 != 46 && i2 != 63) {
            if (i2 == 110) {
                return 10;
            }
            if (i2 == 114) {
                return 13;
            }
            if (i2 == 116) {
                return 9;
            }
            switch (i2) {
                case 40:
                case 41:
                case 42:
                case 43:
                    break;
                default:
                    switch (i2) {
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                            break;
                        default:
                            switch (i2) {
                                case 123:
                                case 124:
                                case 125:
                                    break;
                                default:
                                    throw ex("parser.process.1", this.offset - 2);
                            }
                    }
            }
        }
        return i2;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token getTokenForShorthand(int i2) {
        if (i2 == 67) {
            return getRange("xml:isNameChar", false);
        }
        if (i2 == 68) {
            return getRange("xml:isDigit", false);
        }
        if (i2 == 73) {
            return getRange("xml:isInitialNameChar", false);
        }
        if (i2 == 83) {
            return getRange("xml:isSpace", false);
        }
        if (i2 == 87) {
            return getRange("xml:isWord", false);
        }
        if (i2 == 105) {
            return getRange("xml:isInitialNameChar", true);
        }
        if (i2 == 115) {
            return getRange("xml:isSpace", true);
        }
        if (i2 == 119) {
            return getRange("xml:isWord", true);
        }
        if (i2 == 99) {
            return getRange("xml:isNameChar", true);
        }
        if (i2 == 100) {
            return getRange("xml:isDigit", true);
        }
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(i2, 16));
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0190, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0195, code lost:
    
        if (read() == 1) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0197, code lost:
    
        r2.sortRanges();
        r2.compactRanges();
        setContext(0);
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01a4, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01ab, code lost:
    
        throw ex("parser.cc.2", r16.offset);
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x018c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d6  */
    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected RangeToken parseCharacterClass(boolean z) throws ParseException {
        RangeToken rangeTokenCreateRange;
        RangeToken rangeTokenCreateRange2;
        boolean z2;
        boolean z3;
        setContext(1);
        next();
        boolean z4 = false;
        if (read() == 0 && this.chardata == 94) {
            next();
            rangeTokenCreateRange2 = Token.createRange();
            rangeTokenCreateRange2.addRange(0, 1114111);
            rangeTokenCreateRange = Token.createRange();
            z2 = true;
        } else {
            rangeTokenCreateRange = Token.createRange();
            rangeTokenCreateRange2 = null;
            z2 = false;
        }
        boolean z5 = true;
        while (true) {
            int i2 = read();
            if (i2 == 1) {
                break;
            }
            if (i2 != 0 || this.chardata != 93 || z5) {
                int iProcessCIinCharacterClass = this.chardata;
                if (i2 == 10) {
                    if (iProcessCIinCharacterClass == 67) {
                        iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                        if (iProcessCIinCharacterClass < 0) {
                            z3 = true;
                        }
                    } else if (iProcessCIinCharacterClass == 68) {
                        rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                        z3 = true;
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
                            z3 = true;
                        }
                        int i3 = this.offset;
                        RangeToken rangeTokenProcessBacksolidus_pP = processBacksolidus_pP(iProcessCIinCharacterClass);
                        if (rangeTokenProcessBacksolidus_pP == null) {
                            throw ex("parser.atom.5", i3);
                        }
                        rangeTokenCreateRange.mergeRanges(rangeTokenProcessBacksolidus_pP);
                        z3 = true;
                    }
                    next();
                    if (!z3) {
                        if (i2 == 0) {
                            if (iProcessCIinCharacterClass == 91) {
                                throw ex("parser.cc.6", this.offset - 2);
                            }
                            if (iProcessCIinCharacterClass == 93) {
                                throw ex("parser.cc.7", this.offset - 2);
                            }
                            if (iProcessCIinCharacterClass == 45 && !z5 && this.chardata != 93) {
                                throw ex("parser.cc.8", this.offset - 2);
                            }
                        }
                        if (read() == 0 && this.chardata == 45) {
                            next();
                            int i4 = read();
                            if (i4 == 1) {
                                throw ex("parser.cc.2", this.offset);
                            }
                            if (i4 == 24) {
                                throw ex("parser.cc.8", this.offset - 1);
                            }
                            if (i4 == 0 && this.chardata == 93) {
                                rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                                rangeTokenCreateRange.addRange(45, 45);
                            } else {
                                int iDecodeEscaped = this.chardata;
                                if (i4 == 0) {
                                    if (iDecodeEscaped == 91) {
                                        throw ex("parser.cc.6", this.offset - 1);
                                    }
                                    if (iDecodeEscaped == 93) {
                                        throw ex("parser.cc.7", this.offset - 1);
                                    }
                                    if (iDecodeEscaped == 45) {
                                        next();
                                        if (this.chardata != 93) {
                                            throw ex("parser.cc.8", this.offset - 2);
                                        }
                                    }
                                } else if (i4 == 10) {
                                    iDecodeEscaped = decodeEscaped();
                                }
                                if (iDecodeEscaped != 45 || this.chardata != 93) {
                                    next();
                                }
                                if (iProcessCIinCharacterClass > iDecodeEscaped) {
                                    throw ex("parser.ope.3", this.offset - 1);
                                }
                                rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iDecodeEscaped);
                            }
                        } else {
                            rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        }
                    }
                    z4 = false;
                    z5 = false;
                } else if (i2 == 24 && !z5) {
                    if (z2) {
                        rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
                    } else {
                        rangeTokenCreateRange2 = rangeTokenCreateRange;
                    }
                    rangeTokenCreateRange2.subtractRanges(parseCharacterClass(z4));
                    if (read() != 0 || this.chardata != 93) {
                        throw ex("parser.cc.5", this.offset);
                    }
                }
                z3 = z4;
                next();
                if (!z3) {
                }
                z4 = false;
                z5 = false;
            } else if (z2) {
                rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    protected RangeToken parseSetOperations() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBackreference() throws ParseException {
        throw ex("parser.process.1", this.offset - 4);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_A() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_B() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_C() throws ParseException {
        next();
        return getTokenForShorthand(67);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_I() throws ParseException {
        next();
        return getTokenForShorthand(73);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_X() throws ParseException {
        throw ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_Z() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_b() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_c() throws ParseException {
        next();
        return getTokenForShorthand(99);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_g() throws ParseException {
        throw ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_gt() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_i() throws ParseException {
        next();
        return getTokenForShorthand(105);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_lt() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_z() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    int processCIinCharacterClass(RangeToken rangeToken, int i2) {
        rangeToken.mergeRanges(getTokenForShorthand(i2));
        return -1;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processCaret() throws ParseException {
        next();
        return Token.createChar(94);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processCondition() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processDollar() throws ParseException {
        next();
        return Token.createChar(36);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processIndependent() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processLookahead() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processLookbehind() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processModifiers() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processNegativelookahead() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processNegativelookbehind() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processParen() throws ParseException {
        next();
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), 0);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processParen2() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processPlus(Token token) throws ParseException {
        next();
        return Token.createConcat(token, Token.createClosure(token));
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processQuestion(Token token) throws ParseException {
        next();
        Token.UnionToken unionTokenCreateUnion = Token.createUnion();
        unionTokenCreateUnion.addChild(token);
        unionTokenCreateUnion.addChild(Token.createEmpty());
        return unionTokenCreateUnion;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processStar(Token token) throws ParseException {
        next();
        return Token.createClosure(token);
    }

    public ParserForXMLSchema(Locale locale) {
    }
}
