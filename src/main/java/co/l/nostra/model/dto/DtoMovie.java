package co.l.nostra.model.dto;

import java.util.List;

public class DtoMovie {
	private long id;
	private String name;
	private String shortName;
	private String description;
	private String imgUrl;
	private String videoUrl;
	private String uploadDate;
	private long counter;
	private List<DtoCategories> listCategories;

	public DtoMovie(long id, String name, String shortName, String description, String imgUrl, long counter,
			String uploadDate, String videoUrl) {
		super();
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		this.description = description;
		this.imgUrl = imgUrl;
		this.counter = counter;
		this.uploadDate = uploadDate;
		this.videoUrl = videoUrl;
	}

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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public long getCounter() {
		return counter;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public List<DtoCategories> getListCategories() {
		return listCategories;
	}

	public void setListCategories(List<DtoCategories> listCategories) {
		this.listCategories = listCategories;
	}

}
