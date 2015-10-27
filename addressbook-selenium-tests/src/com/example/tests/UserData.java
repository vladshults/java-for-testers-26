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
}
