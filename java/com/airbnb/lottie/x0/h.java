package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
public class h implements k0<com.airbnb.lottie.v0.c> {
    public static final h a = new h();
    private static final com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private h() {
    }

    @Override // com.airbnb.lottie.x0.k0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.v0.c a(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        com.airbnb.lottie.v0.b bVar = com.airbnb.lottie.v0.b.CENTER;
        eVar.d();
        com.airbnb.lottie.v0.b bVar2 = bVar;
        String strS = null;
        String strS2 = null;
        int iP = 0;
        int iD = 0;
        int iD2 = 0;
        float fO = 0.0f;
        float fO2 = 0.0f;
        float fO3 = 0.0f;
        float fO4 = 0.0f;
        boolean zN = true;
        while (eVar.m()) {
            switch (eVar.y(b)) {
                case 0:
                    strS = eVar.s();
                    break;
                case 1:
                    strS2 = eVar.s();
                    break;
                case 2:
                    fO = (float) eVar.o();
                    break;
                case 3:
                    int iP2 = eVar.p();
                    bVar2 = com.airbnb.lottie.v0.b.CENTER;
                    if (iP2 <= bVar2.ordinal() && iP2 >= 0) {
                        bVar2 = com.airbnb.lottie.v0.b.values()[iP2];
                        break;
                    } else {
                        break;
                    }
                    break;
                case 4:
                    iP = eVar.p();
                    break;
                case 5:
                    fO2 = (float) eVar.o();
                    break;
                case 6:
                    fO3 = (float) eVar.o();
                    break;
                case 7:
                    iD = q.d(eVar);
                    break;
                case 8:
                    iD2 = q.d(eVar);
                    break;
                case 9:
                    fO4 = (float) eVar.o();
                    break;
                case 10:
                    zN = eVar.n();
                    break;
                default:
                    eVar.z();
                    eVar.B();
                    break;
            }
        }
        eVar.i();
        return new com.airbnb.lottie.v0.c(strS, strS2, fO, bVar2, iP, fO2, fO3, iD, iD2, fO4, zN);
    }
}
