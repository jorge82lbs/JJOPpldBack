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
public class CatalogDTO {
    @JsonProperty("idCatalog") 
    private Integer liIdCatalog;
    @JsonProperty("idApplication") 
    private Integer liIdApplication;
    @JsonProperty("idCompany") 
    private Integer liIdCompany;
    @JsonProperty("idUser") 
    private Integer liIdUser;
    @JsonProperty("nomCatalog") 
	private String lsNomCatalog;
    @JsonProperty("operation") 
    private Integer liOperation;
    
    @JsonProperty("createdBy") 
    private String lsCreatedBy;
    @JsonProperty("lastUpdatedBy") 
    private String lsLastUpdatedBy;

    
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
    public String getLsNomCatalog() {
        return lsNomCatalog;
    }
    public void setLsNomCatalog(String lsNomCatalog) {
        this.lsNomCatalog = lsNomCatalog;
    }

    public Integer getLiIdCatalog() {
        return liIdCatalog;
    }

    public void setLiIdCatalog(Integer liIdCatalog) {
        this.liIdCatalog = liIdCatalog;
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

    

}
