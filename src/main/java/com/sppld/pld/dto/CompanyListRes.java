package com.sppld.pld.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyListRes {
	
	@JsonProperty("id") 
    private Integer liId;
	
	@JsonProperty("idCompany")
	private Integer liIdCompany;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;
		
	@JsonProperty("indRfc")
	private String lsIndRfc;
	
	@JsonProperty("indDescription")
	private String lsIndDescription;
	
	@JsonProperty("indEmail")
	private String lsIndEmail;
	
	@JsonProperty("indEstatus") 
    private String lsIndEstatus;
	
	@JsonProperty("indCreatedBy") 
    private String lsIndCreatedBy;
	
	@JsonProperty("operationType") 
    private Integer liOperationType;

	public Integer getLiIdCompany() {
		return liIdCompany;
	}

	public void setLiIdCompany(Integer liIdCompany) {
		this.liIdCompany = liIdCompany;
	}

	public Integer getLiIdApplication() {
		return liIdApplication;
	}

	public void setLiIdApplication(Integer liIdApplication) {
		this.liIdApplication = liIdApplication;
	}

	public String getLsIndRfc() {
		return lsIndRfc;
	}

	public void setLsIndRfc(String lsIndRfc) {
		this.lsIndRfc = lsIndRfc;
	}

	public String getLsIndDescription() {
		return lsIndDescription;
	}

	public void setLsIndDescription(String lsIndDescription) {
		this.lsIndDescription = lsIndDescription;
	}

	public String getLsIndEmail() {
		return lsIndEmail;
	}

	public void setLsIndEmail(String lsIndEmail) {
		this.lsIndEmail = lsIndEmail;
	}

	public String getLsIndEstatus() {
		return lsIndEstatus;
	}

	public void setLsIndEstatus(String lsIndEstatus) {
		this.lsIndEstatus = lsIndEstatus;
	}

	public String getLsIndCreatedBy() {
		return lsIndCreatedBy;
	}

	public void setLsIndCreatedBy(String lsIndCreatedBy) {
		this.lsIndCreatedBy = lsIndCreatedBy;
	}

	public Integer getLiOperationType() {
		return liOperationType;
	}

	public void setLiOperationType(Integer liOperationType) {
		this.liOperationType = liOperationType;
	}

	public Integer getLiId() {
		return liId;
	}

	public void setLiId(Integer liId) {
		this.liId = liId;
	}
	
	
	

}
