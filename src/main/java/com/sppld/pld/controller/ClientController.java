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


import com.sppld.pld.service.ClientPpldService;
import com.sppld.pld.dto.ClientListResDTO;
import com.sppld.pld.dto.ClientListReqDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "SPPLD", description = "Controlador de servicios para Clientes")
@RequestMapping("/api/clientPpld")
public class ClientController {
	
	@Autowired
	private ClientPpldService clientPpldService;
    
    public static final String URL_SERVER_FRONT = "http://localhost:4200";

    @CrossOrigin(origins = URL_SERVER_FRONT)
    @Operation(summary = "getListClientsPpld")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog created"),
			@ApiResponse(responseCode = "201", description = "Catalog created", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ClientListResDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListClientsPpld")
    public ResponseEntity<List<ClientListResDTO>> getListClients(@RequestBody ClientListReqDTO loClientListReqDTO) {    	
        List<ClientListResDTO> laList = clientPpldService.getListClients(loClientListReqDTO);
        return new ResponseEntity<>(laList, HttpStatus.OK);        
	}    

}
