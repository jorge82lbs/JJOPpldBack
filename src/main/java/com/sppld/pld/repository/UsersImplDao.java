package com.sppld.pld.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sppld.pld.dto.UserCrudReq;
import com.sppld.pld.dto.UserCrudRes;
import com.sppld.pld.dto.UserListReq;
import com.sppld.pld.dto.UserListRes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;
import lombok.extern.log4j.Log4j2;


@Repository
@Log4j2
public class UsersImplDao implements UsersDao {
	
	@Autowired
	//@Qualifier("jdbcDataSource")
	private JdbcTemplate loDatasource;
	
	@Override
	public UserCrudRes crudUsers(UserCrudReq loUserCrudReq) throws Exception {
		UserCrudRes loResult = new UserCrudRes();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			
			System.out.println("CALL SPPLDSAT.PLD_CRUD_USERS_PR(");
			System.out.println(""+loUserCrudReq.getLiIdUser()+",");
			System.out.println(""+loUserCrudReq.getLiIdApplication()+",");
			System.out.println(""+loUserCrudReq.getLiIdCompany()+",");
			System.out.println("'"+loUserCrudReq.getLsIndRfc()+"',");
			System.out.println("'"+loUserCrudReq.getLsIndFirstName()+"',");
			System.out.println("'"+loUserCrudReq.getLsIndSecondName()+"',");
			System.out.println("'"+loUserCrudReq.getLsIndName()+"',");
			System.out.println("'"+loUserCrudReq.getLsIndUsername()+"',");
			System.out.println("'"+loUserCrudReq.getLsIndDescription()+"',");
			System.out.println("'"+loUserCrudReq.getLsIndEmail()+"',");
			System.out.println("'"+loUserCrudReq.getLsIndRol()+"',");
			System.out.println("'"+loUserCrudReq.getLsIndEstatus()+"',");
			System.out.println("'"+loUserCrudReq.getLsUsername()+"',");
			System.out.println(""+loUserCrudReq.getLiOperationType()+")");
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_CRUD_USERS_PR(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			loCallableStatement.setInt(1, loUserCrudReq.getLiIdUser());
			loCallableStatement.setInt(2, loUserCrudReq.getLiIdApplication());
			loCallableStatement.setInt(3, loUserCrudReq.getLiIdCompany());
			loCallableStatement.setString(4, loUserCrudReq.getLsIndRfc());
			loCallableStatement.setString(5, loUserCrudReq.getLsIndFirstName());
			loCallableStatement.setString(6, loUserCrudReq.getLsIndSecondName());
			loCallableStatement.setString(7, loUserCrudReq.getLsIndName());
			loCallableStatement.setString(8, loUserCrudReq.getLsIndUsername());
			loCallableStatement.setString(9, loUserCrudReq.getLsIndDescription());
			loCallableStatement.setString(10, loUserCrudReq.getLsIndEmail());
			loCallableStatement.setString(11, loUserCrudReq.getLsIndRol());
			loCallableStatement.setString(12, loUserCrudReq.getLsIndEstatus());			
			loCallableStatement.setString(13, loUserCrudReq.getLsUsername());
			loCallableStatement.setInt(14, loUserCrudReq.getLiOperationType());
			
			boolean loHasResultSet =  loCallableStatement.execute();				
			if (loHasResultSet) {
				ResultSet loRs = loCallableStatement.getResultSet();
				while (loRs.next()) {		
					System.out.println("CODE_STATUS: "+loRs.getString("CODE_STATUS").trim()+" --> CODE_DESCRIPTION: "+loRs.getString("CODE_DESCRIPTION").trim());
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
					System.out.println("Handle potential exceptions during close "+e.getMessage());
					loResult.setLsCodeStatus("ERR");
					loResult.setLsCodeDescription(e.getMessage());				
					e.printStackTrace();	                    
				}
			}
		}

		return loResult;
	}

	@Override
	public List<UserListRes> getListUsers(UserListReq loUserListReq) throws Exception {
		List<UserListRes> laList = new ArrayList<UserListRes>();
		Connection loConnection = loDatasource.getDataSource().getConnection();
		try {
			CallableStatement loCallableStatement = loConnection.prepareCall("CALL SPPLDSAT.PLD_GET_USERS_PR(?, ?, ?, ?)");
			loCallableStatement.setInt(1, loUserListReq.getLiIdUser());
			loCallableStatement.setInt(2, loUserListReq.getLiIdApplication());
			loCallableStatement.setInt(3, loUserListReq.getLiIdCompany());
			loCallableStatement.setInt(4, loUserListReq.getLiOperationType());
			
			boolean loHasResultSet =  loCallableStatement.execute();
			
			if (loHasResultSet) {
			      ResultSet loRs = loCallableStatement.getResultSet();
			      int liI = 1;
			      while (loRs.next()) {
			    	 
			    	UserListRes loEnt = new UserListRes();				    	
					
					loEnt.setLiId(liI);
					
					loEnt.setLiIdUser(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdApplication(loRs.getInt("ID_APPLICATION"));
					loEnt.setLiIdCompany(loRs.getInt("ID_COMPANY"));
					
					loEnt.setLsIndRfc(loRs.getString("IND_RFC"));
					loEnt.setLsIndFirstName(loRs.getString("IND_FIRST_NAME"));
					loEnt.setLsIndSecondName(loRs.getString("IND_SECOND_NAME"));
					loEnt.setLsIndName(loRs.getString("IND_NAME"));
					loEnt.setLsIndUsername(loRs.getString("IND_USERNAME"));
					loEnt.setLsIndDescription(loRs.getString("IND_DESCRIPTION"));
					loEnt.setLsIndEmail(loRs.getString("IND_EMAIL"));
					loEnt.setLsIndRol(loRs.getString("IND_ROL"));
					loEnt.setLsIndEstatus(loRs.getString("IND_ESTATUS"));
										
					laList.add(loEnt);
					liI++;
				    
			      }
			      loRs.close();
			}
			
		}catch(Exception loEx) {
			System.out.println("Error al invocar SP PLD_GET_USERS_PR :"+loEx.getMessage());
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
