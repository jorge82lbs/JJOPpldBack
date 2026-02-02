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

import com.sppld.pld.dto.RelConSelectReqDTO;
import com.sppld.pld.dto.RelConSelectResDTO;
import com.sppld.pld.dto.RelSelectReqDTO;
import com.sppld.pld.dto.RelSelectResponseDTO;
import com.sppld.pld.dto.RelationDTO;
import com.sppld.pld.dto.RelationResponseDTO;

import com.sppld.pld.dto.RelMainReq;
import com.sppld.pld.dto.RelMainResponse;

@Repository
@Log4j2
public class RelationDaoImpl implements RelationDao{
	@Autowired
	//@Qualifier("jdbcDataSource")
	private JdbcTemplate loDatasource;

	@Override
	public RelationResponseDTO crudCatalogRelation(RelationDTO loRelation) throws Exception {
		RelationResponseDTO loResult = new RelationResponseDTO();
		
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			
			
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_RELATION_PR(?,?,?,?,?,?,?)");
			loCallableStatement.setInt(1, loRelation.getLiIdRelation());
			loCallableStatement.setInt(2, loRelation.getLiIdApplication());
			loCallableStatement.setInt(3, loRelation.getLiIdCompany());
			
			loCallableStatement.setInt(4, loRelation.getLiConceptUp());
			loCallableStatement.setInt(5, loRelation.getLiConceptDown());
			loCallableStatement.setString(6, loRelation.getLsCreatedBy());
			loCallableStatement.setInt(7, loRelation.getLiOperation());
			
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
	public List<RelSelectResponseDTO> getListRelation(RelSelectReqDTO loRelSelectReqDTO) throws Exception {
		List<RelSelectResponseDTO> laList = new ArrayList<RelSelectResponseDTO>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_RELATIONS_PR(?, ?, ?)");
			loCallableStatement.setInt(1, loRelSelectReqDTO.getLiIdApplication());
			loCallableStatement.setInt(2, loRelSelectReqDTO.getLiIdCompany());
			loCallableStatement.setInt(3, loRelSelectReqDTO.getLiIdConceptRel());
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	  RelSelectResponseDTO loEnt = new RelSelectResponseDTO();				    	
					
					loEnt.setLiId(liI);
					loEnt.setLiIdRelation(loRs.getInt("ID_RELATION"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));
					
					loEnt.setLiIdConceptRel(loRs.getInt("ID_CONCEPT_REL"));
					loEnt.setLiIdConcept(loRs.getInt("ID_CONCEPT"));
					loEnt.setLsNomConceptRel(loRs.getString("NOM_CONCEPT_REL"));
					loEnt.setLsNomConcept(loRs.getString("NOM_CONCEPT"));

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

	@Override
	public List<RelConSelectResDTO> getListRelationCat(RelConSelectReqDTO loRelConSelectReqDTO) throws Exception {
		List<RelConSelectResDTO> laList = new ArrayList<RelConSelectResDTO>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_REL_CONCEPTS_PR(?, ?, ?)");
			loCallableStatement.setInt(1, loRelConSelectReqDTO.getLiIdApplication());
			loCallableStatement.setInt(2, loRelConSelectReqDTO.getLiIdCompany());
			loCallableStatement.setInt(3, loRelConSelectReqDTO.getLiIdConceptRel());
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
				ResultSet loRs = loCallableStatement.getResultSet();
			    int liI = 1;
			    while (loRs.next()) {
			    	RelConSelectResDTO loEnt = new RelConSelectResDTO();				    						
					loEnt.setLiId(liI);
					loEnt.setLiIdConceptRisk(loRs.getInt("ID_CONCEPT_RISK"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));					
					loEnt.setLiIdConceptRel(loRs.getInt("ID_CONCEPT_REL"));
					loEnt.setLsNomCatalogRisk(loRs.getString("NOM_CATALOG_RISK"));
					loEnt.setLsIndEstatus(loRs.getString("IND_ESTATUS"));
					
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

	@Override
	public List<RelMainResponse> getListRelationMainCat(RelMainReq loRelMainReq) throws Exception {
		List<RelMainResponse> laList = new ArrayList<RelMainResponse>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_RELATIONS_MAIN_PR(?, ?, ?, ?, ?, ?)");
			loCallableStatement.setInt(1, loRelMainReq.getLiIdApplication());
			loCallableStatement.setInt(2, loRelMainReq.getLiIdCompany());
			loCallableStatement.setInt(3, loRelMainReq.getLiIdConceptRel());
			loCallableStatement.setInt(4, loRelMainReq.getLiTypeOperation());
			loCallableStatement.setInt(5, loRelMainReq.getLiIndNivel());
			loCallableStatement.setString(6, loRelMainReq.getLsAttribute1());
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
				ResultSet loRs = loCallableStatement.getResultSet();
			    int liI = 1;
			    while (loRs.next()) {
			    	RelMainResponse loEnt = new RelMainResponse();				    						
					loEnt.setLiId(liI);
					loEnt.setLiIdConceptRisk(loRs.getInt("ID_CONCEPT_RISK"));
					loEnt.setLsNomCatalogRisk(loRs.getString("NOM_CATALOG_RISK"));
					loEnt.setLiIdRelation(loRs.getInt("ID_RELATION"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));						
					loEnt.setLiIdConceptRel(loRs.getInt("ID_CONCEPT_REL"));
					loEnt.setLsNomConceptRel(loRs.getString("NOM_CONCEPT_REL"));  
					loEnt.setLiIdConcept(loRs.getInt("ID_CONCEPT"));
					loEnt.setLsIndEstatus(loRs.getString("IND_ESTATUS"));
					loEnt.setLiIndValue(loRs.getDouble("IND_VALUE"));
					loEnt.setLiIndNivel(loRs.getInt("IND_NIVEL"));
					
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
