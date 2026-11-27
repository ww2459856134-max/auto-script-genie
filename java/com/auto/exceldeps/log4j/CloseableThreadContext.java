package com.auto.exceldeps.log4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CloseableThreadContext {

    public static class Instance implements AutoCloseable {
        private final Map<String, String> originalValues;
        private int pushCount;

        private void closeMap() {
            HashMap map = new HashMap(this.originalValues.size());
            ArrayList arrayList = new ArrayList(this.originalValues.size());
            for (Map.Entry<String, String> entry : this.originalValues.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    arrayList.add(key);
                } else {
                    map.put(key, value);
                }
            }
            if (!map.isEmpty()) {
                ThreadContext.putAll(map);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ThreadContext.removeAll(arrayList);
        }

        private void closeStack() {
            for (int i2 = 0; i2 < this.pushCount; i2++) {
                ThreadContext.pop();
            }
            this.pushCount = 0;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            closeStack();
            closeMap();
        }

        public Instance push(String str) {
            ThreadContext.push(str);
            this.pushCount++;
            return this;
        }

        public Instance pushAll(List<String> list) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                push(it.next());
            }
            return this;
        }

        public Instance put(String str, String str2) {
            if (!this.originalValues.containsKey(str)) {
                this.originalValues.put(str, ThreadContext.get(str));
            }
            ThreadContext.put(str, str2);
            return this;
        }

        public Instance putAll(Map<String, String> map) {
            Map<String, String> context = ThreadContext.getContext();
            ThreadContext.putAll(map);
            for (String str : map.keySet()) {
                if (!this.originalValues.containsKey(str)) {
                    this.originalValues.put(str, context.get(str));
                }
            }
            return this;
        }

        private Instance() {
            this.pushCount = 0;
            this.originalValues = new HashMap();
        }

        public Instance push(String str, Object[] objArr) {
            ThreadContext.push(str, objArr);
            this.pushCount++;
            return this;
        }
    }

    private CloseableThreadContext() {
    }

    public static Instance push(String str) {
        return new Instance().push(str);
    }

    public static Instance pushAll(List<String> list) {
        return new Instance().pushAll(list);
    }

    public static Instance put(String str, String str2) {
        return new Instance().put(str, str2);
    }

    public static Instance putAll(Map<String, String> map) {
        return new Instance().putAll(map);
    }

    public static Instance push(String str, Object... objArr) {
        return new Instance().push(str, objArr);
    }
}
