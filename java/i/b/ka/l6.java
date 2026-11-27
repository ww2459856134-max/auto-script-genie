package i.b.ka;

import com.v.ExcelWriteDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.io.IOException;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class l6 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(lt ltVar, Node node) {
        v8.m().X(node);
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(lt ltVar, Node node) {
        v8.m().X(node);
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 39;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, final lt ltVar) {
        ExcelWriteDialogView excelWriteDialogView = (ExcelWriteDialogView) com.frame.s0.g().B(ExcelWriteDialogView.class);
        excelWriteDialogView.setTaskNode(v8.m().p(), node);
        excelWriteDialogView.m(new lt() { // from class: i.b.ka.n0
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.U(ltVar, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        nodeQ.type = 39;
        nodeQ.errorType = 2;
        nodeQ.whatIndex = -1;
        nodeQ.arg1 = "";
        ExcelWriteDialogView excelWriteDialogView = (ExcelWriteDialogView) com.frame.s0.g().B(ExcelWriteDialogView.class);
        excelWriteDialogView.setTaskNode(v8.m().p(), nodeQ);
        excelWriteDialogView.m(new lt() { // from class: i.b.ka.m0
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.W(ltVar, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws NumberFormatException, IOException {
        String strTrim;
        try {
            String[] strArrSplit = node.arg1.split(",");
            String[] strArr = new String[strArrSplit.length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                strArr[i2] = da.B().G(strArrSplit[i2]);
            }
            int i3 = node.whatIndex;
            if (i3 == 1) {
                i.b.ga.a.i(com.frame.v0.g(), node.url, strArr, 1);
            } else if (i3 == -2) {
                String strG = da.B().G(node.arg4);
                if (strG == null) {
                    strTrim = "";
                } else {
                    try {
                        strTrim = strG.trim();
                    } catch (NumberFormatException e) {
                        throw new IOException("Excel行号必须是大于0的整数：" + strG, e);
                    }
                }
                i.b.ga.a.i(com.frame.v0.g(), node.url, strArr, Integer.parseInt(strTrim));
            } else {
                i.b.ga.a.a(com.frame.v0.g(), node.url, strArr);
            }
            com.frame.y0.n("数据插入成功！");
        } catch (IOException | RuntimeException | k.a0.a.d | k.b0.u e2) {
            com.frame.y0.l(e2);
        }
        this.c.W(runnable);
        return false;
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
        return "写入Excel数据";
    }
}
