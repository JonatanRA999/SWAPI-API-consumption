package Models;

public class Movie
{
    private String title;
    private String numberEpisode;
    private String nameDirector;
    private int releaseDate;

    public Movie(String title , String nameDirector, int releaseDate){
        this.title = title;
        this.nameDirector = nameDirector;
        this.releaseDate = releaseDate;
    }

    public Movie(MovieSwapi movieSwapi)
    {
        this.title = movieSwapi.title();
        this.nameDirector = movieSwapi.director();
        this.releaseDate = Integer.valueOf(movieSwapi.release_date().substring(0,4));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumberEpisode() {
        return numberEpisode;
    }

    public void setNumberEpisode(String numberEpisode) {
        this.numberEpisode = numberEpisode;
    }

    public String getNameDirector() {
        return nameDirector;
    }

    public void setNameDirector(String nameDirector) {
        this.nameDirector = nameDirector;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "{Title : "+this.title+" | Director : "+this.nameDirector+" | Realease Date : "+this.releaseDate+"}\n";
    }
}
