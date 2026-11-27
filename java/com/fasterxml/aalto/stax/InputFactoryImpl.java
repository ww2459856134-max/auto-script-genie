package com.fasterxml.aalto.stax;

import i.e.a.a;
import i.e.a.h.b;
import i.e.a.i.c;
import i.e.a.j.g;
import i.e.a.j.j;
import i.e.a.j.z;
import i.e.a.l.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.ByteBuffer;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import n.b.a.d;
import n.b.a.i;
import n.b.a.m.h;
import n.b.a.m.n.p;
import n.b.a.m.n.q;
import org.apache.poi.javax.xml.stream.EventFilter;
import org.apache.poi.javax.xml.stream.StreamFilter;
import org.apache.poi.javax.xml.stream.XMLEventReader;
import org.apache.poi.javax.xml.stream.XMLReporter;
import org.apache.poi.javax.xml.stream.XMLResolver;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.javax.xml.stream.util.XMLEventAllocator;
import org.xml.sax.InputSource;

/* loaded from: classes.dex */
public final class InputFactoryImpl extends a {
    protected XMLEventAllocator _allocator = null;
    final z _config = new z();

    public void configureForConvenience() {
        this._config.m();
    }

    public void configureForLowMemUsage() {
        this._config.n();
    }

    public void configureForRoundTripping() {
        this._config.o();
    }

    public void configureForSpeed() {
        this._config.p();
    }

    public void configureForXmlConformance() {
        this._config.q();
    }

    public d constructER(i iVar) {
        return new b(createEventAllocator(), iVar);
    }

    protected i constructSR(InputStream inputStream, String str, boolean z) throws XMLStreamException {
        return StreamReaderImpl.construct(g.u(getNonSharedConfig(null, null, str, z, false), inputStream));
    }

    protected i constructSR2(n.b.a.l.a aVar, boolean z) throws XMLStreamException {
        z nonSharedConfig = getNonSharedConfig(aVar.d(), aVar.getSystemId(), aVar.c(), z, true);
        try {
            InputStream inputStreamA = aVar.a();
            if (inputStreamA != null) {
                return StreamReaderImpl.construct(g.u(nonSharedConfig, inputStreamA));
            }
            Reader readerB = aVar.b();
            if (readerB != null) {
                return StreamReaderImpl.construct(j.s(nonSharedConfig, readerB));
            }
            throw new IllegalArgumentException("Can not create stream reader for given Stax2Source: neither InputStream nor Reader available");
        } catch (IOException e) {
            throw new c(e);
        }
    }

    public i.e.a.b<Object> createAsyncFor(byte[] bArr) throws XMLStreamException {
        return createAsyncFor(bArr, 0, bArr.length);
    }

    public i.e.a.b<Object> createAsyncForByteArray() {
        z nonSharedConfig = getNonSharedConfig(null, null, null, false, false);
        nonSharedConfig.R("UTF-8");
        return new i.e.a.f.d(new i.e.a.f.a(nonSharedConfig));
    }

    public i.e.a.b<Object> createAsyncForByteBuffer() {
        z nonSharedConfig = getNonSharedConfig(null, null, null, false, false);
        nonSharedConfig.R("UTF-8");
        return new i.e.a.f.d(new i.e.a.f.b(nonSharedConfig));
    }

