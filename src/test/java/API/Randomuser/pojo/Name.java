package API.Randomuser.pojo;

import java.util.Objects;

public class Name{
	private String last;
	private String title;
	private String first;

	public String getLast(){
		return last;
	}

	public String getTitle(){
		return title;
	}

	public String getFirst(){
		return first;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Name)) return false;
		Name name = (Name) o;
		return Objects.equals(getLast(), name.getLast()) && Objects.equals(getTitle(), name.getTitle()) && Objects.equals(getFirst(), name.getFirst());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLast(), getTitle(), getFirst());
	}
}
