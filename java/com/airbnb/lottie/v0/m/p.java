package com.airbnb.lottie.v0.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.s0;
import com.airbnb.lottie.t0.c.t;
import com.airbnb.lottie.t0.c.v;
import com.airbnb.lottie.v0.l.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class p extends c {
    private final Paint A;
    private final Paint B;
    private final Map<com.airbnb.lottie.v0.e, List<com.airbnb.lottie.t0.b.f>> C;
    private final h.d.f<String> D;
    private final t E;
    private final e0 F;
    private final com.airbnb.lottie.e G;
    private com.airbnb.lottie.t0.c.g<Integer, Integer> H;
    private com.airbnb.lottie.t0.c.g<Integer, Integer> I;
    private com.airbnb.lottie.t0.c.g<Integer, Integer> J;
    private com.airbnb.lottie.t0.c.g<Integer, Integer> K;
    private com.airbnb.lottie.t0.c.g<Float, Float> L;
    private com.airbnb.lottie.t0.c.g<Float, Float> M;
    private com.airbnb.lottie.t0.c.g<Float, Float> N;
    private com.airbnb.lottie.t0.c.g<Float, Float> O;
    private com.airbnb.lottie.t0.c.g<Float, Float> P;
    private com.airbnb.lottie.t0.c.g<Float, Float> Q;
    private final StringBuilder x;
    private final RectF y;
    private final Matrix z;

    p(e0 e0Var, i iVar) {
        com.airbnb.lottie.v0.k.b bVar;
        com.airbnb.lottie.v0.k.b bVar2;
        com.airbnb.lottie.v0.k.a aVar;
        com.airbnb.lottie.v0.k.a aVar2;
        super(e0Var, iVar);
        this.x = new StringBuilder(2);
        this.y = new RectF();
        this.z = new Matrix();
        this.A = new m(this, 1);
        this.B = new n(this, 1);
        this.C = new HashMap();
        this.D = new h.d.f<>();
        this.F = e0Var;
        this.G = iVar.a();
        t tVarA = iVar.q().a();
        this.E = tVarA;
        tVarA.a(this);
        i(tVarA);
        com.airbnb.lottie.v0.k.k kVarR = iVar.r();
        if (kVarR != null && (aVar2 = kVarR.a) != null) {
            com.airbnb.lottie.t0.c.g<Integer, Integer> gVarA = aVar2.a();
            this.H = gVarA;
            gVarA.a(this);
            i(this.H);
        }
        if (kVarR != null && (aVar = kVarR.b) != null) {
            com.airbnb.lottie.t0.c.g<Integer, Integer> gVarA2 = aVar.a();
            this.J = gVarA2;
            gVarA2.a(this);
            i(this.J);
        }
        if (kVarR != null && (bVar2 = kVarR.c) != null) {
            com.airbnb.lottie.t0.c.g<Float, Float> gVarA3 = bVar2.a();
            this.L = gVarA3;
            gVarA3.a(this);
            i(this.L);
        }
        if (kVarR == null || (bVar = kVarR.d) == null) {
            return;
        }
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA4 = bVar.a();
        this.N = gVarA4;
        gVarA4.a(this);
        i(this.N);
    }

    private void J(com.airbnb.lottie.v0.b bVar, Canvas canvas, float f) {
        int i2 = o.a[bVar.ordinal()];
        if (i2 == 2) {
            canvas.translate(-f, 0.0f);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    private String K(String str, int i2) {
        int iCodePointAt = str.codePointAt(i2);
        int iCharCount = Character.charCount(iCodePointAt) + i2;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!W(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j2 = iCodePointAt;
        if (this.D.d(j2)) {
            return this.D.f(j2);
        }
        this.x.setLength(0);
        while (i2 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i2);
            this.x.appendCodePoint(iCodePointAt3);
            i2 += Character.charCount(iCodePointAt3);
        }
        String string = this.x.toString();
        this.D.j(j2, string);
        return string;
    }

    private void L(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void M(com.airbnb.lottie.v0.e eVar, Matrix matrix, float f, com.airbnb.lottie.v0.c cVar, Canvas canvas) {
        List<com.airbnb.lottie.t0.b.f> listT = T(eVar);
        for (int i2 = 0; i2 < listT.size(); i2++) {
            Path path = listT.get(i2).getPath();
            path.computeBounds(this.y, false);
            this.z.set(matrix);
            this.z.preTranslate(0.0f, (-cVar.g) * com.airbnb.lottie.y0.h.e());
            this.z.preScale(f, f);
            path.transform(this.z);
            if (cVar.f517k) {
                P(path, this.A, canvas);
                P(path, this.B, canvas);
            } else {
                P(path, this.B, canvas);
                P(path, this.A, canvas);
            }
        }
    }

    private void N(String str, com.airbnb.lottie.v0.c cVar, Canvas canvas) {
        if (cVar.f517k) {
            L(str, this.A, canvas);
            L(str, this.B, canvas);
        } else {
            L(str, this.B, canvas);
            L(str, this.A, canvas);
        }
    }

    private void O(String str, com.airbnb.lottie.v0.c cVar, Canvas canvas, float f) {
        float fFloatValue;
        int length = 0;
        while (length < str.length()) {
            String strK = K(str, length);
            length += strK.length();
            N(strK, cVar, canvas);
            float fMeasureText = this.A.measureText(strK, 0, 1);
            float f2 = cVar.e / 10.0f;
            com.airbnb.lottie.t0.c.g<Float, Float> gVar = this.O;
            if (gVar != null) {
                fFloatValue = gVar.h().floatValue();
            } else {
                com.airbnb.lottie.t0.c.g<Float, Float> gVar2 = this.N;
                if (gVar2 != null) {
                    fFloatValue = gVar2.h().floatValue();
                } else {
                    canvas.translate(fMeasureText + (f2 * f), 0.0f);
                }
            }
            f2 += fFloatValue;
            canvas.translate(fMeasureText + (f2 * f), 0.0f);
        }
    }

    private void P(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void Q(String str, com.airbnb.lottie.v0.c cVar, Matrix matrix, com.airbnb.lottie.v0.d dVar, Canvas canvas, float f, float f2) {
        float fFloatValue;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.airbnb.lottie.v0.e eVarE = this.G.c().e(com.airbnb.lottie.v0.e.c(str.charAt(i2), dVar.a(), dVar.c()));
            if (eVarE != null) {
                M(eVarE, matrix, f2, cVar, canvas);
                float fB = ((float) eVarE.b()) * f2 * com.airbnb.lottie.y0.h.e() * f;
                float f3 = cVar.e / 10.0f;
                com.airbnb.lottie.t0.c.g<Float, Float> gVar = this.O;
                if (gVar != null) {
                    fFloatValue = gVar.h().floatValue();
                } else {
                    com.airbnb.lottie.t0.c.g<Float, Float> gVar2 = this.N;
                    if (gVar2 != null) {
                        fFloatValue = gVar2.h().floatValue();
                    }
                    canvas.translate(fB + (f3 * f), 0.0f);
                }
                f3 += fFloatValue;
                canvas.translate(fB + (f3 * f), 0.0f);
            }
        }
    }

    private void R(com.airbnb.lottie.v0.c cVar, Matrix matrix, com.airbnb.lottie.v0.d dVar, Canvas canvas) {
        float fFloatValue;
        com.airbnb.lottie.t0.c.g<Float, Float> gVar = this.Q;
        if (gVar != null) {
            fFloatValue = gVar.h().floatValue();
        } else {
            com.airbnb.lottie.t0.c.g<Float, Float> gVar2 = this.P;
            fFloatValue = gVar2 != null ? gVar2.h().floatValue() : cVar.c;
        }
        float f = fFloatValue / 100.0f;
        float fG = com.airbnb.lottie.y0.h.g(matrix);
        String str = cVar.a;
        float fE = cVar.f * com.airbnb.lottie.y0.h.e();
        List<String> listV = V(str);
        int size = listV.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = listV.get(i2);
            float fU = U(str2, dVar, f, fG);
            canvas.save();
            J(cVar.d, canvas, fU);
            canvas.translate(0.0f, (i2 * fE) - (((size - 1) * fE) / 2.0f));
            Q(str2, cVar, matrix, dVar, canvas, fG, f);
            canvas.restore();
        }
    }

    private void S(com.airbnb.lottie.v0.c cVar, com.airbnb.lottie.v0.d dVar, Matrix matrix, Canvas canvas) {
        float fFloatValue;
        float fG = com.airbnb.lottie.y0.h.g(matrix);
        Typeface typefaceD = this.F.D(dVar.a(), dVar.c());
        if (typefaceD == null) {
            return;
        }
        String str = cVar.a;
        s0 s0VarC = this.F.C();
        if (s0VarC != null) {
            s0VarC.a(str);
            throw null;
        }
        this.A.setTypeface(typefaceD);
        com.airbnb.lottie.t0.c.g<Float, Float> gVar = this.Q;
        if (gVar != null) {
            fFloatValue = gVar.h().floatValue();
        } else {
            com.airbnb.lottie.t0.c.g<Float, Float> gVar2 = this.P;
            fFloatValue = gVar2 != null ? gVar2.h().floatValue() : cVar.c;
        }
        this.A.setTextSize(fFloatValue * com.airbnb.lottie.y0.h.e());
        this.B.setTypeface(this.A.getTypeface());
        this.B.setTextSize(this.A.getTextSize());
        float fE = cVar.f * com.airbnb.lottie.y0.h.e();
        List<String> listV = V(str);
        int size = listV.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = listV.get(i2);
            J(cVar.d, canvas, this.B.measureText(str2));
            canvas.translate(0.0f, (i2 * fE) - (((size - 1) * fE) / 2.0f));
            O(str2, cVar, canvas, fG);
            canvas.setMatrix(matrix);
        }
    }

    private List<com.airbnb.lottie.t0.b.f> T(com.airbnb.lottie.v0.e eVar) {
        if (this.C.containsKey(eVar)) {
            return this.C.get(eVar);
        }
        List<q> listA = eVar.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new com.airbnb.lottie.t0.b.f(this.F, this, listA.get(i2)));
        }
        this.C.put(eVar, arrayList);
        return arrayList;
    }

    private float U(String str, com.airbnb.lottie.v0.d dVar, float f, float f2) {
        float fB = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.airbnb.lottie.v0.e eVarE = this.G.c().e(com.airbnb.lottie.v0.e.c(str.charAt(i2), dVar.a(), dVar.c()));
            if (eVarE != null) {
                fB = (float) (fB + (eVarE.b() * f * com.airbnb.lottie.y0.h.e() * f2));
            }
        }
        return fB;
    }

    private List<String> V(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private boolean W(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    @Override // com.airbnb.lottie.v0.m.c, com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.G.b().width(), this.G.b().height());
    }

    @Override // com.airbnb.lottie.v0.m.c, com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        super.f(t, cVar);
        if (t == j0.a) {
            com.airbnb.lottie.t0.c.g<Integer, Integer> gVar = this.I;
            if (gVar != null) {
                C(gVar);
            }
            if (cVar == null) {
                this.I = null;
                return;
            }
            v vVar = new v(cVar);
            this.I = vVar;
            vVar.a(this);
            i(this.I);
            return;
        }
        if (t == j0.b) {
            com.airbnb.lottie.t0.c.g<Integer, Integer> gVar2 = this.K;
            if (gVar2 != null) {
                C(gVar2);
            }
            if (cVar == null) {
                this.K = null;
                return;
            }
            v vVar2 = new v(cVar);
            this.K = vVar2;
            vVar2.a(this);
            i(this.K);
            return;
        }
        if (t == j0.f445o) {
            com.airbnb.lottie.t0.c.g<Float, Float> gVar3 = this.M;
            if (gVar3 != null) {
                C(gVar3);
            }
            if (cVar == null) {
                this.M = null;
                return;
            }
            v vVar3 = new v(cVar);
            this.M = vVar3;
            vVar3.a(this);
            i(this.M);
            return;
        }
        if (t == j0.p) {
            com.airbnb.lottie.t0.c.g<Float, Float> gVar4 = this.O;
            if (gVar4 != null) {
                C(gVar4);
            }
            if (cVar == null) {
                this.O = null;
                return;
            }
            v vVar4 = new v(cVar);
            this.O = vVar4;
            vVar4.a(this);
            i(this.O);
            return;
        }
        if (t == j0.B) {
            com.airbnb.lottie.t0.c.g<Float, Float> gVar5 = this.Q;
            if (gVar5 != null) {
                C(gVar5);
            }
            if (cVar == null) {
                this.Q = null;
                return;
            }
            v vVar5 = new v(cVar);
            this.Q = vVar5;
            vVar5.a(this);
            i(this.Q);
        }
    }

    @Override // com.airbnb.lottie.v0.m.c
    void t(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.F.l0()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.v0.c cVarH = this.E.h();
        com.airbnb.lottie.v0.d dVar = this.G.g().get(cVarH.b);
        if (dVar == null) {
            canvas.restore();
            return;
        }
        com.airbnb.lottie.t0.c.g<Integer, Integer> gVar = this.I;
        if (gVar != null) {
            this.A.setColor(gVar.h().intValue());
        } else {
            com.airbnb.lottie.t0.c.g<Integer, Integer> gVar2 = this.H;
            if (gVar2 != null) {
                this.A.setColor(gVar2.h().intValue());
            } else {
                this.A.setColor(cVarH.f514h);
            }
        }
        com.airbnb.lottie.t0.c.g<Integer, Integer> gVar3 = this.K;
        if (gVar3 != null) {
            this.B.setColor(gVar3.h().intValue());
        } else {
            com.airbnb.lottie.t0.c.g<Integer, Integer> gVar4 = this.J;
            if (gVar4 != null) {
                this.B.setColor(gVar4.h().intValue());
            } else {
                this.B.setColor(cVarH.f515i);
            }
        }
        int iIntValue = ((this.v.h() == null ? 100 : this.v.h().h().intValue()) * 255) / 100;
        this.A.setAlpha(iIntValue);
        this.B.setAlpha(iIntValue);
        com.airbnb.lottie.t0.c.g<Float, Float> gVar5 = this.M;
        if (gVar5 != null) {
            this.B.setStrokeWidth(gVar5.h().floatValue());
        } else {
            com.airbnb.lottie.t0.c.g<Float, Float> gVar6 = this.L;
            if (gVar6 != null) {
                this.B.setStrokeWidth(gVar6.h().floatValue());
            } else {
                this.B.setStrokeWidth(cVarH.f516j * com.airbnb.lottie.y0.h.e() * com.airbnb.lottie.y0.h.g(matrix));
            }
        }
        if (this.F.l0()) {
            R(cVarH, matrix, dVar, canvas);
        } else {
            S(cVarH, dVar, matrix, canvas);
        }
        canvas.restore();
    }
}
