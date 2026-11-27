package com.jsj.autojs.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.tencent.cursor.R;

/* loaded from: classes.dex */
public class A592aa6ab95 extends com.yl.ui.p {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k0(View view) {
        Y("如果无法加入频道，可发邮件至chenai@skyingidea.com");
        if (com.user.w.h().k(com.frame.v0.g())) {
            com.jsj.autojs.l.c0.e().g();
        } else {
            com.jsj.autojs.l.c0.e().h();
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492899;
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((TextView) findViewById(R.id.tv_content)).setText(Html.fromHtml("<big><strong>常见问题Q&A：</strong></big><br/><br/><strong>问：为什么执行任务没完成就中断了？</strong><br/>答：大部分手机为了降低能耗，会在软件进入后台后杀死软件或使软件进入休眠状态，导致软件无法正常工作。为了防止此类情况，请在软件首页点击右上角“权限加固”按钮，根据提示进行设置，尤其使“自启动”和“防止异常退出”这两项。检查软件时候被杀死的方法：查看‘无障碍’权限是否丢失或通知了是否有本软件的通知条。<br/><br/><strong>问：为什么我设置的定时执行/自动触发等不起作用？</strong><br/>答：同上，除此之外，清勿将自动脚本精灵app从多任务页面划掉，部分手机即便授予自启动权限，划掉后也无法自启动。<br/><br/><strong>问：为什么无法在电脑模拟器上运行？</strong><br/>答：为了减小安装包大小，应用市场下载的默认是去除x86兼容包，要下载完整安装包请进入VIP群下载即可全兼容了。<br/><br/><strong>问：为什么定时执行脚本，没有执行呢？</strong><br/>答：大部分手机为了降低耗能，黑屏后限制app亮屏操作，我们可以通过日历唤起亮屏，就可以执行定时脚本了，这就需要开启日历权限和检测日历APP的通知栏权限开启，并且得关闭手机自带的息屏显示功能。"));
        findViewById(2131296450).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.k0(view);
            }
        });
    }
}
