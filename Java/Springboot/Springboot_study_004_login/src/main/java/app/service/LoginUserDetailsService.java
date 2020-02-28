package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.db.User;
import app.details.LoginUserDetails;
import app.imp.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository userRepos;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepos.findByUsername(username);
		if(user == null) throw new UsernameNotFoundException("User not found");
		return new LoginUserDetails(user);
	}

}
