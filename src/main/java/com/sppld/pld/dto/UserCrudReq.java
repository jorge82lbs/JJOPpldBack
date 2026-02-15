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
public class UserCrudReq {
	
	
	@JsonProperty("idUser")
	private Integer liIdUser;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;
	
	@JsonProperty("idCompany")
	private Integer liIdCompany;
	
	@JsonProperty("indRfc")
	private String lsIndRfc;
	
	@JsonProperty("indFirstName")
	private String lsIndFirstName;
	
	@JsonProperty("indSecondName")
	private String lsIndSecondName;
	
	@JsonProperty("indName")
	private String lsIndName;
	
	@JsonProperty("indUsername")
	private String lsIndUsername;
	
	@JsonProperty("indDescription")
	private String lsIndDescription;
	
	@JsonProperty("indEmail")
	private String lsIndEmail;
	
	@JsonProperty("indRol")
	private String lsIndRol;
	
	@JsonProperty("indEstatus")
	private String lsIndEstatus;
	
	@JsonProperty("username")
	private String lsUsername;
	
	@JsonProperty("operationType")
	private Integer liOperationType;
	
	
	public Integer getLiIdUser() {
		return liIdUser;
	}
	public void setLiIdUser(Integer liIdUser) {
		this.liIdUser = liIdUser;
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
	public String getLsIndFirstName() {
		return lsIndFirstName;
	}
	public void setLsIndFirstName(String lsIndFirstName) {
		this.lsIndFirstName = lsIndFirstName;
	}
	public String getLsIndSecondName() {
		return lsIndSecondName;
	}
	public void setLsIndSecondName(String lsIndSecondName) {
		this.lsIndSecondName = lsIndSecondName;
	}
	public String getLsIndName() {
		return lsIndName;
	}
	public void setLsIndName(String lsIndName) {
		this.lsIndName = lsIndName;
	}
	public String getLsIndUsername() {
		return lsIndUsername;
	}
	public void setLsIndUsername(String lsIndUsername) {
		this.lsIndUsername = lsIndUsername;
	}
	public String getLsIndDescription() {
		return lsIndDescription;
	}
	public void setLsIndDescription(String lsIndDescription) {
		this.lsIndDescription = lsIndDescription;
	}
	public String getLsIndEmail() {
		return lsIndEmail;
	}
	public void setLsIndEmail(String lsIndEmail) {
		this.lsIndEmail = lsIndEmail;
	}
	public String getLsIndRol() {
		return lsIndRol;
	}
	public void setLsIndRol(String lsIndRol) {
		this.lsIndRol = lsIndRol;
	}
	public String getLsIndEstatus() {
		return lsIndEstatus;
	}
	public void setLsIndEstatus(String lsIndEstatus) {
		this.lsIndEstatus = lsIndEstatus;
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
