package co.l.nostra.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DB_MOVIE")
public class Movie {
	private long id;
	private String name;
	private String shortName;
	private String description;
	private String imgUrl;
	private String videoUrl;
	private long counter;
	private Date uploadDate;
	private List<UserApp> listUsers = new ArrayList<UserApp>();
	private List<Categories> categories = new ArrayList<Categories>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SHORT_NAME", nullable = false)
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IMG_URL", nullable = false)
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Column(name = "COUNTER", nullable = false)
	public long getCounter() {
		return counter;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}

	@Column(name = "UPLOAD_DATE", nullable = false)
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Column(name = "VIDEO_URL", nullable = false)
	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	@ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	@ManyToMany(mappedBy = "listMovie", fetch = FetchType.LAZY)
	public List<UserApp> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<UserApp> listUsers) {
		this.listUsers = listUsers;
	}

}
