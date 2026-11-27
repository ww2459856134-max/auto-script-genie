package com.v;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.DurationSetDialogView;
import com.v.item.RunConditionItem;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class LengthScrollChooseView extends RelativeLayout implements View.OnClickListener {
    private Paint A;
    private Paint C;
    private final ArrayList<Point> D;
    private Point G;
    private int H;
    private boolean I;
    private lt J;
    private Task K;
    private ImageView c;
    private Node d;
    private Node e;
    private View f;
    private TextView g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f976h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f977i;

    /* renamed from: j, reason: collision with root package name */
    private RunConditionItem f978j;

    /* renamed from: k, reason: collision with root package name */
    private int f979k;
    private Paint t;

    public LengthScrollChooseView() {
        super(com.frame.v0.g());
        this.D = new ArrayList<>();
        this.H = -1;
        this.f979k = com.frame.p1.c(15.0f);
        Paint paint = new Paint();
        this.A = paint;
        paint.setColor(-65536);
        this.A.setStyle(Paint.Style.FILL);
        this.A.setStrokeWidth(com.frame.p1.c(5.0f));
        Paint paint2 = new Paint();
        this.C = paint2;
        paint2.setColor(-65536);
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setStrokeWidth(com.frame.p1.c(2.5f));
        Paint paint3 = new Paint();
        this.t = paint3;
        paint3.setTextSize(com.frame.p1.k(10.0f));
        this.t.setColor(-1);
        this.t.setStyle(Paint.Style.FILL);
        this.g = (TextView) View.inflate(com.frame.v0.g(), j.b.f.j1, null);
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.k1, null);
        this.f = viewInflate;
        viewInflate.setClickable(true);
        LinearLayout linearLayout = new LinearLayout(com.frame.v0.g());
        this.f977i = linearLayout;
        linearLayout.setClickable(true);
        this.f977i.setGravity(14);
        this.f977i.setOrientation(1);
        this.f977i.addView(this.g, new LinearLayout.LayoutParams(-2, -2));
        RunConditionItem runConditionItem = new RunConditionItem(com.frame.v0.g());
        this.f978j = runConditionItem;
        runConditionItem.setAttachView(this);
        this.f978j.setBackgroundResource(j.b.d.f1748o);
        this.f978j.setHelp(getResources().getString(j.b.g.g));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.frame.p1.c(280.0f), -2);
        layoutParams.bottomMargin = com.frame.p1.c(8.0f);
        this.f977i.addView(this.f978j, layoutParams);
        ImageView imageView = new ImageView(com.frame.v0.g());
        this.c = imageView;
        imageView.setImageResource(j.b.d.w);
        this.c.setAdjustViewBounds(true);
        addView(this.c, com.frame.p1.c(40.0f), com.frame.p1.c(40.0f));
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.v.rb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.g(view);
            }
        });
        this.f.findViewById(j.b.e.B).setOnClickListener(this);
        this.f.findViewById(j.b.e.A).setOnClickListener(this);
        TextView textView = (TextView) this.f.findViewById(j.b.e.f1749h);
        this.f976h = textView;
        textView.setOnClickListener(this);
        this.f.findViewById(j.b.e.q).setOnClickListener(this);
        this.f.findViewById(j.b.e.V).setOnClickListener(this);
    }

    private Node a(Node node) {
        Node node2 = this.d;
        node2.type = node.type;
        node2.duration = node.duration;
        node2.maxDuration = node.maxDuration;
        node2.text = node.text;
        node2.arg1 = node.arg1;
        node2.pathPoints = node.pathPoints == null ? null : new ArrayList<>(node.pathPoints);
        this.d.setCondition(node.getCondition() != null ? (Node) com.frame.q1.a(node.getCondition()) : null);
        return this.d;
    }

    private Rect b(Point point) {
        int i2 = point.x;
        int i3 = this.f979k;
        int i4 = point.y;
        return new Rect(i2 - i3, i4 - i3, i2 + i3, i4 + i3);
    }

    private int c(int i2, int i3) {
        for (int size = this.D.size() - 1; size >= 0; size--) {
            if (b(this.D.get(size)).contains(i2, i3)) {
                return size;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(long j2, long j3) {
        Node node = this.e;
        node.duration = j2;
        node.maxDuration = j3;
        if (j3 == 0) {
            this.g.setText("滑动时长：" + this.e.duration + "毫秒");
            return;
        }
        this.g.setText("滑动时长：" + this.e.duration + "~" + this.e.maxDuration + "毫秒");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        DurationSetDialogView durationSetDialogView = (DurationSetDialogView) com.frame.s0.g().B(DurationSetDialogView.class);
        Node node = this.e;
        durationSetDialogView.setDefaultValue(node.duration, node.maxDuration);
        durationSetDialogView.setSetDuration(new DurationSetDialogView.a() { // from class: com.v.qb
            @Override // com.v.DurationSetDialogView.a
            public final void a(long j2, long j3) {
                this.a.e(j2, j3);
            }
        });
    }

    private ArrayList<Integer> getStoredPoints() {
        ArrayList arrayList = new ArrayList(this.D.size() * 2);
        Iterator<Point> it = this.D.iterator();
        while (it.hasNext()) {
            Point next = it.next();
            arrayList.add(Integer.valueOf(next.x));
            arrayList.add(Integer.valueOf(next.y));
        }
        return kt.d(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Node node) {
        this.J.a(node == null ? null : a(node));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#99000000"));
        for (int i2 = 1; i2 < this.D.size(); i2++) {
            Point point = this.D.get(i2 - 1);
            Point point2 = this.D.get(i2);
            canvas.drawLine(point.x, point.y, point2.x, point2.y, this.A);
        }
        int i3 = 0;
        while (i3 < this.D.size()) {
            Point point3 = this.D.get(i3);
            canvas.drawCircle(point3.x, point3.y, this.f979k, this.A);
            if (i3 == this.H) {
                canvas.drawCircle(point3.x, point3.y, this.f979k * 1.3f, this.C);
            }
            com.frame.p1.d(canvas, this.t, i3 < 26 ? String.valueOf((char) (i3 + 65)) : String.valueOf(i3 + 1), point3.x, point3.y);
            i3++;
        }
        super.dispatchDraw(canvas);
    }

    public lt getCallback() {
        return this.J;
    }

    public void j() {
        if (this.D.size() < 2) {
            return;
        }
        float[] fArr = new float[this.D.size()];
        float[] fArr2 = new float[this.D.size()];
        for (int i2 = 0; i2 < this.D.size(); i2++) {
            fArr[i2] = this.D.get(i2).x;
            fArr2[i2] = this.D.get(i2).y;
        }
        this.c.setVisibility(0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "x", fArr);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.start();
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "y", fArr2);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.start();
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.c, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(1000L);
        objectAnimatorOfFloat3.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.B) {
            ArrayList<Integer> storedPoints = getStoredPoints();
            if (storedPoints.isEmpty()) {
                FloatToast.i("请至少设置两个滑动点");
                return;
            }
            com.frame.s0.g().o(this);
            Node node = this.e;
            node.type = 27;
            node.text = null;
            node.arg1 = null;
            node.pathPoints = storedPoints;
            this.J.a(a(node));
            return;
        }
        if (id == j.b.e.f1749h) {
            boolean z = !this.I;
            this.I = z;
            this.f976h.setText(z ? "取消添加" : "添加点");
            if (this.I) {
                FloatToast.i("请点击屏幕放置新的滑动点");
                return;
            }
            return;
        }
        if (id != j.b.e.q) {
            if (id != j.b.e.V) {
                if (id == j.b.e.A) {
                    this.J.a(null);
                    return;
                }
                return;
            } else {
                this.e.pathPoints = getStoredPoints();
                com.frame.s0.g().o(this);
                LengthScrollDialogView lengthScrollDialogView = (LengthScrollDialogView) com.frame.s0.g().x(LengthScrollDialogView.class);
                lengthScrollDialogView.l(this.K, this.e);
                lengthScrollDialogView.k(new lt() { // from class: com.v.sb
                    @Override // com.v.lt
                    public final void a(Node node2) {
                        this.a.i(node2);
                    }
                });
                return;
            }
        }
        this.I = false;
        this.f976h.setText("添加点");
        if (this.D.size() <= 2) {
            FloatToast.i("至少保留两个滑动点");
            return;
        }
        int i2 = this.H;
        if (i2 < 0 || i2 >= this.D.size()) {
            FloatToast.i("请先选择要删除的滑动点");
            return;
        }
        this.D.remove(this.H);
        this.H = Math.min(this.H, this.D.size() - 1);
        j();
        setSubViewPosition();
        postInvalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f.setVisibility(8);
            if (this.I) {
                Point point = new Point(x, y);
                this.G = point;
                this.D.add(point);
                this.H = this.D.size() - 1;
                this.I = false;
                this.f976h.setText("添加点");
            } else {
                int iC = c(x, y);
                this.H = iC;
                this.G = iC >= 0 ? this.D.get(iC) : null;
            }
            postInvalidate();
        } else if (action == 1) {
            this.G = null;
            j();
            setSubViewPosition();
        } else if (action == 2) {
            Point point2 = this.G;
            if (point2 != null) {
                point2.x = x;
                point2.y = y;
                postInvalidate();
            }
        } else if (action == 3) {
        }
        return true;
    }

    public void setCallback(lt ltVar) {
        this.J = ltVar;
    }

    public void setSubViewPosition() {
        boolean z;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int iD = com.frame.k0.c().d() - com.frame.p1.c(50.0f);
        Iterator<Point> it = this.D.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().y > iD) {
                z = true;
                break;
            }
        }
        if (z) {
            layoutParams.addRule(10);
        } else {
            layoutParams.addRule(12);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        int iC = com.frame.p1.c(20.0f);
        layoutParams2.topMargin = iC;
        layoutParams2.bottomMargin = iC;
        if (z) {
            layoutParams2.addRule(12);
        } else {
            layoutParams2.addRule(10);
        }
        this.f.setVisibility(0);
        this.f977i.setVisibility(0);
        if (this.f.getLayoutParams() == null) {
            addView(this.f, layoutParams);
            addView(this.f977i, layoutParams2);
        } else {
            this.f.setLayoutParams(layoutParams);
            this.f977i.setLayoutParams(layoutParams2);
        }
    }

    public void setTaskNode(Task task, Node node) {
        this.d = node;
        Node node2 = (Node) com.frame.q1.a(node);
        this.e = node2;
        this.K = task;
        this.f978j.setTaskNode(task, node2);
        if (this.e.maxDuration == 0) {
            this.g.setText("滑动时长：" + this.e.duration + "毫秒");
        } else {
            this.g.setText("滑动时长：" + this.e.duration + "~" + this.e.maxDuration + "毫秒");
        }
        this.D.clear();
        ArrayList<Integer> arrayListB = kt.b(this.e.pathPoints);
        for (int i2 = 0; i2 < arrayListB.size(); i2 += 2) {
            this.D.add(new Point(arrayListB.get(i2).intValue(), arrayListB.get(i2 + 1).intValue()));
        }
        if (this.D.size() < 2) {
            int iE = com.frame.k0.c().e() / 2;
            int iD = com.frame.k0.c().d() / 2;
            this.D.clear();
            this.D.add(new Point(iE, com.frame.p1.c(60.0f) + iD));
            this.D.add(new Point(iE, iD - com.frame.p1.c(60.0f)));
        }
        this.H = this.D.size() - 1;
        this.I = false;
        this.f976h.setText("添加点");
        j();
        post(new Runnable() { // from class: com.v.bt
            @Override // java.lang.Runnable
            public final void run() {
                this.c.setSubViewPosition();
            }
        });
        postInvalidate();
    }
}
