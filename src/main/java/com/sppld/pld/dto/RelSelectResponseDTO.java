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
public class RelSelectResponseDTO {
	@JsonProperty("id") 
    private Integer liId;
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
	public Integer getLiIdRelation() {
		return liIdRelation;
	}
	public void setLiIdRelation(Integer liIdRelation) {
		this.liIdRelation = liIdRelation;
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
	
	
	
	
}
