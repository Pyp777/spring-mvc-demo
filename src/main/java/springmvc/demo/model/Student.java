package springmvc.demo.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Student {
	private String name;
	private String hobby;
	private String phone;
	
	// size is for string
	//@Size(min=5, max=25, message="moc velkky nebo moc maly")
	@NotNull
	@Range(min=5, max=25, message="moc velkky nebo moc maly")
	private Integer age;
	
	private Date birth;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", hobby=" + hobby + ", phone=" + phone + ", age=" + age + ", birth=" + birth
				+ "]";
	}


}
