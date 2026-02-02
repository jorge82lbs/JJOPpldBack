package com.sppld.pld.service;

import java.util.List;

import com.sppld.pld.dto.UmbralCrudReqDTO;
import com.sppld.pld.dto.UmbralCrudResDTO;
import com.sppld.pld.dto.UmbralListReqDTO;
import com.sppld.pld.dto.UmbralListResDTO;

public interface UmbralService {
	public UmbralCrudResDTO crudUmbral(UmbralCrudReqDTO loUmbralCrudReqDTO);
    public List<UmbralListResDTO> getListUmbral(UmbralListReqDTO loUmbralListReqDTO);
}
