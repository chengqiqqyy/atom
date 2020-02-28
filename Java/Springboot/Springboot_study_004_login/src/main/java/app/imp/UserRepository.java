package app.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.db.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findById(int id);
	public User findByUsername(String username);
}
