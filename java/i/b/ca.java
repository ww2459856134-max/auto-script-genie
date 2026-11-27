package i.b;

import android.os.CountDownTimer;
import android.os.PowerManager;
import android.widget.TextView;
import com.yl.float_ui.TopTipFloatView;

/* loaded from: classes.dex */
class ca extends CountDownTimer {
    final /* synthetic */ TopTipFloatView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ca(da daVar, long j2, long j3, TopTipFloatView topTipFloatView) {
        super(j2, j3);
        this.a = topTipFloatView;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.frame.s0.g().d(TopTipFloatView.class);
        if (com.frame.w0.d() && ((PowerManager) com.frame.v0.g().getSystemService("power")).isScreenOn()) {
            com.frame.w0.b().performGlobalAction(8);
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
        ((TextView) this.a.findViewById(j.b.e.m6)).setText("任务完成，" + (j2 / 1000) + "秒后自动锁屏");
    }
}
