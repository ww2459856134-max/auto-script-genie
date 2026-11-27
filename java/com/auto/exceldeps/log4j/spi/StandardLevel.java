package com.auto.exceldeps.log4j.spi;

import androidx.recyclerview.widget.k0;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public enum StandardLevel {
    OFF(0),
    FATAL(100),
    ERROR(k0.a.DEFAULT_DRAG_ANIMATION_DURATION),
    WARN(300),
    INFO(400),
    DEBUG(500),
    TRACE(600),
    ALL(Integer.MAX_VALUE);

    private static final EnumSet<StandardLevel> LEVELSET = EnumSet.allOf(StandardLevel.class);
    private final int intLevel;

    StandardLevel(int i2) {
        this.intLevel = i2;
    }

    public static StandardLevel getStandardLevel(int i2) {
        StandardLevel standardLevel = OFF;
        Iterator it = LEVELSET.iterator();
        while (it.hasNext()) {
            StandardLevel standardLevel2 = (StandardLevel) it.next();
            if (standardLevel2.intLevel() > i2) {
                break;
            }
            standardLevel = standardLevel2;
        }
        return standardLevel;
    }

    public int intLevel() {
        return this.intLevel;
    }
}
