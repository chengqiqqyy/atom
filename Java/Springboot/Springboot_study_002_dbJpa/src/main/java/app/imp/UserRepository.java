package app.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.db.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public void deleteById(long id);
}