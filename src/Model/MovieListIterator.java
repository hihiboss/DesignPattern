package Model;

public class MovieListIterator implements Iterator {
    private MovieList movieList;
    private int index;

    public MovieListIterator(MovieList movieList) {
        this.movieList = movieList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < movieList.getLength()) {
            return true;
        }

        return false;    }

    @Override
    public Object next() {
        Movie movie = movieList.getMovieAt(index);
        index++;
        return movie;
    }
}
