package com.sppld.pld.repository;

import java.util.List;

import com.sppld.pld.dto.RelSelectReqDTO;
import com.sppld.pld.dto.RelSelectResponseDTO;
import com.sppld.pld.dto.RelationDTO;
import com.sppld.pld.dto.RelationResponseDTO;
import com.sppld.pld.dto.RelConSelectReqDTO;
import com.sppld.pld.dto.RelConSelectResDTO;
import com.sppld.pld.dto.RelMainReq;
import com.sppld.pld.dto.RelMainResponse;


public interface RelationDao {
	public RelationResponseDTO crudCatalogRelation(RelationDTO loRelation) throws Exception;
	public List<RelSelectResponseDTO> getListRelation(RelSelectReqDTO loRelSelectReqDTO) throws Exception;
	public List<RelConSelectResDTO> getListRelationCat(RelConSelectReqDTO loRelConSelectReqDTO) throws Exception;
	public List<RelMainResponse> getListRelationMainCat(RelMainReq loRelMainReq) throws Exception;
	
}
