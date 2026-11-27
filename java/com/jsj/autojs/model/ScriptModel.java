package com.jsj.autojs.model;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class ScriptModel {
    private List<ContentBean> content;
    private boolean first;
    private boolean last;
    private int number;
    private int numberOfElements;
    private int size;
    private SortBean sort;
    private int totalElements;
    private int totalPages;

    public static class ContentBean {
        private Long downloadCount;
        private Long fileSize;
        private Long id;
        private String insertTime;
        private String lastDownloadTime;
        private String path;
        private String scriptId;
        private String scriptName;
        private String shareUserName;
        private String updateTime;
        private String updateUserName;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ContentBean) {
                return this.id.equals(((ContentBean) obj).id);
            }
            return false;
        }

        public Long getDownloadCount() {
            return this.downloadCount;
        }

        public Long getFileSize() {
            return this.fileSize;
        }

        public Long getId() {
            return this.id;
        }

        public String getInsertTime() {
            return this.insertTime;
        }

        public String getLastDownloadTime() {
            return this.lastDownloadTime;
        }

        public String getPath() {
            return this.path;
        }

        public String getScriptId() {
            return this.scriptId;
        }

        public String getScriptName() {
            return this.scriptName;
        }

        public String getShareUserName() {
            return this.shareUserName;
        }

        public String getUpdateTime() {
            return this.updateTime;
        }

        public String getUpdateUserName() {
            return this.updateUserName;
        }

        public int hashCode() {
            return Objects.hash(this.id);
        }

        public void setDownloadCount(Long l2) {
            this.downloadCount = l2;
        }

        public void setFileSize(Long l2) {
            this.fileSize = l2;
        }

        public void setId(Long l2) {
            this.id = l2;
        }

        public void setInsertTime(String str) {
            this.insertTime = str;
        }

        public void setLastDownloadTime(String str) {
            this.lastDownloadTime = str;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public void setScriptId(String str) {
            this.scriptId = str;
        }

        public void setScriptName(String str) {
            this.scriptName = str;
        }

        public void setShareUserName(String str) {
            this.shareUserName = str;
        }

        public void setUpdateTime(String str) {
            this.updateTime = str;
        }

        public void setUpdateUserName(String str) {
            this.updateUserName = str;
        }
    }

    public static class SortBean {
        private boolean sorted;
        private boolean unsorted;

        public boolean isSorted() {
            return this.sorted;
        }

        public boolean isUnsorted() {
            return this.unsorted;
        }

        public void setSorted(boolean z) {
            this.sorted = z;
        }

        public void setUnsorted(boolean z) {
            this.unsorted = z;
        }
    }

    public List<ContentBean> getContent() {
        return this.content;
    }

    public int getNumber() {
        return this.number;
    }

    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    public int getSize() {
        return this.size;
    }

    public SortBean getSort() {
        return this.sort;
    }

    public int getTotalElements() {
        return this.totalElements;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public boolean isFirst() {
        return this.first;
    }

    public boolean isLast() {
        return this.last;
    }

    public void setContent(List<ContentBean> list) {
        this.content = list;
    }

    public void setFirst(boolean z) {
        this.first = z;
    }

    public void setLast(boolean z) {
        this.last = z;
    }

    public void setNumber(int i2) {
        this.number = i2;
    }

    public void setNumberOfElements(int i2) {
        this.numberOfElements = i2;
    }

    public void setSize(int i2) {
        this.size = i2;
    }

    public void setSort(SortBean sortBean) {
        this.sort = sortBean;
    }

    public void setTotalElements(int i2) {
        this.totalElements = i2;
    }

    public void setTotalPages(int i2) {
        this.totalPages = i2;
    }
}
