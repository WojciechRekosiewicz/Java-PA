package view;

import controller.Manager;
import controller.User;
import model.Data;
import model.MediaItem;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private Data data = new Data();
    private User user = new User();
    private Manager manager = new Manager();
    private ArrayList<MediaItem> mediaArray = data.arrayCreator();

    public void menu() {
        int choose;
        System.out.println("Choose what do you wanna do");
        System.out.println("1. User options");
        System.out.println("2. Manager options");
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

    public void userOptions() {
        int choose;
        System.out.println("Options");
        System.out.println("1. To show all media");
        System.out.println("2. ");
        System.out.println("0. To go back to menu");
        Scanner scanner = new Scanner(System.in);
        choose = scanner.nextInt();
        switch (choose) {
            case 1:
                displayAll(mediaArray);
                menu();
                break;
            case 2:
                menu();
                break;
            case 0:
                menu();
                break;
        }

    }

    public void managerOptions() {
        System.out.println("Enter manager password");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        if (managerPassword(password)){
            System.out.println("Correct password!");
            System.out.println("Manager options");
            int choose;
            System.out.println("1. Add new media ");
            System.out.println("0. To go back to menu");
    //        Scanner scanner = new Scanner(System.in);
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

    public void displayAll(ArrayList<MediaItem> mediaItems){
        for (MediaItem mediaItem : mediaItems) {
                System.out.println( mediaItem.toString());
        }
    }

    public boolean managerPassword(String password){
       if (password.equals("pass")){
           return true;
       }
       return false;
    }
}
