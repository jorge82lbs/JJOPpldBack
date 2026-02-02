package com.sppld.pld.repository;

import com.sppld.pld.dto.CatSelectReqDTO;
import com.sppld.pld.dto.CatSelectResponseDTO;
import com.sppld.pld.dto.CatalogDTO;
import com.sppld.pld.dto.CatalogResponseDTO;
import com.sppld.pld.dto.ConceptRelReqDTO;

import java.util.List;

public interface CatalogDao {
    
    public CatalogResponseDTO saveCatalog(CatalogDTO loCatalog) throws Exception;
    public CatalogResponseDTO updateCatalog(CatalogDTO loCatalog) throws Exception;
    public CatalogResponseDTO deleteCatalog(CatalogDTO loCatalog) throws Exception;
    public List<CatSelectResponseDTO> getListCatalog(CatSelectReqDTO loCatSelectReqDTO) throws Exception;
    public CatalogResponseDTO crudConceptRel(ConceptRelReqDTO loConceptRelReqDTO) throws Exception;
}
