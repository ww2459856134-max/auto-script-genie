package com.auto.exceldeps.log4j.message;

/* loaded from: classes.dex */
public interface ThreadInformation {
    void printStack(StringBuilder sb, StackTraceElement[] stackTraceElementArr);

    void printThreadInfo(StringBuilder sb);
}
