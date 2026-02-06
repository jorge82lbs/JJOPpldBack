package com.sppld.pld.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientReqDTO {
	
	@JsonProperty("idClient")
	private Integer liIdClient;
	
	@JsonProperty("idApplication")
	private Integer liIdApplication;

	@JsonProperty("idCompany")
	private Integer liIdCompany;

	@JsonProperty("idConcept")
	private Integer liIdConcept;

	@JsonProperty("fecDocumentDate")
	private Date ltFecDocumentDate;

	@JsonProperty("indFirstName")
	private String lsIndFirstName;

	@JsonProperty("indSecondName")
	private String lsIndSecondName;

	@JsonProperty("indNames")
	private String lsIndNames;

	@JsonProperty("indNationality")
	private String lsIndNationality;

	@JsonProperty("indCountryBirth")
	private String lsIndCountryBirth;

	@JsonProperty("fecBirthDate")
	private Date ltFecBirthDate;

	@JsonProperty("indEconomicAct")
	private String lsIndEconomicAct;

	@JsonProperty("indRfc")
	private String lsIndRfc;

	@JsonProperty("indAddressStreet")
	private String lsIndAddressStreet;

	@JsonProperty("indAddressNum")
	private String lsIndAddressNum;

	@JsonProperty("indAddressSuburb")
	private String lsIndAddressSuburb;

	@JsonProperty("indAddressCp")
	private String lsIndAddressCp;

	@JsonProperty("indAddressCity")
	private String lsIndAddressCity;

	@JsonProperty("indAddressTown")
	private String lsIndAddressTown;

	@JsonProperty("indAddressState")
	private String lsIndAddressState;

	@JsonProperty("indPhoneNumber")
	private String lsIndPhoneNumber;

	@JsonProperty("indPhoneExt")
	private String lsIndPhoneExt;

	@JsonProperty("indPhoneSmart")
	private String lsIndPhoneSmart;

	@JsonProperty("indCountry")
	private String lsIndCountry;

	@JsonProperty("indCurp")
	private String lsIndCurp;

	@JsonProperty("indEmail")
	private String lsIndEmail;

	@JsonProperty("indIdOficial")
	private String lsIndIdOficial;

	@JsonProperty("indIdName")
	private String lsIndIdName;

	@JsonProperty("indIdAuthority")
	private String lsIndIdAuthority;

	@JsonProperty("indForeign")
	private String lsIndForeign;

	@JsonProperty("indFstreet")
	private String lsIndFstreet;

	@JsonProperty("indFnumber")
	private String lsIndFnumber;

	@JsonProperty("indFsuburb")
	private String lsIndFsuburb;

	@JsonProperty("indFcity")
	private String lsIndFcity;

	@JsonProperty("indFstate")
	private String lsIndFstate;

	@JsonProperty("indFcp")
	private String lsIndFcp;

	@JsonProperty("indFcountry")
	private String lsIndFcountry;

	@JsonProperty("indBcontroller")
	private String lsIndBcontroller;

	@JsonProperty("indBcDoc")
	private String lsIndBcDoc;

	
	@JsonProperty("operationType") 
    private Integer liOperationType;
    
    @JsonProperty("createdBy") 
    private String lsCreatedBy;
    
    @JsonProperty("indEstatus") 
    private String lsIndEstatus;
    
    @JsonProperty("username") 
    private String lsUserName;
    
    

	public String getLsUserName() {
		return lsUserName;
	}

	public void setLsUserName(String lsUserName) {
		this.lsUserName = lsUserName;
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

	public Integer getLiIdConcept() {
		return liIdConcept;
	}

	public void setLiIdConcept(Integer liIdConcept) {
		this.liIdConcept = liIdConcept;
	}

	public Date getLtFecDocumentDate() {
		return ltFecDocumentDate;
	}

	public void setLtFecDocumentDate(Date ltFecDocumentDate) {
		this.ltFecDocumentDate = ltFecDocumentDate;
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

	public String getLsIndNames() {
		return lsIndNames;
	}

	public void setLsIndNames(String lsIndNames) {
		this.lsIndNames = lsIndNames;
	}

	public String getLsIndNationality() {
		return lsIndNationality;
	}

	public void setLsIndNationality(String lsIndNationality) {
		this.lsIndNationality = lsIndNationality;
	}

	public String getLsIndCountryBirth() {
		return lsIndCountryBirth;
	}

	public void setLsIndCountryBirth(String lsIndCountryBirth) {
		this.lsIndCountryBirth = lsIndCountryBirth;
	}

	public Date getLtFecBirthDate() {
		return ltFecBirthDate;
	}

	public void setLtFecBirthDate(Date ltFecBirthDate) {
		this.ltFecBirthDate = ltFecBirthDate;
	}

	public String getLsIndEconomicAct() {
		return lsIndEconomicAct;
	}

	public void setLsIndEconomicAct(String lsIndEconomicAct) {
		this.lsIndEconomicAct = lsIndEconomicAct;
	}

	public String getLsIndRfc() {
		return lsIndRfc;
	}

	public void setLsIndRfc(String lsIndRfc) {
		this.lsIndRfc = lsIndRfc;
	}

	public String getLsIndAddressStreet() {
		return lsIndAddressStreet;
	}

	public void setLsIndAddressStreet(String lsIndAddressStreet) {
		this.lsIndAddressStreet = lsIndAddressStreet;
	}

	public String getLsIndAddressNum() {
		return lsIndAddressNum;
	}

	public void setLsIndAddressNum(String lsIndAddressNum) {
		this.lsIndAddressNum = lsIndAddressNum;
	}

	public String getLsIndAddressSuburb() {
		return lsIndAddressSuburb;
	}

	public void setLsIndAddressSuburb(String lsIndAddressSuburb) {
		this.lsIndAddressSuburb = lsIndAddressSuburb;
	}

	public String getLsIndAddressCp() {
		return lsIndAddressCp;
	}

	public void setLsIndAddressCp(String lsIndAddressCp) {
		this.lsIndAddressCp = lsIndAddressCp;
	}

	public String getLsIndAddressCity() {
		return lsIndAddressCity;
	}

	public void setLsIndAddressCity(String lsIndAddressCity) {
		this.lsIndAddressCity = lsIndAddressCity;
	}

	public String getLsIndAddressTown() {
		return lsIndAddressTown;
	}

	public void setLsIndAddressTown(String lsIndAddressTown) {
		this.lsIndAddressTown = lsIndAddressTown;
	}

	public String getLsIndAddressState() {
		return lsIndAddressState;
	}

	public void setLsIndAddressState(String lsIndAddressState) {
		this.lsIndAddressState = lsIndAddressState;
	}

	public String getLsIndPhoneNumber() {
		return lsIndPhoneNumber;
	}

	public void setLsIndPhoneNumber(String lsIndPhoneNumber) {
		this.lsIndPhoneNumber = lsIndPhoneNumber;
	}

	public String getLsIndPhoneExt() {
		return lsIndPhoneExt;
	}

	public void setLsIndPhoneExt(String lsIndPhoneExt) {
		this.lsIndPhoneExt = lsIndPhoneExt;
	}

	public String getLsIndPhoneSmart() {
		return lsIndPhoneSmart;
	}

	public void setLsIndPhoneSmart(String lsIndPhoneSmart) {
		this.lsIndPhoneSmart = lsIndPhoneSmart;
	}

	public String getLsIndCountry() {
		return lsIndCountry;
	}

	public void setLsIndCountry(String lsIndCountry) {
		this.lsIndCountry = lsIndCountry;
	}

	public String getLsIndCurp() {
		return lsIndCurp;
	}

	public void setLsIndCurp(String lsIndCurp) {
		this.lsIndCurp = lsIndCurp;
	}

	public String getLsIndEmail() {
		return lsIndEmail;
	}

	public void setLsIndEmail(String lsIndEmail) {
		this.lsIndEmail = lsIndEmail;
	}

	public String getLsIndIdOficial() {
		return lsIndIdOficial;
	}

	public void setLsIndIdOficial(String lsIndIdOficial) {
		this.lsIndIdOficial = lsIndIdOficial;
	}

	public String getLsIndIdName() {
		return lsIndIdName;
	}

	public void setLsIndIdName(String lsIndIdName) {
		this.lsIndIdName = lsIndIdName;
	}

	public String getLsIndIdAuthority() {
		return lsIndIdAuthority;
	}

	public void setLsIndIdAuthority(String lsIndIdAuthority) {
		this.lsIndIdAuthority = lsIndIdAuthority;
	}

	public String getLsIndForeign() {
		return lsIndForeign;
	}

	public void setLsIndForeign(String lsIndForeign) {
		this.lsIndForeign = lsIndForeign;
	}

	public String getLsIndFstreet() {
		return lsIndFstreet;
	}

	public void setLsIndFstreet(String lsIndFstreet) {
		this.lsIndFstreet = lsIndFstreet;
	}

	public String getLsIndFnumber() {
		return lsIndFnumber;
	}

	public void setLsIndFnumber(String lsIndFnumber) {
		this.lsIndFnumber = lsIndFnumber;
	}

	public String getLsIndFsuburb() {
		return lsIndFsuburb;
	}

	public void setLsIndFsuburb(String lsIndFsuburb) {
		this.lsIndFsuburb = lsIndFsuburb;
	}

	public String getLsIndFcity() {
		return lsIndFcity;
	}

	public void setLsIndFcity(String lsIndFcity) {
		this.lsIndFcity = lsIndFcity;
	}

	public String getLsIndFstate() {
		return lsIndFstate;
	}

	public void setLsIndFstate(String lsIndFstate) {
		this.lsIndFstate = lsIndFstate;
	}

	public String getLsIndFcp() {
		return lsIndFcp;
	}

	public void setLsIndFcp(String lsIndFcp) {
		this.lsIndFcp = lsIndFcp;
	}

	public String getLsIndFcountry() {
		return lsIndFcountry;
	}

	public void setLsIndFcountry(String lsIndFcountry) {
		this.lsIndFcountry = lsIndFcountry;
	}

	public String getLsIndBcontroller() {
		return lsIndBcontroller;
	}

	public void setLsIndBcontroller(String lsIndBcontroller) {
		this.lsIndBcontroller = lsIndBcontroller;
	}

	public String getLsIndBcDoc() {
		return lsIndBcDoc;
	}

	public void setLsIndBcDoc(String lsIndBcDoc) {
		this.lsIndBcDoc = lsIndBcDoc;
	}

	public Integer getLiOperationType() {
		return liOperationType;
	}

	public void setLiOperationType(Integer liOperationType) {
		this.liOperationType = liOperationType;
	}

	public String getLsCreatedBy() {
		return lsCreatedBy;
	}

	public void setLsCreatedBy(String lsCreatedBy) {
		this.lsCreatedBy = lsCreatedBy;
	}

	public Integer getLiIdClient() {
		return liIdClient;
	}

	public void setLiIdClient(Integer liIdClient) {
		this.liIdClient = liIdClient;
	}

	public String getLsIndEstatus() {
		return lsIndEstatus;
	}

	public void setLsIndEstatus(String lsIndEstatus) {
		this.lsIndEstatus = lsIndEstatus;
	}
            

}
