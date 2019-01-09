package model.media;

import model.interfaces.Playable;

public class Game extends MediaItem implements Playable {
    public Game(String name, String author, int length, int releaseYear, boolean isRented, boolean isReserved, String teaser) {
        super(name, author, length, releaseYear, isRented, isReserved, teaser);
    }

    @Override
    String displayLength() {
        return "" + getLength() + " minutes";
    }

    @Override
    String getGenus() {
        return "Game";
    }

    @Override
    public void play() {

    }
}
