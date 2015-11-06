package com.example.tests;

public class UserData implements Comparable<UserData> {
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

	@Override
	public String toString() {
		return "UserData [lastname = " + lastname + "]";
	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		int result = 1;
		// result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserData other = (UserData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(UserData other) {
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	}
	
	public UserData withFirstName(String name) {
		this.firstname = name;
		return this;
	}
	
	public UserData withLastName(String lastName) {
		this.lastname = lastName;
		return this;
	}
	
	public UserData withFirstAddr(String addr) {
		this.firstaddr = addr;
		return this;
	}
	
	public UserData withMobilePhone(String phone) {
		this.mobilephone = phone;
		return this;
	}
	
	public UserData withHomePhone(String phone) {
		this.homephone = phone;
		return this;
	}
	
	public UserData withJobPhone(String phone) {
		this.jobphone = phone;
		return this;
	}
	
	public UserData withFirstMail(String mail) {
		this.firstmail = mail;
		return this;
	}
	
	public UserData withSecondMail(String mail) {
		this.secondmail = mail;
		return this;
	}
	
	public UserData withBdate(String date) {
		this.selectbdate = date;
		return this;
	}
	
	public UserData withBmonth(String month) {
		this.selectbmonth = month;
		return this;
	}
	
	public UserData withByear(String year) {
		this.byear = year;
		return this;
	}
	
	public UserData withGroup(String gr) {
		this.selectgroup = gr;
		return this;
	}
	
	public UserData withSecondAddr(String addr) {
		this.secondaddr = addr;
		return this;
	}
	
	public UserData withSecondPhone(String addr) {
		this.secondaddr = addr;
		return this;
	}

	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public String getFirstAddr() {
		return firstaddr;
	}

	public String getMobilePhone() {
		return mobilephone;
	}

	public String getHomePhone() {
		return homephone;
	}

	public String getJobPhone() {
		return jobphone;
	}

	public String getFirsMail() {
		return firstmail;
	}

	public String getSecondMail() {
		return secondmail;
	}

	public String getBDate() {
		return selectbdate;
	}

	public String getBMonth() {
		return selectbmonth;
	}

	public String getBYear() {
		return byear;
	}

	public String getGroup() {
		return selectgroup;
	}

	public String getSecondAddr() {
		return secondaddr;
	}

	public String getSecondPhone() {
		return secondphone;
	}
}
