package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.widget.TextView;
import h.e.h.b;

/* loaded from: classes.dex */
public abstract class m {
    public static int a(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int b(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    private static int c(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    private static TextDirectionHeuristic d(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                if (!z) {
                    break;
                } else {
                    break;
                }
        }
        return TextDirectionHeuristics.LTR;
    }

    public static b.a e(TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new b.a(textView.getTextMetricsParams());
        }
        h.e.h.a aVar = new h.e.h.a(new TextPaint(textView.getPaint()));
        if (i2 >= 23) {
            aVar.b(textView.getBreakStrategy());
            aVar.c(textView.getHyphenationFrequency());
        }
        if (i2 >= 18) {
            aVar.d(d(textView));
        }
        return aVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(TextView textView, ColorStateList colorStateList) {
        h.e.i.h.d(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof r) {
            ((r) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(TextView textView, PorterDuff.Mode mode) {
        h.e.i.h.d(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof r) {
            ((r) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void h(TextView textView, int i2) {
        h.e.i.h.b(i2);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i4 = (i3 < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i4)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i4, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void i(TextView textView, int i2) {
        h.e.i.h.b(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void j(TextView textView, int i2) {
        h.e.i.h.b(i2);
        if (i2 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i2 - r0, 1.0f);
        }
    }

    public static void k(TextView textView, h.e.h.b bVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(bVar.b());
        } else {
            if (!e(textView).a(bVar.a())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(bVar);
        }
    }

    public static void l(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static void m(TextView textView, b.a aVar) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 18) {
            textView.setTextDirection(c(aVar.d()));
        }
        if (i2 >= 23) {
            textView.getPaint().set(aVar.e());
            textView.setBreakStrategy(aVar.b());
            textView.setHyphenationFrequency(aVar.c());
        } else {
            float textScaleX = aVar.e().getTextScaleX();
            textView.getPaint().set(aVar.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    public static ActionMode.Callback n(TextView textView, ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof l)) ? callback : new l(callback, textView);
    }
}
