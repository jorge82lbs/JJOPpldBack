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
public class RelMainReq {
	
	@JsonProperty("idApplication") 
    private Integer liIdApplication;    
    
    @JsonProperty("idCompany") 
    private Integer liIdCompany;
    
    @JsonProperty("idConceptRel") 
    private Integer liIdConceptRel;
    
    @JsonProperty("typeOperation") 
    private Integer liTypeOperation;
    
    @JsonProperty("indNivel") 
    private Integer liIndNivel;
    
    @JsonProperty("attribute1") 
    private String lsAttribute1;

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

	public Integer getLiIdConceptRel() {
		return liIdConceptRel;
	}

	public void setLiIdConceptRel(Integer liIdConceptRel) {
		this.liIdConceptRel = liIdConceptRel;
	}

	public Integer getLiTypeOperation() {
		return liTypeOperation;
	}

	public void setLiTypeOperation(Integer liTypeOperation) {
		this.liTypeOperation = liTypeOperation;
	}

	public Integer getLiIndNivel() {
		return liIndNivel;
	}

	public void setLiIndNivel(Integer liIndNivel) {
		this.liIndNivel = liIndNivel;
	}

	public String getLsAttribute1() {
		return lsAttribute1;
	}

	public void setLsAttribute1(String lsAttribute1) {
		this.lsAttribute1 = lsAttribute1;
	}
	
	

}
