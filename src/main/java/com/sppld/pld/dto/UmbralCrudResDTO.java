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
public class UmbralCrudResDTO {
	@JsonProperty("codeStatus") 
    private String lsCodeStatus;
    @JsonProperty("codeDescription")     
    private String lsCodeDescription;
    
	public String getLsCodeStatus() {
		return lsCodeStatus;
	}
	public void setLsCodeStatus(String lsCodeStatus) {
		this.lsCodeStatus = lsCodeStatus;
	}
	public String getLsCodeDescription() {
		return lsCodeDescription;
	}
	public void setLsCodeDescription(String lsCodeDescription) {
		this.lsCodeDescription = lsCodeDescription;
	}
}
