package model;

import model.media.Book;
import model.media.Film;
import model.media.MediaItem;
import model.media.Song;

import java.util.ArrayList;

public class Data {

    private String[] name = {"John Wick", "47 Ronin", "Lemmy", "Gamedec", "The Final Frontier", "Toxicity"};
    private String[] author ={"John Wick", "Carl Rinsch", "Lemmy", "Marcin Przybylek", "Iron Maiden", "System of a down"};
    private int[] length ={200, 128, 500, 400, 60, 45};
    private int[] releaseDate ={2012, 2013, 2010, 2002, 2015, 2005};
    private boolean isRented = false;
    private boolean isReserved = false;
    private String[] genus = {"Movie", "Movie", "Movie", "Book", "Book", "Album", "Album"};
    private String[] teaser = {"Man shoots", "Man slice", "Lemmy rocks", "Future of VR", "Great album ",
            "System of a down album"};

    public ArrayList<MediaItem> arrayCreator(){
        ArrayList<MediaItem> mediaItemArray = new ArrayList<>();
        for (int x = 0; x < name.length; x++){
            if (x < 2 ){
                mediaItemArray.add(x, new Film(name[x], author[x], length[x],
                        releaseDate[x], isRented, isReserved, teaser[x]));
            }
            else if (x < 4 && x >= 2 ){
                mediaItemArray.add(x, new Book(name[x], author[x], length[x],
                        releaseDate[x], isRented, isReserved, teaser[x]));
            }
            else if (x >= 4 && x < 6 ){
                mediaItemArray.add(x, new Song(name[x], author[x], length[x],
                        releaseDate[x], isRented, isReserved, teaser[x]));
            }}
        return mediaItemArray;
    }
}

