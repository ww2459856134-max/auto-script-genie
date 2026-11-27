package com.jsj.autojs.model;

import com.chad.library.adapter.base.entity.SectionEntity;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Video extends SectionEntity<JSONObject> {
    private Long id;
    private String label;
    private String subTitle;
    private Long url;

    public Video(boolean z, String str) {
        super(z, str);
    }
}
