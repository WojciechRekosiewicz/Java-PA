package model.media;

public abstract class MediaItem {
    private String name;

    private String author;

    public int getLength() {
        return length;
    }

    private int length;
    private int releaseYear;
    private boolean isRented;
    private boolean isReserved;
    private String teaser;


    protected MediaItem(String name, String author, int length, int releaseYear,
                        boolean isRented, boolean isReserved, String teaser) {
        this.name = name;
        this.author = author;
        this.length = length;
        this.releaseYear = releaseYear;
        this.isRented = isRented;
        this.isReserved = isReserved;
        this.teaser = teaser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    private String checkerRent(){
        if (isRented){
            return "Rented";
        }
        return "Not rented";

    }

    private String checkerReserved(){
        if (isReserved){
            return "Reserved";
        }
        return "Not reserved";
    }

    public String getTeaser() {
        return teaser;
    }

    abstract String displayLength();

    @Override
    public String toString() {
        return "Title -> " + name +
                ", Author " + author + ", " +
                displayLength() + " " +
                ", ReleaseYear " + releaseYear +
                ", " + checkerRent() + ", " +
                checkerReserved() + ", " +
                ", Genus " + getGenus() +
                '.';
    }

    protected abstract String getGenus();


}
