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
		
		ClientResDTO lbResult = new ClientResDTO();
        Connection loConnection = loDatasource.getDataSource().getConnection();
        
		try {
			CallableStatement loCallableStatement = 
					loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_CLIENTS_DETAIL_PR(?,?,?,?,?"+
					",?,?,?,?,?"+
					",?,?,?,?,?"+
					",?,?,?,?,?"+
					",?,?,?,?,?"+
					",?,?,?,?,?"+
					",?,?,?,?,?"+
					",?,?,?,?,?"+
					",?,?"+
					")");
			loCallableStatement.setInt(1, loClientReqDTO.getLiIdClient());
			loCallableStatement.setInt(2, loClientReqDTO.getLiIdApplication());
			loCallableStatement.setInt(3, loClientReqDTO.getLiIdCompany());
			loCallableStatement.setInt(4, loClientReqDTO.getLiIdConcept());
			
			long timeFecDoc = loClientReqDTO.getLtFecDocumentDate().getTime();			
			loCallableStatement.setDate(5, new java.sql.Date(timeFecDoc));
			
			loCallableStatement.setString(6, loClientReqDTO.getLsIndFirstName());
			loCallableStatement.setString(7, loClientReqDTO.getLsIndSecondName());
			loCallableStatement.setString(8, loClientReqDTO.getLsIndNames());
			loCallableStatement.setString(9, loClientReqDTO.getLsIndNationality());
			loCallableStatement.setString(10, loClientReqDTO.getLsIndCountryBirth());
			
			long timeFecBirth = loClientReqDTO.getLtFecBirthDate().getTime();
			loCallableStatement.setDate(11, new java.sql.Date(timeFecBirth));
			
			loCallableStatement.setString(12, loClientReqDTO.getLsIndEconomicAct());
			loCallableStatement.setString(13, loClientReqDTO.getLsIndRfc());
			loCallableStatement.setString(14, loClientReqDTO.getLsIndAddressStreet());
			loCallableStatement.setString(15, loClientReqDTO.getLsIndAddressNum());
			loCallableStatement.setString(16, loClientReqDTO.getLsIndAddressSuburb());
			loCallableStatement.setString(17, loClientReqDTO.getLsIndAddressCp());
			loCallableStatement.setString(18, loClientReqDTO.getLsIndAddressCity());
			loCallableStatement.setString(19, loClientReqDTO.getLsIndAddressTown());
			loCallableStatement.setString(20, loClientReqDTO.getLsIndAddressState());
			loCallableStatement.setString(21, loClientReqDTO.getLsIndPhoneNumber());
			loCallableStatement.setString(22, loClientReqDTO.getLsIndPhoneExt());
			loCallableStatement.setString(23, loClientReqDTO.getLsIndPhoneSmart());
			loCallableStatement.setString(24, loClientReqDTO.getLsIndCountry());
			loCallableStatement.setString(25, loClientReqDTO.getLsIndCurp());
			loCallableStatement.setString(26, loClientReqDTO.getLsIndEmail());
			loCallableStatement.setString(27, loClientReqDTO.getLsIndIdOficial());
			loCallableStatement.setString(28, loClientReqDTO.getLsIndIdName());
			loCallableStatement.setString(29, loClientReqDTO.getLsIndIdAuthority());
			loCallableStatement.setString(30, loClientReqDTO.getLsIndForeign());
			loCallableStatement.setString(31, loClientReqDTO.getLsIndFstreet());
			loCallableStatement.setString(32, loClientReqDTO.getLsIndFnumber());
			loCallableStatement.setString(33, loClientReqDTO.getLsIndFsuburb());
			loCallableStatement.setString(34, loClientReqDTO.getLsIndFcity());
			loCallableStatement.setString(35, loClientReqDTO.getLsIndFstate());
			loCallableStatement.setString(36, loClientReqDTO.getLsIndFcp());
			loCallableStatement.setString(37, loClientReqDTO.getLsIndFcountry());
			loCallableStatement.setString(38, loClientReqDTO.getLsIndBcontroller());
			loCallableStatement.setString(39, loClientReqDTO.getLsIndBcDoc());
			loCallableStatement.setString(40, loClientReqDTO.getLsIndEstatus());
			loCallableStatement.setInt(41, loClientReqDTO.getLiOperationType());
			loCallableStatement.setString(42, loClientReqDTO.getLsUserName());
						
			
			System.out.println("getLiIdApplication: "+loClientReqDTO.getLiIdApplication());
			System.out.println("getLiIdCompany: "+loClientReqDTO.getLiIdCompany());
			System.out.println("getLiOperationType: "+loClientReqDTO.getLiOperationType());
			System.out.println("getLsIndRfc: "+loClientReqDTO.getLsIndRfc());
			
			boolean loHasResultSet =  loCallableStatement.execute();				
			if (loHasResultSet) {
				ResultSet loRs = loCallableStatement.getResultSet();
				while (loRs.next()) {				    	
					lbResult.setLsCodeStatus(loRs.getString("CODE_STATUS").trim());
					lbResult.setLsCodeDescription(loRs.getString("CODE_DESCRIPTION").trim());
				}				      
				loRs.close();
			}
			
		}catch(Exception loEx) {
			System.out.println("Error al invocar SP PLD_CRUD_CLIENTS_DETAIL_PR "+loEx.getMessage());
			lbResult.setLsCodeStatus("ERR");
			lbResult.setLsCodeDescription(loEx.getMessage());				
			
		}finally {
			if (loConnection != null) {
				try {
					loConnection.close(); // Close the connection
				} catch (Exception e) {
					// Handle potential exceptions during close
					lbResult.setLsCodeStatus("ERR");
					lbResult.setLsCodeDescription(e.getMessage());				
					e.printStackTrace();	                    
				}
			}
		}

		return lbResult;

	}

}
