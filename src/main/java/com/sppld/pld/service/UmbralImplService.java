package com.sppld.pld.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppld.pld.dto.UmbralCrudReqDTO;
import com.sppld.pld.dto.UmbralCrudResDTO;
import com.sppld.pld.dto.UmbralListReqDTO;
import com.sppld.pld.dto.UmbralListResDTO;
import com.sppld.pld.repository.UmbralDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UmbralImplService implements UmbralService {

	@Autowired
	private UmbralDao loUmbralDao;
	
	@Override
	public UmbralCrudResDTO crudUmbral(UmbralCrudReqDTO loUmbralCrudReqDTO) {
		UmbralCrudResDTO loService = new UmbralCrudResDTO();
		try {			
			loService = loUmbralDao.crudUmbral(loUmbralCrudReqDTO);
		} catch (Exception e) {
			loService.setLsCodeStatus("ERR");
			loService.setLsCodeDescription(e.getMessage());
		}
		return loService;
	}

	@Override
	public List<UmbralListResDTO> getListUmbral(UmbralListReqDTO loUmbralListReqDTO) {
		List<UmbralListResDTO> laList = new ArrayList<UmbralListResDTO>();
		try {
			laList = loUmbralDao.getListUmbral(loUmbralListReqDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

}
