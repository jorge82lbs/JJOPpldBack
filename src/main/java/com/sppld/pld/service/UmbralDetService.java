package com.sppld.pld.service;

import java.util.List;

import com.sppld.pld.dto.UmDetSelectReqDTO;
import com.sppld.pld.dto.UmDetSelectResDTO;
import com.sppld.pld.dto.UmbralDetDTO;
import com.sppld.pld.dto.UmbralDetResponseDTO;

public interface UmbralDetService {
	public UmbralDetResponseDTO crudUmbralDet(UmbralDetDTO loUmbralDetDTO);
	public List<UmDetSelectResDTO> getListUmbralDet(UmDetSelectReqDTO loUmDetSelectReqDTO);
}
