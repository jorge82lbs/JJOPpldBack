package com.sppld.pld.service;

import java.util.List;

import com.sppld.pld.dto.RelConSelectReqDTO;
import com.sppld.pld.dto.RelConSelectResDTO;
import com.sppld.pld.dto.RelMainReq;
import com.sppld.pld.dto.RelMainResponse;
import com.sppld.pld.dto.RelSelectReqDTO;
import com.sppld.pld.dto.RelSelectResponseDTO;
import com.sppld.pld.dto.RelationDTO;
import com.sppld.pld.dto.RelationResponseDTO;
import com.sppld.pld.repository.RelationDao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class RelationImplService implements RelationService {

	@Autowired
	private RelationDao loRelationDao;
	
	
	@Override
	public RelationResponseDTO crudCatalogRelation(RelationDTO loRelation) {
		RelationResponseDTO loService = new RelationResponseDTO();
		try {			
			loService = loRelationDao.crudCatalogRelation(loRelation);
		} catch (Exception e) {
			loService.setLsCodeStatus("ERR");
			loService.setLsCodeDescription(e.getMessage());
		}		
		return loService;
	}

	@Override
	public List<RelSelectResponseDTO> getListRelation(RelSelectReqDTO loRelSelectReqDTO) {
		List<RelSelectResponseDTO> laList = new ArrayList<RelSelectResponseDTO>();
		try {
			laList = loRelationDao.getListRelation(loRelSelectReqDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

	@Override
	public List<RelConSelectResDTO> getListRelationCat(RelConSelectReqDTO loRelConSelectReqDTO) {
		List<RelConSelectResDTO> laList = new ArrayList<RelConSelectResDTO>();
		try {
			laList = loRelationDao.getListRelationCat(loRelConSelectReqDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

	@Override
	public List<RelMainResponse> getListRelationMainCat(RelMainReq loRelMainReq) {
		List<RelMainResponse> laList = new ArrayList<RelMainResponse>();
		try {
			laList = loRelationDao.getListRelationMainCat(loRelMainReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

}
