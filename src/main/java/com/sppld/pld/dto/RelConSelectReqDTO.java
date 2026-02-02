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
public class RelConSelectReqDTO {
	@JsonProperty("idApplication") 
    private Integer liIdApplication;    
    
    @JsonProperty("idCompany") 
    private Integer liIdCompany;
    
    @JsonProperty("idConceptRel") 
    private Integer liIdConceptRel;

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

}
