package academy.Bentilzone;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static LinkedList<Album> albums = new LinkedList<Album>();

    public static void main(String[] args) {
	    Album album = new Album("Alpha", "Sarkodie");
	    album.addSong("Greatness", 3.25);
	    album.addSong("Angels and Demons", 4.0);
	    album.addSong("Bleeding", 2.56);
	    album.addSong("Legend", 3.21);
	    album.addSong("Vintage Flow", 3.0);
	    album.addSong("Odo", 2.99);
        albums.add(album);
	    album = new Album("Wonder Boy", "Shatta Wale");
	    album.addSong("The postman intro", 2.34);
	    album.addSong("Melissa", 3.22);
	    album.addSong("Jata Bi", 2.55);
	    album.addSong("Bad Man", 3.11);
	    album.addSong("Ay3 halfcast", 3.00);
	    album.addSong("Blessing upon me", 3.44);
	    album.addSong("Only one man", 3.36);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(1).addPlaylist("Melissa", playlist);
        albums.get(0).addPlaylist("Greatness", playlist);
        albums.get(1).addPlaylist("Jata Bi", playlist);
        albums.get(1).addPlaylist("Ay3 halfcast", playlist);
//        albums.get(0).addPlaylist("Ofeetso", playlist);
        albums.get(0).addPlaylist(2, playlist);
        albums.get(0).addPlaylist(5, playlist);
        albums.get(1).addPlaylist(4, playlist);
        albums.get(0).addPlaylist(6, playlist);

        play(playlist);
    }
    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> listIterator = playlist.listIterator();
        Scanner scanner = new Scanner((System.in));
        boolean quit = false;
        boolean forward = true;

        if(playlist.size() == 0){
            System.out.println("Playlist is empty!");
        }else {
            System.out.println("Now playing "+listIterator.next().toString());
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                        forward = true;
                    }else {
                        System.out.println("We've reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(!forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                        forward = false;
                    }else{
                        System.out.println("Playlist has started.....");
                        forward = true;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    printPlaylist(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid menu input");
            }
        }
    }
    public static void printPlaylist(LinkedList<Song> playlist){
        if(playlist.size() == 0){
            System.out.println("No song in this playlist.");
        }else{
            System.out.println("Sons in Playlist:");
            for(int i = 0; i < playlist.size(); i++){
                System.out.println((i+1)+". "+playlist.get(i).getTitle());
            }
        }
        ListIterator<Song> listIterator = playlist.listIterator();
        System.out.println("===============================");
        while (listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
        System.out.println("===============================");
    }
    public static void printMenu(){
        System.out.println("Application Menu \nPress:" +
                            "\n0-  To quit program" +
                            "\n1- to play next song" +
                            "\n2. to play previous song" +
                            "\n3- to replay current song" +
                            "\n4- to Display songs in Playlist" +
                            "\n5- to Print program menu");
    }
}
