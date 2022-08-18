package API.Randomuser.pojo;

import java.util.Objects;

public class Location{
	private String country;
	private String city;
	private Street street;
	private Timezone timezone;
	private int postcode;
	private Coordinates coordinates;
	private String state;

	public String getCountry(){
		return country;
	}

	public String getCity(){
		return city;
	}

	public Street getStreet(){
		return street;
	}

	public Timezone getTimezone(){
		return timezone;
	}

	public int getPostcode(){
		return postcode;
	}

	public Coordinates getCoordinates(){
		return coordinates;
	}

	public String getState(){
		return state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Location)) return false;
		Location location = (Location) o;
		return getPostcode() == location.getPostcode() && Objects.equals(getCountry(), location.getCountry()) && Objects.equals(getCity(), location.getCity()) && Objects.equals(getStreet(), location.getStreet()) && Objects.equals(getTimezone(), location.getTimezone()) && Objects.equals(getCoordinates(), location.getCoordinates()) && Objects.equals(getState(), location.getState());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCountry(), getCity(), getStreet(), getTimezone(), getPostcode(), getCoordinates(), getState());
	}
}
