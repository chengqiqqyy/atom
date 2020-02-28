package app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.User;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	UserService userService;
	

	
	@Test
	public void findAllTest() {
		assertThat(userService.findAll()).isNotNull().matches(u -> u.size() == 1);
	}
	
	@Test
	public void findUserById() {
		assertThat(userService.findUserById(1l)).isNotNull().matches(u -> u.getUsername().equals("user1"));
	}
	
	@Test
	public void findUserByUsernameAndPassword() {
		assertThat(userService.findUserLikeUsername("mi")).isNotNull();
	}
	
	@Test
	public void insertUser() {
		User user = new User();
		user.setUsername("Anna");
		user.setPassword("anna");
		
		assertThat(userService.insertUser(user)).isEqualByComparingTo(1);
	}
	
	@Test
	public void updateUser() {
		User user = userService.findUserById(1l);
		user.setAddress("23333");
		user.setPhone("1582333333333");
		user.setNote("This is test");
		
		assertThat(userService.updateUser(user)).isEqualByComparingTo(1);
	}
	
	@Test
	public void deleteUser() {
		assertThat(userService.deleteUserById(1l)).isEqualByComparingTo(1);
	}
	
	
	
	
	
	
	
	
}
