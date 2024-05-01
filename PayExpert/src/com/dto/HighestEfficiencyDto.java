package com.dto;

public class HighestEfficiencyDto {
	private String name;
	private String position;
	private int efficiency;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}
	public HighestEfficiencyDto(String name, String position, int efficiency) {
		super();
		this.name = name;
		this.position = position;
		this.efficiency = efficiency;
	}
	public HighestEfficiencyDto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HighestEfficiencyDto [name=" + name + ", position=" + position + ", efficiency=" + efficiency + "]";
	}
	
	

}
