package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class QzonePublish extends BaseApi {
    public static final String HULIAN_CALL_BACK = "hulian_call_back";
    public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x035c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException {
        String str;
        String str2;
        String string;
        String appId;
        String openId;
        String str3;
        String str4;
        String str5;
        String str6;
        Intent intent;
        Bundle bundle2;
        SLog.i("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string2 = bundle.getString("summary");
        int i2 = bundle.getInt("req_type", 3);
        String string3 = bundle.getString("appName");
        String string4 = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        int i3 = bundle.getInt(PUBLISH_TO_QZONE_VIDEO_DURATION);
        long j2 = bundle.getLong(PUBLISH_TO_QZONE_VIDEO_SIZE);
        try {
            bundle2 = bundle.getBundle("extMap");
        } catch (Exception e) {
            e = e;
            str = "";
        }
        if (bundle2 != null) {
            Set<String> setKeySet = bundle2.keySet();
            str = "";
            try {
                JSONObject jSONObject = new JSONObject();
                Iterator<String> it = setKeySet.iterator();
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    String next = it.next();
                    if (TextUtils.isEmpty(bundle2.getString(next))) {
                        str2 = string3;
                    } else {
                        str2 = string3;
                        try {
                            jSONObject.put(next, bundle2.getString(next));
                        } catch (Exception e2) {
                            e = e2;
                            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                            string = str;
                            appId = this.c.getAppId();
                            openId = this.c.getOpenId();
                            SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                            if (3 == i2) {
                            }
                            if (4 == i2) {
                            }
                            String str7 = str6;
                            if (!TextUtils.isEmpty(string2)) {
                            }
                            if (!TextUtils.isEmpty(appId)) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            if (!l.e(str5)) {
                            }
                            if (!TextUtils.isEmpty(str3)) {
                            }
                            stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
                            String str8 = str4;
                            SLog.v(str8, "doPublishToQzone, url: " + stringBuffer.toString());
                            com.tencent.connect.a.a.a(f.a(), this.c, "requireApi", "shareToNativeQQ");
                            intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(stringBuffer.toString()));
                            intent.putExtra("pkg_name", activity.getPackageName());
                            if (a(intent)) {
                            }
                            SLog.i(SLog.TAG, "doPublishToQzone() --end");
                        }
                    }
                    it = it2;
                    string3 = str2;
                }
                str2 = string3;
                if (jSONObject.length() > 0) {
                    string = jSONObject.toString();
                }
            } catch (Exception e3) {
                e = e3;
                str2 = string3;
                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                string = str;
                appId = this.c.getAppId();
                openId = this.c.getOpenId();
                SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                if (3 == i2) {
                }
                if (4 == i2) {
                }
                String str72 = str6;
                if (!TextUtils.isEmpty(string2)) {
                }
                if (!TextUtils.isEmpty(appId)) {
                }
                if (!TextUtils.isEmpty(str2)) {
                }
                if (!l.e(str5)) {
                }
                if (!TextUtils.isEmpty(str3)) {
                }
                stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
                String str82 = str4;
                SLog.v(str82, "doPublishToQzone, url: " + stringBuffer.toString());
                com.tencent.connect.a.a.a(f.a(), this.c, "requireApi", "shareToNativeQQ");
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringBuffer.toString()));
                intent.putExtra("pkg_name", activity.getPackageName());
                if (a(intent)) {
                }
                SLog.i(SLog.TAG, "doPublishToQzone() --end");
            }
            appId = this.c.getAppId();
            openId = this.c.getOpenId();
            SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
            if (3 == i2 || stringArrayList == null) {
                str3 = string;
                str4 = "openSDK_LOG.QzonePublish";
                str5 = openId;
                str6 = str;
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                str4 = "openSDK_LOG.QzonePublish";
                int size = stringArrayList.size();
                str3 = string;
                int i4 = 0;
                while (i4 < size) {
                    String str9 = openId;
                    stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i4)));
                    String strA = l.a(appId, activity, stringArrayList.get(i4), iUiListener);
                    if (!TextUtils.isEmpty(strA)) {
                        stringBuffer3.append(URLEncoder.encode(strA));
                    }
                    if (i4 != size - 1) {
                        stringBuffer2.append(";");
                        stringBuffer3.append(";");
                    }
                    i4++;
                    openId = str9;
                }
                str5 = openId;
                stringBuffer.append("&image_url=" + Base64.encodeToString(l.i(stringBuffer2.toString()), 2));
                if (!TextUtils.isEmpty(stringBuffer3.toString())) {
                    stringBuffer.append("&image_uri=" + Base64.encodeToString(l.i(stringBuffer3.toString()), 2));
                }
                str6 = "7";
            }
            if (4 == i2) {
                stringBuffer.append("&videoPath=" + Base64.encodeToString(l.i(string4), 2));
                String strA2 = l.a(appId, activity, string4, iUiListener);
                if (!TextUtils.isEmpty(strA2)) {
                    stringBuffer.append("&videoUri=" + Base64.encodeToString(l.i(strA2), 2));
                }
                stringBuffer.append("&videoDuration=" + Base64.encodeToString(l.i(String.valueOf(i3)), 2));
                stringBuffer.append("&videoSize=" + Base64.encodeToString(l.i(String.valueOf(j2)), 2));
                str6 = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
            }
            String str722 = str6;
            if (!TextUtils.isEmpty(string2)) {
                stringBuffer.append("&description=" + Base64.encodeToString(l.i(string2), 2));
            }
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
            }
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(str2), 2));
            }
            if (!l.e(str5)) {
                stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(str5), 2));
            }
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(l.i(str3), 2));
            }
            stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
            String str822 = str4;
            SLog.v(str822, "doPublishToQzone, url: " + stringBuffer.toString());
            com.tencent.connect.a.a.a(f.a(), this.c, "requireApi", "shareToNativeQQ");
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putExtra("pkg_name", activity.getPackageName());
            if (a(intent)) {
                SLog.e(str822, "doPublishToQzone() target activity not found");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                d.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str722, "0", "1", "0");
            } else {
                a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
                d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                d.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str722, "0", "1", "0");
            }
            SLog.i(SLog.TAG, "doPublishToQzone() --end");
        }
        str = "";
        str2 = string3;
        string = str;
        appId = this.c.getAppId();
        openId = this.c.getOpenId();
        SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
        if (3 == i2) {
            str3 = string;
            str4 = "openSDK_LOG.QzonePublish";
            str5 = openId;
            str6 = str;
        }
        if (4 == i2) {
        }
        String str7222 = str6;
        if (!TextUtils.isEmpty(string2)) {
        }
        if (!TextUtils.isEmpty(appId)) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        if (!l.e(str5)) {
        }
        if (!TextUtils.isEmpty(str3)) {
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
        String str8222 = str4;
        SLog.v(str8222, "doPublishToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(f.a(), this.c, "requireApi", "shareToNativeQQ");
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (a(intent)) {
        }
        SLog.i(SLog.TAG, "doPublishToQzone() --end");
    }

    public void publishToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        if (!l.f(activity)) {
            iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new TDialog(activity, "", a(""), null, this.c).show();
            return;
        }
        String strA = l.a(activity);
        int i2 = 0;
        if (strA == null) {
            strA = bundle.getString("appName");
        } else if (strA.length() > 20) {
            strA = strA.substring(0, 20) + "...";
        }
        if (!TextUtils.isEmpty(strA)) {
            bundle.putString("appName", strA);
        }
        int i3 = bundle.getInt("req_type");
        if (i3 == 3) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                while (i2 < stringArrayList.size()) {
                    if (!l.h(stringArrayList.get(i2))) {
                        stringArrayList.remove(i2);
                        i2--;
                    }
                    i2++;
                }
                bundle.putStringArrayList("imageUrl", stringArrayList);
            }
            b(activity, bundle, iUiListener);
            SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            return;
        }
        if (i3 != 4) {
            iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            return;
        }
        final String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        if (!l.h(string)) {
            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
            iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.connect.share.QzonePublish.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) throws JSONException {
                long length = new File(string).length();
                int duration = mediaPlayer2.getDuration();
                bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, string);
                bundle.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                bundle.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                QzonePublish.this.b(activity, bundle, iUiListener);
                SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.connect.share.QzonePublish.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i4, int i5) {
                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                return false;
            }
        });
        try {
            mediaPlayer.setDataSource(string);
            mediaPlayer.prepareAsync();
        } catch (Exception unused) {
            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
            iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
        }
    }
}
