package com.dto;

public class AverageOvertimeDto {
	private String position;
	private String avg_overtime_hours;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAvg_overtime_hours() {
		return avg_overtime_hours;
	}
	public void setAvg_overtime_hours(String avg_overtime_hours) {
		this.avg_overtime_hours = avg_overtime_hours;
	}
	public AverageOvertimeDto(String position, String avg_overtime_hours) {
		super();
		this.position = position;
		this.avg_overtime_hours = avg_overtime_hours;
	}
	public AverageOvertimeDto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AverageOvertimeDto [position=" + position + ", avg_overtime_hours=" + avg_overtime_hours + "]";
	}

}
