package com.google.gson;

import com.auto.exceldeps.log4j.util.Chars;
import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class j implements k {
    public static final j c;
    public static final j d;
    public static final j e;
    public static final j f;
    public static final j g;

    /* renamed from: h, reason: collision with root package name */
    public static final j f756h;

    /* renamed from: i, reason: collision with root package name */
    public static final j f757i;

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ j[] f758j;

    static {
        c cVar = new c("IDENTITY", 0);
        c = cVar;
        final String str = "UPPER_CAMEL_CASE";
        final int i2 = 1;
        j jVar = new j(str, i2) { // from class: com.google.gson.d
            {
                c cVar2 = null;
            }

            @Override // com.google.gson.k
            public String a(Field field) {
                return j.c(field.getName());
            }
        };
        d = jVar;
        final String str2 = "UPPER_CAMEL_CASE_WITH_SPACES";
        final int i3 = 2;
        j jVar2 = new j(str2, i3) { // from class: com.google.gson.e
            {
                c cVar2 = null;
            }

            @Override // com.google.gson.k
            public String a(Field field) {
                return j.c(j.b(field.getName(), Chars.SPACE));
            }
        };
        e = jVar2;
        final String str3 = "UPPER_CASE_WITH_UNDERSCORES";
        final int i4 = 3;
        j jVar3 = new j(str3, i4) { // from class: com.google.gson.f
            {
                c cVar2 = null;
            }

            @Override // com.google.gson.k
            public String a(Field field) {
                return j.b(field.getName(), NameUtil.USCORE).toUpperCase(Locale.ENGLISH);
            }
        };
        f = jVar3;
        final String str4 = "LOWER_CASE_WITH_UNDERSCORES";
        final int i5 = 4;
        j jVar4 = new j(str4, i5) { // from class: com.google.gson.g
            {
                c cVar2 = null;
            }

            @Override // com.google.gson.k
            public String a(Field field) {
                return j.b(field.getName(), NameUtil.USCORE).toLowerCase(Locale.ENGLISH);
            }
        };
        g = jVar4;
        final String str5 = "LOWER_CASE_WITH_DASHES";
        final int i6 = 5;
        j jVar5 = new j(str5, i6) { // from class: com.google.gson.h
            {
                c cVar2 = null;
            }

            @Override // com.google.gson.k
            public String a(Field field) {
                return j.b(field.getName(), NameUtil.HYPHEN).toLowerCase(Locale.ENGLISH);
            }
        };
        f756h = jVar5;
        final String str6 = "LOWER_CASE_WITH_DOTS";
        final int i7 = 6;
        j jVar6 = new j(str6, i7) { // from class: com.google.gson.i
            {
                c cVar2 = null;
            }

            @Override // com.google.gson.k
            public String a(Field field) {
                return j.b(field.getName(), NameUtil.PERIOD).toLowerCase(Locale.ENGLISH);
            }
        };
        f757i = jVar6;
        f758j = new j[]{cVar, jVar, jVar2, jVar3, jVar4, jVar5, jVar6};
    }

    private j(String str, int i2) {
    }

    static String b(String str, char c2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String c(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i2 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
            }
        }
        return str;
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f758j.clone();
    }

    /* synthetic */ j(String str, int i2, c cVar) {
        this(str, i2);
    }
}
