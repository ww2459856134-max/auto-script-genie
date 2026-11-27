package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.PerformanceSensitive;
import java.util.Map;

@PerformanceSensitive({"allocation"})
@AsynchronouslyFormattable
/* loaded from: classes.dex */
public class StringMapMessage extends MapMessage<StringMapMessage, String> {
    private static final long serialVersionUID = 1;

    public StringMapMessage() {
    }

    public StringMapMessage(int i2) {
        super(i2);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    public StringMapMessage newInstance(Map<String, String> map) {
        return new StringMapMessage(map);
    }

    public StringMapMessage(Map<String, String> map) {
        super(map);
    }
}
