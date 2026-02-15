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
public class CompanyListReq {
	
	@JsonProperty("idCompany")
	private Integer liIdCompany;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;
	
	@JsonProperty("operationType") 
    private Integer liOperationType;

	public Integer getLiIdCompany() {
		return liIdCompany;
	}

	public void setLiIdCompany(Integer liIdCompany) {
		this.liIdCompany = liIdCompany;
	}

	public Integer getLiIdApplication() {
		return liIdApplication;
	}

	public void setLiIdApplication(Integer liIdApplication) {
		this.liIdApplication = liIdApplication;
	}

	public Integer getLiOperationType() {
		return liOperationType;
	}

	public void setLiOperationType(Integer liOperationType) {
		this.liOperationType = liOperationType;
	}
	
	

}
