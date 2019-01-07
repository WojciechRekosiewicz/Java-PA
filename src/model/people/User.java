package model.people;

import model.media.MediaItem;

import java.util.ArrayList;

public class User {

    private String name;

    private ArrayList<MediaItem> userDeposit = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public ArrayList<MediaItem> getUserDeposit() {
        return userDeposit;
    }

    public void rentItem(MediaItem mediaItem){
        userDeposit.add(mediaItem);
    }

    public void returnItem(MediaItem mediaItem){
        userDeposit.remove(mediaItem);
    }

    public void reserveItem(MediaItem mediaItem){
        userDeposit.add(mediaItem);
    }



}
