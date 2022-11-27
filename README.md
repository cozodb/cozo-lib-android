# CozoDB for Android

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
