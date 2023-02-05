package org.musicplayer.view;

import org.musicplayer.model.PlayList;
import org.musicplayer.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class SongLibraryView {
    public static void run(Scanner input, String username)throws Exception{
        while(true){
            System.out.println("*** SONG LIBRARY VIEW ***");
            System.out.println("your playlists: ");
            ArrayList<PlayList> playLists = PlayList.getPlayListsByUser(new User(username, ""));
            for(PlayList playList : playLists){
                System.out.println(" - " + playList.getName());
            }
            System.out.println("");
            System.out.println("1. view/edit an existing playlist");
            System.out.println("2. add a new playlist");
            System.out.println("3. remove an existing playlist");
            System.out.println("4. back");
            String command = input.nextLine();
            if(command.equals("1")){
                System.out.println("enter the name of the playlist:");
                command = input.nextLine();
                boolean flag = true;
                for(PlayList playList : playLists){
                    if(playList.getName().equals(command)){
                        PlayListView.run(input, username, playList);
                    }
                }
                if(flag){
                    System.out.println("playlist not found.");
                }
            }
            else if(command.equals("2")){
                System.out.println("enter the name of the new playlist:");
                command = input.nextLine();
                PlayList pl = new PlayList(command, new User(username, ""));
                pl.selfAdd();
                //PlayList.setPlayLists(playLists);
            }
            else if(command.equals("3")){
                System.out.println("enter the name of the playlist:");
                command = input.nextLine();
                for(PlayList playList : playLists){
                    if(playList.getName().equals(command)){
                        playList.selfRemove();
                    }
                }
            }
            else if(command.equals("4")){
                break;
            }
            else{
                System.out.println("enter a valid command");
            }

        }
    }
}
