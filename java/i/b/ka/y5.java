package i.b.ka;

import android.os.CountDownTimer;
import android.widget.TextView;

/* loaded from: classes.dex */
class y5 extends CountDownTimer {
    final /* synthetic */ TextView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    y5(z5 z5Var, long j2, long j3, TextView textView) {
        super(j2, j3);
        this.a = textView;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.a.callOnClick();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
        this.a.setText("继续执行(" + (j2 / 1000) + ")");
    }
}
