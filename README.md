# 自动脚本精灵 26.11.19 源码工程（整理版）

> 本工程由发布版本的安装包整理而来，用于学习与二次开发参考。
> 它不是厂商的原始工程，缺少原始依赖与构建配置，**直接编译无法通过**。

## 说明

- 包名：`com.jsj.autojs`
- 版本：26.11.19（versionCode 202611190），minSdk 24 / targetSdk 33
- 应用是一个 RPA/自动化脚本工具：无障碍服务、截屏、OCR、脚本编辑器、Excel、悬浮窗等

## 目录

```
settings.gradle / build.gradle / gradle.properties
app/
  build.gradle
  src/main/
    java/                 Java 源码（约 7800 个文件）
    res/                  资源（多语言 values、布局、xml）
    assets/               运行资源（已去掉 tesseract 语言包）
    AndroidManifest.xml   完整清单（61 个组件、17 条权限）
```

Java 包结构（节选）：

- `com.jsj.autojs`：应用本体
  - `activity/` 30+ 界面
  - `basicmode/` 基础模式脚本编辑器
  - `autorun/`、`window/`、`widget/`、`model/`
  - `privacy/`、`wxapi/`
- `com.s`：服务（`BoxService` 无障碍、`ScreenshotService` 截屏、`TaskService`、`NotifyService`）
- `com.frame`：无障碍/节点操作框架
- `com.googlecode.tesseract`、`com.v`：OCR 与相关弹窗
- `com.auto.exceldeps`、`org.apache.poi`：Excel 依赖
- `n/a/a`、`k/a0/a`、`i/b/*`：业务/第三方代码

## 编译说明

本工程是**结构参考**，不是可构建状态：

1. 缺少原始 Gradle 依赖（AndroidX、腾讯 SDK、POI、OpenCV、Tesseract 等）；
2. 部分类和资源名经过混淆，`R` 引用需要按 `res/` 重新生成；
3. 约 1,700 个类为反编译 fallback 输出，逻辑需对照 smali。

如需可安装包，见仓库 Releases 中的 APK。

## 声明

本项目仅用于个人学习、研究与二次开发参考。代码版权归原作者所有；请勿用于商业分发或声称原创。如有侵权，请联系删除。
