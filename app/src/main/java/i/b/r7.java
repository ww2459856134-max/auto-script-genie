package i.b;

import android.content.Intent;
import android.widget.Toast;
import com.act.WebAct;
import com.tencent.open.SocialConstants;
import i.h.f;

/* loaded from: classes.dex */
class r7 implements f.b<String> {
    r7(t7 t7Var) {
    }

    @Override // i.h.f.b
    public void a(int i2, String str) {
        try {
            Toast.makeText(com.frame.v0.g(), str, 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // i.h.f.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        Intent intent = new Intent(com.frame.v0.g().d(), (Class<?>) WebAct.class);
        intent.addFlags(268435456);
        intent.putExtra(SocialConstants.PARAM_URL, str);
        intent.putExtra("title", "客服");
        com.frame.v0.g().startActivity(intent);
        Toast.makeText(com.frame.v0.g(), "可发邮件至chenai@skyingidea.com", 0).show();
    }
}
