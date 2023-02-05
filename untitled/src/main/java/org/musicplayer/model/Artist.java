package org.musicplayer.model;

import java.util.ArrayList;

public class Artist{
    private String name;
    private String profilePhotoAddress;
    ArrayList<Album> albums;
    private ArrayList<User> followers;
    public Artist(String name, String profilePhotoAddress, ArrayList<Album> albums){
        this.name = name;
        this.profilePhotoAddress = profilePhotoAddress;
        this.albums = (ArrayList<Album>) albums.clone();
        this.followers = new ArrayList<User>();
    }

    public String getName() {
        return name;
    }

    public String getProfilePhotoAddress() {
        return profilePhotoAddress;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }
    public void addAlbum(Album album){
        this.albums.add(album);
    }
    public void addFollower(User user){
        this.followers.add(user);
    }

}
