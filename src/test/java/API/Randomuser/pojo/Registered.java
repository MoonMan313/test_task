package API.Randomuser.pojo;

import java.util.Objects;

public class Registered{
	private String date;
	private int age;

	public String getDate(){
		return date;
	}

	public int getAge(){
		return age;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Registered)) return false;
		Registered that = (Registered) o;
		return getAge() == that.getAge() && Objects.equals(getDate(), that.getDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDate(), getAge());
	}
}
