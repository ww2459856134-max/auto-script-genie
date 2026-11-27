package androidx.activity;

/* loaded from: classes.dex */
class j implements a {
    private final i a;
    final /* synthetic */ OnBackPressedDispatcher b;

    j(OnBackPressedDispatcher onBackPressedDispatcher, i iVar) {
        this.b = onBackPressedDispatcher;
        this.a = iVar;
    }

    @Override // androidx.activity.a
    public void cancel() {
        this.b.b.remove(this.a);
        this.a.e(this);
    }
}
