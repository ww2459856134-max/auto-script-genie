package com.jsj.autojs.model;

import java.util.List;

/* loaded from: classes.dex */
public class VipItemModel {
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
        private String content;
        private Long id;
        private String insertTime;
        private long money;
        private String packageName;
        private long scrMoney;
        public boolean select;
        private String tag;
        private long timeDuration;
        private String title;
        private int valid;

        public String getContent() {
            return this.content;
        }

        public Long getId() {
            return this.id;
        }

        public String getInsertTime() {
            return this.insertTime;
        }

        public long getMoney() {
            return this.money;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public long getScrMoney() {
            return this.scrMoney;
        }

        public String getTag() {
            return this.tag;
        }

        public long getTimeDuration() {
            return this.timeDuration;
        }

        public String getTitle() {
            return this.title;
        }

        public int getValid() {
            return this.valid;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setId(Long l2) {
            this.id = l2;
        }

        public void setInsertTime(String str) {
            this.insertTime = str;
        }

        public void setMoney(long j2) {
            this.money = j2;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setScrMoney(int i2) {
            this.scrMoney = i2;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTimeDuration(long j2) {
            this.timeDuration = j2;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setValid(int i2) {
            this.valid = i2;
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
