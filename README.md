# CozoDB for Android

[![android](https://img.shields.io/maven-central/v/io.github.cozodb/cozo_android)](https://mvnrepository.com/artifact/io.github.cozodb/cozo_android)

This document describes how to set up Cozo for use in Android.
To learn how to use CozoDB (CozoScript), read the [docs](https://docs.cozodb.org/en/latest/index.html).

## Installation

Artefacts are on [Maven central](https://mvnrepository.com/artifact/io.github.cozodb/cozo_android):

```groovy
implementation 'io.github.cozodb:cozo_android:0.7.2'
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

For more information: 

* [Android ABIs](https://developer.android.com/ndk/guides/abis)
* [App bundles](https://developer.android.com/guide/app-bundle)
* [Multiple APKs](https://developer.android.com/studio/build/configure-apk-splits)
