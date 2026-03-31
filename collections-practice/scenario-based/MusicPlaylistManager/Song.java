package MusicPlaylistManager;

//song entity
public class Song {
	String title;

	// constructor
	public Song(String title) {
		this.title = title;
	}

	// needed for Set to prevent duplicates
	@Override
	public boolean equals(Object obj) {
		Song s = (Song) obj;
		return this.title.equals(s.title);
	}

	@Override
	public int hashCode() {
		return title.hashCode();
	}
}
