package i.b.ka;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.v.MultiClickChooseView;
import com.v.MultiClickDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import i.b.x7;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONException;

/* loaded from: classes.dex */
public class r6 extends x5 {
    private int e;
    private int f;
    private Node g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f1532h;

    /* renamed from: i, reason: collision with root package name */
    private Node f1533i;

    /* renamed from: j, reason: collision with root package name */
    private Runnable f1534j = new Runnable() { // from class: i.b.ka.d1
        @Override // java.lang.Runnable
        public final void run() {
            this.c.c0();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z(lt ltVar, Node node, final Node node2) {
        com.frame.s0.g().d(MultiClickDialogView.class);
        com.frame.l1.g(new Runnable() { // from class: i.b.ka.c1
            @Override // java.lang.Runnable
            public final void run() {
                v8.m().V(node2);
            }
        });
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(MultiClickChooseView multiClickChooseView, final Node node, final lt ltVar, View view) {
        Point point = multiClickChooseView.getPoint();
        ArrayList<Integer> arrayList = new ArrayList<>();
        node.pathPoints = arrayList;
        arrayList.add(Integer.valueOf(point.x));
        node.pathPoints.add(Integer.valueOf(point.y));
        com.frame.s0.g().o(multiClickChooseView);
        MultiClickDialogView multiClickDialogView = (MultiClickDialogView) com.frame.s0.g().B(MultiClickDialogView.class);
        multiClickDialogView.h(v8.m().p(), node);
        multiClickDialogView.f(new lt() { // from class: i.b.ka.b1
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.Z(ltVar, node, node2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (this.c.q()) {
            if (this.f < this.e) {
                Log.e("", "连续点击:" + this.f);
                g(this.g, this.f1534j);
                x7.d().b(this.g.getDelay());
            } else {
                this.c.W(this.f1532h);
            }
            this.f++;
        }
    }

    @Override // i.b.ka.x5
    public int B() {
        return 11;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        MultiClickDialogView multiClickDialogView = (MultiClickDialogView) com.frame.s0.g().B(MultiClickDialogView.class);
        multiClickDialogView.h(task, node);
        multiClickDialogView.f(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        final Node nodeQ = v8.m().Q();
        final MultiClickChooseView multiClickChooseView = (MultiClickChooseView) com.frame.s0.g().x(MultiClickChooseView.class);
        multiClickChooseView.setOnClickListener(new View.OnClickListener() { // from class: i.b.ka.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.b0(multiClickChooseView, nodeQ, ltVar, view);
            }
        });
        multiClickChooseView.setHit("请选择连续点击坐标");
    }

    public synchronized void T() {
        if (this.c.q()) {
            if (this.f < this.e) {
                Rect areaOrParam = this.f1533i.getAreaOrParam();
                if (!this.f1533i.hasAreaResolveError() && areaOrParam != null) {
                    int i2 = Integer.parseInt(this.f1533i.text);
                    float fWidth = areaOrParam.width() / i2;
                    float fHeight = areaOrParam.height() / Integer.parseInt(this.f1533i.url);
                    int i3 = this.f;
                    int i4 = i3 % i2;
                    int i5 = i3 / i2;
                    int i6 = areaOrParam.left + ((int) ((i4 * fWidth) + (fWidth / 2.0f)));
                    int i7 = areaOrParam.top + ((int) ((i5 * fHeight) + (fHeight / 2.0f)));
                    this.g.pathPoints.clear();
                    this.g.pathPoints.add(Integer.valueOf(i6));
                    this.g.pathPoints.add(Integer.valueOf(i7));
                    g(this.g, this.f1534j);
                    x7.d().b(this.g.getDelay());
                }
                k(this.f1533i, this.f1532h);
                return;
            }
            this.c.W(this.f1532h);
            this.f++;
        }
    }

    public synchronized void U() {
        if (this.c.q()) {
            if (this.f < this.e) {
                try {
                    Rect areaOrParam = this.f1533i.getAreaOrParam();
                    if (!this.f1533i.hasAreaResolveError() && areaOrParam != null) {
                        this.g.pathPoints = V(areaOrParam);
                        g(this.g, this.f1534j);
                        x7.d().b(this.g.getDelay());
                    }
                    k(this.f1533i, this.f1532h);
                    return;
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
            } else {
                this.c.W(this.f1532h);
            }
            this.f++;
        }
    }

    public ArrayList<Integer> V(Rect rect) {
        int iA = o.a.f.a(rect.top, rect.bottom);
        int iA2 = o.a.f.a(rect.left, rect.right);
        this.g.pathPoints.clear();
        this.g.pathPoints.add(Integer.valueOf(iA2));
        this.g.pathPoints.add(Integer.valueOf(iA));
        return this.g.pathPoints;
    }

    public synchronized void d0() {
        if (this.c.q()) {
            if (this.f < this.e) {
                g(this.g, this.f1534j);
                x7.d().b(this.g.getDelay());
            } else {
                this.c.W(this.f1532h);
            }
            this.f++;
        }
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws JSONException, NumberFormatException {
        this.f1533i = node;
        if (TextUtils.isEmpty(node.arg1)) {
            da.B().w1("新版本协议已修改，请重新录制此操作");
            return false;
        }
        int i2 = Integer.parseInt(node.arg1);
        this.e = i2;
        if (i2 == 0) {
            i2 = 1;
        }
        this.e = i2;
        this.f = 0;
        int i3 = node.what;
        if (i3 == 1) {
            Rect areaOrParam = node.getAreaOrParam();
            if (node.hasAreaResolveError() || areaOrParam == null) {
                k(node, runnable);
                return false;
            }
            if ("1".equals(node.arg2)) {
                this.f1534j = new Runnable() { // from class: i.b.ka.t5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.T();
                    }
                };
            } else {
                this.f1534j = new Runnable() { // from class: i.b.ka.u5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.U();
                    }
                };
            }
        } else if (i3 == 0) {
            this.f1534j = new Runnable() { // from class: i.b.ka.r5
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d0();
                }
            };
        }
        Node node2 = new Node();
        if (TextUtils.isEmpty(node.arg3) || node.pathPoints != null) {
            node2.pathPoints = node.pathPoints;
        } else {
            node2.pathPoints = x(node.arg3);
        }
        node2.duration = da.B().M().getClickDuration();
        node2.delay = String.valueOf(node.duration / this.e);
        this.g = node2;
        this.f1532h = runnable;
        this.f1534j.run();
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.a;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.K;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "连续点击";
    }
}
