package com.sppld.pld.service;

import java.util.List;

import com.sppld.pld.dto.CompanyCrudReq;
import com.sppld.pld.dto.CompanyCrudRes;
import com.sppld.pld.dto.CompanyListReq;
import com.sppld.pld.dto.CompanyListRes;

public interface CompanyService {
	
	public CompanyCrudRes crudCompany(CompanyCrudReq loCompanyCrudReq);
	
	public List<CompanyListRes> getListCompanies(CompanyListReq loCompanyListReq);
	
}
