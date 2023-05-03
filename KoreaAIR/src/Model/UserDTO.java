package Model;

public class UserDTO {
	////////필드
	private String userId;
	private String userPw;
	private String userName;
	private String userCellnum;
	
	///////생성자
	public UserDTO(String userId, String userPw, String userName, String userCellnum) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userCellnum = userCellnum;
	}
	
	////////getter,setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCellnum() {
		return userCellnum;
	}

	public void setUserCellnum(String userCellnum) {
		this.userCellnum = userCellnum;
	}
	
	
}
