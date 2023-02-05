package org.musicplayer.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    //private String profilePhotoAddress;
    private ArrayList<PlayList> playLists;
    private ArrayList<Artist> following;
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public static ArrayList<User> getUsers() throws Exception{
        ArrayList<User> users = new ArrayList<>();
        Scanner sc = new Scanner(new File("src\\main\\resources\\users.txt"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String next = sc.next();
            String username = next.split(":")[0];
            String password = next.split(":")[1];
            User user = new User(username, password);
            users.add(user);
        }
        sc.close();
        return users;
    }
    public static void setUsers(ArrayList<User> users)throws Exception{
        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\users.txt");
            for(User user : users){
                myWriter.write(user.getUsername() + ":" + user.getPassword() + ",");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void addUser(User user) throws Exception{
        ArrayList<User> users = getUsers();
        users.add(user);
        setUsers(users);
    }
    public static boolean doesUsernameExists(String username) throws Exception{
        ArrayList<User> users = getUsers();
        for(User user : users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public static boolean canLogin(String username, String password)throws Exception{
        ArrayList<User> users = getUsers();
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }


    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }

    public ArrayList<Artist> getFollowing() {
        return following;
    }
    public void addFollowing(Artist artist){
        this.following.add(artist);
    }
    public void addPlaylist(PlayList playList){
        this.playLists.add(playList);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
