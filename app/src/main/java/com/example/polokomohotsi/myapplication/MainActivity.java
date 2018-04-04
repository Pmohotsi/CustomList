package com.example.polokomohotsi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
ListView listView;
int[] img_resoure ={R.drawable.batman,R.drawable.stark,R.drawable.ironman};
String[]name={"Batman","Stark","Iron Man"};
String []Qty={"100","200","300"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    listView = findViewById(R.id.mainListView);
     FruitAdapter adapter = new FruitAdapter(getApplicationContext(),R.layout.row_layout);
     listView.setAdapter(adapter);
int i =0;
        for (String Name:name) {
            FruitClass obj = new FruitClass(img_resoure[i], Name,Qty[i]);
            adapter.add(obj);
            i++;

        }
    }
}
