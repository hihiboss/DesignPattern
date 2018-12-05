package Model;

import java.util.ArrayList;

public class MovieList implements Aggregate {
    private ArrayList<Movie> movieList = new ArrayList<Movie>();

    public Movie getMovieAt(int index) {
        return movieList.get(index);
    }

    public void addMovie(Movie movie) {
        this.movieList.add(movie);
    }

    public void addMovieAt(int index, Movie movie) {
        this.movieList.add(index, movie);
    }

    public void removeMovieAt(int index) {
        this.movieList.remove(index);
    }

    public int getLength() {
        return movieList.size();
    }

    public void clear() {
        this.movieList.clear();
    }

    @Override
    public Iterator iterator() {
        return new MovieListIterator(this);
    }
}
