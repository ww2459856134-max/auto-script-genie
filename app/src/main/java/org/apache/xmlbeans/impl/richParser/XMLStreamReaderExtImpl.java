package org.apache.xmlbeans.impl.richParser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* loaded from: classes.dex */
public class XMLStreamReaderExtImpl implements XMLStreamReaderExt {
    private final CharSeqTrimWS _charSeq;
    private String _defaultValue;
    private final XMLStreamReader _xmlStream;

    public XMLStreamReaderExtImpl(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader == null) {
            throw new IllegalArgumentException();
        }
        this._xmlStream = xMLStreamReader;
        this._charSeq = new CharSeqTrimWS(this);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public void close() throws XMLStreamException {
        this._xmlStream.close();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getAttributeBase64Value(int i2) throws XMLStreamException {
        byte[] bArrDecode = Base64.getMimeDecoder().decode(this._charSeq.reloadAtt(i2, 2).toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid base64Binary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigDecimal getAttributeBigDecimalValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexDecimal(this._charSeq.reloadAtt(i2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigInteger getAttributeBigIntegerValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexInteger(this._charSeq.reloadAtt(i2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public boolean getAttributeBooleanValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexBoolean(this._charSeq.reloadAtt(i2, 2));
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public byte getAttributeByteValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexByte(this._charSeq.reloadAtt(i2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public XmlCalendar getAttributeCalendarValue(int i2) throws XMLStreamException {
        try {
            return new GDateBuilder(this._charSeq.reloadAtt(i2, 2)).getCalendar();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getAttributeCount() {
        return this._xmlStream.getAttributeCount();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public Date getAttributeDateValue(int i2) throws XMLStreamException {
        try {
            return new GDateBuilder(this._charSeq.reloadAtt(i2, 2)).getDate();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public double getAttributeDoubleValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexDouble(this._charSeq.reloadAtt(i2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public float getAttributeFloatValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexFloat(this._charSeq.reloadAtt(i2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDate getAttributeGDateValue(int i2) throws XMLStreamException {
        try {
            return new GDate(this._charSeq.reloadAtt(i2, 2));
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDuration getAttributeGDurationValue(int i2) throws XMLStreamException {
        try {
            return new GDuration(this._charSeq.reloadAtt(i2, 2));
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getAttributeHexBinaryValue(int i2) throws XMLStreamException {
        byte[] bArrDecode = HexBin.decode(this._charSeq.reloadAtt(i2, 2).toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid hexBinary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public int getAttributeIntValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexInt(this._charSeq.reloadAtt(i2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeLocalName(int i2) {
        return this._xmlStream.getAttributeLocalName(i2);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public long getAttributeLongValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexLong(this._charSeq.reloadAtt(i2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public QName getAttributeName(int i2) {
        return this._xmlStream.getAttributeName(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeNamespace(int i2) {
        return this._xmlStream.getAttributeNamespace(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributePrefix(int i2) {
        return this._xmlStream.getAttributePrefix(i2);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public QName getAttributeQNameValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexQName(this._charSeq.reloadAtt(i2, 2), this._xmlStream.getNamespaceContext());
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e.getMessage(), this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public short getAttributeShortValue(int i2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexShort(this._charSeq.reloadAtt(i2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getAttributeStringValue(int i2) throws XMLStreamException {
        return this._xmlStream.getAttributeValue(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeType(int i2) {
        return this._xmlStream.getAttributeType(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeValue(String str, String str2) {
        return this._xmlStream.getAttributeValue(str, str2);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getBase64Value() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        byte[] bArrDecode = Base64.getMimeDecoder().decode(this._charSeq.toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid base64Binary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigDecimal getBigDecimalValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexDecimal(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigInteger getBigIntegerValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexInteger(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public boolean getBooleanValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexBoolean(this._charSeq);
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public byte getByteValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexByte(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public XmlCalendar getCalendarValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return new GDateBuilder(this._charSeq).getCalendar();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getCharacterEncodingScheme() {
        return this._xmlStream.getCharacterEncodingScheme();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public Date getDateValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return new GDateBuilder(this._charSeq).getDate();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public double getDoubleValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexDouble(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getElementText() throws XMLStreamException {
        return this._xmlStream.getElementText();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getEncoding() {
        return this._xmlStream.getEncoding();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getEventType() {
        return this._xmlStream.getEventType();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public float getFloatValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexFloat(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDate getGDateValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexGDate(this._charSeq);
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDuration getGDurationValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return new GDuration(this._charSeq);
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getHexBinaryValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        byte[] bArrDecode = HexBin.decode(this._charSeq.toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid hexBinary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public int getIntValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexInt(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getLocalName() {
        return this._xmlStream.getLocalName();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public Location getLocation() {
        return this._xmlStream.getLocation();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public long getLongValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexLong(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public QName getName() {
        return this._xmlStream.getName();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public NamespaceContext getNamespaceContext() {
        return this._xmlStream.getNamespaceContext();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getNamespaceCount() {
        return this._xmlStream.getNamespaceCount();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespacePrefix(int i2) {
        return this._xmlStream.getNamespacePrefix(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespaceURI(String str) {
        return this._xmlStream.getNamespaceURI(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getPIData() {
        return this._xmlStream.getPIData();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getPITarget() {
        return this._xmlStream.getPITarget();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getPrefix() {
        return this._xmlStream.getPrefix();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public Object getProperty(String str) throws IllegalArgumentException {
        return this._xmlStream.getProperty(str);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public QName getQNameValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexQName(this._charSeq, this._xmlStream.getNamespaceContext());
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e.getMessage(), this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public short getShortValue() throws InvalidLexicalValueException, XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexShort(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getStringValue() throws XMLStreamException {
        this._charSeq.reload(1);
        return this._charSeq.toString();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getText() {
        return this._xmlStream.getText();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public char[] getTextCharacters() {
        return this._xmlStream.getTextCharacters();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getTextLength() {
        return this._xmlStream.getTextLength();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getTextStart() {
        return this._xmlStream.getTextStart();
    }

    public XMLStreamReader getUnderlyingXmlStream() {
        return this._xmlStream;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getVersion() {
        return this._xmlStream.getVersion();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean hasName() {
        return this._xmlStream.hasName();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean hasNext() throws XMLStreamException {
        return this._xmlStream.hasNext();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean hasText() {
        return this._xmlStream.hasText();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isAttributeSpecified(int i2) {
        return this._xmlStream.isAttributeSpecified(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isCharacters() {
        return this._xmlStream.isCharacters();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isEndElement() {
        return this._xmlStream.isEndElement();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isStandalone() {
        return this._xmlStream.isStandalone();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isStartElement() {
        return this._xmlStream.isStartElement();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isWhiteSpace() {
        return this._xmlStream.isWhiteSpace();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int next() throws XMLStreamException {
        return this._xmlStream.next();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int nextTag() throws XMLStreamException {
        return this._xmlStream.nextTag();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public void require(int i2, String str, String str2) throws XMLStreamException {
        this._xmlStream.require(i2, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public void setDefaultValue(String str) throws XMLStreamException {
        this._defaultValue = str;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean standaloneSet() {
        return this._xmlStream.standaloneSet();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getAttributeStringValue(int i2, int i3) throws XMLStreamException {
        return XmlWhitespace.collapse(this._xmlStream.getAttributeValue(i2), i3);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeValue(int i2) {
        return this._xmlStream.getAttributeValue(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespaceURI(int i2) {
        return this._xmlStream.getNamespaceURI(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getTextCharacters(int i2, char[] cArr, int i3, int i4) throws XMLStreamException {
        return this._xmlStream.getTextCharacters(i2, cArr, i3, i4);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigDecimal getAttributeBigDecimalValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexDecimal(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigInteger getAttributeBigIntegerValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexInteger(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public boolean getAttributeBooleanValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexBoolean(this._charSeq.reloadAtt(str, str2, 2));
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public byte getAttributeByteValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexByte(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public double getAttributeDoubleValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexDouble(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public float getAttributeFloatValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexFloat(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDate getAttributeGDateValue(String str, String str2) throws XMLStreamException {
        try {
            return new GDate(this._charSeq.reloadAtt(str, str2, 2));
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDuration getAttributeGDurationValue(String str, String str2) throws XMLStreamException {
        try {
            return new GDuration(this._charSeq.reloadAtt(str, str2, 2));
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public int getAttributeIntValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexInt(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public long getAttributeLongValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexLong(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public short getAttributeShortValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexShort(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getAttributeStringValue(String str, String str2) throws XMLStreamException {
        return this._charSeq.reloadAtt(str, str2, 1).toString();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespaceURI() {
        return this._xmlStream.getNamespaceURI();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getStringValue(int i2) throws XMLStreamException {
        this._charSeq.reload(1);
        return XmlWhitespace.collapse(this._charSeq.toString(), i2);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public XmlCalendar getAttributeCalendarValue(String str, String str2) throws XMLStreamException {
        try {
            return new GDateBuilder(this._charSeq.reloadAtt(str, str2, 2)).getCalendar();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public Date getAttributeDateValue(String str, String str2) throws XMLStreamException {
        try {
            return new GDateBuilder(this._charSeq.reloadAtt(str, str2, 2)).getDate();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getAttributeStringValue(String str, String str2, int i2) throws XMLStreamException {
        return XmlWhitespace.collapse(this._xmlStream.getAttributeValue(str, str2), i2);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getAttributeBase64Value(String str, String str2) throws XMLStreamException {
        byte[] bArrDecode = Base64.getMimeDecoder().decode(this._charSeq.reloadAtt(str, str2, 2).toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid base64Binary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getAttributeHexBinaryValue(String str, String str2) throws XMLStreamException {
        byte[] bArrDecode = HexBin.decode(this._charSeq.reloadAtt(str, str2, 2).toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid hexBinary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public QName getAttributeQNameValue(String str, String str2) throws XMLStreamException {
        try {
            return XsTypeConverter.lexQName(this._charSeq.reloadAtt(str, str2, 2), this._xmlStream.getNamespaceContext());
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e.getMessage(), this._charSeq.getLocation());
        }
    }

    private static class CharSeqTrimWS implements CharSequence {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static int INITIAL_SIZE = 100;
        static final int XMLWHITESPACE_PRESERVE = 1;
        static final int XMLWHITESPACE_TRIM = 2;
        private boolean _hasText;
        private int _start;
        private String _toStringValue;
        private XMLStreamReaderExtImpl _xmlSteam;
        private char[] _buf = new char[INITIAL_SIZE];
        private int _length = 0;
        private int _nonWSStart = 0;
        private int _nonWSEnd = 0;
        private final ExtLocation _location = new ExtLocation();

        private static class ExtLocation implements Location {
            private int _col;
            private boolean _isSet = false;
            private int _line;
            private int _off;
            private String _pid;
            private String _sid;

            ExtLocation() {
            }

            @Override // org.apache.poi.javax.xml.stream.Location
            public int getCharacterOffset() {
                if (this._isSet) {
                    return this._off;
                }
                throw new IllegalStateException();
            }

            @Override // org.apache.poi.javax.xml.stream.Location
            public int getColumnNumber() {
                if (this._isSet) {
                    return this._col;
                }
                throw new IllegalStateException();
            }

            @Override // org.apache.poi.javax.xml.stream.Location
            public int getLineNumber() {
                if (this._isSet) {
                    return this._line;
                }
                throw new IllegalStateException();
            }

            @Override // org.apache.poi.javax.xml.stream.Location
            public String getPublicId() {
                if (this._isSet) {
                    return this._pid;
                }
                throw new IllegalStateException();
            }

            @Override // org.apache.poi.javax.xml.stream.Location
            public String getSystemId() {
                if (this._isSet) {
                    return this._sid;
                }
                throw new IllegalStateException();
            }

            void reset() {
                this._isSet = false;
            }

            void set(Location location) {
                if (this._isSet) {
                    return;
                }
                this._isSet = true;
                this._line = location.getLineNumber();
                this._col = location.getColumnNumber();
                this._off = location.getCharacterOffset();
                this._pid = location.getPublicId();
                this._sid = location.getSystemId();
            }
        }

        CharSeqTrimWS(XMLStreamReaderExtImpl xMLStreamReaderExtImpl) {
            this._xmlSteam = xMLStreamReaderExtImpl;
        }

        private void addEntityToBuffer() {
            String text = this._xmlSteam.getText();
            ensureBufferLength(text.length());
            text.getChars(0, text.length(), this._buf, this._length);
            this._length += text.length();
        }

        private void addTextToBuffer() {
            this._hasText = true;
            int textLength = this._xmlSteam.getTextLength();
            ensureBufferLength(textLength);
            System.arraycopy(this._xmlSteam.getTextCharacters(), this._xmlSteam.getTextStart(), this._buf, this._length, textLength);
            this._length += textLength;
        }

        private void ensureBufferLength(int i2) {
            int i3 = this._length;
            int i4 = i3 + i2;
            char[] cArr = this._buf;
            if (i4 > cArr.length) {
                char[] cArr2 = new char[i2 + i3];
                if (i3 > 0) {
                    System.arraycopy(cArr, 0, cArr2, 0, i3);
                }
                this._buf = cArr2;
            }
        }

        private void fillBuffer() throws XMLStreamException {
            int i2 = 0;
            this._length = 0;
            if (this._xmlSteam.getEventType() == 7) {
                this._xmlSteam.next();
            }
            if (this._xmlSteam.isStartElement()) {
                this._xmlSteam.next();
            }
            String str = null;
            int eventType = this._xmlSteam.getEventType();
            while (true) {
                if (eventType == 1) {
                    i2++;
                    str = "Unexpected element '" + this._xmlSteam.getName() + "' in text content.";
                    this._location.set(this._xmlSteam.getLocation());
                } else if (eventType == 2) {
                    this._location.set(this._xmlSteam.getLocation());
                    i2--;
                    if (i2 < 0) {
                        break;
                    }
                } else if (eventType != 4 && eventType != 6 && eventType != 12) {
                    if (eventType == 8) {
                        this._location.set(this._xmlSteam.getLocation());
                        break;
                    } else if (eventType == 9) {
                        this._location.set(this._xmlSteam.getLocation());
                        addEntityToBuffer();
                    }
                } else {
                    this._location.set(this._xmlSteam.getLocation());
                    if (i2 == 0) {
                        addTextToBuffer();
                    }
                }
                eventType = this._xmlSteam.next();
            }
            if (str != null) {
                throw new XMLStreamException(str);
            }
        }

        private void fillBufferFromString(CharSequence charSequence) {
            int length = charSequence.length();
            ensureBufferLength(length);
            for (int i2 = 0; i2 < length; i2++) {
                this._buf[i2] = charSequence.charAt(i2);
            }
            this._length = length;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i2) {
            return this._buf[this._nonWSStart + i2];
        }

        Location getLocation() {
            ExtLocation extLocation = new ExtLocation();
            extLocation.set(this._location);
            return extLocation;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this._nonWSEnd - this._nonWSStart;
        }

        void reload(int i2) throws XMLStreamException {
            this._toStringValue = null;
            this._location.reset();
            this._hasText = false;
            fillBuffer();
            if (i2 == 1) {
                this._nonWSStart = 0;
                this._nonWSEnd = this._length;
                if (!this._hasText && this._xmlSteam._defaultValue != null) {
                    this._length = 0;
                    fillBufferFromString(this._xmlSteam._defaultValue);
                }
            } else if (i2 == 2) {
                this._nonWSStart = 0;
                while (true) {
                    int i3 = this._nonWSStart;
                    if (i3 >= this._length || !XMLChar.isSpace(this._buf[i3])) {
                        break;
                    } else {
                        this._nonWSStart++;
                    }
                }
                int i4 = this._length;
                while (true) {
                    this._nonWSEnd = i4;
                    int i5 = this._nonWSEnd;
                    if (i5 <= this._nonWSStart || !XMLChar.isSpace(this._buf[i5 - 1])) {
                        break;
                    } else {
                        i4 = this._nonWSEnd - 1;
                    }
                }
                if (length() == 0 && this._xmlSteam._defaultValue != null) {
                    this._length = 0;
                    fillBufferFromString(this._xmlSteam._defaultValue);
                    this._nonWSStart = 0;
                    while (true) {
                        int i6 = this._nonWSStart;
                        if (i6 >= this._length || !XMLChar.isSpace(this._buf[i6])) {
                            break;
                        } else {
                            this._nonWSStart++;
                        }
                    }
                    int i7 = this._length;
                    while (true) {
                        this._nonWSEnd = i7;
                        int i8 = this._nonWSEnd;
                        if (i8 <= this._nonWSStart || !XMLChar.isSpace(this._buf[i8 - 1])) {
                            break;
                        } else {
                            i7 = this._nonWSEnd - 1;
                        }
                    }
                }
            }
            this._xmlSteam._defaultValue = null;
        }

        CharSequence reloadAtt(int i2, int i3) throws XMLStreamException {
            this._location.reset();
            this._location.set(this._xmlSteam.getLocation());
            String attributeValue = this._xmlSteam.getAttributeValue(i2);
            if (attributeValue == null && this._xmlSteam._defaultValue != null) {
                attributeValue = this._xmlSteam._defaultValue;
            }
            this._xmlSteam._defaultValue = null;
            int length = attributeValue.length();
            if (i3 == 1) {
                return attributeValue;
            }
            if (i3 != 2) {
                throw new IllegalStateException("unknown style");
            }
            int i4 = 0;
            while (i4 < length && XMLChar.isSpace(attributeValue.charAt(i4))) {
                i4++;
            }
            int i5 = length;
            while (i5 > i4 && XMLChar.isSpace(attributeValue.charAt(i5 - 1))) {
                i5--;
            }
            return (i4 == 0 && i5 == length) ? attributeValue : attributeValue.subSequence(i4, i5);
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i2, int i3) {
            return new String(this._buf, this._nonWSStart + i2, i3 - i2);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            String str = this._toStringValue;
            if (str != null) {
                return str;
            }
            char[] cArr = this._buf;
            int i2 = this._nonWSStart;
            String str2 = new String(cArr, i2, this._nonWSEnd - i2);
            this._toStringValue = str2;
            return str2;
        }

        CharSequence reloadAtt(String str, String str2, int i2) throws XMLStreamException {
            this._location.reset();
            this._location.set(this._xmlSteam.getLocation());
            String attributeValue = this._xmlSteam.getAttributeValue(str, str2);
            if (attributeValue == null && this._xmlSteam._defaultValue != null) {
                attributeValue = this._xmlSteam._defaultValue;
            }
            this._xmlSteam._defaultValue = null;
            int length = attributeValue.length();
            if (i2 == 1) {
                return attributeValue;
            }
            if (i2 == 2) {
                int i3 = 0;
                while (true) {
                    this._nonWSStart = i3;
                    int i4 = this._nonWSStart;
                    if (i4 >= length || !XMLChar.isSpace(attributeValue.charAt(i4))) {
                        break;
                    }
                    i3 = this._nonWSStart + 1;
                }
                this._nonWSEnd = length;
                while (true) {
                    int i5 = this._nonWSEnd;
                    if (i5 <= this._nonWSStart || !XMLChar.isSpace(attributeValue.charAt(i5 - 1))) {
                        break;
                    }
                    this._nonWSEnd--;
                }
                int i6 = this._nonWSStart;
                return (i6 == 0 && this._nonWSEnd == length) ? attributeValue : attributeValue.subSequence(i6, this._nonWSEnd);
            }
            throw new IllegalStateException("unknown style");
        }
    }
}
