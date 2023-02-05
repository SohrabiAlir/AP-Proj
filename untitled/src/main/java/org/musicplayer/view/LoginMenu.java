package org.musicplayer.view;

import org.musicplayer.model.User;

import java.util.Scanner;

public class LoginMenu {

    public static void run(Scanner input) throws Exception {
        System.out.println("***** LOGIN MENU *****");
        while(true){
            System.out.println("Enter the username: ");
            String username = input.nextLine();

            System.out.println("Enter the password: ");
            String password = input.nextLine();

            if(!User.canLogin(username, password)){
                System.out.println("username doesn't match with password.");
                continue;
            }
            HomeView.run(input, username);
            break;
        }

    }
}
