package dto;

public class student {
	private int studentid;
	private String name;
	private String email;
	private String phone;
	private int age;
	private int courseid;
	
	public student(int studentid,String name,String email,String phone,int age,int courseid){
		this.studentid=studentid;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.age=age;
		this.setCourseid(courseid);
	}
	
	//getter
	
	public int getstudentid() {
		return studentid;
	}
	public String getname() {
		return name;
	}
	public String getemail() {
		return email;
	}
	public String getphone() {
		return phone;
	}
	public int getage() {
		return age;
	}
	
	
	//setter
	public void setstudentid(int studentid) {
		this.studentid=studentid;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setemail(String email) {
		this.email=email;
	}
	public void setphone(String phone) {
		this.phone=phone;
	}
	public void setage(int age) {
		this.age=age;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

}
