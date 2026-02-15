package com.sppld.pld.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sppld.pld.dto.UserCrudReq;
import com.sppld.pld.dto.UserCrudRes;
import com.sppld.pld.dto.UserListReq;
import com.sppld.pld.dto.UserListRes;
import com.sppld.pld.repository.UsersDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UsersImplService implements UsersService {

	@Autowired
	private UsersDao loUsersDao;
	
	@Override
	public UserCrudRes crudUsers(UserCrudReq loUserCrudReq) {
		UserCrudRes loService = new UserCrudRes();
		try {			
			loService = loUsersDao.crudUsers(loUserCrudReq);
		} catch (Exception e) {
			loService.setLsCodeStatus("ERR");
			loService.setLsCodeDescription(e.getMessage());
		}
		return loService;
	}

	@Override
	public List<UserListRes> getListUsers(UserListReq loUserListReq) {
		List<UserListRes> laList = new ArrayList<UserListRes>();
		try {
			laList = loUsersDao.getListUsers(loUserListReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laList;
	}

}
