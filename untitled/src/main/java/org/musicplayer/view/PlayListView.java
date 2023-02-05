package org.musicplayer.view;

import org.musicplayer.model.PlayList;
import org.musicplayer.model.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayListView {
    public static void run(Scanner input, String username, PlayList playList)throws Exception{
        while(true){
            System.out.println("***** PLAYLIST VIEW *****");
            System.out.println("songs of this ("+playList.getName()+") playlist:");
            ArrayList<Song> songs = playList.getSongs();
            for(Song song : songs){
                System.out.println(" - " + song.getName() + " : " + song.getPerformer());
            }
            System.out.println("1. add a song");
            System.out.println("2. remove a song");
            System.out.println("3. back");
            String command = input.nextLine();
            if(command.equals("1")){
                System.out.println("enter the name of the song.");
                command = input.nextLine();
                if(Song.doesSongExistsByName(command)){
                    playList.addSong(new Song(command, ""));
                    System.out.println("song added successfully");
                }
                else{
                    System.out.println("failed to find that song.");
                }
            }
            else if(command.equals("2")){
                System.out.println("enter the name of the song.");
                command = input.nextLine();
                if(Song.doesSongExistsByName(command)){
                    playList.removeSong(new Song(command, ""));
                }
            }
            else if(command.equals("3")){
                break;
            }
            else{
                System.out.println("enter a valid command.");
            }
        }

    }
}
