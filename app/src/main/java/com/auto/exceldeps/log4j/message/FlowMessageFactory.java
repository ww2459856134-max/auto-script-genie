package com.auto.exceldeps.log4j.message;

/* loaded from: classes.dex */
public interface FlowMessageFactory {
    EntryMessage newEntryMessage(Message message);

    EntryMessage newEntryMessage(String str, Object... objArr);

    ExitMessage newExitMessage(EntryMessage entryMessage);

    ExitMessage newExitMessage(Message message);

    ExitMessage newExitMessage(Object obj, EntryMessage entryMessage);

    ExitMessage newExitMessage(Object obj, Message message);

    ExitMessage newExitMessage(String str, Object obj);
}
