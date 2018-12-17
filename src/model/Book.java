package model;

import model.interfaces.Readable;

public class Book extends MediaItem implements Readable {


    public Book(String name, String author, int length, int releaseDate,
                boolean isRented, boolean isReserved, String genus) {
        super(name, author, length, releaseDate, isRented, isReserved, genus);
    }

    @Override
    public void read() {
    }
}

