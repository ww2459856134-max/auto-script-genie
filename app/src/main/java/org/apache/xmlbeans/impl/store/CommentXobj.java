package org.apache.xmlbeans.impl.store;

import org.w3c.dom.Comment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
class CommentXobj extends NodeXobj implements Comment {
    CommentXobj(Locale locale) {
        super(locale, 4, 8);
    }

    @Override // org.w3c.dom.CharacterData
    public void appendData(String str) {
        DomImpl._characterData_appendData(this, str);
    }

    @Override // org.w3c.dom.CharacterData
    public void deleteData(int i2, int i3) {
        DomImpl._characterData_deleteData(this, i2, i3);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public NodeList getChildNodes() {
        return DomImpl._emptyNodeList;
    }

    @Override // org.w3c.dom.CharacterData
    public String getData() {
        return DomImpl._characterData_getData(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public Node getFirstChild() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.NodeList, org.w3c.dom.CharacterData
    public int getLength() {
        return DomImpl._characterData_getLength(this);
    }

    @Override // org.w3c.dom.CharacterData
    public void insertData(int i2, String str) {
        DomImpl._characterData_insertData(this, i2, str);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale locale) {
        return new CommentXobj(locale);
    }

    @Override // org.w3c.dom.CharacterData
    public void replaceData(int i2, int i3, String str) {
        DomImpl._characterData_replaceData(this, i2, i3, str);
    }

    @Override // org.w3c.dom.CharacterData
    public void setData(String str) {
        DomImpl._characterData_setData(this, str);
    }

    @Override // org.w3c.dom.CharacterData
    public String substringData(int i2, int i3) {
        return DomImpl._characterData_substringData(this, i2, i3);
    }
}
