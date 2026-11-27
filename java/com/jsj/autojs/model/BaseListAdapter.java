package com.jsj.autojs.model;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseListAdapter<T> extends BaseAdapter {
    protected Context context;
    protected int layoutId;
    protected List<T> mListDatas;

    public static class ViewHolder {
        public View mConvertView;
        SparseArray<View> views = new SparseArray<>();

        private ViewHolder(Context context, int i2, ViewGroup viewGroup) {
            this.mConvertView = LayoutInflater.from(context).inflate(i2, viewGroup, false);
            this.mConvertView.setTag(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ViewHolder getViewHolder(Context context, View view, ViewGroup viewGroup, int i2) {
            return (view == null || view.getTag() == null) ? new ViewHolder(context, i2, viewGroup) : (ViewHolder) view.getTag();
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View get(int i2) {
            View view = this.views.get(i2);
            if (view != null) {
                return view;
            }
            View viewFindViewById = this.mConvertView.findViewById(i2);
            this.views.put(i2, viewFindViewById);
            return viewFindViewById;
        }
    }

    public BaseListAdapter(Context context, int i2) {
        this.context = context;
        this.layoutId = i2;
    }

    public void addData(List<T> list) {
        if (this.mListDatas == null) {
            this.mListDatas = new ArrayList();
        }
        this.mListDatas.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.mListDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<T> getDatas() {
        return this.mListDatas;
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        List<T> list = this.mListDatas;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(this.context, view, viewGroup, this.layoutId);
        getView(viewHolder, i2);
        return viewHolder.mConvertView;
    }

    protected abstract void getView(ViewHolder viewHolder, int i2);

    public void remove(T t) {
        List<T> list = this.mListDatas;
        if (list != null) {
            list.remove(t);
        }
    }

    public void removeAllData() {
        List<T> list = this.mListDatas;
        if (list != null) {
            list.removeAll(list);
        }
    }

    public void setDatas(List<T> list) {
        this.mListDatas = list;
    }

    public void remove(int i2) {
        List<T> list = this.mListDatas;
        if (list != null) {
            list.remove(i2);
        }
    }

    public void addData(int i2, T t) {
        if (this.mListDatas == null) {
            this.mListDatas = new ArrayList();
        }
        this.mListDatas.add(i2, t);
    }

    public void addData(T t) {
        if (this.mListDatas == null) {
            this.mListDatas = new ArrayList();
        }
        this.mListDatas.add(t);
    }
}
