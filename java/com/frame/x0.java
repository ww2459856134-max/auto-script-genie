package com.frame;

import android.database.Cursor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class x0 {
    public static final void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public static final void b(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final void c(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final void d(InputStreamReader inputStreamReader) throws IOException {
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (Exception unused) {
            }
        }
    }

    public static final void e(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final void f(OutputStreamWriter outputStreamWriter) throws IOException {
        if (outputStreamWriter != null) {
            try {
                outputStreamWriter.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final void g(PrintWriter printWriter) {
        if (printWriter != null) {
            try {
                printWriter.close();
            } catch (Exception unused) {
            }
        }
    }
}
