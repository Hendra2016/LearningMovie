package co.l.nostra.services;

import java.util.List;

import co.l.nostra.model.domain.Movie;

public interface MovieService {
	public void saveMovie(Movie movie);

	public Movie getByDetail(long id);

	public List<Movie> getAllMovies();

	public List<Movie> getNewAddedMovies();

	public List<Movie> searchByMovieParam(String param);

	public List<Movie> getMovieByUser(String user);
}
