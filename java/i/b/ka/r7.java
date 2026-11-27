package i.b.ka;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.yl.model.Node;
import com.yl.model.WidgetFeature;
import i.b.da;

/* loaded from: classes.dex */
class r7 implements com.frame.h0 {
    private Node a;
    private Rect b = new Rect();
    private boolean c;
    final /* synthetic */ s7 d;

    public r7(s7 s7Var, Node node, boolean z) {
        this.d = s7Var;
        this.a = node;
        this.c = z;
    }

    @Override // com.frame.h0
    public boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (!this.d.c.q()) {
            return false;
        }
        if (this.d.f.heightToggle) {
            accessibilityNodeInfo.getBoundsInScreen(this.b);
            String[] strArrSplit = da.B().G(this.d.f.height).split(ProcessIdUtil.DEFAULT_PROCESSID);
            if (strArrSplit.length > 1) {
                if (this.b.height() < Integer.valueOf(strArrSplit[0]).intValue() || this.b.height() > Integer.valueOf(strArrSplit[1]).intValue()) {
                    return false;
                }
            } else if (Integer.valueOf(strArrSplit[0]).intValue() != this.b.height()) {
                return false;
            }
        }
        if (this.d.f.widthToggle) {
            accessibilityNodeInfo.getBoundsInScreen(this.b);
            String[] strArrSplit2 = da.B().G(this.d.f.width).split(ProcessIdUtil.DEFAULT_PROCESSID);
            if (strArrSplit2.length > 1) {
                if (this.b.width() < Integer.valueOf(strArrSplit2[0]).intValue() || this.b.width() > Integer.valueOf(strArrSplit2[1]).intValue()) {
                    return false;
                }
            } else if (Integer.valueOf(strArrSplit2[0]).intValue() != this.b.width()) {
                return false;
            }
        }
        WidgetFeature widgetFeature = this.d.f;
        if (widgetFeature.classToggle && !String.valueOf(widgetFeature.className).contentEquals(accessibilityNodeInfo.getClassName())) {
            return false;
        }
        if (this.c && !accessibilityNodeInfo.isVisibleToUser()) {
            return false;
        }
        WidgetFeature widgetFeature2 = this.d.f;
        boolean z6 = widgetFeature2.textToggle;
        if (z6 && widgetFeature2.textType == 1) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (text == null) {
                return false;
            }
            String strG = da.B().G(String.valueOf(this.d.f.text));
            String[] strArrSplit3 = strG.contains("＠＠") ? strG.split("＠＠") : strG.split("@@");
            int length = strArrSplit3.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z5 = false;
                    break;
                }
                if (strArrSplit3[i2].contentEquals(text)) {
                    z5 = true;
                    break;
                }
                i2++;
            }
            if (!z5) {
                return false;
            }
        } else if (z6 && widgetFeature2.textType == 2) {
            CharSequence text2 = accessibilityNodeInfo.getText();
            if (text2 == null) {
                return false;
            }
            String strG2 = da.B().G(String.valueOf(this.d.f.text));
            if (strG2.contains("##")) {
                for (String str : strG2.split("##")) {
                    if (!text2.toString().contains(str)) {
                        return false;
                    }
                }
            } else if (strG2.contains("＠＠")) {
                String[] strArrSplit4 = strG2.split("＠＠");
                int length2 = strArrSplit4.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        z2 = false;
                        break;
                    }
                    if (text2.toString().contains(strArrSplit4[i3])) {
                        z2 = true;
                        break;
                    }
                    i3++;
                }
                if (!z2) {
                    return false;
                }
            } else {
                String[] strArrSplit5 = strG2.split("@@");
                int length3 = strArrSplit5.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length3) {
                        z = false;
                        break;
                    }
                    if (text2.toString().contains(strArrSplit5[i4])) {
                        z = true;
                        break;
                    }
                    i4++;
                }
                if (!z) {
                    return false;
                }
            }
        }
        WidgetFeature widgetFeature3 = this.d.f;
        boolean z7 = widgetFeature3.descToggle;
        if (z7 && widgetFeature3.descType == 1) {
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription == null) {
                return false;
            }
            String[] strArrSplit6 = da.B().G(String.valueOf(this.d.f.desc)).split("@@");
            int length4 = strArrSplit6.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length4) {
                    z4 = false;
                    break;
                }
                if (strArrSplit6[i5].contentEquals(contentDescription)) {
                    z4 = true;
                    break;
                }
                i5++;
            }
            if (!z4) {
                return false;
            }
        } else if (z7 && widgetFeature3.descType == 2) {
            CharSequence contentDescription2 = accessibilityNodeInfo.getContentDescription();
            if (contentDescription2 == null) {
                return false;
            }
            String[] strArrSplit7 = da.B().G(String.valueOf(this.d.f.desc)).split("@@");
            int length5 = strArrSplit7.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length5) {
                    z3 = false;
                    break;
                }
                if (contentDescription2.toString().contains(strArrSplit7[i6])) {
                    z3 = true;
                    break;
                }
                i6++;
            }
            if (!z3) {
                return false;
            }
        }
        Rect areaOrParam = this.a.getAreaOrParam();
        if (areaOrParam != null) {
            accessibilityNodeInfo.getBoundsInScreen(this.b);
            if (!areaOrParam.contains(this.b)) {
                return false;
            }
        } else if (this.a.hasAreaResolveError()) {
            return false;
        }
        if (!this.d.f.isPackageMatchEnabled()) {
            CharSequence packageName = accessibilityNodeInfo.getPackageName();
            if (packageName == null) {
                return false;
            }
            try {
                this.d.T(packageName.toString());
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }
}
