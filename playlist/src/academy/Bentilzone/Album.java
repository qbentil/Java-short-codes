package academy.Bentilzone;

import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private LinkedList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new LinkedList<Song>();
    }

    public  boolean addSong(String title, Double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return  false;
    }

    public Song findSong(String title){
        for(Song checkedSong: this.songs){
            if(checkedSong.getTitle().toLowerCase().equals(title.toLowerCase())){
                return checkedSong;
            }
        }
        return null;
    }

    public  boolean addPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber-1;
        if((index > 0) && (index <= this.songs.size())){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This Album do not have a track "+trackNumber);
        return false;
    }
    public boolean addPlaylist(String title, LinkedList<Song> playlist){
        Song checkedSOng = findSong(title);
        if(checkedSOng != null){
            playlist.add(checkedSOng);
            return true;
        }
        System.out.println("The song "+title+" is not in the album.");
        return false;
    }
}
