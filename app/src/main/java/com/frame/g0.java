package com.frame;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.PrecomputedText;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.AbsListView;
import android.widget.EditText;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.frame.w0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class g0 {
    private static g0 a;

    public interface a {
        void a(AccessibilityNodeInfo accessibilityNodeInfo);
    }

    public interface b {
        AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo);
    }

    public interface c {
        void a(AccessibilityNodeInfo accessibilityNodeInfo);

        void b();
    }

    private g0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(AccessibilityNodeInfo accessibilityNodeInfo, AtomicReference atomicReference, AtomicReference atomicReference2, final AtomicReference atomicReference3, String str, String str2, Rect rect, String str3, boolean z, AtomicReference atomicReference4, c cVar, boolean z2, long j2, long j3, AtomicReference atomicReference5) {
        AccessibilityNodeInfo accessibilityNodeInfoU;
        AccessibilityNodeInfo accessibilityNodeInfoN;
        if (accessibilityNodeInfo == null) {
            try {
                accessibilityNodeInfoU = v().u(null, w0.b());
            } catch (Exception e) {
                k0.r(e);
                return;
            }
        } else {
            accessibilityNodeInfoU = accessibilityNodeInfo;
        }
        if (accessibilityNodeInfoU == null) {
            return;
        }
        if (!TextUtils.isEmpty((CharSequence) atomicReference.get()) || !((Boolean) atomicReference2.get()).booleanValue()) {
            l1.e(new Runnable() { // from class: com.frame.j
                @Override // java.lang.Runnable
                public final void run() {
                    w0.b().i((w0.a) atomicReference3.get());
                }
            });
            return;
        }
        if (str != null) {
            try {
                if (str.contains("/")) {
                    if (!str.equals(((Object) accessibilityNodeInfoU.getPackageName()) + "/" + ((Object) accessibilityNodeInfoU.getClassName()))) {
                        return;
                    }
                } else {
                    String string = accessibilityNodeInfoU.getPackageName().toString();
                    Log.e("AccessibilityUtil", str + "===" + str);
                    if (!str.equals(string)) {
                        return;
                    }
                }
            } catch (Exception e2) {
                k0.r(e2);
                return;
            }
        }
        if (str2 == null) {
            accessibilityNodeInfoN = v().g(rect, accessibilityNodeInfoU, str3, z);
        } else if (str2.contains("&")) {
            accessibilityNodeInfoN = i(accessibilityNodeInfoU, str2, z);
            if (accessibilityNodeInfoN != null) {
                accessibilityNodeInfoN = f(accessibilityNodeInfoN, 4);
            }
        } else if (str2.contains("#")) {
            accessibilityNodeInfoN = k(null, str2, z);
            if (accessibilityNodeInfoN != null) {
                accessibilityNodeInfoN = f(accessibilityNodeInfoN, 4);
            }
        } else {
            accessibilityNodeInfoN = n(str2, accessibilityNodeInfoU, z);
            if (accessibilityNodeInfoN != null) {
                accessibilityNodeInfoN = f(accessibilityNodeInfoN, 4);
            }
        }
        if (accessibilityNodeInfoN != null && ((Boolean) atomicReference2.get()).booleanValue()) {
            atomicReference4.set(Boolean.FALSE);
            atomicReference.set(accessibilityNodeInfoU.getPackageName().toString());
            l1.e(new Runnable() { // from class: com.frame.g
                @Override // java.lang.Runnable
                public final void run() {
                    w0.b().i((w0.a) atomicReference3.get());
                }
            });
            if (cVar != null) {
                cVar.a(accessibilityNodeInfoN);
                return;
            }
            return;
        }
        if (!((Boolean) atomicReference2.get()).booleanValue() || !z2 || !((Boolean) atomicReference4.get()).booleanValue() || !TextUtils.isEmpty((CharSequence) atomicReference.get()) || System.currentTimeMillis() - j2 >= j3) {
            if (System.currentTimeMillis() - j2 <= j3 || !((Boolean) atomicReference5.get()).booleanValue()) {
                return;
            }
            l1.e(new Runnable() { // from class: com.frame.h
                @Override // java.lang.Runnable
                public final void run() {
                    w0.b().i((w0.a) atomicReference3.get());
                }
            });
            if (cVar != null) {
                cVar.b();
                return;
            }
            return;
        }
        l1.e(new Runnable() { // from class: com.frame.i
            @Override // java.lang.Runnable
            public final void run() {
                w0.b().a((w0.a) atomicReference3.get());
            }
        });
        if (v().P(accessibilityNodeInfoU)) {
            atomicReference5.set(Boolean.TRUE);
            return;
        }
        if (((Boolean) atomicReference5.get()).booleanValue()) {
            l1.e(new Runnable() { // from class: com.frame.d
                @Override // java.lang.Runnable
                public final void run() {
                    w0.b().i((w0.a) atomicReference3.get());
                }
            });
            Log.e("scroll", "onNoFind");
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    static /* synthetic */ void I(AtomicReference atomicReference) {
        if (atomicReference.get() != null) {
            w0.b().i((w0.a) atomicReference.get());
        }
    }

    private void K(ArrayDeque<AccessibilityNodeInfo> arrayDeque, AccessibilityNodeInfo accessibilityNodeInfo, int i2, boolean z) {
        int childCount = accessibilityNodeInfo.getChildCount();
        if (i2 >= 0) {
            childCount = -1;
        }
        int i3 = i2 < 0 ? 1 : -1;
        for (int i4 = i2 >= 0 ? childCount - 1 : 0; i4 != childCount; i4 += i3) {
            AccessibilityNodeInfo accessibilityNodeInfoS = z ? s(accessibilityNodeInfo, i4) : accessibilityNodeInfo.getChild(i4);
            if (accessibilityNodeInfoS != null) {
                arrayDeque.push(accessibilityNodeInfoS);
            }
        }
    }

    private AccessibilityNodeInfo k(String str, String str2, boolean z) {
        String str3;
        int i2;
        String[] strArrSplit;
        AccessibilityNodeInfo accessibilityNodeInfoU;
        try {
            String[] strArrSplit2 = str2.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            str3 = strArrSplit2.length > 1 ? strArrSplit2[1] : null;
            strArrSplit = strArrSplit2[0].split(",");
            accessibilityNodeInfoU = v().u(str, w0.b());
        } catch (Exception e) {
            k0.r(e);
        }
        if (accessibilityNodeInfoU == null) {
            return null;
        }
        for (String str4 : strArrSplit) {
            accessibilityNodeInfoU = w(str4, accessibilityNodeInfoU);
            if (accessibilityNodeInfoU == null) {
                return null;
            }
            if (A(accessibilityNodeInfoU.getClassName().toString())) {
                String string = accessibilityNodeInfoU.getClassName().toString();
                String strSubstring = str2.substring(str2.indexOf(",", str2.indexOf(string) + string.length() + 5) + 1);
                for (i2 = 0; i2 < accessibilityNodeInfoU.getChildCount(); i2++) {
                    AccessibilityNodeInfo accessibilityNodeInfoM = m(accessibilityNodeInfoU.getChild(i2), strSubstring, z);
                    if (accessibilityNodeInfoM != null) {
                        return accessibilityNodeInfoM;
                    }
                }
                return null;
            }
        }
        if (str3 == null) {
            return accessibilityNodeInfoU;
        }
        if (z && str3.equals(accessibilityNodeInfoU.getText())) {
            return accessibilityNodeInfoU;
        }
        if (accessibilityNodeInfoU.getText() == null || !accessibilityNodeInfoU.getText().toString().contains(str3)) {
            return null;
        }
        return accessibilityNodeInfoU;
    }

    public static g0 v() {
        g0 g0Var = a;
        if (g0Var != null) {
            return g0Var;
        }
        g0 g0Var2 = new g0();
        a = g0Var2;
        return g0Var2;
    }

    private boolean y(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo == null) {
            Log.e("AccessibilityUtil", "isCanClickByClassName: false");
            return false;
        }
        if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.isEnabled()) {
            return TextUtils.isEmpty(str) || str.contains(accessibilityNodeInfo.getClassName());
        }
        return false;
    }

    public boolean A(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName(str);
            if (!AbsListView.class.isAssignableFrom(cls)) {
                if (!Class.forName("androidx.recyclerview.widget.RecyclerView").isAssignableFrom(cls)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String J(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        if (accessibilityNodeInfo == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append("   ");
        }
        stringBuffer.append(accessibilityNodeInfo.getClassName());
        if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
            stringBuffer.append("--");
            stringBuffer.append(accessibilityNodeInfo.getText());
        }
        if (accessibilityNodeInfo.isClickable() || accessibilityNodeInfo.isCheckable()) {
            stringBuffer.append("--");
            stringBuffer.append("isClickable");
        }
        if (!TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
            stringBuffer.append("--getContentDescription:");
            stringBuffer.append(accessibilityNodeInfo.getContentDescription());
        }
        return stringBuffer.toString();
    }

    public void L(final AccessibilityNodeInfo accessibilityNodeInfo, final Rect rect, final String str, final String str2, final String str3, final long j2, long j3, final boolean z, final boolean z2, AtomicReference<Boolean> atomicReference, final c cVar) {
        Log.e("scroll", "寻找：findText:" + str3 + "path:" + str2 + "timeout:" + j2);
        if (w0.d()) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final AtomicReference atomicReference2 = new AtomicReference("");
            Boolean bool = Boolean.TRUE;
            final AtomicReference atomicReference3 = new AtomicReference(bool);
            final AtomicReference atomicReference4 = new AtomicReference(Boolean.FALSE);
            final AtomicReference atomicReference5 = new AtomicReference(null);
            AtomicReference<Boolean> atomicReference6 = atomicReference == null ? new AtomicReference<>(bool) : atomicReference;
            final AtomicReference<Boolean> atomicReference7 = atomicReference6;
            String str4 = "scroll";
            Runnable runnable = new Runnable() { // from class: com.frame.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.H(accessibilityNodeInfo, atomicReference2, atomicReference7, atomicReference5, str, str2, rect, str3, z, atomicReference3, cVar, z2, jCurrentTimeMillis, j2, atomicReference4);
                }
            };
            atomicReference5.set(new f0(this, atomicReference2, str3, z2, runnable));
            try {
                SystemClock.sleep(j3);
                while (System.currentTimeMillis() - jCurrentTimeMillis < j2) {
                    String str5 = str4;
                    Log.e(str5, "--------while loop find-------");
                    if (!((Boolean) atomicReference4.get()).booleanValue() && ((Boolean) atomicReference3.get()).booleanValue() && atomicReference6.get().booleanValue()) {
                        runnable.run();
                        SystemClock.sleep(100L);
                        str4 = str5;
                    }
                    Log.e(str5, "alreadyScroll:" + atomicReference4.get() + "，canScroll:" + atomicReference3.get());
                    return;
                }
                String str6 = str4;
                if (System.currentTimeMillis() - jCurrentTimeMillis < j2 || !TextUtils.isEmpty((CharSequence) atomicReference2.get())) {
                    return;
                }
                l1.e(new Runnable() { // from class: com.frame.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        g0.I(atomicReference5);
                    }
                });
                Log.e(str6, "onNoFind");
                if (cVar != null) {
                    cVar.b();
                }
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    public void M(String str, String str2, String str3, long j2, long j3, boolean z, AtomicReference<Boolean> atomicReference, c cVar) {
        L(null, null, null, str2, str3, j2, j3, false, z, atomicReference, cVar);
    }

    public boolean N(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        HashSet hashSet = new HashSet();
        while (accessibilityNodeInfo != null && hashSet.add(accessibilityNodeInfo)) {
            if (accessibilityNodeInfo.isScrollable()) {
                if (!accessibilityNodeInfo.performAction(i2)) {
                    return false;
                }
                y0.o("滑动屏幕");
                return true;
            }
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
        }
        return false;
    }

    public boolean O(int i2, AccessibilityNodeInfo accessibilityNodeInfo, int i3) {
        if (accessibilityNodeInfo != null && i2 <= 100) {
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                AccessibilityNodeInfo accessibilityNodeInfoS = s(accessibilityNodeInfo, i4);
                if (accessibilityNodeInfoS != null && accessibilityNodeInfoS.getClassName() != null) {
                    if (accessibilityNodeInfoS.isScrollable() && !accessibilityNodeInfoS.getClassName().toString().toLowerCase().contains("viewpager") && accessibilityNodeInfoS.performAction(i3)) {
                        y0.o("纵向滑动屏幕");
                        return true;
                    }
                    if (accessibilityNodeInfoS.getChildCount() > 0 && O(i2 + 1, accessibilityNodeInfoS, i3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean P(AccessibilityNodeInfo accessibilityNodeInfo) {
        return O(0, accessibilityNodeInfo, XMLEvent.CHANGE_PREFIX_MAPPING);
    }

    public boolean Q(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        ArrayDeque<AccessibilityNodeInfo> arrayDeque = new ArrayDeque<>();
        HashSet hashSet = new HashSet();
        hashSet.add(accessibilityNodeInfo);
        K(arrayDeque, accessibilityNodeInfo, 1, true);
        while (!arrayDeque.isEmpty()) {
            AccessibilityNodeInfo accessibilityNodeInfoPop = arrayDeque.pop();
            if (hashSet.add(accessibilityNodeInfoPop) && accessibilityNodeInfoPop.getClassName() != null) {
                if (accessibilityNodeInfoPop.isScrollable() && accessibilityNodeInfoPop.getClassName().toString().toLowerCase().contains("viewpager") && accessibilityNodeInfoPop.performAction(i2)) {
                    y0.o("横向滑动屏幕");
                    return true;
                }
                K(arrayDeque, accessibilityNodeInfoPop, 1, true);
            }
        }
        return false;
    }

    public boolean R(int i2, AccessibilityNodeInfo accessibilityNodeInfo, int i3) {
        Log.e("toScroll", "------------toScroll--------------" + i2);
        if (accessibilityNodeInfo != null && i2 <= 50) {
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                if (child != null && !accessibilityNodeInfo.equals(child)) {
                    if (child.isScrollable() && child.performAction(i3)) {
                        return true;
                    }
                    if (child.getChildCount() > 0 && R(i2 + 1, child, i3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean S(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        return R(0, accessibilityNodeInfo, i2);
    }

    public boolean T(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        ArrayDeque<AccessibilityNodeInfo> arrayDeque = new ArrayDeque<>();
        HashSet hashSet = new HashSet();
        hashSet.add(accessibilityNodeInfo);
        K(arrayDeque, accessibilityNodeInfo, 1, true);
        while (!arrayDeque.isEmpty()) {
            AccessibilityNodeInfo accessibilityNodeInfoPop = arrayDeque.pop();
            if (hashSet.add(accessibilityNodeInfoPop) && accessibilityNodeInfoPop.getClassName() != null) {
                if (accessibilityNodeInfoPop.isScrollable() && !accessibilityNodeInfoPop.getClassName().toString().toLowerCase().contains("viewpager")) {
                    if (Build.VERSION.SDK_INT < 23) {
                        return true;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("android.view.accessibility.action.ARGUMENT_ROW_INT", i2);
                    return accessibilityNodeInfoPop.performAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION.getId(), bundle);
                }
                K(arrayDeque, accessibilityNodeInfoPop, 1, true);
            }
        }
        return false;
    }

    public b a(int i2, String... strArr) {
        return new c0(this, strArr, i2);
    }

    public b b(String str) {
        return new d0(this, str);
    }

    public b c(int i2, String... strArr) {
        return new b0(this, i2, strArr);
    }

    public b d(String str) {
        return new e0(this, str);
    }

    public AccessibilityNodeInfo e(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2, String str, int i2, int i3) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        ArrayDeque<AccessibilityNodeInfo> arrayDeque = new ArrayDeque<>();
        HashSet hashSet = new HashSet();
        hashSet.add(accessibilityNodeInfo);
        K(arrayDeque, accessibilityNodeInfo, i2, true);
        while (!arrayDeque.isEmpty()) {
            AccessibilityNodeInfo accessibilityNodeInfoPop = arrayDeque.pop();
            if (accessibilityNodeInfoPop != accessibilityNodeInfo2 && hashSet.add(accessibilityNodeInfoPop)) {
                if (i2 < 0) {
                    J(accessibilityNodeInfoPop, i3);
                }
                if (y(accessibilityNodeInfoPop, str)) {
                    return accessibilityNodeInfoPop;
                }
                K(arrayDeque, accessibilityNodeInfoPop, i2, true);
            }
        }
        return null;
    }

    public AccessibilityNodeInfo f(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        if (y(accessibilityNodeInfo, null)) {
            return accessibilityNodeInfo;
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
        while (i2 > 0) {
            AccessibilityNodeInfo accessibilityNodeInfoT = t(accessibilityNodeInfo2);
            Log.e("AccessibilityUtil", "tempLevel: " + i2);
            i2 += -1;
            if (accessibilityNodeInfoT != null) {
                J(accessibilityNodeInfoT, 0);
                if (y(accessibilityNodeInfoT, null)) {
                    return accessibilityNodeInfoT;
                }
                AccessibilityNodeInfo accessibilityNodeInfoE = e(accessibilityNodeInfoT, accessibilityNodeInfo, null, 1, 0);
                if (accessibilityNodeInfoE != null) {
                    return accessibilityNodeInfoE;
                }
                accessibilityNodeInfo2 = accessibilityNodeInfoT;
            }
        }
        return accessibilityNodeInfo;
    }

    public AccessibilityNodeInfo g(Rect rect, AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
        return h(rect, accessibilityNodeInfo, str, z, 1);
    }

    public AccessibilityNodeInfo h(Rect rect, AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z, int i2) {
        Rect rect2;
        Log.e("AccessibilityUtil", "----------findCanClickViewNearText----------" + str);
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
        if (listFindAccessibilityNodeInfosByText == null || listFindAccessibilityNodeInfosByText.isEmpty()) {
            return null;
        }
        AccessibilityNodeInfo accessibilityNodeInfoT = null;
        for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByText) {
            if (rect != null) {
                try {
                    rect2 = new Rect();
                    accessibilityNodeInfo2.getBoundsInScreen(rect2);
                } catch (Exception e) {
                    k0.r(e);
                }
                if (!rect.contains(rect2)) {
                    continue;
                }
            }
            if (!z || (accessibilityNodeInfo2.getText() != null && accessibilityNodeInfo2.getText().equals(str))) {
                if (y(accessibilityNodeInfo2, null)) {
                    return accessibilityNodeInfo2;
                }
                int i3 = 3;
                AccessibilityNodeInfo accessibilityNodeInfo3 = accessibilityNodeInfo2;
                while (i3 > 0) {
                    accessibilityNodeInfoT = t(accessibilityNodeInfo3);
                    int i4 = i3 - 1;
                    if (accessibilityNodeInfoT != null) {
                        if (y(accessibilityNodeInfoT, null)) {
                            return accessibilityNodeInfoT;
                        }
                        AccessibilityNodeInfo accessibilityNodeInfoE = e(accessibilityNodeInfoT, accessibilityNodeInfo2, null, i2, 3);
                        if (accessibilityNodeInfoE != null) {
                            return accessibilityNodeInfoE;
                        }
                        accessibilityNodeInfo3 = accessibilityNodeInfoT;
                    }
                    i3 = i4;
                }
            }
        }
        return accessibilityNodeInfoT;
    }

    public AccessibilityNodeInfo i(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
        String[] strArrSplit = str.split("&");
        if (Build.VERSION.SDK_INT >= 18) {
            List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(strArrSplit[0]);
            String str2 = strArrSplit.length > 1 ? strArrSplit[1] : null;
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo2 != null) {
                    if (str2 == null) {
                        return accessibilityNodeInfo2;
                    }
                    if (z && str2.equals(accessibilityNodeInfo2.getText())) {
                        return accessibilityNodeInfo2;
                    }
                    if (accessibilityNodeInfo2.getText() != null && accessibilityNodeInfo2.getText().toString().contains(str2)) {
                        return accessibilityNodeInfo2;
                    }
                }
            }
        }
        return null;
    }

    public AccessibilityNodeInfo j(String str, String str2, AccessibilityNodeInfo accessibilityNodeInfo, h0 h0Var) throws NumberFormatException {
        AccessibilityNodeInfo accessibilityNodeInfoL;
        for (String str3 : str2.split(",")) {
            accessibilityNodeInfo = w(str3, accessibilityNodeInfo);
            if (accessibilityNodeInfo == null) {
                return null;
            }
            if (A(accessibilityNodeInfo.getClassName().toString())) {
                String string = accessibilityNodeInfo.getClassName().toString();
                String strSubstring = str2.substring(str2.indexOf(",", str2.indexOf(string) + string.length() + 5) + 1);
                for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
                    if (child != null && (accessibilityNodeInfoL = l(child, strSubstring, h0Var)) != null) {
                        return accessibilityNodeInfoL;
                    }
                }
                return null;
            }
        }
        if (h0Var == null || h0Var.a(accessibilityNodeInfo)) {
            return accessibilityNodeInfo;
        }
        return null;
    }

    public AccessibilityNodeInfo l(AccessibilityNodeInfo accessibilityNodeInfo, String str, h0 h0Var) throws NumberFormatException {
        try {
            String[] strArrSplit = str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            if (strArrSplit.length > 1) {
                String str2 = strArrSplit[1];
            }
            for (String str3 : strArrSplit[0].split(",")) {
                String str4 = str3.split("#")[0];
                int i2 = Integer.parseInt(str3.split("#")[1]);
                if (accessibilityNodeInfo != null && i2 < accessibilityNodeInfo.getChildCount() && (accessibilityNodeInfo = accessibilityNodeInfo.getChild(i2)) != null && !str4.equals(accessibilityNodeInfo.getClassName())) {
                    return null;
                }
            }
        } catch (Exception e) {
            k0.r(e);
        }
        if (accessibilityNodeInfo == null) {
            return null;
        }
        if (h0Var.a(accessibilityNodeInfo)) {
            return accessibilityNodeInfo;
        }
        return null;
    }

    public AccessibilityNodeInfo m(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) throws NumberFormatException {
        String str2;
        try {
            String[] strArrSplit = str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            str2 = strArrSplit.length > 1 ? strArrSplit[1] : null;
            for (String str3 : strArrSplit[0].split(",")) {
                String str4 = str3.split("#")[0];
                int i2 = Integer.parseInt(str3.split("#")[1]);
                if (accessibilityNodeInfo != null && i2 < accessibilityNodeInfo.getChildCount() && (accessibilityNodeInfo = accessibilityNodeInfo.getChild(i2)) != null && !str4.equals(accessibilityNodeInfo.getClassName())) {
                    return null;
                }
            }
        } catch (Exception e) {
            k0.r(e);
        }
        if (accessibilityNodeInfo == null) {
            return null;
        }
        if (str2 == null || "null".equals(str2) || (z && str2.equals(accessibilityNodeInfo.getText()))) {
            return accessibilityNodeInfo;
        }
        if (accessibilityNodeInfo.getText() != null) {
            if (accessibilityNodeInfo.getText().toString().contains(str2)) {
                return accessibilityNodeInfo;
            }
        }
        return null;
    }

    public AccessibilityNodeInfo n(String str, AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        if (accessibilityNodeInfo != null && str != null) {
            ArrayDeque<AccessibilityNodeInfo> arrayDeque = new ArrayDeque<>();
            HashSet hashSet = new HashSet();
            hashSet.add(accessibilityNodeInfo);
            K(arrayDeque, accessibilityNodeInfo, 1, false);
            while (!arrayDeque.isEmpty()) {
                AccessibilityNodeInfo accessibilityNodeInfoPop = arrayDeque.pop();
                if (hashSet.add(accessibilityNodeInfoPop)) {
                    CharSequence text = accessibilityNodeInfoPop.getText();
                    if (text != null) {
                        String string = text.toString();
                        Log.e("AccessibilityUtil", string);
                        if ((z && str.equals(string)) || string.contains(str)) {
                            return accessibilityNodeInfoPop;
                        }
                    }
                    K(arrayDeque, accessibilityNodeInfoPop, 1, false);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AccessibilityNodeInfo o(int i2, AccessibilityNodeInfo accessibilityNodeInfo, boolean z, boolean z2, String... strArr) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        ArrayDeque<AccessibilityNodeInfo> arrayDeque = new ArrayDeque<>();
        HashSet hashSet = new HashSet();
        hashSet.add(accessibilityNodeInfo);
        K(arrayDeque, accessibilityNodeInfo, 1, false);
        while (!arrayDeque.isEmpty()) {
            AccessibilityNodeInfo accessibilityNodeInfoPop = arrayDeque.pop();
            if (hashSet.add(accessibilityNodeInfoPop)) {
                if (accessibilityNodeInfoPop.getChildCount() == 0) {
                    CharSequence text = accessibilityNodeInfoPop.getText();
                    CharSequence contentDescription = accessibilityNodeInfoPop.getContentDescription();
                    String string = text == null ? "" : text.toString();
                    String string2 = contentDescription != null ? contentDescription.toString() : "";
                    if (z) {
                        for (String str : strArr) {
                            if (str.equals(string) && string.length() < i2) {
                                return accessibilityNodeInfoPop;
                            }
                            if (z2 && str.equals(string2) && string2.length() < i2) {
                                return accessibilityNodeInfoPop;
                            }
                        }
                    } else {
                        for (PrecomputedText precomputedText : strArr) {
                            if (string.contains(precomputedText) && string.length() < i2) {
                                return accessibilityNodeInfoPop;
                            }
                            if (z2 && string2.contains(precomputedText) && string2.length() < i2) {
                                return accessibilityNodeInfoPop;
                            }
                        }
                    }
                } else {
                    K(arrayDeque, accessibilityNodeInfoPop, 1, false);
                }
            }
        }
        return null;
    }

    public boolean p(String str, b bVar, a aVar) {
        return q(str, bVar, aVar, 20);
    }

    public boolean q(String str, b bVar, a aVar, int i2) throws InterruptedException {
        AccessibilityNodeInfo root;
        AccessibilityNodeInfo accessibilityNodeInfoA;
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                Thread.sleep(200L);
                try {
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 < 21) {
                        if (i4 >= 16) {
                            AccessibilityNodeInfo rootInActiveWindow = w0.b().getRootInActiveWindow();
                            if (str == null || str.equals(rootInActiveWindow.getPackageName())) {
                                AccessibilityNodeInfo accessibilityNodeInfoA2 = bVar.a(rootInActiveWindow);
                                if (accessibilityNodeInfoA2 != null) {
                                    aVar.a(accessibilityNodeInfoA2);
                                }
                            }
                        }
                        return true;
                    }
                    List<AccessibilityWindowInfo> windows = w0.b().getWindows();
                    for (int size = windows.size() - 1; size >= 0; size--) {
                        AccessibilityWindowInfo accessibilityWindowInfo = windows.get(size);
                        if (accessibilityWindowInfo != null && (root = accessibilityWindowInfo.getRoot()) != null) {
                            if (str != null) {
                                str.equals(root.getPackageName());
                            } else if (accessibilityWindowInfo.isActive() && (accessibilityNodeInfoA = bVar.a(root)) != null) {
                                aVar.a(accessibilityNodeInfoA);
                                return true;
                            }
                        }
                    }
                } catch (Exception e) {
                    k0.r(e);
                }
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }
        return false;
    }

    public List<AccessibilityNodeInfo> r(List<AccessibilityNodeInfo> list, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (accessibilityNodeInfo == null) {
            return list;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        hashSet.add(accessibilityNodeInfo);
        for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(childCount);
            if (child != null) {
                arrayDeque.push(child);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) arrayDeque.pop();
            if (hashSet.add(accessibilityNodeInfo2)) {
                int childCount2 = accessibilityNodeInfo2.getChildCount();
                if (childCount2 > 0) {
                    for (int i2 = childCount2 - 1; i2 >= 0; i2--) {
                        AccessibilityNodeInfo child2 = accessibilityNodeInfo2.getChild(i2);
                        if (child2 != null) {
                            arrayDeque.push(child2);
                        }
                    }
                } else if (accessibilityNodeInfo2.getClassName() != null && z(accessibilityNodeInfo2.getClassName().toString())) {
                    list.add(accessibilityNodeInfo2);
                }
            }
        }
        return list;
    }

    public AccessibilityNodeInfo s(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        int i3 = 0;
        while (i3 < 2) {
            i3++;
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
            if (child != null) {
                return child;
            }
            Log.e("AccessibilityUtil", "getForceChildren: " + i3);
            SystemClock.sleep(100L);
        }
        Log.e("AccessibilityUtil", "getForceChildren: 未获取到");
        return null;
    }

    public AccessibilityNodeInfo t(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2 = 0;
        while (i2 < 5) {
            i2++;
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
            if (parent != null) {
                return parent;
            }
            Log.e("AccessibilityUtil", "getForceParent: " + i2);
            SystemClock.sleep(100L);
        }
        Log.e("AccessibilityUtil", "getForceParent: 未获取到");
        return null;
    }

    public AccessibilityNodeInfo u(String str, AccessibilityService accessibilityService) {
        String string;
        if (accessibilityService == null) {
            return null;
        }
        int i2 = 0;
        while (i2 < 4) {
            i2++;
            AccessibilityNodeInfo accessibilityNodeInfoX = x(accessibilityService);
            if (accessibilityNodeInfoX != null) {
                if (str != null) {
                    string = accessibilityNodeInfoX.getPackageName().toString();
                    if (!str.equals(string)) {
                    }
                }
                return accessibilityNodeInfoX;
            }
            string = null;
            if ("com.android.systemui".equals(string)) {
                return accessibilityNodeInfoX;
            }
            Log.e("AccessibilityUtil", "getForceRootNodeInfo: " + i2);
            SystemClock.sleep(100L);
        }
        Log.e("AccessibilityUtil", "getForceRootNodeInfo: 未获取到");
        return null;
    }

    public AccessibilityNodeInfo w(String str, AccessibilityNodeInfo accessibilityNodeInfo) throws NumberFormatException {
        AccessibilityNodeInfo child;
        String[] strArrSplit = str.split("#");
        String str2 = strArrSplit[0];
        int i2 = Integer.parseInt(strArrSplit[1]);
        if (i2 >= accessibilityNodeInfo.getChildCount() || (child = accessibilityNodeInfo.getChild(i2)) == null || !str2.equals(child.getClassName().toString())) {
            return null;
        }
        return child;
    }

    public AccessibilityNodeInfo x(AccessibilityService accessibilityService) {
        if (Build.VERSION.SDK_INT < 21) {
            return accessibilityService.getRootInActiveWindow();
        }
        List<AccessibilityWindowInfo> windows = accessibilityService.getWindows();
        if (windows.isEmpty()) {
            return null;
        }
        return windows.get(windows.size() - 1).getRoot();
    }

    public boolean z(String str) {
        try {
            return EditText.class.isAssignableFrom(Class.forName(str));
        } catch (Exception unused) {
            return false;
        }
    }
}
