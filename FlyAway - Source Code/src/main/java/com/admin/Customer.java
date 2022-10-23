package com.admin;

public class Customer {
private String name;
private long phone;
private int flightno;
private long cardno;
private String cardname;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public int getFlightno() {
	return flightno;
}
public void setFlightno(int flightno) {
	this.flightno = flightno;
}
public long getCardno() {
	return cardno;
}
public void setCardno(long cardno) {
	this.cardno = cardno;
}
public String getCardname() {
	return cardname;
}
public void setCardname(String cardname) {
	this.cardname = cardname;
}
@Override
public String toString() {
	return "Customer [name=" + name + ", phone=" + phone + ", flightno=" + flightno + ", cardno=" + cardno
			+ ", cardname=" + cardname + "]";
}


}
