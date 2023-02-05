package org.musicplayer;

import org.musicplayer.model.Song;
import org.musicplayer.view.FirstView;
import org.musicplayer.view.LoginMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        FirstView.run(input);
    }
}