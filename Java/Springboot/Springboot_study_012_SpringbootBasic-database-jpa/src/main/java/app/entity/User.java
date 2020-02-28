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
	@Id // n标明主键
	@GeneratedValue(strategy = GenerationType.AUTO) // n主键策略，递增
	@Column
	private Long id;
	@Column
	private String username;
	@Column
	@Convert(converter = SexConverter.class)
	private SexEnum sex;
	@Column
	private String note;
}
