package app.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	// n使用@Query注解，需要在@Entity注解指定name属性
	@Query("from user where username like concat('%',?1,'%') and note like concat('%',?1,'%')")
	public List<User> findUsers(String username, String note);
	public User findUserById(Long id);
	public List<User> findUserByUsernameLike(String username);
	public List<User> findUserByUsernameLikeOrNoteLike(String username, String note);
}
