package model.media;

import model.interfaces.Readable;

public class Magazine extends MediaItem implements Readable {

    public Magazine(String name, String author, int length, int releaseYear, boolean isRented,
                    boolean isReserved, String teaser) {
        super(name, author, length, releaseYear, isRented, isReserved, teaser);
    }

    @Override
    String displayLength() {
        return "" + getLength() + " pages";
    }

    @Override
    String getGenus() {
        return "Magazine";
    }

    @Override
    public void read() {

    }
}
