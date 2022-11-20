package org.cozodb;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

public class CozoJavaBridge {
    private static native int openDb(String kind, String path);

    private static native boolean closeDb(int id);

    private static native String runQuery(int id, String script, String params);

    private static native String exportRelations(int id, String rel);

    private static native String importRelations(int id, String data);

    private static native String backup(int id, String file);

    private static native String restore(int id, String file);

    private final int dbId;

    static {
        System.loadLibrary("cozo_java");
    }

    public CozoJavaBridge(String kind, String path) {
        int id = CozoJavaBridge.openDb(kind, path);
        if (id < 0) {
            throw new RuntimeException("cannot create database: error code " + id);
        }
        this.dbId = id;
    }

    public String query(String script, String params) {
        return CozoJavaBridge.runQuery(this.dbId, script, params);
    }

    public boolean close() {
        return CozoJavaBridge.closeDb(this.dbId);
    }

    public String exportRelations(String desc) {
        return CozoJavaBridge.exportRelations(this.dbId, desc);
    }

    public String exportRelation(String data) {
        return CozoJavaBridge.importRelations(this.dbId, data);
    }

    public String backup(String path) {
        return CozoJavaBridge.backup(this.dbId, path);
    }

    public String restore(String path) {
        return CozoJavaBridge.restore(this.dbId, path);
    }

//    public static void main(String[] args) {
//        CozoJavaBridge db = new CozoJavaBridge("mem", "");
//        System.out.println(db);
//        System.out.println(db.query("?[] <- [[1, 2, 3]]", ""));
//        System.out.println(db.query("?[z] <- [[1, 2, 3]]", ""));
//        System.out.println(db.close());
//    }
}