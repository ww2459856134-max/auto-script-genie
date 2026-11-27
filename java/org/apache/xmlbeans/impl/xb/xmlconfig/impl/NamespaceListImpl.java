package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList;

/* loaded from: classes2.dex */
public class NamespaceListImpl extends XmlUnionImpl implements NamespaceList, NamespaceList.Member, NamespaceList.Member2 {
    private static final long serialVersionUID = 1;

    public static class MemberImpl extends JavaStringEnumerationHolderEx implements NamespaceList.Member {
        private static final long serialVersionUID = 1;

        public MemberImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public static class MemberImpl2 extends XmlListImpl implements NamespaceList.Member2 {
        private static final long serialVersionUID = 1;

        public static class ItemImpl extends XmlUnionImpl implements NamespaceList.Member2.Item, XmlAnyURI, NamespaceList.Member2.Item.Member {
            private static final long serialVersionUID = 1;

            public static class MemberImpl extends JavaStringEnumerationHolderEx implements NamespaceList.Member2.Item.Member {
                private static final long serialVersionUID = 1;

                public MemberImpl(SchemaType schemaType) {
                    super(schemaType, false);
                }

                protected MemberImpl(SchemaType schemaType, boolean z) {
                    super(schemaType, z);
                }
            }

            public ItemImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected ItemImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }

        public MemberImpl2(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl2(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public NamespaceListImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    protected NamespaceListImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
