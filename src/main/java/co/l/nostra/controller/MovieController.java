package co.l.nostra.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.l.nostra.handler.ConstantsGlobal;
import co.l.nostra.handler.DtoHandler;
import co.l.nostra.model.domain.Movie;
import co.l.nostra.model.dto.DtoMovie;
import co.l.nostra.services.MovieService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/movie")
public class MovieController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	@Autowired
	private MovieService movieService;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public @ResponseBody DtoHandler getAllMovie() {
		try {
			List<DtoMovie> movies = new ArrayList<DtoMovie>();
			for (Movie e : movieService.getAllMovies()) {
				movies.add(new DtoMovie(e.getId(), e.getName(), e.getShortName(), e.getDescription(), e.getImgUrl(),
						e.getCounter(), sdf.format(e.getUploadDate()), e.getVideoUrl()));
			}
			return new DtoHandler(ConstantsGlobal.OK, ConstantsGlobal.MESSAGE_SUCCESS, movies);
		} catch (Exception e) {
			return new DtoHandler(ConstantsGlobal.ERROR, ConstantsGlobal.MESSAGE_ERROR, e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public @ResponseBody DtoHandler saveMovie(@RequestBody DtoMovie dtoMovie) {
		try {
			Movie m = new Movie();
			m.setCounter(0);
			m.setDescription(dtoMovie.getDescription());
			m.setImgUrl(dtoMovie.getImgUrl());
			m.setName(dtoMovie.getName());
			m.setShortName(dtoMovie.getShortName());
			m.setVideoUrl(dtoMovie.getVideoUrl());
			movieService.saveMovie(m);
			return new DtoHandler(ConstantsGlobal.OK, ConstantsGlobal.MESSAGE_SUCCESS, "");
		} catch (Exception e) {
			return new DtoHandler(ConstantsGlobal.ERROR, ConstantsGlobal.MESSAGE_ERROR, e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/newAdded")
	public @ResponseBody DtoHandler getNewAdded() {
		try {
			List<Movie> movies = movieService.getNewAddedMovies();
			List<DtoMovie> list = new ArrayList<DtoMovie>();
			int counter = 0;
			for (Movie e : movies) {
				if (counter < ConstantsGlobal.MAX_RELEASE) {
					list.add(new DtoMovie(e.getId(), e.getName(), e.getShortName(), e.getDescription(), e.getImgUrl(),
							e.getCounter(), sdf.format(e.getUploadDate()), e.getVideoUrl()));
					counter++;
				}
			}

			return new DtoHandler(ConstantsGlobal.OK, ConstantsGlobal.MESSAGE_SUCCESS, list);
		} catch (Exception e) {
			return new DtoHandler(ConstantsGlobal.ERROR, ConstantsGlobal.MESSAGE_ERROR, e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public @ResponseBody DtoHandler searchByName(@RequestParam("name") String name) {
		try {
			List<Movie> movies = movieService.searchByMovieParam(name.toUpperCase() + "%");
			List<DtoMovie> list = new ArrayList<DtoMovie>();
			for (Movie e : movies) {
				list.add(new DtoMovie(e.getId(), e.getName(), e.getShortName(), e.getDescription(), e.getImgUrl(),
						e.getCounter(), sdf.format(e.getUploadDate()), e.getVideoUrl()));
			}
			return new DtoHandler(ConstantsGlobal.OK, ConstantsGlobal.MESSAGE_SUCCESS, list);
		} catch (Exception e) {
			return new DtoHandler(ConstantsGlobal.ERROR, ConstantsGlobal.MESSAGE_ERROR, e.getMessage());
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody DtoHandler getDetailMovie(@PathVariable(name = "id") long id) {
		try {
			Movie movies = movieService.getByDetail(id);

			return new DtoHandler(ConstantsGlobal.OK, ConstantsGlobal.MESSAGE_SUCCESS,
					new DtoMovie(movies.getId(), movies.getName(), movies.getShortName(), movies.getDescription(),
							movies.getImgUrl(), movies.getCounter(), sdf.format(movies.getUploadDate()),
							movies.getVideoUrl()));
		} catch (Exception e) {
			return new DtoHandler(ConstantsGlobal.ERROR, ConstantsGlobal.MESSAGE_ERROR, e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/myList")
	public @ResponseBody DtoHandler getMyList(@RequestParam("username") String user) {
		try {
			List<DtoMovie> movies = new ArrayList<DtoMovie>();
			for (Movie e : movieService.getMovieByUser(user)) {
				movies.add(new DtoMovie(e.getId(), e.getName(), e.getShortName(), e.getDescription(), e.getImgUrl(),
						e.getCounter(), sdf.format(e.getUploadDate()), e.getVideoUrl()));
			}
			return new DtoHandler(ConstantsGlobal.OK, ConstantsGlobal.MESSAGE_SUCCESS, movies);
		} catch (Exception e) {
			return new DtoHandler(ConstantsGlobal.ERROR, ConstantsGlobal.MESSAGE_ERROR, e.getMessage());
		}
	}

}
