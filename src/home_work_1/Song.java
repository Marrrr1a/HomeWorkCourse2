package home_work_1;

public class Song {
    private String title;
    private String artist;
    private String genre;
    private double duration;

    public Song (String title, String artist, String genre, double duration){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " by " + artist + "(" + duration + "; " + genre + ")";
    }
}
