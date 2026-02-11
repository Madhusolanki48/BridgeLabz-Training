package MusicPlaylistManager;

public class MusicPlaylistManagerApp {

    public static void main(String[] args) {

        System.out.println("--------------------------------");
        System.out.println("     MUSIC PLAYLIST MANAGER     ");
        System.out.println("--------------------------------");

        PlaylistManager manager = new PlaylistManager();

        try {
            // add songs
            manager.addSong(new Song("Believer"));
            manager.addSong(new Song("Shape of You"));
            manager.addSong(new Song("Believer")); // duplicate

        } catch (SongAlreadyExistsException e) {
            System.out.println("\nSong Not Added");
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("\nPlaying Songs...");
        manager.playSong();
        manager.playSong();

        System.out.println("\nRecently Played Songs:");
        while (!manager.recentlyPlayed.isEmpty()) {
            System.out.println(manager.recentlyPlayed.pop().title);
        }

        System.out.println("--------------------------------");
    }
}
