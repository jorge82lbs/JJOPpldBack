package com.sppld.pld.service;

import org.springframework.stereotype.Service;

import com.sppld.pld.dto.UmDetSelectReqDTO;
import com.sppld.pld.dto.UmDetSelectResDTO;
import com.sppld.pld.dto.UmbralDetDTO;
import com.sppld.pld.dto.UmbralDetResponseDTO;
import com.sppld.pld.repository.UmbralDetDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
public class UmbralDetImplService implements UmbralDetService {
	
	@Autowired
	private UmbralDetDao loUmbralDetDao;
	
	@Override
	public UmbralDetResponseDTO crudUmbralDet(UmbralDetDTO loUmbralDetDTO) {
		UmbralDetResponseDTO loService = new UmbralDetResponseDTO();
		try {			
			loService = loUmbralDetDao.crudUmbralDet(loUmbralDetDTO);
		} catch (Exception e) {
			loService.setLsCodeStatus("ERR");
			loService.setLsCodeDescription(e.getMessage());
		}
		return loService;
	}

	@Override
	public List<UmDetSelectResDTO> getListUmbralDet(UmDetSelectReqDTO loUmDetSelectReqDTO) {
		List<UmDetSelectResDTO> laList = new ArrayList<UmDetSelectResDTO>();
		try {
			laList = loUmbralDetDao.getListUmbralDet(loUmDetSelectReqDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

}
