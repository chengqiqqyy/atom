package app.mapper;

import java.util.List;

import app.entity.Department;

public interface DepartmentMapper {
	public List<Department> findAllDepartment();
	public Department findDepartmentByCode(String code);
}
