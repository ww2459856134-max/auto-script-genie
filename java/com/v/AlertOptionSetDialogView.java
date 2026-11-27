package com.v;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.v.item.AreaChooseItem;
import com.v.item.BaseItemView;
import com.v.item.CoordItem;
import com.v.item.FileItem;
import com.v.item.InputItem;
import com.v.item.MultiSelectItem;
import com.v.item.SelectItem;
import com.yl.model.Node;
import com.yl.model.Task;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AlertOptionSetDialogView extends RelativeLayout implements View.OnClickListener {
    private LinearLayout c;
    private Task d;
    private Node e;
    private JSONArray f;
    View.OnClickListener g;

    /* renamed from: h, reason: collision with root package name */
    View.OnClickListener f902h;

    public AlertOptionSetDialogView(Context context) {
        super(context);
    }

    private View a(JSONObject jSONObject) {
        AreaChooseItem areaChooseItem = new AreaChooseItem(com.frame.v0.g());
        areaChooseItem.setLabel(jSONObject.optString("key"));
        areaChooseItem.setValue(Node.getRectByString(jSONObject.optString("value")), null);
        return areaChooseItem;
    }

    private View b(JSONObject jSONObject) {
        FileItem fileItem = new FileItem(com.frame.v0.g());
        fileItem.setLabel(jSONObject.optString("key"));
        fileItem.setValue(jSONObject.optString("value"));
        return fileItem;
    }

    private View c(JSONObject jSONObject) {
        MultiSelectItem multiSelectItem = new MultiSelectItem(com.frame.v0.g());
        multiSelectItem.setLabel(jSONObject.optString("key"));
        multiSelectItem.setItems(jSONObject.optString("items").split("@@"));
        multiSelectItem.setValue(jSONObject.optString("value"));
        return multiSelectItem;
    }

    private View d(JSONObject jSONObject) {
        InputItem inputItem = new InputItem(com.frame.v0.g());
        inputItem.setLabel(jSONObject.optString("key"));
        inputItem.setValue(jSONObject.optString("value"));
        inputItem.setInputType(8194);
        return inputItem;
    }

    private View e(JSONObject jSONObject) {
        CoordItem coordItem = new CoordItem(com.frame.v0.g());
        coordItem.setLabel(jSONObject.optString("key"));
        if (!TextUtils.isEmpty(jSONObject.optString("value"))) {
            coordItem.setValue(Node.getPointByString(jSONObject.optString("value")));
        }
        return coordItem;
    }

    private View f(JSONObject jSONObject) {
        SelectItem selectItem = new SelectItem(com.frame.v0.g());
        selectItem.setLabel(jSONObject.optString("key"));
        selectItem.setItems(jSONObject.optString("items").split("@@"));
        selectItem.setSelectLabel(jSONObject.optString("value"));
        return selectItem;
    }

    private View g(JSONObject jSONObject) {
        InputItem inputItem = new InputItem(com.frame.v0.g());
        inputItem.setLabel(jSONObject.optString("key"));
        inputItem.setValue(i.b.da.B().G(jSONObject.optString("value")));
        inputItem.setInputType(1);
        return inputItem;
    }

    private String getRememberKey() {
        return "alertLastValue:" + this.d.getId() + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.e.id;
    }

    private void i() throws JSONException {
        if ("1".equals(this.e.arg2)) {
            String strF = com.frame.n0.f(getRememberKey(), "");
            if (TextUtils.isEmpty(strF)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(strF);
            for (int i2 = 0; i2 < this.f.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = this.f.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i3);
                        if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject.optString("key").equals(jSONObjectOptJSONObject2.optString("key")) && jSONObjectOptJSONObject.optString("option").equals(jSONObjectOptJSONObject2.optString("option")) && jSONObjectOptJSONObject2.has("value")) {
                            jSONObjectOptJSONObject.put("value", jSONObjectOptJSONObject2.opt("value"));
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
    }

    public void h() {
        for (int i2 = 0; i2 < this.f.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = this.f.optJSONObject(i2);
            String strOptString = jSONObjectOptJSONObject.optString("option");
            if ("数字".equals(strOptString)) {
                this.c.addView(d(jSONObjectOptJSONObject));
            } else if ("文字".equals(strOptString)) {
                this.c.addView(g(jSONObjectOptJSONObject));
            } else if ("多选".equals(strOptString)) {
                this.c.addView(c(jSONObjectOptJSONObject));
            } else if ("单选".equals(strOptString)) {
                this.c.addView(f(jSONObjectOptJSONObject));
            } else if ("区域".equals(strOptString)) {
                this.c.addView(a(jSONObjectOptJSONObject));
            } else if ("坐标".equals(strOptString)) {
                this.c.addView(e(jSONObjectOptJSONObject));
            } else if ("文件路径".equals(strOptString)) {
                this.c.addView(b(jSONObjectOptJSONObject));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        if (view.getId() == j.b.e.A) {
            com.frame.s0.g().o(this);
            View.OnClickListener onClickListener = this.f902h;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                return;
            }
            return;
        }
        if (view.getId() == j.b.e.B) {
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                try {
                    JSONObject jSONObject = this.f.getJSONObject(i2);
                    BaseItemView baseItemView = (BaseItemView) this.c.getChildAt(i2);
                    if (baseItemView instanceof SelectItem) {
                        jSONObject.put("value", ((SelectItem) baseItemView).getSelectLabel());
                    } else if (baseItemView instanceof AreaChooseItem) {
                        jSONObject.put("value", Node.getStringByRect((Rect) baseItemView.getValue()));
                    } else if (baseItemView instanceof CoordItem) {
                        jSONObject.put("value", Node.getStringByPoint((Point) baseItemView.getValue()));
                    } else if (baseItemView.getValue() != null) {
                        jSONObject.put("value", baseItemView.getValue().toString());
                    }
                    i.b.da.B().E1(jSONObject.optString("key"), jSONObject.optString("value"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            if ("1".equals(this.e.arg2)) {
                com.frame.n0.k(getRememberKey(), this.f.toString());
            }
            com.frame.s0.g().o(this);
            this.g.onClick(view);
        }
    }

    public void setJsonArray(JSONArray jSONArray) {
    }

    public void setOnContinueListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void setOnStopListener(View.OnClickListener onClickListener) {
        this.f902h = onClickListener;
    }

    public void setTask(Task task, Node node) {
        this.d = task;
        this.e = node;
        try {
            this.f = new JSONArray(node.arg1);
            i();
            h();
            TextView textView = (TextView) findViewById(j.b.e.e6);
            textView.setVisibility(0);
            textView.setText(i.b.da.B().G(node.text));
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public AlertOptionSetDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlertOptionSetDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public AlertOptionSetDialogView() {
        super(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.f1760k, this);
        this.c = (LinearLayout) findViewById(j.b.e.T3);
        ((TextView) findViewById(j.b.e.w6)).setText("弹窗确认");
        TextView textView = (TextView) findViewById(j.b.e.A);
        textView.setOnClickListener(this);
        textView.setText("停止执行");
        textView.setTextColor(-10066330);
        TextView textView2 = (TextView) findViewById(j.b.e.B);
        textView2.setOnClickListener(this);
        textView2.setText("继续执行");
    }
}
