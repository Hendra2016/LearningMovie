package co.l.nostra.model.dto;

import java.util.List;

public class DtoCategories {
	private long id;
	private String name;
	private List<DtoMovie> listMovie;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DtoMovie> getListMovie() {
		return listMovie;
	}

	public void setListMovie(List<DtoMovie> listMovie) {
		this.listMovie = listMovie;
	}

}
