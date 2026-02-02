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
public class QualifyListResDTO {
	
	@JsonProperty("id") 
    private Integer liId;
	
	@JsonProperty("idQualify")
	private Integer liIdQualify;
	
	@JsonProperty("idClient")
	private Integer liIdClient;
	
	@JsonProperty("numQualified")
	private Double liNumQualified;
	
	@JsonProperty("nomConceptDown")
	private String lsNomConceptDown;
	
	@JsonProperty("idRelation")
	private Integer liIdRelation;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;
	
	@JsonProperty("idCompany")
	private Integer liIdCompany;
	
	@JsonProperty("idConceptRel")
	private Integer liIdConceptRel;
	
	@JsonProperty("nomConceptRel")
	private String lsNomConceptRel;
	
	@JsonProperty("idConcept")
	private Integer liIdConcept;
	
	@JsonProperty("nomConcept")
	private String lsNomConcept;
	
	@JsonProperty("indEstatus")
	private String lsIndEstatus;
	
	@JsonProperty("indValue")
	private Double liIndValue;
	
	@JsonProperty("indNivel")
	private Integer liIndNivel;
	
	
	public Integer getLiIdQualify() {
		return liIdQualify;
	}
	public void setLiIdQualify(Integer liIdQualify) {
		this.liIdQualify = liIdQualify;
	}
	public Integer getLiIdClient() {
		return liIdClient;
	}
	public void setLiIdClient(Integer liIdClient) {
		this.liIdClient = liIdClient;
	}
	public Double getLiNumQualified() {
		return liNumQualified;
	}
	public void setLiNumQualified(Double liNumQualified) {
		this.liNumQualified = liNumQualified;
	}
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
	public Integer getLiIdConceptRel() {
		return liIdConceptRel;
	}
	public void setLiIdConceptRel(Integer liIdConceptRel) {
		this.liIdConceptRel = liIdConceptRel;
	}
	public String getLsNomConceptRel() {
		return lsNomConceptRel;
	}
	public void setLsNomConceptRel(String lsNomConceptRel) {
		this.lsNomConceptRel = lsNomConceptRel;
	}
	public Integer getLiIdConcept() {
		return liIdConcept;
	}
	public void setLiIdConcept(Integer liIdConcept) {
		this.liIdConcept = liIdConcept;
	}
	public String getLsNomConcept() {
		return lsNomConcept;
	}
	public void setLsNomConcept(String lsNomConcept) {
		this.lsNomConcept = lsNomConcept;
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
	public Integer getLiId() {
		return liId;
	}
	public void setLiId(Integer liId) {
		this.liId = liId;
	}
	public String getLsIndEstatus() {
		return lsIndEstatus;
	}
	public void setLsIndEstatus(String lsIndEstatus) {
		this.lsIndEstatus = lsIndEstatus;
	}
	public String getLsNomConceptDown() {
		return lsNomConceptDown;
	}
	public void setLsNomConceptDown(String lsNomConceptDown) {
		this.lsNomConceptDown = lsNomConceptDown;
	}

	
	

}
