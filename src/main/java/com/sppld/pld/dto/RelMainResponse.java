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
public class RelMainResponse {
	
	@JsonProperty("id") 
    private Integer liId;
	
	@JsonProperty("idConceptRisk") 
    private Integer liIdConceptRisk;
	
	@JsonProperty("idRelation") 
    private Integer liIdRelation;
	
	@JsonProperty("nomCatalogRisk") 
    private String lsNomCatalogRisk;
    
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
	
    @JsonProperty("indEstatus") 
    private String lsIndEstatus;
    
    @JsonProperty("indValue") 
    private Double liIndValue;
    
    @JsonProperty("indNivel") 
    private Integer liIndNivel;
	

	public Integer getLiId() {
		return liId;
	}

	public void setLiId(Integer liId) {
		this.liId = liId;
	}

	public Integer getLiIdConceptRisk() {
		return liIdConceptRisk;
	}

	public void setLiIdConceptRisk(Integer liIdConceptRisk) {
		this.liIdConceptRisk = liIdConceptRisk;
	}

	public Integer getLiIdRelation() {
		return liIdRelation;
	}

	public void setLiIdRelation(Integer liIdRelation) {
		this.liIdRelation = liIdRelation;
	}

	public String getLsNomCatalogRisk() {
		return lsNomCatalogRisk;
	}

	public void setLsNomCatalogRisk(String lsNomCatalogRisk) {
		this.lsNomCatalogRisk = lsNomCatalogRisk;
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

	public String getLsIndEstatus() {
		return lsIndEstatus;
	}

	public void setLsIndEstatus(String lsIndEstatus) {
		this.lsIndEstatus = lsIndEstatus;
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
	
	
    
}
