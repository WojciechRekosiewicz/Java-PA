package model;

import model.interfaces.Listenable;

public class Song extends MediaItem implements Listenable {


    public Song(String name, String author, int length, int releaseYear, boolean isRented, boolean isReserved, String genus, String teaser) {
        super(name, author, length, releaseYear, isRented, isReserved, genus, teaser);
    }

    @Override
    public void listen() {

    }
}
