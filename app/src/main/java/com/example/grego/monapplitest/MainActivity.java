package com.example.grego.monapplitest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.grego.monapplitest.R.id.textView;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "http://api.androidhive.info/contacts/";

    ArrayList<HashMap<String, String>> contactList;

    TextView d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View w = findViewById(textView);
        d= (TextView)w;

        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView);
    }

    public void OnClick(View v){
        Intent i = new Intent(this, HttpHandler.class);
        startService(i);

        //Context context = getApplicationContext();
        //CharSequence text = "Bouton cliqué !";
        //Log.i("Gregoire", "Bouton cliqué");
        //d.setText("Bouton appuyé !");
        //int duration = Toast.LENGTH_SHORT;

        //Toast toast = Toast.makeText(context, text, duration);
        //toast.show();
    }

    public void OnClick3(View v){
        Intent i = new Intent(this, Main_deux.class);
        startActivity(i);
        Log.i("Gregoire", "Bouton cliqué");
        d.setText("Bouton appuyé !");



    }
}

