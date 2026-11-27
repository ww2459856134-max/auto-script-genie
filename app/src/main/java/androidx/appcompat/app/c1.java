package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
class c1 {
    private static c1 d;
    private final Context a;
    private final LocationManager b;
    private final b1 c = new b1();

    c1(Context context, LocationManager locationManager) {
        this.a = context;
        this.b = locationManager;
    }

    static c1 a(Context context) {
        if (d == null) {
            Context applicationContext = context.getApplicationContext();
            d = new c1(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location locationC = androidx.core.content.b.b(this.a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = androidx.core.content.b.b(this.a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.b.isProviderEnabled(str)) {
                return this.b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private boolean e() {
        return this.c.f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j2;
        b1 b1Var = this.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        a1 a1VarB = a1.b();
        a1VarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = a1VarB.a;
        a1VarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a1VarB.c == 1;
        long j4 = a1VarB.b;
        long j5 = a1VarB.a;
        a1VarB.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = a1VarB.b;
        if (j4 == -1 || j5 == -1) {
            j2 = 43200000 + jCurrentTimeMillis;
        } else {
            j2 = (jCurrentTimeMillis > j5 ? 0 + j6 : jCurrentTimeMillis > j4 ? 0 + j5 : 0 + j4) + 60000;
        }
        b1Var.a = z;
        b1Var.b = j3;
        b1Var.c = j4;
        b1Var.d = j5;
        b1Var.e = j6;
        b1Var.f = j2;
    }

    boolean d() {
        b1 b1Var = this.c;
        if (e()) {
            return b1Var.a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return b1Var.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}
