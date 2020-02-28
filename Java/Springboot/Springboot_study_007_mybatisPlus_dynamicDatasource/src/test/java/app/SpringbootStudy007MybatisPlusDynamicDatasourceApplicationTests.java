package app;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.entity.User;
import app.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootStudy007MybatisPlusDynamicDatasourceApplicationTests {

	private Random random = new Random();

	  @Autowired
	  private UserService userService;

	  @Test
	  public void addUser() {
	    User user = new User();
	    user.setName("测试用户" + random.nextInt());
	    user.setAge(random.nextInt(100));
	    userService.addUser(user);
	  }
	  
	  @Test
	  public void selectUser() {
		  userService.list(null);
	  }
}
