package n.a.a.l.b;

/* loaded from: classes.dex */
public enum e {
    none("", 0, "", 0, "", false, ""),
    sha1("SHA-1", 32772, "SHA1", 20, "HmacSHA1", false, "1.3.14.3.2.26"),
    sha256("SHA-256", 32780, "SHA256", 32, "HmacSHA256", false, "2.16.840.1.101.3.4.2.1"),
    sha384("SHA-384", 32781, "SHA384", 48, "HmacSHA384", false, "2.16.840.1.101.3.4.2.2"),
    sha512("SHA-512", 32782, "SHA512", 64, "HmacSHA512", false, "2.16.840.1.101.3.4.2.3"),
    md5("MD5", -1, "MD5", 16, "HmacMD5", false, "1.2.840.113549.2.5"),
    md2("MD2", -1, "MD2", 16, "Hmac-MD2", true, "1.2.840.113549.2.2"),
    md4("MD4", -1, "MD4", 16, "Hmac-MD4", true, "1.2.840.113549.2.4"),
    ripemd128("RipeMD128", -1, "RIPEMD-128", 16, "HMac-RipeMD128", true, "1.3.36.3.2.2"),
    ripemd160("RipeMD160", -1, "RIPEMD-160", 20, "HMac-RipeMD160", true, "1.3.36.3.2.1"),
    whirlpool("Whirlpool", -1, "WHIRLPOOL", 64, "HMac-Whirlpool", true, "1.0.10118.3.0.55"),
    sha224("SHA-224", -1, "SHA224", 28, "HmacSHA224", true, "2.16.840.1.101.3.4.2.4"),
    ripemd256("RipeMD256", -1, "RIPEMD-256", 32, "HMac-RipeMD256", true, "1.3.36.3.2.3");

    public final String c;
    public final String d;
    public final boolean e;

    e(String str, int i2, String str2, int i3, String str3, boolean z, String str4) {
        this.c = str;
        this.d = str2;
        this.e = z;
    }

    public static e a(String str) {
        for (e eVar : values()) {
            if (eVar.d.equalsIgnoreCase(str) || eVar.c.equalsIgnoreCase(str)) {
                return eVar;
            }
        }
        throw new n.a.a.b("hash algorithm not found");
    }
}
