package org.musicplayer.view;

import org.musicplayer.model.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class SongSearchView {
    public static void run(Scanner input)throws Exception{
        String Command;
        while(true){
            System.out.println("*** SONG SEARCH VIEW ***");
            System.out.println("1. search by performer");
            System.out.println("2. search by song title");
            System.out.println("3. exit");
            System.out.println("[1/2/3]");

            Command = input.nextLine();

            if(Command.equals("1")){
                System.out.println("enter the full name of the performer.");
                String performerName = input.nextLine();
                ArrayList<Song> requested = Song.getSongsByPerformer(performerName);
                System.out.println(requested.size() +  " song(s) found:");
                for(Song song : requested){
                    System.out.println(song.getName() + " : " + song.getPerformer());
                }
            }
            else if(Command.equals("2")){
                System.out.println("enter the search text:");
                String songName = input.nextLine();
                ArrayList<Song> requested = Song.getSongsByName(songName);
                System.out.println(requested.size() +  " song(s) found:");
                for(Song song : requested){
                    System.out.println(song.getName() + " : " + song.getPerformer());
                }

            }
            else if(Command.equals("3")){
                break;
            }
            else{
                System.out.println("enter a valid command.");
            }

        }
    }
}
