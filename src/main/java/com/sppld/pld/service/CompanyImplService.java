package com.sppld.pld.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppld.pld.dto.CompanyCrudReq;
import com.sppld.pld.dto.CompanyCrudRes;
import com.sppld.pld.dto.CompanyListReq;
import com.sppld.pld.dto.CompanyListRes;
import com.sppld.pld.dto.UmbralListResDTO;
import com.sppld.pld.repository.CompanyDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CompanyImplService implements CompanyService {

	@Autowired
	private CompanyDao loCompanyDao;
	
	@Override
	public CompanyCrudRes crudCompany(CompanyCrudReq loCompanyCrudReq) {
		CompanyCrudRes loService = new CompanyCrudRes();
		try {			
			loService = loCompanyDao.crudCompany(loCompanyCrudReq);
		} catch (Exception e) {
			loService.setLsCodeStatus("ERR");
			loService.setLsCodeDescription(e.getMessage());
		}
		return loService;
	}

	@Override
	public List<CompanyListRes> getListCompanies(CompanyListReq loCompanyListReq) {
		List<CompanyListRes> laList = new ArrayList<CompanyListRes>();
		try {
			laList = loCompanyDao.getListCompanies(loCompanyListReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

}
