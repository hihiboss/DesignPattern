package Model;

public class PreShowingMovieFactory implements MovieAbstractFactory {
    private String genre;
    private int age;
    private double expect;
    private String country;

    public PreShowingMovieFactory(String genre, int age, double expect, String country) {
        this.genre = genre;
        this.age = age;
        this.expect = expect;
        this.country = country;
    }

    @Override
    public Movie createMovie() {
        return new PreShowingMovie(genre, age, expect, country);
    }
}
