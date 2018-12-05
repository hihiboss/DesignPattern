package Model;

public class PreShowingMovieFactory implements MovieAbstractFactory {
    private String genre;
    private String age;
    private double expect;
    private String country;
    private String releaseDate;

    public PreShowingMovieFactory(String genre, String age, double expect, String country, String releaseDate) {
        this.genre = genre;
        this.age = age;
        this.expect = expect;
        this.country = country;
        this.releaseDate = releaseDate;
    }

    @Override
    public Movie createMovie() {
        return new PreShowingMovie(genre, age, expect, country, releaseDate);
    }
}
