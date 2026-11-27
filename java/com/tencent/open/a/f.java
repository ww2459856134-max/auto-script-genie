package com.tencent.open.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import com.tencent.open.log.SLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class f extends SQLiteOpenHelper {
    protected static final String[] a = {"key"};
    protected static f b;

    public f(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized f a() {
        if (b == null) {
            b = new f(com.tencent.open.utils.f.a());
        }
        return b;
    }

    public synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (writableDatabase == null) {
                return;
            }
            try {
                writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
            } catch (Exception e) {
                SLog.e("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e);
                if (writableDatabase != null) {
                }
            }
        } finally {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0073 A[Catch: all -> 0x007d, Exception -> 0x0080, TRY_ENTER, TryCatch #15 {Exception -> 0x0080, all -> 0x007d, blocks: (B:14:0x0030, B:16:0x0036, B:17:0x0039, B:20:0x0053, B:21:0x0056, B:36:0x0073, B:37:0x0076, B:27:0x0060, B:28:0x0063, B:29:0x0066, B:32:0x006a, B:33:0x006d), top: B:90:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:7:0x0012, B:45:0x0085, B:47:0x008a, B:60:0x00a4, B:62:0x00a9, B:63:0x00ac, B:54:0x009a), top: B:84:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<Serializable> a(String str) {
        ObjectInputStream objectInputStream;
        Serializable serializable;
        List<Serializable> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        if (TextUtils.isEmpty(str)) {
            return listSynchronizedList;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return listSynchronizedList;
        }
        Cursor cursor = null;
        ObjectInputStream objectInputStream2 = null;
        cursor = null;
        try {
            try {
                Cursor cursorQuery = readableDatabase.query("via_cgi_report", null, "type = ?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            do {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cursorQuery.getBlob(cursorQuery.getColumnIndex("blob")));
                                try {
                                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                    try {
                                        serializable = (Serializable) objectInputStream.readObject();
                                        try {
                                            objectInputStream.close();
                                        } catch (IOException unused) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (IOException unused2) {
                                        }
                                    } catch (Exception unused3) {
                                        if (objectInputStream != null) {
                                            try {
                                                objectInputStream.close();
                                            } catch (IOException unused4) {
                                            }
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (IOException unused5) {
                                        }
                                        serializable = null;
                                        if (serializable != null) {
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        objectInputStream2 = objectInputStream;
                                        if (objectInputStream2 != null) {
                                            try {
                                                objectInputStream2.close();
                                            } catch (IOException unused6) {
                                            }
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                            throw th;
                                        } catch (IOException unused7) {
                                            throw th;
                                        }
                                    }
                                } catch (Exception unused8) {
                                    objectInputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                if (serializable != null) {
                                    listSynchronizedList.add(serializable);
                                }
                            } while (cursorQuery.moveToNext());
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor = cursorQuery;
                        SLog.e("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (readableDatabase != null) {
                        }
                        return listSynchronizedList;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (readableDatabase != null) {
                            readableDatabase.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
            return listSynchronizedList;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized void a(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.beginTransaction();
        try {
            try {
                ContentValues contentValues = new ContentValues();
                for (int i2 = 0; i2 < size; i2++) {
                    Serializable serializable = list.get(i2);
                    if (serializable != null) {
                        contentValues.put(SocialConstants.PARAM_TYPE, str);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                        ObjectOutputStream objectOutputStream2 = null;
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            try {
                                objectOutputStream.writeObject(serializable);
                                try {
                                    objectOutputStream.close();
                                } catch (IOException unused) {
                                }
                            } catch (IOException unused2) {
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                byteArrayOutputStream.close();
                                contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                writableDatabase.insert("via_cgi_report", null, contentValues);
                                contentValues.clear();
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException unused4) {
                                    throw th;
                                }
                            }
                        } catch (IOException unused5) {
                            objectOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused6) {
                        }
                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                        writableDatabase.insert("via_cgi_report", null, contentValues);
                    }
                    contentValues.clear();
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception unused7) {
                SLog.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
                writableDatabase.endTransaction();
                if (writableDatabase != null) {
                }
            }
        } finally {
            writableDatabase.endTransaction();
            if (writableDatabase != null) {
                writableDatabase.close();
            }
        }
    }
}
