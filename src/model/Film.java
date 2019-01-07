package model;

import model.interfaces.Watchable;

public class Film extends MediaItem implements Watchable {
    public Film(String name, String author, int length, int releaseYear, boolean isRented, boolean isReserved, String genus, String teaser) {
        super(name, author, length, releaseYear, isRented, isReserved, genus, teaser);
    }


    @Override
    public void watch() {
    }
}