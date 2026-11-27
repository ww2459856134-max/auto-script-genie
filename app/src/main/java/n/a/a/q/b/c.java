package n.a.a.q.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import n.a.a.j.m;
import n.a.a.n.d.p0;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument;

/* loaded from: classes.dex */
public class c extends n.a.a.j.c implements b {
    private CTComments c;

    public c() {
        CTComments cTCommentsNewInstance = CTComments.Factory.newInstance();
        this.c = cTCommentsNewInstance;
        cTCommentsNewInstance.addNewCommentList();
        this.c.addNewAuthors().addAuthor("");
    }

    public void I(InputStream inputStream) throws IOException {
        try {
            this.c = CommentsDocument.Factory.parse(inputStream, m.a).getComments();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void J(OutputStream outputStream) throws IOException {
        CommentsDocument commentsDocumentNewInstance = CommentsDocument.Factory.newInstance();
        commentsDocumentNewInstance.setComments(this.c);
        commentsDocumentNewInstance.save(outputStream, m.a);
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            J(outputStreamO);
            if (outputStreamO != null) {
                outputStreamO.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamO != null) {
                    try {
                        outputStreamO.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // n.a.a.q.b.b
    public void p(p0 p0Var) {
    }

    public c(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
        InputStream inputStreamM = mVar.m();
        try {
            I(inputStreamM);
            if (inputStreamM != null) {
                inputStreamM.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamM != null) {
                    try {
                        inputStreamM.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
