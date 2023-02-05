package org.musicplayer.view;

import java.util.Scanner;

public class HomeView {


    public static void run(Scanner input, String username)throws Exception{
        String Command;
        while(true){
            System.out.println("***** HOME VIEW *****");
            System.out.println("1. song library");
            System.out.println("2. song search");
            System.out.println("3. exit");
            System.out.println("4. exit");
            System.out.println("[1/2/3/4]");

            Command = input.nextLine();

            if(Command.equals("1")){
                SongLibraryView.run(input, username);
            }
            else if(Command.equals("2")){
                SongSearchView.run(input);
            }
            else if(Command.equals("3")){
                break;
            }
            else if(Command.equals("4")){
                break;
            }
            else{
                System.out.println("enter a valid command.");
            }

        }
    }
}
