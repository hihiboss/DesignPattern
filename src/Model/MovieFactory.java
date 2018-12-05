package Model;

public class MovieFactory {
    public static Movie getMovie(MovieAbstractFactory movie) {
        return movie.createMovie();
    }
}
