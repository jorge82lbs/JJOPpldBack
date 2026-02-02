package com.sppld.pld.repository;

import java.util.List;

import com.sppld.pld.dto.UmDetSelectReqDTO;
import com.sppld.pld.dto.UmDetSelectResDTO;
import com.sppld.pld.dto.UmbralDetDTO;
import com.sppld.pld.dto.UmbralDetResponseDTO;

public interface UmbralDetDao {
	public UmbralDetResponseDTO crudUmbralDet(UmbralDetDTO loUmbralDetDTO) throws Exception;
	public List<UmDetSelectResDTO> getListUmbralDet(UmDetSelectReqDTO loUmDetSelectReqDTO) throws Exception;
}
