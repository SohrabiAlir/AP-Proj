
package org.musicplayer.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Song {
    private String name;
    private String performer;
    public Song(String name, String performer){
        this.name = name;
        this.performer = performer;
    }
    public static ArrayList<Song> getSongs()throws Exception{
        ArrayList<Song> songs = new ArrayList<>();
        Scanner sc = new Scanner(new File("src\\main\\resources\\songs.txt"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String next = sc.next();
            String name = next.split(":")[0];
            String performer = next.split(":")[1];
            Song song = new Song(name, performer);
            songs.add(song);
        }
        sc.close();
        return songs;
    }
    public static ArrayList<Song> getSongsByPerformer(String performer)throws Exception{
        ArrayList<Song> requested = new ArrayList<>();
        ArrayList<Song> songs = getSongs();
        for(Song song : songs){
            if(song.getPerformer().equals(performer)){
                requested.add(song);
            }
        }
        return requested;
    }
    public static ArrayList<Song> getSongsByName(String name)throws Exception{
        ArrayList<Song> requested = new ArrayList<>();
        ArrayList<Song> songs = getSongs();
        for(Song song : songs){
            if(song.getName().contains(name)){
                requested.add(song);
            }
        }
        return requested;
    }
    public static String getPerformerByName(String songName) throws  Exception{
        ArrayList<Song> requested = new ArrayList<>();
        ArrayList<Song> songs = getSongs();
        String performer = "null";
        for(Song song : songs){
            if(song.getName().equals(songName)){
                performer = song.getPerformer();
            }
        }
        return performer;
    }

    /**
     * returns whether the song exist in database or not
     * @param name
     * @return
     * @throws Exception
     */
    public static boolean doesSongExistsByName(String name) throws Exception{
        ArrayList<Song> songs = getSongs();
        for(Song song : songs){
            if(song.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getPerformer() {
        return performer;
    }
}
