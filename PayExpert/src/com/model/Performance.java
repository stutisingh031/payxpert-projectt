package com.model;

import java.util.Objects;

public class Performance {
	@Override
	public int hashCode() {
		return Objects.hash(absent_days, efficiency, employee_id, overtime_period, performance_id, present_days);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Performance other = (Performance) obj;
		return absent_days == other.absent_days && efficiency == other.efficiency && employee_id == other.employee_id
				&& Objects.equals(overtime_period, other.overtime_period) && performance_id == other.performance_id
				&& present_days == other.present_days;
	}
	//Work Done By Priyankka
	private int performance_id;
	private int present_days;
	private int absent_days;
	private String overtime_period;
	private int efficiency;
	private int employee_id;
	public int getPerformance_id() {
		return performance_id;
	}
	public void setPerformance_id(int performance_id) {
		this.performance_id = performance_id;
	}
	public int getPresent_days() {
		return present_days;
	}
	public void setPresent_days(int present_days) {
		this.present_days = present_days;
	}
	public int getAbsent_days() {
		return absent_days;
	}
	public void setAbsent_days(int absent_days) {
		this.absent_days = absent_days;
	}
	public String getOvertime_period() {
		return overtime_period;
	}
	public void setOvertime_period(String overtime_period) {
		this.overtime_period = overtime_period;
	}
	public int getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Performance(int performance_id, int present_days, int absent_days, String overtime_period, int efficiency,
			int employee_id) {
		super();
		this.performance_id = performance_id;
		this.present_days = present_days;
		this.absent_days = absent_days;
		this.overtime_period = overtime_period;
		this.efficiency = efficiency;
		this.employee_id = employee_id;
	}
	public Performance() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Performance [performance_id=" + performance_id + ", present_days=" + present_days + ", absent_days="
				+ absent_days + ", overtime_period=" + overtime_period + ", efficiency=" + efficiency + ", employee_id="
				+ employee_id + "]";
	}
	

}
