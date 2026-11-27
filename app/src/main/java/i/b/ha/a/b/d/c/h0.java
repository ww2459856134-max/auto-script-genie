package i.b.ha.a.b.d.c;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* loaded from: classes.dex */
final class h0 implements y1 {
    private static final byte[] c = {63};
    private static final String d = String.valueOf('?');
    private static final char[] e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final Charset a;
    private final boolean b;

    h0(Charset charset) {
        this.a = charset;
        this.b = z1.d(charset);
    }

    private static ByteBuffer d(CharsetEncoder charsetEncoder, CharBuffer charBuffer, ByteBuffer byteBuffer) {
        while (charBuffer.hasRemaining()) {
            if (charsetEncoder.encode(charBuffer, byteBuffer, false).isOverflow()) {
                byteBuffer = z1.c(byteBuffer, f(charsetEncoder, charBuffer.remaining()));
            }
        }
        return byteBuffer;
    }

    private static CharBuffer e(CharBuffer charBuffer, char c2) {
        charBuffer.position(0).limit(6);
        charBuffer.put('%');
        charBuffer.put('U');
        char[] cArr = e;
        charBuffer.put(cArr[(c2 >> '\f') & 15]);
        charBuffer.put(cArr[(c2 >> '\b') & 15]);
        charBuffer.put(cArr[(c2 >> 4) & 15]);
        charBuffer.put(cArr[c2 & 15]);
        charBuffer.flip();
        return charBuffer;
    }

    private static int f(CharsetEncoder charsetEncoder, int i2) {
        return (int) Math.ceil(i2 * charsetEncoder.averageBytesPerChar());
    }

    private static int g(CharsetEncoder charsetEncoder, int i2) {
        return (int) Math.ceil(charsetEncoder.maxBytesPerChar() + ((i2 - 1) * charsetEncoder.averageBytesPerChar()));
    }

    private CharsetDecoder h() {
        return !this.b ? this.a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT) : this.a.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(d);
    }

    private CharsetEncoder i() {
        return this.b ? this.a.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(c) : this.a.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    }

    @Override // i.b.ha.a.b.d.c.y1
    public ByteBuffer a(String str) {
        CharsetEncoder charsetEncoderI = i();
        CharBuffer charBufferWrap = CharBuffer.wrap(str);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(g(charsetEncoderI, charBufferWrap.remaining()));
        CharBuffer charBufferAllocate = null;
        while (charBufferWrap.hasRemaining()) {
            CoderResult coderResultEncode = charsetEncoderI.encode(charBufferWrap, byteBufferAllocate, false);
            if (!coderResultEncode.isUnmappable() && !coderResultEncode.isMalformed()) {
                if (!coderResultEncode.isOverflow()) {
                    if (coderResultEncode.isUnderflow() || coderResultEncode.isError()) {
                        break;
                    }
                } else {
                    byteBufferAllocate = z1.c(byteBufferAllocate, f(charsetEncoderI, charBufferWrap.remaining()));
                }
            } else {
                if (f(charsetEncoderI, coderResultEncode.length() * 6) > byteBufferAllocate.remaining()) {
                    int i2 = 0;
                    for (int iPosition = charBufferWrap.position(); iPosition < charBufferWrap.limit(); iPosition++) {
                        i2 += !charsetEncoderI.canEncode(charBufferWrap.get(iPosition)) ? 6 : 1;
                    }
                    byteBufferAllocate = z1.c(byteBufferAllocate, f(charsetEncoderI, i2) - byteBufferAllocate.remaining());
                }
                if (charBufferAllocate == null) {
                    charBufferAllocate = CharBuffer.allocate(6);
                }
                for (int i3 = 0; i3 < coderResultEncode.length(); i3++) {
                    e(charBufferAllocate, charBufferWrap.get());
                    byteBufferAllocate = d(charsetEncoderI, charBufferAllocate, byteBufferAllocate);
                }
            }
        }
        charsetEncoderI.encode(charBufferWrap, byteBufferAllocate, true);
        byteBufferAllocate.limit(byteBufferAllocate.position());
        byteBufferAllocate.rewind();
        return byteBufferAllocate;
    }

    @Override // i.b.ha.a.b.d.c.y1
    public String b(byte[] bArr) throws IOException {
        return h().decode(ByteBuffer.wrap(bArr)).toString();
    }

    @Override // i.b.ha.a.b.d.c.y1
    public boolean c(String str) {
        return i().canEncode(str);
    }
}
