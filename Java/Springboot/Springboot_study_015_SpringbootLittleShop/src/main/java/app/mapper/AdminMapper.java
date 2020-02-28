package app.mapper;

import org.apache.ibatis.annotations.Mapper;

import app.entity.Admin;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
	int insertAdmin(Admin admin);
}
