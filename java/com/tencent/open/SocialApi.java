package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class SocialApi {
    private SocialApiIml a;

    public SocialApi(QQToken qQToken) {
        this.a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        this.a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        this.a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        this.a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        this.a.story(activity, bundle, iUiListener);
    }
}
