package org.musicplayer.view;

import java.util.Scanner;

public class FirstView {
    public static void run(Scanner input) throws Exception{

        while(true){
            System.out.println("***** ***** *****");
            System.out.println("1. log in");
            System.out.println("2. sign up");
            System.out.println("3. exit");

            String choice = input.nextLine();

            if(choice.equals("1")) {
                LoginMenu.run(input);
            }
            else if(choice.equals("2")) {
                SignupMenu.run(input);
            }
            else if(choice.equals("3")){
                break;
            }
            else {
                System.out.println("please enter a valid command.");
            }
        }

    }
}
