package app.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.h2JpaDb.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
