package com.sppld.pld.repository;

import com.sppld.pld.dto.CompanyCrudRes;

import java.util.List;

import com.sppld.pld.dto.CompanyCrudReq;
import com.sppld.pld.dto.CompanyListRes;
import com.sppld.pld.dto.CompanyListReq;


public interface CompanyDao {
	
	public CompanyCrudRes crudCompany(CompanyCrudReq loCompanyCrudReq) throws Exception;
	
	public List<CompanyListRes> getListCompanies(CompanyListReq loCompanyListReq) throws Exception;

}
