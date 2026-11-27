package i.b;

import android.os.CountDownTimer;
import com.yl.float_ui.DingMsgView;

/* loaded from: classes.dex */
class y9 extends CountDownTimer {
    final /* synthetic */ DingMsgView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    y9(da daVar, long j2, long j3, DingMsgView dingMsgView) {
        super(j2, j3);
        this.a = dingMsgView;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.frame.s0.g().d(DingMsgView.class);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
        this.a.j("知道了(" + (j2 / 1000) + ")");
    }
}
