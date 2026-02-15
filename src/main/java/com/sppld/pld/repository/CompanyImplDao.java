package com.sppld.pld.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sppld.pld.dto.CompanyCrudReq;
import com.sppld.pld.dto.CompanyCrudRes;
import com.sppld.pld.dto.CompanyListReq;
import com.sppld.pld.dto.CompanyListRes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class CompanyImplDao implements CompanyDao {
	
	@Autowired
	//@Qualifier("jdbcDataSource")
	private JdbcTemplate loDatasource;
	
	@Override
	public CompanyCrudRes crudCompany(CompanyCrudReq loCompanyCrudReq) throws Exception {
		CompanyCrudRes lbResult = new CompanyCrudRes();
        Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			
			System.out.println("CALL SPPLDSAT.PLD_CRUD_COMPANY_PR(");
			System.out.println(""+loCompanyCrudReq.getLiIdCompany()+",");
			System.out.println(""+loCompanyCrudReq.getLiIdApplication()+",");
			System.out.println("'"+loCompanyCrudReq.getLsIndRfc()+"',");
			System.out.println("'"+loCompanyCrudReq.getLsIndDescription()+"',");
			System.out.println("'"+loCompanyCrudReq.getLsIndEmail()+"',");
			System.out.println("'"+loCompanyCrudReq.getLsIndEstatus()+"',");
			System.out.println("'"+loCompanyCrudReq.getLsUserName()+"',");
			System.out.println(""+loCompanyCrudReq.getLiOperationType()+")");
			
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_COMPANY_PR(?,?,?,?,?,?,?,?)");
			loCallableStatement.setInt(1, loCompanyCrudReq.getLiIdCompany());
			loCallableStatement.setInt(2, loCompanyCrudReq.getLiIdApplication());
			loCallableStatement.setString(3, loCompanyCrudReq.getLsIndRfc());
			loCallableStatement.setString(4, loCompanyCrudReq.getLsIndDescription());
			loCallableStatement.setString(5, loCompanyCrudReq.getLsIndEmail());
			loCallableStatement.setString(6, loCompanyCrudReq.getLsIndEstatus());
			loCallableStatement.setString(7, loCompanyCrudReq.getLsUserName());
			loCallableStatement.setInt(8, loCompanyCrudReq.getLiOperationType());
			
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
	public List<CompanyListRes> getListCompanies(CompanyListReq loCompanyListReq) throws Exception {
		List<CompanyListRes> laList = new ArrayList<CompanyListRes>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_COMPANY_PR(?, ?, ?)");
			loCallableStatement.setInt(1, loCompanyListReq.getLiIdCompany());
			loCallableStatement.setInt(2, loCompanyListReq.getLiIdApplication());			
			loCallableStatement.setInt(3, loCompanyListReq.getLiOperationType());
			
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	  CompanyListRes loEnt = new CompanyListRes();				    	
					
					loEnt.setLiId(liI);
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));					
					loEnt.setLsIndRfc(loRs.getString("IND_RFC"));
					loEnt.setLsIndDescription(loRs.getString("IND_DESCRIPTION"));
					loEnt.setLsIndEmail(loRs.getString("IND_EMAIL"));
					loEnt.setLsIndEstatus(loRs.getString("IND_ESTATUS"));
					loEnt.setLsIndCreatedBy(loRs.getString("IND_CREATED_BY"));
					
					
					
					laList.add(loEnt);
					liI++;
				    
			      }
			      loRs.close();
			}
			
		}catch(Exception loEx) {
			System.out.println("Error al invocar SP PLD_GET_COMPANY_PR :"+loEx.getMessage());
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
