#!/usr/bin/env bash

rm -f app/src/main/jniLibs/*/*.so

COZO_HOME=~/cozo

cp $COZO_HOME/release/libcozo_java-*-aarch64-linux-android.so.gz app/src/main/jniLibs/arm64-v8a/libcozo_java.so.gz
cp $COZO_HOME/release/libcozo_java-*-armv7-linux-androideabi.so.gz app/src/main/jniLibs/armeabi-v7a/libcozo_java.so.gz
cp $COZO_HOME/release/libcozo_java-*-i686-linux-android.so.gz app/src/main/jniLibs/x86/libcozo_java.so.gz
cp $COZO_HOME/release/libcozo_java-*-x86_64-linux-android.so.gz app/src/main/jniLibs/x86_64/libcozo_java.so.gz

gunzip app/src/main/jniLibs/*/*.so.gz