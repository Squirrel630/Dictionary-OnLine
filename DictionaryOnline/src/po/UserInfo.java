package po;

public class UserInfo implements java.io.Serializable{
	private String username;
	private String password;
	private int clientflag;
	private Boolean IsLogin;
	//public WordCardInfo wordCardInfo;
	
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return password;
	}

	public Boolean getIsLogin(){
		return IsLogin;
	}
	
	public int getClientFlag(){
		return clientflag;
	}
	
	public UserInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.IsLogin = false;
		this.clientflag=0;
	}
	
	public void setLogin(){
		this.IsLogin=true;
	}
	
	public void setClientFlag(int choose){
		this.clientflag=choose;
	} 

}