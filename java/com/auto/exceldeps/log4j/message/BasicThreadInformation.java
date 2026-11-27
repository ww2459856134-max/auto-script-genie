package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.StringBuilders;
import java.lang.Thread;

/* loaded from: classes.dex */
class BasicThreadInformation implements ThreadInformation {
    private static final int HASH_MULTIPLIER = 31;
    private static final int HASH_SHIFT = 32;
    private final long id;
    private final boolean isDaemon;
    private final String name;
    private final int priority;
    private final Thread.State state;
    private final String threadGroupName;

    BasicThreadInformation(Thread thread) {
        this.id = thread.getId();
        this.name = thread.getName();
        this.state = thread.getState();
        this.priority = thread.getPriority();
        this.isDaemon = thread.isDaemon();
        ThreadGroup threadGroup = thread.getThreadGroup();
        this.threadGroupName = threadGroup == null ? null : threadGroup.getName();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicThreadInformation)) {
            return false;
        }
        BasicThreadInformation basicThreadInformation = (BasicThreadInformation) obj;
        if (this.id != basicThreadInformation.id) {
            return false;
        }
        String str = this.name;
        String str2 = basicThreadInformation.name;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        long j2 = this.id;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        String str = this.name;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    @Override // com.auto.exceldeps.log4j.message.ThreadInformation
    public void printStack(StringBuilder sb, StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
    }

    @Override // com.auto.exceldeps.log4j.message.ThreadInformation
    public void printThreadInfo(StringBuilder sb) {
        StringBuilders.appendDqValue(sb, this.name).append(Chars.SPACE);
        if (this.isDaemon) {
            sb.append("daemon ");
        }
        sb.append("prio=");
        sb.append(this.priority);
        sb.append(" tid=");
        sb.append(this.id);
        sb.append(Chars.SPACE);
        String str = this.threadGroupName;
        if (str != null) {
            StringBuilders.appendKeyDqValue(sb, "group", str);
        }
        sb.append('\n');
        sb.append("\tThread state: ");
        sb.append(this.state.name());
        sb.append('\n');
    }
}
