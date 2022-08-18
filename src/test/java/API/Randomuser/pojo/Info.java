package API.Randomuser.pojo;

import java.util.Objects;

public class Info{
	private String seed;
	private int page;
	private int results;
	private String version;

	public String getSeed(){
		return seed;
	}

	public int getPage(){
		return page;
	}

	public int getResults(){
		return results;
	}

	public String getVersion(){
		return version;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setResults(int results) {
		this.results = results;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Info)) return false;
		Info info = (Info) o;
		return getPage() == info.getPage() && getResults() == info.getResults() && Objects.equals(getSeed(), info.getSeed()) && Objects.equals(getVersion(), info.getVersion());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSeed(), getPage(), getResults(), getVersion());
	}
}
