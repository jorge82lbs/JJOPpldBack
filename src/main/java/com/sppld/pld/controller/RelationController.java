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

import com.sppld.pld.dto.RelSelectReqDTO;
import com.sppld.pld.dto.RelSelectResponseDTO;
import com.sppld.pld.dto.RelationResponseDTO;
import com.sppld.pld.dto.RelationDTO;
import com.sppld.pld.dto.RelConSelectReqDTO;
import com.sppld.pld.dto.RelConSelectResDTO;
import com.sppld.pld.service.RelationService;
import com.sppld.pld.dto.RelMainReq;
import com.sppld.pld.dto.RelMainResponse;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "SPPLD", description = "Controlador de servicios para Relacion de Catalogos")
@RequestMapping("/api/relation")
public class RelationController {
	
	@Autowired
	private RelationService relationService;
    
    public static final String URL_SERVER_FRONT = "http://localhost:4200";

    @CrossOrigin(origins = URL_SERVER_FRONT)
    @Operation(summary = "crudRelation")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Relation created"),
			@ApiResponse(responseCode = "201", description = "Catalog created", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = RelationResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("crudRelation")
	public ResponseEntity<RelationResponseDTO> crudRelation(@RequestBody RelationDTO loRelation) {

        RelationResponseDTO loBean = relationService.crudCatalogRelation(loRelation);
        
		if(loBean.getLsCodeStatus().equalsIgnoreCase("SUCCESS")){        
            return new ResponseEntity<>(loBean, HttpStatus.OK); // Return 200 OK with UserDTO
        }else{
            return new ResponseEntity<>(loBean,HttpStatus.NOT_IMPLEMENTED);
        }

	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListRelation")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog deleted"),
			@ApiResponse(responseCode = "201", description = "Catalog deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = RelationResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListRelation")
	public ResponseEntity<List<RelSelectResponseDTO>> getListRelation(@RequestBody RelSelectReqDTO loRelation) {

        List<RelSelectResponseDTO> laList = relationService.getListRelation(loRelation);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListRelationCat")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog deleted"),
			@ApiResponse(responseCode = "201", description = "Catalog deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = RelationResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListRelationCat")
	public ResponseEntity<List<RelConSelectResDTO>> getListRelationCat(@RequestBody RelConSelectReqDTO loRelationCat) {

        List<RelConSelectResDTO> laList = relationService.getListRelationCat(loRelationCat);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListRelationMainCat")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog deleted"),
			@ApiResponse(responseCode = "201", description = "Catalog deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = RelMainResponse.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListRelationMainCat")
	public ResponseEntity<List<RelMainResponse>> getListRelationMainCat(@RequestBody RelMainReq loRelMainReq) {

        List<RelMainResponse> laList = relationService.getListRelationMainCat(loRelMainReq);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}

}
