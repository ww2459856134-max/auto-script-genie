package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/* loaded from: classes.dex */
public class PropertyFilePropertySource extends PropertiesPropertySource {
    private static final Logger LOGGER = StatusLogger.getLogger();

    public PropertyFilePropertySource(String str) {
        this(str, true);
    }

    @SuppressFBWarnings(justification = "This property source should only be used with hardcoded file names.", value = {"URLCONNECTION_SSRF_FD"})
    private static Properties loadPropertiesFile(String str, boolean z) throws IOException {
        Properties properties = new Properties();
        for (URL url : LoaderUtil.findResources(str, z)) {
            try {
                InputStream inputStreamOpenStream = url.openStream();
                try {
                    properties.load(inputStreamOpenStream);
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStreamOpenStream != null) {
                        try {
                            inputStreamOpenStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                LOGGER.error("Unable to read URL `{}`", url, e);
            }
        }
        return properties;
    }

    public PropertyFilePropertySource(String str, boolean z) {
        super(loadPropertiesFile(str, z));
    }
}
