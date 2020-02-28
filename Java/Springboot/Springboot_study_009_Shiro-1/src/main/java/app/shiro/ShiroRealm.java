package app.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		System.out.println("Password : " + password);
		
		User user = userMapper.findUserByUsername(username);
		
		
		if(user == null) {
			throw new UnknownAccountException("Wrong Account or Password.");
		}
		if(!password.equals(user.getPassword())) {
			throw new UnknownAccountException("Wrong Account or Password.");
		}
		if(user.getStatus() == -1) {
			throw new AuthenticationException("Account has been locked. Please contact the administrator.");
		}
		
		System.out.println(user.toString());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
