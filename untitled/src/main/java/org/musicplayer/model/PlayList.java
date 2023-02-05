package org.musicplayer.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayList {
    private ArrayList<Song> songs;
    private String name;

    private User user;
    public PlayList(String name, User user){
        this.name = name;
        this.songs = new ArrayList<Song>();
        this.user = user;
    }

    /**
     * returns all playlists of a user
     * @param user
     * @return
     * @throws Exception
     */
    public static ArrayList<PlayList> getPlayListsByUser(User user)throws Exception{
        ArrayList<PlayList> playLists = new ArrayList<>();
        Scanner sc = new Scanner(new File("src\\main\\resources\\playlists.txt"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String next = sc.next();
            String username = next.split(":")[0];
            String playlistName = next.split(":")[1];
            if(username.equals(user.getUsername())){
                playLists.add(new PlayList(playlistName, new User(username, "")));
            }
        }
        sc.close();
        return playLists;
    }

    /**
     * sets all the playlists file with the given playilsts array
     * @param playLists
     * @throws Exception
     */
    public static void setPlayLists(ArrayList<PlayList> playLists) throws Exception{
        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\playlists.txt");
            for(PlayList playList : playLists){
                myWriter.write(playList.getUser().getUsername() + ":" + playList.getName() + ",");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * gets a song and adds the song to the playlist
     * @param song
     * @throws Exception
     */
    public void addSong(Song song) throws Exception{
        ArrayList<String> rows = new ArrayList<>();
        Scanner sc = new Scanner(new File("src\\main\\resources\\playlistswithsongs.txt"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String next = sc.next();
            String username = next.split(":")[0];
            String playlistName = next.split(":")[1];
            rows.add(next);

        }
        sc.close();

        rows.add(this.user.getUsername()+":"+this.name + ":"+ song.getName());

        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\playlistswithsongs.txt");
            for(String row : rows){
                myWriter.write(row + ",");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /**
     * removes a song from "this" playlist
     * @param song
     * @throws Exception
     */
    public void removeSong(Song song) throws  Exception{
        ArrayList<String> rows = new ArrayList<>();
        Scanner sc = new Scanner(new File("src\\main\\resources\\playlistswithsongs.txt"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String next = sc.next();
            String username = next.split(":")[0];
            String playlistName = next.split(":")[1];
            String songName = next.split(":")[2];
            if(!username.equals(user.getUsername()) || !song.getName().equals(songName)){
                rows.add(next);
            }
        }
        sc.close();
        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\playlistswithsongs.txt");
            for(String row : rows){
                myWriter.write(row + ",");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * removes "this" playlist from playlists
     * @throws Exception
     */
    public void selfRemove() throws  Exception{
        ArrayList<String> rows = new ArrayList<>();
        Scanner sc = new Scanner(new File("src\\main\\resources\\playlists.txt"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String next = sc.next();
            String username = next.split(":")[0];
            String playlistName = next.split(":")[1];
            //String songName = next.split(":")[2];
            if(!username.equals(this.user.getUsername()) || !playlistName.equals(this.name)){
                rows.add(next);
            }
        }
        sc.close();
        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\playlists.txt");
            for(String row : rows){
                myWriter.write(row + ",");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * adds "this" playlist to the playlists file
     * @throws Exception
     */
    public void selfAdd() throws  Exception{
        ArrayList<String> rows = new ArrayList<>();
        Scanner sc = new Scanner(new File("src\\main\\resources\\playlists.txt"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String next = sc.next();
            String username = next.split(":")[0];
            String playlistName = next.split(":")[1];
            //String songName = next.split(":")[2];
            rows.add(next);

        }
        rows.add(this.user.getUsername() + ":" + this.name);
        sc.close();
        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\playlists.txt");
            for(String row : rows){
                myWriter.write(row + ",");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public ArrayList<Song> getSongs() throws Exception {
        songs = new ArrayList<>();
        Scanner sc = new Scanner(new File("src\\main\\resources\\playlistswithsongs.txt"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String next = sc.next();
            String username = next.split(":")[0];
            String playlistName = next.split(":")[1];
            String songName = next.split(":")[2];
            if(username.equals(user.getUsername()) && playlistName.equals(this.name)){
                songs.add(new Song(songName, Song.getPerformerByName(songName)));
            }
        }
        sc.close();
        return songs;
    }


    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }
}
