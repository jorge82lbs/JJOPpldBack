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

import com.sppld.pld.dto.UmbralCrudReqDTO;
import com.sppld.pld.dto.UmbralCrudResDTO;
import com.sppld.pld.dto.UmbralListResDTO;
import com.sppld.pld.dto.UmbralListReqDTO;
import com.sppld.pld.service.UmbralService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "SPPLD", description = "Controlador de servicios para Umbral")
@RequestMapping("/api/umbral")
public class UmbralController {
	
	@Autowired
	private UmbralService umbralService;
    
    
    public static final String URL_SERVER_FRONT = "http://localhost:4200";

    @CrossOrigin(origins = URL_SERVER_FRONT)
    @Operation(summary = "crudUmbral")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog created"),
			@ApiResponse(responseCode = "201", description = "Catalog created", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UmbralCrudResDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("crudUmbral")
	public ResponseEntity<UmbralCrudResDTO> crudUmbral(@RequestBody UmbralCrudReqDTO loUmbralCrudReqDTO) {
    	UmbralCrudResDTO loBean = umbralService.crudUmbral(loUmbralCrudReqDTO);
        //if(loBean.getLsCodeStatus().equalsIgnoreCase("SUCCESS")){        
            return new ResponseEntity<>(loBean, HttpStatus.OK); // Return 200 OK with UserDTO
        /*}else{
            return new ResponseEntity<>(loBean,HttpStatus.NOT_IMPLEMENTED);
        }*/
	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListUmbral")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog deleted"),
			@ApiResponse(responseCode = "201", description = "Catalog deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UmbralListResDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListUmbral")
	public ResponseEntity<List<UmbralListResDTO>> getListUmbral(@RequestBody UmbralListReqDTO loUmbralListReqDTO) {

        List<UmbralListResDTO> laList = umbralService.getListUmbral(loUmbralListReqDTO);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}
	

}
