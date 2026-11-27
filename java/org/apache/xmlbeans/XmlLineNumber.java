package org.apache.xmlbeans;

import org.apache.xmlbeans.XmlCursor;

/* loaded from: classes.dex */
public class XmlLineNumber extends XmlCursor.XmlBookmark {
    private int _column;
    private int _line;
    private int _offset;

    public XmlLineNumber(int i2) {
        this(i2, -1, -1);
    }

    public int getColumn() {
        return this._column;
    }

    public int getLine() {
        return this._line;
    }

    public int getOffset() {
        return this._offset;
    }

    public XmlLineNumber(int i2, int i3) {
        this(i2, i3, -1);
    }

    public XmlLineNumber(int i2, int i3, int i4) {
        super(false);
        this._line = i2;
        this._column = i3;
        this._offset = i4;
    }
}
