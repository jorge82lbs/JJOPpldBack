package com.sppld.pld.service;

import java.util.List;

import com.sppld.pld.dto.ClientListReqDTO;
import com.sppld.pld.dto.ClientListResDTO;

public interface ClientPpldService {
	public List<ClientListResDTO> getListClients(ClientListReqDTO loClientListReqDTO);
}
