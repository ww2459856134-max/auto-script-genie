package h.l.a;

import androidx.lifecycle.i;
import androidx.lifecycle.n;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import h.d.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
class b extends h.l.a.a {
    private final i a;
    private final C0013b b;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<D>] */
    public static class a<D> extends n<D> {
        abstract h.l.b.a<D> j(boolean z);

        public abstract void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        abstract void l();

        public abstract String toString();
    }

    /* renamed from: h.l.a.b$b, reason: collision with other inner class name */
    static class C0013b extends t {
        private static final u.a c = new a();
        private j<a> b = new j<>();

        /* renamed from: h.l.a.b$b$a */
        static class a implements u.a {
            a() {
            }

            @Override // androidx.lifecycle.u.a
            public <T extends t> T a(Class<T> cls) {
                return new C0013b();
            }
        }

        C0013b() {
        }

        static C0013b f(v vVar) {
            return (C0013b) new u(vVar, c).a(C0013b.class);
        }

        @Override // androidx.lifecycle.t
        protected void d() {
            super.d();
            int i2 = this.b.i();
            for (int i3 = 0; i3 < i2; i3++) {
                this.b.j(i3).j(true);
            }
            this.b.b();
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.i() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.b.i(); i2++) {
                    a aVarJ = this.b.j(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.g(i2));
                    printWriter.print(": ");
                    printWriter.println(aVarJ.toString());
                    aVarJ.k(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void g() {
            int i2 = this.b.i();
            for (int i3 = 0; i3 < i2; i3++) {
                this.b.j(i3).l();
            }
        }
    }

    b(i iVar, v vVar) {
        this.a = iVar;
        this.b = C0013b.f(vVar);
    }

    @Override // h.l.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // h.l.a.a
    public void c() {
        this.b.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        h.e.i.b.a(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
