package com.admin;

public class Flights {
	private int flightNumber;
	private String source;
	private String destination;
	private String time;
	private int duration;
	private int price;
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Flights(int flightNumber, String source, String destination, String time, int duration, int price) {
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.time = time;
		this.duration = duration;
		this.price = price;
	}
	
}
