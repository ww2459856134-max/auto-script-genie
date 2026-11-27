package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
abstract class g {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("ty", "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static com.airbnb.lottie.v0.l.b a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        com.airbnb.lottie.v0.l.b bVarA;
        String strS;
        eVar.d();
        char c = 2;
        int iP = 2;
        while (true) {
            bVarA = null;
            if (!eVar.m()) {
                strS = null;
                break;
            }
            int iY = eVar.y(a);
            if (iY == 0) {
                strS = eVar.s();
                break;
            }
            if (iY != 1) {
                eVar.z();
                eVar.B();
            } else {
                iP = eVar.p();
            }
        }
        if (strS == null) {
            return null;
        }
        strS.hashCode();
        switch (strS.hashCode()) {
            case 3239:
                if (!strS.equals("el")) {
                    c = 65535;
                    break;
                } else {
                    c = 0;
                    break;
                }
            case 3270:
                if (strS.equals("fl")) {
                    c = 1;
                    break;
                }
                break;
            case 3295:
                if (!strS.equals("gf")) {
                }
                break;
            case 3307:
                if (strS.equals("gr")) {
                    c = 3;
                    break;
                }
                break;
            case 3308:
                if (strS.equals("gs")) {
                    c = 4;
                    break;
                }
                break;
            case 3488:
                if (strS.equals("mm")) {
                    c = 5;
                    break;
                }
                break;
            case 3633:
                if (strS.equals("rc")) {
                    c = 6;
                    break;
                }
                break;
            case 3646:
                if (strS.equals("rp")) {
                    c = 7;
                    break;
                }
                break;
            case 3669:
                if (strS.equals("sh")) {
                    c = '\b';
                    break;
                }
                break;
            case 3679:
                if (strS.equals("sr")) {
                    c = '\t';
                    break;
                }
                break;
            case 3681:
                if (strS.equals("st")) {
                    c = '\n';
                    break;
                }
                break;
            case 3705:
                if (strS.equals("tm")) {
                    c = 11;
                    break;
                }
                break;
            case 3710:
                if (strS.equals("tr")) {
                    c = '\f';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                bVarA = e.a(eVar, eVar2, iP);
                break;
            case 1:
                bVarA = f0.a(eVar, eVar2);
                break;
            case 2:
                bVarA = m.a(eVar, eVar2);
                break;
            case 3:
                bVarA = g0.a(eVar, eVar2);
                break;
            case 4:
                bVarA = n.a(eVar, eVar2);
                break;
            case 5:
                bVarA = w.a(eVar);
                eVar2.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                bVarA = b0.a(eVar, eVar2);
                break;
            case 7:
                bVarA = c0.a(eVar, eVar2);
                break;
            case '\b':
                bVarA = h0.a(eVar, eVar2);
                break;
            case '\t':
                bVarA = a0.a(eVar, eVar2);
                break;
            case '\n':
                bVarA = i0.a(eVar, eVar2);
                break;
            case 11:
                bVarA = j0.a(eVar, eVar2);
                break;
            case '\f':
                bVarA = c.g(eVar, eVar2);
                break;
            default:
                com.airbnb.lottie.y0.d.c("Unknown shape type " + strS);
                break;
        }
        while (eVar.m()) {
            eVar.B();
        }
        eVar.i();
        return bVarA;
    }
}
