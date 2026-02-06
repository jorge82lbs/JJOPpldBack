package com.sppld.pld.service;

import java.util.List;

import com.sppld.pld.dto.ClientListReqDTO;
import com.sppld.pld.dto.ClientListResDTO;
import com.sppld.pld.dto.ClientReqDTO;
import com.sppld.pld.dto.ClientResDTO;

public interface ClientPpldService {
	public List<ClientListResDTO> getListClients(ClientListReqDTO loClientListReqDTO);
	public ClientResDTO crudClientsPpld(ClientReqDTO loClientReqDTO);
}
