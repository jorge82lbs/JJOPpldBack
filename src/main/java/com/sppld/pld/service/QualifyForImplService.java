package com.sppld.pld.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppld.pld.dto.QualifyListMainReqDTO;
import com.sppld.pld.dto.QualifyListMainResDTO;
import com.sppld.pld.dto.QualifyListReqDTO;
import com.sppld.pld.dto.QualifyListResDTO;
import com.sppld.pld.dto.QualifyReqDTO;
import com.sppld.pld.dto.QualifyResDTO;
import com.sppld.pld.repository.QualifyForDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class QualifyForImplService implements QualifyForService{

	@Autowired
	private QualifyForDao loQualifyForDao; 
	
	@Override
	public QualifyResDTO crudQualifyFor(QualifyReqDTO loQualifyReqDTO) {
		QualifyResDTO loQualifyResDTO = new QualifyResDTO();
		try {			
			loQualifyResDTO = loQualifyForDao.crudQualifyFor(loQualifyReqDTO);
		} catch (Exception e) {
			loQualifyResDTO.setLsCodeStatus("ERR");
			loQualifyResDTO.setLsCodeDescription(e.getMessage());
		}
		return loQualifyResDTO;
	}

	@Override
	public List<QualifyListResDTO> getListQualify(QualifyListReqDTO loQualifyListReqDTO) {
		List<QualifyListResDTO> laList = new ArrayList<QualifyListResDTO>();
		try {
			laList = loQualifyForDao.getListQualify(loQualifyListReqDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

	@Override
	public List<QualifyListMainResDTO> getListMainQualify(QualifyListMainReqDTO loQualifyListMainReqDTO) {
		List<QualifyListMainResDTO> laList = new ArrayList<QualifyListMainResDTO>();
		try {
			laList = loQualifyForDao.getListMainQualify(loQualifyListMainReqDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

}
