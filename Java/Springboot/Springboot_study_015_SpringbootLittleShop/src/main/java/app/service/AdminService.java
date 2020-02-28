package app.service;

import java.util.List;

import app.entity.Admin;

public interface AdminService {
	List<Admin> findAll();
	Admin findAdminById(Long id);
	Admin findAdminByUsernameAndPassword(String username, String password);
	List<Admin> findAdminLikeNme(String username);
	int deleteAdminById(Long id);
}
