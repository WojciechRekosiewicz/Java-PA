package model.media;

import model.interfaces.Watchable;

public class Film extends MediaItem implements Watchable {
    public Film(String name, String author, int length, int releaseYear, boolean isRented, boolean isReserved, String teaser) {
        super(name, author, length, releaseYear, isRented, isReserved, teaser);
    }

    @Override
    String displayLength() {
        return "" + getLength() + " minutes";
    }

    @Override
    String getGenus() {
        return "Movie";
    }


    @Override
    public void watch() {
    }
}