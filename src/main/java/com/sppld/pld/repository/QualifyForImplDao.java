package com.sppld.pld.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sppld.pld.dto.QualifyListMainReqDTO;
import com.sppld.pld.dto.QualifyListMainResDTO;
import com.sppld.pld.dto.QualifyListReqDTO;
import com.sppld.pld.dto.QualifyListResDTO;
import com.sppld.pld.dto.QualifyReqDTO;
import com.sppld.pld.dto.QualifyResDTO;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class QualifyForImplDao  implements QualifyForDao{
	@Autowired
	//@Qualifier("jdbcDataSource")
	private JdbcTemplate loDatasource;

	@Override
	public QualifyResDTO crudQualifyFor(QualifyReqDTO loQualifyReqDTO) throws Exception {
		QualifyResDTO lbResult = new QualifyResDTO();
        Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			System.out.println("loQualifyReqDTO.getLiIdQualifyFor(): "+loQualifyReqDTO.getLiIdQualifyFor());
			System.out.println("loQualifyReqDTO.getLiIdApplication(): "+loQualifyReqDTO.getLiIdApplication());
			System.out.println("loQualifyReqDTO.getLiIdCompany(): "+loQualifyReqDTO.getLiIdCompany());
			System.out.println("loQualifyReqDTO.getLiIdClient(): "+loQualifyReqDTO.getLiIdClient());
			System.out.println("loQualifyReqDTO.getLiIdRelationUp(): "+loQualifyReqDTO.getLiIdRelationUp());
			System.out.println("loQualifyReqDTO.getLiIdRelation(): "+loQualifyReqDTO.getLiIdRelation());
			System.out.println("loQualifyReqDTO.getLiIndValue(): "+loQualifyReqDTO.getLiIndValue());
			System.out.println("loQualifyReqDTO.getLsUsername(): "+loQualifyReqDTO.getLsUsername());
			System.out.println("loQualifyReqDTO.getLiIOperationType(): "+loQualifyReqDTO.getLiIOperationType());
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_QUALIFY_FOR_PR(?,?,?,?,?,?,?,?,?)");
			loCallableStatement.setInt(1, loQualifyReqDTO.getLiIdQualifyFor());
			loCallableStatement.setInt(2, loQualifyReqDTO.getLiIdApplication());
			loCallableStatement.setInt(3, loQualifyReqDTO.getLiIdCompany());
			loCallableStatement.setInt(4, loQualifyReqDTO.getLiIdClient());
			loCallableStatement.setInt(5, loQualifyReqDTO.getLiIdRelationUp());
			loCallableStatement.setInt(6, loQualifyReqDTO.getLiIdRelation());
			loCallableStatement.setDouble(7, loQualifyReqDTO.getLiIndValue());
			loCallableStatement.setString(8, loQualifyReqDTO.getLsUsername());
			loCallableStatement.setInt(9, loQualifyReqDTO.getLiIOperationType());

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
		System.out.println("lbResult.getLsCodeStatus(): "+lbResult.getLsCodeStatus());
		System.out.println("lbResult.getLsCodeDescription(): "+lbResult.getLsCodeDescription());
		return lbResult;
	}

	@Override
	public List<QualifyListResDTO> getListQualify(QualifyListReqDTO loQualifyListReqDTO) throws Exception {
		List<QualifyListResDTO> laList = new ArrayList<QualifyListResDTO>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_QUALIFY_FOR_PR(?, ?, ?, ?, ?, ?)");
			loCallableStatement.setInt(1, loQualifyListReqDTO.getLiIdClient());
			loCallableStatement.setInt(2, loQualifyListReqDTO.getLiIdApplication());
			loCallableStatement.setInt(3, loQualifyListReqDTO.getLiIdCompany());
			loCallableStatement.setInt(4, loQualifyListReqDTO.getLiIdConceptRel());
			loCallableStatement.setInt(5, loQualifyListReqDTO.getLiIndNivel());
			loCallableStatement.setInt(6, loQualifyListReqDTO.getLiOperationType());
			
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	QualifyListResDTO loEnt = new QualifyListResDTO();				    	
					
					loEnt.setLiId(liI);
					loEnt.setLiIdQualify(loRs.getInt("ID_QUALIFY"));
					loEnt.setLiIdClient(loRs.getInt("ID_CLIENT"));
					loEnt.setLiNumQualified(loRs.getDouble("NUM_QUALIFIED"));
					loEnt.setLsNomConceptDown(loRs.getString("NOM_CONCEPT_DOWN"));
					loEnt.setLiIdRelation(loRs.getInt("ID_RELATION"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));							
					loEnt.setLiIdConceptRel(loRs.getInt("ID_CONCEPT_REL"));
					loEnt.setLsNomConceptRel(loRs.getString("NOM_CONCEPT_REL"));					
					loEnt.setLiIdConcept(loRs.getInt("ID_CONCEPT"));					
					loEnt.setLsNomConcept(loRs.getString("NOM_CONCEPT"));
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

	@Override
	public List<QualifyListMainResDTO> getListMainQualify(QualifyListMainReqDTO loQualifyListMainReqDTO) throws Exception {
		List<QualifyListMainResDTO> laList = new ArrayList<QualifyListMainResDTO>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_QUALIFY_MAIN_PR(?, ?, ?, ?, ?, ?)");
			loCallableStatement.setInt(1, loQualifyListMainReqDTO.getLiIdClient());
			loCallableStatement.setInt(2, loQualifyListMainReqDTO.getLiIdApplication());
			loCallableStatement.setInt(3, loQualifyListMainReqDTO.getLiIdCompany());
			loCallableStatement.setInt(4, loQualifyListMainReqDTO.getLiIdConceptRel());
			loCallableStatement.setInt(5, loQualifyListMainReqDTO.getLiIndNivel());
			loCallableStatement.setInt(6, loQualifyListMainReqDTO.getLiOperationType());			
			boolean loHasResultSet =  loCallableStatement.execute();			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	QualifyListMainResDTO loEnt = new QualifyListMainResDTO();				    	
					
					loEnt.setLiId(liI);
					loEnt.setLiIdConceptRisk(loRs.getInt("ID_CONCEPT_RISK"));
					loEnt.setLsNomCatalogRisk(loRs.getString("NOM_CATALOG_RISK"));
					loEnt.setLiMaxRisk(loRs.getDouble("MAX_RISK"));
					loEnt.setLiFactorx(loRs.getDouble("FACTORX"));
					loEnt.setLiSumRisk(loRs.getDouble("SUM_RISK"));
					loEnt.setLiCatCalif(loRs.getDouble("CAT_CALIF"));
					loEnt.setLiIndNivel(loRs.getInt("IND_NIVEL"));
					loEnt.setLiIdRelation(loRs.getInt("ID_RELATION"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));
					loEnt.setLiIdConceptRel(loRs.getInt("ID_CONCEPT_REL"));										
					loEnt.setLiIdConcept(loRs.getInt("ID_CONCEPT"));					
					loEnt.setLsIndEstatus(loRs.getString("IND_ESTATUS"));					
					loEnt.setLiIndValue(loRs.getDouble("IND_VALUE"));
					
					
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
