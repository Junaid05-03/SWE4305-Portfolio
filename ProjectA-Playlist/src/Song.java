public class Song {
    private String title;
    private String artist;
    private int playCount;

    public Song(String title, String artist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getPlayCount() { return playCount; }
    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setPlayCount(int playCount) { this.playCount = playCount; }

    public void print() {
        System.out.printf("%-40s %-25s %,d plays%n", title, artist, playCount);
    }

    public String toString() {
        return title + " by " + artist + " (" + playCount + " plays)";
    }
}
