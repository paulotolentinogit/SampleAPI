package br.com.paulotolentino.sampleapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulotolentino.sampleapi.request.FabricanteRequest;
import br.com.paulotolentino.sampleapi.response.AcoesStatusResponse;
import br.com.paulotolentino.sampleapi.response.FabricanteResponse;
import br.com.paulotolentino.sampleapi.service.FabricanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Controller para fabricantes
 * @author Paulo Tolentino
 *
 */
@RestController
@Validated
@RequestMapping("fabricante")
@Api(value="Cadastro de fabricante")
public class FabricanteController {

	@Autowired
	private FabricanteService fabricanteService;
	
	/**
	 * Metodo para criar um novo fabricante
	 * @param fabricanteRequest
	 */
	@PostMapping
    @ApiOperation(value = "Criar fabricante")
	public ResponseEntity<?> addFabricante(@RequestBody FabricanteRequest fabricanteRequest) {
		
		fabricanteRequest.setFabricanteId(0);
		
		fabricanteService.salvar(fabricanteRequest);
		
		AcoesStatusResponse acoesStatusResponse = AcoesStatusResponse.builder().resultado("Fabricante Criado").build();
		
		return new ResponseEntity<AcoesStatusResponse>(acoesStatusResponse, HttpStatus.CREATED);
	}
	
	/**
	 * Metodo para alterar um fabricante
	 * @param fabricanteRequest
	 * @return
	 */
    @PutMapping()
    @ApiOperation(value = "alterar fabricante")
    public ResponseEntity<AcoesStatusResponse>  updateFabricante(@RequestBody FabricanteRequest fabricanteRequest){
    	
    	fabricanteService.salvar(fabricanteRequest);
    	
    	AcoesStatusResponse acoesStatusResponse = AcoesStatusResponse.builder().resultado("Fabricante alterado").build();
    	
    	return new ResponseEntity<AcoesStatusResponse>(acoesStatusResponse, HttpStatus.OK);
    }
    
    /**
     * lista todos os fabricantes
     * @return
     */
    @GetMapping()
    @ApiOperation(value = "listar fabricantes")
    public List<FabricanteResponse> getFabricante(){
    	
    	List<FabricanteResponse> lstFabricanteResponse = null;
    	lstFabricanteResponse = fabricanteService.listar();
    	
    	return lstFabricanteResponse;
    }
    
    /**
     * Busca um fabricante por seu id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "fabricante por Id")
    public FabricanteResponse getFabricanteById(Integer id){
    	
    	FabricanteResponse fabricanteResponse = null;
    	fabricanteResponse = fabricanteService.listarById(id);
    	return fabricanteResponse;
    }
    
    /**
     * Deleta um fabricante por seu id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleta fabricante por Id")
    public ResponseEntity<AcoesStatusResponse> deleteFabricanteById(Integer id){
    	
    	boolean acao  = fabricanteService.deleteById(id);
    	AcoesStatusResponse acoesStatusResponse ;
    	HttpStatus httpStatus;
    	if(acao){
    		acoesStatusResponse = AcoesStatusResponse.builder().resultado("Fabricante deletado").build();
    		httpStatus =  HttpStatus.OK;
    	}else{
    		acoesStatusResponse = AcoesStatusResponse.builder().resultado("Fabricante não encontrado").build();
    		httpStatus =  HttpStatus.NOT_FOUND;
    	}
    	
    	return new ResponseEntity<AcoesStatusResponse>(acoesStatusResponse,httpStatus);
    }
}
