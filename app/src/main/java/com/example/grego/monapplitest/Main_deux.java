package com.example.grego.monapplitest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.layout_height;
import static android.R.attr.layout_width;

public class Main_deux extends AppCompatActivity {
    ListView mListView;
    String[] prenoms = new String[]{
        "Grégoire - 16/12/1996",
        "Geraldo - 25/05/1995",
        "Nicolas - 10/10/1995"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_deux);
        IntentFilter intentFilter = new IntentFilter(NAME_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new nameUpdate(), intentFilter);
        mListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main_deux.this, android.R.layout.simple_list_item_1, prenoms);
        mListView.setAdapter(adapter);
    }

    public void OnClick2(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        Log.i("Gregoire", "Retour Accueil");
    }

    public static final String NAME_UPDATE = "http://applibirthday.alwaysdata.net/birthday.json";


    public class nameUpdate extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {

            ArrayList<String> ls;
            getNameFromFile();


        }

        public JSONArray getNameFromFile() {
            try {
                InputStream is = new FileInputStream(getCacheDir() + "/" + " birthday.json");
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                is.close();
                return new JSONArray(new String(buffer, "UTF-8"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return new JSONArray();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return new JSONArray();
                    }
                }
            }


    }





