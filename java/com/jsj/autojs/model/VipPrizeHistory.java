package com.jsj.autojs.model;

import java.util.List;

/* loaded from: classes.dex */
public class VipPrizeHistory {
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
        private int id;
        private String insertTime;
        private int uid;
        private String userHeader;
        private String userName;
        private long vipDuration;
        private int vipPrizeId;

        public int getId() {
            return this.id;
        }

        public String getInsertTime() {
            return this.insertTime;
        }

        public int getUid() {
            return this.uid;
        }

        public String getUserHeader() {
            return this.userHeader;
        }

        public String getUserName() {
            return this.userName;
        }

        public long getVipDuration() {
            return this.vipDuration;
        }

        public int getVipPrizeId() {
            return this.vipPrizeId;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setInsertTime(String str) {
            this.insertTime = str;
        }

        public void setUid(int i2) {
            this.uid = i2;
        }

        public void setUserHeader(String str) {
            this.userHeader = str;
        }

        public void setUserName(String str) {
            this.userName = str;
        }

        public void setVipDuration(long j2) {
            this.vipDuration = j2;
        }

        public void setVipPrizeId(int i2) {
            this.vipPrizeId = i2;
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
