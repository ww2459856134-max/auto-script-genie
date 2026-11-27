package org.apache.xmlbeans.impl.regex;

import java.text.CharacterIterator;

/* loaded from: classes.dex */
public class Match implements Cloneable {
    int[] beginpos = null;
    int[] endpos = null;
    int nofgroups = 0;
    CharacterIterator ciSource = null;
    String strSource = null;
    char[] charSource = null;

    public synchronized Object clone() {
        Match match;
        match = new Match();
        int i2 = this.nofgroups;
        if (i2 > 0) {
            match.setNumberOfGroups(i2);
            CharacterIterator characterIterator = this.ciSource;
            if (characterIterator != null) {
                match.setSource(characterIterator);
            }
            String str = this.strSource;
            if (str != null) {
                match.setSource(str);
            }
            for (int i3 = 0; i3 < this.nofgroups; i3++) {
                match.setBeginning(i3, getBeginning(i3));
                match.setEnd(i3, getEnd(i3));
            }
        }
        return match;
    }

    public int getBeginning(int i2) {
        int[] iArr = this.beginpos;
        if (iArr == null) {
            throw new IllegalStateException("A result is not set.");
        }
        if (i2 >= 0 && this.nofgroups > i2) {
            return iArr[i2];
        }
        throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + i2);
    }

    public String getCapturedText(int i2) {
        int[] iArr = this.beginpos;
        if (iArr == null) {
            throw new IllegalStateException("match() has never been called.");
        }
        if (i2 < 0 || this.nofgroups <= i2) {
            throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + i2);
        }
        int i3 = iArr[i2];
        int i4 = this.endpos[i2];
        if (i3 < 0 || i4 < 0) {
            return null;
        }
        CharacterIterator characterIterator = this.ciSource;
        if (characterIterator != null) {
            return REUtil.substring(characterIterator, i3, i4);
        }
        String str = this.strSource;
        return str != null ? str.substring(i3, i4) : new String(this.charSource, i3, i4 - i3);
    }

    public int getEnd(int i2) {
        int[] iArr = this.endpos;
        if (iArr == null) {
            throw new IllegalStateException("A result is not set.");
        }
        if (i2 >= 0 && this.nofgroups > i2) {
            return iArr[i2];
        }
        throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + i2);
    }

    public int getNumberOfGroups() {
        int i2 = this.nofgroups;
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalStateException("A result is not set.");
    }

    protected void setBeginning(int i2, int i3) {
        this.beginpos[i2] = i3;
    }

    protected void setEnd(int i2, int i3) {
        this.endpos[i2] = i3;
    }

    protected void setNumberOfGroups(int i2) {
        int i3 = this.nofgroups;
        this.nofgroups = i2;
        if (i3 <= 0 || i3 < i2 || i2 * 2 < i3) {
            this.beginpos = new int[i2];
            this.endpos = new int[i2];
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.beginpos[i4] = -1;
            this.endpos[i4] = -1;
        }
    }

    protected void setSource(CharacterIterator characterIterator) {
        this.ciSource = characterIterator;
        this.strSource = null;
        this.charSource = null;
    }

    protected void setSource(String str) {
        this.ciSource = null;
        this.strSource = str;
        this.charSource = null;
    }

    protected void setSource(char[] cArr) {
        this.ciSource = null;
        this.strSource = null;
        this.charSource = cArr;
    }
}
