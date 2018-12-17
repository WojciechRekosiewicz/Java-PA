package controller;

import org.junit.Assert;

import model.Data;
import model.Film;
import model.MediaItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class UserTest {

        private User user;
        private Data data;
        private ArrayList<MediaItem> testArray;
        private String title;

        @BeforeEach
        public void prepareData(){
            data = new Data();
            testArray = data.arrayCreator();
            user = new User();
            title = "John Wick";
        }

        @Test
    public void searchMediaByTitle() {
        MediaItem expectedObject = new Film("John Wick", "John Wick", 200,
                2012, false, false, "Movie");

        Assert.assertEquals(expectedObject.toString(), user.searchMediaByTitle(testArray, title) );
    }

    @Test
    public void searchMediaByTitle_BadTitle_NotFound(){
        String searchWrong = "Very bad title";
        String expectedError = "Media not found";

        Assert.assertEquals(expectedError, user.searchMediaByTitle(testArray, searchWrong));
    }

    @Test
    public void searchMediaByTitle_ArrayNull_Error(){
        String expectedError = "Database is empty";
        ArrayList<MediaItem> emptyArray = new ArrayList<>();

        Assert.assertEquals(expectedError, user.searchMediaByTitle(emptyArray, title) );
    }

    @Test
    public void searchMediaByAuthor() {
        String author = "Carl Rinsch";
        MediaItem expectedObject = new Film("47 Ronin", "Carl Rinsch", 128,
                2013, false, false, "Movie");

        Assert.assertEquals(expectedObject.toString(), user.searchMediaByAuthor(testArray, author) );
    }

    @Test
    public void searchMediaByAuthor_BadTitle_NotFound(){
        String searchWrong = "Very bad title";
        String expectedError = "Media not found";

        Assert.assertEquals(expectedError, user.searchMediaByAuthor(testArray, searchWrong));
    }

    @Test
    public void searchMediaByAuthor_ArrayNull_Error(){
        String author = "Carl Rinsch";
        String expectedError = "Database is empty";
        ArrayList<MediaItem> emptyArray = new ArrayList<>();

        Assert.assertEquals(expectedError, user.searchMediaByAuthor(emptyArray, author) );
    }

        @Test
        public void rentMedia() {
            String secondTitle = "47 Ronin";
            String expectedAlert = "Media Rented";
            boolean expectedChange = true;

            user.rentMedia(testArray, title);

            Assert.assertEquals(expectedChange, testArray.get(0).isRented());
            Assert.assertEquals(expectedAlert, user.rentMedia(testArray, secondTitle));

        }

        @Test
        public void rentMedia_BadTitle_NotFound() {
            String expectedError = "Media not found";
            String searchWrong = "very bad title";
            boolean expectedChange = true;

            user.rentMedia(testArray, title);

            Assert.assertEquals(expectedChange, testArray.get(0).isRented());
            Assert.assertEquals(expectedError, user.rentMedia(testArray, searchWrong));
        }

        @Test
        public void rentMedia_TitleRented_TitleUnavailable() {
            String secondTitle = "47 Ronin";
            String expectedError = "Media is unavailable at the moment";


            //set title to rented and reserved status manually
            testArray.get(0).setRented(true);
            testArray.get(1).setReserved(true);

            Assert.assertEquals(expectedError, user.rentMedia(testArray, title));
            Assert.assertEquals(expectedError, user.rentMedia(testArray, secondTitle));
        }

        @Test
        public void rentMedia_ArrayNull_Error(){
            String expectedError = "Database is empty";
            ArrayList<MediaItem> emptyArray = new ArrayList<>();

            Assert.assertEquals(expectedError, user.rentMedia(emptyArray, title) );
        }

        @Test
        public void returnMedia() {
            String mediaRented = "47 Ronin";
            String expectedAlert = "Media Returned";
            boolean expectedChange = false;

            //set title to rented status manually
            testArray.get(0).setRented(true);
            testArray.get(1).setRented(true);

            user.returnMedia(testArray, title);

            Assert.assertEquals(expectedChange, testArray.get(0).isRented());
            Assert.assertEquals(expectedAlert, user.returnMedia(testArray, mediaRented));

        }

        @Test
        public void returnMedia_TitleNotRented_TitleAvailable() {
            String media = "47 Ronin";
            String expectedAlert = "This media is not rented";

            Assert.assertEquals(expectedAlert, user.returnMedia(testArray, media));
        }

        @Test
        public void returnMedia_BadTitle_NotFound() {
            String expectedError = "Media not found";
            String searchWrong = "very bad title";

            Assert.assertEquals(expectedError, user.returnMedia(testArray, searchWrong));
        }

        @Test
        public void returnItem_ArrayNull_Error(){
            String expectedError = "Database is empty";
            ArrayList<MediaItem> emptyArray = new ArrayList<>();

            Assert.assertEquals(expectedError, user.returnMedia(emptyArray, title) );
        }
}