package androidx.activity.result;

/* JADX INFO: Add missing generic type declarations: [I] */
/* loaded from: classes.dex */
class f<I> extends d<I> {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ androidx.activity.result.l.b c;
    final /* synthetic */ ActivityResultRegistry d;

    f(ActivityResultRegistry activityResultRegistry, String str, int i2, androidx.activity.result.l.b bVar) {
        this.d = activityResultRegistry;
        this.a = str;
        this.b = i2;
        this.c = bVar;
    }

    @Override // androidx.activity.result.d
    public void b(I i2, androidx.core.app.g gVar) {
        this.d.e.add(this.a);
        Integer num = this.d.c.get(this.a);
        this.d.f(num != null ? num.intValue() : this.b, this.c, i2, gVar);
    }

    @Override // androidx.activity.result.d
    public void c() {
        this.d.l(this.a);
    }
}
