package API.Randomuser.pojo;

import java.util.Objects;

public class Street{
	private int number;
	private String name;

	public int getNumber(){
		return number;
	}

	public String getName(){
		return name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Street)) return false;
		Street street = (Street) o;
		return getNumber() == street.getNumber() && Objects.equals(getName(), street.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumber(), getName());
	}
}
