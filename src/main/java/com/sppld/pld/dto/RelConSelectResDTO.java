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
public class RelConSelectResDTO {

	@JsonProperty("id") 
    private Integer liId;

    @JsonProperty("idConceptRisk") 
    private Integer liIdConceptRisk;
    
    @JsonProperty("idApplication") 
    private Integer liIdApplication;
    
    @JsonProperty("idCompany") 
    private Integer liIdCompany;
    
    @JsonProperty("nomCatalogRisk") 
    private String lsNomCatalogRisk;
    
    @JsonProperty("indEstatus") 
    private String lsIndEstatus;
    
    @JsonProperty("idConceptRel") 
    private Integer liIdConceptRel;
    

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
    public String getLsNomCatalogRisk() {
        return lsNomCatalogRisk;
    }
    public void setLsNomCatalogRisk(String lsNomCatalogRisk) {
        this.lsNomCatalogRisk = lsNomCatalogRisk;
    }
	public String getLsIndEstatus() {
		return lsIndEstatus;
	}
	public void setLsIndEstatus(String lsIndEstatus) {
		this.lsIndEstatus = lsIndEstatus;
	}
	public Integer getLiIdConceptRel() {
		return liIdConceptRel;
	}
	public void setLiIdConceptRel(Integer liIdConceptRel) {
		this.liIdConceptRel = liIdConceptRel;
	}
    
    

}
