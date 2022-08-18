package API.Randomuser.pojo;

import java.util.Objects;

public class Login{
	private String sha1;
	private String password;
	private String salt;
	private String sha256;
	private String uuid;
	private String username;
	private String md5;

	public String getSha1(){
		return sha1;
	}

	public String getPassword(){
		return password;
	}

	public String getSalt(){
		return salt;
	}

	public String getSha256(){
		return sha256;
	}

	public String getUuid(){
		return uuid;
	}

	public String getUsername(){
		return username;
	}

	public String getMd5(){
		return md5;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Login)) return false;
		Login login = (Login) o;
		return Objects.equals(getSha1(), login.getSha1()) && Objects.equals(getPassword(), login.getPassword()) && Objects.equals(getSalt(), login.getSalt()) && Objects.equals(getSha256(), login.getSha256()) && Objects.equals(getUuid(), login.getUuid()) && Objects.equals(getUsername(), login.getUsername()) && Objects.equals(getMd5(), login.getMd5());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSha1(), getPassword(), getSalt(), getSha256(), getUuid(), getUsername(), getMd5());
	}
}
