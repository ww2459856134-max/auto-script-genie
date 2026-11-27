package i.b.ia;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import com.frame.p1;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class f extends RectF {
    public static HashMap<Long, f> I;
    private ArrayList<f> A = new ArrayList<>();
    private ArrayList<c> C = new ArrayList<>();
    private int D = p1.c(100.0f);
    private a G;
    private b H;
    private LinkedHashMap<Long, i.b.ia.b> c;
    private i.b.ia.b d;
    private Task e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1513h;

    /* renamed from: i, reason: collision with root package name */
    public float f1514i;

    /* renamed from: j, reason: collision with root package name */
    public float f1515j;

    /* renamed from: k, reason: collision with root package name */
    public float f1516k;
    public float t;

    public interface a {
        void b(f fVar, i.b.ia.b bVar);
    }

    public interface b {
        void a(f fVar, c cVar);
    }

    public f() {
        k();
    }

    private void b(i.b.ia.b bVar) {
        float f = ((RectF) bVar).right;
        if (f > ((RectF) this).right) {
            ((RectF) this).right = f;
        }
        float f2 = ((RectF) bVar).left;
        if (f2 < ((RectF) this).left) {
            ((RectF) this).left = f2;
        }
        float f3 = ((RectF) bVar).top;
        if (f3 < ((RectF) this).top) {
            ((RectF) this).top = f3;
        }
        float f4 = ((RectF) bVar).bottom;
        if (f4 > ((RectF) this).bottom) {
            ((RectF) this).bottom = f4;
        }
        float f5 = ((RectF) bVar).right;
        if (f5 > this.f1514i) {
            this.f1514i = f5;
        }
        float f6 = ((RectF) bVar).left;
        if (f6 < this.f1516k) {
            this.f1516k = f6;
        }
        float f7 = ((RectF) bVar).top;
        if (f7 < this.t) {
            this.t = f7;
        }
        float f8 = ((RectF) bVar).bottom;
        if (f8 > this.f1515j) {
            this.f1515j = f8;
        }
    }

    private f f(Task task) {
        f fVar = new f();
        fVar.w(this.G);
        fVar.x(this.H);
        fVar.p(task);
        fVar.o();
        return fVar;
    }

    private void k() {
        this.f = p1.c(80.0f);
        this.g = p1.c(60.0f);
        this.f1513h = p1.c(45.0f);
    }

    public static void l() {
        I = new HashMap<>();
    }

    private void n(i.b.ia.b bVar, Task task, Long l2, String str) {
        i.b.ia.a aVar = new i.b.ia.a();
        ((RectF) aVar).left = 0.0f;
        ((RectF) aVar).top = 0.0f;
        ((RectF) aVar).right = this.f;
        ((RectF) aVar).bottom = this.g;
        f fVar = I.get(Long.valueOf(task.getId()));
        if (fVar != null) {
            aVar.offsetTo(((RectF) fVar).left, ((RectF) fVar).top);
            c cVar = new c(bVar, (l2 == null || !fVar.i().containsKey(l2)) ? fVar.d : fVar.i().get(l2));
            cVar.p(str);
            this.C.add(cVar);
            return;
        }
        f fVarF = f(task);
        boolean z = bVar.g;
        int i2 = this.D;
        if (!z && !bVar.f1506h) {
            float f = i2;
            aVar.offsetTo((((RectF) bVar).left - fVarF.s()) - f, ((RectF) bVar).top);
            Iterator<f> it = I.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().c(aVar)) {
                    aVar.offsetTo(((RectF) bVar).right + f, ((RectF) bVar).top);
                    Iterator<f> it2 = I.values().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        } else if (it2.next().c(aVar)) {
                            aVar.offset(f + fVarF.s(), 0.0f);
                            break;
                        }
                    }
                }
            }
        } else if (z) {
            aVar.offsetTo(((RectF) bVar).right + fVarF.s() + i2, ((RectF) bVar).top);
        } else {
            aVar.offsetTo((((RectF) bVar).left - fVarF.s()) - i2, ((RectF) bVar).top);
        }
        fVarF.offsetTo(((RectF) aVar).left, ((RectF) aVar).top);
        float f2 = ((RectF) fVarF).right;
        if (f2 > this.f1514i) {
            this.f1514i = f2;
        }
        float f3 = ((RectF) fVarF).left;
        if (f3 < this.f1516k) {
            this.f1516k = f3;
        }
        float f4 = ((RectF) fVarF).top;
        if (f4 < this.t) {
            this.t = f4;
        }
        float f5 = ((RectF) fVarF).bottom;
        if (f5 > this.f1515j) {
            this.f1515j = f5;
        }
        c cVar2 = new c(bVar, (l2 == null || !fVarF.i().containsKey(l2)) ? fVarF.d : fVarF.i().get(l2));
        cVar2.p(str);
        this.C.add(cVar2);
        this.A.add(fVarF);
    }

    public boolean a(float f, float f2) {
        Iterator<c> it = this.C.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.contains(f, f2)) {
                b bVar = this.H;
                if (bVar != null) {
                    bVar.a(this, next);
                }
                return true;
            }
        }
        for (i.b.ia.b bVar2 : this.c.values()) {
            if (bVar2.contains(f, f2)) {
                a aVar = this.G;
                if (aVar != null) {
                    aVar.b(this, bVar2);
                }
                return true;
            }
        }
        return false;
    }

    public boolean c(RectF rectF) {
        Iterator<f> it = I.values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(rectF)) {
                return true;
            }
        }
        return false;
    }

    public i.b.ia.b d(Node node) {
        int i2 = node.type;
        i.b.ia.b eVar = (i2 == 3 || i2 == 4 || i2 == 13 || i2 == 14 || i2 == 19 || i2 == 23) ? new e() : new d();
        eVar.e = node;
        eVar.c = node.id;
        eVar.d = node.getName();
        return eVar;
    }

    public i.b.ia.b e(i.b.ia.b bVar, float f, float f2) {
        ((RectF) bVar).top = f2;
        ((RectF) bVar).left = f;
        ((RectF) bVar).right = f + this.f;
        ((RectF) bVar).bottom = f2 + this.g;
        b(bVar);
        i.b.ia.b bVar2 = bVar;
        while (bVar != null) {
            i.b.ia.b bVar3 = this.c.get(Long.valueOf(bVar.e.nextId));
            if (bVar3 != null) {
                if (((RectF) bVar3).bottom != 0.0f) {
                    bVar = null;
                    bVar2 = bVar3;
                } else {
                    float f3 = ((RectF) bVar).top;
                    int i2 = this.g;
                    float f4 = f3 + i2 + this.f1513h;
                    ((RectF) bVar3).top = f4;
                    float f5 = ((RectF) bVar).left;
                    ((RectF) bVar3).left = f5;
                    ((RectF) bVar3).right = f5 + this.f;
                    ((RectF) bVar3).bottom = f4 + i2;
                    b(bVar3);
                    bVar2 = bVar3;
                }
            }
            bVar = bVar3;
        }
        return bVar2;
    }

    public ArrayList<c> g() {
        return this.C;
    }

    public i.b.ia.b h(float f, float f2) {
        for (i.b.ia.b bVar : this.c.values()) {
            if (bVar.contains(f, f2)) {
                return bVar;
            }
        }
        return null;
    }

    public LinkedHashMap<Long, i.b.ia.b> i() {
        return this.c;
    }

    public Task j() {
        return this.e;
    }

    public void m(Task task) {
        p(task);
        o();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o() {
        Task taskL;
        int i2;
        this.C.clear();
        for (i.b.ia.b bVar : this.c.values()) {
            Node node = bVar.e;
            if (node != null) {
                i.b.ia.b bVar2 = this.c.get(Long.valueOf(node.nextId));
                if (bVar2 != null) {
                    if (bVar.e.isJumOtherType()) {
                        Node node2 = bVar.e;
                        if (node2.nextTaskId == 0 || node2.errorId == 0) {
                            c cVar = new c(bVar, bVar2);
                            cVar.p(bVar2.e.delay + "\n毫秒");
                            this.C.add(cVar);
                        }
                    }
                }
                Node node3 = bVar.e;
                int i3 = node3.errorType;
                if (i3 == 6) {
                    i.b.ia.b bVar3 = this.c.get(Long.valueOf(node3.errorId));
                    if (bVar3 != null) {
                        boolean z = bVar.g;
                        int i4 = this.D;
                        e(bVar3, z ? ((RectF) bVar).right + bVar.width() + i4 : (((RectF) bVar).left - bVar.width()) - i4, ((RectF) bVar).top);
                        c cVar2 = new c(bVar, bVar3);
                        cVar2.p("识别超时");
                        this.C.add(cVar2);
                    }
                } else if (i3 != 2) {
                    long j2 = node3.errorId;
                    if (j2 != 0 && i3 == 3) {
                        i.b.ia.b bVar4 = this.c.get(Long.valueOf(j2));
                        if (bVar4 != null) {
                            bVar.f1508j = true;
                            c cVar3 = new c(bVar, bVar4);
                            cVar3.p("识别超时");
                            this.C.add(cVar3);
                        }
                    } else if (j2 != 0 && i3 == 4 && (taskL = da.B().L(bVar.e.errorId)) != null) {
                        n(bVar, taskL, Long.valueOf(bVar.e.nextTaskNodeId), "识别超时");
                    }
                }
                Node node4 = bVar.e;
                long j3 = node4.nextTaskId;
                if (j3 != 0 && ((i2 = node4.nextType) == 3 || i2 == 13)) {
                    i.b.ia.b bVar5 = this.c.get(Long.valueOf(j3));
                    if (bVar5 != null) {
                        boolean z2 = bVar.g;
                        c cVar4 = new c(bVar, bVar5);
                        cVar4.p("识别成功");
                        this.C.add(cVar4);
                    }
                } else if ((j3 != 0 && node4.nextType == 4) || node4.nextType == 12) {
                    Task taskL2 = da.B().L(bVar.e.nextTaskId);
                    if (taskL2 != null) {
                        n(bVar, taskL2, Long.valueOf(bVar.e.nextTaskNodeId), "识别成功");
                    }
                }
            }
        }
    }

    @Override // android.graphics.RectF
    public void offset(float f, float f2) {
        super.offset(f, f2);
        Iterator<c> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().offset(f, f2);
        }
        Iterator<i.b.ia.b> it2 = this.c.values().iterator();
        while (it2.hasNext()) {
            it2.next().offset(f, f2);
        }
        Iterator<f> it3 = this.A.iterator();
        while (it3.hasNext()) {
            it3.next().offset(f, f2);
        }
        this.f1516k += f;
        this.f1514i += f;
        this.t += f2;
        this.f1515j += f2;
    }

    @Override // android.graphics.RectF
    public void offsetTo(float f, float f2) {
        offset(f - ((RectF) this).left, f2 - ((RectF) this).top);
    }

    public void p(Task task) {
        q(task, null);
    }

    public void q(Task task, Node node) {
        this.e = task;
        I.put(Long.valueOf(task.getId()), this);
        if (node == null) {
            if (task.getFirstNodeId() == 0 && !task.getNodeMap().isEmpty()) {
                task.setFirstNodeId(task.getNodeMap().values().iterator().next().id);
            }
            node = task.getNodeMap().get(Long.valueOf(task.getFirstNodeId()));
        }
        LinkedHashMap<Long, i.b.ia.b> linkedHashMap = new LinkedHashMap<>();
        this.c = linkedHashMap;
        if (node == null) {
            return;
        }
        this.d = d(node);
        Iterator<Node> it = task.getNodeMap().values().iterator();
        while (it.hasNext()) {
            i.b.ia.b bVarD = d(it.next());
            linkedHashMap.put(Long.valueOf(bVarD.c), bVarD);
        }
        linkedHashMap.put(Long.valueOf(this.d.c), this.d);
        i.b.ia.b bVar = this.d;
        if (bVar != null) {
            i.b.ia.b bVarE = e(bVar, 0.0f, 0.0f);
            for (i.b.ia.b bVar2 : linkedHashMap.values()) {
                if (((RectF) bVar2).top == 0.0f && ((RectF) bVar2).bottom == 0.0f) {
                    float f = ((RectF) bVarE).bottom;
                    int i2 = this.g;
                    float f2 = f + i2 + this.f1513h;
                    ((RectF) bVar2).top = f2;
                    float f3 = ((RectF) bVarE).left;
                    ((RectF) bVar2).left = f3;
                    ((RectF) bVar2).right = f3 + this.f;
                    ((RectF) bVar2).bottom = f2 + i2;
                    b(bVar2);
                    bVarE = bVar2;
                }
            }
        }
    }

    public float r() {
        return this.f1515j - this.t;
    }

    public float s() {
        return this.f1514i - this.f1516k;
    }

    public void t(Canvas canvas) {
        LinkedHashMap<Long, i.b.ia.b> linkedHashMap = this.c;
        if (linkedHashMap == null) {
            return;
        }
        Iterator<i.b.ia.b> it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            it.next().c(canvas);
        }
        Iterator<c> it2 = this.C.iterator();
        while (it2.hasNext()) {
            it2.next().o(canvas);
        }
        int iC = p1.c(40.0f);
        Paint paint = new Paint();
        paint.setStrokeWidth(p1.c(1.0f));
        paint.setColor(Color.parseColor("#FBA847"));
        paint.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{10.0f, 4.0f}, 0.0f), new CornerPathEffect(p1.c(5.0f))));
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        paint2.setTextSize(25.0f);
        paint2.setColor(Color.parseColor("#FBA847"));
        Iterator<f> it3 = this.A.iterator();
        while (it3.hasNext()) {
            f next = it3.next();
            if (((RectF) next).left == 0.0f && ((RectF) next).top == 0.0f) {
                float f = iC;
                canvas.drawText(next.e.getName(), ((RectF) next).left - f, (((RectF) next).top - f) - 15.0f, paint2);
                next.t(canvas);
            } else {
                next.t(canvas);
                float f2 = iC;
                canvas.drawText(next.e.getName(), ((RectF) next).left - f2, (((RectF) next).top - f2) - 15.0f, paint2);
                canvas.drawRect(((RectF) next).left - f2, ((RectF) next).top - f2, ((RectF) next).right + f2, f2 + ((RectF) next).bottom, paint);
            }
        }
    }

    public void u() {
        p(this.e);
        o();
    }

    public void v(i.b.ia.b bVar) {
        Node node = bVar.e;
        Node node2 = this.c.containsKey(Long.valueOf(node.frontId)) ? this.c.get(Long.valueOf(node.frontId)).e : null;
        Node node3 = this.c.containsKey(Long.valueOf(node.nextId)) ? this.c.get(Long.valueOf(node.nextId)).e : null;
        if (node2 == null || node2.nextId == node.id) {
            if (node2 != null && node3 != null) {
                node2.nextId = node3.id;
                node3.frontId = node2.id;
            } else if (node2 != null && node3 == null) {
                node2.nextId = 0L;
            } else if (node2 == null && node3 != null) {
                node3.frontId = 0L;
            }
            if (node.id == this.d.c && node3 != null) {
                node3.frontId = 0L;
                this.e.setFirstNodeId(node3.id);
                this.d = this.c.get(Long.valueOf(node3.id));
            }
            this.c.remove(Long.valueOf(bVar.b()));
            ArrayList arrayList = new ArrayList();
            Iterator<c> it = this.C.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.n() == bVar.b()) {
                    arrayList.add(next);
                }
            }
            this.C.removeAll(arrayList);
            i.b.ia.b bVar2 = this.c.get(Long.valueOf(node.nextId));
            if (bVar2 != null) {
                y(bVar2, ((RectF) bVar).left, ((RectF) bVar).top);
            }
        }
    }

    public void w(a aVar) {
        this.G = aVar;
    }

    public void x(b bVar) {
        this.H = bVar;
    }

    public void y(i.b.ia.b bVar, float f, float f2) {
        ((RectF) bVar).top = f2;
        ((RectF) bVar).left = f;
        ((RectF) bVar).right = f + this.f;
        ((RectF) bVar).bottom = f2 + this.g;
        b(bVar);
        while (bVar != null) {
            i.b.ia.b bVar2 = this.c.get(Long.valueOf(bVar.e.nextId));
            if (bVar2 != null) {
                float f3 = ((RectF) bVar).top;
                int i2 = this.g;
                float f4 = f3 + i2 + this.f1513h;
                ((RectF) bVar2).top = f4;
                float f5 = ((RectF) bVar).left;
                ((RectF) bVar2).left = f5;
                ((RectF) bVar2).right = f5 + this.f;
                ((RectF) bVar2).bottom = f4 + i2;
                b(bVar2);
            }
            bVar = bVar2;
        }
        o();
    }
}
