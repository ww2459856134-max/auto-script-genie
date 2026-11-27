package i.b.ka;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.google.gson.Gson;
import com.s.BoxService;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.FlowView;
import com.v.GesturePlayFloatView;
import com.v.MultiLogicDialogView;
import com.v.NodeListDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.i9;
import i.b.t9;
import i.b.x7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.json.JSONException;
import org.opencv.core.Mat;

/* loaded from: classes.dex */
public abstract class x5 {
    public static int d = 5;
    protected long a;
    private int b;
    protected t9 c;

    private Bitmap[] A(IdentityHashMap<Node, Bitmap[]> identityHashMap, e7 e7Var, Node node) {
        Bitmap[] bitmapArr = identityHashMap.get(node);
        if (bitmapArr != null || identityHashMap.containsKey(node)) {
            return bitmapArr;
        }
        Bitmap[] bitmapArrX = e7Var.X(node.url, e7Var.d0(node), node.argInt1);
        identityHashMap.put(node, bitmapArrX);
        return bitmapArrX;
    }

    private AccessibilityNodeInfo C(int i2, Node node, List<AccessibilityNodeInfo> list, Runnable runnable) throws JSONException {
        String str = "mapLoop:" + node.id;
        String str2 = "textLoop:" + node.id;
        HashMap map = (HashMap) da.B().F(str);
        if (map == null) {
            map = new HashMap();
            da.B().E1(str, map);
        }
        if (i2 < list.size()) {
            com.frame.y0.o(node.getName() + "：每次识别递进：第" + i2);
            AccessibilityNodeInfo accessibilityNodeInfo = list.get(i2);
            CharSequence charSequenceV = v(accessibilityNodeInfo);
            if (charSequenceV == null || !map.containsKey(charSequenceV)) {
                if (charSequenceV != null) {
                    da.B().E1(str2, Integer.valueOf(i2 + 1));
                    map.put(charSequenceV, 1);
                }
                return accessibilityNodeInfo;
            }
            com.frame.y0.j("执行过了：" + ((Object) charSequenceV) + ParameterizedMessage.ERROR_MSG_SEPARATOR + i2);
            return C(i2 + 1, node, list, runnable);
        }
        com.frame.y0.o(node.getName() + "：每次识别递进：第" + i2 + "   超出页面，滚动下一页");
        s7 s7Var = (s7) z(19);
        if (!"1".equals(node.arg2)) {
            s7Var.k(node, runnable);
            return null;
        }
        if (list.isEmpty()) {
            SystemClock.sleep(600L);
        }
        if (!com.frame.g0.v().N(list.get(list.size() / 2), XMLEvent.CHANGE_PREFIX_MAPPING)) {
            if (System.currentTimeMillis() - this.a <= node.timeOut) {
                SystemClock.sleep(500L);
                return C(i2, node, list, runnable);
            }
            com.frame.y0.j("不能滑动,可能滑到最后了");
            s7Var.k(node, runnable);
            return null;
        }
        SystemClock.sleep(600L);
        s7Var.e0(System.currentTimeMillis());
        List<AccessibilityNodeInfo> listD0 = s7Var.d0(node, node.url);
        if (listD0 != null) {
            da.B().E1(str2, 0);
            return u(node, listD0, runnable);
        }
        com.frame.y0.j("递进未找到控件");
        s7Var.k(node, runnable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(Node node, Runnable runnable) {
        if (this.c.q()) {
            this.c.U(node.getJumpNodeId(), runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(Node node, Runnable runnable, int i2) throws JSONException {
        if (this.c.q()) {
            t9 t9Var = this.c;
            if (t9Var != null && t9Var.l() != null && node.nextTaskId == this.c.l().getId()) {
                this.c.X(runnable);
            } else if (runnable != null) {
                E(node, Long.valueOf(node.nextTaskId), i2 == 1 ? node.successJumpBack : node.jumpBack);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L() throws JSONException {
        da.B().x1(this.c);
    }

    static /* synthetic */ int b(x5 x5Var) {
        int i2 = x5Var.b;
        x5Var.b = i2 - 1;
        return i2;
    }

    private void j(final Node node, Rect rect, List<AccessibilityNodeInfo> list, final int i2, final Runnable runnable) throws JSONException {
        t9 t9Var = this.c;
        if (t9Var == null || !t9Var.q()) {
            com.frame.y0.j("单线程任务已停止");
            return;
        }
        switch (i2 == 1 ? node.nextType : node.errorType) {
            case -4:
                da.B().u(this.c);
                break;
            case -3:
                com.frame.y0.j("跳转终止脚本");
                da.B().h2();
                break;
            case -2:
                com.frame.y0.j(" 超时，弹窗报错：" + node.getName());
                da.B().B1("ding.mp3");
                da.B().w1("超时：" + node.getName());
                break;
            case 0:
                if (rect != null) {
                    f(rect, da.B().M().getClickDuration(), node.getPoint(), runnable);
                    break;
                } else if (list != null && !list.isEmpty()) {
                    AccessibilityNodeInfo accessibilityNodeInfoU = u(node, list, runnable);
                    if (accessibilityNodeInfoU != null) {
                        Rect rect2 = new Rect();
                        accessibilityNodeInfoU.getBoundsInScreen(rect2);
                        f(rect2, da.B().M().getClickDuration(), node.getPoint(), runnable);
                        break;
                    }
                } else {
                    com.frame.y0.g("模拟点击出现bug，请联系技术小哥");
                    break;
                }
                break;
            case 1:
                FloatToast.i("请联系开发者...");
                break;
            case 2:
                if (da.B().M().isShowGesturePath && rect != null) {
                    GesturePlayFloatView.B(rect);
                }
                if (node.isJumOtherType()) {
                    try {
                        Node nextNodeAtIndex = node.getNextNodeAtIndex(this.c.l());
                        if (nextNodeAtIndex != null) {
                            this.c.V(nextNodeAtIndex, runnable);
                        } else {
                            com.frame.l1.e(new Runnable() { // from class: i.b.ka.e
                                @Override // java.lang.Runnable
                                public final void run() throws JSONException {
                                    this.c.L();
                                }
                            });
                        }
                        break;
                    } catch (Exception e) {
                        com.frame.y0.j("跳转下一个节点失败2");
                        com.frame.y0.l(e);
                        break;
                    }
                } else {
                    this.c.W(runnable);
                    break;
                }
            case 3:
                if (da.B().M().isShowGesturePath && rect != null) {
                    GesturePlayFloatView.B(rect);
                }
                this.c.U(i2 == 1 ? node.getJumpNodeId() : node.errorId, runnable);
                break;
            case 4:
                if (da.B().M().isShowGesturePath && rect != null) {
                    GesturePlayFloatView.B(rect);
                }
                long jumpNodeId = i2 == 1 ? node.getJumpNodeId() : node.errorId;
                t9 t9Var2 = this.c;
                if (t9Var2 != null && t9Var2.l() != null && jumpNodeId == this.c.l().getId()) {
                    this.c.X(runnable);
                    break;
                } else if (runnable != null) {
                    E(node, Long.valueOf(jumpNodeId), i2 == 1 ? node.successJumpBack : node.jumpBack);
                    break;
                }
                break;
            case 5:
                com.frame.y0.g(" 触发长按点击");
                if (rect != null) {
                    f(rect, da.B().M().longClickDuration, node.getPoint(), runnable);
                    break;
                } else if (list != null && !list.isEmpty()) {
                    AccessibilityNodeInfo accessibilityNodeInfoU2 = u(node, list, runnable);
                    if (accessibilityNodeInfoU2 != null) {
                        Rect rect3 = new Rect();
                        accessibilityNodeInfoU2.getBoundsInScreen(rect3);
                        f(rect3, da.B().M().longClickDuration, node.getPoint(), runnable);
                        break;
                    } else {
                        ((s7) z(19)).k(node, runnable);
                        break;
                    }
                } else {
                    com.frame.y0.g("出现bug，请联系技术小哥");
                    break;
                }
                break;
            case 6:
                if (da.B().M().isShowGesturePath && rect != null) {
                    GesturePlayFloatView.B(rect);
                }
                this.c.U(i2 == 1 ? node.nextId : node.errorId, runnable);
                break;
            case 7:
                AccessibilityNodeInfo accessibilityNodeInfoU3 = u(node, list, runnable);
                if (accessibilityNodeInfoU3 == null) {
                    ((s7) z(19)).k(node, runnable);
                    break;
                } else {
                    AccessibilityNodeInfo accessibilityNodeInfoF = com.frame.g0.v().f(accessibilityNodeInfoU3, 4);
                    boolean zPerformAction = accessibilityNodeInfoF.performAction(16);
                    com.frame.y0.g("触发点击附近可点击控件");
                    if (zPerformAction) {
                        GesturePlayFloatView.C(accessibilityNodeInfoF);
                        this.c.W(runnable);
                        return;
                    }
                    com.frame.y0.j("触发点击失败，自动尝试模拟点击，你可以修改节点为模拟点击");
                    if (list != null && !list.isEmpty()) {
                        Rect rect4 = new Rect();
                        list.get(0).getBoundsInScreen(rect4);
                        f(rect4, da.B().M().getClickDuration(), node.getPoint(), runnable);
                        break;
                    } else {
                        com.frame.y0.g("出现bug，请联系技术小哥");
                        break;
                    }
                }
                break;
            case 8:
                if (list != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (AccessibilityNodeInfo accessibilityNodeInfo : list) {
                        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null) {
                            if (!TextUtils.isEmpty(stringBuffer)) {
                                stringBuffer.append("\n");
                            }
                            stringBuffer.append(accessibilityNodeInfo.getText());
                        }
                    }
                    com.frame.m0.a(stringBuffer.toString());
                    com.frame.y0.g("控件内容拷贝至剪切板");
                    this.c.W(runnable);
                    break;
                } else {
                    com.frame.y0.g("触发bug，请联系技术小哥：TYPE_SUB_COPY_TEXT");
                    break;
                }
                break;
            case 9:
                if (list != null) {
                    if (node.whatIndex == Integer.MAX_VALUE) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        for (AccessibilityNodeInfo accessibilityNodeInfo2 : list) {
                            if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.getText() != null) {
                                if (!TextUtils.isEmpty(stringBuffer2)) {
                                    stringBuffer2.append("\n");
                                }
                                stringBuffer2.append(accessibilityNodeInfo2.getText());
                            }
                        }
                        com.frame.y0.g("控件内容写入变量：" + node.arg3);
                        da.B().E1(da.B().G(node.arg3), stringBuffer2.toString());
                    } else {
                        AccessibilityNodeInfo accessibilityNodeInfoU4 = u(node, list, runnable);
                        if (accessibilityNodeInfoU4 == null) {
                            ((s7) z(19)).k(node, runnable);
                            return;
                        }
                        GesturePlayFloatView.C(accessibilityNodeInfoU4);
                        com.frame.y0.g("控件内容写入变量：" + node.arg3);
                        da.B().E1(da.B().G(node.arg3), accessibilityNodeInfoU4.getText());
                    }
                    this.c.W(runnable);
                    break;
                } else {
                    com.frame.y0.g("触发bug，请联系技术小哥：TYPE_SUB_PUT_PARAM");
                    break;
                }
                break;
            case 10:
                com.frame.y0.g(" 元素内随机坐标点击");
                if (rect != null) {
                    h(rect, da.B().M().getClickDuration(), node.getPoint(), runnable);
                    break;
                } else if (list != null && !list.isEmpty()) {
                    Rect rect5 = new Rect();
                    list.get(0).getBoundsInScreen(rect5);
                    h(rect5, da.B().M().getClickDuration(), node.getPoint(), runnable);
                    break;
                } else {
                    com.frame.y0.g("元素内随机坐标点击，出现bug，请联系技术小哥");
                    break;
                }
                break;
            case 11:
                if (list != null) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    Rect rect6 = new Rect();
                    if (node.whatIndex == Integer.MAX_VALUE) {
                        for (AccessibilityNodeInfo accessibilityNodeInfo3 : list) {
                            if (accessibilityNodeInfo3 != null) {
                                accessibilityNodeInfo3.getBoundsInScreen(rect6);
                                stringBuffer3.append("|");
                                stringBuffer3.append(rect6.centerX() + "," + rect6.centerY());
                            }
                        }
                        if (stringBuffer3.length() != 0) {
                            String strSubstring = stringBuffer3.toString().substring(1);
                            com.frame.y0.g("识别成功重新点坐标写入变量（" + node.arg3 + "）：" + strSubstring);
                            da.B().E1(da.B().G(node.arg3), strSubstring);
                        } else {
                            com.frame.y0.g("未找到坐标");
                        }
                    } else {
                        AccessibilityNodeInfo accessibilityNodeInfoU5 = u(node, list, runnable);
                        if (accessibilityNodeInfoU5 != null) {
                            accessibilityNodeInfoU5.getBoundsInScreen(rect6);
                            stringBuffer3.append(rect6.centerX() + "," + rect6.centerY());
                            GesturePlayFloatView.v(rect6.centerX(), rect6.centerY());
                            com.frame.y0.g("识别成功重新点坐标写入变量（" + node.arg3 + "）：" + ((Object) stringBuffer3));
                            da.B().E1(da.B().G(node.arg3), stringBuffer3);
                        } else {
                            com.frame.y0.g("未找到坐标");
                        }
                    }
                    this.c.W(runnable);
                    break;
                } else if (rect != null) {
                    String str = rect.centerX() + "," + rect.centerY();
                    da.B().E1(da.B().G(node.arg3), str);
                    com.frame.y0.g("识别成功重新点坐标写入变量（" + node.arg3 + "）：" + str);
                    this.c.W(runnable);
                    break;
                }
                break;
            case 12:
                com.frame.y0.g(" 点击后跳转任务");
                Runnable runnable2 = new Runnable() { // from class: i.b.ka.a
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        this.c.J(node, runnable, i2);
                    }
                };
                if (rect != null) {
                    f(rect, da.B().M().getClickDuration(), node.getPoint(), runnable2);
                    break;
                } else if (list != null && !list.isEmpty()) {
                    Rect rect7 = new Rect();
                    list.get(0).getBoundsInScreen(rect7);
                    f(rect7, da.B().M().getClickDuration(), node.getPoint(), runnable2);
                    break;
                } else {
                    com.frame.y0.g("出现bug，请联系技术小哥");
                    break;
                }
                break;
            case 13:
                com.frame.y0.g(" 点击后跳转节点");
                Runnable runnable3 = new Runnable() { // from class: i.b.ka.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.H(node, runnable);
                    }
                };
                if (rect != null) {
                    f(rect, da.B().M().getClickDuration(), node.getPoint(), runnable3);
                    break;
                } else if (list != null && !list.isEmpty()) {
                    Rect rect8 = new Rect();
                    list.get(0).getBoundsInScreen(rect8);
                    f(rect8, da.B().M().getClickDuration(), node.getPoint(), runnable3);
                    break;
                } else {
                    com.frame.y0.g("出现bug，请联系技术小哥");
                    break;
                }
            case 16:
                if (rect != null) {
                    new w5(this, new AtomicReference(0), Integer.parseInt(node.arg3), runnable, rect, da.B().M().getClickDuration(), node).run();
                    break;
                } else if (list == null || list.isEmpty()) {
                    com.frame.y0.g("模拟点击出现bug，请联系技术小哥");
                    break;
                }
                break;
            case 17:
                if (list != null) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    Rect rect9 = new Rect();
                    if (node.whatIndex == Integer.MAX_VALUE) {
                        for (AccessibilityNodeInfo accessibilityNodeInfo4 : list) {
                            if (accessibilityNodeInfo4 != null) {
                                accessibilityNodeInfo4.getBoundsInScreen(rect9);
                                stringBuffer4.append("|");
                                stringBuffer4.append(Node.getStringByRect(rect9));
                            }
                        }
                        if (stringBuffer4.length() != 0) {
                            String strSubstring2 = stringBuffer4.toString().substring(1);
                            com.frame.y0.g("识别成功区域写入变量（" + node.arg3 + "）：" + strSubstring2);
                            da.B().E1(da.B().G(node.arg3), strSubstring2);
                        } else {
                            com.frame.y0.g("未找到坐标");
                        }
                    } else {
                        AccessibilityNodeInfo accessibilityNodeInfoU6 = u(node, list, runnable);
                        if (accessibilityNodeInfoU6 != null) {
                            accessibilityNodeInfoU6.getBoundsInScreen(rect9);
                            stringBuffer4.append(Node.getStringByRect(rect9));
                            GesturePlayFloatView.B(rect9);
                            com.frame.y0.g("识别成功区域写入变量（" + node.arg3 + "）：" + stringBuffer4.toString());
                            da.B().E1(da.B().G(node.arg3), stringBuffer4.toString());
                        } else {
                            com.frame.y0.g("未找到坐标");
                        }
                    }
                    this.c.W(runnable);
                    break;
                } else if (rect != null) {
                    String stringByRect = Node.getStringByRect(rect);
                    da.B().E1(da.B().G(node.arg3), stringByRect);
                    com.frame.y0.g("识别成功区域写入变量（" + node.arg3 + "）：" + stringByRect);
                    this.c.W(runnable);
                    break;
                }
                break;
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<AccessibilityNodeInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
    }

    private AccessibilityNodeInfo u(Node node, List<AccessibilityNodeInfo> list, Runnable runnable) {
        String str = "0";
        try {
            int i2 = node.whatIndex;
            if (i2 != 0 && i2 != 1) {
                if (i2 == -1) {
                    return list.get(list.size() - 1);
                }
                if (i2 == Integer.MIN_VALUE) {
                    String strI = da.B().I("textLoop:" + node.id, "0");
                    if (!"null".equals(strI) && !TextUtils.isEmpty(strI)) {
                        str = strI;
                    }
                    return C(Integer.parseInt(str), node, list, runnable);
                }
                if (i2 != -2) {
                    if (i2 == Integer.MAX_VALUE) {
                        return list.get(0);
                    }
                    return null;
                }
                String strG = da.B().G(node.arg4);
                if (Integer.valueOf(strG).intValue() < list.size()) {
                    com.frame.y0.n("选择第" + strG + "个元素操作");
                    return list.get(Integer.valueOf(strG).intValue());
                }
                com.frame.y0.j("找到" + list.size() + "个节点,你选择的是第" + Integer.valueOf(strG) + "个节点，已超出。（可以检查一下控件的特征局限了控件识别的范围）");
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            com.frame.y0.l(e);
            return null;
        }
    }

    public abstract int B();

    protected boolean D(Node node, List<Node> list) {
        if (list == null) {
            return false;
        }
        Iterator<Node> it = list.iterator();
        while (it.hasNext()) {
            int i2 = it.next().type;
            if (3 == i2 || 22 == i2 || 13 == i2 || 37 == i2 || 40 == i2 || 38 == i2) {
                return true;
            }
        }
        return false;
    }

    public void E(Node node, Long l2, boolean z) throws JSONException {
        F(node, l2, true, z);
    }

    public void F(Node node, Long l2, boolean z, boolean z2) throws JSONException {
        if (this.c.q()) {
            Task taskL = da.B().L(l2.longValue());
            if (taskL == null) {
                com.frame.y0.j("跳转任务失败，未找到任务id：" + l2);
                if (z) {
                    da.B().w1("跳转任务失败，未找到任务指定脚本，可能是脚本已被删除或还未导入子脚本。");
                    return;
                }
                return;
            }
            Node node2 = node.nextTaskNodeId != 0 ? taskL.getNodeMap().get(Long.valueOf(node.nextTaskNodeId)) : null;
            com.frame.y0.g(" 跳转任务：" + taskL.getName());
            t9 t9Var = this.c;
            if (t9Var == null || t9Var.l() == null) {
                da.B().b2(taskL, node2, i.b.j7.a().f(), null, false);
            } else if (z2) {
                da.B().b2(taskL, node2, this.c.p(), e(this.c), false);
            } else {
                da.B().b2(taskL, node2, this.c.p(), null, false);
            }
        }
    }

    public String N(Node node, long j2) {
        String str = t() + "「" + node.getStepAndName() + "」成功耗时:" + (System.currentTimeMillis() - j2) + "毫秒，执行操作：" + w(node.nextType);
        com.frame.y0.n(str);
        return str;
    }

    public String O(Node node, long j2) {
        String str = t() + "「" + node.getStepAndName() + "」超时:" + (System.currentTimeMillis() - j2) + "毫秒，执行操作：" + w(node.errorType);
        com.frame.y0.j(str);
        return str;
    }

    public abstract void P(int i2, Task task, Node node, lt ltVar);

    public void Q(final lt ltVar, final Node node) {
        if (ltVar != null) {
            com.frame.l1.e(new Runnable() { // from class: i.b.ka.d
                @Override // java.lang.Runnable
                public final void run() {
                    ltVar.a(node);
                }
            });
        }
    }

    public abstract void R(int i2, lt ltVar);

    public x5 S(t9 t9Var) {
        this.c = t9Var;
        return this;
    }

    protected void c(lt ltVar) {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(FloatHandlerRecord.class);
        com.frame.s0.g().u(MultiLogicDialogView.class);
        if (ltVar != null) {
            ltVar.a(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0359, code lost:
    
        com.frame.l0.c(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x04e6, code lost:
    
        com.frame.y0.j("前置条件：‘否’");
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x04eb, code lost:
    
        com.frame.l0.c(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x04ef, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04c4 A[Catch: all -> 0x04e0, TRY_LEAVE, TryCatch #0 {all -> 0x04e0, blocks: (B:27:0x00d5, B:28:0x00de, B:32:0x00f3, B:31:0x00f0, B:35:0x00fc, B:39:0x010a, B:41:0x010f, B:42:0x0113, B:44:0x0119, B:47:0x012a, B:49:0x0135, B:55:0x0179, B:63:0x0190, B:75:0x01b6, B:77:0x01bc, B:78:0x01c5, B:83:0x01d8, B:85:0x01e3, B:95:0x0229, B:97:0x022f, B:102:0x028a, B:107:0x029d, B:111:0x02b0, B:117:0x02fa, B:120:0x0302, B:144:0x0359, B:235:0x04b4, B:237:0x04c4, B:122:0x0307, B:123:0x030a, B:124:0x030b, B:128:0x031e, B:134:0x0332, B:137:0x0346, B:141:0x034f, B:142:0x0352, B:147:0x0367, B:148:0x036c, B:150:0x0372, B:152:0x037e, B:229:0x04a7, B:159:0x0396, B:169:0x03b0, B:174:0x03ba, B:177:0x03c6, B:180:0x03e1, B:183:0x03ed, B:191:0x0410, B:194:0x0418, B:197:0x042e, B:200:0x043e, B:203:0x0450, B:208:0x045f, B:211:0x046b, B:213:0x0470, B:214:0x0473, B:215:0x0474, B:218:0x0486, B:222:0x0492, B:223:0x0497, B:225:0x049c, B:226:0x04a0, B:114:0x02b8, B:116:0x02be, B:220:0x048c, B:131:0x0325, B:133:0x032b, B:136:0x033f, B:206:0x0459, B:210:0x0464), top: B:250:0x00d5, inners: #2, #4, #5, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(Node node) throws Throwable {
        boolean z;
        Bitmap bitmapX;
        int i2;
        long j2;
        s7 s7Var;
        List<Node> list;
        Mat matE0;
        int i3 = 0;
        List<Node> list2 = (List) new Gson().k(node.arg1, com.google.gson.k0.a.c(List.class, Node.class).e());
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zD = D(node, list2);
        if (zD) {
            i9.v().n();
            for (int i4 = 0; i4 < 10 && !i9.v().B(); i4++) {
                SystemClock.sleep(200L);
            }
        }
        e7 e7Var = (e7) z(3);
        e7Var.X0(jCurrentTimeMillis);
        s7 s7Var2 = (s7) z(19);
        i6 i6Var = (i6) z(13);
        g7 g7Var = (g7) z(4);
        s7Var2.S(this.c);
        g7Var.S(this.c);
        i6Var.S(this.c);
        e7Var.S(this.c);
        Bitmap bitmap = null;
        try {
            IdentityHashMap<Node, Bitmap[]> identityHashMap = new IdentityHashMap<>();
            int i5 = 0;
            s7 s7Var3 = s7Var2;
            Bitmap bitmap2 = null;
            while (true) {
                long j3 = i5;
                try {
                    if (j3 >= node.getCheckCount().longValue()) {
                        bitmap = bitmap2;
                        break;
                    }
                    if (!this.c.q()) {
                        break;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("条件检查第<big><strong>");
                    int i6 = i5 + 1;
                    sb.append(i6);
                    sb.append("</big></strong>次");
                    com.frame.y0.m(sb.toString());
                    if (zD) {
                        bitmapX = i9.v().x();
                        while (i3 < 30 && bitmapX == null) {
                            try {
                                boolean z2 = zD;
                                Log.e("", "bitmap == null");
                                try {
                                    Thread.sleep(s());
                                    bitmapX = i9.v().x();
                                } catch (Exception e) {
                                    com.frame.k0.r(e);
                                }
                                i3++;
                                zD = z2;
                            } catch (Throwable th) {
                                th = th;
                                bitmap = bitmapX;
                                com.frame.l0.c(bitmap);
                                throw th;
                            }
                        }
                        z = zD;
                        if (bitmapX == null) {
                            com.frame.y0.j("前置条件：‘获取不到屏幕截图’");
                            com.frame.l0.c(bitmapX);
                            return false;
                        }
                    } else {
                        z = zD;
                        bitmapX = null;
                    }
                    int i7 = node.what;
                    if (i7 == 1) {
                        Iterator<Node> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = i6;
                                j2 = j3;
                                s7Var = s7Var3;
                                break;
                            }
                            Node next = it.next();
                            int i8 = next.type;
                            Iterator<Node> it2 = it;
                            i2 = i6;
                            if (4 == i8) {
                                g7Var.W(next);
                                if (g7Var.d0(next, next.url) != null) {
                                    com.frame.y0.n("「" + next.getName() + "」找到文字元素，耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis));
                                    x7.d().b(node.getNextDelay());
                                    node.setPointNew(next.getPoint());
                                    com.frame.l0.c(bitmapX);
                                    return true;
                                }
                            } else if (36 == i8) {
                                g7Var.W(next);
                                if (g7Var.d0(next, next.url) == null) {
                                    com.frame.l0.c(bitmapX);
                                    return true;
                                }
                            } else {
                                if (39 == i8) {
                                    s7Var = s7Var3;
                                    s7Var.W(next);
                                    if (s7Var.d0(next, next.url) == null) {
                                        com.frame.l0.c(bitmapX);
                                        return true;
                                    }
                                    j2 = j3;
                                } else {
                                    s7Var = s7Var3;
                                    j2 = j3;
                                    if (37 == i8 || 40 == i8) {
                                        Bitmap[] bitmapArrA = A(identityHashMap, e7Var, next);
                                        Rect areaOrParam = next.getAreaOrParam();
                                        if (next.hasAreaResolveError()) {
                                            com.frame.l0.c(bitmapX);
                                            return false;
                                        }
                                        matE0 = e7Var.e0(bitmapX, next, areaOrParam);
                                        if (matE0 == null) {
                                            break;
                                        }
                                        try {
                                            if (e7Var.V0(next, matE0, areaOrParam, bitmapArrA) == null) {
                                                i9.v().h0();
                                                com.frame.l0.c(bitmapX);
                                                return true;
                                            }
                                            i9.v().h0();
                                        } finally {
                                        }
                                    } else if (38 == i8) {
                                        if (i6Var.V(bitmapX, next) == null) {
                                            i9.v().h0();
                                            com.frame.l0.c(bitmapX);
                                            com.frame.l0.c(bitmapX);
                                            return true;
                                        }
                                        i9.v().h0();
                                    } else if (19 == i8) {
                                        s7Var.W(next);
                                        if (s7Var.d0(next, next.url) != null) {
                                            com.frame.y0.n("「" + next.getName() + "」找到控件，耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis));
                                            x7.d().b(node.getNextDelay());
                                            node.setPointNew(next.getPoint());
                                            com.frame.l0.c(bitmapX);
                                            return true;
                                        }
                                    } else if (3 == i8 || 22 == i8) {
                                        Bitmap[] bitmapArrA2 = A(identityHashMap, e7Var, next);
                                        Rect areaOrParam2 = next.getAreaOrParam();
                                        if (next.hasAreaResolveError()) {
                                            com.frame.l0.c(bitmapX);
                                            return false;
                                        }
                                        matE0 = e7Var.e0(bitmapX, next, areaOrParam2);
                                        if (matE0 == null) {
                                            break;
                                        }
                                        try {
                                            if (e7Var.V0(next, matE0, areaOrParam2, bitmapArrA2) != null) {
                                                com.frame.y0.n("「" + next.getName() + "」找到图片，耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis));
                                                x7.d().b(node.getNextDelay());
                                                node.setPointNew(next.getPoint());
                                                i9.v().h0();
                                                com.frame.l0.c(bitmapX);
                                                return true;
                                            }
                                            matE0.h();
                                        } finally {
                                        }
                                    } else if (13 == i8) {
                                        Point pointV = i6Var.V(bitmapX, next);
                                        if (pointV != null) {
                                            com.frame.y0.n("「" + next.getName() + "」找到颜色，耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis));
                                            x7.d().b(node.getNextDelay());
                                            i9.v().h0();
                                            com.frame.l0.c(bitmapX);
                                            int i9 = pointV.x;
                                            int i10 = pointV.y;
                                            new Rect(i9 - 10, i10 - 10, i9 + 10, i10 + 10);
                                            node.setPointNew(next.getPoint());
                                            com.frame.l0.c(bitmapX);
                                            return true;
                                        }
                                    } else if (24 == i8 && ((a7) z(24)).n0(next)) {
                                        com.frame.l0.c(bitmapX);
                                        return true;
                                    }
                                }
                                s7Var3 = s7Var;
                                it = it2;
                                i6 = i2;
                                j3 = j2;
                            }
                            j2 = j3;
                            s7Var = s7Var3;
                            s7Var3 = s7Var;
                            it = it2;
                            i6 = i2;
                            j3 = j2;
                        }
                    } else {
                        i2 = i6;
                        j2 = j3;
                        s7Var = s7Var3;
                        if (i7 == 2) {
                            boolean z3 = true;
                            for (Node node2 : list2) {
                                int i11 = node2.type;
                                if (36 == i11) {
                                    g7Var.W(node2);
                                    if (g7Var.d0(node2, node2.url) != null) {
                                        list = list2;
                                        z3 = false;
                                        break;
                                    }
                                    list = list2;
                                    list2 = list;
                                } else if (39 == i11) {
                                    s7Var.W(node2);
                                    if (s7Var.d0(node2, node2.url) != null) {
                                        list = list2;
                                        z3 = false;
                                        break;
                                    }
                                    list = list2;
                                    list2 = list;
                                } else if (37 == i11 || 40 == i11) {
                                    list = list2;
                                    Bitmap[] bitmapArrA3 = A(identityHashMap, e7Var, node2);
                                    Rect areaOrParam3 = node2.getAreaOrParam();
                                    if (node2.hasAreaResolveError()) {
                                        z3 = false;
                                        break;
                                    }
                                    matE0 = e7Var.e0(bitmapX, node2, areaOrParam3);
                                    if (matE0 != null) {
                                        try {
                                            if (e7Var.V0(node2, matE0, areaOrParam3, bitmapArrA3) != null) {
                                                matE0.h();
                                                z3 = false;
                                                break;
                                            }
                                            matE0.h();
                                        } finally {
                                        }
                                    } else {
                                        continue;
                                    }
                                    list2 = list;
                                } else if (38 == i11) {
                                    if (i6Var.V(bitmapX, node2) != null) {
                                        list = list2;
                                        z3 = false;
                                        break;
                                    }
                                    list = list2;
                                    list2 = list;
                                } else if (4 != i11) {
                                    if (19 != i11) {
                                        if (3 == i11 || 22 == i11) {
                                            Bitmap[] bitmapArrA4 = A(identityHashMap, e7Var, node2);
                                            Rect areaOrParam4 = node2.getAreaOrParam();
                                            if (node2.hasAreaResolveError()) {
                                                list = list2;
                                            } else {
                                                list = list2;
                                                matE0 = e7Var.e0(bitmapX, node2, areaOrParam4);
                                                if (matE0 != null) {
                                                    try {
                                                        if (e7Var.V0(node2, matE0, areaOrParam4, bitmapArrA4) != null) {
                                                            node.setPointNew(node2.getPoint());
                                                            matE0.h();
                                                            list2 = list;
                                                        }
                                                    } finally {
                                                    }
                                                }
                                            }
                                        } else {
                                            if (13 == i11) {
                                                Point pointV2 = i6Var.V(bitmapX, node2);
                                                if (pointV2 == null) {
                                                    list = list2;
                                                } else {
                                                    node.setPointNew(node2.getPoint());
                                                    int i12 = pointV2.x;
                                                    int i13 = pointV2.y;
                                                    new Rect(i12, i13, i12, i13);
                                                }
                                            } else {
                                                if (24 == i11 && !((a7) z(24)).n0(node2)) {
                                                    list = list2;
                                                    z3 = false;
                                                }
                                                list2 = list;
                                            }
                                            list = list2;
                                            list2 = list;
                                        }
                                        z3 = false;
                                        break;
                                    }
                                    s7Var.W(node2);
                                    List<AccessibilityNodeInfo> listD0 = s7Var.d0(node2, node2.url);
                                    if (listD0 == null) {
                                        list = list2;
                                        z3 = false;
                                        break;
                                    }
                                    node.setPointNew(node2.getPoint());
                                    listD0.get(0).getBoundsInScreen(new Rect());
                                    list = list2;
                                    list2 = list;
                                } else {
                                    g7Var.W(node2);
                                    List<AccessibilityNodeInfo> listD02 = g7Var.d0(node2, node2.url);
                                    if (listD02 == null) {
                                        list = list2;
                                        z3 = false;
                                        break;
                                    }
                                    node.setPointNew(node2.getPoint());
                                    listD02.get(0).getBoundsInScreen(new Rect());
                                    list = list2;
                                    list2 = list;
                                }
                            }
                            list = list2;
                            com.frame.l0.c(bitmapX);
                            if (z3) {
                                com.frame.l0.c(bitmapX);
                                return true;
                            }
                        }
                        if (j2 >= node.getCheckCount().longValue() - 1) {
                            SystemClock.sleep(node.getCheckDelay().longValue());
                        }
                        bitmap2 = bitmapX;
                        zD = z;
                        i5 = i2;
                        i3 = 0;
                        list2 = list;
                        s7Var3 = s7Var;
                    }
                    list = list2;
                    if (j2 >= node.getCheckCount().longValue() - 1) {
                    }
                    bitmap2 = bitmapX;
                    zD = z;
                    i5 = i2;
                    i3 = 0;
                    list2 = list;
                    s7Var3 = s7Var;
                } catch (Throwable th2) {
                    th = th2;
                    bitmap = bitmap2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    protected da.a e(t9 t9Var) {
        if (t9Var == null || t9Var.l() == null) {
            return null;
        }
        return da.B().t(t9Var);
    }

    public void f(Rect rect, long j2, Point point, Runnable runnable) {
        Node node = new Node();
        node.type = 1;
        node.duration = j2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        node.pathPoints = arrayList;
        if (point != null) {
            arrayList.add(Integer.valueOf(rect.centerX() + point.x));
            node.pathPoints.add(Integer.valueOf(rect.centerY() + point.y));
        } else {
            arrayList.add(Integer.valueOf(rect.centerX()));
            node.pathPoints.add(Integer.valueOf(rect.centerY()));
        }
        GesturePlayFloatView.B(rect);
        g(node, runnable);
    }

    public void g(Node node, Runnable runnable) {
        this.b = 8;
        i(node, runnable);
    }

    public void h(Rect rect, long j2, Point point, Runnable runnable) {
        Node node = new Node();
        node.type = 1;
        node.duration = j2;
        node.pathPoints = new ArrayList<>();
        try {
            node.getRandomPoint(rect);
        } catch (Exception unused) {
            node.pathPoints.add(Integer.valueOf(rect.centerX()));
            node.pathPoints.add(Integer.valueOf(rect.centerY()));
        }
        GesturePlayFloatView.B(rect);
        g(node, runnable);
    }

    public void i(Node node, Runnable runnable) {
        System.currentTimeMillis();
        GesturePlayFloatView.w(node);
        if (Build.VERSION.SDK_INT >= 24) {
            this.c.f(node, new v5(this, runnable, node));
        }
    }

    public void k(Node node, Runnable runnable) throws JSONException {
        j(node, null, null, 0, runnable);
    }

    public void l(Node node, Rect rect, Runnable runnable) throws JSONException {
        j(node, rect, null, 1, runnable);
    }

    public void m(Node node, Runnable runnable) throws JSONException {
        j(node, null, null, 1, runnable);
    }

    public void n(Node node, List<AccessibilityNodeInfo> list, Runnable runnable) throws JSONException {
        j(node, null, list, 1, runnable);
    }

    public boolean o(t9 t9Var, LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws JSONException {
        this.c = t9Var;
        if (!t9Var.q()) {
            return false;
        }
        if (node.getCondition() != null) {
            com.frame.y0.g(node.getStepAndName() + "：前置条件检测...");
            if (!d(node.getCondition())) {
                com.frame.y0.j("未满足前置条件 ☒☒☒ ");
                int i2 = node.type;
                if (i2 == 4 || i2 == 3) {
                    k(node, runnable);
                } else {
                    t9Var.Y(node, runnable);
                }
                return false;
            }
            com.frame.y0.n("满足前置条件 ☑☑☑ ");
        }
        return p(linkedHashMap, node, runnable);
    }

    public abstract boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable);

    public abstract String q();

    public abstract int r();

    public long s() {
        long j2 = da.B().M().imgScanDelay;
        if (j2 < 10) {
            return 10L;
        }
        return j2;
    }

    public abstract String t();

    public CharSequence v(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = null;
        for (AccessibilityNodeInfo parent = accessibilityNodeInfo; parent != null; parent = parent.getParent()) {
            collectionItemInfo = parent.getCollectionItemInfo();
            if (collectionItemInfo != null) {
                break;
            }
        }
        if (collectionItemInfo != null) {
            return collectionItemInfo.getColumnIndex() + "," + collectionItemInfo.getRowIndex();
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (text != null) {
            return text;
        }
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        if (contentDescription != null) {
            return contentDescription;
        }
        return null;
    }

    public String w(int i2) {
        switch (i2) {
            case -4:
            case -3:
                return "终止脚本";
            case -2:
                return "报错弹窗";
            case -1:
            case 1:
            case 6:
            case 14:
            case 15:
            default:
                return "";
            case 0:
                return "模拟点击";
            case 2:
                return "跳下一个节点";
            case 3:
                return "跳转节点";
            case 4:
                return "跳转任务";
            case 5:
                return "长按点击";
            case 7:
                return "点击附近的控件";
            case 8:
                return "拷贝文本";
            case 9:
                return "内容给到变量";
            case 10:
                return "元素内随机点击";
            case 11:
                return "记录坐标";
            case 12:
                return "点击后跳转任务";
            case 13:
                return "点击后跳转节点";
            case 16:
                return "连续点击";
            case 17:
                return "记录区域坐标";
        }
    }

    public ArrayList<Integer> x(String str) throws NumberFormatException {
        String strG = da.B().G(str);
        if (!strG.contains(ProcessIdUtil.DEFAULT_PROCESSID) || !strG.contains(",")) {
            com.frame.y0.j("变量坐标(" + str + "):" + strG);
            int i2 = Integer.parseInt(strG.split(",")[0]);
            int i3 = Integer.parseInt(strG.split(",")[1]);
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        com.frame.y0.n("变量坐标(" + str + "):" + strG);
        Rect rectByString = Node.getRectByString(strG);
        int iCenterX = rectByString.centerX();
        int iCenterY = rectByString.centerY();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(Integer.valueOf(iCenterX));
        arrayList2.add(Integer.valueOf(iCenterY));
        return arrayList2;
    }

    public AccessibilityNodeInfo y(String str) {
        CharSequence packageName;
        AccessibilityNodeInfo rootInActiveWindow = BoxService.m().getRootInActiveWindow();
        if (rootInActiveWindow == null || (packageName = rootInActiveWindow.getPackageName()) == null || !str.contentEquals(packageName)) {
            List<AccessibilityWindowInfo> windows = BoxService.m().getWindows();
            int size = windows.size() - 1;
            while (size >= 0) {
                rootInActiveWindow = windows.get(size).getRoot();
                if (rootInActiveWindow != null && str.contentEquals(rootInActiveWindow.getPackageName())) {
                    break;
                }
                size--;
                rootInActiveWindow = null;
            }
            if (rootInActiveWindow == null) {
                return null;
            }
        }
        return rootInActiveWindow;
    }

    protected x5 z(int i2) {
        t9 t9Var = this.c;
        return t9Var == null ? x7.d().e(i2) : t9Var.k(i2);
    }
}
