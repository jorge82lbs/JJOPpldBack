package com.sppld.pld.service;

import com.sppld.pld.dto.CatSelectReqDTO;
import com.sppld.pld.dto.CatSelectResponseDTO;
import com.sppld.pld.dto.CatalogDTO;
import com.sppld.pld.dto.CatalogResponseDTO;
import com.sppld.pld.dto.ConceptRelReqDTO;
import com.sppld.pld.repository.CatalogDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CatalogImplService implements CatalogService{

    @Autowired
	private CatalogDao loCatalogDao;
	
    @Override
    public CatalogResponseDTO saveCatalog(CatalogDTO loCatalog) {        
        CatalogResponseDTO loCatalogResponseDTO = new CatalogResponseDTO();
        try {			
			loCatalogResponseDTO = loCatalogDao.saveCatalog(loCatalog);
		} catch (Exception e) {
			loCatalogResponseDTO.setLsCodeStatus("ERR");
            loCatalogResponseDTO.setLsCodeDescription(e.getMessage());
		}
        return loCatalogResponseDTO;
    }

    @Override
    public CatalogResponseDTO updateCatalog(CatalogDTO loCatalog) {
        CatalogResponseDTO loCatalogResponseDTO = new CatalogResponseDTO();
        try {			
			loCatalogResponseDTO = loCatalogDao.updateCatalog(loCatalog);
		} catch (Exception e) {
			loCatalogResponseDTO.setLsCodeStatus("ERR");
            loCatalogResponseDTO.setLsCodeDescription(e.getMessage());
		}
        return loCatalogResponseDTO;
    }

    @Override
    public CatalogResponseDTO deleteCatalog(CatalogDTO loCatalog) {
        CatalogResponseDTO loCatalogResponseDTO = new CatalogResponseDTO();
        try {			
			loCatalogResponseDTO = loCatalogDao.deleteCatalog(loCatalog);
		} catch (Exception e) {
			loCatalogResponseDTO.setLsCodeStatus("ERR");
            loCatalogResponseDTO.setLsCodeDescription(e.getMessage());
		}
        return loCatalogResponseDTO;
    }

    @Override
    public List<CatSelectResponseDTO> getListCatalog(CatSelectReqDTO loCatSelectReqDTO) {
        List<CatSelectResponseDTO> laList = new ArrayList<CatSelectResponseDTO>();
		try {
			laList = loCatalogDao.getListCatalog(loCatSelectReqDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
    }

	@Override
	public CatalogResponseDTO crudConceptRel(ConceptRelReqDTO loConceptRelReqDTO) {
		CatalogResponseDTO loCatalogResponseDTO = new CatalogResponseDTO();
        try {			
			loCatalogResponseDTO = loCatalogDao.crudConceptRel(loConceptRelReqDTO);
		} catch (Exception e) {
			loCatalogResponseDTO.setLsCodeStatus("ERR");
            loCatalogResponseDTO.setLsCodeDescription(e.getMessage());
		}
        return loCatalogResponseDTO;
	}
    
}
