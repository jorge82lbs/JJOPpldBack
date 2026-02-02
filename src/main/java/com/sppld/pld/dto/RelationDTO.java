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
public class RelationDTO {
	@JsonProperty("idRelation") 
    
	private Integer liIdRelation;
    @JsonProperty("idApplication") 
    private Integer liIdApplication;
    @JsonProperty("idCompany") 
    private Integer liIdCompany;
    @JsonProperty("idUser") 
    private Integer liIdUser;
    @JsonProperty("operation") 
    private Integer liOperation;    
    @JsonProperty("createdBy") 
    private String lsCreatedBy;
    @JsonProperty("lastUpdatedBy") 
    private String lsLastUpdatedBy;
    
    @JsonProperty("conceptUp") 
    private Integer liConceptUp;    
    @JsonProperty("conceptDown") 
    private Integer liConceptDown;
    
	public Integer getLiIdRelation() {
		return liIdRelation;
	}
	public void setLiIdRelation(Integer liIdRelation) {
		this.liIdRelation = liIdRelation;
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
	public Integer getLiIdUser() {
		return liIdUser;
	}
	public void setLiIdUser(Integer liIdUser) {
		this.liIdUser = liIdUser;
	}
	public Integer getLiOperation() {
		return liOperation;
	}
	public void setLiOperation(Integer liOperation) {
		this.liOperation = liOperation;
	}
	public String getLsCreatedBy() {
		return lsCreatedBy;
	}
	public void setLsCreatedBy(String lsCreatedBy) {
		this.lsCreatedBy = lsCreatedBy;
	}
	public String getLsLastUpdatedBy() {
		return lsLastUpdatedBy;
	}
	public void setLsLastUpdatedBy(String lsLastUpdatedBy) {
		this.lsLastUpdatedBy = lsLastUpdatedBy;
	}
	public Integer getLiConceptUp() {
		return liConceptUp;
	}
	public void setLiConceptUp(Integer liConceptUp) {
		this.liConceptUp = liConceptUp;
	}
	public Integer getLiConceptDown() {
		return liConceptDown;
	}
	public void setLiConceptDown(Integer liConceptDown) {
		this.liConceptDown = liConceptDown;
	}
    
    
    
    
}
