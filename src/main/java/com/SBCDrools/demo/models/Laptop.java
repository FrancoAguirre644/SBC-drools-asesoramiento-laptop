package com.SBCDrools.demo.models;

public class Laptop {

	private String name;
	private String utility;
	private String size;
	private String battery;
	private String cost;

	public Laptop() {
	}

	public Laptop(String name, String utility, String size, String battery, String cost) {
		super();
		this.name = name;
		this.utility = utility;
		this.size = size;
		this.battery = battery;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUtility() {
		return utility;
	}

	public void setUtility(String utility) {
		this.utility = utility;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Laptop [name=" + name + ", utility=" + utility + ", size=" + size + ", battery=" + battery + ", cost="
				+ cost + "]";
	}

}
