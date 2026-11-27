package i.b.ka;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import com.google.gson.Gson;
import com.tencent.open.SocialConstants;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.ItemChooseDialogView;
import com.v.RectChooseView;
import com.v.item.ParamNameTextView;
import com.v.lt;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.i9;
import i.b.t9;
import i.b.v8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes.dex */
public class h7 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(t9 t9Var, LinkedHashMap linkedHashMap, Node node, Runnable runnable) throws JSONException {
        o(t9Var, linkedHashMap, node, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(final t9 t9Var, final LinkedHashMap linkedHashMap, final Node node, final Runnable runnable) {
        t9Var.W(new Runnable() { // from class: i.b.ka.j4
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.c.U(t9Var, linkedHashMap, node, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z(RectChooseView rectChooseView, lt ltVar, View view) {
        com.frame.s0.g().d(RectChooseView.class);
        Q(ltVar, v8.m().b0(3, rectChooseView.getRect(), null));
        FloatToast.g(j.b.d.h0, "已截图保存至剪切板");
        com.frame.s0.g().u(FloatHandlerRecord.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(RectChooseView rectChooseView, lt ltVar, View view) {
        com.frame.s0.g().d(RectChooseView.class);
        Q(ltVar, v8.m().b0(2, rectChooseView.getRect(), null));
        FloatToast.g(j.b.d.h0, "已截图保存至相册");
        com.frame.s0.g().u(FloatHandlerRecord.class);
    }

    static /* synthetic */ void c0(RectChooseView rectChooseView, View view) {
        com.frame.s0.g().o(rectChooseView);
        com.frame.s0.g().u(FloatHandlerRecord.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean e0(lt ltVar, String str) {
        Q(ltVar, v8.m().b0(3, null, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g0(final lt ltVar, int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            Q(ltVar, v8.m().b0(4, null, null));
            com.frame.s0.g().u(FloatHandlerRecord.class);
            return;
        }
        if (1 == i2) {
            com.frame.s0.g().i(FloatHandlerRecord.class);
            final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
            rectChooseView.q("发送图片", new View.OnClickListener() { // from class: i.b.ka.l4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.Z(rectChooseView, ltVar, view);
                }
            });
            rectChooseView.setHit("滑动选取截图区域");
            rectChooseView.r("保存至相册", new View.OnClickListener() { // from class: i.b.ka.i4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.b0(rectChooseView, ltVar, view);
                }
            });
            rectChooseView.p("取消", new View.OnClickListener() { // from class: i.b.ka.k4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h7.c0(rectChooseView, view);
                }
            });
            return;
        }
        if (2 == i2) {
            ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
            paramNameTextView.setInputHint("请输入坐标或变量");
            paramNameTextView.setInputLabel("格式如：100,110-200,304");
            paramNameTextView.setText((CharSequence) null);
            paramNameTextView.k(new InputDialogView.a() { // from class: i.b.ka.o4
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return this.a.e0(ltVar, str);
                }
            });
        }
    }

    @Override // i.b.ka.x5
    public int B() {
        return 12;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择菜单");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("全屏截图,局部截图,坐标区域截图".split(","))));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: i.b.ka.p4
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i3, List list) {
                this.a.g0(ltVar, i3, list);
            }
        });
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:57|68|58|59|77) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0186, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0188, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0189, code lost:
    
        com.frame.k0.r(r4);
        android.widget.Toast.makeText(com.frame.v0.g(), "图片截取失败", 0).show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a0, code lost:
    
        com.frame.l0.c(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a3, code lost:
    
        throw r12;
     */
    @Override // i.b.ka.x5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean p(final LinkedHashMap<Long, Node> linkedHashMap, final Node node, final Runnable runnable) throws JSONException {
        com.frame.y0.g("屏幕截取：" + node.getName());
        if (node.what == 4) {
            if (Build.VERSION.SDK_INT >= 28) {
                com.frame.w0.b().performGlobalAction(9);
            } else {
                com.frame.y0.j("安卓SDK版本低于28，不能使用全局截屏。");
            }
            this.c.W(runnable);
            return true;
        }
        Rect areaOrParam = node.getAreaOrParam();
        if (node.hasAreaResolveError()) {
            k(node, runnable);
            return false;
        }
        if (areaOrParam == null) {
            areaOrParam = (Rect) new Gson().j(node.extra.toString(), Rect.class);
        }
        i9 i9VarV = i9.v();
        if (!i9VarV.B()) {
            final t9 t9Var = this.c;
            i9VarV.n0(new Runnable() { // from class: i.b.ka.n4
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.W(t9Var, linkedHashMap, node, runnable);
                }
            });
            i9VarV.q0();
            return true;
        }
        i9VarV.n();
        for (int i2 = 0; i2 < 20; i2++) {
            SystemClock.sleep(200L);
            Bitmap bitmapX = i9VarV.x();
            if (bitmapX != null) {
                Bitmap bitmapB = com.frame.l0.b(bitmapX, areaOrParam, 1.0f);
                com.frame.l0.c(bitmapX);
                if (bitmapB != null) {
                    Log.e("图片截取", areaOrParam.toString());
                    int i3 = node.what;
                    if (i3 == 3) {
                        try {
                            Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(com.frame.v0.g().getContentResolver(), bitmapB, System.currentTimeMillis() + "", SocialConstants.PARAM_COMMENT));
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.putExtra("android.intent.extra.STREAM", uri);
                            intent.setType("image/*");
                            intent.setFlags(268435456);
                            intent.addCategory("android.intent.category.DEFAULT");
                            if (intent.resolveActivity(com.frame.v0.g().getPackageManager()) != null) {
                                com.frame.v0.g().startActivity(intent);
                            } else {
                                com.frame.l1.e(new Runnable() { // from class: i.b.ka.m4
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        FloatToast.i("未找到可以处理的应用");
                                    }
                                });
                            }
                        } catch (Exception e) {
                            com.frame.k0.r(e);
                        }
                    } else if (i3 == 1) {
                        try {
                            ((ClipboardManager) com.frame.v0.g().getSystemService("clipboard")).setPrimaryClip(ClipData.newUri(com.frame.v0.g().getContentResolver(), "Image", Uri.parse(MediaStore.Images.Media.insertImage(com.frame.v0.g().getContentResolver(), bitmapB, System.currentTimeMillis() + "", SocialConstants.PARAM_COMMENT))));
                        } catch (Exception e2) {
                            com.frame.k0.r(e2);
                        }
                    } else if (i3 == 2) {
                        try {
                            MediaStore.Images.Media.insertImage(com.frame.v0.g().getContentResolver(), bitmapB, System.currentTimeMillis() + "", SocialConstants.PARAM_COMMENT);
                        } catch (Exception e3) {
                            com.frame.k0.r(e3);
                        }
                    }
                    this.c.W(runnable);
                    return true;
                }
                continue;
            }
        }
        da.B().w1("超时：" + node.getName());
        return true;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.h0;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "屏幕截屏";
    }
}
