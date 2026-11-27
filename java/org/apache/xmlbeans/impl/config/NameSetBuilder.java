package org.apache.xmlbeans.impl.config;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class NameSetBuilder {
    private boolean _isFinite = true;
    private final Set<String> _finiteSet = new HashSet();

    public void add(String str) {
        if (this._isFinite) {
            this._finiteSet.add(str);
        } else {
            this._finiteSet.remove(str);
        }
    }

    public void invert() {
        this._isFinite = !this._isFinite;
    }

    public NameSet toNameSet() {
        return this._finiteSet.isEmpty() ? this._isFinite ? NameSet.EMPTY : NameSet.EVERYTHING : NameSet.newInstance(this._isFinite, this._finiteSet);
    }
}
