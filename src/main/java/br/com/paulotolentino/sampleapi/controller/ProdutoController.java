package br.com.paulotolentino.sampleapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulotolentino.sampleapi.request.ProdutoRequest;
import br.com.paulotolentino.sampleapi.response.ProdutoResponse;
import br.com.paulotolentino.sampleapi.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * controller para produtos
 * @author Paulo Tolentino
 *
 */
@RestController
@Validated
@RequestMapping("produto")
@Api(value="Cadastro de produto")
public class ProdutoController {

	/**
	 * instacia do camada de serviço para produtos
	 */
	@Autowired
	private ProdutoService produtoService;
	
	/**
	 * Metodo para criar um novo produto
	 * @param produtoRequest
	 */
	@PostMapping
    @ApiOperation(value = "Criar produto")
	public void addProduto(@RequestBody ProdutoRequest produtoRequest) {
		produtoService.salvarProduto(produtoRequest);
	}
	
	/**
	 * Metodo para alterar um novo produto
	 * @param produtoRequest
	 */
    @PutMapping()
    @ApiOperation(value = "alterar produto")
    public void updateProduto(@RequestBody ProdutoRequest produtoRequest) {
		produtoService.salvarProduto(produtoRequest);
	}
	
    /**
     * lista todos os produtos de todos os fabricantes, sem filtro
     * @return
     */
    @GetMapping()
    @ApiOperation(value = "listar produtos")
    public List<ProdutoResponse> getFabricante(){
    	
    	List<ProdutoResponse> lstProdutoResponse = null;
    	lstProdutoResponse = produtoService.listar();
    	return lstProdutoResponse;
    }
    
    /**
     * Retorna um produto por seu id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "produto por Id")
    public ProdutoResponse getProdutoById(Integer id){
    	
    	ProdutoResponse produtoResponse = null;
    	produtoResponse = produtoService.listarById(id);
    	return produtoResponse;
    }
    
    /**
     * lista todos os produtos de um fabricantes, filtro id do fabricante
     * @param id
     * @return
     */
    @GetMapping("/{id}/fabricante")
    @ApiOperation(value = "produtos por FabricanteId")
    public List<ProdutoResponse> getFabricanteById(Integer id){
    	
    	List<ProdutoResponse> lstProdutoResponse = null;
    	lstProdutoResponse = produtoService.listarByFabricante(id);
    	return lstProdutoResponse;
    }
}
