package com.sppld.pld.repository;

import java.util.List;

import com.sppld.pld.dto.UmbralCrudResDTO;
import com.sppld.pld.dto.UmbralCrudReqDTO;
import com.sppld.pld.dto.UmbralListResDTO;
import com.sppld.pld.dto.UmbralListReqDTO;

public interface UmbralDao {
	public UmbralCrudResDTO crudUmbral(UmbralCrudReqDTO loUmbralCrudReqDTO) throws Exception;
    public List<UmbralListResDTO> getListUmbral(UmbralListReqDTO loUmbralListReqDTO) throws Exception;
}
