package h.i.a;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
class a extends InputStream implements DataInput {
    private static final ByteOrder g = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: h, reason: collision with root package name */
    private static final ByteOrder f1333h = ByteOrder.BIG_ENDIAN;
    private DataInputStream c;
    private ByteOrder d;
    final int e;
    int f;

    public a(InputStream inputStream) throws IOException {
        this.d = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.c = dataInputStream;
        int iAvailable = dataInputStream.available();
        this.e = iAvailable;
        this.f = 0;
        this.c.mark(iAvailable);
    }

    public int a() {
        return this.f;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.c.available();
    }

    public long c() throws IOException {
        return readInt() & 4294967295L;
    }

    public void d(long j2) throws IOException {
        int i2 = this.f;
        if (i2 > j2) {
            this.f = 0;
            this.c.reset();
            this.c.mark(this.e);
        } else {
            j2 -= i2;
        }
        int i3 = (int) j2;
        if (skipBytes(i3) != i3) {
            throw new IOException("Couldn't seek up to the byteCount");
        }
    }

    public void f(ByteOrder byteOrder) {
        this.d = byteOrder;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.f++;
        return this.c.read();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        this.f++;
        return this.c.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        int i2 = this.f + 1;
        this.f = i2;
        if (i2 > this.e) {
            throw new EOFException();
        }
        int i3 = this.c.read();
        if (i3 >= 0) {
            return (byte) i3;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        this.f += 2;
        return this.c.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f + i3;
        this.f = i4;
        if (i4 > this.e) {
            throw new EOFException();
        }
        if (this.c.read(bArr, i2, i3) != i3) {
            throw new IOException("Couldn't read up to the length of buffer");
        }
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        int i2 = this.f + 4;
        this.f = i2;
        if (i2 > this.e) {
            throw new EOFException();
        }
        int i3 = this.c.read();
        int i4 = this.c.read();
        int i5 = this.c.read();
        int i6 = this.c.read();
        if ((i3 | i4 | i5 | i6) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == g) {
            return (i6 << 24) + (i5 << 16) + (i4 << 8) + i3;
        }
        if (byteOrder == f1333h) {
            return (i3 << 24) + (i4 << 16) + (i5 << 8) + i6;
        }
        throw new IOException("Invalid byte order: " + this.d);
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        int i2 = this.f + 8;
        this.f = i2;
        if (i2 > this.e) {
            throw new EOFException();
        }
        int i3 = this.c.read();
        int i4 = this.c.read();
        int i5 = this.c.read();
        int i6 = this.c.read();
        int i7 = this.c.read();
        int i8 = this.c.read();
        int i9 = this.c.read();
        int i10 = this.c.read();
        if ((i3 | i4 | i5 | i6 | i7 | i8 | i9 | i10) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == g) {
            return (i10 << 56) + (i9 << 48) + (i8 << 40) + (i7 << 32) + (i6 << 24) + (i5 << 16) + (i4 << 8) + i3;
        }
        if (byteOrder == f1333h) {
            return (i3 << 56) + (i4 << 48) + (i5 << 40) + (i6 << 32) + (i7 << 24) + (i8 << 16) + (i9 << 8) + i10;
        }
        throw new IOException("Invalid byte order: " + this.d);
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        int i2 = this.f + 2;
        this.f = i2;
        if (i2 > this.e) {
            throw new EOFException();
        }
        int i3 = this.c.read();
        int i4 = this.c.read();
        if ((i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == g) {
            return (short) ((i4 << 8) + i3);
        }
        if (byteOrder == f1333h) {
            return (short) ((i3 << 8) + i4);
        }
        throw new IOException("Invalid byte order: " + this.d);
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        this.f += 2;
        return this.c.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        this.f++;
        return this.c.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        int i2 = this.f + 2;
        this.f = i2;
        if (i2 > this.e) {
            throw new EOFException();
        }
        int i3 = this.c.read();
        int i4 = this.c.read();
        if ((i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == g) {
            return (i4 << 8) + i3;
        }
        if (byteOrder == f1333h) {
            return (i3 << 8) + i4;
        }
        throw new IOException("Invalid byte order: " + this.d);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i2) throws IOException {
        int iMin = Math.min(i2, this.e - this.f);
        int iSkipBytes = 0;
        while (iSkipBytes < iMin) {
            iSkipBytes += this.c.skipBytes(iMin - iSkipBytes);
        }
        this.f += iSkipBytes;
        return iSkipBytes;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.c.read(bArr, i2, i3);
        this.f += i4;
        return i4;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        int length = this.f + bArr.length;
        this.f = length;
        if (length <= this.e) {
            if (this.c.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
            return;
        }
        throw new EOFException();
    }

    public a(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }
}
