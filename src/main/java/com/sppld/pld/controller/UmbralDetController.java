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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.sppld.pld.dto.UmDetSelectResDTO;
import com.sppld.pld.dto.UmDetSelectReqDTO;
import com.sppld.pld.dto.CatalogResponseDTO;
import com.sppld.pld.dto.UmbralDetDTO;
import com.sppld.pld.dto.UmbralDetResponseDTO;
import com.sppld.pld.service.UmbralDetService;

@RestController
@Tag(name = "SPPLD", description = "Controlador de servicios para Detalle de Umbral de Reglas")
@RequestMapping("/api/umbralDet")
public class UmbralDetController {
	
	@Autowired
	private UmbralDetService loService;
	
	public static final String URL_SERVER_FRONT = "http://localhost:4200";

    @CrossOrigin(origins = URL_SERVER_FRONT)
    @Operation(summary = "crudUmbralDet")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Umbral Detail created"),
			@ApiResponse(responseCode = "201", description = "Catalog created", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UmbralDetResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("crudUmbralDet")
	public ResponseEntity<UmbralDetResponseDTO> crudUmbralDet(@RequestBody UmbralDetDTO loUmbralDetDTO) {

    	UmbralDetResponseDTO loBean = loService.crudUmbralDet(loUmbralDetDTO);
        
		if(loBean.getLsCodeStatus().equalsIgnoreCase("SUCCESS")){        
            return new ResponseEntity<>(loBean, HttpStatus.OK); // Return 200 OK with UserDTO
        }else{
            return new ResponseEntity<>(loBean,HttpStatus.NOT_IMPLEMENTED);
        }

	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListUmbralDet")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog deleted"),
			@ApiResponse(responseCode = "201", description = "Catalog deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CatalogResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListUmbralDet")
	public ResponseEntity<List<UmDetSelectResDTO>> getListUmbralDet(@RequestBody UmDetSelectReqDTO loUmDetSelectReqDTO) {

        List<UmDetSelectResDTO> laList = loService.getListUmbralDet(loUmDetSelectReqDTO);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}


}
