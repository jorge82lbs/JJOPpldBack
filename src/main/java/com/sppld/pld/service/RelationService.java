package com.sppld.pld.service;

import com.sppld.pld.dto.RelConSelectReqDTO;
import com.sppld.pld.dto.RelConSelectResDTO;
import com.sppld.pld.dto.RelMainReq;
import com.sppld.pld.dto.RelMainResponse;
import com.sppld.pld.dto.RelSelectReqDTO;
import com.sppld.pld.dto.RelSelectResponseDTO;
import com.sppld.pld.dto.RelationDTO;
import com.sppld.pld.dto.RelationResponseDTO;

import java.util.List;

public interface RelationService {
	public RelationResponseDTO crudCatalogRelation(RelationDTO loRelation);
	public List<RelSelectResponseDTO> getListRelation(RelSelectReqDTO loRelSelectReqDTO);
	public List<RelConSelectResDTO> getListRelationCat(RelConSelectReqDTO loRelConSelectReqDTO);
	public List<RelMainResponse> getListRelationMainCat(RelMainReq loRelMainReq);
}
