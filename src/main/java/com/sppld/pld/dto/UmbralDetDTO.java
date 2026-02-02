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
public class UmbralDetDTO {
	
	@JsonProperty("umbralDet")
	private Integer liIdUmbralDet;
	
	@JsonProperty("idRelation")
	private Integer liIdRelation;
	
	@JsonProperty("idTypeRule")
	private String lsIdTypeRule;
	
	@JsonProperty("initialRange")
	private Integer liNumInitialRange;
	
	@JsonProperty("finalRange")
	private Integer liNumFinalRange;
	
	@JsonProperty("groupRange")
	private String lsIndGroupRange;
	
	@JsonProperty("numAmount")
	private Integer liNumAmount;
	
	@JsonProperty("determinant")
	private Integer liNumDeterminant;
	
	@JsonProperty("nomRule")
	private String lsIndNomRule;
	
	@JsonProperty("username")
	private String lsUsername;
	
	@JsonProperty("operation")
	private Integer liOperation;
	
	
	public Integer getLiIdUmbralDet() {
		return liIdUmbralDet;
	}
	public void setLiIdUmbralDet(Integer liIdUmbralDet) {
		this.liIdUmbralDet = liIdUmbralDet;
	}
	public Integer getLiIdRelation() {
		return liIdRelation;
	}
	public void setLiIdRelation(Integer liIdRelation) {
		this.liIdRelation = liIdRelation;
	}
	
	public Integer getLiNumInitialRange() {
		return liNumInitialRange;
	}
	public void setLiNumInitialRange(Integer liNumInitialRange) {
		this.liNumInitialRange = liNumInitialRange;
	}
	public Integer getLiNumFinalRange() {
		return liNumFinalRange;
	}
	public void setLiNumFinalRange(Integer liNumFinalRange) {
		this.liNumFinalRange = liNumFinalRange;
	}
	
	public Integer getLiNumAmount() {
		return liNumAmount;
	}
	public void setLiNumAmount(Integer liNumAmount) {
		this.liNumAmount = liNumAmount;
	}
	public Integer getLiNumDeterminant() {
		return liNumDeterminant;
	}
	public void setLiNumDeterminant(Integer liNumDeterminant) {
		this.liNumDeterminant = liNumDeterminant;
	}
	public String getLsUsername() {
		return lsUsername;
	}
	public void setLsUsername(String lsUsername) {
		this.lsUsername = lsUsername;
	}
	public Integer getLiOperation() {
		return liOperation;
	}
	public void setLiOperation(Integer liOperation) {
		this.liOperation = liOperation;
	}
	public String getLsIdTypeRule() {
		return lsIdTypeRule;
	}
	public void setLsIdTypeRule(String lsIdTypeRule) {
		this.lsIdTypeRule = lsIdTypeRule;
	}
	public String getLsIndGroupRange() {
		return lsIndGroupRange;
	}
	public void setLsIndGroupRange(String lsIndGroupRange) {
		this.lsIndGroupRange = lsIndGroupRange;
	}
	public String getLsIndNomRule() {
		return lsIndNomRule;
	}
	public void setLsIndNomRule(String lsIndNomRule) {
		this.lsIndNomRule = lsIndNomRule;
	}

	

	
	
}
