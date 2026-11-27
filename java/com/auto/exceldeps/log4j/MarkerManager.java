package com.auto.exceldeps.log4j;

import com.auto.exceldeps.log4j.MarkerManager;
import com.auto.exceldeps.log4j.util.PerformanceSensitive;
import com.auto.exceldeps.log4j.util.StringBuilderFormattable;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

/* loaded from: classes.dex */
public final class MarkerManager {
    private static final ConcurrentMap<String, Marker> MARKERS = new ConcurrentHashMap();

    private MarkerManager() {
    }

    public static void clear() {
        MARKERS.clear();
    }

    public static boolean exists(String str) {
        return MARKERS.containsKey(str);
    }

    public static Marker getMarker(String str) {
        return MARKERS.computeIfAbsent(str, new Function() { // from class: com.auto.exceldeps.log4j.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new MarkerManager.Log4jMarker((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requireNonNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    @Deprecated
    public static Marker getMarker(String str, String str2) {
        Marker marker = MARKERS.get(str2);
        if (marker != null) {
            return getMarker(str).addParents(marker);
        }
        throw new IllegalArgumentException("Parent Marker " + str2 + " has not been defined");
    }

    public static class Log4jMarker implements Marker, StringBuilderFormattable {
        private static final long serialVersionUID = 100;
        private final String name;
        private volatile Marker[] parents;

        private Log4jMarker() {
            this.name = null;
            this.parents = null;
        }

        @PerformanceSensitive({"allocation"})
        private static void addParentInfo(StringBuilder sb, Marker... markerArr) {
            sb.append("[ ");
            int length = markerArr.length;
            boolean z = true;
            int i2 = 0;
            while (i2 < length) {
                Marker marker = markerArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append(marker.getName());
                Marker[] parents = marker instanceof Log4jMarker ? ((Log4jMarker) marker).parents : marker.getParents();
                if (parents != null) {
                    addParentInfo(sb, parents);
                }
                i2++;
                z = false;
            }
            sb.append(" ]");
        }

        @PerformanceSensitive({"allocation", "unrolled"})
        private static boolean checkParent(Marker marker, Marker marker2) {
            if (marker == marker2) {
                return true;
            }
            Marker[] parents = marker instanceof Log4jMarker ? ((Log4jMarker) marker).parents : marker.getParents();
            if (parents != null) {
                int length = parents.length;
                if (length == 1) {
                    return checkParent(parents[0], marker2);
                }
                if (length == 2) {
                    return checkParent(parents[0], marker2) || checkParent(parents[1], marker2);
                }
                for (Marker marker3 : parents) {
                    if (checkParent(marker3, marker2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @PerformanceSensitive({"allocation"})
        private static boolean contains(Marker marker, Marker... markerArr) {
            for (Marker marker2 : markerArr) {
                if (marker2 == marker) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.auto.exceldeps.log4j.Marker
        public synchronized Marker addParents(Marker... markerArr) {
            MarkerManager.requireNonNull(markerArr, "A parent marker must be specified");
            Marker[] markerArr2 = this.parents;
            int length = markerArr.length;
            if (markerArr2 != null) {
                int i2 = 0;
                for (Marker marker : markerArr) {
                    if (!contains(marker, markerArr2) && !marker.isInstanceOf(this)) {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    return this;
                }
                length = markerArr2.length + i2;
            }
            Marker[] markerArr3 = new Marker[length];
            if (markerArr2 != null) {
                System.arraycopy(markerArr2, 0, markerArr3, 0, markerArr2.length);
            }
            int length2 = markerArr2 == null ? 0 : markerArr2.length;
            for (Marker marker2 : markerArr) {
                if (markerArr2 == null || (!contains(marker2, markerArr2) && !marker2.isInstanceOf(this))) {
                    markerArr3[length2] = marker2;
                    length2++;
                }
            }
            this.parents = markerArr3;
            return this;
        }

        @Override // com.auto.exceldeps.log4j.Marker
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Marker)) {
                return false;
            }
            return this.name.equals(((Marker) obj).getName());
        }

        @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
        public void formatTo(StringBuilder sb) {
            sb.append(this.name);
            Marker[] markerArr = this.parents;
            if (markerArr != null) {
                addParentInfo(sb, markerArr);
            }
        }

        @Override // com.auto.exceldeps.log4j.Marker
        public String getName() {
            return this.name;
        }

        @Override // com.auto.exceldeps.log4j.Marker
        public Marker[] getParents() {
            Marker[] markerArr = this.parents;
            if (markerArr == null) {
                return null;
            }
            return (Marker[]) Arrays.copyOf(markerArr, markerArr.length);
        }

        @Override // com.auto.exceldeps.log4j.Marker
        public boolean hasParents() {
            return this.parents != null;
        }

        @Override // com.auto.exceldeps.log4j.Marker
        public int hashCode() {
            return this.name.hashCode();
        }

        @Override // com.auto.exceldeps.log4j.Marker
        @PerformanceSensitive({"allocation", "unrolled"})
        public boolean isInstanceOf(Marker marker) {
            MarkerManager.requireNonNull(marker, "A marker parameter is required");
            if (this == marker) {
                return true;
            }
            Marker[] markerArr = this.parents;
            if (markerArr != null) {
                int length = markerArr.length;
                if (length == 1) {
                    return checkParent(markerArr[0], marker);
                }
                if (length == 2) {
                    return checkParent(markerArr[0], marker) || checkParent(markerArr[1], marker);
                }
                for (Marker marker2 : markerArr) {
                    if (checkParent(marker2, marker)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.auto.exceldeps.log4j.Marker
        public synchronized boolean remove(Marker marker) {
            MarkerManager.requireNonNull(marker, "A parent marker must be specified");
            Marker[] markerArr = this.parents;
            if (markerArr == null) {
                return false;
            }
            int length = markerArr.length;
            if (length == 1) {
                if (!markerArr[0].equals(marker)) {
                    return false;
                }
                this.parents = null;
                return true;
            }
            int i2 = length - 1;
            Marker[] markerArr2 = new Marker[i2];
            int i3 = 0;
            for (Marker marker2 : markerArr) {
                if (!marker2.equals(marker)) {
                    if (i3 == i2) {
                        return false;
                    }
                    int i4 = i3 + 1;
                    markerArr2[i3] = marker2;
                    i3 = i4;
                }
            }
            this.parents = markerArr2;
            return true;
        }

        @Override // com.auto.exceldeps.log4j.Marker
        public Marker setParents(Marker... markerArr) {
            if (markerArr == null || markerArr.length == 0) {
                this.parents = null;
            } else {
                Marker[] markerArr2 = new Marker[markerArr.length];
                System.arraycopy(markerArr, 0, markerArr2, 0, markerArr.length);
                this.parents = markerArr2;
            }
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            formatTo(sb);
            return sb.toString();
        }

        public Log4jMarker(String str) {
            MarkerManager.requireNonNull(str, "Marker name cannot be null.");
            this.name = str;
            this.parents = null;
        }

        @Override // com.auto.exceldeps.log4j.Marker
        @PerformanceSensitive({"allocation", "unrolled"})
        public boolean isInstanceOf(String str) {
            Marker[] markerArr;
            MarkerManager.requireNonNull(str, "A marker name is required");
            if (str.equals(getName())) {
                return true;
            }
            Marker marker = (Marker) MarkerManager.MARKERS.get(str);
            if (marker != null && (markerArr = this.parents) != null) {
                int length = markerArr.length;
                if (length == 1) {
                    return checkParent(markerArr[0], marker);
                }
                if (length == 2) {
                    return checkParent(markerArr[0], marker) || checkParent(markerArr[1], marker);
                }
                for (Marker marker2 : markerArr) {
                    if (checkParent(marker2, marker)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @InlineMe(imports = {"com.auto.exceldeps.log4j.MarkerManager"}, replacement = "MarkerManager.getMarker(name).addParents(parent)")
    @Deprecated
    public static Marker getMarker(String str, Marker marker) {
        return getMarker(str).addParents(marker);
    }
}
