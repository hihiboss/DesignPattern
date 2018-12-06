package Model;

public class MovieFactory {
    private volatile static MovieFactory instance = null;

    private MovieFactory(){}

    public static MovieFactory getInstance(){
        if (instance == null) {
            synchronized (Movie.class) {
                if (instance == null) {
                    instance = new MovieFactory();
                }
            }
        }
        return instance;
    }

    public Movie getMovie(MovieAbstractFactory movie) {
        return movie.createMovie();
    }
}
