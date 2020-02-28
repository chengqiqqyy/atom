package app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import app.entity.User;

public interface UserService extends IService<User>{
	void addUser(User user);
}
