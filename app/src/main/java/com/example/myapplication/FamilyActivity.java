package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Mivokele> arr1=new ArrayList<>();
        arr1.add(new Mivokele("apa","father",R.drawable.family_father,R.raw.family_father));
        arr1.add(new Mivokele("ata","mother",R.drawable.family_mother,R.raw.family_mother));
        arr1.add(new Mivokele("angsi","son",R.drawable.family_son,R.raw.family_son));
        arr1.add(new Mivokele("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        arr1.add(new Mivokele("taachi","olderbrother",R.drawable.family_older_brother,R.raw.family_older_brother));
        arr1.add(new Mivokele("tete","older sister",R.drawable.family_older_sister,R.raw.family_older_sister));

        WordAdapter arrd1= new WordAdapter(this,arr1,R.color.purple);
        ListView l1=(ListView)findViewById(R.id.family);
        l1.setAdapter(arrd1);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mivokele mi=arr1.get(position);
                MediaPlayer mp3= MediaPlayer.create(FamilyActivity.this,mi.getsongid());
                mp3.start();
            }
        });
    }
}