package API.Randomuser.pojo;

import java.util.Objects;

public class Picture{
	private String thumbnail;
	private String large;
	private String medium;

	public String getThumbnail(){
		return thumbnail;
	}

	public String getLarge(){
		return large;
	}

	public String getMedium(){
		return medium;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Picture)) return false;
		Picture picture = (Picture) o;
		return Objects.equals(getThumbnail(), picture.getThumbnail()) && Objects.equals(getLarge(), picture.getLarge()) && Objects.equals(getMedium(), picture.getMedium());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getThumbnail(), getLarge(), getMedium());
	}
}
