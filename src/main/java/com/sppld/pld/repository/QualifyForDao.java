package com.sppld.pld.repository;

import com.sppld.pld.dto.QualifyReqDTO;
import com.sppld.pld.dto.QualifyResDTO;
import com.sppld.pld.dto.QualifyListResDTO;
import com.sppld.pld.dto.QualifyListReqDTO;
import com.sppld.pld.dto.QualifyListMainResDTO;
import com.sppld.pld.dto.QualifyListMainReqDTO;

import java.util.List;



public interface QualifyForDao {
	
	public QualifyResDTO crudQualifyFor(QualifyReqDTO loQualifyReqDTO) throws Exception;
	public List<QualifyListResDTO> getListQualify(QualifyListReqDTO loQualifyListReqDTO) throws Exception;
	
	public List<QualifyListMainResDTO> getListMainQualify(QualifyListMainReqDTO loQualifyListMainReqDTO) throws Exception;
	
}
  