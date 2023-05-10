# Cozo 数据库 Android 库

[![android](https://img.shields.io/maven-central/v/io.github.cozodb/cozo_android)](https://mvnrepository.com/artifact/io.github.cozodb/cozo_android)

本文叙述的是如何安装设置库本身。有关如何使用 CozoDB（CozoScript）的信息，见 [文档](https://docs.cozodb.org/zh_CN/latest/index.html) 。

## 安装

库可从 [maven central](https://mvnrepository.com/artifact/io.github.cozodb/cozo_android) 下载：

```groovy
implementation 'io.github.cozodb:cozo_android:0.7.1'
```

## 使用方法

与在 [JVM 里使用](https://github.com/cozodb/cozo-lib-java/blob/main/README-zh.md) （ [国内镜像](https://gitee.com/cozodb/cozo-lib-java) ） 方式一样。

[这里](https://github.com/cozodb/cozo-android-example) （ [国内镜像](https://gitee.com/cozodb/cozo-android-example) ） 有一个示例项目。

## 给安装包减肥

在你的 App 的 `build.gradle` 中添加：

```groovy
android {
    defaultConfig {
        ndk {
            abiFilters 'arm64-v8a', 'x86'
        }
    }
}
```

相关信息参见：

* [Android 的 ABI](https://developer.android.com/ndk/guides/abis)
* [App bundles](https://developer.android.com/guide/app-bundle)
* [多个 APK](https://developer.android.com/studio/build/configure-apk-splits)
