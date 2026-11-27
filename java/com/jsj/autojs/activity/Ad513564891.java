package com.jsj.autojs.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jsj.autojs.adapter.StabilityAdapter;
import com.tencent.cursor.R;
import i.h.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Ad513564891 extends com.yl.ui.p implements BaseQuickAdapter.OnItemClickListener {
    private StabilityAdapter P;

    class a extends i.h.g<String> {
        a(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            Ad513564891.this.Y(str);
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) throws JSONException {
            try {
                JSONArray jSONArray = new JSONObject(str.replace("$appName", com.frame.v0.g().getString(R.string.app_name)).replace("$packageName", com.frame.v0.g().getPackageName()).replace("$appUid", com.frame.v0.g().getApplicationInfo().uid + "")).getJSONArray("content");
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.getJSONObject(i2));
                }
                Ad513564891.this.P.setNewData(arrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Ad513564891.this.S();
        }
    }

    private void l0() {
        U();
        f.a aVar = new f.a();
        aVar.f("/getCompatibilities");
        aVar.a().l(String.class, new a(this));
    }

    public static boolean m0(JSONObject jSONObject) throws Exception {
        String strOptString = jSONObject.optString("packageName");
        String strOptString2 = jSONObject.optString("className");
        String strOptString3 = jSONObject.optString("intentExtra");
        String strOptString4 = jSONObject.optString("intentUri");
        String strOptString5 = jSONObject.optString("intentPackage");
        String strOptString6 = jSONObject.optString("intentAction");
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(strOptString)) {
            if (TextUtils.isEmpty(strOptString2)) {
                intent = com.frame.i0.c(strOptString);
                if (intent == null) {
                    return false;
                }
            } else {
                intent.setComponent(new ComponentName(strOptString, strOptString2));
            }
        }
        if (!TextUtils.isEmpty(strOptString6)) {
            intent.setAction(strOptString6);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            intent.setData(Uri.parse(strOptString4));
        }
        if (!TextUtils.isEmpty(strOptString5)) {
            intent.setPackage(strOptString5);
        }
        if (!TextUtils.isEmpty(strOptString3)) {
            String[] strArrSplit = strOptString3.split(",");
            for (String str : strArrSplit) {
                String str2 = str.split("=")[0];
                String str3 = str.split("=")[1];
                try {
                    intent.putExtra(str2, Integer.parseInt(str3));
                } catch (Exception unused) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        com.frame.v0.g().s(intent);
        return true;
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492917;
    }

    @Override // com.yl.ui.p
    public void b0() {
        super.b0();
        j0("优化APP稳定性");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StabilityAdapter stabilityAdapter = new StabilityAdapter(null);
        this.P = stabilityAdapter;
        recyclerView.setAdapter(stabilityAdapter);
        this.P.setOnItemClickListener(this);
        l0();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) throws JSONException {
        try {
            JSONArray jSONArray = this.P.getItem(i2).getJSONArray("activities");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    m0(jSONArray.getJSONObject(i3));
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
