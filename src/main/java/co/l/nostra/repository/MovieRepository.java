package co.l.nostra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.l.nostra.model.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(value = "select m from Movie m order by m.uploadDate desc")
	public List<Movie> getNewReleaseMovie();

	@Query(value = "select m from Movie m where upper(m.name) like :param")
	public List<Movie> searchMovieByParam(@Param("param") String param);

	List<Movie> findByListUsers_Username(String userName);
}
