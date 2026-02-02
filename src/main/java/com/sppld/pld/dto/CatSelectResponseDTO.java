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
public class CatSelectResponseDTO {
    
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
    
    @JsonProperty("fecCreationDate") 
    private Date ltFecCreationDate;
    
    @JsonProperty("fecLastUpdateDate") 
    private Date ltFecLastUpdateDate;
    
    @JsonProperty("numCreatedBy") 
    private Integer liNumCreatedBy;
    
    @JsonProperty("numLastUpdatedBy") 
    private Integer liNumLastUpdatedBy;
    
    
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
    public Integer getLiNumCreatedBy() {
        return liNumCreatedBy;
    }
    public void setLiNumCreatedBy(Integer liNumCreatedBy) {
        this.liNumCreatedBy = liNumCreatedBy;
    }
    public Integer getLiNumLastUpdatedBy() {
        return liNumLastUpdatedBy;
    }
    public void setLiNumLastUpdatedBy(Integer liNumLastUpdatedBy) {
        this.liNumLastUpdatedBy = liNumLastUpdatedBy;
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
