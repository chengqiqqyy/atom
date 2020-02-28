package app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AdminServiceTest {
	@Autowired
	AdminService adminService;

	@Test
	public void findAllTest() {
		assertThat(adminService.findAll()).matches(a -> a.size() == 1);
	}
	
	@Test
	public void findAdminById() {
		assertThat(adminService.findAdminById(1l)).matches(a -> a.getUsername().equals("admin"));
	}
	
	@Test
	public void findAdminByUsernameAndPassword() {
		assertThat(adminService.findAdminByUsernameAndPassword("Admin", "admin")).isNotNull().matches(a -> a.getUsername().equals("admin"));
	}
	
	@Test
	public void findAdminLikeName() {
		assertThat(adminService.findAdminLikeNme("mi")).isNotNull().matches(a -> a.get(0).getUsername().equals("admin"));
	}
	
	@Test
	public void deleteAdminById() {
		assertThat(adminService.deleteAdminById(1l)).isEqualTo(1);
	}
	
}
