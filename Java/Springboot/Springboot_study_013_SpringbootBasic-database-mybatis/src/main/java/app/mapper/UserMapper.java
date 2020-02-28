package app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import app.entity.User;

@Mapper
public interface UserMapper {
	List<User> findAll();
	User findUserById(Long id);
	int insertUser(@Param("username") String username, @Param("sex") int sex, @Param("note") String note);
//	int insertUserDefault(String username, int sex, String note);
//	int insertUserRequireNew(String username, int sex, String note);
//	int insertUserNested(String username, int sex, String note);
//	int isertUsersDefault(List<User> userList);
//	int isertUsersRequireNew(List<User> userList);
//	int isertUsersNested(List<User> userList);
}
