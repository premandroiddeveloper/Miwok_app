package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Mivokele> arr1=new ArrayList<>();
        arr1.add(new Mivokele("wettetji","red",R.drawable.color_red,R.raw.color_red));
        arr1.add(new Mivokele("chiwitta","yellow",R.drawable.color_mustard_yellow));
        arr1.add(new Mivokele("topisla","dusti yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        arr1.add(new Mivokele("topoppi","grey",R.drawable.color_gray,R.raw.color_gray));
        arr1.add(new Mivokele("kululli","black",R.drawable.color_black,R.raw.color_black));
        arr1.add(new Mivokele("kelelli","white",R.drawable.color_white,R.raw.color_white));

        WordAdapter arrd1= new WordAdapter(this,arr1,R.color.darkblue);
        ListView l1=(ListView)findViewById(R.id.color);
        l1.setAdapter(arrd1);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mivokele mi=arr1.get(position);
               MediaPlayer mp4= MediaPlayer.create(ColorsActivity.this,mi.getsongid());
                mp4.start();
            }
        });
    }
}