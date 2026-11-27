package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;

@PerformanceSensitive({"allocation"})
/* loaded from: classes.dex */
public class Unbox {
    private static final int BITS_PER_INT = 32;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final int MASK;
    private static final int RINGBUFFER_MIN_SIZE = 32;
    private static final int RINGBUFFER_SIZE;
    private static ThreadLocal<State> threadLocalState;
    private static WebSafeState webSafeState;

    private static class State {
        private int current;
        private final StringBuilder[] ringBuffer = new StringBuilder[Unbox.RINGBUFFER_SIZE];

        State() {
            int i2 = 0;
            while (true) {
                StringBuilder[] sbArr = this.ringBuffer;
                if (i2 >= sbArr.length) {
                    return;
                }
                sbArr[i2] = new StringBuilder(21);
                i2++;
            }
        }

        public StringBuilder getStringBuilder() {
            StringBuilder[] sbArr = this.ringBuffer;
            int i2 = Unbox.MASK;
            int i3 = this.current;
            this.current = i3 + 1;
            StringBuilder sb = sbArr[i2 & i3];
            sb.setLength(0);
            return sb;
        }
    }

    private static class WebSafeState {
        private final ThreadLocal<int[]> current;
        private final ThreadLocal<StringBuilder[]> ringBuffer;

        private WebSafeState() {
            this.ringBuffer = new ThreadLocal<>();
            this.current = new ThreadLocal<>();
        }

        public StringBuilder getStringBuilder() {
            StringBuilder[] sbArr = this.ringBuffer.get();
            if (sbArr == null) {
                int i2 = Unbox.RINGBUFFER_SIZE;
                StringBuilder[] sbArr2 = new StringBuilder[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    sbArr2[i3] = new StringBuilder(21);
                }
                this.ringBuffer.set(sbArr2);
                this.current.set(new int[1]);
                sbArr = sbArr2;
            }
            int[] iArr = this.current.get();
            int i4 = Unbox.MASK;
            int i5 = iArr[0];
            iArr[0] = i5 + 1;
            StringBuilder sb = sbArr[i4 & i5];
            sb.setLength(0);
            return sb;
        }
    }

    static {
        int iCalculateRingBufferSize = calculateRingBufferSize("log4j.unbox.ringbuffer.size");
        RINGBUFFER_SIZE = iCalculateRingBufferSize;
        MASK = iCalculateRingBufferSize - 1;
        threadLocalState = new ThreadLocal<>();
        webSafeState = new WebSafeState();
    }

    private Unbox() {
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(float f) {
        StringBuilder sb = getSB();
        sb.append(f);
        return sb;
    }

    private static int calculateRingBufferSize(String str) throws NumberFormatException {
        String stringProperty = PropertiesUtil.getProperties().getStringProperty(str, String.valueOf(32));
        try {
            int i2 = Integer.parseInt(stringProperty.trim());
            if (i2 < 32) {
                LOGGER.warn("Invalid {} {}, using minimum size {}.", (Object) str, (Object) stringProperty, (Object) 32);
                i2 = 32;
            }
            return ceilingNextPowerOfTwo(i2);
        } catch (Exception unused) {
            LOGGER.warn("Invalid {} {}, using default size {}.", (Object) str, (Object) stringProperty, (Object) 32);
            return 32;
        }
    }

    private static int ceilingNextPowerOfTwo(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }

    static int getRingbufferSize() {
        return RINGBUFFER_SIZE;
    }

    private static StringBuilder getSB() {
        return Constants.ENABLE_THREADLOCALS ? getState().getStringBuilder() : webSafeState.getStringBuilder();
    }

    private static State getState() {
        State state = threadLocalState.get();
        if (state != null) {
            return state;
        }
        State state2 = new State();
        threadLocalState.set(state2);
        return state2;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(double d) {
        StringBuilder sb = getSB();
        sb.append(d);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(short s) {
        StringBuilder sb = getSB();
        sb.append((int) s);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(int i2) {
        StringBuilder sb = getSB();
        sb.append(i2);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(char c) {
        StringBuilder sb = getSB();
        sb.append(c);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(long j2) {
        StringBuilder sb = getSB();
        sb.append(j2);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(byte b) {
        StringBuilder sb = getSB();
        sb.append((int) b);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(boolean z) {
        StringBuilder sb = getSB();
        sb.append(z);
        return sb;
    }
}
