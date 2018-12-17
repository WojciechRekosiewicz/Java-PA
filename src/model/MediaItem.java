package model;

public abstract class MediaItem {
    private String name;

    private String author;
    private int length;
    private int releaseYear;
    private boolean isRented;
    private boolean isReserved;
    private String genus;

    protected MediaItem(String name, String author, int length, int releaseYear,
                        boolean isRented, boolean isReserved, String genus) {
        this.name = name;
        this.author = author;
        this.length = length;
        this.releaseYear = releaseYear;
        this.isRented = isRented;
        this.isReserved = isReserved;
        this.genus = genus;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
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
            return "available";
        }
        return "not available";

    }

    private String checkerReserved(){
        if (isReserved){
            return "available";
        }
        return "not available";
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    @Override
    public String toString() {
        return "MediaItem{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", length=" + length +
                ", releaseYear=" + releaseYear +
                ", isRented=" + checkerRent() +
                ", isReserved=" + checkerReserved() +
                ", genus=" + genus +
                '}';
    }
}
