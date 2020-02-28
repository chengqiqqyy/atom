package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Admin;
import app.mapper.AdminMapper;
import app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminMapper adminMapper;

	@Override
	public List<Admin> findAll() {
		return adminMapper.findAll();
	}
	
	@Override
	public Admin findAdminById(Long id) {
		return adminMapper.findById(id);
	}

	@Override
	public Admin findAdminByUsernameAndPassword(String username, String password) {
		return adminMapper.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<Admin> findAdminLikeNme(String username) {
		return adminMapper.findLikeName("%" + username + "%");
	}

	@Override
	public int deleteAdminById(Long id) {
		return adminMapper.deleteById(id);
	}
}
