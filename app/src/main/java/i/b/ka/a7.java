package i.b.ka;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.tencent.connect.common.Constants;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.GesturePlayFloatView;
import com.v.MultiLogicDialogView;
import com.v.ParamsInitDialogView;
import com.v.RunConditionDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.ui.v;
import i.b.da;
import i.b.i9;
import i.b.t9;
import i.b.v8;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class a7 extends x5 {
    private BigDecimal T(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        try {
            return bigDecimal.divide(bigDecimal2);
        } catch (ArithmeticException unused) {
            return bigDecimal.divide(bigDecimal2, V(bigDecimal, bigDecimal2), RoundingMode.HALF_UP);
        }
    }

    private int V(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return Math.max(Math.max(bigDecimal.scale(), bigDecimal2.scale()), 10);
    }

    private Bitmap Y(Node node) {
        Rect areaOrParam = node.getAreaOrParam();
        if (!node.hasAreaResolveError() && areaOrParam != null) {
            i9.v().n();
            for (int i2 = 0; i2 < 20; i2++) {
                SystemClock.sleep(200L);
                Bitmap bitmapX = i9.v().x();
                if (bitmapX != null) {
                    Bitmap bitmapB = com.frame.l0.b(bitmapX, areaOrParam, 1.0f);
                    com.frame.l0.c(bitmapX);
                    if (bitmapB != null) {
                        return bitmapB;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean a0(String str, Runnable runnable, Dialog dialog, String str2) {
        da.B().E1(str, str2);
        this.c.W(runnable);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(final String str, final Runnable runnable) {
        da.B().r(new v.b() { // from class: i.b.ka.o2
            @Override // com.yl.ui.v.b
            public final boolean a(Dialog dialog, String str2) {
                return this.a.a0(str, runnable, dialog, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0(lt ltVar, Node node, Node node2) {
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g0(lt ltVar, DialogInterface dialogInterface) {
        c(ltVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j0(Node node, lt ltVar) {
        if (!com.frame.s0.g().b(MultiLogicDialogView.class) && !com.frame.s0.g().b(RunConditionDialogView.class)) {
            com.frame.l1.f(new Runnable() { // from class: i.b.ka.q2
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().u(FloatHandlerRecord.class);
                }
            }, 600L);
            v8.m().a0(node);
        }
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l0(final Node node, final lt ltVar, Node node2) {
        new t9(v8.m().p()).W(new Runnable() { // from class: i.b.ka.s2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.j0(node, ltVar);
            }
        });
    }

    private BigDecimal m0(String str) {
        return new BigDecimal(str.replaceAll(",", "").trim());
    }

    @Override // i.b.ka.x5
    public int B() {
        return 24;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, final Node node, final lt ltVar) {
        ParamsInitDialogView paramsInitDialogView = (ParamsInitDialogView) com.frame.s0.g().B(ParamsInitDialogView.class);
        paramsInitDialogView.setTaskNode(task, node);
        paramsInitDialogView.u(new lt() { // from class: i.b.ka.r2
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.e0(ltVar, node, node2);
            }
        });
        if (i2 == 1) {
            paramsInitDialogView.setMiniModel();
        }
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        final Node nodeQ = v8.m().Q();
        ParamsInitDialogView paramsInitDialogView = (ParamsInitDialogView) com.frame.s0.g().B(ParamsInitDialogView.class);
        paramsInitDialogView.setTaskNode(v8.m().p(), nodeQ);
        if (i2 == 1) {
            paramsInitDialogView.setMiniModel();
        }
        paramsInitDialogView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.ka.p2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.c.g0(ltVar, dialogInterface);
            }
        });
        paramsInitDialogView.u(new lt() { // from class: i.b.ka.t2
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.l0(nodeQ, ltVar, node);
            }
        });
    }

    public String U(BigDecimal bigDecimal) {
        return bigDecimal == null ? "0" : bigDecimal.stripTrailingZeros().toPlainString();
    }

    public String W(String str) {
        return (TextUtils.isEmpty(str) || !str.contains("${")) ? "" : X(str.replace("${", "").replace("}", ""));
    }

    public String X(String str) {
        return "<font color='#55CA9B'>[" + str + "]</font>";
    }

    public boolean n0(Node node) {
        String strG = da.B().G(node.text);
        String strX = X(strG);
        String strH = da.B().H(strG);
        String strW = W(node.arg2);
        String strG2 = da.B().G(node.arg2);
        boolean zEquals = false;
        if ("是否等于".equals(node.arg1)) {
            try {
                zEquals = strH.trim().equals(strG2.trim());
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            com.frame.y0.g(node.getStepAndName() + ".是否等于(" + strH + strX + "=" + strG2 + strW + ")=" + zEquals);
        } else if ("是否大于".equals(node.arg1)) {
            try {
            } catch (Exception unused) {
                if (strH != null && !"null".equals(strW)) {
                    try {
                        if (strH.trim().compareTo(strG2.trim()) > 0) {
                        }
                    } catch (Exception e2) {
                        com.frame.y0.g(node.getStepAndName() + ".是否大于(" + strH + strX + ">" + strG2 + strW + ")=出错：false");
                        com.frame.k0.r(e2);
                    }
                }
            }
            if (m0(strH).compareTo(m0(strG2)) > 0) {
                zEquals = true;
            }
            try {
                com.frame.y0.g(node.getStepAndName() + ".是否大于(" + strH + strX + ">" + strG2 + strW + ")=" + zEquals);
            } catch (Exception unused2) {
                com.frame.y0.g(node.getStepAndName() + ".是否大于(" + strH + strX + ">" + strG2 + strW + ")=出错：" + zEquals);
            }
        } else if ("是否小于".equals(node.arg1)) {
            try {
            } catch (Exception unused3) {
                if (strH != null && !"null".equals(strW)) {
                    try {
                        if (strH.trim().compareTo(strG2.trim()) < 0) {
                        }
                    } catch (Exception e3) {
                        com.frame.y0.g(node.getStepAndName() + ".是否小于(" + strH + strX + "＜" + strG2 + strW + ")=出错：false");
                        com.frame.k0.r(e3);
                    }
                }
            }
            if (m0(strH).compareTo(m0(strG2)) < 0) {
                zEquals = true;
            }
            try {
                com.frame.y0.g(node.getStepAndName() + ".是否小于(" + strH + strX + "＜" + strG2 + strW + ")=" + zEquals);
            } catch (Exception unused4) {
                com.frame.y0.g(node.getStepAndName() + ".是否小于(" + strH + strX + "＜" + strG2 + strW + ")=出错：" + zEquals);
            }
        } else if ("是否包含".equals(node.arg1)) {
            try {
                zEquals = strH.contains(strG2);
            } catch (Exception e4) {
                com.frame.k0.r(e4);
            }
            com.frame.y0.g(node.getStepAndName() + ".是否包含(" + strH + strX + " contain " + strG2 + strW + ")=" + zEquals);
        } else if ("是否不包含".equals(node.arg1)) {
            try {
                zEquals = !strH.contains(strG2);
            } catch (Exception e5) {
                com.frame.k0.r(e5);
            }
            com.frame.y0.g(node.getStepAndName() + ".是否不包含(" + strH + strX + " not contain " + strG2 + strW + ")=" + zEquals);
        } else if ("是否被包含".equals(node.arg1)) {
            try {
                zEquals = strG2.contains(strH);
            } catch (Exception e6) {
                com.frame.k0.r(e6);
            }
            com.frame.y0.g(node.getStepAndName() + ".是否被包含(" + strH + strX + " contain by " + strG2 + strW + ")=" + zEquals);
        } else if ("是否不被包含".equals(node.arg1)) {
            try {
                zEquals = !strG2.contains(strH);
            } catch (Exception e7) {
                com.frame.k0.r(e7);
            }
            com.frame.y0.g(node.getStepAndName() + ".是否不被包含(" + strH + strX + "not contain by " + strG2 + strW + ")=" + zEquals);
        }
        return zEquals;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(22:367|92|(2:94|95)(1:96)|97|(3:348|98|99)|(7:350|100|101|338|102|342|103)|(2:361|104)|(2:365|105)|321|124|125|325|126|336|127|330|128|140|357|141|149|150) */
    /* JADX WARN: Can't wrap try/catch for region: R(30:367|92|(2:94|95)(1:96)|97|348|98|99|350|100|101|338|102|342|103|(2:361|104)|(2:365|105)|321|124|125|325|126|336|127|330|128|140|357|141|149|150) */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x069d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x069e, code lost:
    
        r16 = r0;
        r23 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x06a3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x06a4, code lost:
    
        r16 = r0;
        r23 = r14;
        r22 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x06ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x06ac, code lost:
    
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x06af, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x06b0, code lost:
    
        r16 = r0;
        r21 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x06b4, code lost:
    
        r22 = 0;
        r23 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x06b8, code lost:
    
        com.frame.y0.j(r4 + "偏移值非区域变量，请检查格式是否是x,y-x1,y1");
        com.frame.k0.r(r16);
        r14 = r23;
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x06fc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v38, types: [i.b.ka.a7] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // i.b.ka.x5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, final Runnable runnable) throws Throwable {
        Runnable runnable2;
        String strG;
        Object obj;
        a7 a7Var;
        ?? r3;
        String str;
        String str2;
        String str3;
        Exception exc;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str4;
        String[] strArrSplit;
        String[] strArrSplit2;
        String str5;
        int i7;
        int iA;
        String str6;
        String str7;
        String str8;
        Exception exc2;
        String str9;
        int i8;
        int i9;
        String str10;
        Exception exc3;
        int i10;
        int i11;
        int i12;
        String[] strArrSplit3;
        String strSubstring;
        String str11;
        a7 a7Var2;
        final String strG2 = da.B().G(node.text);
        String strG3 = "";
        switch (node.what) {
            case 1:
                final a7 a7Var3 = this;
                if ("0".equals(node.arg1)) {
                    strG = da.B().G(node.arg2);
                    runnable2 = runnable;
                } else {
                    if ("1".equals(node.arg1)) {
                        com.frame.l1.e(new Runnable() { // from class: i.b.ka.n2
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.c0(strG2, runnable);
                            }
                        });
                        return true;
                    }
                    runnable2 = runnable;
                    if ("2".equals(node.arg1)) {
                        String strX = com.frame.r0.x(da.B().G(node.arg2));
                        if (!TextUtils.isEmpty(node.arg5)) {
                            String[] strArrSplit4 = strX.split(node.arg5, -1);
                            if ("顺序读取".equals(node.arg4)) {
                                try {
                                    obj = da.B().A().get("textLoop:" + node.id);
                                } catch (Exception e) {
                                    com.frame.k0.r(e);
                                }
                                int i13 = obj != null ? Integer.parseInt(obj.toString()) : 0;
                                strX = strArrSplit4[i13 % strArrSplit4.length];
                                da.B().A().put("textLoop:" + node.id, Integer.valueOf(i13 + 1));
                            } else if ("随机读取".equals(node.arg4)) {
                                strX = strArrSplit4[new Random().nextInt(strArrSplit4.length)];
                            }
                        }
                        if ("1".equals(node.arg6)) {
                            strX = strX.trim();
                        }
                        strG = strX;
                    } else if ("3".equals(node.arg1)) {
                        strG = da.B().H(node.arg2);
                    } else if (Constants.VIA_TO_TYPE_QZONE.equals(node.arg1)) {
                        strG = com.frame.r0.m(node.arg2);
                    } else if ("5".equals(node.arg1)) {
                        File file = new File(da.z(), "temps.jpg");
                        if (file.exists() && !file.delete()) {
                            da.B().w1("截图转成Base64失败，旧临时图片无法清理。");
                            return true;
                        }
                        Bitmap bitmapY = a7Var3.Y(node);
                        if (bitmapY == null) {
                            da.B().w1("截图转成Base64失败，请检查录屏权限和截图区域设置。");
                            return true;
                        }
                        try {
                            com.frame.l0.d(bitmapY, file);
                            com.frame.l0.c(bitmapY);
                            if (!file.exists() || file.length() == 0) {
                                da.B().w1("截图转成Base64失败，临时图片保存失败。");
                                return true;
                            }
                            strG = com.frame.r0.m(file.getAbsolutePath());
                        } catch (Throwable th) {
                            com.frame.l0.c(bitmapY);
                            throw th;
                        }
                    } else {
                        strG = (Constants.VIA_SHARE_TYPE_INFO.equals(node.arg1) || "7".equals(node.arg1)) ? da.B().G(node.arg2) : null;
                    }
                }
                da.B().E1(strG2, strG);
                com.frame.y0.g(node.getStepAndName() + ".变量赋值:" + strG2 + "=" + strG);
                a7Var2 = a7Var3;
                a7Var2.c.W(runnable2);
                return true;
            case 2:
                a7Var = this;
                String strH = da.B().H(strG2);
                com.frame.m0.a(strH);
                FloatToast.g(j.b.d.O, "变量赋值到剪切板");
                com.frame.y0.g(node.getStepAndName() + ".变量(" + strG2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + strH + ")赋值到剪切板");
                runnable2 = runnable;
                a7Var2 = a7Var;
                a7Var2.c.W(runnable2);
                return true;
            case 3:
                a7 a7Var4 = this;
                String strG4 = da.B().G(node.arg2);
                String strG5 = da.B().G(da.B().H(strG2));
                com.frame.y0.g(node.getStepAndName() + ".将变量写入文件:" + strG4 + ParameterizedMessage.ERROR_MSG_SEPARATOR + strG2 + "=" + strG5);
                if ("覆盖文本".equals(node.arg3)) {
                    com.frame.r0.y(strG4, strG5, false);
                    a7Var = a7Var4;
                } else {
                    if (!TextUtils.isEmpty(node.arg4)) {
                        strG5 = strG5 + node.arg4;
                    }
                    com.frame.r0.y(strG4, strG5, true);
                    a7Var = a7Var4;
                }
                runnable2 = runnable;
                a7Var2 = a7Var;
                a7Var2.c.W(runnable2);
                return true;
            case 4:
            default:
                runnable2 = runnable;
                a7Var2 = this;
                a7Var2.c.W(runnable2);
                return true;
            case 5:
                String strX2 = X(strG2);
                String strH2 = da.B().H(strG2);
                if (!TextUtils.isEmpty(node.arg4)) {
                    strG2 = node.arg4;
                }
                String strW = W(node.arg2);
                String strG6 = da.B().G(node.arg2);
                try {
                } catch (Exception e2) {
                    e = e2;
                    r3 = this;
                }
                if ("提取数字".equals(node.arg1)) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(strH2);
                    if (matcher.find()) {
                        String strGroup = matcher.group();
                        com.frame.y0.g("提取数字(" + strX2 + ")=" + strGroup);
                        da.B().E1(strG2, strGroup);
                    } else {
                        com.frame.y0.j("提取数字(" + strX2 + ")=提取不到数字");
                        da.B().E1(strG2, "null");
                    }
                } else if ("除以".equals(node.arg1)) {
                    BigDecimal bigDecimalM0 = m0(strH2);
                    BigDecimal bigDecimalM02 = m0(strG6);
                    String strU = U(T(bigDecimalM0, bigDecimalM02));
                    com.frame.y0.g("除以(" + U(bigDecimalM0) + strX2 + "/" + U(bigDecimalM02) + strW + ")=" + strU);
                    da.B().E1(strG2, strU);
                } else if ("时间格式化".equals(node.arg1)) {
                    String str12 = new SimpleDateFormat(strG6).format(i.b.q7.b(strH2));
                    com.frame.y0.g("时间格式化(" + strH2 + "," + strG6 + ")=" + str12);
                    da.B().E1(strG2, str12);
                } else if ("正则查找".equals(node.arg1)) {
                    Matcher matcher2 = Pattern.compile(strG6).matcher(strH2);
                    matcher2.find();
                    String strGroup2 = matcher2.group();
                    com.frame.y0.g("正则查找(" + strG6 + ")=" + strGroup2);
                    da.B().E1(strG2, strGroup2);
                } else if ("乘以".equals(node.arg1)) {
                    BigDecimal bigDecimalM03 = m0(strH2);
                    BigDecimal bigDecimalM04 = m0(strG6);
                    String strU2 = U(bigDecimalM03.multiply(bigDecimalM04));
                    com.frame.y0.g("乘以(" + U(bigDecimalM03) + strX2 + "*" + U(bigDecimalM04) + strW + ")=" + strU2);
                    da.B().E1(strG2, strU2.toString());
                } else if ("加上".equals(node.arg1)) {
                    BigDecimal bigDecimalM05 = m0(strH2);
                    BigDecimal bigDecimalM06 = m0(strG6);
                    String strU3 = U(bigDecimalM05.add(bigDecimalM06));
                    com.frame.y0.g("加上(" + U(bigDecimalM05) + strX2 + "+" + U(bigDecimalM06) + strW + ")=" + strU3);
                    da.B().E1(strG2, strU3.toString());
                } else {
                    if (!"减去".equals(node.arg1)) {
                        if ("追加字符".equals(node.arg1)) {
                            String str13 = strH2 + strG6;
                            com.frame.y0.g(node.getStepAndName() + ".追加字符(" + strH2 + strX2 + "+" + strG6 + strW + ")=" + str13);
                            da.B().E1(strG2, str13);
                        } else if ("字符前追加".equals(node.arg1)) {
                            String str14 = strG6 + strH2;
                            com.frame.y0.g(node.getStepAndName() + ".字符前追加(" + strG6 + strW + "+" + strH2 + strX2 + ")=" + str14);
                            da.B().E1(strG2, str14);
                        } else if ("随机数字".equals(node.arg1)) {
                            String str15 = node.arg2.split("&&~")[0];
                            String str16 = node.arg2.split("&&~")[1];
                            String strW2 = W(str15);
                            String strW3 = W(str16);
                            int iIntValue = Integer.valueOf(da.B().G(str15)).intValue();
                            int iIntValue2 = Integer.valueOf(da.B().G(str16)).intValue();
                            int iA2 = o.a.f.a(iIntValue, iIntValue2);
                            com.frame.y0.g(node.getStepAndName() + ".随机数字(" + iIntValue + strW2 + "~" + iIntValue2 + strW3 + ")=" + iA2);
                            da daVarB = da.B();
                            StringBuilder sb = new StringBuilder();
                            sb.append(iA2);
                            sb.append("");
                            daVarB.E1(strG2, sb.toString());
                        } else if ("文字替换".equals(node.arg1)) {
                            String[] strArrSplit5 = strG6.split("&&~", -1);
                            String str17 = strArrSplit5[0];
                            String strW4 = W(str17);
                            String strG7 = da.B().G(str17);
                            if (strArrSplit5.length <= 1 || TextUtils.isEmpty(strArrSplit5[1])) {
                                str11 = "";
                            } else {
                                String str18 = strArrSplit5[1];
                                String strW5 = W(str18);
                                strG3 = da.B().G(str18);
                                str11 = strW5;
                            }
                            String strW6 = W(strH2);
                            String strG8 = da.B().G(strH2);
                            if (!TextUtils.isEmpty(strG7)) {
                                strG8 = strG8.replace(strG7, strG3);
                            }
                            com.frame.y0.g(node.getStepAndName() + ".文字替换(将" + strG7 + strW4 + " 替换成 " + strG3 + str11 + "):" + strG2 + "=" + strG8 + strW6);
                            da.B().E1(strG2, strG8);
                        } else {
                            if (!"长度分割".equals(node.arg1)) {
                                if ("区域扩大".equals(node.arg1)) {
                                    try {
                                        String str19 = strG6.split("&&~")[0];
                                        String strW7 = W(str19);
                                        String strG9 = da.B().G(str19);
                                        if (strG6.endsWith("&&~")) {
                                            str = "";
                                        } else {
                                            String str20 = strG6.split("&&~")[1];
                                            String strW8 = W(str20);
                                            strG3 = da.B().G(str20);
                                            str = strW8;
                                        }
                                        String strW9 = W(strH2);
                                        String strG10 = da.B().G(strH2);
                                        try {
                                            strArrSplit = strG10.split(ProcessIdUtil.DEFAULT_PROCESSID);
                                            str2 = strG10;
                                        } catch (Exception e3) {
                                            e = e3;
                                            str2 = strG10;
                                        }
                                        try {
                                            str3 = ",";
                                            try {
                                                String[] strArrSplit6 = strArrSplit[0].split(str3);
                                                strArrSplit2 = strArrSplit[1].split(str3);
                                                i3 = Integer.parseInt(strArrSplit6[0]);
                                                try {
                                                    i5 = Integer.parseInt(strArrSplit6[1]);
                                                } catch (Exception e4) {
                                                    exc = e4;
                                                    i2 = 0;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                exc = e;
                                                i2 = 0;
                                                i3 = 0;
                                                i4 = 0;
                                                try {
                                                    com.frame.y0.j(strG2 + "变量非坐标变量，请检查格式是否是x,y");
                                                    com.frame.k0.r(exc);
                                                    i5 = i2;
                                                    i6 = 0;
                                                    String[] strArrSplit7 = strG9.split(str3);
                                                    String[] strArrSplit8 = strG3.split(str3);
                                                    int i14 = Integer.parseInt(strArrSplit7[0]);
                                                    int i15 = Integer.parseInt(strArrSplit7[1]);
                                                    int i16 = Integer.parseInt(strArrSplit8[0]);
                                                    int i17 = Integer.parseInt(strArrSplit8[1]);
                                                    str4 = (i3 + i14) + str3 + (i5 + i15) + ProcessIdUtil.DEFAULT_PROCESSID + (i4 + i16) + str3 + (i6 + i17);
                                                    GesturePlayFloatView.D(str4);
                                                } catch (Exception e6) {
                                                    Exception e7 = e6;
                                                    str4 = str2;
                                                    com.frame.k0.r(e7);
                                                    com.frame.y0.g(node.getStepAndName() + ".区域扩大(" + strG9 + strW7 + str3 + strG3 + str + "):" + strG2 + "=" + str4 + strW9);
                                                    da.B().E1(strG2, str4);
                                                    a7Var = this;
                                                    runnable2 = runnable;
                                                    a7Var2 = a7Var;
                                                    a7Var2.c.W(runnable2);
                                                    return true;
                                                }
                                                com.frame.y0.g(node.getStepAndName() + ".区域扩大(" + strG9 + strW7 + str3 + strG3 + str + "):" + strG2 + "=" + str4 + strW9);
                                                da.B().E1(strG2, str4);
                                                a7Var = this;
                                                runnable2 = runnable;
                                                a7Var2 = a7Var;
                                                a7Var2.c.W(runnable2);
                                                return true;
                                            }
                                        } catch (Exception e8) {
                                            e = e8;
                                            str3 = ",";
                                            exc = e;
                                            i2 = 0;
                                            i3 = 0;
                                            i4 = 0;
                                            com.frame.y0.j(strG2 + "变量非坐标变量，请检查格式是否是x,y");
                                            com.frame.k0.r(exc);
                                            i5 = i2;
                                            i6 = 0;
                                            String[] strArrSplit72 = strG9.split(str3);
                                            String[] strArrSplit82 = strG3.split(str3);
                                            int i142 = Integer.parseInt(strArrSplit72[0]);
                                            int i152 = Integer.parseInt(strArrSplit72[1]);
                                            int i162 = Integer.parseInt(strArrSplit82[0]);
                                            int i172 = Integer.parseInt(strArrSplit82[1]);
                                            str4 = (i3 + i142) + str3 + (i5 + i152) + ProcessIdUtil.DEFAULT_PROCESSID + (i4 + i162) + str3 + (i6 + i172);
                                            GesturePlayFloatView.D(str4);
                                            com.frame.y0.g(node.getStepAndName() + ".区域扩大(" + strG9 + strW7 + str3 + strG3 + str + "):" + strG2 + "=" + str4 + strW9);
                                            da.B().E1(strG2, str4);
                                            a7Var = this;
                                            runnable2 = runnable;
                                            a7Var2 = a7Var;
                                            a7Var2.c.W(runnable2);
                                            return true;
                                        }
                                        try {
                                            i4 = Integer.parseInt(strArrSplit2[0]);
                                        } catch (Exception e9) {
                                            exc = e9;
                                            i2 = i5;
                                            i4 = 0;
                                            com.frame.y0.j(strG2 + "变量非坐标变量，请检查格式是否是x,y");
                                            com.frame.k0.r(exc);
                                            i5 = i2;
                                            i6 = 0;
                                            String[] strArrSplit722 = strG9.split(str3);
                                            String[] strArrSplit822 = strG3.split(str3);
                                            int i1422 = Integer.parseInt(strArrSplit722[0]);
                                            int i1522 = Integer.parseInt(strArrSplit722[1]);
                                            int i1622 = Integer.parseInt(strArrSplit822[0]);
                                            int i1722 = Integer.parseInt(strArrSplit822[1]);
                                            str4 = (i3 + i1422) + str3 + (i5 + i1522) + ProcessIdUtil.DEFAULT_PROCESSID + (i4 + i1622) + str3 + (i6 + i1722);
                                            GesturePlayFloatView.D(str4);
                                            com.frame.y0.g(node.getStepAndName() + ".区域扩大(" + strG9 + strW7 + str3 + strG3 + str + "):" + strG2 + "=" + str4 + strW9);
                                            da.B().E1(strG2, str4);
                                            a7Var = this;
                                            runnable2 = runnable;
                                            a7Var2 = a7Var;
                                            a7Var2.c.W(runnable2);
                                            return true;
                                        }
                                        try {
                                            i6 = Integer.parseInt(strArrSplit2[1]);
                                        } catch (Exception e10) {
                                            exc = e10;
                                            i2 = i5;
                                            com.frame.y0.j(strG2 + "变量非坐标变量，请检查格式是否是x,y");
                                            com.frame.k0.r(exc);
                                            i5 = i2;
                                            i6 = 0;
                                            String[] strArrSplit7222 = strG9.split(str3);
                                            String[] strArrSplit8222 = strG3.split(str3);
                                            int i14222 = Integer.parseInt(strArrSplit7222[0]);
                                            int i15222 = Integer.parseInt(strArrSplit7222[1]);
                                            int i16222 = Integer.parseInt(strArrSplit8222[0]);
                                            int i17222 = Integer.parseInt(strArrSplit8222[1]);
                                            str4 = (i3 + i14222) + str3 + (i5 + i15222) + ProcessIdUtil.DEFAULT_PROCESSID + (i4 + i16222) + str3 + (i6 + i17222);
                                            GesturePlayFloatView.D(str4);
                                            com.frame.y0.g(node.getStepAndName() + ".区域扩大(" + strG9 + strW7 + str3 + strG3 + str + "):" + strG2 + "=" + str4 + strW9);
                                            da.B().E1(strG2, str4);
                                            a7Var = this;
                                            runnable2 = runnable;
                                            a7Var2 = a7Var;
                                            a7Var2.c.W(runnable2);
                                            return true;
                                        }
                                        String[] strArrSplit72222 = strG9.split(str3);
                                        String[] strArrSplit82222 = strG3.split(str3);
                                        int i142222 = Integer.parseInt(strArrSplit72222[0]);
                                        int i152222 = Integer.parseInt(strArrSplit72222[1]);
                                        int i162222 = Integer.parseInt(strArrSplit82222[0]);
                                        int i172222 = Integer.parseInt(strArrSplit82222[1]);
                                        str4 = (i3 + i142222) + str3 + (i5 + i152222) + ProcessIdUtil.DEFAULT_PROCESSID + (i4 + i162222) + str3 + (i6 + i172222);
                                        GesturePlayFloatView.D(str4);
                                        com.frame.y0.g(node.getStepAndName() + ".区域扩大(" + strG9 + strW7 + str3 + strG3 + str + "):" + strG2 + "=" + str4 + strW9);
                                        da.B().E1(strG2, str4);
                                        a7Var = this;
                                    } catch (Exception e11) {
                                        e = e11;
                                        r3 = this;
                                        com.frame.y0.j(node.getStepAndName() + "：变量操作出错，排查：---></br>" + e.getMessage());
                                        a7Var = r3;
                                        runnable2 = runnable;
                                        a7Var2 = a7Var;
                                        a7Var2.c.W(runnable2);
                                        return true;
                                    }
                                } else {
                                    try {
                                        r3 = node.arg1;
                                    } catch (Exception e12) {
                                        e = e12;
                                        r3 = this;
                                        com.frame.y0.j(node.getStepAndName() + "：变量操作出错，排查：---></br>" + e.getMessage());
                                        a7Var = r3;
                                        runnable2 = runnable;
                                        a7Var2 = a7Var;
                                        a7Var2.c.W(runnable2);
                                        return true;
                                    }
                                    try {
                                        if ("坐标偏移".equals(r3)) {
                                            String str21 = strG6.split("&&~")[0];
                                            String strW10 = W(str21);
                                            String strG11 = da.B().G(str21);
                                            if (strG6.endsWith("&&~")) {
                                                str8 = "";
                                            } else {
                                                String str22 = strG6.split("&&~")[1];
                                                String strW11 = W(str22);
                                                strG3 = da.B().G(str22);
                                                str8 = strW11;
                                            }
                                            String strW12 = W(strH2);
                                            String strG12 = da.B().G(strH2);
                                            try {
                                                strArrSplit3 = strG12.split(",");
                                                i8 = Integer.parseInt(strArrSplit3[0]);
                                            } catch (Exception e13) {
                                                exc2 = e13;
                                                str9 = strG12;
                                                i8 = 0;
                                            }
                                            try {
                                                i9 = Integer.parseInt(strArrSplit3[1]);
                                                str9 = strG12;
                                            } catch (Exception e14) {
                                                exc2 = e14;
                                                str9 = strG12;
                                                try {
                                                    com.frame.y0.j(strG2 + "变量非坐标变量，请检查格式是否是x,y");
                                                    com.frame.k0.r(exc2);
                                                    i9 = 0;
                                                    i11 = Integer.parseInt(strG11);
                                                    i12 = Integer.parseInt(strG3);
                                                    str10 = (i8 + i11) + "," + (i9 + i12);
                                                } catch (Exception e15) {
                                                    com.frame.k0.r(e15);
                                                    str10 = str9;
                                                }
                                                com.frame.y0.g(node.getStepAndName() + ".坐标偏移(" + strG11 + strW10 + "," + strG3 + str8 + "):" + strG2 + "=" + str10 + strW12);
                                                da.B().E1(strG2, str10);
                                                a7Var = this;
                                                runnable2 = runnable;
                                                a7Var2 = a7Var;
                                                a7Var2.c.W(runnable2);
                                                return true;
                                            }
                                            try {
                                                i11 = Integer.parseInt(strG11);
                                            } catch (Exception e16) {
                                                exc3 = e16;
                                                i10 = 0;
                                            }
                                            try {
                                                i12 = Integer.parseInt(strG3);
                                            } catch (Exception e17) {
                                                exc3 = e17;
                                                i10 = i11;
                                                com.frame.y0.j(strG2 + "偏移值非坐标变量，请检查格式是否是x,y");
                                                com.frame.k0.r(exc3);
                                                i11 = i10;
                                                i12 = 0;
                                                str10 = (i8 + i11) + "," + (i9 + i12);
                                                com.frame.y0.g(node.getStepAndName() + ".坐标偏移(" + strG11 + strW10 + "," + strG3 + str8 + "):" + strG2 + "=" + str10 + strW12);
                                                da.B().E1(strG2, str10);
                                                a7Var = this;
                                                runnable2 = runnable;
                                                a7Var2 = a7Var;
                                                a7Var2.c.W(runnable2);
                                                return true;
                                            }
                                            str10 = (i8 + i11) + "," + (i9 + i12);
                                            com.frame.y0.g(node.getStepAndName() + ".坐标偏移(" + strG11 + strW10 + "," + strG3 + str8 + "):" + strG2 + "=" + str10 + strW12);
                                            da.B().E1(strG2, str10);
                                            a7Var = this;
                                        } else if ("文字分割".equals(node.arg1)) {
                                            String str23 = strG6.split("&&~")[0];
                                            r3 = this;
                                            String strW13 = r3.W(str23);
                                            String strG13 = da.B().G(str23);
                                            if (strG6.endsWith("&&~")) {
                                                str7 = "";
                                            } else {
                                                String str24 = strG6.split("&&~")[1];
                                                String strW14 = r3.W(str24);
                                                strG3 = da.B().G(str24);
                                                str7 = strW14;
                                            }
                                            String strW15 = r3.W(strH2);
                                            String strG14 = da.B().G(strH2);
                                            try {
                                                if (!TextUtils.isEmpty(strG13) && !TextUtils.isEmpty(strG3)) {
                                                    int iIndexOf = strG14.indexOf(strG13) + strG13.length();
                                                    strG14 = strG14.substring(iIndexOf, strG14.indexOf(strG3, iIndexOf));
                                                } else if (!TextUtils.isEmpty(strG13)) {
                                                    strG14 = strG14.substring(strG14.indexOf(strG13) + strG13.length());
                                                } else if (!TextUtils.isEmpty(strG3)) {
                                                    strG14 = strG14.substring(0, strG14.indexOf(strG3));
                                                }
                                            } catch (Exception e18) {
                                                com.frame.k0.r(e18);
                                            }
                                            com.frame.y0.g(node.getStepAndName() + ".文字分割(" + strG13 + strW13 + "~" + strG3 + str7 + "):" + strG2 + "=" + strG14 + strW15);
                                            da.B().E1(strG2, strG14);
                                            a7Var = r3;
                                        } else {
                                            a7 a7Var5 = this;
                                            a7Var = a7Var5;
                                            if ("数组分割".equals(node.arg1)) {
                                                String[] strArrSplit9 = strG6.split("&&~");
                                                String str25 = strArrSplit9[0];
                                                if (str25.equals("|")) {
                                                    str25 = "\\|";
                                                }
                                                String str26 = strArrSplit9[1];
                                                String[] strArrSplit10 = da.B().G(strH2).split(str25);
                                                if ("顺序取值".equals(str26)) {
                                                    try {
                                                        HashMap mapA = da.B().A();
                                                        StringBuilder sb2 = new StringBuilder();
                                                        str5 = "textLoop:";
                                                        try {
                                                            sb2.append(str5);
                                                            sb2.append(node.id);
                                                            i7 = Integer.parseInt(mapA.get(sb2.toString()).toString());
                                                        } catch (Exception e19) {
                                                            e = e19;
                                                            com.frame.k0.r(e);
                                                            i7 = 0;
                                                            String str27 = strArrSplit10[i7 % strArrSplit10.length];
                                                            iA = i7 + 1;
                                                            da.B().A().put(str5 + node.id, Integer.valueOf(iA));
                                                            str6 = str27;
                                                            com.frame.y0.g(node.getStepAndName() + ".数组分割(" + str26 + iA + "):" + strG2 + "=" + str6);
                                                            da.B().E1(strG2, str6);
                                                            a7Var = a7Var5;
                                                            runnable2 = runnable;
                                                            a7Var2 = a7Var;
                                                            a7Var2.c.W(runnable2);
                                                            return true;
                                                        }
                                                    } catch (Exception e20) {
                                                        e = e20;
                                                        str5 = "textLoop:";
                                                    }
                                                    String str272 = strArrSplit10[i7 % strArrSplit10.length];
                                                    iA = i7 + 1;
                                                    da.B().A().put(str5 + node.id, Integer.valueOf(iA));
                                                    str6 = str272;
                                                } else if ("随机取值".equals(str26)) {
                                                    iA = o.a.f.a(0, strArrSplit10.length);
                                                    str6 = strArrSplit10[iA % strArrSplit10.length];
                                                } else {
                                                    str6 = null;
                                                    iA = 0;
                                                }
                                                com.frame.y0.g(node.getStepAndName() + ".数组分割(" + str26 + iA + "):" + strG2 + "=" + str6);
                                                da.B().E1(strG2, str6);
                                                a7Var = a7Var5;
                                            }
                                        }
                                    } catch (Exception e21) {
                                        e = e21;
                                        com.frame.y0.j(node.getStepAndName() + "：变量操作出错，排查：---></br>" + e.getMessage());
                                        a7Var = r3;
                                        runnable2 = runnable;
                                        a7Var2 = a7Var;
                                        a7Var2.c.W(runnable2);
                                        return true;
                                    }
                                }
                                runnable2 = runnable;
                                a7Var2 = a7Var;
                                a7Var2.c.W(runnable2);
                                return true;
                            }
                            String strG15 = da.B().G(strH2);
                            String[] strArrSplit11 = strG6.split("&&~");
                            String str28 = strArrSplit11[0];
                            if (strArrSplit11.length == 1) {
                                strSubstring = strG15.substring(Integer.parseInt(str28));
                            } else {
                                strG3 = strArrSplit11[1];
                                strSubstring = TextUtils.isEmpty(strG3) ? strG15.substring(Integer.parseInt(str28)) : TextUtils.isEmpty(str28) ? strG15.substring(0, Integer.parseInt(strG3)) : strG15.substring(Integer.parseInt(str28), Integer.parseInt(strG3));
                            }
                            com.frame.y0.g(node.getStepAndName() + ".长度分割(" + str28 + "~" + strG3 + "):" + strG2 + "=" + strSubstring);
                            da.B().E1(strG2, strSubstring);
                        }
                        runnable2 = runnable;
                        a7Var2 = this;
                        a7Var2.c.W(runnable2);
                        return true;
                    }
                    BigDecimal bigDecimalM07 = m0(strH2);
                    BigDecimal bigDecimalM08 = m0(strG6);
                    String strU4 = U(bigDecimalM07.subtract(bigDecimalM08));
                    com.frame.y0.g(node.getStepAndName() + ".减去(" + U(bigDecimalM07) + strX2 + ProcessIdUtil.DEFAULT_PROCESSID + U(bigDecimalM08) + strW + ")=" + strU4);
                    da.B().E1(strG2, strU4.toString());
                }
                a7Var = this;
                runnable2 = runnable;
                a7Var2 = a7Var;
                a7Var2.c.W(runnable2);
                return true;
            case 6:
                if (n0(node)) {
                    com.frame.y0.i(node.getStepAndName() + ":变量逻辑判断:true");
                    m(node, runnable);
                } else {
                    com.frame.y0.i(node.getStepAndName() + ":变量逻辑判断:false");
                    k(node, runnable);
                }
                return true;
            case 7:
                if (!TextUtils.isEmpty(node.arg4)) {
                    strG2 = node.arg4;
                }
                String strG16 = da.B().G(node.arg3);
                String strU5 = U(i.b.m7.b(strG16));
                com.frame.y0.g(node.getStepAndName() + ".公式计算器(" + strG16 + "):" + strG2 + "=" + strU5);
                da daVarB2 = da.B();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(strU5);
                sb3.append("");
                daVarB2.E1(strG2, sb3.toString());
                runnable2 = runnable;
                a7Var2 = this;
                a7Var2.c.W(runnable2);
                return true;
            case 8:
                da.B().J1();
                FloatToast.g(j.b.d.O, "清理变量值");
                com.frame.y0.g(node.getStepAndName() + ".清理变量值");
                runnable2 = runnable;
                a7Var2 = this;
                a7Var2.c.W(runnable2);
                return true;
            case 9:
                FloatToast.g(j.b.d.O, "重置变量[" + strG2 + "]");
                da.B().E1(strG2, null);
                runnable2 = runnable;
                a7Var2 = this;
                a7Var2.c.W(runnable2);
                return true;
        }
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.c0;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "变量操控";
    }
}
