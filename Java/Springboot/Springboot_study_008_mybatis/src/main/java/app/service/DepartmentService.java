package app.service;

import java.util.List;

import app.entity.Department;

public interface DepartmentService {
	public List<Department> findAllDepartment();
	public Department findDepartmentByCode(String code);
}
