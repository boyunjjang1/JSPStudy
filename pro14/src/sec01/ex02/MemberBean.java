package sec01.ex02;

import java.sql.Date;

public class MemberBean {
	private String id;
	private String pwd;
	private String name;
	private String emial;
	private Date joinDate;
	private Address addr;
	
	
	public MemberBean() {
		
	}


	public MemberBean(String id, String pwd, String name, String emial) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.emial = emial;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmial() {
		return emial;
	}


	public void setEmail(String emial) {
		this.emial = emial;
	}


	public Date getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}


	public Address getAddr() {
		return addr;
	}


	public void setAddr(Address addr) {
		this.addr = addr;
	}
}
	
	