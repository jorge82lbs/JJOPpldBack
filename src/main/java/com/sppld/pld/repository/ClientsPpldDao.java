package com.sppld.pld.repository;

import java.util.List;

import com.sppld.pld.dto.ClientListReqDTO;
import com.sppld.pld.dto.ClientListResDTO;
import com.sppld.pld.dto.ClientReqDTO;
import com.sppld.pld.dto.ClientResDTO;

public interface ClientsPpldDao {
	public List<ClientListResDTO> getListClients(ClientListReqDTO loClientListReqDTO) throws Exception;
	
	public ClientResDTO crudClientsPpld(ClientReqDTO loClientReqDTO) throws Exception;
}
