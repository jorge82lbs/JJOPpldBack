package com.sppld.pld.service;

import java.util.List;

import com.sppld.pld.dto.QualifyListMainReqDTO;
import com.sppld.pld.dto.QualifyListMainResDTO;
import com.sppld.pld.dto.QualifyListReqDTO;
import com.sppld.pld.dto.QualifyListResDTO;
import com.sppld.pld.dto.QualifyReqDTO;
import com.sppld.pld.dto.QualifyResDTO;

public interface QualifyForService {
	
	public QualifyResDTO crudQualifyFor(QualifyReqDTO loQualifyReqDTO);
	public List<QualifyListResDTO> getListQualify(QualifyListReqDTO loQualifyListReqDTO);
	public List<QualifyListMainResDTO> getListMainQualify(QualifyListMainReqDTO loQualifyListMainReqDTO);
	
}
