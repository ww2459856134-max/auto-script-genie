package com.jsj.autojs.window;

import android.content.Context;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import com.frame.p1;
import com.frame.v0;
import com.tencent.cursor.R;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class StudyView extends FrameLayout implements View.OnClickListener {
    private static StudyView d;
    private WindowManager c;

    private StudyView(Context context) {
        super(context);
        View.inflate(getContext(), 2131493189, this);
        Button button = (Button) findViewById(2131296506);
        Button button2 = (Button) findViewById(2131296534);
        Button button3 = (Button) findViewById(2131296446);
        Button button4 = (Button) findViewById(2131296434);
        Button button5 = (Button) findViewById(R.id.btn_close);
        int iC = p1.c(100.0f);
        HashMap map = new HashMap();
        GestureLibrary gestureLibraryFromPrivateFile = GestureLibraries.fromPrivateFile(v0.g(), "gesture");
        gestureLibraryFromPrivateFile.load();
        Iterator<String> it = gestureLibraryFromPrivateFile.getGestureEntries().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Iterator<Gesture> it2 = gestureLibraryFromPrivateFile.getGestures(next).iterator();
            while (it2.hasNext()) {
                int i2 = iC;
                int i3 = iC;
                int i4 = iC;
                String str = next;
                map.put(str, b(it2.next(), i2, i3, 20, -256));
                next = str;
                iC = i4;
            }
        }
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    public static StudyView getInstance() {
        StudyView studyView = d;
        if (studyView != null) {
            return studyView;
        }
        StudyView studyView2 = new StudyView(v0.g());
        d = studyView2;
        return studyView2;
    }

    public void a() {
        WindowManager windowManager = this.c;
        if (windowManager != null) {
            windowManager.removeView(this);
        }
        d = null;
    }

    public Bitmap b(Gesture gesture, int i2, int i3, int i4, int i5) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(i5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(20.0f);
        Path path = gesture.toPath();
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        int i6 = i4 * 2;
        float fWidth = (i2 - i6) / rectF.width();
        float fHeight = (i3 - i6) / rectF.height();
        if (fWidth > fHeight) {
            fWidth = fHeight;
        }
        path.offset((-rectF.left) + ((i2 - (rectF.width() * fWidth)) / 2.0f), (-rectF.top) + ((i3 - (rectF.height() * fWidth)) / 2.0f));
        float f = i4;
        canvas.translate(f, f);
        canvas.scale(fWidth, fWidth);
        canvas.drawPath(path, paint);
        return bitmapCreateBitmap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296439) {
            p1.j("请拖动小球，学习手势");
        } else {
            a();
        }
    }
}
