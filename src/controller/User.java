package controller;

import model.MediaItem;

import java.util.ArrayList;

public class User {
    public String searchMediaByTitle(ArrayList<MediaItem> mediaItems, String title) {
        String message;
        if (mediaItems.size() == 0) {
            message ="Database is empty";
        } else {

            for (MediaItem mediaItem : mediaItems) {
                if (title.equals(mediaItem.getName())) {
                    message = mediaItem.toString();
                    return message;
                }
            }


            message = "Media not found";
        }
        return message;
    }

    public String searchMediaByAuthor(ArrayList<MediaItem> mediaItems, String author) {
        String message;
        if (mediaItems.size() == 0) {
            message ="Database is empty";
        } else {

            for (MediaItem mediaItem : mediaItems) {
                if (author.equals(mediaItem.getAuthor())) {
                    message = mediaItem.toString();
                    return message;
                }
            }
            message = "Media not found";
        }
        return message;
    }

    public String rentMedia(ArrayList<MediaItem> mediaItems, String title) {
        String message;

        if (mediaItems.size() == 0) {
            message ="Database is empty";
        } else {
            for (MediaItem mediaItem : mediaItems) {
                if (title.equals(mediaItem.getName()) && !mediaItem.isRented() && !mediaItem.isReserved()) {
                    mediaItem.setRented(true);
                    message = "Media Rented";
                    return message;
                } else if (title.equals(mediaItem.getName()) && (mediaItem.isRented()) || mediaItem.isReserved()) {
                    message = "Media is unavailable at the moment";
                    return message;
                }
            }
            message = "Media not found";
        }
        return message;
    }

    public String returnMedia(ArrayList<MediaItem> mediaItems, String title) {
        String message;
        if (mediaItems.size() == 0) {
            message ="Database is empty";
        } else {

            for (MediaItem mediaItem : mediaItems) {
                if (title.equals(mediaItem.getName()) && mediaItem.isRented()) {
                    mediaItem.setRented(false);
                    message = "Media Returned";
                    return message;
                } else if (title.equals(mediaItem.getName()) && !mediaItem.isRented()) {
                    message = "This media is not rented";
                    return message;
                }
            }

            message = "Media not found";
        }
        return message;
    }

    public String reserveMedia(ArrayList<MediaItem> mediaItems, String title) {
        return null;
        }

    public String preview(ArrayList<MediaItem> mediaItems, String title) {
        return null;
    }
}
