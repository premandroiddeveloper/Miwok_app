package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {


Mivokele mi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Mivokele> arr1=new ArrayList<>();
        arr1.add(new Mivokele("one","title",R.drawable.number_one,R.raw.number_one));
        arr1.add(new Mivokele("two","kindle",R.drawable.number_two,R.raw.number_two));
        arr1.add(new Mivokele("three","amazon",R.drawable.number_three,R.raw.number_three));
        arr1.add(new Mivokele("four","google",R.drawable.number_four,R.raw.number_four));
        arr1.add(new Mivokele("five","flipkart",R.drawable.number_five,R.raw.number_five));
        arr1.add(new Mivokele("six","happen",R.drawable.number_six,R.raw.number_six));

        final WordAdapter arrd1= new WordAdapter(this,arr1,R.color.red);
         ListView l1=(ListView)findViewById(R.id.grid);
        l1.setAdapter(arrd1);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mivokele mi=arr1.get(position);
               MediaPlayer mp1=MediaPlayer.create(NumbersActivity.this,mi.getsongid());
                mp1.start();
            }
        });
    }
}