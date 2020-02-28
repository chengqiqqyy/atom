package app.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import app.entity.User;
import app.mapper.UserMapper;
import app.service.UserService;

@Service
@DS("slave")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Override
	@DS("master")//这里必须包一层，不能调用mp默认的插入，因为会走到从库去
	public void addUser(User user) {
		baseMapper.insert(user);
	}

}
