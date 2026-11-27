package com.auto.exceldeps.log4j;

import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.message.StructuredDataMessage;
import com.auto.exceldeps.log4j.spi.ExtendedLogger;

@Deprecated
/* loaded from: classes.dex */
public final class EventLogger {
    public static final Marker EVENT_MARKER = MarkerManager.getMarker("EVENT");
    private static final String FQCN = EventLogger.class.getName();
    private static final String NAME = "EventLogger";
    private static final ExtendedLogger LOGGER = LogManager.getContext(false).getLogger(NAME);

    private EventLogger() {
    }

    public static void logEvent(StructuredDataMessage structuredDataMessage) {
        LOGGER.logIfEnabled(FQCN, Level.OFF, EVENT_MARKER, (Message) structuredDataMessage, (Throwable) null);
    }

    public static void logEvent(StructuredDataMessage structuredDataMessage, Level level) {
        LOGGER.logIfEnabled(FQCN, level, EVENT_MARKER, (Message) structuredDataMessage, (Throwable) null);
    }
}
