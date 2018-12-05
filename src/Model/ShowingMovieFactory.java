package Model;

public class ShowingMovieFactory implements MovieAbstractFactory {
    private double dailySales;

    public ShowingMovieFactory(double dailySales) {
        this.dailySales = dailySales;
    }

    @Override
    public Movie createMovie() {
        return new ShowingMovie(dailySales);
    }
}
