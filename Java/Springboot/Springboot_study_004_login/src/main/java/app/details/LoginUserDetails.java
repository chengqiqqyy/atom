package app.details;

import org.springframework.security.core.authority.*;

import app.db.User;

public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1L;
	private final User user;
	
	public LoginUserDetails(User user) {
		super(user.getUsername(),user.getPassword(),AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}
