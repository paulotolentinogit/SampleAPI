package br.com.paulotolentino.sampleapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paulotolentino.sampleapi.model.Produto;
import br.com.paulotolentino.sampleapi.repository.ProdutoRepository;
import br.com.paulotolentino.sampleapi.request.ProdutoRequest;
import br.com.paulotolentino.sampleapi.response.ProdutoResponse;

/**
 * Camada de serviço para tratar Produto
 * @author Paulo Tolentino
 *
 */
@Service
public class ProdutoService {

	/**
	 * instancia do objeto de respositorio para manipulação de produto
	 */
	@Autowired
	private ProdutoRepository produtoRepository;
	
	/**
	 * Salva um produto
	 * @param produtoRequest
	 */
	public void salvarProduto(ProdutoRequest  produtoRequest) {
		
		Produto produto = null;
		
		if(produtoRequest.getProdutoId() > 0) {
			Optional<Produto> optProduto = produtoRepository.findById(produtoRequest.getProdutoId());
			if(!optProduto.isEmpty()) {
				produto = optProduto.get();
				produto.setDescricao(produtoRequest.getDescricao());
				produto.setFabricanteId(produtoRequest.getFabricanteId());
				produto.setQuantidade(produtoRequest.getQuantidade());
			}
		}else {
			produto = mapperProdutoRequestToModel(produtoRequest);
		}
		produtoRepository.save(produto);
				
	}
	
	/**
	 * Lista todos os produtos
	 * @return
	 */
	public List<ProdutoResponse> listar() {
		
		List<ProdutoResponse> lstProdutoResponses = new ArrayList();
		List<Produto> lstproduto =	(List<Produto>) produtoRepository.findAll();

		for (Produto produto : lstproduto) {
			lstProdutoResponses.add(mapperProdutoModelToResponse(produto));
		}		
		
		return lstProdutoResponses;
	}

	/**
	 * busca m produto por seu id
	 * @param Id
	 * @return
	 */
	public ProdutoResponse listarById(Integer Id) {

		Optional<Produto> optproduto =	produtoRepository.findById(Id);

		if(!optproduto.isEmpty())
			return mapperProdutoModelToResponse(optproduto.get());
		else
			return null;
	}

	/**
	 * busca todos os produtos de um determinado fabricante.
	 * @param fabricanteId
	 * @return
	 */
	public List<ProdutoResponse> listarByFabricante(Integer fabricanteId) {
		
		List<ProdutoResponse> lstProdutoResponses = new ArrayList();
		List<Produto> lstproduto =	(List<Produto>) produtoRepository.findByFabricanteId(fabricanteId);

		for (Produto produto : lstproduto) {
			lstProdutoResponses.add(mapperProdutoModelToResponse(produto));
		}		
		
		return lstProdutoResponses;
	}
	
	/**
	 * @param produto
	 * @return
	 */
	private ProdutoResponse mapperProdutoModelToResponse(Produto produto) {
		return ProdutoResponse.builder()
				.produtoId(produto.getProdutoId())
				.fabricanteId(produto.getFabricanteId())
				.descricao(produto.getDescricao())
				.quantidade(produto.getQuantidade())
				.build();
	}
	
	/**
	 * @param produtoRequest
	 * @return
	 */
	private Produto mapperProdutoRequestToModel(ProdutoRequest produtoRequest) {
		return Produto.builder()
		.produtoId(produtoRequest.getProdutoId())
		.descricao(produtoRequest.getDescricao())
		.fabricanteId(produtoRequest.getFabricanteId())
		.quantidade(produtoRequest.getQuantidade())
		.build();
	}
}
