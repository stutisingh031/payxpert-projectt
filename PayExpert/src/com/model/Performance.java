package com.model;

public class Performance {
	private int performanceId;
	private int presentDays;
    private int absentDays;
    private String overtimePeriod;
    private double efficiency;
	public Performance(int performanceId,int presentDays, int absentDays, String overtimePeriod, double efficiency) {
		super();
		this.setPerformanceId(performanceId);
		this.presentDays = presentDays;
		this.absentDays = absentDays;
		this.overtimePeriod = overtimePeriod;
		this.efficiency = efficiency;
	}
	public Performance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPresentDays() {
		return presentDays;
	}
	public void setPresentDays(int presentDays) {
		this.presentDays = presentDays;
	}
	public int getAbsentDays() {
		return absentDays;
	}
	public void setAbsentDays(int absentDays) {
		this.absentDays = absentDays;
	}
	public String getOvertimePeriod() {
		return overtimePeriod;
	}
	public void setOvertimePeriod(String overtimePeriod) {
		this.overtimePeriod = overtimePeriod;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	public int getPerformanceId() {
		return performanceId;
	}
	public void setPerformanceId(int performanceId) {
		this.performanceId = performanceId;
	}
	@Override
	public String toString() {
		return "Performance [performanceId=" + performanceId + ", presentDays=" + presentDays + ", absentDays="
				+ absentDays + ", overtimePeriod=" + overtimePeriod + ", efficiency=" + efficiency + "]";
	}
	
}
