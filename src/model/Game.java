package model;

import model.interfaces.Playable;

public class Game extends MediaItem implements Playable {
    public Game(String name, String author, int length, int releaseYear, boolean isRented, boolean isReserved, String genus) {
        super(name, author, length, releaseYear, isRented, isReserved, genus);
    }

    @Override
    public void play() {

    }
}
