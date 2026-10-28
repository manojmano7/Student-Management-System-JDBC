package dto;

public class Parent {
	private int parent_id;
	private String name;
	private String email;
	private int phone;
	private int student_id;
	
	public Parent(int parent_id,String name,String email,int phone,int student_id) {
		this.parent_id=parent_id;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.student_id=student_id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	
}

