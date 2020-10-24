package com.example.myapplication;

public class Mivokele {
    public String mivok;
    public String english;
    public int song;
    public int images=-1;
    public Mivokele(String mivok,String english,int images,int song){
        this.mivok=mivok;
        this.english=english;
        this.images=images;
        this.song=song;
    }
    public Mivokele(String mivok,String english,int song){
        this.mivok=mivok;
        this.english=english;
        this.song=song;
    }
    public String getMivok(){
        return mivok;}
    public String getDefault(){
        return english;
    }
    public int getImages(){
        return images;
    }
    public int getsongid(){
        return song;
    }
    public boolean getanwser(){
        if(images==-1)
            return true;
        else
            return false;
    }
}
