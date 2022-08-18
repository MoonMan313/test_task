package API.Randomuser.pojo;

import java.util.Objects;

public class Id{
	private String name;
	private String value;

	public String getName(){
		return name;
	}

	public String getValue(){
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Id)) return false;
		Id id = (Id) o;
		return Objects.equals(getName(), id.getName()) && Objects.equals(getValue(), id.getValue());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getValue());
	}
}
