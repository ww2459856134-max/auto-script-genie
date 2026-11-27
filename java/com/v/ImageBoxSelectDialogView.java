package com.v;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ImageBoxAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.v.FileChooseView;
import com.v.ImageBoxSelectDialogView;
import com.v.ItemChooseDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.ImageBox;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ImageBoxSelectDialogView extends RelativeLayout implements View.OnClickListener, OnItemDragListener {
    private c c;
    private ImageBoxAdapter d;
    private Runnable e;
    private int f;

    class a implements BaseQuickAdapter.OnItemLongClickListener {
        a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
        public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            ImageBoxSelectDialogView.this.o(i2);
            return true;
        }
    }

    class b implements ItemChooseDialogView.b {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        static /* synthetic */ void b() {
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(FloatHandlerRecord.class);
            com.frame.s0.g().u(ImageBoxSelectDialogView.class);
            com.frame.s0.g().u(ImageScanDialogView.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(Rect rect, int i2) {
            for (int i3 = 0; i3 < 10; i3++) {
                SystemClock.sleep(200L);
                Bitmap bitmapX = i.b.i9.v().x();
                if (bitmapX != null) {
                    Bitmap bitmapB = com.frame.l0.b(bitmapX, rect, 1.0f);
                    if (bitmapB == null) {
                        return;
                    }
                    File file = new File(i.b.da.z(), "/img/" + System.currentTimeMillis() + ".jpg");
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    com.frame.l0.d(bitmapB, file);
                    ImageBoxSelectDialogView.this.d.getItem(i2).urls.add(file.getAbsolutePath());
                    i.b.b8.c().d(ImageBoxSelectDialogView.this.d.getData());
                    com.frame.l1.f(new Runnable() { // from class: com.v.s9
                        @Override // java.lang.Runnable
                        public final void run() {
                            ImageBoxSelectDialogView.b.b();
                        }
                    }, 300L);
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(RectChooseView rectChooseView, final int i2, View view) {
            final Rect rect = rectChooseView.getRect();
            com.frame.s0.g().d(RectChooseView.class);
            i.b.i9.v().n();
            com.frame.l1.g(new Runnable() { // from class: com.v.v9
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d(rect, i2);
                }
            });
        }

        static /* synthetic */ void g(View view) {
            com.frame.s0.g().d(RectChooseView.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(FloatHandlerRecord.class);
            com.frame.s0.g().u(ImageScanDialogView.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(int i2, Uri uri) throws Throwable {
            File file = new File(i.b.da.z(), "/img/" + com.frame.r0.t(com.frame.v0.g(), uri));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                com.frame.r0.A(uri, file);
                ImageBoxSelectDialogView.this.d.getItem(i2).urls.add(file.getAbsolutePath());
            } catch (Exception unused) {
                FloatToast.i("文件错误，请确定是图片文件");
            }
            i.b.b8.c().d(ImageBoxSelectDialogView.this.d.getData());
            com.frame.s0.g().d(ItemChooseDialogView.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean k(int i2, String str) {
            ImageBoxSelectDialogView.this.d.getItem(i2).name = str;
            ImageBoxSelectDialogView.this.d.notifyItemChanged(i2);
            return true;
        }

        @Override // com.v.ItemChooseDialogView.b
        public void a(int i2, List<String> list) {
            if (i2 == 0) {
                com.frame.s0.g().d(ImageScanDialogView.class);
                com.frame.s0.g().d(ItemChooseDialogView.class);
                com.frame.s0.g().i(NodeListDialogView.class);
                com.frame.s0.g().i(FlowView.class);
                com.frame.s0.g().i(FloatHandlerRecord.class);
                com.frame.s0.g().i(ImageBoxSelectDialogView.class);
                final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
                rectChooseView.setHit("滑动选取识别图片");
                final int i3 = this.a;
                rectChooseView.r("确定", new View.OnClickListener() { // from class: com.v.u9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.f(rectChooseView, i3, view);
                    }
                });
                rectChooseView.q("取消", new View.OnClickListener() { // from class: com.v.r9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ImageBoxSelectDialogView.b.g(view);
                    }
                });
                return;
            }
            if (i2 == 1) {
                FileChooseView fileChooseView = (FileChooseView) com.frame.s0.g().B(FileChooseView.class);
                fileChooseView.setPickMimeType("image/*");
                final int i4 = this.a;
                fileChooseView.setUriCallback(new FileChooseView.c() { // from class: com.v.t9
                    @Override // com.v.FileChooseView.c
                    public final void a(Uri uri) throws Throwable {
                        this.a.i(i4, uri);
                    }
                });
                return;
            }
            if (i2 == 2) {
                com.frame.s0.g().d(ItemChooseDialogView.class);
                ((ImageListDialogView) com.frame.s0.g().x(ImageListDialogView.class)).setDefaultData(-1, ImageBoxSelectDialogView.this.d.getItem(this.a).urls);
                return;
            }
            if (i2 == 3) {
                com.frame.s0.g().d(ItemChooseDialogView.class);
                InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
                inputDialogView.v(1);
                inputDialogView.w(ImageBoxSelectDialogView.this.d.getItem(this.a).name);
                inputDialogView.s("请输入图集名称");
                final int i5 = this.a;
                inputDialogView.t(new InputDialogView.a() { // from class: com.v.w9
                    @Override // com.yl.float_ui.InputDialogView.a
                    public final boolean a(String str) {
                        return this.a.k(i5, str);
                    }
                });
                return;
            }
            if (i2 != 4) {
                if (i2 != 5) {
                    return;
                }
                com.frame.s0.g().d(ItemChooseDialogView.class);
                ImageBoxSelectDialogView.this.d.remove(this.a);
                return;
            }
            com.frame.s0.g().d(ItemChooseDialogView.class);
            ImageBox item = ImageBoxSelectDialogView.this.d.getItem(this.a);
            com.frame.s0.g().d(ItemChooseDialogView.class);
            ImageBox imageBox = (ImageBox) com.frame.q1.a(item);
            imageBox.name += "(副本)";
            imageBox.id = System.currentTimeMillis();
            ImageBoxSelectDialogView.this.d.addData(this.a, (int) imageBox);
        }
    }

    public interface c {
        void a(int i2, List<ImageBox> list);
    }

    public ImageBoxSelectDialogView() {
        this(com.frame.v0.g());
    }

    private void d() {
        View.inflate(com.frame.v0.g(), j.b.f.f, this);
        setGravity(17);
        ((TextView) findViewById(j.b.e.w6)).setText("选择图集");
        this.d = new ImageBoxAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.d);
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.d));
        k0Var.j(recyclerView);
        this.d.enableDragItem(k0Var, j.b.e.N, false);
        this.d.setOnItemDragListener(this);
        ImageView imageView = (ImageView) findViewById(j.b.e.X);
        imageView.setImageResource(j.b.d.L0);
        imageView.setOnClickListener(this);
        imageView.setVisibility(0);
        imageView.setImageTintList(null);
        imageView.setImageTintMode(null);
        TextView textView = (TextView) findViewById(j.b.e.g6);
        textView.setVisibility(0);
        textView.setText("长按图集可以给图集添加图片");
        TextView textView2 = (TextView) findViewById(j.b.e.g);
        textView2.setOnClickListener(this);
        textView2.setText("确定");
        TextView textView3 = (TextView) findViewById(j.b.e.P);
        textView3.setOnClickListener(this);
        textView3.setText("取消");
        TextView textView4 = new TextView(com.frame.v0.g());
        textView4.setText("无内容~");
        textView4.setGravity(17);
        textView4.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.d.setEmptyView(textView4);
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.ba
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.j(baseQuickAdapter, view, i2);
            }
        });
        this.d.setOnItemLongClickListener(new a());
        com.frame.l1.g(new Runnable() { // from class: com.v.x9
            @Override // java.lang.Runnable
            public final void run() {
                this.c.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean f(String str) {
        ImageBox imageBox = new ImageBox();
        imageBox.id = System.currentTimeMillis();
        imageBox.name = str;
        this.d.addData(0, (int) imageBox);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(View view) {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.s("请输入图片集名称~");
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.y9
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.f(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (this.f == 0) {
            this.d.c(i2);
        } else {
            o(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(List list) {
        setDefaultData(-1, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        final List<ImageBox> listB = i.b.b8.c().b();
        com.frame.l1.e(new Runnable() { // from class: com.v.aa
            @Override // java.lang.Runnable
            public final void run() {
                this.c.l(listB);
            }
        });
    }

    public void b() {
        if (!this.d.getData().isEmpty()) {
            this.d.addFooterView(c());
        } else {
            this.d.setEmptyView(c());
            this.d.addFooterView(c());
        }
    }

    public View c() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.y0, null);
        viewInflate.setBackgroundResource(j.b.c.a);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.K5);
        textView.setText("新建图集");
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = com.frame.p1.c(15.0f);
        layoutParams.rightMargin = com.frame.p1.c(15.0f);
        viewInflate.setLayoutParams(layoutParams);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.z9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.h(view);
            }
        });
        return viewInflate;
    }

    public Runnable getOnCancelListener() {
        return this.e;
    }

    public void o(int i2) {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择菜单");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("添加图片,从文件选择图片,查看列表,重命名,复制,删除".split(","))));
        itemChooseDialogView.setOnTextChoose(new b(i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.d.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(ImageBoxSelectDialogView.class);
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (id == j.b.e.X) {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("长按图集可以为此图集添加图片，图集识别可以快速的识别多张图片，一旦识别的图集中的任意一张图片就能触发操作，如果需要全部图片都识别到后才做操作可以用逻辑判断来做。");
            dingMsgView.i("知道了", null);
        } else if (id == j.b.e.g) {
            if (this.f == 0 && this.d.e() == -1) {
                FloatToast.i("还未选择~");
                return;
            }
            com.frame.s0.g().d(ImageBoxSelectDialogView.class);
            c cVar = this.c;
            if (cVar != null) {
                cVar.a(this.d.e(), this.d.getData());
            }
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public void onItemDragEnd(RecyclerView.d0 d0Var, int i2) {
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public void onItemDragMoving(RecyclerView.d0 d0Var, int i2, RecyclerView.d0 d0Var2, int i3) {
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public void onItemDragStart(RecyclerView.d0 d0Var, int i2) {
    }

    public void setDefaultData(int i2, List<ImageBox> list) {
        this.d.setNewData(list);
        this.d.c(i2);
    }

    public void setListType() {
        this.f = 1;
        ((TextView) findViewById(j.b.e.g)).setText("保存");
    }

    public void setOnCancelListener(Runnable runnable) {
        this.e = runnable;
    }

    public void setOnImageBoxChoose(c cVar) {
        this.c = cVar;
    }

    public ImageBoxSelectDialogView(Context context) {
        this(context, null);
    }

    public ImageBoxSelectDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        d();
    }

    public void setDefaultData(int i2) {
        this.d.c(i2);
    }
}
