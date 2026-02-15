package com.sppld.pld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sppld.pld.dto.CatalogResponseDTO;
import com.sppld.pld.dto.UserCrudReq;
import com.sppld.pld.dto.UserCrudRes;
import com.sppld.pld.dto.UserListReq;
import com.sppld.pld.dto.UserListRes;

import com.sppld.pld.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "SPPLD", description = "Controlador de servicios para Administración de usuarios")
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	public static final String URL_SERVER_FRONT = "http://localhost:4200";

    @CrossOrigin(origins = URL_SERVER_FRONT)
    @Operation(summary = "crudUsers")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User created"),
			@ApiResponse(responseCode = "201", description = "User created", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserCrudRes.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("crudUsers")
    public ResponseEntity<UserCrudRes> crudUsers(@RequestBody UserCrudReq loUserCrudReq) {
    	
    	UserCrudRes loBean = usersService.crudUsers(loUserCrudReq);
    	
    	return new ResponseEntity<>(loBean, HttpStatus.OK);

	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListUsers")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Users deleted"),
			@ApiResponse(responseCode = "201", description = "Users deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CatalogResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListUsers")
	public ResponseEntity<List<UserListRes>> getListUsers(@RequestBody UserListReq loUserListReq) {

        List<UserListRes> laList = usersService.getListUsers(loUserListReq);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}
	
	
	
}
