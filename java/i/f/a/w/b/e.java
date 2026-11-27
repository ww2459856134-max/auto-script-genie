package i.f.a.w.b;

import androidx.recyclerview.widget.k0;
import com.auto.exceldeps.log4j.util.Chars;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
abstract class e {
    private static final char[] a = {'*', '*', '*', Chars.SPACE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] b;
    private static final char[] c;
    private static final char[] d;
    private static final char[] e;

    static {
        char[] cArr = {'!', Chars.DQUOTE, '#', '$', '%', '&', Chars.QUOTE, '(', ')', '*', '+', ',', NameUtil.HYPHEN, NameUtil.PERIOD, '/', NameUtil.COLON, ';', '<', Chars.EQ, '>', '?', '@', '[', '\\', ']', '^', NameUtil.USCORE};
        b = cArr;
        c = new char[]{'*', '*', '*', Chars.SPACE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        d = cArr;
        e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    static i.f.a.v.e a(byte[] bArr) throws i.f.a.g {
        i.f.a.v.c cVar = new i.f.a.v.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        d dVarC = d.ASCII_ENCODE;
        do {
            d dVar = d.ASCII_ENCODE;
            if (dVarC == dVar) {
                dVarC = c(cVar, sb, sb2);
            } else {
                int i2 = c.a[dVarC.ordinal()];
                if (i2 == 1) {
                    e(cVar, sb);
                } else if (i2 == 2) {
                    g(cVar, sb);
                } else if (i2 == 3) {
                    b(cVar, sb);
                } else if (i2 == 4) {
                    f(cVar, sb);
                } else {
                    if (i2 != 5) {
                        throw i.f.a.g.a();
                    }
                    d(cVar, sb, arrayList);
                }
                dVarC = dVar;
            }
            if (dVarC == d.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new i.f.a.v.e(bArr, string, arrayList, null);
    }

    private static void b(i.f.a.v.c cVar, StringBuilder sb) throws i.f.a.g {
        int iD;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            h(iD, cVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append(Chars.CR);
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append('>');
                } else if (i3 == 3) {
                    sb.append(Chars.SPACE);
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else {
                    if (i3 >= 40) {
                        throw i.f.a.g.a();
                    }
                    sb.append((char) (i3 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static d c(i.f.a.v.c cVar, StringBuilder sb, StringBuilder sb2) throws i.f.a.g {
        boolean z = false;
        do {
            int iD = cVar.d(8);
            if (iD == 0) {
                throw i.f.a.g.a();
            }
            if (iD > 128) {
                if (iD != 129) {
                    if (iD > 229) {
                        switch (iD) {
                            case 230:
                                return d.C40_ENCODE;
                            case 231:
                                return d.BASE256_ENCODE;
                            case 232:
                                sb.append((char) 29);
                                break;
                            case 233:
                            case 234:
                            case 241:
                                break;
                            case 235:
                                z = true;
                                break;
                            case 236:
                                sb.append("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                sb.append("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return d.ANSIX12_ENCODE;
                            case 239:
                                return d.TEXT_ENCODE;
                            case 240:
                                return d.EDIFACT_ENCODE;
                            default:
                                if (iD != 254 || cVar.a() != 0) {
                                    throw i.f.a.g.a();
                                }
                                break;
                        }
                    } else {
                        int i2 = iD - 130;
                        if (i2 < 10) {
                            sb.append('0');
                        }
                        sb.append(i2);
                    }
                } else {
                    return d.PAD_ENCODE;
                }
            } else {
                if (z) {
                    iD += 128;
                }
                sb.append((char) (iD - 1));
                return d.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return d.ASCII_ENCODE;
    }

    private static void d(i.f.a.v.c cVar, StringBuilder sb, Collection<byte[]> collection) throws i.f.a.g {
        int iC = cVar.c() + 1;
        int i2 = iC + 1;
        int i3 = i(cVar.d(8), iC);
        if (i3 == 0) {
            i3 = cVar.a() / 8;
        } else if (i3 >= 250) {
            i3 = ((i3 - 249) * k0.a.DEFAULT_SWIPE_ANIMATION_DURATION) + i(cVar.d(8), i2);
            i2++;
        }
        if (i3 < 0) {
            throw i.f.a.g.a();
        }
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            if (cVar.a() < 8) {
                throw i.f.a.g.a();
            }
            bArr[i4] = (byte) i(cVar.d(8), i2);
            i4++;
            i2++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e2)));
        }
    }

    private static void e(i.f.a.v.c cVar, StringBuilder sb) throws i.f.a.g {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            h(iD, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = b;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw i.f.a.g.a();
                                }
                                z = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw i.f.a.g.a();
                            }
                            if (z) {
                                sb.append((char) (i4 + 224));
                                z = false;
                                i2 = 0;
                            } else {
                                sb.append((char) (i4 + 96));
                                i2 = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i4 + 128));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = a;
                    if (i4 >= cArr2.length) {
                        throw i.f.a.g.a();
                    }
                    char c3 = cArr2[i4];
                    if (z) {
                        sb.append((char) (c3 + 128));
                        z = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(i.f.a.v.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int iD = cVar.d(6);
                if (iD == 31) {
                    int iB = 8 - cVar.b();
                    if (iB != 8) {
                        cVar.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                sb.append((char) iD);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void g(i.f.a.v.c cVar, StringBuilder sb) throws i.f.a.g {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            h(iD, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = d;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw i.f.a.g.a();
                                }
                                z = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw i.f.a.g.a();
                            }
                            char[] cArr2 = e;
                            if (i4 >= cArr2.length) {
                                throw i.f.a.g.a();
                            }
                            char c3 = cArr2[i4];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                                i2 = 0;
                            } else {
                                sb.append(c3);
                                i2 = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i4 + 128));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = c;
                    if (i4 >= cArr3.length) {
                        throw i.f.a.g.a();
                    }
                    char c4 = cArr3[i4];
                    if (z) {
                        sb.append((char) (c4 + 128));
                        z = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    private static int i(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % 255) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }
}
