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
public class ConceptRelReqDTO {
	
	@JsonProperty("idConceptUp") 
	private Integer liIdConceptUp;
	
	@JsonProperty("idApplication") 
	private Integer liIdApplication;
	
	@JsonProperty("idCompany") 
	private Integer liIdCompany;
	
	@JsonProperty("username") 
	private String lsUsername;
	
	@JsonProperty("nomCatalog") 
	private String lsNomCatalog;
	
	@JsonProperty("idConceptDown") 
	private Integer liIdConceptDown;
	
	@JsonProperty("idRelation") 
	private Integer liIdRelation;
	
	@JsonProperty("indValue") 
	private Double liIndValue;
	
	@JsonProperty("indNivel") 
	private Integer liIndNivel;
	
	@JsonProperty("operationType") 
	private Integer liOperationType;
	
	@JsonProperty("attribute1") 
	private String lsAttribute1;
	
	public Integer getLiIdConceptUp() {
		return liIdConceptUp;
	}
	public void setLiIdConceptUp(Integer liIdConceptUp) {
		this.liIdConceptUp = liIdConceptUp;
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
	public String getLsUsername() {
		return lsUsername;
	}
	public void setLsUsername(String lsUsername) {
		this.lsUsername = lsUsername;
	}
	public String getLsNomCatalog() {
		return lsNomCatalog;
	}
	public void setLsNomCatalog(String lsNomCatalog) {
		this.lsNomCatalog = lsNomCatalog;
	}
	public Integer getLiIdConceptDown() {
		return liIdConceptDown;
	}
	public void setLiIdConceptDown(Integer liIdConceptDown) {
		this.liIdConceptDown = liIdConceptDown;
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
	public Integer getLiIndNivel() {
		return liIndNivel;
	}
	public void setLiIndNivel(Integer liIndNivel) {
		this.liIndNivel = liIndNivel;
	}
	public Integer getLiOperationType() {
		return liOperationType;
	}
	public void setLiOperationType(Integer liOperationType) {
		this.liOperationType = liOperationType;
	}
	public String getLsAttribute1() {
		return lsAttribute1;
	}
	public void setLsAttribute1(String lsAttribute1) {
		this.lsAttribute1 = lsAttribute1;
	}
	
	
	
	

}
