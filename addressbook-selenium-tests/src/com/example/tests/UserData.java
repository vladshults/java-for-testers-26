package com.example.tests;

public class UserData {
	public String firstname;
	public String lastname;
	public String firstaddr;
	public String mobilephone;
	public String homephone;
	public String jobphone;
	public String firstmail;
	public String secondmail;
	public String selectbdate;
	public String selectbmonth;
	public String byear;
	public String selectgroup;
	public String secondaddr;
	public String secondphone;

	public UserData() {
	}
	
	public UserData(String firstname, String lastname, String firstaddr, String mobilephone, String homephone,
			String jobphone, String firstmail, String secondmail, String selectbdate, String selectbmonth, String byear,
			String selectgroup, String secondaddr, String secondphone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.firstaddr = firstaddr;
		this.mobilephone = mobilephone;
		this.homephone = homephone;
		this.jobphone = jobphone;
		this.firstmail = firstmail;
		this.secondmail = secondmail;
		this.selectbdate = selectbdate;
		this.selectbmonth = selectbmonth;
		this.byear = byear;
		this.selectgroup = selectgroup;
		this.secondaddr = secondaddr;
		this.secondphone = secondphone;
	}
}
