package com.yl.model;

import i.b.da;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Task {
    private boolean actCode;
    private String argumentJson;
    private boolean canBackup;
    private boolean canNotShare;
    private Long cloudScriptId;
    private Long createUserId;
    private long firstNodeId;
    private String group;
    private long id;
    private boolean isNeedScan;
    private long lastNodeId;
    private Long limitTime;
    private Long limitUserId;
    private String name;
    private long nextTaskId;
    public LinkedHashMap<Long, Node> nodeMap;
    private transient da.a onTaskRunStateListener;
    public Set<String> params;
    private String pn;
    private String pwd;
    private int repeatCount;
    private long repeatDelay;
    private long repeatFinishJumpTaskId;
    private int screenHeight;
    private float screenScale;
    private int screenWith;
    private boolean showBar = true;
    private boolean showToast = true;
    public long updateTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Task) && this.id == ((Task) obj).id;
    }

    public String getArgumentJson() {
        return this.argumentJson;
    }

    public Long getCloudScriptId() {
        return this.cloudScriptId;
    }

    public Long getCreateUserId() {
        return this.createUserId;
    }

    public long getFirstNodeId() {
        return this.firstNodeId;
    }

    public String getGroup() {
        return this.group;
    }

    public long getId() {
        return this.id;
    }

    public long getLastNodeId() {
        return this.lastNodeId;
    }

    public Long getLimitTime() {
        return this.limitTime;
    }

    public Long getLimitUserId() {
        return this.limitUserId;
    }

    public String getName() {
        return this.name;
    }

    public long getNextTaskId() {
        return this.nextTaskId;
    }

    public LinkedHashMap<Long, Node> getNodeMap() {
        return this.nodeMap;
    }

    public da.a getOnTaskRunStateListener() {
        return this.onTaskRunStateListener;
    }

    public String getPn() {
        return this.pn;
    }

    public String getPwd() {
        return this.pwd;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public long getRepeatDelay() {
        return this.repeatDelay;
    }

    public long getRepeatFinishJumpTaskId() {
        return this.repeatFinishJumpTaskId;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public float getScreenScale() {
        return this.screenScale;
    }

    public int getScreenWith() {
        return this.screenWith;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id));
    }

    public boolean isActCode() {
        return this.actCode;
    }

    public boolean isCanBackup() {
        return this.canBackup;
    }

    public boolean isCanNotShare() {
        return this.canNotShare;
    }

    public boolean isNeedScan() {
        return this.isNeedScan;
    }

    public boolean isShowBar() {
        return this.showBar;
    }

    public boolean isShowToast() {
        return this.showToast;
    }

    public void setActCode(boolean z) {
        this.actCode = z;
    }

    public void setArgumentJson(String str) {
        this.argumentJson = str;
    }

    public void setCanBackup(boolean z) {
        this.canBackup = z;
    }

    public void setCanNotShare(boolean z) {
        this.canNotShare = z;
    }

    public void setCloudScriptId(Long l2) {
        this.cloudScriptId = l2;
    }

    public void setCreateUserId(Long l2) {
        this.createUserId = l2;
    }

    public void setFirstNodeId(long j2) {
        this.firstNodeId = j2;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public void setId(long j2) {
        this.id = j2;
    }

    public void setLastNodeId(long j2) {
        this.lastNodeId = j2;
    }

    public void setLimitTime(Long l2) {
        this.limitTime = l2;
    }

    public void setLimitUserId(Long l2) {
        this.limitUserId = l2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeedScan(boolean z) {
        this.isNeedScan = z;
    }

    public void setNextTaskId(long j2) {
        this.nextTaskId = j2;
    }

    public void setNodeMap(LinkedHashMap<Long, Node> linkedHashMap) {
        this.nodeMap = linkedHashMap;
    }

    public void setOnTaskRunStateListener(da.a aVar) {
        this.onTaskRunStateListener = aVar;
    }

    public void setPn(String str) {
        this.pn = str;
    }

    public void setPwd(String str) {
        this.pwd = str;
    }

    public void setRepeatCount(int i2) {
        this.repeatCount = i2;
    }

    public void setRepeatDelay(long j2) {
        this.repeatDelay = j2;
    }

    public void setRepeatFinishJumpTaskId(long j2) {
        this.repeatFinishJumpTaskId = j2;
    }

    public void setScreenHeight(int i2) {
        this.screenHeight = i2;
    }

    public void setScreenScale(float f) {
        this.screenScale = f;
    }

    public void setScreenWith(int i2) {
        this.screenWith = i2;
    }

    public void setShowBar(boolean z) {
        this.showBar = z;
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("group", this.group);
        jSONObject.put("id", this.id);
        jSONObject.put("createUserId", this.createUserId);
        jSONObject.put("cloudScriptId", this.cloudScriptId);
        jSONObject.put("nextTaskId", this.nextTaskId);
        jSONObject.put("name", this.name);
        jSONObject.put("canBackup", this.canBackup);
        jSONObject.put("pwd", this.pwd);
        jSONObject.put("limitTime", this.limitTime);
        jSONObject.put("limitUserId", this.limitUserId);
        jSONObject.put("showBar", this.showBar);
        jSONObject.put("pn", this.pn);
        jSONObject.put("showToast", this.showToast);
        jSONObject.put("screenScale", this.screenScale);
        jSONObject.put("screenHeight", this.screenHeight);
        jSONObject.put("screenWith", this.screenWith);
        jSONObject.put("repeatFinishJumpTaskId", this.repeatFinishJumpTaskId);
        jSONObject.put("repeatCount", this.repeatCount);
        jSONObject.put("repeatDelay", this.repeatDelay);
        jSONObject.put("lastNodeId", this.lastNodeId);
        jSONObject.put("firstNodeId", this.firstNodeId);
        jSONObject.put("isNeedScan", this.isNeedScan);
        jSONObject.put("actCode", this.actCode);
        jSONObject.put("canNotShare", this.canNotShare);
        jSONObject.put("updateTime", this.updateTime);
        jSONObject.put("argumentJson", this.argumentJson);
        if (this.params != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.params.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("params", jSONArray);
        }
        if (this.nodeMap != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Long l2 : this.nodeMap.keySet()) {
                jSONObject2.put(l2 + "", this.nodeMap.get(l2).toJson());
            }
            jSONObject.put("nodeMap", jSONObject2);
        }
        return jSONObject;
    }
}
