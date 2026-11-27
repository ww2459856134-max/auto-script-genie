package com.v;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class kt {
    private static final Gson a = new Gson();

    private static boolean a(List<String> list) {
        if (list == null || list.size() < 2) {
            return false;
        }
        for (String str : list) {
            if (str == null || str.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> b(List<Integer> list) {
        if (!f(list)) {
            return new ArrayList<>();
        }
        int size = list.size();
        if (size > 4 && list.get(size - 4).equals(list.get(size - 2)) && list.get(size - 3).equals(list.get(size - 1))) {
            size -= 2;
        }
        return new ArrayList<>(list.subList(0, size));
    }

    public static ArrayList<String> c(String str, String str2) {
        if (str == null || str.trim().isEmpty()) {
            if (str2 == null || str2.isEmpty()) {
                return new ArrayList<>();
            }
            String[] strArrSplit = str2.split(ProcessIdUtil.DEFAULT_PROCESSID, -1);
            return (strArrSplit.length == 2 && a(Arrays.asList(strArrSplit))) ? new ArrayList<>(Arrays.asList(strArrSplit)) : new ArrayList<>();
        }
        try {
            String[] strArr = (String[]) a.j(str, String[].class);
            if (strArr != null && a(Arrays.asList(strArr))) {
                return new ArrayList<>(Arrays.asList(strArr));
            }
        } catch (com.google.gson.t unused) {
        }
        return new ArrayList<>();
    }

    public static ArrayList<Integer> d(List<Integer> list) {
        if (!f(list)) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>(list.size() + 2);
        arrayList.addAll(list);
        arrayList.add(list.get(list.size() - 2));
        arrayList.add(list.get(list.size() - 1));
        return arrayList;
    }

    public static String e(List<String> list) {
        return a(list) ? a.s(list) : "";
    }

    private static boolean f(List<Integer> list) {
        if (list == null || list.size() < 4 || list.size() % 2 != 0) {
            return false;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                return false;
            }
        }
        return true;
    }
}
