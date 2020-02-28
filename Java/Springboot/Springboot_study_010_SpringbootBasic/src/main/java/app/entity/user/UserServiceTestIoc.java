package app.entity.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceTestIoc {
	public void printUser(User user) {
		System.out.println(user.toString());
	}
}
