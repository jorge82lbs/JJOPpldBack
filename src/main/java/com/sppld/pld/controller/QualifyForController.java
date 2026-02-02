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
import com.sppld.pld.dto.QualifyReqDTO;
import com.sppld.pld.dto.QualifyResDTO;
import com.sppld.pld.service.QualifyForService;
import com.sppld.pld.dto.QualifyListResDTO;
import com.sppld.pld.dto.QualifyListReqDTO;
import com.sppld.pld.dto.QualifyListMainResDTO;
import com.sppld.pld.dto.QualifyListMainReqDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "SPPLD", description = "Controlador de servicios para Calificacion de Clientes")
@RequestMapping("/api/qualifyfor")
public class QualifyForController {

	@Autowired
	private QualifyForService qualifyForService;
    
    public static final String URL_SERVER_FRONT = "http://localhost:4200";

    @CrossOrigin(origins = URL_SERVER_FRONT)
    @Operation(summary = "crudQualifyFor")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "QualifyFor created"),
			@ApiResponse(responseCode = "201", description = "QualifyFor created", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = QualifyResDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("crudQualifyFor")
    public ResponseEntity<QualifyResDTO> crudQualifyFor(@RequestBody QualifyReqDTO loQualifyResDTO) {
    	System.out.println("QualifyController");
    	QualifyResDTO loBean = qualifyForService.crudQualifyFor(loQualifyResDTO);
    	return new ResponseEntity<>(loBean, HttpStatus.OK);
        /*if(loBean.getLsCodeStatus().equalsIgnoreCase("SUCCESS")){        
            return new ResponseEntity<>(loBean, HttpStatus.OK); 
        }else{
            return new ResponseEntity<>(loBean,HttpStatus.NOT_IMPLEMENTED);
        }*/

	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListQualifyFor")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Qualify deleted"),
			@ApiResponse(responseCode = "201", description = "Qualify deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CatalogResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListQualifyFor")
	public ResponseEntity<List<QualifyListResDTO>> getListQualifyFor(@RequestBody QualifyListReqDTO loQualifyListResDTO) {

        List<QualifyListResDTO> laList = qualifyForService.getListQualify(loQualifyListResDTO);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListMainQualifyFor")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Qualify deleted"),
			@ApiResponse(responseCode = "201", description = "Qualify deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CatalogResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListMainQualifyFor")
	public ResponseEntity<List<QualifyListMainResDTO>> getListMainQualifyFor(@RequestBody QualifyListMainReqDTO loQualifyListMainResDTO) {

        List<QualifyListMainResDTO> laList = qualifyForService.getListMainQualify(loQualifyListMainResDTO);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}
}
