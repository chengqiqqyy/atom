package app.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import app.converter.SexConverter;
import app.enumeration.SexEnum;
import lombok.Data;

@Entity(name = "user")
@Table(name = "user")
@Data
public class User {
	// n标明主键
	@Id
	// n主键策略，递增
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	@Column
	@Convert(converter = SexConverter.class)
	private SexEnum sex;
	@Column
	private String note;
}
