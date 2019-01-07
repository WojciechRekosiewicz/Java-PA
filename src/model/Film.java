package model;

import model.interfaces.Watchable;

public class Film extends MediaItem implements Watchable {
    public Film(String name, String author, int length, int releaseDate, boolean isRented,
                boolean isReserved, String genus) {
        super(name, author, length, releaseDate, isRented, isReserved, genus);
    }

    @Override
    public void watch() {

    }
}