package com.yl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class ImageBox {
    public long id;
    public String name;
    public List<String> urls = new ArrayList();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageBox) && this.id == ((ImageBox) obj).id;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id));
    }
}
