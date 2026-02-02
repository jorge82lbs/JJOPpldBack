package com.sppld.pld.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QualifyReqDTO {

	@JsonProperty("idQualifyFor")
	private Integer liIdQualifyFor;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;
	
	@JsonProperty("idCompany")
	private Integer liIdCompany;
	
	@JsonProperty("idClient")
	private Integer liIdClient;
	
	@JsonProperty("idRelationUp")
	private Integer liIdRelationUp;
	
	@JsonProperty("idRelation")
	private Integer liIdRelation;
	
	@JsonProperty("indValue")
	private Double liIndValue;
	
	@JsonProperty("username")
	private String lsUsername;
	
	@JsonProperty("operationType")
	private Integer liIOperationType;
	
	
	public Integer getLiIdQualifyFor() {
		return liIdQualifyFor;
	}
	public void setLiIdQualifyFor(Integer liIdQualifyFor) {
		this.liIdQualifyFor = liIdQualifyFor;
	}
	public Integer getLiIdApplication() {
		return liIdApplication;
	}
	public void setLiIdApplication(Integer liIdApplication) {
		this.liIdApplication = liIdApplication;
	}
	public Integer getLiIdCompany() {
		return liIdCompany;
	}
	public void setLiIdCompany(Integer liIdCompany) {
		this.liIdCompany = liIdCompany;
	}
	public Integer getLiIdClient() {
		return liIdClient;
	}
	public void setLiIdClient(Integer liIdClient) {
		this.liIdClient = liIdClient;
	}
	public Integer getLiIdRelation() {
		return liIdRelation;
	}
	public void setLiIdRelation(Integer liIdRelation) {
		this.liIdRelation = liIdRelation;
	}
	public Double getLiIndValue() {
		return liIndValue;
	}
	public void setLiIndValue(Double liIndValue) {
		this.liIndValue = liIndValue;
	}
	public String getLsUsername() {
		return lsUsername;
	}
	public void setLsUsername(String lsUsername) {
		this.lsUsername = lsUsername;
	}
	public Integer getLiIOperationType() {
		return liIOperationType;
	}
	public void setLiIOperationType(Integer liIOperationType) {
		this.liIOperationType = liIOperationType;
	}
	public Integer getLiIdRelationUp() {
		return liIdRelationUp;
	}
	public void setLiIdRelationUp(Integer liIdRelationUp) {
		this.liIdRelationUp = liIdRelationUp;
	}
	
	
}
