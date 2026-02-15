package com.sppld.pld.service;

import java.util.List;

import com.sppld.pld.dto.UserCrudReq;
import com.sppld.pld.dto.UserCrudRes;
import com.sppld.pld.dto.UserListReq;
import com.sppld.pld.dto.UserListRes;

public interface UsersService {
	
	public UserCrudRes crudUsers(UserCrudReq loUserCrudReq);
	
	public List<UserListRes> getListUsers(UserListReq loUserListReq);
	

}
