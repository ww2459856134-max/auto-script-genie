package i.b;

import com.yl.model.TaskSimple;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/* loaded from: classes.dex */
class x9 implements Comparator<TaskSimple> {
    x9(da daVar) {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(TaskSimple taskSimple, TaskSimple taskSimple2) {
        String name = taskSimple.getName();
        String name2 = taskSimple2.getName();
        if (name == null || name2 == null) {
            return -1;
        }
        return Collator.getInstance(Locale.CHINA).compare(name, name2);
    }
}
