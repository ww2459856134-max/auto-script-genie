package org.apache.poi.xssf.usermodel;

import java.lang.reflect.Array;
import java.util.List;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor;

/* loaded from: classes.dex */
public class s0 implements u0 {
    private final byte[][] a;

    private s0(byte[][] bArr) {
        this.a = bArr;
    }

    public static s0 b(CTColors cTColors) {
        if (cTColors == null || !cTColors.isSetIndexedColors()) {
            return null;
        }
        List<CTRgbColor> rgbColorList = cTColors.getIndexedColors().getRgbColorList();
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, rgbColorList.size(), 3);
        for (int i2 = 0; i2 < rgbColorList.size(); i2++) {
            bArr[i2] = rgbColorList.get(i2).getRgb();
        }
        return new s0(bArr);
    }

    @Override // org.apache.poi.xssf.usermodel.u0
    public byte[] a(int i2) {
        byte[][] bArr = this.a;
        if (bArr == null || i2 < 0 || i2 >= bArr.length) {
            return null;
        }
        return bArr[i2];
    }
}
