package com.dto;

public class EmployeeRecordDto {
	
	  private int employeeId;
	  private String name;
      private String position;
      private int userId ;
	  private int amount;
	  private String recordType;
	  private int recordId;
	  private String description;
	  
	public EmployeeRecordDto(int employeeId, String name, String position, int userId, int amount, String recordType,
			int recordId, String description) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.position = position;
		this.userId = userId;
		this.amount = amount;
		this.recordType = recordType;
		this.recordId = recordId;
		this.description = description;
	}

	public EmployeeRecordDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EmployeeRecordDto [employeeId=" + employeeId + ", name=" + name + ", position=" + position + ", userId="
				+ userId + ", amount=" + amount + ", recordType=" + recordType + ", recordId=" + recordId
				+ ", description=" + description + "]";
	}
	
	
	  
	  
	

}
