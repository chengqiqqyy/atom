package app.service.impl;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.entity.User;
import app.mapper.UserMapper;
import app.service.UserService;

@Service
public class UserServiceImpl implements UserService,ApplicationContextAware{
	@Autowired
	UserMapper userMapper;
	@Autowired
	ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
	public User findUserById(Long id) {
		return userMapper.findUserById(id);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
	public int insertUser(String username, int sex, String note) {
		return userMapper.insertUser(username,sex,note);
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, propagation = Propagation.REQUIRED)
	public int insertUserDefault(String username, int sex, String note) {
		return userMapper.insertUser(username, sex, note);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, propagation = Propagation.REQUIRES_NEW)
	public int insertUserRequireNew(String username, int sex, String note) {
		return userMapper.insertUser(username, sex, note);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, propagation = Propagation.NESTED)
	public int insertUserNested(String username, int sex, String note) {
		return userMapper.insertUser(username, sex, note);
	}

	/*
	 * @Transactional
	 * - 自调用不会触发@Transactional事务
	 * - 解决方法1
	 * -    新建Service类，在新Service类中使用@Trasactional注解,调用UserServiceImpl方法
	 * - 解决方法2
	 * -    通过IOC容器获取UserService接口对象，通过IOC容器获取的对象将是一个代理对象
	 * -    实现ApplicationContextAware接口； 注入ApplicationContext； 重写setApplicationContext方法
	 */
	@Override
	// default is required.
	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
	public int insertUsersDefault(List<User> userList) {
		// - 此时使用的是 UserService接口， 而不是 UserMapper接口
		UserService userService = applicationContext.getBean(UserService.class);
		int count = 0;
		for(User user : userList) {
			count += userService.insertUserDefault(user.getUsername(), user.getSex().getId(), user.getNote());
		}
		return count;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
	public int insertUsersRequireNew(List<User> userList) {
		// - 此时使用的是 UserService接口， 而不是 UserMapper接口
		UserService userService = applicationContext.getBean(UserService.class);
		int count = 0;
		for(User user : userList) {
			count += userService.insertUserRequireNew(user.getUsername(), user.getSex().getId(), user.getNote());
		}
		return count;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
	public int insertUsersNested(List<User> userList) {
		// - 此时使用的是 UserService接口， 而不是 UserMapper接口
		UserService userService = applicationContext.getBean(UserService.class);
		int count = 0;
		for(User user : userList) {
			count += userService.insertUserNested(user.getUsername(), user.getSex().getId(), user.getNote());
		}
		return count;
	}
}
