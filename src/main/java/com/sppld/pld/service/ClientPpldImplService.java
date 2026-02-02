package com.sppld.pld.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppld.pld.dto.ClientListReqDTO;
import com.sppld.pld.dto.ClientListResDTO;
import com.sppld.pld.repository.ClientsPpldDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ClientPpldImplService implements ClientPpldService {
	
	@Autowired
	private ClientsPpldDao loClientsDao;
	
	@Override
	public List<ClientListResDTO> getListClients(ClientListReqDTO loClientListReqDTO) {
		List<ClientListResDTO> laList = new ArrayList<ClientListResDTO>();
		try {
			laList = loClientsDao.getListClients(loClientListReqDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

}
