package i.e.a.f;

import com.fasterxml.aalto.stax.StreamReaderImpl;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public class d<F> extends StreamReaderImpl implements i.e.a.b<F> {
    public d(c cVar) {
        super(cVar);
        this._currToken = 257;
    }

    @Override // com.fasterxml.aalto.stax.StreamReaderImpl
    protected void _reportNonTextEvent(int i2) throws XMLStreamException {
        if (i2 == 257) {
            throwWfe("Can not use text-aggregating methods with non-blocking parser, as they (may) require blocking");
        }
        super._reportNonTextEvent(i2);
    }
}
