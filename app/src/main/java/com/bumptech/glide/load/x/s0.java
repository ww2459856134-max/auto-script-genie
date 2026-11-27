package com.bumptech.glide.load.x;

import java.io.IOException;

/* loaded from: classes.dex */
final class s0 implements Appendable {
    private final Appendable c;
    private boolean d = true;

    s0(Appendable appendable) {
        this.c = appendable;
    }

    private CharSequence a(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence;
    }

    @Override // java.lang.Appendable
    public Appendable append(char c) throws IOException {
        if (this.d) {
            this.d = false;
            this.c.append("  ");
        }
        this.d = c == '\n';
        this.c.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence charSequence) throws IOException {
        CharSequence charSequenceA = a(charSequence);
        append(charSequenceA, 0, charSequenceA.length());
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
        CharSequence charSequenceA = a(charSequence);
        boolean z = false;
        if (this.d) {
            this.d = false;
            this.c.append("  ");
        }
        if (charSequenceA.length() > 0 && charSequenceA.charAt(i3 - 1) == '\n') {
            z = true;
        }
        this.d = z;
        this.c.append(charSequenceA, i2, i3);
        return this;
    }
}
