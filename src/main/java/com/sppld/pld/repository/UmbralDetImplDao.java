package com.sppld.pld.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;
import lombok.extern.log4j.Log4j2;

import com.sppld.pld.dto.UmDetSelectReqDTO;
import com.sppld.pld.dto.UmDetSelectResDTO;
import com.sppld.pld.dto.UmbralDetDTO;
import com.sppld.pld.dto.UmbralDetResponseDTO;


@Repository
@Log4j2
public class UmbralDetImplDao implements UmbralDetDao {

	@Autowired
	//@Qualifier("jdbcDataSource")
	private JdbcTemplate loDatasource;
	
	@Override
	public UmbralDetResponseDTO crudUmbralDet(UmbralDetDTO loUmbralDetDTO) throws Exception {
		UmbralDetResponseDTO loResult = new UmbralDetResponseDTO();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_UMBRAL_DET_PR(?,?,?,?,?,?,?,?,?,?,?)");
			loCallableStatement.setInt(1, loUmbralDetDTO.getLiIdUmbralDet());
			loCallableStatement.setInt(2, loUmbralDetDTO.getLiIdRelation());
			loCallableStatement.setString(3, loUmbralDetDTO.getLsIdTypeRule());
			loCallableStatement.setInt(4, loUmbralDetDTO.getLiNumInitialRange());
			loCallableStatement.setInt(5, loUmbralDetDTO.getLiNumFinalRange());
			loCallableStatement.setString(6, loUmbralDetDTO.getLsIndGroupRange());
			loCallableStatement.setInt(7, loUmbralDetDTO.getLiNumAmount());
			loCallableStatement.setInt(8, loUmbralDetDTO.getLiNumDeterminant());
			loCallableStatement.setString(9, loUmbralDetDTO.getLsIndNomRule());
			loCallableStatement.setString(10, loUmbralDetDTO.getLsUsername());
			loCallableStatement.setInt(11, loUmbralDetDTO.getLiOperation());
			
			boolean loHasResultSet =  loCallableStatement.execute();				
			if (loHasResultSet) {
				ResultSet loRs = loCallableStatement.getResultSet();
				while (loRs.next()) {				    	
					loResult.setLsCodeStatus(loRs.getString("CODE_STATUS").trim());
					loResult.setLsCodeDescription(loRs.getString("CODE_DESCRIPTION").trim());
				}				      
				loRs.close();
			}
			
		}catch(Exception loEx) {
			System.out.println("Error al invocar SP "+loEx.getMessage());
			loResult.setLsCodeStatus("ERR");
			loResult.setLsCodeDescription(loEx.getMessage());				
			
		}finally {
			if (loConnection != null) {
				try {
					loConnection.close(); // Close the connection
				} catch (Exception e) {
					// Handle potential exceptions during close
					loResult.setLsCodeStatus("ERR");
					loResult.setLsCodeDescription(e.getMessage());				
					e.printStackTrace();	                    
				}
			}
		}

		return loResult;
	}

	@Override
	public List<UmDetSelectResDTO> getListUmbralDet(UmDetSelectReqDTO loUmDetSelectReqDTO) throws Exception {
		List<UmDetSelectResDTO> laList = new ArrayList<UmDetSelectResDTO>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_UMBRAL_DET_PR(?, ?, ?)");
			loCallableStatement.setInt(1, loUmDetSelectReqDTO.getLiIdApplication());
			loCallableStatement.setInt(2, loUmDetSelectReqDTO.getLiIdCompany());
			loCallableStatement.setInt(3, loUmDetSelectReqDTO.getLiIdConceptRel());
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	UmDetSelectResDTO loEnt = new UmDetSelectResDTO();				    	
					
					loEnt.setLiId(liI);
					
					loEnt.setLiIdUmbralDet(loRs.getInt("ID_UMBRAL_DET"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));
					loEnt.setLiIdRelation(loRs.getInt("ID_RELATION"));					
					loEnt.setLiIdConceptRel(loRs.getInt("ID_CONCEPT_REL"));
					loEnt.setLiIdConcept(loRs.getInt("ID_CONCEPT"));					
					loEnt.setLsNomConceptRel(loRs.getString("NOM_CONCEPT_REL"));
					loEnt.setLsNomConcept(loRs.getString("NOM_CONCEPT"));
					
					loEnt.setLsTypeRule(loRs.getString("IND_TYPE_RULE"));
					loEnt.setLiInitialRange(loRs.getInt("NUM_INITIAL_RANGE"));
					loEnt.setLiFinalRange(loRs.getInt("NUM_FINAL_RANGE"));
					loEnt.setLsGroupRange(loRs.getString("IND_GROUP_RANGE"));
					loEnt.setLiNumAmount(loRs.getInt("NUM_AMOUNT"));
					loEnt.setLiDeterminant(loRs.getInt("NUM_DETERMINANT"));
					loEnt.setLsNomRule(loRs.getString("IND_NOM_RULE"));
					

					loEnt.setLsIndEstatus(loRs.getString("IND_ESTATUS"));
					loEnt.setLtFecCreationDate(loRs.getDate("FEC_CREATION_DATE"));
					loEnt.setLtFecLastUpdateDate(loRs.getDate("FEC_LAST_UPDATE_DATE"));
					loEnt.setLsCreatedBy(loRs.getString("IND_CREATED_BY"));
					loEnt.setLsLastUpdatedBy(loRs.getString("IND_LAST_UPDATED_BY"));
					
					laList.add(loEnt);
					liI++;
				    
			      }
			      loRs.close();
			}
			
		}catch(Exception loEx) {
			System.out.println("Error al invocar SP :"+loEx.getMessage());
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
