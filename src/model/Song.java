package model;

import model.interfaces.Listenable;

public class Song extends MediaItem implements Listenable {

    public Song(String name, String author, int length, int releaseDate, boolean isRented,
                boolean isReserved, String genus) {
        super(name, author, length, releaseDate, isRented, isReserved, genus);
    }

    @Override
    public void listen() {

    }
}
