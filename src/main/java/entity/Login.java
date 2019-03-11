package entity;

public class Login {

	public int id;
	public String username;		//登陆者的账号
	public String password;		//登陆者的密码
	
	public Login(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
}
