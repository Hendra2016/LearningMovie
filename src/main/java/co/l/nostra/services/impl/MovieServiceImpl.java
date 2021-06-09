package co.l.nostra.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.l.nostra.model.domain.Movie;
import co.l.nostra.repository.MovieRepository;
import co.l.nostra.services.MovieService;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie getByDetail(long id) {
		return movieRepository.getById(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> getNewAddedMovies() {
		return movieRepository.getNewReleaseMovie();
	}

	@Override
	public List<Movie> searchByMovieParam(String param) {
		return movieRepository.searchMovieByParam(param + "%");
	}

	@Override
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Override
	public List<Movie> getMovieByUser(String user) {
		return movieRepository.findByListUsers_Username(user);
	}

}
