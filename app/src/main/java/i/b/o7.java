package i.b;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.user.AccountTool;
import com.v.FloatToast;

/* loaded from: classes.dex */
public abstract class o7 {

    public interface a {
        void a(boolean z);
    }

    private static GradientDrawable b(Activity activity, int i2, int i3, int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(d(activity, i4));
        gradientDrawable.setStroke(d(activity, 1), i3);
        return gradientDrawable;
    }

    private static RadioButton c(Activity activity, String str) {
        RadioButton radioButton = new RadioButton(activity);
        radioButton.setId(View.generateViewId());
        radioButton.setText(str);
        radioButton.setTextSize(14.0f);
        radioButton.setTextColor(-14737633);
        radioButton.setButtonTintList(ColorStateList.valueOf(-16033840));
        radioButton.setPadding(d(activity, 12), d(activity, 14), d(activity, 12), d(activity, 14));
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.topMargin = d(activity, 12);
        radioButton.setLayoutParams(layoutParams);
        return radioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(Activity activity, int i2) {
        return Math.round(i2 * activity.getResources().getDisplayMetrics().density);
    }

    static /* synthetic */ void e(Activity activity, RadioGroup radioGroup, RadioButton radioButton, View view) {
        if (j(activity)) {
            return;
        }
        radioGroup.check(radioButton.getId());
    }

    static /* synthetic */ void f(RadioButton radioButton, RadioButton radioButton2, Activity activity, RadioGroup radioGroup, int i2) {
        RadioButton[] radioButtonArr = {radioButton, radioButton2};
        for (int i3 = 0; i3 < 2; i3++) {
            RadioButton radioButton3 = radioButtonArr[i3];
            boolean z = radioButton3.getId() == i2;
            radioButton3.setBackground(b(activity, z ? -1511170 : -1, z ? -16033840 : -2104602, 16));
        }
    }

    static /* synthetic */ void i(AlertDialog alertDialog, RadioGroup radioGroup, RadioButton radioButton, i9 i9Var, Activity activity, RadioButton radioButton2, a aVar, View view) {
        if (alertDialog.isShowing()) {
            boolean z = radioGroup.getCheckedRadioButtonId() == radioButton.getId();
            if (z && i9Var.t() == null && !j(activity)) {
                radioGroup.check(radioButton2.getId());
                return;
            }
            String strU = z ? i9Var.u() : null;
            if (strU != null) {
                FloatToast.i(strU);
            } else {
                alertDialog.dismiss();
                aVar.a(z);
            }
        }
    }

    private static boolean j(Activity activity) {
        if (AccountTool.d().m()) {
            return true;
        }
        Toast.makeText(activity, "无障碍截图需要 VIP，请先开通 VIP", 1).show();
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("chenai://www.skyingidea.com/pay")));
            return false;
        } catch (Exception e) {
            com.frame.k0.r(e);
            return false;
        }
    }

    public static AlertDialog k(final Activity activity, final a aVar, final Runnable runnable) {
        final i9 i9VarV = i9.v();
        String strT = i9VarV.t();
        String strU = i9VarV.u();
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        int iD = d(activity, 20);
        linearLayout.setPadding(iD, d(activity, 8), iD, d(activity, 8));
        linearLayout.addView(l(activity, "找图、找色和文字识别都需要获取屏幕画面。"));
        if (strU != null) {
            TextView textViewL = l(activity, strU);
            textViewL.setTextColor(-7187456);
            textViewL.setBackground(b(activity, -2858, -7007, 12));
            int i2 = iD / 2;
            textViewL.setPadding(i2, i2, i2, i2);
            linearLayout.addView(textViewL);
        }
        final RadioGroup radioGroup = new RadioGroup(activity);
        StringBuilder sb = new StringBuilder();
        sb.append("无障碍截图模式（需要 VIP）\n无需录屏授权；需要 Android 11 及以上和无障碍服务，识别稳定。");
        sb.append(strT == null ? "" : "当前不可用，原因见上方提示。");
        final RadioButton radioButtonC = c(activity, sb.toString());
        final RadioButton radioButtonC2 = c(activity, "录屏权限模式\n连续取图更快；每次重新开启录屏都需要系统授权。");
        radioGroup.addView(radioButtonC);
        radioGroup.addView(radioButtonC2);
        radioButtonC.setEnabled(strT == null);
        radioButtonC.setAlpha(strT == null ? 1.0f : 0.5f);
        radioButtonC.setOnClickListener(new View.OnClickListener() { // from class: i.b.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o7.e(activity, radioGroup, radioButtonC2, view);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: i.b.m
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                o7.f(radioButtonC, radioButtonC2, activity, radioGroup2, i3);
            }
        });
        radioGroup.check((strU == null && da.B().M().useAccessibilityScreenshot) ? radioButtonC.getId() : radioButtonC2.getId());
        linearLayout.addView(radioGroup);
        linearLayout.addView(l(activity, "确认后记住选择，不再重复询问。可在兼容设置中切换；取消不更改设置。"));
        n7 n7Var = new n7(activity, activity);
        n7Var.addView(linearLayout);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(activity, R.style.Theme.Material.Light.Dialog.Alert).setTitle("选择截图模式").setView(n7Var).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: i.b.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                runnable.run();
            }
        }).setPositiveButton("使用所选模式", (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.l
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        alertDialogCreate.show();
        alertDialogCreate.getWindow().setBackgroundDrawable(b(activity, -1, -1, 24));
        alertDialogCreate.getWindow().setLayout(Math.min(d(activity, 420), activity.getResources().getDisplayMetrics().widthPixels - d(activity, 32)), -2);
        alertDialogCreate.getButton(-2).setTextColor(-16033840);
        alertDialogCreate.getButton(-1).setTextColor(-1);
        alertDialogCreate.getButton(-1).setPadding(d(activity, 12), 0, d(activity, 12), 0);
        alertDialogCreate.getButton(-1).setBackground(new RippleDrawable(ColorStateList.valueOf(872415231), b(activity, -16033840, -16033840, 24), null));
        alertDialogCreate.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: i.b.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o7.i(alertDialogCreate, radioGroup, radioButtonC, i9VarV, activity, radioButtonC2, aVar, view);
            }
        });
        return alertDialogCreate;
    }

    private static TextView l(Activity activity, String str) {
        TextView textView = new TextView(activity);
        textView.setText(str);
        textView.setTextSize(14.0f);
        textView.setTextColor(-12302522);
        textView.setPadding(0, d(activity, 8), 0, d(activity, 12));
        return textView;
    }
}
