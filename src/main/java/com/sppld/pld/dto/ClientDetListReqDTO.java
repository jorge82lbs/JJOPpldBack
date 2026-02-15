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
public class ClientDetListReqDTO {
	
	@JsonProperty("idClient")
	private Integer liIdClient;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;
	
	@JsonProperty("idCompany")
	private Integer liIdCompany;
	
	@JsonProperty("operationType")
	private Integer liOperationType;

	
	
	public Integer getLiOperationType() {
		return liOperationType;
	}

	public void setLiOperationType(Integer liOperationType) {
		this.liOperationType = liOperationType;
	}

	public Integer getLiIdClient() {
		return liIdClient;
	}

	public void setLiIdClient(Integer liIdClient) {
		this.liIdClient = liIdClient;
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
	

}
