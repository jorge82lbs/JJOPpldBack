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

import com.sppld.pld.dto.CompanyListReq;
import com.sppld.pld.dto.CompanyListRes;
import com.sppld.pld.dto.CompanyCrudReq;
import com.sppld.pld.dto.CompanyCrudRes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.sppld.pld.service.CompanyService;

@RestController
@Tag(name = "SPPLD", description = "Controlador de servicios para Company")
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService; 
	
	public static final String URL_SERVER_FRONT = "http://localhost:4200";

    @CrossOrigin(origins = URL_SERVER_FRONT)
    @Operation(summary = "crudCompanies")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Company created"),
			@ApiResponse(responseCode = "201", description = "Company created", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CompanyCrudRes.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("crudCompanies")
    public ResponseEntity<CompanyCrudRes> crudCompanies(@RequestBody CompanyCrudReq loCompanyCrudReq){
    	
    	CompanyCrudRes loBean = companyService.crudCompany(loCompanyCrudReq);
    	
    	return new ResponseEntity<>(loBean, HttpStatus.OK);
    }
    
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListCompanies")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Company deleted"),
			@ApiResponse(responseCode = "201", description = "Company deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CompanyListRes.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListCompanies")
	public ResponseEntity<List<CompanyListRes>> getListCompanies(@RequestBody CompanyListReq loCompanyListReq) {

        List<CompanyListRes> laList = companyService.getListCompanies(loCompanyListReq);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}
    
    
}
