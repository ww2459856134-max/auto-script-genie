package com.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FileItemAdapter extends BaseQuickAdapter<File, BaseViewHolder> {
    private List<File> a;

    public FileItemAdapter(List<File> list, boolean z) {
        super(j.b.f.k0, list);
        this.a = new ArrayList();
        v0.g().getPackageManager();
    }

    public void c() {
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, File file) {
        baseViewHolder.setText(j.b.e.n6, file.getName());
        baseViewHolder.getView(j.b.e.S1).setSelected(this.a.contains(file));
        String lowerCase = file.getName().toLowerCase();
        if (file.isDirectory()) {
            baseViewHolder.setImageResource(j.b.e.C3, j.b.d.r);
            return;
        }
        if (lowerCase.endsWith("txt")) {
            baseViewHolder.setImageResource(j.b.e.C3, j.b.d.u);
            return;
        }
        if (lowerCase.endsWith("zip")) {
            baseViewHolder.setImageResource(j.b.e.C3, j.b.d.v);
            return;
        }
        if (lowerCase.endsWith("png") || lowerCase.endsWith("jpg")) {
            baseViewHolder.setImageResource(j.b.e.C3, j.b.d.t);
        } else if (lowerCase.endsWith("mp3") || lowerCase.endsWith("org") || lowerCase.endsWith("wav")) {
            baseViewHolder.setImageResource(j.b.e.C3, j.b.d.q);
        } else {
            baseViewHolder.setImageResource(j.b.e.C3, j.b.d.s);
        }
    }

    public List<File> e() {
        return this.a;
    }

    public boolean f(int i2) {
        return g(getItem(i2));
    }

    boolean g(File file) {
        return this.a.contains(file);
    }

    public void h(int i2) {
        this.a.add(getItem(i2));
    }

    public void i(File file) {
        this.a.add(file);
    }

    public void j(int i2) {
        if (f(i2)) {
            k(i2);
        } else {
            h(i2);
        }
        notifyDataSetChanged();
    }

    public void k(int i2) {
        this.a.remove(getItem(i2));
    }
}
