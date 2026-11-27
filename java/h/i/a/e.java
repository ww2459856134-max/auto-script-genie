package h.i.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class e {
    private static final c A;
    private static final c[] B;
    private static final c[] C;
    private static final c[] D;
    private static final c[] E;
    static final c[][] F;
    private static final c[] G;
    private static final HashMap<Integer, c>[] H;
    private static final HashMap<String, c>[] I;
    private static final HashSet<String> J;
    private static final HashMap<Integer, Integer> K;
    static final Charset L;
    static final byte[] M;

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f1334m;

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f1335n;

    /* renamed from: o, reason: collision with root package name */
    static final byte[] f1336o;
    private static final byte[] p;
    private static final byte[] q;
    private static SimpleDateFormat r;
    static final String[] s;
    static final int[] t;
    static final byte[] u;
    private static final c[] v;
    private static final c[] w;
    private static final c[] x;
    private static final c[] y;
    private static final c[] z;
    private final String a;
    private final AssetManager.AssetInputStream b;
    private int c;
    private final HashMap<String, b>[] d;
    private Set<Integer> e;
    private ByteOrder f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1337h;

    /* renamed from: i, reason: collision with root package name */
    private int f1338i;

    /* renamed from: j, reason: collision with root package name */
    private int f1339j;

    /* renamed from: k, reason: collision with root package name */
    private int f1340k;

    /* renamed from: l, reason: collision with root package name */
    private int f1341l;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        f1334m = new int[]{8, 8, 8};
        f1335n = new int[]{8};
        f1336o = new byte[]{-1, -40, -1};
        p = new byte[]{79, 76, 89, 77, 80, 0};
        q = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        s = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
        t = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        u = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        c[] cVarArr = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", BaseQuickAdapter.HEADER_VIEW, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
        v = cVarArr;
        c[] cVarArr2 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        w = cVarArr2;
        c[] cVarArr3 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        x = cVarArr3;
        c[] cVarArr4 = {new c("InteroperabilityIndex", 1, 2)};
        y = cVarArr4;
        c[] cVarArr5 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", BaseQuickAdapter.HEADER_VIEW, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        z = cVarArr5;
        A = new c("StripOffsets", BaseQuickAdapter.HEADER_VIEW, 3);
        c[] cVarArr6 = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
        B = cVarArr6;
        c[] cVarArr7 = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
        C = cVarArr7;
        c[] cVarArr8 = {new c("AspectFrame", 4371, 3)};
        D = cVarArr8;
        c[] cVarArr9 = {new c("ColorSpace", 55, 3)};
        E = cVarArr9;
        c[][] cVarArr10 = {cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr, cVarArr6, cVarArr7, cVarArr8, cVarArr9};
        F = cVarArr10;
        G = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        H = new HashMap[cVarArr10.length];
        I = new HashMap[cVarArr10.length];
        J = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        K = new HashMap<>();
        Charset charsetForName = Charset.forName("US-ASCII");
        L = charsetForName;
        M = "Exif\u0000\u0000".getBytes(charsetForName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        r = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            c[][] cVarArr11 = F;
            if (i2 >= cVarArr11.length) {
                HashMap<Integer, Integer> map = K;
                c[] cVarArr12 = G;
                map.put(Integer.valueOf(cVarArr12[0].a), 5);
                map.put(Integer.valueOf(cVarArr12[1].a), 1);
                map.put(Integer.valueOf(cVarArr12[2].a), 2);
                map.put(Integer.valueOf(cVarArr12[3].a), 3);
                map.put(Integer.valueOf(cVarArr12[4].a), 7);
                map.put(Integer.valueOf(cVarArr12[5].a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            H[i2] = new HashMap<>();
            I[i2] = new HashMap<>();
            for (c cVar : cVarArr11[i2]) {
                H[i2].put(Integer.valueOf(cVar.a), cVar);
                I[i2].put(cVar.b, cVar);
            }
            i2++;
        }
    }

    public e(InputStream inputStream) throws IOException {
        c[][] cVarArr = F;
        this.d = new HashMap[cVarArr.length];
        this.e = new HashSet(cVarArr.length);
        this.f = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        this.a = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.b = (AssetManager.AssetInputStream) inputStream;
        } else {
            this.b = null;
        }
        t(inputStream);
    }

    private void A(int i2, int i3) throws Throwable {
        if (this.d[i2].isEmpty() || this.d[i3].isEmpty()) {
            return;
        }
        b bVar = this.d[i2].get("ImageLength");
        b bVar2 = this.d[i2].get("ImageWidth");
        b bVar3 = this.d[i3].get("ImageLength");
        b bVar4 = this.d[i3].get("ImageWidth");
        if (bVar == null || bVar2 == null || bVar3 == null || bVar4 == null) {
            return;
        }
        int i4 = bVar.i(this.f);
        int i5 = bVar2.i(this.f);
        int i6 = bVar3.i(this.f);
        int i7 = bVar4.i(this.f);
        if (i4 >= i6 || i5 >= i7) {
            return;
        }
        HashMap<String, b>[] mapArr = this.d;
        HashMap<String, b> map = mapArr[i2];
        mapArr[i2] = mapArr[i3];
        mapArr[i3] = map;
    }

    private void B(a aVar, int i2) throws Throwable {
        b bVarF;
        b bVarF2;
        b bVar = this.d[i2].get("DefaultCropSize");
        b bVar2 = this.d[i2].get("SensorTopBorder");
        b bVar3 = this.d[i2].get("SensorLeftBorder");
        b bVar4 = this.d[i2].get("SensorBottomBorder");
        b bVar5 = this.d[i2].get("SensorRightBorder");
        if (bVar == null) {
            if (bVar2 == null || bVar3 == null || bVar4 == null || bVar5 == null) {
                y(aVar, i2);
                return;
            }
            int i3 = bVar2.i(this.f);
            int i4 = bVar4.i(this.f);
            int i5 = bVar5.i(this.f);
            int i6 = bVar3.i(this.f);
            if (i4 <= i3 || i5 <= i6) {
                return;
            }
            b bVarF3 = b.f(i4 - i3, this.f);
            b bVarF4 = b.f(i5 - i6, this.f);
            this.d[i2].put("ImageLength", bVarF3);
            this.d[i2].put("ImageWidth", bVarF4);
            return;
        }
        if (bVar.a == 5) {
            d[] dVarArr = (d[]) bVar.k(this.f);
            if (dVarArr == null || dVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                return;
            }
            bVarF = b.d(dVarArr[0], this.f);
            bVarF2 = b.d(dVarArr[1], this.f);
        } else {
            int[] iArr = (int[]) bVar.k(this.f);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            bVarF = b.f(iArr[0], this.f);
            bVarF2 = b.f(iArr[1], this.f);
        }
        this.d[i2].put("ImageWidth", bVarF);
        this.d[i2].put("ImageLength", bVarF2);
    }

    private void C(InputStream inputStream) throws Throwable {
        A(0, 5);
        A(0, 4);
        A(5, 4);
        b bVar = this.d[1].get("PixelXDimension");
        b bVar2 = this.d[1].get("PixelYDimension");
        if (bVar != null && bVar2 != null) {
            this.d[0].put("ImageWidth", bVar);
            this.d[0].put("ImageLength", bVar2);
        }
        if (this.d[4].isEmpty() && s(this.d[5])) {
            HashMap<String, b>[] mapArr = this.d;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        if (s(this.d[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    private void a() {
        String strC = c("DateTimeOriginal");
        if (strC != null && c("DateTime") == null) {
            this.d[0].put("DateTime", b.a(strC));
        }
        if (c("ImageWidth") == null) {
            this.d[0].put("ImageWidth", b.b(0L, this.f));
        }
        if (c("ImageLength") == null) {
            this.d[0].put("ImageLength", b.b(0L, this.f));
        }
        if (c("Orientation") == null) {
            this.d[0].put("Orientation", b.b(0L, this.f));
        }
        if (c("LightSource") == null) {
            this.d[1].put("LightSource", b.b(0L, this.f));
        }
    }

    private static long[] b(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            jArr[i2] = iArr[i2];
        }
        return jArr;
    }

    private b e(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < F.length; i2++) {
            b bVar = this.d[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0115, code lost:
    
        r10.f(r9.f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011a, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(a aVar, int i2, int i3) throws IOException {
        aVar.f(ByteOrder.BIG_ENDIAN);
        aVar.d(i2);
        byte b = aVar.readByte();
        if (b != -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(b & 255));
        }
        int i4 = i2 + 1;
        if (aVar.readByte() != -40) {
            throw new IOException("Invalid marker: " + Integer.toHexString(b & 255));
        }
        int i5 = i4 + 1;
        while (true) {
            byte b2 = aVar.readByte();
            if (b2 != -1) {
                throw new IOException("Invalid marker:" + Integer.toHexString(b2 & 255));
            }
            byte b3 = aVar.readByte();
            int i6 = i5 + 1 + 1;
            if (b3 != -39 && b3 != -38) {
                int unsignedShort = aVar.readUnsignedShort() - 2;
                int i7 = i6 + 2;
                if (unsignedShort < 0) {
                    throw new IOException("Invalid length");
                }
                if (b3 != -31) {
                    if (b3 != -2) {
                        switch (b3) {
                            default:
                                switch (b3) {
                                    default:
                                        switch (b3) {
                                            default:
                                                switch (b3) {
                                                }
                                            case -55:
                                            case -54:
                                            case -53:
                                                if (aVar.skipBytes(1) != 1) {
                                                    throw new IOException("Invalid SOFx");
                                                }
                                                this.d[i3].put("ImageLength", b.b(aVar.readUnsignedShort(), this.f));
                                                this.d[i3].put("ImageWidth", b.b(aVar.readUnsignedShort(), this.f));
                                                unsignedShort -= 5;
                                                break;
                                        }
                                    case -59:
                                    case -58:
                                    case -57:
                                        break;
                                }
                            case -64:
                            case -63:
                            case -62:
                            case -61:
                                break;
                        }
                    } else {
                        byte[] bArr = new byte[unsignedShort];
                        if (aVar.read(bArr) != unsignedShort) {
                            throw new IOException("Invalid exif");
                        }
                        if (c("UserComment") == null) {
                            this.d[1].put("UserComment", b.a(new String(bArr, L)));
                        }
                        unsignedShort = 0;
                    }
                } else if (unsignedShort >= 6) {
                    byte[] bArr2 = new byte[6];
                    if (aVar.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    i7 += 6;
                    unsignedShort -= 6;
                    if (Arrays.equals(bArr2, M)) {
                        if (unsignedShort <= 0) {
                            throw new IOException("Invalid exif");
                        }
                        this.f1337h = i7;
                        byte[] bArr3 = new byte[unsignedShort];
                        if (aVar.read(bArr3) != unsignedShort) {
                            throw new IOException("Invalid exif");
                        }
                        i7 += unsignedShort;
                        w(bArr3, i3);
                        unsignedShort = 0;
                    }
                }
                if (unsignedShort < 0) {
                    throw new IOException("Invalid length");
                }
                if (aVar.skipBytes(unsignedShort) != unsignedShort) {
                    throw new IOException("Invalid JPEG segment");
                }
                i5 = i7 + unsignedShort;
            }
        }
    }

    private int g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (n(bArr)) {
            return 4;
        }
        if (p(bArr)) {
            return 9;
        }
        if (o(bArr)) {
            return 7;
        }
        return q(bArr) ? 10 : 0;
    }

    private void h(a aVar) throws Throwable {
        j(aVar);
        b bVar = this.d[1].get("MakerNote");
        if (bVar != null) {
            a aVar2 = new a(bVar.c);
            aVar2.f(this.f);
            byte[] bArr = p;
            byte[] bArr2 = new byte[bArr.length];
            aVar2.readFully(bArr2);
            aVar2.d(0L);
            byte[] bArr3 = q;
            byte[] bArr4 = new byte[bArr3.length];
            aVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                aVar2.d(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                aVar2.d(12L);
            }
            x(aVar2, 6);
            b bVar2 = this.d[7].get("PreviewImageStart");
            b bVar3 = this.d[7].get("PreviewImageLength");
            if (bVar2 != null && bVar3 != null) {
                this.d[5].put("JPEGInterchangeFormat", bVar2);
                this.d[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = this.d[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.k(this.f);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                    return;
                }
                int i2 = (iArr[2] - iArr[0]) + 1;
                int i3 = (iArr[3] - iArr[1]) + 1;
                if (i2 < i3) {
                    int i4 = i2 + i3;
                    i3 = i4 - i3;
                    i2 = i4 - i3;
                }
                b bVarF = b.f(i2, this.f);
                b bVarF2 = b.f(i3, this.f);
                this.d[0].put("ImageWidth", bVarF);
                this.d[0].put("ImageLength", bVarF2);
            }
        }
    }

    private void i(a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        f(aVar, i2, 5);
        aVar.d(i3);
        aVar.f(ByteOrder.BIG_ENDIAN);
        int i4 = aVar.readInt();
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = aVar.readUnsignedShort();
            int unsignedShort2 = aVar.readUnsignedShort();
            if (unsignedShort == A.a) {
                short s2 = aVar.readShort();
                short s3 = aVar.readShort();
                b bVarF = b.f(s2, this.f);
                b bVarF2 = b.f(s3, this.f);
                this.d[0].put("ImageLength", bVarF);
                this.d[0].put("ImageWidth", bVarF2);
                return;
            }
            aVar.skipBytes(unsignedShort2);
        }
    }

    private void j(a aVar) throws Throwable {
        b bVar;
        u(aVar, aVar.available());
        x(aVar, 0);
        B(aVar, 0);
        B(aVar, 5);
        B(aVar, 4);
        C(aVar);
        if (this.c != 8 || (bVar = this.d[1].get("MakerNote")) == null) {
            return;
        }
        a aVar2 = new a(bVar.c);
        aVar2.f(this.f);
        aVar2.d(6L);
        x(aVar2, 9);
        b bVar2 = this.d[9].get("ColorSpace");
        if (bVar2 != null) {
            this.d[1].put("ColorSpace", bVar2);
        }
    }

    private void k(a aVar) throws Throwable {
        j(aVar);
        if (this.d[0].get("JpgFromRaw") != null) {
            f(aVar, this.f1341l, 5);
        }
        b bVar = this.d[0].get("ISO");
        b bVar2 = this.d[1].get("PhotographicSensitivity");
        if (bVar == null || bVar2 != null) {
            return;
        }
        this.d[1].put("PhotographicSensitivity", bVar);
    }

    private void l(a aVar, HashMap map) throws Throwable {
        int i2;
        b bVar = (b) map.get("JPEGInterchangeFormat");
        b bVar2 = (b) map.get("JPEGInterchangeFormatLength");
        if (bVar == null || bVar2 == null) {
            return;
        }
        int i3 = bVar.i(this.f);
        int iMin = Math.min(bVar2.i(this.f), aVar.available() - i3);
        int i4 = this.c;
        if (i4 != 4 && i4 != 9 && i4 != 10) {
            if (i4 == 7) {
                i2 = this.f1338i;
            }
            if (i3 > 0 || iMin <= 0 || this.a != null || this.b != null) {
                return;
            }
            aVar.d(i3);
            aVar.readFully(new byte[iMin]);
            return;
        }
        i2 = this.f1337h;
        i3 += i2;
        if (i3 > 0) {
        }
    }

    private void m(a aVar, HashMap map) throws IOException {
        b bVar = (b) map.get("StripOffsets");
        b bVar2 = (b) map.get("StripByteCounts");
        if (bVar == null || bVar2 == null) {
            return;
        }
        long[] jArrB = b(bVar.k(this.f));
        long[] jArrB2 = b(bVar2.k(this.f));
        if (jArrB == null) {
            Log.w("ExifInterface", "stripOffsets should not be null.");
            return;
        }
        if (jArrB2 == null) {
            Log.w("ExifInterface", "stripByteCounts should not be null.");
            return;
        }
        long j2 = 0;
        for (long j3 : jArrB2) {
            j2 += j3;
        }
        byte[] bArr = new byte[(int) j2];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < jArrB.length; i4++) {
            int i5 = (int) jArrB[i4];
            int i6 = (int) jArrB2[i4];
            int i7 = i5 - i2;
            if (i7 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
            }
            aVar.d(i7);
            int i8 = i2 + i7;
            byte[] bArr2 = new byte[i6];
            aVar.read(bArr2);
            i2 = i8 + i6;
            System.arraycopy(bArr2, 0, bArr, i3, i6);
            i3 += i6;
        }
    }

    private static boolean n(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f1336o;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean o(byte[] bArr) throws IOException {
        a aVar = new a(bArr);
        ByteOrder byteOrderV = v(aVar);
        this.f = byteOrderV;
        aVar.f(byteOrderV);
        short s2 = aVar.readShort();
        aVar.close();
        return s2 == 20306 || s2 == 21330;
    }

    private boolean p(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean q(byte[] bArr) throws IOException {
        a aVar = new a(bArr);
        ByteOrder byteOrderV = v(aVar);
        this.f = byteOrderV;
        aVar.f(byteOrderV);
        short s2 = aVar.readShort();
        aVar.close();
        return s2 == 85;
    }

    private boolean r(HashMap map) throws Throwable {
        b bVar;
        b bVar2 = (b) map.get("BitsPerSample");
        if (bVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) bVar2.k(this.f);
        int[] iArr2 = f1334m;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.c != 3 || (bVar = (b) map.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int i2 = bVar.i(this.f);
        return (i2 == 1 && Arrays.equals(iArr, f1335n)) || (i2 == 6 && Arrays.equals(iArr, iArr2));
    }

    private boolean s(HashMap map) throws IOException {
        b bVar = (b) map.get("ImageLength");
        b bVar2 = (b) map.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.i(this.f) <= 512 && bVar2.i(this.f) <= 512;
    }

    private void t(InputStream inputStream) throws IOException {
        for (int i2 = 0; i2 < F.length; i2++) {
            try {
                this.d[i2] = new HashMap<>();
            } catch (IOException unused) {
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.c = g(bufferedInputStream);
        a aVar = new a(bufferedInputStream);
        switch (this.c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                j(aVar);
                break;
            case 4:
                f(aVar, 0, 0);
                break;
            case 7:
                h(aVar);
                break;
            case 9:
                i(aVar);
                break;
            case 10:
                k(aVar);
                break;
        }
        z(aVar);
        a();
    }

    private void u(a aVar, int i2) throws IOException {
        ByteOrder byteOrderV = v(aVar);
        this.f = byteOrderV;
        aVar.f(byteOrderV);
        int unsignedShort = aVar.readUnsignedShort();
        int i3 = this.c;
        if (i3 != 7 && i3 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i4 = aVar.readInt();
        if (i4 < 8 || i4 >= i2) {
            throw new IOException("Invalid first Ifd offset: " + i4);
        }
        int i5 = i4 - 8;
        if (i5 <= 0 || aVar.skipBytes(i5) == i5) {
            return;
        }
        throw new IOException("Couldn't jump to first Ifd: " + i5);
    }

    private ByteOrder v(a aVar) throws IOException {
        short s2 = aVar.readShort();
        if (s2 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s2));
    }

    private void w(byte[] bArr, int i2) throws IOException {
        a aVar = new a(bArr);
        u(aVar, bArr.length);
        x(aVar, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void x(a aVar, int i2) throws IOException {
        short s2;
        String str;
        long j2;
        boolean z2;
        short s3;
        c cVar;
        int i3;
        int i4;
        int unsignedShort;
        long j3;
        this.e.add(Integer.valueOf(aVar.f));
        if (aVar.f + 2 > aVar.e) {
            return;
        }
        short s4 = aVar.readShort();
        if (aVar.f + (s4 * 12) > aVar.e || s4 <= 0) {
            return;
        }
        short s5 = 0;
        while (s5 < s4) {
            int unsignedShort2 = aVar.readUnsignedShort();
            int unsignedShort3 = aVar.readUnsignedShort();
            int i5 = aVar.readInt();
            long jA = aVar.a() + 4;
            c cVar2 = H[i2].get(Integer.valueOf(unsignedShort2));
            if (cVar2 == null) {
                Log.w("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
            } else {
                if (unsignedShort3 > 0) {
                    if (unsignedShort3 < t.length) {
                        if (cVar2.a(unsignedShort3)) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = cVar2.c;
                            }
                            str = "ExifInterface";
                            s2 = s5;
                            j2 = r6[unsignedShort3] * i5;
                            if (j2 < 0 || j2 > 2147483647L) {
                                Log.w(str, "Skip the tag entry since the number of components is invalid: " + i5);
                                z2 = false;
                                if (z2) {
                                    aVar.d(jA);
                                    s3 = s4;
                                } else {
                                    if (j2 > 4) {
                                        int i6 = aVar.readInt();
                                        int i7 = this.c;
                                        s3 = s4;
                                        if (i7 == 7) {
                                            if ("MakerNote".equals(cVar2.b)) {
                                                this.f1338i = i6;
                                            } else if (i2 == 6 && "ThumbnailImage".equals(cVar2.b)) {
                                                this.f1339j = i6;
                                                this.f1340k = i5;
                                                b bVarF = b.f(6, this.f);
                                                i3 = unsignedShort3;
                                                i4 = i5;
                                                b bVarB = b.b(this.f1339j, this.f);
                                                j3 = jA;
                                                b bVarB2 = b.b(this.f1340k, this.f);
                                                this.d[4].put("Compression", bVarF);
                                                this.d[4].put("JPEGInterchangeFormat", bVarB);
                                                this.d[4].put("JPEGInterchangeFormatLength", bVarB2);
                                            }
                                            i3 = unsignedShort3;
                                            i4 = i5;
                                            j3 = jA;
                                        } else {
                                            i3 = unsignedShort3;
                                            i4 = i5;
                                            j3 = jA;
                                            if (i7 == 10 && "JpgFromRaw".equals(cVar2.b)) {
                                                this.f1341l = i6;
                                            }
                                        }
                                        long j4 = i6;
                                        cVar = cVar2;
                                        if (j4 + j2 <= aVar.e) {
                                            aVar.d(j4);
                                            jA = j3;
                                        } else {
                                            Log.w(str, "Skip the tag entry since data offset is invalid: " + i6);
                                            aVar.d(j3);
                                        }
                                    } else {
                                        s3 = s4;
                                        cVar = cVar2;
                                        i3 = unsignedShort3;
                                        i4 = i5;
                                    }
                                    Integer num = K.get(Integer.valueOf(unsignedShort2));
                                    if (num != null) {
                                        long jC = -1;
                                        int i8 = i3;
                                        if (i8 != 3) {
                                            if (i8 == 4) {
                                                jC = aVar.c();
                                            } else if (i8 == 8) {
                                                unsignedShort = aVar.readShort();
                                            } else if (i8 == 9 || i8 == 13) {
                                                unsignedShort = aVar.readInt();
                                            }
                                            if (jC > 0 || jC >= aVar.e) {
                                                Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jC);
                                            } else if (this.e.contains(Integer.valueOf((int) jC))) {
                                                Log.w(str, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jC + ")");
                                            } else {
                                                aVar.d(jC);
                                                x(aVar, num.intValue());
                                            }
                                            aVar.d(jA);
                                        } else {
                                            unsignedShort = aVar.readUnsignedShort();
                                        }
                                        jC = unsignedShort;
                                        if (jC > 0) {
                                            Log.w(str, "Skip jump into the IFD since its offset is invalid: " + jC);
                                            aVar.d(jA);
                                        }
                                    } else {
                                        byte[] bArr = new byte[(int) j2];
                                        aVar.readFully(bArr);
                                        b bVar = new b(i3, i4, bArr);
                                        c cVar3 = cVar;
                                        this.d[i2].put(cVar3.b, bVar);
                                        if ("DNGVersion".equals(cVar3.b)) {
                                            this.c = 3;
                                        }
                                        if ((("Make".equals(cVar3.b) || "Model".equals(cVar3.b)) && bVar.j(this.f).contains("PENTAX")) || ("Compression".equals(cVar3.b) && bVar.i(this.f) == 65535)) {
                                            this.c = 8;
                                        }
                                        if (aVar.a() != jA) {
                                            aVar.d(jA);
                                        }
                                    }
                                }
                                s5 = (short) (s2 + 1);
                                s4 = s3;
                            } else {
                                z2 = true;
                                if (z2) {
                                }
                                s5 = (short) (s2 + 1);
                                s4 = s3;
                            }
                        } else {
                            Log.w("ExifInterface", "Skip the tag entry since data format (" + s[unsignedShort3] + ") is unexpected for tag: " + cVar2.b);
                        }
                    }
                }
                s2 = s5;
                str = "ExifInterface";
                Log.w(str, "Skip the tag entry since data format is invalid: " + unsignedShort3);
                j2 = 0;
                z2 = false;
                if (z2) {
                }
                s5 = (short) (s2 + 1);
                s4 = s3;
            }
            s2 = s5;
            str = "ExifInterface";
            j2 = 0;
            z2 = false;
            if (z2) {
            }
            s5 = (short) (s2 + 1);
            s4 = s3;
        }
        if (aVar.a() + 4 <= aVar.e) {
            int i9 = aVar.readInt();
            long j5 = i9;
            if (j5 <= 0 || i9 >= aVar.e) {
                Log.w("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i9);
                return;
            }
            if (this.e.contains(Integer.valueOf(i9))) {
                Log.w("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i9);
                return;
            }
            aVar.d(j5);
            if (this.d[4].isEmpty()) {
                x(aVar, 4);
            } else if (this.d[5].isEmpty()) {
                x(aVar, 5);
            }
        }
    }

    private void y(a aVar, int i2) throws IOException {
        b bVar;
        b bVar2 = this.d[i2].get("ImageLength");
        b bVar3 = this.d[i2].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = this.d[i2].get("JPEGInterchangeFormat")) != null) {
            f(aVar, bVar.i(this.f), i2);
        }
    }

    private void z(a aVar) throws Throwable {
        HashMap<String, b> map = this.d[4];
        b bVar = map.get("Compression");
        if (bVar == null) {
            this.g = 6;
            l(aVar, map);
            return;
        }
        int i2 = bVar.i(this.f);
        this.g = i2;
        if (i2 != 1) {
            if (i2 == 6) {
                l(aVar, map);
                return;
            } else if (i2 != 7) {
                return;
            }
        }
        if (r(map)) {
            m(aVar, map);
        }
    }

    public String c(String str) {
        b bVarE = e(str);
        if (bVarE != null) {
            if (!J.contains(str)) {
                return bVarE.j(this.f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i2 = bVarE.a;
                if (i2 != 5 && i2 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + bVarE.a);
                    return null;
                }
                d[] dVarArr = (d[]) bVarE.k(this.f);
                if (dVarArr != null && dVarArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (dVarArr[0].a / dVarArr[0].b)), Integer.valueOf((int) (dVarArr[1].a / dVarArr[1].b)), Integer.valueOf((int) (dVarArr[2].a / dVarArr[2].b)));
                }
                Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                return null;
            }
            try {
                return Double.toString(bVarE.h(this.f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int d(String str, int i2) {
        b bVarE = e(str);
        if (bVarE == null) {
            return i2;
        }
        try {
            return bVarE.i(this.f);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }
}
