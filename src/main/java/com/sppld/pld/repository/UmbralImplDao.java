package com.sppld.pld.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sppld.pld.dto.UmbralCrudReqDTO;
import com.sppld.pld.dto.UmbralCrudResDTO;
import com.sppld.pld.dto.UmbralListReqDTO;
import com.sppld.pld.dto.UmbralListResDTO;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class UmbralImplDao implements UmbralDao {
	
	@Autowired
	//@Qualifier("jdbcDataSource")
	private JdbcTemplate loDatasource;
	
	@Override
	public UmbralCrudResDTO crudUmbral(UmbralCrudReqDTO loUmbralCrudReqDTO) throws Exception {
		UmbralCrudResDTO lbResult = new UmbralCrudResDTO();
        Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_UMBRAL_PR(?,?,?,?,?,?,?,?,?)");
			loCallableStatement.setInt(1, loUmbralCrudReqDTO.getLiIdUmbral());
			loCallableStatement.setInt(2, loUmbralCrudReqDTO.getLiIdApplication());
			loCallableStatement.setInt(3, loUmbralCrudReqDTO.getLiIdCompany());
			loCallableStatement.setDouble(4, loUmbralCrudReqDTO.getLiNumInitial());
			loCallableStatement.setDouble(5, loUmbralCrudReqDTO.getLiNumFinal());						
			loCallableStatement.setString(6, loUmbralCrudReqDTO.getLsIndProbability());
			loCallableStatement.setString(7, loUmbralCrudReqDTO.getLsIndImpact());
			loCallableStatement.setString(8, loUmbralCrudReqDTO.getLsUsername());
			loCallableStatement.setInt(9, loUmbralCrudReqDTO.getLiOperationType());
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
			System.out.println("Error al invocar SP "+loEx.getMessage());
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
	public List<UmbralListResDTO> getListUmbral(UmbralListReqDTO loUmbralListReqDTO) throws Exception {
		List<UmbralListResDTO> laList = new ArrayList<UmbralListResDTO>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_UMBRAL_PR(?, ?)");
			loCallableStatement.setInt(1, loUmbralListReqDTO.getLiIdApplication());
			loCallableStatement.setInt(2, loUmbralListReqDTO.getLiIdCompany());			
			
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	  UmbralListResDTO loEnt = new UmbralListResDTO();				    	
					
					loEnt.setLiId(liI);
					loEnt.setLiIdUmbral(loRs.getInt("ID_UMBRAL"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));
					loEnt.setLiNumInitial(loRs.getDouble("NUM_INITIAL"));
					loEnt.setLiNumFinal(loRs.getDouble("NUM_FINAL"));
					loEnt.setLsIndProbabilty(loRs.getString("IND_PROBABILTY"));
					loEnt.setLsIndImpact(loRs.getString("IND_IMPACT"));					
					loEnt.setLsIndEstatus(loRs.getString("IND_ESTATUS"));
					
					laList.add(loEnt);
					liI++;
				    
			      }
			      loRs.close();
			}
			
		}catch(Exception loEx) {
			System.out.println("Error al invocar SP PLD_GET_UMBRAL_PR :"+loEx.getMessage());
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
