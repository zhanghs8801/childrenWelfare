package cn.child.welfare.entity;

/**
 * 用户
 */
public class User extends BaseEntity {
	private static final long serialVersionUID = -513810604986828521L;
	/**
	 * 登录邮箱
	 */
	private String email;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * QQ
	 */
	private String qq;
	/**
	 * 团队名称
	 */
	private String teamName;
	/**
	 * 业务描述
	 */
	private String bizDesc;
	/**
	 * 联系人
	 */
	private String contact;
	/**
	 * 1 激活
	 * 0 冻结
	 */
	private int status;
	/**
	 * 账号类型
	 */
	private UserType type = UserType.CUSTOMER;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getBizDesc() {
		return bizDesc;
	}

	public void setBizDesc(String bizDesc) {
		this.bizDesc = bizDesc;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public UserType getType() {
		return type;
	}
	
	public void setType(UserType type) {
		this.type = type;
	}
}
