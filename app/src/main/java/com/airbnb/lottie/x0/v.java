package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
abstract class v {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static com.airbnb.lottie.v0.l.h a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        String strQ;
        char c;
        eVar.d();
        com.airbnb.lottie.v0.l.g gVar = null;
        boolean zN = false;
        com.airbnb.lottie.v0.k.h hVarK = null;
        com.airbnb.lottie.v0.k.d dVarH = null;
        while (eVar.m()) {
            strQ = eVar.q();
            strQ.hashCode();
            c = 3;
            switch (strQ) {
                case "o":
                    dVarH = d.h(eVar, eVar2);
                    break;
                case "pt":
                    hVarK = d.k(eVar, eVar2);
                    break;
                case "inv":
                    zN = eVar.n();
                    break;
                case "mode":
                    String strS = eVar.s();
                    strS.hashCode();
                    switch (strS.hashCode()) {
                        case 97:
                            if (!strS.equals("a")) {
                                c = 65535;
                                break;
                            } else {
                                c = 0;
                                break;
                            }
                        case 105:
                            if (strS.equals("i")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 110:
                            if (strS.equals("n")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 115:
                            if (!strS.equals("s")) {
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            gVar = com.airbnb.lottie.v0.l.g.MASK_MODE_ADD;
                            break;
                        case 1:
                            eVar2.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            gVar = com.airbnb.lottie.v0.l.g.MASK_MODE_INTERSECT;
                            break;
                        case 2:
                            gVar = com.airbnb.lottie.v0.l.g.MASK_MODE_NONE;
                            break;
                        case 3:
                            gVar = com.airbnb.lottie.v0.l.g.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            com.airbnb.lottie.y0.d.c("Unknown mask mode " + strQ + ". Defaulting to Add.");
                            gVar = com.airbnb.lottie.v0.l.g.MASK_MODE_ADD;
                            break;
                    }
                default:
                    eVar.B();
                    break;
            }
        }
        eVar.i();
        return new com.airbnb.lottie.v0.l.h(gVar, hVarK, dVarH, zN);
    }
}
