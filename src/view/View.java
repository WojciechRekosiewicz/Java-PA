package view;

import controller.ManagerOptions;
import controller.UserOptions;
import model.Data;
import model.media.MediaItem;
import model.people.User;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private Data data = new Data();
    private UserOptions userOptions = new UserOptions();
    private ManagerOptions managerOptions = new ManagerOptions();
    private ArrayList<MediaItem> mediaArray = data.arrayCreator();
    private User user1 = new User("Stefan");

    public void menu() {
        int choose;
        System.out.println("Choose what do you wanna do");
        System.out.println("1. UserOptions options");
        System.out.println("2. ManagerOptions options");
        Scanner scanner = new Scanner(System.in);
        choose = scanner.nextInt();
        switch (choose) {
            case 1:
                userOptions();
                break;
            case 2:
                managerOptions();
                break;
        }

    }

    private void userOptions() {
        int choose;
        System.out.println("Options");
        System.out.println("1. To show all media");
        System.out.println("2. To search media by title");
        System.out.println("3. To rent media");
        System.out.println("0. To go back to menu");
        Scanner scanner = new Scanner(System.in);
        choose = scanner.nextInt();
        switch (choose) {
            case 1:
                displayAll();
                System.out.println();
                displayUser();
                menu();
                break;
            case 2:
                displayByTitle();
                menu();
                break;
            case 3:
                rentOption();
                menu();
                break;
            case 0:
                menu();
                break;
        }
    }

    private void managerOptions() {
        System.out.println("Enter managerOptions password");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        if (managerPassword(password)){
            System.out.println("Correct password!");
            System.out.println("ManagerOptions options");
            int choose;
            System.out.println("1. Add new media ");
            System.out.println("0. To go back to menu");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("media added");
                    menu();
                    break;
                case 0:
                    menu();
                    break;
            }
        } else {
            System.out.println("Bad password");
            menu();
        }
    }

    private void displayByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. To enter one word title");
        System.out.println("2. To enter two word title");
        System.out.println("0. To go back to menu");
        int subChoose = scanner.nextInt();
        switch (subChoose){
            case 1:
                System.out.println("Enter title to display");
                String titleShort = scanner.next();
                System.out.println(userOptions.searchMediaByTitle(mediaArray, titleShort));
                break;

            case 2:
                System.out.println("Enter title to display");
                String titleLong = scanner.next() + " " + scanner.next();
                System.out.println(userOptions.searchMediaByTitle(mediaArray, titleLong));
                break;
            case 0:
                break;
        }
    }


    private void rentOption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. To enter one word title");
        System.out.println("2. To enter two word title");
        System.out.println("0. To go back to menu");
        int subChoose = scanner.nextInt();
        switch (subChoose){
            case 1:
                System.out.println("Enter title to reserve");
                String titleShort = scanner.next();
                System.out.println(userOptions.rentMedia(mediaArray, titleShort, user1));
                break;

            case 2:
                System.out.println("Enter title to reserve");
                String titleLong = scanner.next() + " " + scanner.next();
                System.out.println(userOptions.rentMedia(mediaArray, titleLong, user1));
                break;
            case 0:
                break;
        }
    }

    private void displayAll(){
        for (MediaItem mediaItem : mediaArray) {
            System.out.println( mediaItem.toString());
        }
    }

    private void displayUser(){

        for (int x = 0; x < user1.getUserDeposit().size();x++){
            System.out.println(user1.getUserDeposit().get(x).toString());
        }
//
//        for (MediaItem mediaItem : user1.getUserDeposit()){
//            System.out.println(mediaItem.toString());
//        }
    }


    private boolean managerPassword(String password){
        return "pass".equals(password);
    }
}
