package com.yl.model;

import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class TaskSimple implements MultiItemEntity, IExpandable {
    private transient List<TaskSimple> children;
    private long defaultTaskId;
    private long deletedAt;
    private String group;
    private long id;
    private boolean isExpanded;
    private int level;
    private String name;
    private String pn;
    private int repeatCount;
    private long repeatDelay;
    private long repeatFinishJumpTaskId;
    public long updateTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TaskSimple) && this.id == ((TaskSimple) obj).id;
    }

    public List<TaskSimple> getChildren() {
        return this.children;
    }

    public long getDefaultTaskId() {
        return this.defaultTaskId;
    }

    public long getDeletedAt() {
        return this.deletedAt;
    }

    public String getGroup() {
        return this.group;
    }

    public long getId() {
        return this.id;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return "group".equals(this.pn) ? 1 : 2;
    }

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public String getPn() {
        return this.pn;
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

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public List getSubItems() {
        return this.children;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id));
    }

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setChildren(List<TaskSimple> list) {
        this.children = list;
    }

    public void setDefaultTaskId(long j2) {
        this.defaultTaskId = j2;
    }

    public void setDeletedAt(long j2) {
        this.deletedAt = j2;
    }

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public void setId(long j2) {
        this.id = j2;
    }

    public void setLevel(int i2) {
        this.level = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPn(String str) {
        this.pn = str;
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
}
