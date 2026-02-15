package com.sppld.pld.repository;

import com.sppld.pld.dto.UserCrudReq;
import com.sppld.pld.dto.UserCrudRes;
import com.sppld.pld.dto.UserListReq;
import com.sppld.pld.dto.UserListRes;

import java.util.List;

public interface UsersDao {

	public UserCrudRes crudUsers(UserCrudReq loUserCrudReq) throws Exception;
	public List<UserListRes> getListUsers(UserListReq loUserListReq) throws Exception;
	
}
