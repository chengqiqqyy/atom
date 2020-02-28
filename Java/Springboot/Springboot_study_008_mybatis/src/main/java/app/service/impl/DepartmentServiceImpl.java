package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Department;
import app.mapper.DepartmentMapper;
import app.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> findAllDepartment() {
		return departmentMapper.findAllDepartment();
	}

	@Override
	public Department findDepartmentByCode(String code) {
		return departmentMapper.findDepartmentByCode(code);
	}

}