    protected XMLEventAllocator createEventAllocator() {
        XMLEventAllocator xMLEventAllocator = this._allocator;
        return xMLEventAllocator != null ? xMLEventAllocator.newInstance() : this._config.g0() ? i.e.a.h.a.f() : i.e.a.h.a.g();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLEventReader createFilteredReader(XMLEventReader xMLEventReader, EventFilter eventFilter) {
        return new q(p.a(xMLEventReader), eventFilter);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(InputStream inputStream) throws XMLStreamException {
        return createXMLEventReader(inputStream, (String) null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(InputStream inputStream) throws XMLStreamException {
        return constructSR(inputStream, (String) null, false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLEventAllocator getEventAllocator() {
        return this._allocator;
    }

    public z getNonSharedConfig(String str, String str2, String str3, boolean z, boolean z2) {
        z zVarR = this._config.r(str2, str, str3);
        if (z) {
            zVarR.v(false);
        }
        if (z2) {
            zVarR.t(true);
        }
        return zVarR;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public Object getProperty(String str) {
        return this._config.a(str, true);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLReporter getXMLReporter() {
        return this._config.J();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLResolver getXMLResolver() {
        return this._config.K();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public boolean isPropertySupported(String str) {
        return this._config.e(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public void setEventAllocator(XMLEventAllocator xMLEventAllocator) {
        this._allocator = xMLEventAllocator;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public void setProperty(String str, Object obj) {
        this._config.g(str, obj);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public void setXMLReporter(XMLReporter xMLReporter) {
        this._config.S(xMLReporter);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public void setXMLResolver(XMLResolver xMLResolver) {
        this._config.T(xMLResolver);
    }

    public i.e.a.b<Object> createAsyncFor(byte[] bArr, int i2, int i3) throws XMLStreamException {
        z nonSharedConfig = getNonSharedConfig(null, null, null, false, false);
        nonSharedConfig.R("UTF-8");
        i.e.a.f.a aVar = new i.e.a.f.a(nonSharedConfig);
        aVar.G1(bArr, i2, i3);
        return new i.e.a.f.d(aVar);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLStreamReader createFilteredReader(XMLStreamReader xMLStreamReader, StreamFilter streamFilter) throws XMLStreamException {
        n.b.a.m.g gVar = new n.b.a.m.g(xMLStreamReader, streamFilter);
        if (!streamFilter.accept(gVar)) {
            gVar.next();
        }
        return gVar;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(InputStream inputStream, String str) throws XMLStreamException {
        return constructER(constructSR(inputStream, str, true));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(InputStream inputStream, String str) throws XMLStreamException {
        return constructSR(inputStream, str, false);
    }

    protected i constructSR(String str, Reader reader, boolean z) throws XMLStreamException {
        return StreamReaderImpl.construct(j.s(getNonSharedConfig(null, str, null, z, false), reader));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(Reader reader) throws XMLStreamException {
        return createXMLEventReader((String) null, reader);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException {
        return constructSR((String) null, reader, false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(Source source) throws XMLStreamException {
        return constructER(constructSR(source, true));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(String str, Reader reader) throws XMLStreamException {
        return constructSR(str, reader, false);
    }

    protected i constructSR(String str, InputStream inputStream, boolean z) throws XMLStreamException {
        return StreamReaderImpl.construct(g.u(getNonSharedConfig(null, str, null, z, false), inputStream));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(String str, InputStream inputStream) throws XMLStreamException {
        return constructER(constructSR(str, inputStream, true));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(Source source) throws XMLStreamException {
        return constructSR(source, false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(String str, Reader reader) throws XMLStreamException {
        return constructER(constructSR(str, reader, true));
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(String str, InputStream inputStream) throws XMLStreamException {
        return constructSR(str, inputStream, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    protected i constructSR(Source source, boolean z) throws XMLStreamException {
        String systemId;
        Reader characterStream;
        String str;
        String str2;
        ?? r2;
        String publicId = null;
        String encoding = null;
        if (source instanceof StreamSource) {
            StreamSource streamSource = (StreamSource) source;
            systemId = streamSource.getSystemId();
            String publicId2 = streamSource.getPublicId();
            InputStream inputStream = streamSource.getInputStream();
            reader = inputStream == null ? streamSource.getReader() : null;
            str = publicId2;
            str2 = null;
            r2 = inputStream;
        } else if (source instanceof SAXSource) {
            SAXSource sAXSource = (SAXSource) source;
            systemId = sAXSource.getSystemId();
            InputSource inputSource = sAXSource.getInputSource();
            if (inputSource != null) {
                systemId = inputSource.getSystemId();
                publicId = inputSource.getPublicId();
                encoding = inputSource.getEncoding();
                ?? byteStream = inputSource.getByteStream();
                characterStream = byteStream == 0 ? inputSource.getCharacterStream() : null;
                reader = byteStream;
            } else {
                characterStream = null;
            }
            str = publicId;
            str2 = encoding;
            r2 = reader;
            reader = characterStream;
        } else {
            if (source instanceof DOMSource) {
                return i.e.a.g.c.t((DOMSource) source, getNonSharedConfig(null, null, null, z, false));
            }
            throw new IllegalArgumentException("Can not instantiate StAX reader for XML source type " + source.getClass() + " (unrecognized type)");
        }
        if (r2 != 0) {
            return StreamReaderImpl.construct(g.u(getNonSharedConfig(str, systemId, str2, z, false), r2));
        }
        if (reader != null) {
            return StreamReaderImpl.construct(j.s(getNonSharedConfig(str, systemId, str2, z, false), reader));
        }
        if (systemId != null && systemId.length() > 0) {
            try {
                return StreamReaderImpl.construct(g.u(getNonSharedConfig(str, systemId, str2, z, true), k.c(k.f(systemId))));
            } catch (IOException e) {
                throw new c(e);
            }
        }
        throw new XMLStreamException("Can not create Stax reader for the Source passed -- neither reader, input stream nor system id was accessible; can not use other types of sources (like embedded SAX streams)");
    }

    public i.e.a.b<Object> createAsyncFor(ByteBuffer byteBuffer) throws XMLStreamException {
        z nonSharedConfig = getNonSharedConfig(null, null, null, false, false);
        nonSharedConfig.R("UTF-8");
        i.e.a.f.b bVar = new i.e.a.f.b(nonSharedConfig);
        bVar.G1(byteBuffer);
        return new i.e.a.f.d(bVar);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        return constructER(h.a(xMLStreamReader));
    }

    public i createXMLStreamReader(URL url) throws XMLStreamException {
        return constructSR(url, false);
    }

    public d createXMLEventReader(URL url) throws XMLStreamException {
        return constructER(constructSR(url, true));
    }

    public i createXMLStreamReader(File file) throws XMLStreamException {
        return constructSR(file, false);
    }

    public d createXMLEventReader(File file) throws XMLStreamException {
        return constructER(constructSR(file, true));
    }

    protected i constructSR(URL url, boolean z) throws XMLStreamException {
        try {
            return StreamReaderImpl.construct(g.u(getNonSharedConfig(k.g(url), null, null, z, true), k.c(url)));
        } catch (IOException e) {
            throw new c(e);
        }
    }

    protected i constructSR(File file, boolean z) throws XMLStreamException {
        try {
            return StreamReaderImpl.construct(g.u(getNonSharedConfig(k.a(file), null, null, z, true), new FileInputStream(file)));
        } catch (IOException e) {
            throw new c(e);
        }
    }
}
