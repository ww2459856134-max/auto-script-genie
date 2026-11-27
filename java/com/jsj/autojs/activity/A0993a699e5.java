package com.jsj.autojs.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.jsj.autojs.activity.A0993a699e5;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.yl.ui.s;
import i.h.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class A0993a699e5 extends com.yl.ui.p implements View.OnClickListener, View.OnTouchListener {
    private VideoView P;
    private ImageView Q;
    private MediaPlayer U;
    private String V;
    private TextView W;
    private TextView Z;
    private String a0;
    private boolean b0;

    class a implements MediaPlayer.OnErrorListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) throws IllegalStateException {
            try {
                A0993a699e5.this.U = mediaPlayer;
                mediaPlayer.stop();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    class b implements MediaPlayer.OnPreparedListener {
        b() {
        }

        static /* synthetic */ boolean a(MediaPlayer mediaPlayer, int i2, int i3) throws IllegalStateException {
            try {
                mediaPlayer.stop();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }

        static /* synthetic */ boolean b(MediaPlayer mediaPlayer, int i2, int i3) {
            return true;
        }

        static /* synthetic */ void c(MediaPlayer mediaPlayer) throws IllegalStateException {
            try {
                mediaPlayer.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                A0993a699e5.this.U = mediaPlayer;
                mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.jsj.autojs.activity.c0
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public final boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) {
                        return A0993a699e5.b.a(mediaPlayer2, i2, i3);
                    }
                });
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.jsj.autojs.activity.a0
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public final boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                        return A0993a699e5.b.b(mediaPlayer2, i2, i3);
                    }
                });
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.jsj.autojs.activity.b0
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer2) throws IllegalStateException {
                        A0993a699e5.b.c(mediaPlayer2);
                    }
                });
                A0993a699e5.this.U.setLooping(false);
                A0993a699e5.this.P.start();
                A0993a699e5.this.Q.setVisibility(8);
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    class c implements f.b<String> {
        c() {
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            A0993a699e5.this.Y(str);
        }

        @Override // i.h.f.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
        }
    }

    class d implements f.b<String> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        d(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            A0993a699e5.this.Y(str);
        }

        @Override // i.h.f.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt(this.a);
                int iOptInt2 = jSONObject.optInt(this.b);
                A0993a699e5.this.Z.setText(String.format("有帮助（%d）", Integer.valueOf(iOptInt)));
                A0993a699e5.this.W.setText(String.format("没帮助（%d）", Integer.valueOf(iOptInt2)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    class e implements DialogInterface.OnClickListener {
        e(A0993a699e5 a0993a699e5) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            com.jsj.autojs.l.c0.e().h();
        }
    }

    class f implements DialogInterface.OnClickListener {
        f(A0993a699e5 a0993a699e5) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            com.frame.i0.h(com.frame.v0.g().getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(MediaPlayer mediaPlayer) {
        this.Q.setVisibility(0);
    }

    private void s0() {
        if (TextUtils.isEmpty(this.a0)) {
            return;
        }
        String str = this.a0 + "_no";
        String str2 = this.a0 + "_ok";
        f.a aVar = new f.a();
        aVar.f("/getCount");
        aVar.e("key", str2 + "," + str);
        aVar.a().l(String.class, new d(str2, str));
    }

    private void t0(String str) {
        if (this.b0) {
            Y("已经提交了，请勿重新提交");
            return;
        }
        this.b0 = true;
        f.a aVar = new f.a();
        aVar.f("/addCount");
        aVar.e("key", str);
        aVar.a().l(String.class, new c());
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492919;
    }

    @Override // com.yl.ui.p
    public void b0() {
        VideoView videoView = (VideoView) findViewById(2131297330);
        this.P = videoView;
        videoView.setOnTouchListener(this);
        ImageView imageView = (ImageView) findViewById(2131297074);
        this.Q = imageView;
        imageView.setOnClickListener(this);
        this.Z = (TextView) findViewById(2131296491);
        TextView textView = (TextView) findViewById(2131296489);
        this.W = textView;
        textView.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(2131297240);
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("data"));
            String strOptString = jSONObject.optString("label");
            String strOptString2 = jSONObject.optString("descr");
            String strOptString3 = jSONObject.optString(SocialConstants.PARAM_URL);
            this.a0 = jSONObject.optString("author");
            j0(strOptString);
            if (TextUtils.isEmpty(strOptString2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(Html.fromHtml(strOptString2));
            }
            this.V = strOptString3;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.P.setOnErrorListener(new a());
        this.P.setOnPreparedListener(new b());
        this.P.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.jsj.autojs.activity.z
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                this.a.r0(mediaPlayer);
            }
        });
        s0();
        u0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException {
        int id = view.getId();
        if (id == 2131296489) {
            com.jsj.autojs.l.c0.e().g();
            return;
        }
        if (id != 2131296491) {
            if (id != 2131297074) {
                return;
            }
            try {
                MediaPlayer mediaPlayer = this.U;
                if (mediaPlayer == null) {
                    u0();
                } else {
                    mediaPlayer.prepareAsync();
                }
                this.Q.setVisibility(8);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                com.frame.k0.r(e2);
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(this.V));
                    intent.setFlags(268435456);
                    com.frame.v0.g().startActivity(intent);
                    return;
                } catch (Exception e3) {
                    com.frame.k0.i("no_webapp");
                    e3.printStackTrace();
                    return;
                }
            }
        }
        if (!TextUtils.isEmpty(this.a0)) {
            t0(this.a0 + "_ok");
        }
        if (com.frame.n0.a("alreadyCommon", false)) {
            return;
        }
        com.frame.n0.g("alreadyCommon", true);
        try {
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.r("五星好评", new f(this));
            aVar.m("吐槽一下", new e(this));
            aVar.s(2131558482);
            aVar.g(R.drawable.great_icon);
            aVar.j("希望我们能帮到您，也希望您能在百忙中给个好评！感谢您对我们的支持，您的支持是我们前进的动力，谢谢！祝福您万事如意。");
            aVar.e().show();
        } catch (Exception e4) {
            e4.printStackTrace();
            com.frame.k0.r(e4);
        }
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onPause() throws IllegalStateException {
        super.onPause();
        try {
            MediaPlayer mediaPlayer = this.U;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.pause();
                    this.Q.setVisibility(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onStop() throws IllegalStateException {
        super.onStop();
        try {
            MediaPlayer mediaPlayer = this.U;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            this.P.stopPlayback();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws IllegalStateException {
        MediaPlayer mediaPlayer;
        if (motionEvent.getAction() == 1 && (mediaPlayer = this.U) != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    this.U.pause();
                    this.Q.setVisibility(0);
                } else {
                    this.U.start();
                    this.Q.setVisibility(8);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    public void u0() {
        try {
            this.P.setVideoPath(this.V);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
