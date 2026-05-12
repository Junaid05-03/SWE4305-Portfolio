import java.util.ArrayList;

public class PlaylistManager {
    private ArrayList<Song> songs;

    public PlaylistManager() {
        songs = new ArrayList<>();
        loadDefaultSongs();
    }

    private void loadDefaultSongs() {
        songs.add(new Song("Tere Bina", "Atif Aslam", 245678923));
        songs.add(new Song("Dam Mast Qalandar", "Nusrat Fateh Ali Khan", 189456321));
        songs.add(new Song("Tum Hi Ho", "Arijit Singh", 987654321));
        songs.add(new Song("Afreen Afreen", "Rahat Fateh Ali Khan", 156789432));
        songs.add(new Song("Allah Hoo", "Nusrat Fateh Ali Khan", 203456789));
        songs.add(new Song("Dil Diya Gallan", "Atif Aslam", 134567890));
        songs.add(new Song("Lag Ja Gale", "Lata Mangeshkar", 98765432));
        songs.add(new Song("Channa Mereya", "Arijit Singh", 876543210));
        songs.add(new Song("Yeh Jo Halka Halka Suroor", "Nusrat Fateh Ali Khan", 167890234));
        songs.add(new Song("Woh Lamhe", "Atif Aslam", 145678901));
        songs.add(new Song("Teri Meri Kahani", "Rahat Fateh Ali Khan", 123456789));
        songs.add(new Song("Tujh Mein Rab Dikhta Hai", "Shreya Ghoshal", 234567891));
    }

    public void addSong(String title, String artist, int playCount) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Error: Song title cannot be empty.");
            return;
        }
        if (artist == null || artist.trim().isEmpty()) {
            System.out.println("Error: Artist name cannot be empty.");
            return;
        }
        if (playCount < 0) {
            System.out.println("Error: Play count cannot be negative.");
            return;
        }
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title) && song.getArtist().equalsIgnoreCase(artist)) {
                System.out.println("Error: This song already exists in the playlist.");
                return;
            }
        }
        songs.add(new Song(title, artist, playCount));
        System.out.println("Successfully added: " + title + " by " + artist);
    }

    public void removeSong(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Error: Song title cannot be empty.");
            return;
        }
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songs.remove(song);
                System.out.println("Successfully removed: " + title);
                return;
            }
        }
        System.out.println("Song not found: " + title);
    }

    public void printAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("The playlist is empty.");
            return;
        }
        System.out.println("\n=== Full Playlist (" + songs.size() + " songs) ===");
        System.out.printf("%-40s %-25s %s%n", "Title", "Artist", "Play Count");
        System.out.println("-".repeat(80));
        for (Song song : songs) {
            song.print();
        }
    }

    public void filterByPlayCount(int minPlays) {
        if (minPlays < 0) {
            System.out.println("Error: Minimum play count cannot be negative.");
            return;
        }
        System.out.println("\n=== Songs with over " + String.format("%,d", minPlays) + " plays ===");
        System.out.printf("%-40s %-25s %s%n", "Title", "Artist", "Play Count");
        System.out.println("-".repeat(80));
        boolean found = false;
        for (Song song : songs) {
            if (song.getPlayCount() > minPlays) {
                song.print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No songs found with over " + String.format("%,d", minPlays) + " plays.");
        }
    }

    public void searchByArtist(String artist) {
        if (artist == null || artist.trim().isEmpty()) {
            System.out.println("Error: Artist name cannot be empty.");
            return;
        }
        System.out.println("\n=== Songs by " + artist + " ===");
        boolean found = false;
        for (Song song : songs) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                song.print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No songs found by " + artist);
        }
    }

    public ArrayList<Song> getSongs() { return songs; }
}
