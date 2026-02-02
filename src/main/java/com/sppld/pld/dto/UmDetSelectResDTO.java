package com.sppld.pld.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UmDetSelectResDTO {
	
	@JsonProperty("id") 
    private Integer liId;
	
	@JsonProperty("idUmbralDet")
	private Integer liIdUmbralDet;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;
	
	@JsonProperty("idCompany")
	private Integer liIdCompany;
	
	@JsonProperty("idConceptRel")
	private Integer liIdConceptRel;
	
	@JsonProperty("idConcept")
	private Integer liIdConcept;
	
	@JsonProperty("nomConceptRel")
	private String lsNomConceptRel;
	
	@JsonProperty("nomConcept")
	private String lsNomConcept;
	
	@JsonProperty("idRelation")
	private Integer liIdRelation;
	
	@JsonProperty("typeRule")
	private String lsTypeRule;
	
	public String getLsTypeRule() {
		return lsTypeRule;
	}
	public void setLsTypeRule(String lsTypeRule) {
		this.lsTypeRule = lsTypeRule;
	}
	@JsonProperty("initialRange")
	private Integer liInitialRange;
	
	@JsonProperty("finalRange")
	private Integer liFinalRange;
	
	@JsonProperty("groupRange")
	private String lsGroupRange;
	
	@JsonProperty("numAmount")
	private Integer liNumAmount;
	
	@JsonProperty("determinant")
	private Integer liDeterminant;
	
	@JsonProperty("nomRule")
	private String lsNomRule;
	
		
	@JsonProperty("indEstatus") 
    private String lsIndEstatus;    
    @JsonProperty("fecCreationDate") 
    private Date ltFecCreationDate;    
    @JsonProperty("fecLastUpdateDate") 
    private Date ltFecLastUpdateDate;
    @JsonProperty("createdBy") 
    private String lsCreatedBy;
    @JsonProperty("lastUpdatedBy") 
    private String lsLastUpdatedBy;
	public Integer getLiId() {
		return liId;
	}
	public void setLiId(Integer liId) {
		this.liId = liId;
	}
	public Integer getLiIdUmbralDet() {
		return liIdUmbralDet;
	}
	public void setLiIdUmbralDet(Integer liIdUmbralDet) {
		this.liIdUmbralDet = liIdUmbralDet;
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
	public Integer getLiIdConceptRel() {
		return liIdConceptRel;
	}
	public void setLiIdConceptRel(Integer liIdConceptRel) {
		this.liIdConceptRel = liIdConceptRel;
	}
	public Integer getLiIdConcept() {
		return liIdConcept;
	}
	public void setLiIdConcept(Integer liIdConcept) {
		this.liIdConcept = liIdConcept;
	}
	public String getLsNomConceptRel() {
		return lsNomConceptRel;
	}
	public void setLsNomConceptRel(String lsNomConceptRel) {
		this.lsNomConceptRel = lsNomConceptRel;
	}
	public String getLsNomConcept() {
		return lsNomConcept;
	}
	public void setLsNomConcept(String lsNomConcept) {
		this.lsNomConcept = lsNomConcept;
	}
	public Integer getLiIdRelation() {
		return liIdRelation;
	}
	public void setLiIdRelation(Integer liIdRelation) {
		this.liIdRelation = liIdRelation;
	}
	
	
	public Integer getLiInitialRange() {
		return liInitialRange;
	}
	public void setLiInitialRange(Integer liInitialRange) {
		this.liInitialRange = liInitialRange;
	}
	public Integer getLiFinalRange() {
		return liFinalRange;
	}
	public void setLiFinalRange(Integer liFinalRange) {
		this.liFinalRange = liFinalRange;
	}
	public String getLsGroupRange() {
		return lsGroupRange;
	}
	public void setLsGroupRange(String lsGroupRange) {
		this.lsGroupRange = lsGroupRange;
	}
	public Integer getLiNumAmount() {
		return liNumAmount;
	}
	public void setLiNumAmount(Integer liNumAmount) {
		this.liNumAmount = liNumAmount;
	}
	public Integer getLiDeterminant() {
		return liDeterminant;
	}
	public void setLiDeterminant(Integer liDeterminant) {
		this.liDeterminant = liDeterminant;
	}
	public String getLsNomRule() {
		return lsNomRule;
	}
	public void setLsNomRule(String lsNomRule) {
		this.lsNomRule = lsNomRule;
	}
	public String getLsIndEstatus() {
		return lsIndEstatus;
	}
	public void setLsIndEstatus(String lsIndEstatus) {
		this.lsIndEstatus = lsIndEstatus;
	}
	public Date getLtFecCreationDate() {
		return ltFecCreationDate;
	}
	public void setLtFecCreationDate(Date ltFecCreationDate) {
		this.ltFecCreationDate = ltFecCreationDate;
	}
	public Date getLtFecLastUpdateDate() {
		return ltFecLastUpdateDate;
	}
	public void setLtFecLastUpdateDate(Date ltFecLastUpdateDate) {
		this.ltFecLastUpdateDate = ltFecLastUpdateDate;
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
    
    
    
    
    
	
}
