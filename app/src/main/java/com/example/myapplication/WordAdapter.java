package com.example.myapplication;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Mivokele> {
    MediaPlayer mp1;

    private int colorid;
    public WordAdapter(Activity context, ArrayList<Mivokele> mivokword,int color){
        super(context,0,mivokword);
        colorid=color;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Mivokele currentword=getItem(position);
        View ListItemView=convertView;
        if(ListItemView==null){
            ListItemView=LayoutInflater.from(getContext()).inflate(R.layout.list_item_1,parent,false);
        }
        TextView t1=(TextView)ListItemView.findViewById(R.id.textView);
        t1.setText(currentword.getMivok());
        TextView t2=(TextView)ListItemView.findViewById(R.id.textView6);
        t2.setText(currentword.getDefault());
        ImageView i1=(ImageView)ListItemView.findViewById(R.id.imageView);
        if(currentword.getanwser())
            i1.setVisibility(View.GONE);
        else{
        i1.setImageResource(currentword.getImages());}
        View textcontainer=ListItemView.findViewById(R.id.layout);
        int colored= ContextCompat.getColor(getContext(),colorid);
        textcontainer.setBackgroundColor(colored);



        return ListItemView;
    }
}
