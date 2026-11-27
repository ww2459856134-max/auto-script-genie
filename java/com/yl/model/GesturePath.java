package com.yl.model;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.xmlbeans.XmlErrorCodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GesturePath {
    public long duration;
    public ArrayList<Integer> points = new ArrayList<>();
    public long startTime;

    public boolean isEmpty() {
        ArrayList<Integer> arrayList = this.points;
        return arrayList == null || arrayList.isEmpty();
    }

    public void lineTo(float f, float f2) {
        this.points.add(Integer.valueOf((int) f));
        this.points.add(Integer.valueOf((int) f2));
    }

    public void moveTo(float f, float f2) {
        this.points.add(Integer.valueOf((int) f));
        this.points.add(Integer.valueOf((int) f2));
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startTime", this.startTime);
        jSONObject.put(XmlErrorCodes.DURATION, this.duration);
        jSONObject.put(XmlErrorCodes.DURATION, this.duration);
        if (this.points != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = this.points.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("points", jSONArray);
        }
        return jSONObject;
    }
}
