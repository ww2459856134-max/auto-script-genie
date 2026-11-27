package com.yl.model;

/* loaded from: classes.dex */
public class WidgetFeature {
    public String className;
    public boolean classToggle;
    public String desc;
    public boolean descToggle;
    public int descType;
    public String height;
    public boolean heightToggle;
    public int heightType;
    public String id;
    public boolean idToggle;
    public Boolean packageToggle;
    public String path;
    public boolean pathToggle;
    public String text;
    public boolean textToggle;
    public int textType;
    public String width;
    public boolean widthToggle;
    public int widthType;

    public boolean isPackageMatchEnabled() {
        return !Boolean.FALSE.equals(this.packageToggle);
    }
}
