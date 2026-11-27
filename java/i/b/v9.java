package i.b;

import com.yl.model.TaskSimple;
import java.util.Comparator;

/* loaded from: classes.dex */
class v9 implements Comparator<TaskSimple> {
    v9(da daVar) {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(TaskSimple taskSimple, TaskSimple taskSimple2) {
        return (int) (taskSimple2.updateTime - taskSimple.updateTime);
    }
}
