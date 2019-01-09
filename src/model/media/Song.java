package model.media;

import model.interfaces.Listenable;

public class Song extends MediaItem implements Listenable {


    public Song(String name, String author, int length, int releaseYear, boolean isRented, boolean isReserved, String teaser) {
        super(name, author, length, releaseYear, isRented, isReserved, teaser);
    }

    @Override
    String displayLength() {
        return "" + getLength() + " minutes";
    }

    @Override
    protected String getGenus()
    {
        return "Song";
    }

    @Override
    public void listen() {

    }
}
