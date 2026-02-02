package com.sppld.pld.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.sppld.pld.dto.CatSelectReqDTO;
import com.sppld.pld.dto.CatSelectResponseDTO;
import com.sppld.pld.dto.CatalogDTO;
import com.sppld.pld.dto.CatalogResponseDTO;
import com.sppld.pld.dto.ConceptRelReqDTO;
import com.sppld.pld.dto.ExcelCatalogDTO;

import com.sppld.pld.service.CatalogService;

@RestController
@Tag(name = "SPPLD", description = "Controlador de servicios para Catalogos")
@RequestMapping("/api/catalog")
public class CatalogController {

    @Autowired
	private CatalogService catalogService;
    
    
    public static final String URL_SERVER_FRONT = "http://localhost:4200";

    @CrossOrigin(origins = URL_SERVER_FRONT)
    @Operation(summary = "saveCatalog")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog created"),
			@ApiResponse(responseCode = "201", description = "Catalog created", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CatalogResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("saveCatalog")
	public ResponseEntity<CatalogResponseDTO> saveCatalog(@RequestBody CatalogDTO loCatalog) {

        CatalogResponseDTO loBean = catalogService.saveCatalog(loCatalog);

        if(loBean.getLsCodeStatus().equalsIgnoreCase("SUCCESS")){        
            return new ResponseEntity<>(loBean, HttpStatus.OK); // Return 200 OK with UserDTO
        }else{
            return new ResponseEntity<>(loBean,HttpStatus.NOT_IMPLEMENTED);
        }

	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "updateCatalog")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog updated"),
			@ApiResponse(responseCode = "201", description = "Catalog updated", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CatalogResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("updateCatalog")
	public ResponseEntity<CatalogResponseDTO> updateCatalog(@RequestBody CatalogDTO loCatalog) {

        CatalogResponseDTO loBean = catalogService.updateCatalog(loCatalog);

        if(loBean.getLsCodeStatus().equalsIgnoreCase("SUCCESS")){        
            return new ResponseEntity<>(loBean, HttpStatus.OK); // Return 200 OK with UserDTO
        }else{
            return new ResponseEntity<>(loBean,HttpStatus.NOT_IMPLEMENTED);
        }

	}
    
    @CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "deleteCatalog")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog deleted"),
			@ApiResponse(responseCode = "201", description = "Catalog deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CatalogResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("deleteCatalog")
	public ResponseEntity<CatalogResponseDTO> deleteCatalog(@RequestBody CatalogDTO loCatalog) {
    	
        CatalogResponseDTO loBean = catalogService.deleteCatalog(loCatalog);

        if(loBean.getLsCodeStatus().equalsIgnoreCase("SUCCESS")){        
            return new ResponseEntity<>(loBean, HttpStatus.OK); // Return 200 OK with UserDTO
        }else{
            return new ResponseEntity<>(loBean,HttpStatus.NOT_IMPLEMENTED);
        }

	}

	@CrossOrigin(origins = URL_SERVER_FRONT)
	@Operation(summary = "getListCatalog")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog deleted"),
			@ApiResponse(responseCode = "201", description = "Catalog deleted", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CatalogResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("getListCatalog")
	public ResponseEntity<List<CatSelectResponseDTO>> getListCatalog(@RequestBody CatSelectReqDTO loCatalog) {

        List<CatSelectResponseDTO> laList = catalogService.getListCatalog(loCatalog);

        return new ResponseEntity<>(laList, HttpStatus.OK);
        

	}
	
	@CrossOrigin(origins = URL_SERVER_FRONT)
    @Operation(summary = "crudConceptRel")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Catalog created"),
			@ApiResponse(responseCode = "201", description = "Catalog created", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "401", description = "User is not authorized for service", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CatalogResponseDTO.class, example = "{\"OutputPushTrackingItem\":{\"Code\":\"101\",\"CodeDescription\":\"Fallido\"}}"))),
			@ApiResponse(responseCode = "403", description = "Forbiden for user access", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "404", description = "Resource not found", content = @io.swagger.v3.oas.annotations.media.Content()),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @io.swagger.v3.oas.annotations.media.Content()) })
	@PostMapping("crudConceptRel")
	public ResponseEntity<CatalogResponseDTO> crudConceptRel(@RequestBody ConceptRelReqDTO loConceptRelReqDTO) {
		
        CatalogResponseDTO loBean = catalogService.crudConceptRel(loConceptRelReqDTO);
        if(loBean.getLsCodeStatus().equalsIgnoreCase("SUCCESS") || loBean.getLsCodeStatus().equalsIgnoreCase("ERR")){
            return new ResponseEntity<>(loBean, HttpStatus.OK); // Return 200 OK with UserDTO
        }else{
            return new ResponseEntity<>(loBean,HttpStatus.NOT_IMPLEMENTED);
        }

	}
	
	@CrossOrigin(origins = URL_SERVER_FRONT)
	@PostMapping("/upload")
	public ResponseEntity<CatalogResponseDTO> uploadFile(@RequestParam("file") MultipartFile file, 
			                                             @RequestParam("idConceptUp") Integer idConceptUp,
			                                             @RequestParam("idApplication") Integer idApplication,
			                                             @RequestParam("idCompany") Integer idCompany,
			                                             @RequestParam("username") String username,
			                                             
			                                             @RequestParam("idConceptDown") Integer idConceptDown,
			                                             @RequestParam("idRelation") Integer idRelation,
			                                             
			                                             @RequestParam("indNivel") Integer indNivel,
			                                             @RequestParam("operationType") Integer operationType,
			                                             @RequestParam("attribute1") Integer attribute1
			                                            ) {
		CatalogResponseDTO loBean = new CatalogResponseDTO();
		List<ExcelCatalogDTO> laList = new ArrayList<ExcelCatalogDTO>();
		System.out.println("attribute1["+attribute1+"]");
		if(attribute1 == 0) {
			
			try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
		        Sheet sheet = workbook.getSheetAt(0);
		        for (Row row : sheet) {
		        	ExcelCatalogDTO loExcelCatalogDTO = new ExcelCatalogDTO();
		        	loExcelCatalogDTO.setLsCatalogo(row.getCell(0).getStringCellValue());
		        	loExcelCatalogDTO.setLiValor(row.getCell(1).getNumericCellValue());
		        	laList.add(loExcelCatalogDTO);
		        }	   
		        
		        for(int liI = 0; liI < laList.size(); liI++) {
		        	System.out.println("laList.get(liI).getLsAttribute1()["+laList.get(liI).getLsAttribute1()+"]");
		        	System.out.println("laList.get(liI).getLsCatalogo()["+laList.get(liI).getLsCatalogo()+"]");
		        	System.out.println("laList.get(liI).getLiValor()["+laList.get(liI).getLiValor()+"]");
		        	ConceptRelReqDTO loConceptRelReqDTO = new ConceptRelReqDTO();
		        	loConceptRelReqDTO.setLiIdConceptUp(idConceptUp);
		        	loConceptRelReqDTO.setLiIdApplication(idApplication);
		        	loConceptRelReqDTO.setLiIdCompany(idCompany);
		        	loConceptRelReqDTO.setLsUsername(username);
		        	loConceptRelReqDTO.setLiIdConceptDown(idConceptDown);
		        	loConceptRelReqDTO.setLiIdRelation(idRelation);
		        	loConceptRelReqDTO.setLsNomCatalog(laList.get(liI).getLsCatalogo());
		        	loConceptRelReqDTO.setLiIndValue(laList.get(liI).getLiValor());
		        	loConceptRelReqDTO.setLiIndNivel(indNivel);
		        	loConceptRelReqDTO.setLiOperationType(operationType);	        	
		        	catalogService.crudConceptRel(loConceptRelReqDTO);		        	
		        	
		        }
		        loBean.setLsCodeStatus("SUCCESS");
				loBean.setLsCodeDescription("SUCCESS");
		    } catch (IOException e) {	        
		        loBean.setLsCodeStatus("ERROR");
				loBean.setLsCodeDescription(e.getMessage());
		    }
		}
		else {
			try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
		        Sheet sheet = workbook.getSheetAt(0);
		        for (Row row : sheet) {
		        	ExcelCatalogDTO loExcelCatalogDTO = new ExcelCatalogDTO();
		        	loExcelCatalogDTO.setLsAttribute1(row.getCell(0).getStringCellValue());
		        	loExcelCatalogDTO.setLsCatalogo(row.getCell(1).getStringCellValue());
		        	loExcelCatalogDTO.setLiValor(row.getCell(2).getNumericCellValue());
		        	laList.add(loExcelCatalogDTO);
		        }	   
		        
		        for(int liI = 0; liI < laList.size(); liI++) {
		        	
		        	System.out.println("laList.get(liI).getLsAttribute1()["+laList.get(liI).getLsAttribute1()+"]");
		        	System.out.println("laList.get(liI).getLsCatalogo()["+laList.get(liI).getLsCatalogo()+"]");
		        	System.out.println("laList.get(liI).getLiValor()["+laList.get(liI).getLiValor()+"]");
		        	ConceptRelReqDTO loConceptRelReqDTO = new ConceptRelReqDTO();
		        	loConceptRelReqDTO.setLiIdConceptUp(idConceptUp);
		        	loConceptRelReqDTO.setLiIdApplication(idApplication);
		        	loConceptRelReqDTO.setLiIdCompany(idCompany);
		        	loConceptRelReqDTO.setLsUsername(username);
		        	loConceptRelReqDTO.setLiIdConceptDown(idConceptDown);
		        	loConceptRelReqDTO.setLiIdRelation(idRelation);
		        	loConceptRelReqDTO.setLsNomCatalog(laList.get(liI).getLsCatalogo());
		        	loConceptRelReqDTO.setLiIndValue(laList.get(liI).getLiValor());
		        	loConceptRelReqDTO.setLiIndNivel(indNivel);
		        	loConceptRelReqDTO.setLiOperationType(operationType);
		        	loConceptRelReqDTO.setLsAttribute1(laList.get(liI).getLsAttribute1());
		        	catalogService.crudConceptRel(loConceptRelReqDTO);
		        	
		        }
		        loBean.setLsCodeStatus("SUCCESS");
				loBean.setLsCodeDescription("SUCCESS");
		    } catch (IOException e) {	        
		        loBean.setLsCodeStatus("ERROR");
				loBean.setLsCodeDescription(e.getMessage());
		    }
		}
		return new ResponseEntity<>(loBean, HttpStatus.OK);
		
	}



}
