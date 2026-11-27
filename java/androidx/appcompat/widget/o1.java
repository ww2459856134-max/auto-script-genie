package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class o1 extends h.f.a.f implements View.OnClickListener {
    private final SearchView C;
    private final SearchableInfo D;
    private final Context G;
    private final WeakHashMap<String, Drawable.ConstantState> H;
    private final int I;
    private boolean J;
    private int K;
    private ColorStateList M;
    private int O;
    private int P;
    private int Q;
    private int U;
    private int V;
    private int W;

    public o1(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.J = false;
        this.K = 1;
        this.O = -1;
        this.P = -1;
        this.Q = -1;
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.C = searchView;
        this.D = searchableInfo;
        this.I = searchView.getSuggestionCommitIconResId();
        this.G = context;
        this.H = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.H.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = this.H.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.M == null) {
            TypedValue typedValue = new TypedValue();
            this.G.getTheme().resolveAttribute(h.a.a.M, typedValue, true);
            this.M = this.G.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.M, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.G.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable n(ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.H.containsKey(strFlattenToShortString)) {
            Drawable drawableM = m(componentName);
            this.H.put(strFlattenToShortString, drawableM != null ? drawableM.getConstantState() : null);
            return drawableM;
        }
        Drawable.ConstantState constantState = this.H.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.G.getResources());
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() throws PackageManager.NameNotFoundException {
        Drawable drawableN = n(this.D.getSearchActivity());
        return drawableN != null ? drawableN : this.G.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) throws IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.G.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                }
            }
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    private Drawable s(String str) throws NumberFormatException, IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i2 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.G.getPackageName() + "/" + i2;
            Drawable drawableK = k(str2);
            if (drawableK != null) {
                return drawableK;
            }
            Drawable drawableE = androidx.core.content.a.e(this.G, i2);
            A(str2, drawableE);
            return drawableE;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableK2 = k(str);
            if (drawableK2 != null) {
                return drawableK2;
            }
            Drawable drawableQ = q(Uri.parse(str));
            A(str, drawableQ);
            return drawableQ;
        }
    }

    private Drawable t(Cursor cursor) throws NumberFormatException, IOException {
        int i2 = this.U;
        if (i2 == -1) {
            return null;
        }
        Drawable drawableS = s(cursor.getString(i2));
        return drawableS != null ? drawableS : p();
    }

    private Drawable u(Cursor cursor) {
        int i2 = this.V;
        if (i2 == -1) {
            return null;
        }
        return s(cursor.getString(i2));
    }

    private static String w(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // h.f.a.c, h.f.a.d
    public void a(Cursor cursor) {
        if (this.J) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.O = cursor.getColumnIndex("suggest_text_1");
                this.P = cursor.getColumnIndex("suggest_text_2");
                this.Q = cursor.getColumnIndex("suggest_text_2_url");
                this.U = cursor.getColumnIndex("suggest_icon_1");
                this.V = cursor.getColumnIndex("suggest_icon_2");
                this.W = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // h.f.a.c, h.f.a.d
    public CharSequence c(Cursor cursor) {
        String strO;
        String strO2;
        if (cursor == null) {
            return null;
        }
        String strO3 = o(cursor, "suggest_intent_query");
        if (strO3 != null) {
            return strO3;
        }
        if (this.D.shouldRewriteQueryFromData() && (strO2 = o(cursor, "suggest_intent_data")) != null) {
            return strO2;
        }
        if (!this.D.shouldRewriteQueryFromText() || (strO = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strO;
    }

    @Override // h.f.a.d
    public Cursor d(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.C.getVisibility() == 0 && this.C.getWindowVisibility() == 0) {
            try {
                Cursor cursorV = v(this.D, string, 50);
                if (cursorV != null) {
                    cursorV.getCount();
                    return cursorV;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    @Override // h.f.a.c
    public void e(View view, Context context, Cursor cursor) {
        n1 n1Var = (n1) view.getTag();
        int i2 = this.W;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (n1Var.a != null) {
            z(n1Var.a, w(cursor, this.O));
        }
        if (n1Var.b != null) {
            String strW = w(cursor, this.Q);
            CharSequence charSequenceL = strW != null ? l(strW) : w(cursor, this.P);
            if (TextUtils.isEmpty(charSequenceL)) {
                TextView textView = n1Var.a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    n1Var.a.setMaxLines(2);
                }
            } else {
                TextView textView2 = n1Var.a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    n1Var.a.setMaxLines(1);
                }
            }
            z(n1Var.b, charSequenceL);
        }
        ImageView imageView = n1Var.c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = n1Var.d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i4 = this.K;
        if (i4 != 2 && (i4 != 1 || (i3 & 1) == 0)) {
            n1Var.e.setVisibility(8);
            return;
        }
        n1Var.e.setVisibility(0);
        n1Var.e.setTag(n1Var.a.getText());
        n1Var.e.setOnClickListener(this);
    }

    @Override // h.f.a.c, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewG = g(this.G, b(), viewGroup);
            if (viewG != null) {
                ((n1) viewG.getTag()).a.setText(e.toString());
            }
            return viewG;
        }
    }

    @Override // h.f.a.c, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewH = h(this.G, b(), viewGroup);
            if (viewH != null) {
                ((n1) viewH.getTag()).a.setText(e.toString());
            }
            return viewH;
        }
    }

    @Override // h.f.a.f, h.f.a.c
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewH = super.h(context, cursor, viewGroup);
        viewH.setTag(new n1(viewH));
        ((ImageView) viewH.findViewById(h.a.f.s)).setImageResource(this.I);
        return viewH;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.C.S((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.G.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.G.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i2) {
        this.K = i2;
    }
}
