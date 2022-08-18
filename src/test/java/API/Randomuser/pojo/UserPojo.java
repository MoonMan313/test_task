package API.Randomuser.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo {
	private List<ResultsItem> results;
	private Info info;

	public List<ResultsItem> getResults(){
		return results;
	}

	public Info getInfo(){
		return info;
	}

	public void setResults(List<ResultsItem> results) {
		this.results = results;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserPojo userPojo = (UserPojo) o;
		return Objects.equals(results, userPojo.results) && Objects.equals(info, userPojo.info);
	}

	@Override
	public int hashCode() {
		return Objects.hash(results, info);
	}
}