package androidx.appcompat.app;

import android.os.Message;
import android.view.View;

/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ AlertController c;

    c(AlertController alertController) {
        this.c = alertController;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        AlertController alertController = this.c;
        Message messageObtain = (view != alertController.f13o || (message3 = alertController.q) == null) ? (view != alertController.s || (message2 = alertController.u) == null) ? (view != alertController.w || (message = alertController.y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
        if (messageObtain != null) {
            messageObtain.sendToTarget();
        }
        AlertController alertController2 = this.c;
        alertController2.R.obtainMessage(1, alertController2.b).sendToTarget();
    }
}
