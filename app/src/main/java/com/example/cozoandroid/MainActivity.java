package com.example.cozoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import org.cozodb.CozoJavaBridge;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        String filePath = context.getExternalFilesDir(null).toString()
                + "/data.db";

        CozoJavaBridge db = new CozoJavaBridge("sqlite", filePath);
        String query = "love[loving, loved] <- [['alice', 'eve'],\n" +
                "                        ['bob', 'alice'],\n" +
                "                        ['eve', 'alice'],\n" +
                "                        ['eve', 'bob'],\n" +
                "                        ['eve', 'charlie'],\n" +
                "                        ['charlie', 'eve'],\n" +
                "                        ['david', 'george'],\n" +
                "                        ['george', 'george']]\n" +
                "\n" +
                "?[person, page_rank] <~ PageRank(love[])";
        String res = db.query(query, "");

        ((TextView) findViewById(R.id.textField)).setText(res);

    }
}