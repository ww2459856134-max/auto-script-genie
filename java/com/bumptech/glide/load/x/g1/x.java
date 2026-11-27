package com.bumptech.glide.load.x.g1;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class x implements s {
    private static final Bitmap.Config[] d;
    private static final Bitmap.Config[] e;
    private static final Bitmap.Config[] f;
    private static final Bitmap.Config[] g;

    /* renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f608h;
    private final w a = new w();
    private final k<v, Bitmap> b = new k<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        d = configArr;
        e = configArr;
        f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f608h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void g(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapK = k(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapK.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapK.remove(num);
                return;
            } else {
                navigableMapK.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
    }

    private v h(int i2, Bitmap.Config config) {
        v vVarE = this.a.e(i2, config);
        for (Bitmap.Config config2 : j(config)) {
            Integer numCeilingKey = k(config2).ceilingKey(Integer.valueOf(i2));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i2 * 8) {
                if (numCeilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return vVarE;
                        }
                    } else if (config2.equals(config)) {
                        return vVarE;
                    }
                }
                this.a.c(vVarE);
                return this.a.e(numCeilingKey.intValue(), config2);
            }
        }
        return vVarE;
    }

    static String i(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    private static Bitmap.Config[] j(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return e;
        }
        int i2 = u.a[config.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new Bitmap.Config[]{config} : f608h : g : f : d;
    }

    private NavigableMap<Integer, Integer> k(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public String a(int i2, int i3, Bitmap.Config config) {
        return i(com.bumptech.glide.b0.p.f(i2, i3, config), config);
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.b0.p.g(bitmap);
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public void c(Bitmap bitmap) {
        v vVarE = this.a.e(com.bumptech.glide.b0.p.g(bitmap), bitmap.getConfig());
        this.b.d(vVarE, bitmap);
        NavigableMap<Integer, Integer> navigableMapK = k(bitmap.getConfig());
        Integer num = (Integer) navigableMapK.get(Integer.valueOf(vVarE.b));
        navigableMapK.put(Integer.valueOf(vVarE.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        v vVarH = h(com.bumptech.glide.b0.p.f(i2, i3, config), config);
        Bitmap bitmapA = this.b.a(vVarH);
        if (bitmapA != null) {
            g(Integer.valueOf(vVarH.b), bitmapA);
            bitmapA.reconfigure(i2, i3, config);
        }
        return bitmapA;
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public String e(Bitmap bitmap) {
        return i(com.bumptech.glide.b0.p.g(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public Bitmap f() {
        Bitmap bitmapF = this.b.f();
        if (bitmapF != null) {
            g(Integer.valueOf(com.bumptech.glide.b0.p.g(bitmapF)), bitmapF);
        }
        return bitmapF;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
