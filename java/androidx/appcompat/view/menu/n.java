package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.p;
import androidx.appcompat.view.menu.z;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: classes.dex */
class n implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, z.a {
    private m c;
    private androidx.appcompat.app.p d;
    k e;
    private z.a f;

    public n(m mVar) {
        this.c = mVar;
    }

    public void a() {
        androidx.appcompat.app.p pVar = this.d;
        if (pVar != null) {
            pVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.z.a
    public void b(m mVar, boolean z) {
        if (z || mVar == this.c) {
            a();
        }
        z.a aVar = this.f;
        if (aVar != null) {
            aVar.b(mVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.z.a
    public boolean c(m mVar) {
        z.a aVar = this.f;
        if (aVar != null) {
            return aVar.c(mVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        m mVar = this.c;
        p.a aVar = new p.a(mVar.u());
        k kVar = new k(aVar.b(), h.a.g.f1213l);
        this.e = kVar;
        kVar.j(this);
        this.c.b(this.e);
        aVar.c(this.e.a(), this);
        View viewY = mVar.y();
        if (viewY != null) {
            aVar.d(viewY);
        } else {
            aVar.e(mVar.w());
            aVar.m(mVar.x());
        }
        aVar.i(this);
        androidx.appcompat.app.p pVarA = aVar.a();
        this.d = pVarA;
        pVarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.d.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        this.d.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.c.L((p) this.e.a().getItem(i2), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.e.b(this.c, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.d.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.d.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.c.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.c.performShortcut(i2, keyEvent, 0);
    }
}
