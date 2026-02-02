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
public class CatSelectReqDTO {
    
    @JsonProperty("idApplication") 
    private Integer liIdApplication;    
    
    @JsonProperty("idCompany") 
    private Integer liIdCompany;
    
    @JsonProperty("idConceptRisk") 
    private Integer liIdConceptRisk;
    
    @JsonProperty("isList") 
    private Integer liIsList;
    
    @JsonProperty("nomConceptRisk") 
    private String lsNomConceptRisk;

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
	public Integer getLiIdConceptRisk() {
		return liIdConceptRisk;
	}
	public void setLiIdConceptRisk(Integer liIdConceptRisk) {
		this.liIdConceptRisk = liIdConceptRisk;
	}
	public Integer getLiIsList() {
		return liIsList;
	}
	public void setLiIsList(Integer liIsList) {
		this.liIsList = liIsList;
	}
	public String getLsNomConceptRisk() {
		return lsNomConceptRisk;
	}
	public void setLsNomConceptRisk(String lsNomConceptRisk) {
		this.lsNomConceptRisk = lsNomConceptRisk;
	}


    

}
