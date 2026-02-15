package com.sppld.pld.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sppld.pld.dto.ClientDetListReqDTO;
import com.sppld.pld.dto.ClientDetListResDTO;
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
					",?"+
					")");
			System.out.println("CALL CALL SPPLDSAT.PLD_CRUD_CLIENTS_DETAIL_PR(");
			System.out.println("0");
			System.out.println(loClientReqDTO.getLiIdApplication()+",");
			System.out.println(loClientReqDTO.getLiIdCompany()+",");
			System.out.println("'"+loClientReqDTO.getLtFecDocumentDate()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndFirstName()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndSecondName()+"',");
			
			System.out.println("'"+loClientReqDTO.getLsIndNames()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndNationality()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndCountryBirth()+"',");
			System.out.println("'"+loClientReqDTO.getLtFecBirthDate()+"',");
			
			System.out.println("'"+loClientReqDTO.getLsIndEconomicAct()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndRfc()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndAddressStreet()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndAddressNum()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndAddressSuburb()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndAddressCp()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndAddressCity()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndAddressTown()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndAddressState()+"',");
			
			System.out.println("'"+loClientReqDTO.getLsIndPhoneNumber()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndPhoneExt()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndPhoneSmart()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndCountry()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndCurp()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndEmail()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndIdOficial()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndIdName()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndIdAuthority()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndForeign()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndFstreet()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndFnumber()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndFsuburb()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndFcity()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndFstate()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndFcp()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndFcountry()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndBcontroller()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndBcDoc()+"',");
			System.out.println("'"+loClientReqDTO.getLsIndEstatus()+"',");
			System.out.println(""+loClientReqDTO.getLiOperationType()+",");
			System.out.println("'"+loClientReqDTO.getLsUserName()+"',");
			System.out.println(");");
			
			
			
			
			
			
			//loCallableStatement.setInt(1, loClientReqDTO.getLiIdClient());
			loCallableStatement.setInt(1, 0);
			loCallableStatement.setInt(2, loClientReqDTO.getLiIdApplication());
			loCallableStatement.setInt(3, loClientReqDTO.getLiIdCompany());			
			
			//long timeFecDoc = loClientReqDTO.getLtFecDocumentDate().getTime();			
			//loCallableStatement.setDate(4, new java.sql.Date(timeFecDoc));
			loCallableStatement.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			
			loCallableStatement.setString(5, loClientReqDTO.getLsIndFirstName());
			loCallableStatement.setString(6, loClientReqDTO.getLsIndSecondName());
			loCallableStatement.setString(7, loClientReqDTO.getLsIndNames());
			loCallableStatement.setString(8, loClientReqDTO.getLsIndNationality());
			loCallableStatement.setString(9, loClientReqDTO.getLsIndCountryBirth());
			
			long timeFecBirth = loClientReqDTO.getLtFecBirthDate().getTime();
			loCallableStatement.setDate(10, new java.sql.Date(timeFecBirth));
			//loCallableStatement.setDate(10, new java.sql.Date(System.currentTimeMillis()));
			
			loCallableStatement.setString(11, loClientReqDTO.getLsIndEconomicAct());
			loCallableStatement.setString(12, loClientReqDTO.getLsIndRfc());
			loCallableStatement.setString(13, loClientReqDTO.getLsIndAddressStreet());
			loCallableStatement.setString(14, loClientReqDTO.getLsIndAddressNum());
			loCallableStatement.setString(15, loClientReqDTO.getLsIndAddressSuburb());
			loCallableStatement.setString(16, loClientReqDTO.getLsIndAddressCp());
			loCallableStatement.setString(17, loClientReqDTO.getLsIndAddressCity());
			loCallableStatement.setString(18, loClientReqDTO.getLsIndAddressTown());
			loCallableStatement.setString(19, loClientReqDTO.getLsIndAddressState());
			loCallableStatement.setString(20, loClientReqDTO.getLsIndPhoneNumber());
			loCallableStatement.setString(21, loClientReqDTO.getLsIndPhoneExt());
			loCallableStatement.setString(22, loClientReqDTO.getLsIndPhoneSmart());
			loCallableStatement.setString(23, loClientReqDTO.getLsIndCountry());
			loCallableStatement.setString(24, loClientReqDTO.getLsIndCurp());
			loCallableStatement.setString(25, loClientReqDTO.getLsIndEmail());
			loCallableStatement.setString(26, loClientReqDTO.getLsIndIdOficial());
			loCallableStatement.setString(27, loClientReqDTO.getLsIndIdName());
			loCallableStatement.setString(28, loClientReqDTO.getLsIndIdAuthority());
			loCallableStatement.setString(29, loClientReqDTO.getLsIndForeign());
			loCallableStatement.setString(30, loClientReqDTO.getLsIndFstreet());
			loCallableStatement.setString(31, loClientReqDTO.getLsIndFnumber());
			loCallableStatement.setString(32, loClientReqDTO.getLsIndFsuburb());
			loCallableStatement.setString(33, loClientReqDTO.getLsIndFcity());
			loCallableStatement.setString(34, loClientReqDTO.getLsIndFstate());
			loCallableStatement.setString(35, loClientReqDTO.getLsIndFcp());
			loCallableStatement.setString(36, loClientReqDTO.getLsIndFcountry());
			loCallableStatement.setString(37, loClientReqDTO.getLsIndBcontroller());
			loCallableStatement.setString(38, loClientReqDTO.getLsIndBcDoc());
			loCallableStatement.setString(39, loClientReqDTO.getLsIndEstatus());
			loCallableStatement.setInt(40, loClientReqDTO.getLiOperationType());
			loCallableStatement.setString(41, loClientReqDTO.getLsUserName());
						
			
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

	@Override
	public List<ClientDetListResDTO> getListClientsDet(ClientDetListReqDTO loClientListReqDTO) throws Exception {
		List<ClientDetListResDTO> laList = new ArrayList<ClientDetListResDTO>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_CLIENTS_DET_PR(?, ?, ?, ?)");
			loCallableStatement.setInt(1, loClientListReqDTO.getLiIdClient());
			loCallableStatement.setInt(2, loClientListReqDTO.getLiIdApplication());
			loCallableStatement.setInt(3, loClientListReqDTO.getLiIdCompany());
			loCallableStatement.setInt(4, loClientListReqDTO.getLiOperationType());
			
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	  ClientDetListResDTO loEnt = new ClientDetListResDTO();				    	
					
					loEnt.setLiId(liI);					
					loEnt.setLiIdClientDet(loRs.getInt("ID_CLIENT_DET"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));
					loEnt.setLtFecDocumentDate(loRs.getDate("FEC_DOCUMENT_DATE"));
					loEnt.setLsIndFirstName(loRs.getString("IND_FIRST_NAME"));
					loEnt.setLsIndSecondName(loRs.getString("IND_SECOND_NAME"));
					loEnt.setLsIndNames(loRs.getString("IND_NAMES"));
					loEnt.setLsIndNationality(loRs.getString("IND_NATIONALITY"));
					loEnt.setLsIndCountryBirth(loRs.getString("IND_COUNTRY_BIRTH"));
					loEnt.setLtFecBirthDate(loRs.getDate("FEC_BIRTH_DATE"));
					loEnt.setLsIndEconomicAct(loRs.getString("IND_ECONOMIC_ACT"));
					loEnt.setLsIndRfc(loRs.getString("IND_RFC"));
					loEnt.setLsIndAddressStreet(loRs.getString("IND_ADDRESS_STREET"));
					loEnt.setLsIndAddressNum(loRs.getString("IND_ADDRESS_NUM"));
					loEnt.setLsIndAddressSuburb(loRs.getString("IND_ADDRESS_SUBURB"));
					loEnt.setLsIndAddressCp(loRs.getString("IND_ADDRESS_CP"));
					loEnt.setLsIndAddressCity(loRs.getString("IND_ADDRESS_CITY"));
					loEnt.setLsIndAddressTown(loRs.getString("IND_ADDRESS_TOWN"));
					loEnt.setLsIndAddressState(loRs.getString("IND_ADDRESS_STATE"));
					loEnt.setLsIndPhoneNumber(loRs.getString("IND_PHONE_NUMBER"));
					loEnt.setLsIndPhoneExt(loRs.getString("IND_PHONE_EXT"));
					loEnt.setLsIndPhoneSmart(loRs.getString("IND_PHONE_SMART"));
					loEnt.setLsIndCountry(loRs.getString("IND_COUNTRY"));
					loEnt.setLsIndCurp(loRs.getString("IND_CURP"));
					loEnt.setLsIndEmail(loRs.getString("IND_EMAIL"));
					loEnt.setLsIndIdOficial(loRs.getString("IND_ID_OFICIAL"));
					loEnt.setLsIndIdName(loRs.getString("IND_ID_NAME"));
					loEnt.setLsIndIdAuthority(loRs.getString("IND_ID_AUTHORITY"));
					loEnt.setLsIndForeign(loRs.getString("IND_FOREIGN"));
					loEnt.setLsIndFstreet(loRs.getString("IND_FSTREET"));
					loEnt.setLsIndFnumber(loRs.getString("IND_FNUMBER"));
					loEnt.setLsIndFsuburb(loRs.getString("IND_FSUBURB"));
					loEnt.setLsIndFcity(loRs.getString("IND_FCITY"));
					loEnt.setLsIndFstate(loRs.getString("IND_FSTATE"));
					loEnt.setLsIndFcp(loRs.getString("IND_FCP"));
					loEnt.setLsIndFcountry(loRs.getString("IND_FCOUNTRY"));
					loEnt.setLsIndBcontroller(loRs.getString("IND_BCONTROLLER"));
					loEnt.setLsIndBcDoc(loRs.getString("IND_BC_DOC"));
					//loEnt.setLsIndEstatus(loRs.getString("IND_ESTATUS"));
					System.out.println("liI:"+liI);
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

}
