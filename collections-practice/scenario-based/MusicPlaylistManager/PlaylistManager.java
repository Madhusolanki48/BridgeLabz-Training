package MusicPlaylistManager;
import java.util.*;

//service class for playlist operations
public class PlaylistManager {

    // maintains song order
    LinkedList<Song> playlist = new LinkedList<>();

    // stores recently played songs
    Stack<Song> recentlyPlayed = new Stack<>();

    // prevents duplicate songs
    Set<Song> songSet = new HashSet<>();

    //method to add song to playlist
    public void addSong(Song song) throws SongAlreadyExistsException {

        if (!songSet.add(song)) {
            throw new SongAlreadyExistsException("Song already exists");
        }

        playlist.add(song);
    }

    //method to play song
    public void playSong() {
        Song song = playlist.poll(); // remove from front

        if (song != null) {
            recentlyPlayed.push(song);
            System.out.println("Now Playing: " + song.title);
        }
    }
}
