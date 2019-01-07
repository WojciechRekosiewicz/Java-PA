package controller;

import model.User;
import org.junit.Assert;

import model.Data;
import model.Film;
import model.MediaItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class UserOptionsTest {

    private UserOptions userOptions;
    private Data data;
    private ArrayList<MediaItem> testArray;
    private String title;
    private User user;

    @BeforeEach
    public void prepareData() {
        data = new Data();
        testArray = data.arrayCreator();
        userOptions = new UserOptions();
        title = "John Wick";
        user = new User("Zenon");
    }

    @Test
    public void searchMediaByTitle() {
        MediaItem expectedObject = new Film("John Wick", "John Wick", 200,
                2012, false, false, "Movie");

        Assert.assertEquals(expectedObject.toString(), userOptions.searchMediaByTitle(testArray, title));
    }

    @Test
    public void searchMediaByTitle_BadTitle_NotFound() {
        String searchWrong = "Bad title";
        String expectedError = "Media not found";

        Assert.assertEquals(expectedError, userOptions.searchMediaByTitle(testArray, searchWrong));
    }

    @Test
    public void searchMediaByTitle_ArrayNull_Error() {
        String expectedError = "Database is empty";
        ArrayList<MediaItem> emptyArray = new ArrayList<>();

        Assert.assertEquals(expectedError, userOptions.searchMediaByTitle(emptyArray, title));
    }

    @Test
    public void searchMediaByAuthor() {
        String author = "Carl Rinsch";
        MediaItem expectedObject = new Film("47 Ronin", "Carl Rinsch", 128,
                2013, false, false, "Movie");

        Assert.assertEquals(expectedObject.toString(), userOptions.searchMediaByAuthor(testArray, author));
    }

    @Test
    public void searchMediaByAuthor_BadTitle_NotFound() {
        String searchWrong = "Bad title";
        String expectedError = "Media not found";

        Assert.assertEquals(expectedError, userOptions.searchMediaByAuthor(testArray, searchWrong));
    }

    @Test
    public void searchMediaByAuthor_ArrayNull_Error() {
        String author = "Carl Rinsch";
        String expectedError = "Database is empty";
        ArrayList<MediaItem> emptyArray = new ArrayList<>();

        Assert.assertEquals(expectedError, userOptions.searchMediaByAuthor(emptyArray, author));
    }

    @Test
    public void rentMedia() {
        String secondTitle = "47 Ronin";
        String expectedAlert = "Media Rented";
        boolean expectedChange = true;
        int expectedSize = 2;

        userOptions.rentMedia(testArray, title, user);

        Assert.assertEquals(expectedChange, testArray.get(0).isRented());
        Assert.assertEquals(expectedAlert, userOptions.rentMedia(testArray, secondTitle, user));
        Assert.assertEquals(expectedSize, user.getUserDeposit().size());

    }

    @Test
    public void rentMedia_BadTitle_NotFound() {
        String expectedError = "Media not found";
        String searchWrong = "Bad title";
        boolean expectedChange = true;

        userOptions.rentMedia(testArray, title, user);

        Assert.assertEquals(expectedChange, testArray.get(0).isRented());
        Assert.assertEquals(expectedError, userOptions.rentMedia(testArray, searchWrong, user));
    }

    @Test
    public void rentMedia_TitleRented_TitleUnavailable() {
        String secondTitle = "47 Ronin";
        String expectedError = "Media is unavailable at the moment";


        //set title to rented and reserved status manually
        testArray.get(0).setRented(true);
        testArray.get(1).setReserved(true);

        Assert.assertEquals(expectedError, userOptions.rentMedia(testArray, title, user));
        Assert.assertEquals(expectedError, userOptions.rentMedia(testArray, secondTitle, user));
    }

    @Test
    public void rentMedia_ArrayNull_Error() {
        String expectedError = "Database is empty";
        ArrayList<MediaItem> emptyArray = new ArrayList<>();


        Assert.assertEquals(expectedError, userOptions.rentMedia(emptyArray, title, user));
    }

    @Test
    public void returnMedia() {
        String mediaRented = "47 Ronin";
        String expectedAlert = "Media Returned";
        boolean expectedChange = false;
        int expectedSize = 0;

        //set title to rented status manually
//        testArray.get(0).setRented(true);
//        testArray.get(1).setRented(true);
        userOptions.rentMedia(testArray, mediaRented, user);
        userOptions.rentMedia(testArray, title, user);


        userOptions.returnMedia(testArray, title, user);

        Assert.assertEquals(expectedChange, testArray.get(0).isRented());
        Assert.assertEquals(expectedAlert, userOptions.returnMedia(testArray, mediaRented, user));
        Assert.assertEquals(expectedSize, user.getUserDeposit().size());

    }

    @Test
    public void returnMedia_TitleNotRented_TitleAvailable() {
        String media = "47 Ronin";
        String expectedAlert = "This media is not rented";

        Assert.assertEquals(expectedAlert, userOptions.returnMedia(testArray, media, user));
    }

    @Test
    public void returnMedia_BadTitle_NotFound() {
        String expectedError = "Media not found";
        String searchWrong = "Bad title";

        Assert.assertEquals(expectedError, userOptions.returnMedia(testArray, searchWrong, user));
    }

    @Test
    public void returnItem_ArrayNull_Error() {
        String expectedError = "Database is empty";
        ArrayList<MediaItem> emptyArray = new ArrayList<>();

        Assert.assertEquals(expectedError, userOptions.returnMedia(emptyArray, title, user));
    }
}