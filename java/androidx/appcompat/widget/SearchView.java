package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements h.a.o.d {
    static final n O0;
    private CharSequence A0;
    private boolean B0;
    private int C0;
    SearchableInfo D0;
    private Bundle E0;
    private final Runnable F0;
    private Runnable G0;
    private final WeakHashMap<String, Drawable.ConstantState> H0;
    final SearchAutoComplete I;
    private final View.OnClickListener I0;
    private final View J;
    View.OnKeyListener J0;
    private final View K;
    private final TextView.OnEditorActionListener K0;
    private final AdapterView.OnItemClickListener L0;
    private final View M;
    private final AdapterView.OnItemSelectedListener M0;
    private TextWatcher N0;
    final ImageView O;
    final ImageView P;
    final ImageView Q;
    final ImageView U;
    private final View V;
    private p W;
    private Rect a0;
    private Rect b0;
    private int[] c0;
    private int[] d0;
    private final ImageView e0;
    private final Drawable f0;
    private final int g0;
    private final int h0;
    private final Intent i0;
    private final Intent j0;
    private final CharSequence k0;
    private l l0;
    private k m0;
    View.OnFocusChangeListener n0;
    private m o0;
    private View.OnClickListener p0;
    private boolean q0;
    private boolean r0;
    h.f.a.c s0;
    private boolean t0;
    private CharSequence u0;
    private boolean v0;
    private boolean w0;
    private int x0;
    private boolean y0;
    private CharSequence z0;

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int f;
        private SearchView g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f129h;

        /* renamed from: i, reason: collision with root package name */
        final Runnable f130i;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 < 600) {
                return (i2 < 640 || i3 < 480) ? 160 : 192;
            }
            return 192;
        }

        void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.O0.c(this);
                return;
            }
            setInputMethodMode(1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void c() {
            if (this.f129h) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f129h = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f129h) {
                removeCallbacks(this.f130i);
                post(this.f130i);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i2, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z, i2, rect);
            this.g.X();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.g.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z);
            if (z && this.g.hasFocus() && getVisibility() == 0) {
                this.f129h = true;
                if (SearchView.K(getContext())) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f129h = false;
                removeCallbacks(this.f130i);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f129h = true;
                    return;
                }
                this.f129h = false;
                removeCallbacks(this.f130i);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.g = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f = i2;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, h.a.a.q);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f130i = new a();
            this.f = getThreshold();
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            SearchView.this.W(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.c0();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.f.a.c cVar = SearchView.this.s0;
            if (cVar instanceof o1) {
                cVar.a(null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.n0;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            SearchView.this.z();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SearchView searchView = SearchView.this;
            if (view == searchView.O) {
                searchView.T();
                return;
            }
            if (view == searchView.Q) {
                searchView.P();
                return;
            }
            if (view == searchView.P) {
                searchView.U();
            } else if (view == searchView.U) {
                searchView.Y();
            } else if (view == searchView.I) {
                searchView.F();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.D0 == null) {
                return false;
            }
            if (searchView.I.isPopupShowing() && SearchView.this.I.getListSelection() != -1) {
                return SearchView.this.V(view, i2, keyEvent);
            }
            if (SearchView.this.I.b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.N(0, null, searchView2.I.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            SearchView.this.U();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            SearchView.this.Q(i2, 0, null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            SearchView.this.R(i2);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public interface k {
        boolean a();
    }

    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    public interface m {
        boolean a(int i2);

        boolean b(int i2);
    }

    private static class n {
        private Method a;
        private Method b;
        private Method c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        n() throws NoSuchMethodException, SecurityException {
            this.a = null;
            this.b = null;
            this.c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    static class o extends h.g.a.c {
        public static final Parcelable.Creator<o> CREATOR = new m1();
        boolean e;

        o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.e + "}";
        }

        @Override // h.g.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.e));
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.e = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    private static class p extends TouchDelegate {
        private final View a;
        private final Rect b;
        private final Rect c;
        private final Rect d;
        private final int e;
        private boolean f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            Rect rect3 = this.d;
            int i2 = this.e;
            rect3.inset(-i2, -i2);
            this.c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f;
                    if (z2 && !this.d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f;
                        this.f = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else if (this.b.contains(x, y)) {
                this.f = true;
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            if (!z || this.c.contains(x, y)) {
                Rect rect = this.c;
                motionEvent.setLocation(x - rect.left, y - rect.top);
            } else {
                motionEvent.setLocation(this.a.getWidth() / 2, this.a.getHeight() / 2);
            }
            return this.a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        O0 = Build.VERSION.SDK_INT < 29 ? new n() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private Intent A(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.A0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.E0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.D0.getSearchActivity());
        return intent;
    }

    private Intent B(Cursor cursor, int i2, String str) {
        int position;
        String strO;
        try {
            String strO2 = o1.o(cursor, "suggest_intent_action");
            if (strO2 == null) {
                strO2 = this.D0.getSuggestIntentAction();
            }
            if (strO2 == null) {
                strO2 = "android.intent.action.SEARCH";
            }
            String str2 = strO2;
            String strO3 = o1.o(cursor, "suggest_intent_data");
            if (strO3 == null) {
                strO3 = this.D0.getSuggestIntentData();
            }
            if (strO3 != null && (strO = o1.o(cursor, "suggest_intent_data_id")) != null) {
                strO3 = strO3 + "/" + Uri.encode(strO);
            }
            return A(str2, strO3 == null ? null : Uri.parse(strO3), o1.o(cursor, "suggest_intent_extra_data"), o1.o(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            return null;
        }
    }

    private Intent C(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, WXVideoFileObject.FILE_SIZE_LIMIT);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.E0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent D(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void E() {
        this.I.dismissDropDown();
    }

    private void G(View view, Rect rect) {
        view.getLocationInWindow(this.c0);
        getLocationInWindow(this.d0);
        int[] iArr = this.c0;
        int i2 = iArr[1];
        int[] iArr2 = this.d0;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private CharSequence H(CharSequence charSequence) {
        if (!this.q0 || this.f0 == null) {
            return charSequence;
        }
        int textSize = (int) (this.I.getTextSize() * 1.25d);
        this.f0.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f0), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean I() {
        SearchableInfo searchableInfo = this.D0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.D0.getVoiceSearchLaunchWebSearch()) {
            intent = this.i0;
        } else if (this.D0.getVoiceSearchLaunchRecognizer()) {
            intent = this.j0;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, WXMediaMessage.THUMB_LENGTH_LIMIT) == null) ? false : true;
    }

    static boolean K(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean L() {
        return (this.t0 || this.y0) && !J();
    }

    private void M(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    private boolean O(int i2, int i3, String str) {
        Cursor cursorB = this.s0.b();
        if (cursorB == null || !cursorB.moveToPosition(i2)) {
            return false;
        }
        M(B(cursorB, i3, str));
        return true;
    }

    private void Z() {
        post(this.F0);
    }

    private void a0(int i2) {
        Editable text = this.I.getText();
        Cursor cursorB = this.s0.b();
        if (cursorB == null) {
            return;
        }
        if (!cursorB.moveToPosition(i2)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceC = this.s0.c(cursorB);
        if (charSequenceC != null) {
            setQuery(charSequenceC);
        } else {
            setQuery(text);
        }
    }

    private void b0() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.I.getText());
        if (!z2 && (!this.q0 || this.B0)) {
            z = false;
        }
        this.Q.setVisibility(z ? 0 : 8);
        Drawable drawable = this.Q.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void d0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.I;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(H(queryHint));
    }

    private void e0() {
        this.I.setThreshold(this.D0.getSuggestThreshold());
        this.I.setImeOptions(this.D0.getImeOptions());
        int inputType = this.D0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.D0.getSuggestAuthority() != null) {
                inputType = inputType | WXMediaMessage.THUMB_LENGTH_LIMIT | 524288;
            }
        }
        this.I.setInputType(inputType);
        h.f.a.c cVar = this.s0;
        if (cVar != null) {
            cVar.a(null);
        }
        if (this.D0.getSuggestAuthority() != null) {
            o1 o1Var = new o1(getContext(), this, this.D0, this.H0);
            this.s0 = o1Var;
            this.I.setAdapter(o1Var);
            ((o1) this.s0).x(this.v0 ? 2 : 1);
        }
    }

    private void f0() {
        this.M.setVisibility((L() && (this.P.getVisibility() == 0 || this.U.getVisibility() == 0)) ? 0 : 8);
    }

    private void g0(boolean z) {
        this.P.setVisibility((this.t0 && L() && hasFocus() && (z || !this.y0)) ? 0 : 8);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(h.a.d.g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(h.a.d.f1185h);
    }

    private void h0(boolean z) {
        this.r0 = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.I.getText());
        this.O.setVisibility(i2);
        g0(z2);
        this.J.setVisibility(z ? 8 : 0);
        this.e0.setVisibility((this.e0.getDrawable() == null || this.q0) ? 8 : 0);
        b0();
        i0(!z2);
        f0();
    }

    private void i0(boolean z) {
        int i2 = 8;
        if (this.y0 && !J() && z) {
            this.P.setVisibility(8);
            i2 = 0;
        }
        this.U.setVisibility(i2);
    }

    void F() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            this.I.refreshAutoCompleteResults();
            return;
        }
        n nVar = O0;
        nVar.b(this.I);
        nVar.a(this.I);
    }

    public boolean J() {
        return this.r0;
    }

    void N(int i2, String str, String str2) {
        getContext().startActivity(A("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    void P() {
        if (!TextUtils.isEmpty(this.I.getText())) {
            this.I.setText("");
            this.I.requestFocus();
            this.I.setImeVisibility(true);
        } else if (this.q0) {
            k kVar = this.m0;
            if (kVar == null || !kVar.a()) {
                clearFocus();
                h0(true);
            }
        }
    }

    boolean Q(int i2, int i3, String str) {
        m mVar = this.o0;
        if (mVar != null && mVar.b(i2)) {
            return false;
        }
        O(i2, 0, null);
        this.I.setImeVisibility(false);
        E();
        return true;
    }

    boolean R(int i2) {
        m mVar = this.o0;
        if (mVar != null && mVar.a(i2)) {
            return false;
        }
        a0(i2);
        return true;
    }

    void S(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void T() {
        h0(false);
        this.I.requestFocus();
        this.I.setImeVisibility(true);
        View.OnClickListener onClickListener = this.p0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void U() {
        Editable text = this.I.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        l lVar = this.l0;
        if (lVar == null || !lVar.b(text.toString())) {
            if (this.D0 != null) {
                N(0, null, text.toString());
            }
            this.I.setImeVisibility(false);
            E();
        }
    }

    boolean V(View view, int i2, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.D0 != null && this.s0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return Q(this.I.getListSelection(), 0, null);
            }
            if (i2 == 21 || i2 == 22) {
                this.I.setSelection(i2 == 21 ? 0 : this.I.length());
                this.I.setListSelection(0);
                this.I.clearListSelection();
                this.I.a();
                return true;
            }
            if (i2 != 19 || this.I.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    void W(CharSequence charSequence) {
        Editable text = this.I.getText();
        this.A0 = text;
        boolean z = !TextUtils.isEmpty(text);
        g0(z);
        i0(!z);
        b0();
        f0();
        if (this.l0 != null && !TextUtils.equals(charSequence, this.z0)) {
            this.l0.a(charSequence.toString());
        }
        this.z0 = charSequence.toString();
    }

    void X() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        h0(J());
        Z();
        if (this.I.hasFocus()) {
            F();
        }
    }

    void Y() {
        SearchableInfo searchableInfo = this.D0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(D(this.i0, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(C(this.j0, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // h.a.o.d
    public void b() {
        setQuery("", false);
        clearFocus();
        h0(true);
        this.I.setImeOptions(this.C0);
        this.B0 = false;
    }

    @Override // h.a.o.d
    public void c() {
        if (this.B0) {
            return;
        }
        this.B0 = true;
        int imeOptions = this.I.getImeOptions();
        this.C0 = imeOptions;
        this.I.setImeOptions(imeOptions | 33554432);
        this.I.setText("");
        setIconified(false);
    }

    void c0() {
        int[] iArr = this.I.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.K.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.M.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.w0 = true;
        super.clearFocus();
        this.I.clearFocus();
        this.I.setImeVisibility(false);
        this.w0 = false;
    }

    public int getImeOptions() {
        return this.I.getImeOptions();
    }

    public int getInputType() {
        return this.I.getInputType();
    }

    public int getMaxWidth() {
        return this.x0;
    }

    public CharSequence getQuery() {
        return this.I.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.u0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.D0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.k0 : getContext().getText(this.D0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.h0;
    }

    int getSuggestionRowLayout() {
        return this.g0;
    }

    public h.f.a.c getSuggestionsAdapter() {
        return this.s0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.F0);
        post(this.G0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            G(this.I, this.a0);
            Rect rect = this.b0;
            Rect rect2 = this.a0;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            p pVar = this.W;
            if (pVar != null) {
                pVar.a(this.b0, this.a0);
                return;
            }
            p pVar2 = new p(this.b0, this.a0, this.I);
            this.W = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        if (J()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.x0;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.x0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.x0) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec(size2, WXVideoFileObject.FILE_SIZE_LIMIT));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.a());
        h0(oVar.e);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.e = J();
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Z();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (this.w0 || !isFocusable()) {
            return false;
        }
        if (J()) {
            return super.requestFocus(i2, rect);
        }
        boolean zRequestFocus = this.I.requestFocus(i2, rect);
        if (zRequestFocus) {
            h0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.E0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            P();
        } else {
            T();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.q0 == z) {
            return;
        }
        this.q0 = z;
        h0(z);
        d0();
    }

    public void setImeOptions(int i2) {
        this.I.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.I.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.x0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
        this.m0 = kVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.n0 = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
        this.l0 = lVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.p0 = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
        this.o0 = mVar;
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.I.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.I;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.A0 = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        U();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.u0 = charSequence;
        d0();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.v0 = z;
        h.f.a.c cVar = this.s0;
        if (cVar instanceof o1) {
            ((o1) cVar).x(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.D0 = searchableInfo;
        if (searchableInfo != null) {
            e0();
            d0();
        }
        boolean zI = I();
        this.y0 = zI;
        if (zI) {
            this.I.setPrivateImeOptions("nm");
        }
        h0(J());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.t0 = z;
        h0(J());
    }

    public void setSuggestionsAdapter(h.f.a.c cVar) {
        this.s0 = cVar;
        this.I.setAdapter(cVar);
    }

    void z() {
        if (this.V.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.K.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = e2.b(this);
            int dimensionPixelSize = this.q0 ? resources.getDimensionPixelSize(h.a.d.e) + resources.getDimensionPixelSize(h.a.d.f) : 0;
            this.I.getDropDownBackground().getPadding(rect);
            this.I.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.I.setDropDownWidth((((this.V.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.I);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a0 = new Rect();
        this.b0 = new Rect();
        this.c0 = new int[2];
        this.d0 = new int[2];
        this.F0 = new b();
        this.G0 = new c();
        this.H0 = new WeakHashMap<>();
        f fVar = new f();
        this.I0 = fVar;
        this.J0 = new g();
        h hVar = new h();
        this.K0 = hVar;
        i iVar = new i();
        this.L0 = iVar;
        j jVar = new j();
        this.M0 = jVar;
        this.N0 = new a();
        t1 t1VarU = t1.u(context, attributeSet, h.a.j.W1, i2, 0);
        LayoutInflater.from(context).inflate(t1VarU.m(h.a.j.g2, h.a.g.t), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(h.a.f.J);
        this.I = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.J = findViewById(h.a.f.F);
        View viewFindViewById = findViewById(h.a.f.I);
        this.K = viewFindViewById;
        View viewFindViewById2 = findViewById(h.a.f.P);
        this.M = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(h.a.f.D);
        this.O = imageView;
        ImageView imageView2 = (ImageView) findViewById(h.a.f.G);
        this.P = imageView2;
        ImageView imageView3 = (ImageView) findViewById(h.a.f.E);
        this.Q = imageView3;
        ImageView imageView4 = (ImageView) findViewById(h.a.f.K);
        this.U = imageView4;
        ImageView imageView5 = (ImageView) findViewById(h.a.f.H);
        this.e0 = imageView5;
        h.e.j.s0.a0(viewFindViewById, t1VarU.f(h.a.j.h2));
        h.e.j.s0.a0(viewFindViewById2, t1VarU.f(h.a.j.l2));
        int i3 = h.a.j.k2;
        imageView.setImageDrawable(t1VarU.f(i3));
        imageView2.setImageDrawable(t1VarU.f(h.a.j.e2));
        imageView3.setImageDrawable(t1VarU.f(h.a.j.b2));
        imageView4.setImageDrawable(t1VarU.f(h.a.j.n2));
        imageView5.setImageDrawable(t1VarU.f(i3));
        this.f0 = t1VarU.f(h.a.j.j2);
        y1.a(imageView, getResources().getString(h.a.h.p));
        this.g0 = t1VarU.m(h.a.j.m2, h.a.g.s);
        this.h0 = t1VarU.m(h.a.j.c2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.N0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.J0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(t1VarU.a(h.a.j.f2, true));
        int iE = t1VarU.e(h.a.j.Y1, -1);
        if (iE != -1) {
            setMaxWidth(iE);
        }
        this.k0 = t1VarU.o(h.a.j.d2);
        this.u0 = t1VarU.o(h.a.j.i2);
        int iJ = t1VarU.j(h.a.j.a2, -1);
        if (iJ != -1) {
            setImeOptions(iJ);
        }
        int iJ2 = t1VarU.j(h.a.j.Z1, -1);
        if (iJ2 != -1) {
            setInputType(iJ2);
        }
        setFocusable(t1VarU.a(h.a.j.X1, true));
        t1VarU.v();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.i0 = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.j0 = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.V = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        h0(this.q0);
        d0();
    }

    private void setQuery(CharSequence charSequence) {
        this.I.setText(charSequence);
        this.I.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }
}
