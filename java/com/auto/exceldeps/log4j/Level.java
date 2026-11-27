package com.auto.exceldeps.log4j;

import aQute.bnd.annotation.baseline.BaselineIgnore;
import com.auto.exceldeps.log4j.spi.StandardLevel;
import com.auto.exceldeps.log4j.util.Strings;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@BaselineIgnore("2.22.0")
/* loaded from: classes.dex */
public final class Level implements Comparable<Level>, Serializable {
    public static final String CATEGORY = "Level";
    private static final long serialVersionUID = 1581082;
    private final int intLevel;
    private final String name;
    private final StandardLevel standardLevel;
    private static final Level[] EMPTY_ARRAY = new Level[0];
    private static final ConcurrentMap<String, Level> LEVELS = new ConcurrentHashMap();
    public static final Level OFF = new Level("OFF", StandardLevel.OFF.intLevel());
    public static final Level FATAL = new Level("FATAL", StandardLevel.FATAL.intLevel());
    public static final Level ERROR = new Level("ERROR", StandardLevel.ERROR.intLevel());
    public static final Level WARN = new Level("WARN", StandardLevel.WARN.intLevel());
    public static final Level INFO = new Level("INFO", StandardLevel.INFO.intLevel());
    public static final Level DEBUG = new Level("DEBUG", StandardLevel.DEBUG.intLevel());
    public static final Level TRACE = new Level("TRACE", StandardLevel.TRACE.intLevel());
    public static final Level ALL = new Level("ALL", StandardLevel.ALL.intLevel());

    private Level(String str, int i2) {
        if (Strings.isEmpty(str)) {
            throw new IllegalArgumentException("Illegal null or empty Level name.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Illegal Level int less than zero.");
        }
        this.name = str;
        this.intLevel = i2;
        this.standardLevel = StandardLevel.getStandardLevel(i2);
        if (LEVELS.putIfAbsent(Strings.toRootUpperCase(str.trim()), this) == null) {
            return;
        }
        throw new IllegalStateException("Level " + str + " has already been defined.");
    }

    public static Level forName(String str, int i2) {
        if (Strings.isEmpty(str)) {
            throw new IllegalArgumentException("Illegal null or empty Level name.");
        }
        String rootUpperCase = Strings.toRootUpperCase(str.trim());
        Level level = LEVELS.get(rootUpperCase);
        if (level != null) {
            return level;
        }
        try {
            return new Level(str, i2);
        } catch (IllegalStateException unused) {
            return LEVELS.get(rootUpperCase);
        }
    }

    public static Level getLevel(String str) {
        if (Strings.isEmpty(str)) {
            throw new IllegalArgumentException("Illegal null or empty Level name.");
        }
        return LEVELS.get(Strings.toRootUpperCase(str.trim()));
    }

    private Object readResolve() {
        return valueOf(this.name);
    }

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    public static Level valueOf(String str) {
        Objects.requireNonNull(str, "No level name given.");
        String rootUpperCase = Strings.toRootUpperCase(str.trim());
        Level level = LEVELS.get(rootUpperCase);
        if (level != null) {
            return level;
        }
        throw new IllegalArgumentException("Unknown level constant [" + rootUpperCase + "].");
    }

    public static Level[] values() {
        return (Level[]) LEVELS.values().toArray(EMPTY_ARRAY);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Level) && obj == this;
    }

    public Class<Level> getDeclaringClass() {
        return Level.class;
    }

    public StandardLevel getStandardLevel() {
        return this.standardLevel;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public int intLevel() {
        return this.intLevel;
    }

    public boolean isInRange(Level level, Level level2) {
        int i2 = this.intLevel;
        return i2 >= level.intLevel && i2 <= level2.intLevel;
    }

    public boolean isLessSpecificThan(Level level) {
        return this.intLevel >= level.intLevel;
    }

    public boolean isMoreSpecificThan(Level level) {
        return this.intLevel <= level.intLevel;
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public static Level toLevel(String str, Level level) {
        Level level2;
        return (str == null || (level2 = LEVELS.get(Strings.toRootUpperCase(str.trim()))) == null) ? level : level2;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Level m0clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override // java.lang.Comparable
    public int compareTo(Level level) {
        int i2 = this.intLevel;
        int i3 = level.intLevel;
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static <T extends Enum<T>> T valueOf(Class<T> cls, String str) {
        return (T) Enum.valueOf(cls, str);
    }
}
