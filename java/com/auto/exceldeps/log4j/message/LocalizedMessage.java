package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.status.StatusLogger;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: classes.dex */
public class LocalizedMessage implements Message, LoggerNameAwareMessage {
    private static final long serialVersionUID = 3893703791567290742L;
    private transient Object[] argArray;
    private String baseName;
    private String formattedMessage;
    private String key;
    private final Locale locale;
    private transient StatusLogger logger;
    private String loggerName;
    private transient ResourceBundle resourceBundle;
    private String[] stringArgs;
    private transient Throwable throwable;

    public LocalizedMessage(String str, Object[] objArr) {
        this((ResourceBundle) null, (Locale) null, str, objArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.formattedMessage = objectInputStream.readUTF();
        this.key = objectInputStream.readUTF();
        this.baseName = objectInputStream.readUTF();
        objectInputStream.readInt();
        this.stringArgs = (String[]) objectInputStream.readObject();
        this.logger = StatusLogger.getLogger();
        this.resourceBundle = null;
        this.argArray = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        getFormattedMessage();
        objectOutputStream.writeUTF(this.formattedMessage);
        objectOutputStream.writeUTF(this.key);
        objectOutputStream.writeUTF(this.baseName);
        objectOutputStream.writeInt(this.argArray.length);
        Object[] objArr = this.argArray;
        this.stringArgs = new String[objArr.length];
        int i2 = 0;
        for (Object obj : objArr) {
            this.stringArgs[i2] = obj.toString();
            i2++;
        }
        objectOutputStream.writeObject(this.stringArgs);
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        return this.key;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        String str = this.formattedMessage;
        if (str != null) {
            return str;
        }
        ResourceBundle resourceBundle = this.resourceBundle;
        if (resourceBundle == null) {
            String str2 = this.baseName;
            resourceBundle = str2 != null ? getResourceBundle(str2, this.locale, false) : getResourceBundle(this.loggerName, this.locale, true);
        }
        String format = getFormat();
        if (resourceBundle != null && resourceBundle.containsKey(format)) {
            format = resourceBundle.getString(format);
        }
        Object[] objArr = this.argArray;
        if (objArr == null) {
            objArr = this.stringArgs;
        }
        FormattedMessage formattedMessage = new FormattedMessage(format, objArr);
        this.formattedMessage = formattedMessage.getFormattedMessage();
        this.throwable = formattedMessage.getThrowable();
        return this.formattedMessage;
    }

    @Override // com.auto.exceldeps.log4j.message.LoggerNameAwareMessage
    public String getLoggerName() {
        return this.loggerName;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        Object[] objArr = this.argArray;
        return objArr != null ? objArr : this.stringArgs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001d  */
    /* JADX WARN: Type inference failed for: r6v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.ResourceBundle] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ResourceBundle] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.ResourceBundle] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.util.ResourceBundle] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x002c -> B:9:0x0011). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0031 -> B:9:0x0011). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ResourceBundle getResourceBundle(String str, Locale locale, boolean z) {
        ResourceBundle resourceBundle = null;
        if (str == null) {
            return null;
        }
        try {
            z = locale != null ? ResourceBundle.getBundle(str, locale) : ResourceBundle.getBundle(str);
        } catch (MissingResourceException unused) {
            if (z == 0) {
                this.logger.debug("Unable to locate ResourceBundle {}", str);
                return resourceBundle;
            }
        }
        resourceBundle = z;
        while (resourceBundle == null) {
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf <= 0) {
                break;
            }
            str = str.substring(0, iLastIndexOf);
            if (locale != null) {
                try {
                    z = ResourceBundle.getBundle(str, locale);
                } catch (MissingResourceException unused2) {
                    this.logger.debug("Unable to locate ResourceBundle {}", str);
                }
            } else {
                z = ResourceBundle.getBundle(str);
            }
            resourceBundle = z;
            while (resourceBundle == null) {
            }
        }
        return resourceBundle;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override // com.auto.exceldeps.log4j.message.LoggerNameAwareMessage
    public void setLoggerName(String str) {
        this.loggerName = str;
    }

    public String toString() {
        return getFormattedMessage();
    }

    public LocalizedMessage(String str, String str2, Object[] objArr) {
        this(str, (Locale) null, str2, objArr);
    }

    public LocalizedMessage(ResourceBundle resourceBundle, String str, Object[] objArr) {
        this(resourceBundle, (Locale) null, str, objArr);
    }

    public LocalizedMessage(String str, Locale locale, String str2, Object[] objArr) {
        this.logger = StatusLogger.getLogger();
        this.key = str2;
        this.argArray = objArr;
        this.throwable = null;
        this.baseName = str;
        this.resourceBundle = null;
        this.locale = locale;
    }

    public LocalizedMessage(ResourceBundle resourceBundle, Locale locale, String str, Object[] objArr) {
        this.logger = StatusLogger.getLogger();
        this.key = str;
        this.argArray = objArr;
        this.throwable = null;
        this.baseName = null;
        this.resourceBundle = resourceBundle;
        this.locale = locale;
    }

    public LocalizedMessage(Locale locale, String str, Object[] objArr) {
        this((ResourceBundle) null, locale, str, objArr);
    }

    public LocalizedMessage(String str, Object obj) {
        this((ResourceBundle) null, (Locale) null, str, new Object[]{obj});
    }

    public LocalizedMessage(String str, String str2, Object obj) {
        this(str, (Locale) null, str2, new Object[]{obj});
    }

    public LocalizedMessage(ResourceBundle resourceBundle, String str) {
        this(resourceBundle, (Locale) null, str, new Object[0]);
    }

    public LocalizedMessage(ResourceBundle resourceBundle, String str, Object obj) {
        this(resourceBundle, (Locale) null, str, new Object[]{obj});
    }

    public LocalizedMessage(String str, Locale locale, String str2, Object obj) {
        this(str, locale, str2, new Object[]{obj});
    }

    public LocalizedMessage(ResourceBundle resourceBundle, Locale locale, String str, Object obj) {
        this(resourceBundle, locale, str, new Object[]{obj});
    }

    public LocalizedMessage(Locale locale, String str, Object obj) {
        this((ResourceBundle) null, locale, str, new Object[]{obj});
    }

    public LocalizedMessage(String str, Object obj, Object obj2) {
        this((ResourceBundle) null, (Locale) null, str, new Object[]{obj, obj2});
    }

    public LocalizedMessage(String str, String str2, Object obj, Object obj2) {
        this(str, (Locale) null, str2, new Object[]{obj, obj2});
    }

    public LocalizedMessage(ResourceBundle resourceBundle, String str, Object obj, Object obj2) {
        this(resourceBundle, (Locale) null, str, new Object[]{obj, obj2});
    }

    public LocalizedMessage(String str, Locale locale, String str2, Object obj, Object obj2) {
        this(str, locale, str2, new Object[]{obj, obj2});
    }

    public LocalizedMessage(ResourceBundle resourceBundle, Locale locale, String str, Object obj, Object obj2) {
        this(resourceBundle, locale, str, new Object[]{obj, obj2});
    }

    public LocalizedMessage(Locale locale, String str, Object obj, Object obj2) {
        this((ResourceBundle) null, locale, str, new Object[]{obj, obj2});
    }
}
