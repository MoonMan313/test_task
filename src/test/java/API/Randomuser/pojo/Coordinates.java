package API.Randomuser.pojo;

import java.util.Objects;

public class Coordinates{
	private String latitude;
	private String longitude;

	public String getLatitude(){
		return latitude;
	}

	public String getLongitude(){
		return longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Coordinates)) return false;
		Coordinates that = (Coordinates) o;
		return Objects.equals(getLatitude(), that.getLatitude()) && Objects.equals(getLongitude(), that.getLongitude());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLatitude(), getLongitude());
	}
}
