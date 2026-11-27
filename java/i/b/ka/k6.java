package i.b.ka;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.message.StructuredDataId;
import com.v.ExcelReadDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class k6 extends x5 {
    static String T(String str, int i2, int i3) {
        if (i3 <= i2) {
            return null;
        }
        return "Excel配置不匹配：文件“" + str + "”只有" + i2 + "列，但配置了" + i3 + "个变量名。请删除多余变量名，或在Excel中增加第" + (i2 + 1) + "列；若第一行是列名，请开启“第一行是表头”。";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(lt ltVar, Node node) {
        v8.m().X(node);
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(lt ltVar, Node node) {
        v8.m().X(node);
        Q(ltVar, node);
    }

    private String Z(Context context, Uri uri) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } finally {
                }
            }
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // i.b.ka.x5
    public int B() {
        return 38;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, final lt ltVar) {
        ExcelReadDialogView excelReadDialogView = (ExcelReadDialogView) com.frame.s0.g().B(ExcelReadDialogView.class);
        excelReadDialogView.setTaskNode(v8.m().p(), node);
        excelReadDialogView.u(new lt() { // from class: i.b.ka.l0
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.W(ltVar, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        nodeQ.type = 38;
        nodeQ.errorType = 2;
        nodeQ.whatIndex = Integer.MIN_VALUE;
        nodeQ.arg1 = StructuredDataId.RESERVED;
        nodeQ.arg2 = "1";
        ExcelReadDialogView excelReadDialogView = (ExcelReadDialogView) com.frame.s0.g().B(ExcelReadDialogView.class);
        excelReadDialogView.setTaskNode(v8.m().p(), nodeQ);
        excelReadDialogView.u(new lt() { // from class: i.b.ka.k0
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.Y(ltVar, node);
            }
        });
    }

    public String U(Context context, String str) {
        if (str == null || defpackage.e.a(str)) {
            return "";
        }
        String strTrim = str.trim();
        if (!strTrim.contains("content://")) {
            return new File(strTrim).getName();
        }
        Uri uri = Uri.parse(strTrim);
        if ("file".equals(uri.getScheme())) {
            return new File(uri.getPath()).getName();
        }
        if (!"content".equals(uri.getScheme())) {
            String lastPathSegment = uri.getLastPathSegment();
            return lastPathSegment == null ? "" : lastPathSegment;
        }
        String strZ = Z(context, uri);
        if (strZ != null && !defpackage.e.a(strZ)) {
            return strZ;
        }
        String lastPathSegment2 = uri.getLastPathSegment();
        return lastPathSegment2 == null ? "" : lastPathSegment2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        i.b.ga.b bVarE;
        int iIntValue;
        int i2 = 0;
        AutoCloseable autoCloseable = null;
        try {
            try {
                try {
                    String strU = U(com.frame.v0.g(), node.url);
                    bVarE = i.b.ga.a.e(com.frame.v0.g(), node.url);
                    bVarE.f(0);
                    String strG = da.B().G(node.arg2);
                    int i3 = node.whatIndex;
                    if (i3 == -1) {
                        iIntValue = bVarE.d() - 1;
                    } else if (i3 == 1) {
                        iIntValue = StructuredDataId.RESERVED.equals(node.arg1);
                    } else if (i3 == -2) {
                        iIntValue = Integer.valueOf(da.B().G(node.arg4)).intValue();
                    } else {
                        iIntValue = Integer.valueOf(da.B().I(strU + "读取行数", strG)).intValue();
                    }
                    if (StructuredDataId.RESERVED.equals(node.arg1)) {
                        if (iIntValue >= bVarE.d()) {
                            da.B().E1(strU + "读取行数", Integer.valueOf(strG));
                            k(node, runnable);
                            if (bVarE != null) {
                                try {
                                    bVarE.close();
                                } catch (IOException e) {
                                    com.frame.y0.l(e);
                                }
                            }
                            return false;
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        int iC = bVarE.c();
                        int i4 = 0;
                        while (i4 < iC) {
                            String strA = bVarE.a(i4, i2).a();
                            String strA2 = bVarE.a(i4, iIntValue).a();
                            if (!TextUtils.isEmpty(strA)) {
                                da.B().E1(strA, strA2);
                                stringBuffer.append(strA);
                                stringBuffer.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                                stringBuffer.append(strA2);
                                stringBuffer.append("   ,     ");
                            }
                            i4++;
                            i2 = 0;
                        }
                        da.B().E1(strU + "读取行数", Integer.valueOf(iIntValue + 1));
                        com.frame.y0.g("excel读取->" + ((Object) stringBuffer));
                    } else {
                        if (iIntValue >= bVarE.d()) {
                            da.B().E1(strU + "读取行数", Integer.valueOf(strG));
                            k(node, runnable);
                            if (bVarE == null) {
                                return false;
                            }
                            try {
                                bVarE.close();
                                return false;
                            } catch (IOException e2) {
                                com.frame.y0.l(e2);
                                return false;
                            }
                        }
                        String[] strArrSplit = node.arg1.split(",");
                        StringBuffer stringBuffer2 = new StringBuffer();
                        String strT = T(strU, bVarE.c(), strArrSplit.length);
                        if (strT != null) {
                            da.B().w1(strT);
                            if (bVarE == null) {
                                return false;
                            }
                            try {
                                bVarE.close();
                                return false;
                            } catch (IOException e3) {
                                com.frame.y0.l(e3);
                                return false;
                            }
                        }
                        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
                            String str = strArrSplit[i5];
                            String strA3 = bVarE.a(i5, iIntValue).a();
                            if (!TextUtils.isEmpty(str)) {
                                da.B().E1(str, strA3);
                                stringBuffer2.append(str);
                                stringBuffer2.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                                stringBuffer2.append(strA3);
                                stringBuffer2.append("   ,     ");
                            }
                        }
                        da.B().E1(strU + "读取行数", Integer.valueOf(iIntValue + 1));
                        com.frame.y0.g("excel读取->" + ((Object) stringBuffer2));
                    }
                } catch (IOException e4) {
                    com.frame.y0.l(e4);
                }
            } catch (IOException | RuntimeException | k.a0.a.d e5) {
                com.frame.y0.l(e5);
                if (0 != 0) {
                    autoCloseable.close();
                }
            }
            if (bVarE != null) {
                bVarE.close();
            }
            this.c.W(runnable);
            return false;
        } catch (Throwable th) {
            if (0 == 0) {
                throw th;
            }
            try {
                autoCloseable.close();
                throw th;
            } catch (IOException e6) {
                com.frame.y0.l(e6);
                throw th;
            }
        }
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.M;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "读取Excel数据";
    }
}
