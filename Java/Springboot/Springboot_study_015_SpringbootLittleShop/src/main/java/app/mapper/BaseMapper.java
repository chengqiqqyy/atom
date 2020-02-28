package app.mapper;

import java.util.List;

public interface BaseMapper<T> {
	List<T> findAll();
	T findById(Long id);
	T findByUsernameAndPassword(String username, String password);
	List<T> findLikeName(String name);
	int insert(T t);
	int update(T t);
	int deleteById(Long id);
}
