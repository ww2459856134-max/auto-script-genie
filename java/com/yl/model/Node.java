package com.yl.model;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.frame.k0;
import com.frame.q1;
import com.frame.y0;
import com.tencent.open.SocialConstants;
import com.v.FloatToast;
import i.b.da;
import i.b.o8;
import i.b.v8;
import i.b.x7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import o.a.f;
import org.apache.xmlbeans.XmlErrorCodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Node implements MultiItemEntity {
    public static final int TYPE_AI = 36;
    public static final int TYPE_ALERT = 41;
    public static final int TYPE_API = 25;
    public static final int TYPE_CHECK_LOGIN = 43;
    public static final int TYPE_CLICK = 1;
    public static final int TYPE_CLICK_BACK = 6;
    public static final int TYPE_CLICK_HOME = 5;
    public static final int TYPE_CLICK_RECENT = 7;
    public static final int TYPE_CLOSE_APP = 30;
    public static final int TYPE_DELAY = 21;
    public static final int TYPE_EXCEL_READ = 38;
    public static final int TYPE_EXCEL_WRITE = 39;
    public static final int TYPE_GESTURE = 2;
    public static final int TYPE_GESTURE_LENGTH_SCROLL = 27;
    public static final int TYPE_GESTURE_MULTI = 26;
    public static final int TYPE_GRID_CLICK = 18;
    public static final int TYPE_GROUP = 0;
    public static final int TYPE_JUMP = 15;
    public static final int TYPE_JUMP_APP_DETAIL = 40;
    public static final int TYPE_LAUNCH = 8;
    public static final int TYPE_LOCK = 9;
    public static final int TYPE_MULTI_CLICK = 11;
    public static final int TYPE_MULTI_LOGIC = 23;
    public static final int TYPE_MULTI_LOGIC_JUMP = 34;
    public static final int TYPE_NOTIFICATION = 29;
    public static final int TYPE_OCR = 31;
    public static final int TYPE_PARAMS = 24;
    public static final int TYPE_PASTE = 37;
    public static final int TYPE_RANDOM_CLICK = 17;
    public static final int TYPE_RESTART_APP = 35;
    public static final int TYPE_SCAN_COLOR = 13;
    public static final int TYPE_SCAN_IMG = 3;
    public static final int TYPE_SCAN_MULTI_IMG = 22;
    public static final int TYPE_SCAN_NO_COLOR = 38;
    public static final int TYPE_SCAN_NO_IMG = 37;
    public static final int TYPE_SCAN_NO_MULTI_IMG = 40;
    public static final int TYPE_SCAN_NO_TEXT = 36;
    public static final int TYPE_SCAN_NO_WIDGET = 39;
    public static final int TYPE_SCAN_PAGE = 14;
    public static final int TYPE_SCAN_TEXT = 4;
    public static final int TYPE_SCAN_WIDGET = 19;
    public static final int TYPE_SCREEN_CAPTURE = 12;
    public static final int TYPE_SCROLL_PAGE = 16;
    public static final int TYPE_SEND_FILE = 45;
    public static final int TYPE_SOUND = 20;
    public static final int TYPE_SUB_ALERT_ERROR = -2;
    public static final int TYPE_SUB_AREA_PUT_PARAM = 17;
    public static final int TYPE_SUB_BRANCH = 6;
    public static final int TYPE_SUB_CLICK = 0;
    public static final int TYPE_SUB_CLICK_AFTER_JUMP_NODE = 13;
    public static final int TYPE_SUB_CLICK_AFTER_JUMP_TASK = 12;
    public static final int TYPE_SUB_CLICK_NEAR = 7;
    public static final int TYPE_SUB_CLICK_RANDOM = 10;
    public static final int TYPE_SUB_COORD_PUT_PARAM = 11;
    public static final int TYPE_SUB_COPY_TEXT = 8;
    public static final int TYPE_SUB_DRAG = 1;
    public static final int TYPE_SUB_FINISH_CURRENT_TASK = -4;
    public static final int TYPE_SUB_FINISH_TASK = -3;
    public static final int TYPE_SUB_IMG_COUNT = 15;
    public static final int TYPE_SUB_JUMP_NODE = 3;
    public static final int TYPE_SUB_JUMP_TASK = 4;
    public static final int TYPE_SUB_LIANLIANKAN = 14;
    public static final int TYPE_SUB_LONG_CLICK = 5;
    public static final int TYPE_SUB_MULTI_CLICK = 16;
    public static final int TYPE_SUB_NEXT = 2;
    public static final int TYPE_SUB_PUT_PARAM = 9;
    public static final int TYPE_TEXT_CAPTURE = 44;
    public static final int TYPE_TEXT_INPUT = 10;
    public static final int TYPE_TOAST = 29;
    public static final int TYPE_URL = 32;
    public static final int TYPE_VERSION = 33;
    public static final int TYPE_WATER_MARK = 42;
    public static final int TYPE_WX_APP = 28;
    public static final int WHAT_PARAMS_CLEAR = 8;
    public static final int WHAT_PARAMS_EXPRESSION = 7;
    public static final int WHAT_PARAMS_INIT = 1;
    public static final int WHAT_PARAMS_JUDGE = 6;
    public static final int WHAT_PARAMS_OPERATION = 5;
    public static final int WHAT_PARAMS_PUT_CLIP = 2;
    public static final int WHAT_PARAMS_SPLIT = 4;
    public static final int WHAT_PARAMS_WRITE_FILE = 3;
    public static final int WHAT_PARAM_RESET = 9;
    private Rect area;
    public String areaParam;
    private transient boolean areaResolveError;
    private transient String areaResolveErrorMessage;
    public String areaS;
    public String arg1;
    public String arg2;
    public String arg3;
    public String arg4;
    public String arg5;
    public String arg6;
    public int argInt1;
    private Long checkCount;
    private Long checkDelay;
    private Node condition;
    public String delay;
    public long duration;
    public String errorDelay;
    public long errorId;
    public String errorMaxDelay;
    public Object extra;
    public long frontId;
    public long id;
    public boolean invalid;
    public String maxDelay;
    public long maxDuration;
    public String name;
    public String nextDelay;
    public long nextId;
    public String nextMaxDelay;
    public long nextTaskId;
    public long nextTaskNodeId;
    public String ocrEngine;
    public ArrayList<Integer> pathPoints;
    public ArrayList<GesturePath> paths;
    private Point point;
    private String pointS;
    public int repeatCount;
    private Rect srcRect;
    private transient boolean srcRectResolveError;
    private transient String srcRectResolveErrorMessage;
    public String srcRectS;
    public String step;
    public String text;
    public Boolean textInputPackageMatch;
    public long timeOut;
    public int type;
    public String url;
    public int what;
    public int whatIndex;
    public boolean jumpBack = true;
    public boolean successJumpBack = true;
    public int nextType = -1;
    public int errorType = -1;

    private String buildRectResolveError(String str, String str2) {
        String strG;
        try {
            strG = da.B().G(str2);
        } catch (Exception unused) {
            strG = null;
        }
        if (TextUtils.isEmpty(strG)) {
            return str + "错误：" + str2 + " 未赋值";
        }
        if (strG.contains("${") && strG.contains("}")) {
            return str + "错误：" + str2 + " 未赋值，当前值：" + strG;
        }
        return str + "错误：" + str2 + "，当前值：" + strG + "，应为x,y-x1,y1";
    }

    public static Point getPointByString(String str) {
        Point point = new Point();
        point.x = Integer.valueOf(str.split(",")[0]).intValue();
        point.y = Integer.valueOf(str.split(",")[1]).intValue();
        return point;
    }

    public static Rect getRectByString(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("区域为空");
        }
        int iIndexOf = str.indexOf(ProcessIdUtil.DEFAULT_PROCESSID, str.indexOf(",") + 2);
        if (iIndexOf <= 0 || iIndexOf >= str.length() - 1) {
            throw new IllegalArgumentException("区域格式错误：" + str);
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        String[] strArrSplit = strSubstring.split(",");
        String[] strArrSplit2 = strSubstring2.split(",");
        if (strArrSplit.length == 2 && strArrSplit2.length == 2) {
            return new Rect(Integer.valueOf(strArrSplit[0]).intValue(), Integer.valueOf(strArrSplit[1]).intValue(), Integer.valueOf(strArrSplit2[0]).intValue(), Integer.valueOf(strArrSplit2[1]).intValue());
        }
        throw new IllegalArgumentException("区域格式错误：" + str);
    }

    public static String getStringByPoint(Point point) {
        return point.x + "," + point.y;
    }

    public static String getStringByRect(Rect rect) {
        return rect.left + "," + rect.top + ProcessIdUtil.DEFAULT_PROCESSID + rect.right + "," + rect.bottom;
    }

    private Rect parseAreaRect(String str, String str2) {
        try {
            String strG = da.B().G(str);
            Rect rectByString = getRectByString(strG);
            if (rectByString.width() > 0 && rectByString.height() > 0) {
                return rectByString;
            }
            throw new IllegalArgumentException("区域宽高必须大于0：" + strG);
        } catch (Exception unused) {
            this.areaResolveError = true;
            String strBuildRectResolveError = buildRectResolveError(str2, str);
            this.areaResolveErrorMessage = strBuildRectResolveError;
            y0.j(strBuildRectResolveError);
            FloatToast.i(this.areaResolveErrorMessage);
            return null;
        }
    }

    private Rect parseSrcRect(String str, String str2) {
        try {
            String strG = da.B().G(str);
            Rect rectByString = getRectByString(strG);
            if (rectByString.width() > 0 && rectByString.height() > 0) {
                return rectByString;
            }
            throw new IllegalArgumentException("区域宽高必须大于0：" + strG);
        } catch (Exception unused) {
            this.srcRectResolveError = true;
            String strBuildRectResolveError = buildRectResolveError(str2, str);
            this.srcRectResolveErrorMessage = strBuildRectResolveError;
            y0.j(strBuildRectResolveError);
            FloatToast.i(this.srcRectResolveErrorMessage);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Node) && this.id == ((Node) obj).id;
    }

    public Rect getArea() {
        Rect rect;
        this.areaResolveError = false;
        this.areaResolveErrorMessage = null;
        if (TextUtils.isEmpty(this.areaS) && (rect = this.area) != null) {
            return rect;
        }
        if (TextUtils.isEmpty(this.areaS)) {
            return null;
        }
        return parseAreaRect(this.areaS, "识别区域");
    }

    public Rect getAreaOrParam() {
        this.areaResolveError = false;
        this.areaResolveErrorMessage = null;
        return !TextUtils.isEmpty(this.areaParam) ? parseAreaRect(this.areaParam, "识别区域变量") : getArea();
    }

    public String getAreaResolveErrorMessage() {
        return this.areaResolveErrorMessage;
    }

    public Long getCheckCount() {
        return this.checkCount;
    }

    public Long getCheckDelay() {
        return this.checkDelay;
    }

    public Node getCompatibility() {
        int i2 = this.type;
        if (i2 == 3) {
            if (this.srcRect == null && this.what == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(this.extra.toString());
                    this.timeOut = jSONObject.optLong("timeout");
                    this.what = jSONObject.optInt("similarity");
                } catch (Exception e) {
                    k0.r(e);
                }
            }
        } else if (i2 == 4 && this.arg2 == null && this.arg1 == null && this.text == null && this.extra != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.extra.toString());
                this.text = jSONObject2.optString("text");
                this.arg1 = jSONObject2.optString("path");
                this.arg2 = jSONObject2.optBoolean("needScrollFind") ? "1" : "0";
                if (this.timeOut == 0) {
                    this.timeOut = jSONObject2.optLong("timeout");
                }
            } catch (JSONException e2) {
                k0.r(e2);
            }
        }
        return this;
    }

    public Node getCondition() {
        return this.condition;
    }

    public long getDelay() {
        try {
            return o8.i(this.delay, this.maxDelay);
        } catch (Exception unused) {
            return 1L;
        }
    }

    public long getDuration() {
        try {
            return this.maxDuration == 0 ? this.duration : q1.m((int) this.duration, (int) r0);
        } catch (Exception unused) {
            return 1L;
        }
    }

    public long getErrorDelay() {
        try {
            return o8.i(this.errorDelay, this.errorMaxDelay);
        } catch (Exception unused) {
            return 1L;
        }
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public long getJumpNodeId() {
        long j2 = this.nextTaskId;
        return j2 == 0 ? this.nextId : j2;
    }

    public String getName() {
        return !TextUtils.isEmpty(this.name) ? this.name : x7.d().e(this.type).t();
    }

    public long getNextDelay() {
        try {
            return o8.i(this.nextDelay, this.nextMaxDelay);
        } catch (Exception unused) {
            return 1L;
        }
    }

    public Node getNextNodeAtIndex(Task task) {
        try {
            ArrayList<Node> arrayList = new ArrayList(task.getNodeMap().values());
            int iIndexOf = arrayList.indexOf(this);
            if (iIndexOf >= 0 && iIndexOf < arrayList.size() - 1) {
                return (Node) arrayList.get(iIndexOf + 1);
            }
            for (Node node : arrayList) {
                if (node.frontId == this.id) {
                    return node;
                }
            }
            return null;
        } catch (Exception e) {
            y0.l(e);
            return null;
        }
    }

    public Point getPoint() {
        if (!TextUtils.isEmpty(this.pointS)) {
            return getPointByString(this.pointS);
        }
        Point point = this.point;
        if (point != null) {
            return point;
        }
        return null;
    }

    public ArrayList<Integer> getRandomPoint(Rect rect) {
        int iA = f.a(rect.top, rect.bottom);
        int iA2 = f.a(rect.left, rect.right);
        this.pathPoints.clear();
        this.pathPoints.add(Integer.valueOf(iA2));
        this.pathPoints.add(Integer.valueOf(iA));
        return this.pathPoints;
    }

    public Rect getSrcRect() {
        this.srcRectResolveError = false;
        this.srcRectResolveErrorMessage = null;
        if (!TextUtils.isEmpty(this.srcRectS)) {
            return parseSrcRect(this.srcRectS, "原始识别区域");
        }
        Rect rect = this.srcRect;
        if (rect != null) {
            return rect;
        }
        return null;
    }

    public String getSrcRectResolveErrorMessage() {
        return this.srcRectResolveErrorMessage;
    }

    public String getStepAndName() {
        return this.step + "." + getName();
    }

    public boolean hasAreaResolveError() {
        return this.areaResolveError;
    }

    public boolean hasSrcRectResolveError() {
        return this.srcRectResolveError;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id));
    }

    public boolean isHashJumpNodeType() {
        int i2 = this.nextType;
        return i2 == 3 || i2 == 13;
    }

    public boolean isHashJumpNodeType(int i2) {
        return i2 == 3 || i2 == 13;
    }

    public boolean isHashJumpTaskType(int i2) {
        return i2 == 4 || i2 == 12;
    }

    public boolean isJumOtherType() {
        int i2 = this.nextType;
        return i2 == 3 || i2 == 4 || i2 == 13 || i2 == 12;
    }

    public boolean isJumOtherType(int i2) {
        return i2 == 3 || i2 == 4 || i2 == 13 || i2 == 12;
    }

    public boolean isJumOtherTypeWithoutJumpTask() {
        return this.nextType == 3;
    }

    public boolean isTextInputPackageMatchEnabled() {
        return !Boolean.FALSE.equals(this.textInputPackageMatch);
    }

    public void lineNextNodeAtIndex(Task task) {
        Node nextNodeAtIndex = getNextNodeAtIndex(task);
        if (nextNodeAtIndex != null) {
            v8.m().K(this, nextNodeAtIndex);
        } else {
            this.nextId = 0L;
        }
    }

    public void setAreaNew(Rect rect) {
        if (rect != null) {
            this.areaS = rect.left + "," + rect.top + ProcessIdUtil.DEFAULT_PROCESSID + rect.right + "," + rect.bottom;
        } else {
            this.areaS = null;
        }
        this.area = null;
    }

    public void setCheckCount(Long l2) {
        this.checkCount = l2;
    }

    public void setCheckDelay(Long l2) {
        this.checkDelay = l2;
    }

    public void setCondition(Node node) {
        this.condition = node;
    }

    public void setPointNew(Point point) {
        if (point != null) {
            this.pointS = point.x + "," + point.y;
        } else {
            this.pointS = null;
        }
        this.point = null;
    }

    public void setSrcRectNew(Rect rect) {
        if (rect == null) {
            this.srcRectS = null;
            return;
        }
        this.srcRectS = rect.left + "," + rect.top + ProcessIdUtil.DEFAULT_PROCESSID + rect.right + "," + rect.bottom;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SocialConstants.PARAM_TYPE, this.type);
        jSONObject.put("id", this.id);
        jSONObject.put("arg4", this.arg4);
        jSONObject.put("arg1", this.arg1);
        jSONObject.put("arg2", this.arg2);
        jSONObject.put("arg3", this.arg3);
        jSONObject.put("errorType", this.errorType);
        jSONObject.put("arg5", this.arg5);
        jSONObject.put("arg6", this.arg6);
        jSONObject.put("ocrEngine", this.ocrEngine);
        jSONObject.put("text", this.text);
        jSONObject.put("areaParam", this.areaParam);
        jSONObject.put("errorId", this.errorId);
        jSONObject.put("step", this.step);
        jSONObject.put("argInt1", this.argInt1);
        jSONObject.put("delay", this.delay);
        jSONObject.put("nextDelay", this.nextDelay);
        jSONObject.put(XmlErrorCodes.DURATION, this.duration);
        jSONObject.put("nextTaskId", this.nextTaskId);
        jSONObject.put("maxDelay", this.maxDelay);
        jSONObject.put("maxDuration", this.maxDuration);
        jSONObject.put("errorMaxDelay", this.errorMaxDelay);
        jSONObject.put("frontId", this.frontId);
        jSONObject.put("invalid", this.invalid);
        jSONObject.put("nextId", this.nextId);
        jSONObject.put("nextTaskNodeId", this.nextTaskNodeId);
        jSONObject.put("nextMaxDelay", this.nextMaxDelay);
        jSONObject.put("jumpBack", this.jumpBack);
        jSONObject.put("successJumpBack", this.successJumpBack);
        jSONObject.put(SocialConstants.PARAM_URL, this.url);
        jSONObject.put("textInputPackageMatch", this.textInputPackageMatch);
        jSONObject.put("extra", this.extra);
        jSONObject.put("name", this.name);
        jSONObject.put("nextType", this.nextType);
        jSONObject.put("repeatCount", this.repeatCount);
        jSONObject.put("timeOut", this.timeOut);
        jSONObject.put("errorDelay", this.errorDelay);
        jSONObject.put("whatIndex", this.whatIndex);
        jSONObject.put("what", this.what);
        jSONObject.put("checkCount", this.checkCount);
        jSONObject.put("checkDelay", this.checkDelay);
        Node node = this.condition;
        if (node != null) {
            jSONObject.put("condition", node.toJson());
        }
        if (this.point != null && TextUtils.isEmpty(this.pointS)) {
            setPointNew(this.point);
        }
        if (this.srcRect != null && TextUtils.isEmpty(this.srcRectS)) {
            setSrcRectNew(this.srcRect);
        }
        if (this.area != null && TextUtils.isEmpty(this.areaS)) {
            setAreaNew(this.area);
        }
        jSONObject.put("areaS", this.areaS);
        jSONObject.put("srcRectS", this.srcRectS);
        jSONObject.put("pointS", this.pointS);
        if (this.paths != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<GesturePath> it = this.paths.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            jSONObject.put("paths", jSONArray);
        }
        if (this.pathPoints != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<Integer> it2 = this.pathPoints.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("pathPoints", jSONArray2);
        }
        return jSONObject;
    }
}
