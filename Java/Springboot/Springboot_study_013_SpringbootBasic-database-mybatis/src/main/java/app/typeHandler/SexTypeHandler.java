package app.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import app.enumeration.SexEnum;

@MappedJdbcTypes(value = JdbcType.INTEGER)
@MappedTypes(SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.getId());
	}

	@Override
	public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int sexId = rs.getInt(columnName);
		SexEnum sex = sexId !=1 && sexId !=2 ? null : SexEnum.getSexEnumById(sexId);
		return sex;
	}

	@Override
	public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int sexId = rs.getInt(columnIndex);
		SexEnum sex = sexId != 1 && sexId != 2 ? null : SexEnum.getSexEnumById(sexId);
		return sex;
	}

	@Override
	public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int sexId = cs.getInt(columnIndex);
		SexEnum sex = sexId != 1 && sexId != 2 ? null : SexEnum.getSexEnumById(sexId);
		return sex;
	}
	
}
