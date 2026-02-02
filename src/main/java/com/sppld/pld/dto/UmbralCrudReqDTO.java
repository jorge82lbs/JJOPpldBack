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
public class UmbralCrudReqDTO {
	
	@JsonProperty("idUmbral") 
    private Integer liIdUmbral;
	
	@JsonProperty("idApplication") 
    private Integer liIdApplication;    
    
    @JsonProperty("idCompany") 
    private Integer liIdCompany;
    
    @JsonProperty("numInitial") 
    private Double liNumInitial;
    
    @JsonProperty("numFinal") 
    private Double liNumFinal;
    
    @JsonProperty("indProbability") 
    private String lsIndProbability;
    
    @JsonProperty("indImpact") 
    private String lsIndImpact;
    
    @JsonProperty("username") 
    private String lsUsername;
    
    @JsonProperty("operationType") 
    private Integer liOperationType;

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

	public Integer getLiIdUmbral() {
		return liIdUmbral;
	}

	public void setLiIdUmbral(Integer liIdUmbral) {
		this.liIdUmbral = liIdUmbral;
	}

	public Double getLiNumInitial() {
		return liNumInitial;
	}

	public void setLiNumInitial(Double liNumInitial) {
		this.liNumInitial = liNumInitial;
	}

	public Double getLiNumFinal() {
		return liNumFinal;
	}

	public void setLiNumFinal(Double liNumFinal) {
		this.liNumFinal = liNumFinal;
	}

	public String getLsIndProbability() {
		return lsIndProbability;
	}

	public void setLsIndProbability(String lsIndProbability) {
		this.lsIndProbability = lsIndProbability;
	}

	public String getLsIndImpact() {
		return lsIndImpact;
	}

	public void setLsIndImpact(String lsIndImpact) {
		this.lsIndImpact = lsIndImpact;
	}

	public String getLsUsername() {
		return lsUsername;
	}

	public void setLsUsername(String lsUsername) {
		this.lsUsername = lsUsername;
	}

	public Integer getLiOperationType() {
		return liOperationType;
	}

	public void setLiOperationType(Integer liOperationType) {
		this.liOperationType = liOperationType;
	}
	
	
    
}
