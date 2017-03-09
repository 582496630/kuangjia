package cn.goodjobs.cms.domain;

public class Users {
	
	private Long id;
	
	private String name;
	
	private String pass;
	
	private Integer age;
	


	private String sex;


	private Integer weight;
	
	private String nation;
	private Integer shengao;
	
	public Integer getShengao() {
		return shengao;
	}

	public void setShengao(Integer shengao) {
		this.shengao = shengao;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer height) {
		this.weight = height;
	}
	private String hobby;
	

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;

	}


	public Users(){
		
	}
	
	public Users(Long id){
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
}
