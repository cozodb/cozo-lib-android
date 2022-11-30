/*
 * Copyright 2022, The Cozo Project Authors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.cozodb;

public class CozoJavaBridge {
    private static native int openDb(String engine, String path, String options);

    private static native boolean closeDb(int id);

    private static native String runQuery(int id, String script, String params);

    private static native String exportRelations(int id, String rel);

    private static native String importRelations(int id, String data);

    private static native String backup(int id, String file);

    private static native String restore(int id, String file);

    private static native String importFromBackup(int id, String data);

    private final int dbId;

    static {
        System.loadLibrary("cozo_java");
    }

    public CozoJavaBridge() {
        this("mem", "");
    }

    public CozoJavaBridge(String kind, String path) {
        this(kind, path, "{}");
    }

    public CozoJavaBridge(String kind, String path, String config) {
        int id = CozoJavaBridge.openDb(kind, path, config);
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

    public String importRelations(String data) {
        return CozoJavaBridge.importRelations(this.dbId, data);
    }

    public String backup(String path) {
        return CozoJavaBridge.backup(this.dbId, path);
    }

    public String restore(String path) {
        return CozoJavaBridge.restore(this.dbId, path);
    }

    public String importRelationsFromBackup(String data) {
        return CozoJavaBridge.importFromBackup(this.dbId, data);
    }
}