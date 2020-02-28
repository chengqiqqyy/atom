package app.jdbctemplate.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import app.entity.User;
import app.enumeration.SexEnum;
import app.jdbctemplate.service.JdbcTemUserService;

@Service
public class JdbcTemUserServiceImpl implements JdbcTemUserService{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> getUserMapper() {
		RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setSex(SexEnum.getEnumById(rs.getInt("sex")));
			user.setNote(rs.getString("note"));
			
			return user;
		};
		return userRowMapper;
	}
	
	@Override
	public User getUser(Long id) {
		String sql = "select * from user where id = ?";
		Object[] args = new Object[] { id };
		User user = jdbcTemplate.queryForObject(sql, args, getUserMapper());
		return user;
	}
	
	/*
	 * JdbcTemplate 每次执行sql时都会重新分配一个连接池资源
	 * n当我们想要在一个连接中执行多条sql时，我们可以使用 StatementCallback 或  ConnectionCallbck 接口来实现回调
	 */
	public User getUser2(Long id) {
		// n通过Lambda表达式使用StatementCallback
		User result = this.jdbcTemplate.execute((Statement st) -> {
			String sql1 = "select count(*) from user where id = " + id;
			ResultSet rs1 = st.executeQuery(sql1);
			while(rs1.next()) {
				int total = rs1.getInt("total");
				System.out.println(total);
			}
			
			String sql2 = "select * from user where id = " + id;
			ResultSet rs2 = st.executeQuery(sql2);
			User user = null;
			while(rs2.next()) {
				user = getUserMapper().mapRow(rs2, rs2.getRow());
			}
			return user;
		});
		return result;
	}
	
	public User getUser3(Long id) {
		// n通过Lambda表达式使用ConnectionCallback
		return this.jdbcTemplate.execute((Connection con) -> {
			String sql1 = "select count(*) from user where id = ?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setLong(1, id);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				System.out.println(rs1.getInt("total"));
			}
			
			String sql2 = "select * from user where id = ?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setLong(1, id);
			ResultSet rs2 = ps2.executeQuery();
			User user = null;
			while(rs2.next()) {
				user = getUserMapper().mapRow(rs2, rs2.getRow());
			}
			return user;
		});
	}

	@Override
	public List<User> findUsers(String username, String note) {
		String sql = "select * from user where username like concat('%',?,'%') and note like concat('%',?,'%')";
		Object[] args = new Object[] { username, note };
		List<User> userList = jdbcTemplate.query(sql, args, getUserMapper());
		return userList;
	}
	
	@Override
	public List<User> showAllUser() {
		String sql = "select * from user";
		List<User> userList = jdbcTemplate.query(sql, getUserMapper());
		return userList;
	}

	@Override
	public int insertUser(User user) {
		String sql = "insert into user (username,sex,note) values (?,?,?)";
		return jdbcTemplate.update(sql, user.getUsername(), user.getSex().getId(), user.getNote());
	}

	@Override
	public int updateUser(User user) {
		String sql = "update user set username = ?, sex = ?, note = ? where id = ?";
		return jdbcTemplate.update(sql, user.getUsername(), user.getSex().getId(), user.getNote(), user.getId());
	}

	@Override
	public int deleteUser(Long id) {
		String sql = "delete from user where id = ?";
		return jdbcTemplate.update(sql, id);
	}
	
}
