package com.sppld.pld.repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sppld.pld.dto.CatSelectReqDTO;
import com.sppld.pld.dto.CatSelectResponseDTO;
import com.sppld.pld.dto.CatalogDTO;
import com.sppld.pld.dto.CatalogResponseDTO;
import com.sppld.pld.dto.ConceptRelReqDTO;

import org.springframework.stereotype.Repository;


import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class CatalogDaoImpl implements CatalogDao{

    @Autowired
	//@Qualifier("jdbcDataSource")
	private JdbcTemplate loDatasource;

    @Override
    public CatalogResponseDTO saveCatalog(CatalogDTO loCatalog) throws Exception {		
        CatalogResponseDTO lbResult = new CatalogResponseDTO();
        Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_CONCEPT_PR(?,?,?,?,?,?)");
			loCallableStatement.setInt(1, 0);
			loCallableStatement.setInt(2, loCatalog.getLiIdApplication());
			loCallableStatement.setInt(3, loCatalog.getLiIdCompany());
			loCallableStatement.setString(4, loCatalog.getLsCreatedBy());
			loCallableStatement.setString(5, loCatalog.getLsNomCatalog());
			loCallableStatement.setInt(6, 1);
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
	public CatalogResponseDTO updateCatalog(CatalogDTO loCatalog) throws Exception {
		CatalogResponseDTO lbResult = new CatalogResponseDTO();
        Connection loConnection = loDatasource.getDataSource().getConnection();
        
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_CONCEPT_PR(?,?,?,?,?,?)");
			loCallableStatement.setInt(1, loCatalog.getLiIdCatalog());
			loCallableStatement.setInt(2, loCatalog.getLiIdApplication());
			loCallableStatement.setInt(3, loCatalog.getLiIdCompany());
			loCallableStatement.setString(4, loCatalog.getLsCreatedBy());
			loCallableStatement.setString(5, loCatalog.getLsNomCatalog());
			loCallableStatement.setInt(6, 2);
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
	public CatalogResponseDTO deleteCatalog(CatalogDTO loCatalog) throws Exception {
		CatalogResponseDTO lbResult = new CatalogResponseDTO();
        Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_CONCEPT_PR(?,?,?,?,?,?)");
			loCallableStatement.setInt(1, loCatalog.getLiIdCatalog());
			loCallableStatement.setInt(2, loCatalog.getLiIdApplication());
			loCallableStatement.setInt(3, loCatalog.getLiIdCompany());
			loCallableStatement.setString(4, loCatalog.getLsCreatedBy());
			loCallableStatement.setString(5, loCatalog.getLsNomCatalog());
			loCallableStatement.setInt(6, 3);
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
	public List<CatSelectResponseDTO> getListCatalog(CatSelectReqDTO loCatSelectReqDTO) throws Exception {
		List<CatSelectResponseDTO> laList = new ArrayList<CatSelectResponseDTO>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_CONCEPTS_PR(?, ?, ?, ?, ?)");
			loCallableStatement.setInt(1, loCatSelectReqDTO.getLiIdApplication());
			loCallableStatement.setInt(2, loCatSelectReqDTO.getLiIdCompany());
			loCallableStatement.setInt(3, loCatSelectReqDTO.getLiIdConceptRisk());
			loCallableStatement.setInt(4, loCatSelectReqDTO.getLiIsList());
			loCallableStatement.setString(5, loCatSelectReqDTO.getLsNomConceptRisk());
			
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	CatSelectResponseDTO loEnt = new CatSelectResponseDTO();				    	
					
					loEnt.setLiId(liI);
					loEnt.setLiIdConceptRisk(loRs.getInt("ID_CONCEPT_RISK"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));
					loEnt.setLsNomCatalogRisk(loRs.getString("NOM_CATALOG_RISK"));
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
			System.out.println("Error al invocar SP PLD_GET_CONCEPTS_PR :"+loEx.getMessage());
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
	public CatalogResponseDTO crudConceptRel(ConceptRelReqDTO loConceptRelReqDTO) throws Exception {
		CatalogResponseDTO lbResult = new CatalogResponseDTO();
        Connection loConnection = loDatasource.getDataSource().getConnection();                
        
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_CONCEPTREL_PR(?,?,?,?,?,?,?,?,?,?,?)");			
			loCallableStatement.setInt(1, loConceptRelReqDTO.getLiIdConceptUp());
			loCallableStatement.setInt(2, loConceptRelReqDTO.getLiIdApplication());
			loCallableStatement.setInt(3, loConceptRelReqDTO.getLiIdCompany());
			loCallableStatement.setString(4, loConceptRelReqDTO.getLsUsername());
			loCallableStatement.setString(5, loConceptRelReqDTO.getLsNomCatalog());
			loCallableStatement.setInt(6, loConceptRelReqDTO.getLiIdConceptDown());
			loCallableStatement.setInt(7, loConceptRelReqDTO.getLiIdRelation());
			loCallableStatement.setDouble(8, loConceptRelReqDTO.getLiIndValue());
			loCallableStatement.setInt(9, loConceptRelReqDTO.getLiIndNivel());
			loCallableStatement.setInt(10, loConceptRelReqDTO.getLiOperationType());
			loCallableStatement.setString(11, loConceptRelReqDTO.getLsAttribute1());
			
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
    
}
