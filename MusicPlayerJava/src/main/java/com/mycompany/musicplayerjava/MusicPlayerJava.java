/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.musicplayerjava;

/**
 *
 * @author EYC
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Song class to represent a song
class Song {
    private String title;
    private String artist;
    
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

// MusicPlayer class to manage the music player functionalities
class MusicPlayer {
    private List<Song> playlist;
    private int currentTrackIndex;
    
    public MusicPlayer() {
        playlist = new ArrayList<>();
        currentTrackIndex = -1;
    }
    
    public void addSong(String title, String artist) {
        playlist.add(new Song(title, artist));
    }
    
    public void play() {
        if (!playlist.isEmpty()) {
            currentTrackIndex = 0;
            System.out.println("Playing: " + playlist.get(currentTrackIndex));
        } else {
            System.out.println("Playlist is empty!");
        }
    }
    
    public void pause() {
        if (currentTrackIndex != -1) {
            System.out.println("Paused: " + playlist.get(currentTrackIndex));
        } else {
            System.out.println("No song is currently playing!");
        }
    }
    
    public void skip() {
        if (currentTrackIndex != -1 && currentTrackIndex < playlist.size() - 1) {
            currentTrackIndex++;
            System.out.println("Playing next track: " + playlist.get(currentTrackIndex));
        } else {
            System.out.println("No next track available!");
        }
    }
    
    public void shuffle() {
        Collections.shuffle(playlist);
        System.out.println("Playlist shuffled!");
    }
    
    public void displayPlaylist() {
        if (!playlist.isEmpty()) {
            System.out.println("Playlist:");
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        } else {
            System.out.println("Playlist is empty!");
        }
    }
}

// Main class to run the music player
public class MusicPlayerJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer musicPlayer = new MusicPlayer();
        
        // Adding some sample songs to the playlist
        musicPlayer.addSong("Shape of You", "Ed Sheeran");
        musicPlayer.addSong("Believer", "Imagine Dragons");
        musicPlayer.addSong("Rolling in the Deep", "Adele");
        
        // Main menu
        while (true) {
            System.out.println("\nMusic Player");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Skip");
            System.out.println("4. Shuffle Playlist");
            System.out.println("5. Display Playlist");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    musicPlayer.play();
                    break;
                case 2:
                    musicPlayer.pause();
                    break;
                case 3:
                    musicPlayer.skip();
                    break;
                case 4:
                    musicPlayer.shuffle();
                    break;
                case 5:
                    musicPlayer.displayPlaylist();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 6.");
            }
        }
    }
}

