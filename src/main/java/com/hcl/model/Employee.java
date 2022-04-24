package com.hcl.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_RELEASE_DET")
public class Employee {

	@Id
	@Column(name = "SAP_ID")
	private String sapId;
	
	@Column(name="FRESHER_LATERAL")
	private String fresherOrLateral;
	
	@Column(name="Employee_Name")
	private String empName;
	
	@Column(name="PROJECT_NAME")
	private String projectName;
	
	@Column(name="BAND")
	private String band;
	
	@Column(name="RELEASE_DATE") // DD-MM-YY
	private Date releaseDate;
	
	@Column(name="DELIMITATION_DATE_RAS")
	private Date delimitationDateInRAS;
	
	@Column(name="REASON_FOR_RELEASE")
	private String reasonforRelease;
	
	@Column(name="PART_OF_ROTATION")
	private String partOfRotation;
	
	@Column(name="FEEDBACK")
	private String performanceFeedback;

	@Column(name="NUMBEROF_MONTHS_WORKED")
	private String noOfMonthsWorked;
	
	@Column(name="BOARD_SKILL")
	private String boardSkil;
	
	@Column(name="SKILL_SET")
	private String skillSet;
	
	@Column(name="EXP_IN_YRS")
	private String expInYrs;
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name="CURRENT_LOCATION")
	private String currentLocation;
	
	@Column(name="LEAVE_PLAN")
	private String leavePlan;
	
	@Column(name="RELEASE_REQUESTOR")
	private String releaseRequestor;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="UPLOADED_DATE")
	private Date uploadedDate;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public String getFresherOrLateral() {
		return fresherOrLateral;
	}

	public void setFresherOrLateral(String fresherOrLateral) {
		this.fresherOrLateral = fresherOrLateral;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getDelimitationDateInRAS() {
		return delimitationDateInRAS;
	}

	public void setDelimitationDateInRAS(Date delimitationDateInRAS) {
		this.delimitationDateInRAS = delimitationDateInRAS;
	}

	public String getReasonforRelease() {
		return reasonforRelease;
	}

	public void setReasonforRelease(String reasonforRelease) {
		this.reasonforRelease = reasonforRelease;
	}

	public String getPartOfRotation() {
		return partOfRotation;
	}

	public void setPartOfRotation(String partOfRotation) {
		this.partOfRotation = partOfRotation;
	}

	public String getPerformanceFeedback() {
		return performanceFeedback;
	}

	public void setPerformanceFeedback(String performanceFeedback) {
		this.performanceFeedback = performanceFeedback;
	}

	public String getNoOfMonthsWorked() {
		return noOfMonthsWorked;
	}

	public void setNoOfMonthsWorked(String noOfMonthsWorked) {
		this.noOfMonthsWorked = noOfMonthsWorked;
	}

	public String getBoardSkil() {
		return boardSkil;
	}

	public void setBoardSkil(String boardSkil) {
		this.boardSkil = boardSkil;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public String getExpInYrs() {
		return expInYrs;
	}

	public void setExpInYrs(String expInYrs) {
		this.expInYrs = expInYrs;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getLeavePlan() {
		return leavePlan;
	}

	public void setLeavePlan(String leavePlan) {
		this.leavePlan = leavePlan;
	}

	public String getReleaseRequestor() {
		return releaseRequestor;
	}

	public void setReleaseRequestor(String releaseRequestor) {
		this.releaseRequestor = releaseRequestor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Employee [sapId=" + sapId + ", fresherOrLateral=" + fresherOrLateral + ", empName=" + empName
				+ ", projectName=" + projectName + ", band=" + band + ", releaseDate=" + releaseDate
				+ ", delimitationDateInRAS=" + delimitationDateInRAS + ", reasonforRelease=" + reasonforRelease
				+ ", partOfRotation=" + partOfRotation + ", performanceFeedback=" + performanceFeedback
				+ ", noOfMonthsWorked=" + noOfMonthsWorked + ", boardSkil=" + boardSkil + ", skillSet=" + skillSet
				+ ", expInYrs=" + expInYrs + ", contactNumber=" + contactNumber + ", currentLocation=" + currentLocation
				+ ", leavePlan=" + leavePlan + ", releaseRequestor=" + releaseRequestor + ", status=" + status
				+ ", uploadedDate=" + uploadedDate + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ "]";
	}
	
	
}
