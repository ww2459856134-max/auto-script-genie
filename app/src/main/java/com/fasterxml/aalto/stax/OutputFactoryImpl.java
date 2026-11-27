package com.fasterxml.aalto.stax;

import i.e.a.g.d;
import i.e.a.i.c;
import i.e.a.k.a;
import i.e.a.k.e;
import i.e.a.k.g;
import i.e.a.k.m;
import i.e.a.k.q;
import i.e.a.k.u;
import i.e.a.k.w;
import i.e.a.k.x;
import i.e.a.l.b;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import n.b.a.f;
import n.b.a.j;
import n.b.a.m.k;
import org.apache.poi.javax.xml.stream.XMLEventWriter;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamWriter;

/* loaded from: classes.dex */
public final class OutputFactoryImpl extends f {
    protected final w _config = new w();

    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private j createSW(OutputStream outputStream, Writer writer, String str, boolean z) throws XMLStreamException {
        e eVar;
        u uVarX;
        x aVar;
        u uVarV;
        w wVarN = this._config.n();
        if (z) {
            wVarN.p(true);
        }
        if (writer == null) {
            if (str == null) {
                str = "UTF-8";
            } else if (str != "UTF-8" && str != "ISO-8859-1" && str != "US-ASCII") {
                str = b.d(str);
            }
            wVarN.D(str);
            try {
                if (str == "UTF-8") {
                    aVar = new q(wVarN, outputStream);
                    uVarV = this._config.A(aVar);
                } else if (str == "ISO-8859-1") {
                    aVar = new i.e.a.k.f(wVarN, outputStream);
                    uVarV = this._config.y(aVar);
                } else if (str == "US-ASCII") {
                    aVar = new a(wVarN, outputStream);
                    uVarV = this._config.v(aVar);
                } else {
                    eVar = new e(wVarN, new OutputStreamWriter(outputStream, str));
                    uVarX = this._config.x(eVar);
                }
                return !wVarN.L() ? new m(wVarN, aVar, uVarV) : new g(wVarN, aVar, uVarV);
            } catch (IOException e) {
                throw new XMLStreamException(e);
            }
        }
        if (str == null) {
            str = b.c(writer);
        }
        if (str != null) {
            wVarN.D(str);
        }
        eVar = new e(wVarN, writer);
        uVarX = this._config.x(eVar);
        u uVar = uVarX;
        aVar = eVar;
        uVarV = uVar;
        if (!wVarN.L()) {
        }
    }

    public void configureForRobustness() {
        this._config.k();
    }

    public void configureForSpeed() {
        this._config.l();
    }

    public void configureForXmlConformance() {
        this._config.m();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public XMLEventWriter createXMLEventWriter(OutputStream outputStream) throws XMLStreamException {
        return createXMLEventWriter(outputStream, (String) null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream) throws XMLStreamException {
        return createXMLStreamWriter(outputStream, (String) null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public Object getProperty(String str) {
        return this._config.a(str, true);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public boolean isPropertySupported(String str) {
        return this._config.e(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public void setProperty(String str, Object obj) {
        this._config.g(str, obj);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public XMLEventWriter createXMLEventWriter(OutputStream outputStream, String str) throws XMLStreamException {
        return new n.b.a.m.f(createSW(outputStream, null, str, false));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream, String str) throws XMLStreamException {
        return createSW(outputStream, null, str, false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public XMLEventWriter createXMLEventWriter(Result result) throws XMLStreamException {
        return new n.b.a.m.f(createSW(result));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public XMLStreamWriter createXMLStreamWriter(Result result) throws XMLStreamException {
        return createSW(result);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public XMLEventWriter createXMLEventWriter(Writer writer) throws XMLStreamException {
        return new n.b.a.m.f(createSW(null, writer, null, false));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLOutputFactory
    public XMLStreamWriter createXMLStreamWriter(Writer writer) throws XMLStreamException {
        return createSW(null, writer, null, false);
    }

    public XMLEventWriter createXMLEventWriter(Writer writer, String str) throws XMLStreamException {
        return new n.b.a.m.f(createSW(null, writer, str, false));
    }

    public j createXMLStreamWriter(Writer writer, String str) throws XMLStreamException {
        return createSW(null, writer, str, false);
    }

    public XMLEventWriter createXMLEventWriter(XMLStreamWriter xMLStreamWriter) throws XMLStreamException {
        return new n.b.a.m.f(k.e(xMLStreamWriter));
    }

    private j createSW(Result result) throws XMLStreamException {
        String systemId;
        boolean z;
        Writer writer;
        OutputStream outputStream;
        if (result instanceof StreamResult) {
            StreamResult streamResult = (StreamResult) result;
            systemId = streamResult.getSystemId();
            outputStream = streamResult.getOutputStream();
            writer = outputStream == null ? streamResult.getWriter() : null;
            z = false;
        } else if (result instanceof SAXResult) {
            systemId = ((SAXResult) result).getSystemId();
            if (systemId == null || systemId.length() == 0) {
                throw new i.e.a.i.e("Can not create a stream writer for a SAXResult that does not have System Id (support for using SAX input source not implemented)");
            }
            z = true;
            writer = null;
            outputStream = null;
        } else {
            if (result instanceof DOMResult) {
                return d.g(this._config.n(), (DOMResult) result);
            }
            throw new IllegalArgumentException("Can not create XMLStreamWriter for Result type " + result.getClass() + " (unrecognized type)");
        }
        if (outputStream != null) {
            return createSW(outputStream, null, null, z);
        }
        if (writer != null) {
            return createSW(null, writer, null, z);
        }
        if (systemId != null && systemId.length() > 0) {
            try {
                return createSW(i.e.a.l.k.d(i.e.a.l.k.f(systemId)), null, null, true);
            } catch (IOException e) {
                throw new c(e);
            }
        }
        throw new i.e.a.i.e("Can not create XMLStreamWriter for passed-in Result -- neither writer, output stream nor system id (to create one) was accessible");
    }
}
