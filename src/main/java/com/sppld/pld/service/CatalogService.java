package com.sppld.pld.service;

import java.util.List;

import com.sppld.pld.dto.CatSelectReqDTO;
import com.sppld.pld.dto.CatSelectResponseDTO;
import com.sppld.pld.dto.CatalogDTO;
import com.sppld.pld.dto.CatalogResponseDTO;
import com.sppld.pld.dto.ConceptRelReqDTO;

public interface CatalogService {
    public CatalogResponseDTO saveCatalog(CatalogDTO loCatalog);
    public CatalogResponseDTO updateCatalog(CatalogDTO loCatalog);
    public CatalogResponseDTO deleteCatalog(CatalogDTO loCatalog);
    public List<CatSelectResponseDTO> getListCatalog(CatSelectReqDTO loCatSelectReqDTO);
    public CatalogResponseDTO crudConceptRel(ConceptRelReqDTO loConceptRelReqDTO);
}
