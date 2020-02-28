package app.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import app.entity.User;
import app.mapper.UserMapper;

public class ShiroRealm extends AuthorizingRealm{
	@Autowired
	UserMapper userMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	
	/*
	 * User Authentication
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// Get username ande password
		String username = (String)token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		
		System.out.println("Username: " + username + " 认证 ----- doGetAuthenticationInfo");
		System.out.println(getName());
		
		// Query user by username
		User user = userMapper.findUserByUsername(username);
		
		if(user == null) {
			throw new UnknownAccountException("Worng username or password!");
		}
		if(!password.equals(user.getPassword())) {
			throw new UnknownAccountException("Wrong username or password!");
		}
		if(user.getStatus() == 0) {
			throw new LockedAccountException("Account has been locked. Please contact the administrator.");
		}
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
