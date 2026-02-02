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
public class QualifyListMainResDTO {
	
	@JsonProperty("id") 
    private Integer liId;
	
	@JsonProperty("idConceptRisk")
	private Integer liIdConceptRisk;
	
	@JsonProperty("nomCatalogRisk")
	private String lsNomCatalogRisk;
	
	@JsonProperty("maxRisk")
	private Double liMaxRisk;
	
	@JsonProperty("factorx")
	private Double liFactorx;
	
	@JsonProperty("sumRisk")
	private Double liSumRisk;
	
	@JsonProperty("catCalif")
	private Double liCatCalif;
	
	@JsonProperty("indNivel")
	private Integer liIndNivel;
	
	@JsonProperty("idRelation")
	private Integer liIdRelation;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;
	
	@JsonProperty("idCompany")
	private Integer liIdCompany;
	
	@JsonProperty("idConceptRel")
	private Integer liIdConceptRel;
	
	@JsonProperty("idConcept")
	private Integer liIdConcept;
	
	@JsonProperty("indEstatus")
	private String lsIndEstatus;
	
	@JsonProperty("indValue")
	private Double liIndValue;

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

	public String getLsNomCatalogRisk() {
		return lsNomCatalogRisk;
	}

	public void setLsNomCatalogRisk(String lsNomCatalogRisk) {
		this.lsNomCatalogRisk = lsNomCatalogRisk;
	}

	public Double getLiMaxRisk() {
		return liMaxRisk;
	}

	public void setLiMaxRisk(Double liMaxRisk) {
		this.liMaxRisk = liMaxRisk;
	}

	public Double getLiFactorx() {
		return liFactorx;
	}

	public void setLiFactorx(Double liFactorx) {
		this.liFactorx = liFactorx;
	}

	public Double getLiSumRisk() {
		return liSumRisk;
	}

	public void setLiSumRisk(Double liSumRisk) {
		this.liSumRisk = liSumRisk;
	}

	public Double getLiCatCalif() {
		return liCatCalif;
	}

	public void setLiCatCalif(Double liCatCalif) {
		this.liCatCalif = liCatCalif;
	}

	public Integer getLiIndNivel() {
		return liIndNivel;
	}

	public void setLiIndNivel(Integer liIndNivel) {
		this.liIndNivel = liIndNivel;
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

	
	

}
