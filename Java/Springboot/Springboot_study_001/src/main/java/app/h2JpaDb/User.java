package app.h2JpaDb;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User {
	/*
	 * @Entity エンティティクラスとしてクラスを定義 
	 * @Table(name="user") エンティティクラスに割り当てられるテーブル名 
	 * @Id プライマリキーを指定 
	 * @GeneratedValue(strategy = GenerationType.AUTO) AUTO：プライマリキーの値を自動採番する 
	 * @Column カラム名　※以下の指定も可 
	 * 	- name：カラム名を指定
	 * 	- length：最大長を指定
	 * 	- nullable：nullを許可するか否か
	 *  example: @Colum(length=10, nullable=false)
	 * @Max
	 *  - value
	 *  example: @Max(value=100)
	 * @Min
	 *  - value
	 *  example: @Mix(value=4)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}