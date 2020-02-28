package app.enumeration;

public enum SexEnum {
	MALE(1,"Male"),FEMALE(2,"Female");
	
	private int id;
	private String sex;
	SexEnum(int id, String sex){
		this.id = id;
		this.sex = sex;
	}
	
	public static SexEnum getSexEnumById(int id) {
		for(SexEnum sex : SexEnum.values()) {
			if(sex.getId() == id) 
				return sex;
		}
		return null;
	}
	
	public static SexEnum getSexEnumBySexName(String sexName) {
		for(SexEnum sex : SexEnum.values()) 
			if(sex.getSex().equals(sexName)) return sex;
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
}
