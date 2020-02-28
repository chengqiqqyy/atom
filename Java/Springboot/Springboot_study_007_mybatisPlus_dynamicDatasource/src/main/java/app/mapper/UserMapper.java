package app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import app.entity.User;

//@DS("slave")这里可以使用但不建议，不要和service同时使用
public interface UserMapper extends BaseMapper<User>{

}
