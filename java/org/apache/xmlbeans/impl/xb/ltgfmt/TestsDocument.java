package org.apache.xmlbeans.impl.xb.ltgfmt;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface TestsDocument extends XmlObject {
    public static final DocumentFactory<TestsDocument> Factory;
    public static final SchemaType type;

    public interface Tests extends XmlObject {
        public static final ElementFactory<Tests> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Tests> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "tests9d6eelemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        TestCase addNewTest();

        TestCase getTestArray(int i2);

        TestCase[] getTestArray();

        List<TestCase> getTestList();

        TestCase insertNewTest(int i2);

        void removeTest(int i2);

        void setTestArray(int i2, TestCase testCase);

        void setTestArray(TestCase[] testCaseArr);

        int sizeOfTestArray();
    }

    static {
        DocumentFactory<TestsDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "tests5621doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Tests addNewTests();

    Tests getTests();

    void setTests(Tests tests);
}
