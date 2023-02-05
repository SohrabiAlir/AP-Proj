package org.musicplayer.view;

import java.util.Scanner;

import org.musicplayer.model.User;

public class SignupMenu {
    public static void run(Scanner input) throws Exception {
        System.out.println("***** SIGNUP MENU *****");
        while(true){
            System.out.println("Enter the username: ");
            String username = input.nextLine();
            if(User.doesUsernameExists(username)){
                System.out.println("this username is already taken, choose anotherone.");
                continue;
            }
            System.out.println("Enter the password: ");
            String password = input.nextLine();
            System.out.println("username was: " + username + " and password was: " + password);
            User.addUser(new User(username, password));
            break;

        }

    }
}
