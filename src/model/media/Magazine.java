package model.media;

import model.interfaces.Readable;

public class Magazine extends MediaItem implements Readable {

    public Magazine(String name, String author, int length, int releaseYear, boolean isRented, boolean isReserved, String genus, String teaser) {
        super(name, author, length, releaseYear, isRented, isReserved, genus, teaser);
    }

    @Override
    public void read() {

    }
}
