# 自动脚本精灵 26.11.19 源码

## 说明

- 包名：`com.jsj.autojs`
- 版本：26.11.19（versionCode 202611190），minSdk 24 / targetSdk 33
- 应用是一个 RPA/自动化脚本工具：无障碍服务、截屏、OCR、脚本编辑器、Excel、悬浮窗等

本仓库为 26.11.19 版本的源码整理，供学习与二次开发参考。

## 目录

```
java/                 Java 源码（约 7800 个文件）
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
- `n/a/a`、`k/a0/a`、`i/b/*`：业务/第三方代码

## 关于编译

Java 源码用于阅读参考。要回编译，可在原工程结构上参考修改后重新构建；签名需要自备 keystore。

## 声明

本项目仅用于个人学习、研究与二次开发参考。请遵守当地法律法规，不要用于侵犯他人权益或商业分发。如有侵权，请联系删除。
