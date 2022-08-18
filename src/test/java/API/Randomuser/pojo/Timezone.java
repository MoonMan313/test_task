package API.Randomuser.pojo;

import java.util.Objects;

public class Timezone{
	private String offset;
	private String description;

	public String getOffset(){
		return offset;
	}

	public String getDescription(){
		return description;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Timezone timezone = (Timezone) o;
		return Objects.equals(offset, timezone.offset) && Objects.equals(description, timezone.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(offset, description);
	}
}
