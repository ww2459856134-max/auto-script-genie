# 自动脚本精灵 26.11.19 — 反编译源码

> 仅供学习、研究与安全分析使用。请勿用于商业用途或二次分发。

## 说明

- 来源：`自动脚本精灵_26.11.19.apk`（67,140,900 字节，sha256 `deb328d7…`）
- 包名：`com.jsj.autojs`
- 版本：26.11.19（versionCode 202611190），minSdk 24 / targetSdk 33
- 应用是一个 RPA/自动化脚本工具：无障碍服务、截屏、OCR、脚本编辑器、Excel、悬浮窗等

反编译方式：原包为私有加固（壳 + 加密载荷），从运行中的进程里取出解密后的 4 个 dex，再用 jadx 1.5.3 还原为 Java。

## 目录

```
java/                 jadx 还原的 Java 源码（约 7800 个文件）
res/                  资源（含多语言 values、布局、xml）
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
- `n/a/a`、`k/a0/a`、`i/b/*`：混淆后的业务/第三方代码

> 注：本仓库不包含加固壳（`com.jsjs`）的代码，那是原 APK `classes.dex` 里的壳，不属于业务源码。

## 关于编译

jadx 输出用于阅读，不能直接编译。要回编译：

1. 用 apktool 解包原 APK，得到 `smali/`、`res/`；
2. 参考本仓库的 Java 修改 `smali`；
3. `apktool b` 后重新签名（需要自己的 keystore）。

## 免责声明

本项目仅用于个人学习、逆向工程研究与安全分析。请遵守当地法律法规，不要用于侵犯他人权益、制作外挂/作弊器或商业分发。如有侵权，请联系删除。
