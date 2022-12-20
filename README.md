# CozoDB for Android

[![android](https://img.shields.io/maven-central/v/io.github.cozodb/cozo_android)](https://mvnrepository.com/artifact/io.github.cozodb/cozo_android)

This document describes how to set up Cozo for use in Android.
To learn how to use CozoDB (CozoScript), follow
the [tutorial](https://github.com/cozodb/cozo-docs/blob/main/tutorial/tutorial.ipynb)
first and then read the [manual](https://cozodb.github.io/current/manual/). You can run all the queries
described in the tutorial with an in-browser DB [here](https://cozodb.github.io/wasm-demo/).

## Installation

Artefacts are on Maven central:

```groovy
implementation 'io.github.cozodb:cozo_android:0.3.0'
```

## Usage

The API is identical to that in the [JVM library](https://github.com/cozodb/cozo-lib-java).

You can build upon the example project [here](https://github.com/cozodb/cozo-android-example).

## Reducing app size

In `build.gradle` of your app:
```groovy
android {
    defaultConfig {
        ndk {
            abiFilters 'arm64-v8a', 'x86'
        }
    }
}
```

* [Android ABIs](https://developer.android.com/ndk/guides/abis)
* [App bundles](https://developer.android.com/guide/app-bundle)
* [Multiple APKs](https://developer.android.com/studio/build/configure-apk-splits)
