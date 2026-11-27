package com.jsj.autojs.model;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class UserModel {
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
        private String headimgurl;
        private Long id;
        private String lastLoginTime;
        private String name;
        private String vipEndTime;
        private String vipStartTime;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ContentBean) {
                return this.id.equals(((ContentBean) obj).id);
            }
            return false;
        }

        public String getHeadimgurl() {
            return this.headimgurl;
        }

        public Long getId() {
            return this.id;
        }

        public String getLastLoginTime() {
            return this.lastLoginTime;
        }

        public String getName() {
            return this.name;
        }

        public String getVipEndTime() {
            return this.vipEndTime;
        }

        public String getVipStartTime() {
            return this.vipStartTime;
        }

        public int hashCode() {
            return Objects.hash(this.id);
        }

        public boolean isActive() {
            return !this.lastLoginTime.equals(this.vipStartTime);
        }

        public void setHeadimgurl(String str) {
            this.headimgurl = str;
        }

        public void setId(Long l2) {
            this.id = l2;
        }

        public void setLastLoginTime(String str) {
            this.lastLoginTime = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setVipEndTime(String str) {
            this.vipEndTime = str;
        }

        public void setVipStartTime(String str) {
            this.vipStartTime = str;
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
