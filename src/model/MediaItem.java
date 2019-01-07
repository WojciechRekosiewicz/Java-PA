package model;

public abstract class MediaItem {
    private String name;

    private String author;
    private int length;
    private int releaseYear;
    private boolean isRented;
    private boolean isReserved;
    private String genus;

    public String getTeaser() {
        return teaser;
    }

    private String teaser;


    protected MediaItem(String name, String author, int length, int releaseYear,
                        boolean isRented, boolean isReserved, String genus, String teaser) {
        this.name = name;
        this.author = author;
        this.length = length;
        this.releaseYear = releaseYear;
        this.isRented = isRented;
        this.isReserved = isReserved;
        this.genus = genus;
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

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
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

    private String displayLength() {
        Integer toConvert = length;
        String sLength = toConvert.toString();
        if (genus.equals("Movie") || genus.equals("Song")) {
            return sLength + " minutes";
        } else if (genus.equals("Book")) {
            return sLength + " pages";
        }
        return sLength;
    }

    @Override
    public String toString() {
        return "Title -> " + name +
                ", Author " + author + ", " +
                displayLength() + " " +
                ", ReleaseYear " + releaseYear +
                ", " + checkerRent() + ", " +
                checkerReserved() + ", " +
                ", Genus " + genus +
                '}';
    }
}
