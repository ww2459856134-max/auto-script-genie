package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.message.Message;

@FunctionalInterface
/* loaded from: classes.dex */
public interface MessageSupplier extends Supplier<Message> {
    @Override // com.auto.exceldeps.log4j.util.Supplier, java.util.function.Supplier
    Message get();
}
