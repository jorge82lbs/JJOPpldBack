package com.sppld.pld.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sppld.pld.dto.ClientListReqDTO;
import com.sppld.pld.dto.ClientListResDTO;
import com.sppld.pld.dto.ClientReqDTO;
import com.sppld.pld.dto.ClientResDTO;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class ClientsPpldImplDao implements ClientsPpldDao {
	@Autowired
	//@Qualifier("jdbcDataSource")
	private JdbcTemplate loDatasource;
	
	@Override
	public List<ClientListResDTO> getListClients(ClientListReqDTO loClientListReqDTO) throws Exception {
		List<ClientListResDTO> laList = new ArrayList<ClientListResDTO>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_CLIENTS_PR(?, ?, ?)");
			loCallableStatement.setInt(1, loClientListReqDTO.getLiIdClient());
			loCallableStatement.setInt(2, loClientListReqDTO.getLiIdApplication());
			loCallableStatement.setInt(3, loClientListReqDTO.getLiIdCompany());
			
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	  ClientListResDTO loEnt = new ClientListResDTO();				    	
					
					loEnt.setLiId(liI);					
					loEnt.setLiIdClient(loRs.getInt("ID_CLIENT"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));
					loEnt.setLsIndRfc(loRs.getString("IND_RFC"));
					loEnt.setLsIndDescription(loRs.getString("IND_DESCRIPTION"));
					loEnt.setLsIndEstatus(loRs.getString("IND_ESTATUS"));
					
					laList.add(loEnt);
					liI++;
				    
			      }
			      loRs.close();
			}
			
		}catch(Exception loEx) {
			System.out.println("Error al invocar SP PLD_GET_CLIENTS_PR :"+loEx.getMessage());
		}finally {
			if (loConnection != null) {
                try {
                    loConnection.close(); // Close the connection
                } catch (Exception e) {
                    // Handle potential exceptions during close
                    e.printStackTrace();
                }
            }
		}
		return laList;
	}

	@Override
	public ClientResDTO crudClientsPpld(ClientReqDTO loClientReqDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
