package com.dal.employee;

public class MyConn {
	private String dbname;
	private String uname;
	private String password;

public MyConn() {
	super();
	// TODO Auto-generated constructor stub
}

public MyConn(String dbname, String uname, String password) {
	super();
	this.dbname = dbname;
	this.uname = uname;
	this.password = password;
}
public String getDbname() {
	return dbname;
}

public void setDbname(String dbname) {
	this.dbname = dbname;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "MyDao [dbname=" + dbname + ", uname=" + uname + ", password=" + password + "]";
}
} 
