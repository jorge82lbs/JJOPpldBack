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
public class UmbralListResDTO {

	@JsonProperty("id") 
    private Integer liId;
	
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
	
	@JsonProperty("indProbabilty")
	private String lsIndProbabilty;
	
	@JsonProperty("indImpact")
	private String lsIndImpact;
	
	@JsonProperty("indEstatus")
	private String lsIndEstatus;

	@JsonProperty("indColor")
	private String lsIndColor;

	public Integer getLiIdUmbral() {
		return liIdUmbral;
	}


	public void setLiIdUmbral(Integer liIdUmbral) {
		this.liIdUmbral = liIdUmbral;
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


	public Double getLiNumInitial() {
		return liNumInitial;
	}


	public void setLiNumInitial(Double liNumInitial) {
		this.liNumInitial = liNumInitial;
	}


	public String getLsIndProbabilty() {
		return lsIndProbabilty;
	}


	public void setLsIndProbabilty(String lsIndProbabilty) {
		this.lsIndProbabilty = lsIndProbabilty;
	}


	public String getLsIndImpact() {
		return lsIndImpact;
	}


	public void setLsIndImpact(String lsIndImpact) {
		this.lsIndImpact = lsIndImpact;
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


	public Double getLiNumFinal() {
		return liNumFinal;
	}


	public void setLiNumFinal(Double liNumFinal) {
		this.liNumFinal = liNumFinal;
	}


	public String getLsIndColor() {
		return lsIndColor;
	}


	public void setLsIndColor(String lsIndColor) {
		this.lsIndColor = lsIndColor;
	}
	
	
	
}
