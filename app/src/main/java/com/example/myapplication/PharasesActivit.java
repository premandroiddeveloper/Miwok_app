package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PharasesActivit extends AppCompatActivity {
    MediaPlayer mp2;
AudioManager amn;


AudioManager.OnAudioFocusChangeListener monAudio=
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if(focusChange==AudioManager.AUDIOFOCUS_GAIN_TRANSIENT || focusChange==AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK){
                        mp2.pause();
                        mp2.seekTo(0);
                    }
                    else if(focusChange==AudioManager.AUDIOFOCUS_GAIN){
                        mp2.start();
                    }
                    else if(focusChange==AudioManager.AUDIOFOCUS_LOSS){
                        releaseInstance();
                    }
                }
            };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharases);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Mivokele> arr1 = new ArrayList<>();
        arr1.add(new Mivokele("minto wuksus", "Where are you going?\n" +
                "\n", R.raw.phrase_where_are_you_going));
        arr1.add(new Mivokele("tinnә oyaase'nә", "What is your name?", R.raw.phrase_what_is_your_name));
        arr1.add(new Mivokele("oyaaset...", "My name is...", R.raw.phrase_my_name_is));
        arr1.add(new Mivokele("michәksәs?", "How are you feeling?", R.raw.phrase_how_are_you_feeling));
        arr1.add(new Mivokele("kuchi achit", "I’m feeling good.", R.raw.phrase_im_feeling_good));
        arr1.add(new Mivokele("әәnәs'aa?", "Are you coming?", R.raw.phrase_are_you_coming));
        amn = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        WordAdapter arrd1 = new WordAdapter(this, arr1, R.color.colorAccent);
        ListView l1 = (ListView) findViewById(R.id.phrase);
        l1.setAdapter(arrd1);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mivokele mi = arr1.get(position);
                int result = amn.requestAudioFocus(monAudio, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mp2 = MediaPlayer.create(PharasesActivit.this, mi.getsongid());
                    mp2.start();
                    mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                           releaseInstance();
                        }
                    });

                }

            }


        });


        }

    @Override
    protected void onStop() {
        super.onStop();
        mp2.stop();
    }
}




