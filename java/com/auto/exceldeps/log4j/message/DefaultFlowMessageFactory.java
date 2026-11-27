package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.StringBuilderFormattable;
import com.auto.exceldeps.log4j.util.StringBuilders;
import com.auto.exceldeps.log4j.util.Strings;
import java.io.Serializable;

/* loaded from: classes.dex */
public class DefaultFlowMessageFactory implements FlowMessageFactory, Serializable {
    private static final String ENTRY_DEFAULT_PREFIX = "Enter";
    private static final String EXIT_DEFAULT_PREFIX = "Exit";
    public static final FlowMessageFactory INSTANCE = new DefaultFlowMessageFactory();
    private static final long serialVersionUID = 8578655591131397576L;
    private final String entryText;
    private final String exitText;

    private static class AbstractFlowMessage implements FlowMessage, StringBuilderFormattable {
        private static final long serialVersionUID = 1;
        private final Message message;
        private final String text;

        AbstractFlowMessage(String str, Message message) {
            this.message = message;
            this.text = str;
        }

        @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
        public void formatTo(StringBuilder sb) {
            sb.append(this.text);
            if (this.message != null) {
                sb.append(" ");
                StringBuilders.appendValue(sb, this.message);
            }
        }

        @Override // com.auto.exceldeps.log4j.message.Message
        public String getFormat() {
            if (this.message == null) {
                return this.text;
            }
            return this.text + " " + this.message.getFormat();
        }

        @Override // com.auto.exceldeps.log4j.message.Message
        public String getFormattedMessage() {
            if (this.message == null) {
                return this.text;
            }
            return this.text + " " + this.message.getFormattedMessage();
        }

        @Override // com.auto.exceldeps.log4j.message.FlowMessage
        public Message getMessage() {
            return this.message;
        }

        @Override // com.auto.exceldeps.log4j.message.Message
        public Object[] getParameters() {
            Message message = this.message;
            if (message != null) {
                return message.getParameters();
            }
            return null;
        }

        @Override // com.auto.exceldeps.log4j.message.FlowMessage
        public String getText() {
            return this.text;
        }

        @Override // com.auto.exceldeps.log4j.message.Message
        public Throwable getThrowable() {
            Message message = this.message;
            if (message != null) {
                return message.getThrowable();
            }
            return null;
        }
    }

    private static final class SimpleEntryMessage extends AbstractFlowMessage implements EntryMessage {
        private static final long serialVersionUID = 1;

        SimpleEntryMessage(String str, Message message) {
            super(str, message);
        }
    }

    private static final class SimpleExitMessage extends AbstractFlowMessage implements ExitMessage {
        private static final long serialVersionUID = 1;
        private final boolean isVoid;
        private final Object result;

        SimpleExitMessage(String str, EntryMessage entryMessage) {
            this(str, entryMessage.getMessage());
        }

        @Override // com.auto.exceldeps.log4j.message.DefaultFlowMessageFactory.AbstractFlowMessage, com.auto.exceldeps.log4j.message.Message
        public String getFormattedMessage() {
            String formattedMessage = super.getFormattedMessage();
            if (this.isVoid) {
                return formattedMessage;
            }
            return formattedMessage + ": " + this.result;
        }

        SimpleExitMessage(String str, Message message) {
            super(str, message);
            this.result = null;
            this.isVoid = true;
        }

        SimpleExitMessage(String str, Object obj, EntryMessage entryMessage) {
            this(str, obj, entryMessage.getMessage());
        }

        SimpleExitMessage(String str, Object obj, Message message) {
            super(str, message);
            this.result = obj;
            this.isVoid = false;
        }
    }

    public DefaultFlowMessageFactory() {
        this(ENTRY_DEFAULT_PREFIX, EXIT_DEFAULT_PREFIX);
    }

    private Message makeImmutable(Message message) {
        return message instanceof ReusableMessage ? ((ReusableMessage) message).memento() : message;
    }

    public String getEntryText() {
        return this.entryText;
    }

    public String getExitText() {
        return this.exitText;
    }

    @Override // com.auto.exceldeps.log4j.message.FlowMessageFactory
    public EntryMessage newEntryMessage(String str, Object... objArr) {
        Message messageNewMessage;
        boolean zIsNotEmpty = Strings.isNotEmpty(str);
        if (objArr == null || objArr.length == 0) {
            messageNewMessage = zIsNotEmpty ? ParameterizedMessageFactory.INSTANCE.newMessage(str) : null;
        } else if (zIsNotEmpty) {
            messageNewMessage = ParameterizedMessageFactory.INSTANCE.newMessage(str, objArr);
        } else {
            StringBuilder sb = new StringBuilder("params(");
            for (int i2 = 0; i2 < objArr.length; i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append("{}");
            }
            sb.append(")");
            messageNewMessage = ParameterizedMessageFactory.INSTANCE.newMessage(sb.toString(), objArr);
        }
        return newEntryMessage(messageNewMessage);
    }

    @Override // com.auto.exceldeps.log4j.message.FlowMessageFactory
    public ExitMessage newExitMessage(String str, Object obj) {
        Message messageNewMessage;
        boolean zIsNotEmpty = Strings.isNotEmpty(str);
        if (obj == null) {
            messageNewMessage = zIsNotEmpty ? ParameterizedMessageFactory.INSTANCE.newMessage(str) : null;
        } else {
            ParameterizedMessageFactory parameterizedMessageFactory = ParameterizedMessageFactory.INSTANCE;
            if (!zIsNotEmpty) {
                str = "with({})";
            }
            messageNewMessage = parameterizedMessageFactory.newMessage(str, obj);
        }
        return newExitMessage(messageNewMessage);
    }

    public DefaultFlowMessageFactory(String str, String str2) {
        this.entryText = str;
        this.exitText = str2;
    }

    @Override // com.auto.exceldeps.log4j.message.FlowMessageFactory
    public ExitMessage newExitMessage(Message message) {
        return new SimpleExitMessage(this.exitText, message);
    }

    @Override // com.auto.exceldeps.log4j.message.FlowMessageFactory
    public ExitMessage newExitMessage(EntryMessage entryMessage) {
        return new SimpleExitMessage(this.exitText, entryMessage);
    }

    @Override // com.auto.exceldeps.log4j.message.FlowMessageFactory
    public ExitMessage newExitMessage(Object obj, EntryMessage entryMessage) {
        return new SimpleExitMessage(this.exitText, obj, entryMessage);
    }

    @Override // com.auto.exceldeps.log4j.message.FlowMessageFactory
    public ExitMessage newExitMessage(Object obj, Message message) {
        return new SimpleExitMessage(this.exitText, obj, message);
    }

    @Override // com.auto.exceldeps.log4j.message.FlowMessageFactory
    public EntryMessage newEntryMessage(Message message) {
        return new SimpleEntryMessage(this.entryText, makeImmutable(message));
    }
}
