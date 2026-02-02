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
public class ClientListResDTO {
	
	@JsonProperty("id") 
    private Integer liId;
	
	@JsonProperty("idClient")
	private Integer liIdClient;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;
	
	@JsonProperty("idCompany")
	private Integer liIdCompany;
	
	@JsonProperty("indRfc")
	private String lsIndRfc;
	
	@JsonProperty("indDescription")
	private String lsIndDescription;
	
	@JsonProperty("indEstatus")
	private String lsIndEstatus;

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

	public String getLsIndRfc() {
		return lsIndRfc;
	}

	public void setLsIndRfc(String lsIndRfc) {
		this.lsIndRfc = lsIndRfc;
	}

	public String getLsIndDescription() {
		return lsIndDescription;
	}

	public void setLsIndDescription(String lsIndDescription) {
		this.lsIndDescription = lsIndDescription;
	}

	public String getLsIndEstatus() {
		return lsIndEstatus;
	}

	public void setLsIndEstatus(String lsIndEstatus) {
		this.lsIndEstatus = lsIndEstatus;
	}

	public Integer getLiId() {
		return liId;
	}

	public void setLiId(Integer liId) {
		this.liId = liId;
	}

	
	
	
}
