package br.com.paulotolentino.sampleapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.paulotolentino.sampleapi.model.Fabricante;
import br.com.paulotolentino.sampleapi.repository.FabricanteRepository;
import br.com.paulotolentino.sampleapi.request.FabricanteRequest;
import br.com.paulotolentino.sampleapi.response.FabricanteResponse;

/**
 * Implementação da camada de serviço para operações com o objeto de fabricante
 * @author Paulo Tolentino
 *
 */
@Service
public class FabricanteService {

	private static final Logger LOGGER = LogManager.getLogger(FabricanteService.class.getName());
			
	/**
	 * Instancia da repository de fabricante
	 */
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	/**
	 * realiza a persistencia de um facricante. utilizado nos metodos de criar e alterar.
	 * @param fabricanteRequest
	 * @return
	 */
	public FabricanteResponse salvar(FabricanteRequest fabricanteRequest) {
		
		LOGGER.info("Entrando Fabricante salvar: fabricanteRequest[{}].", fabricanteRequest);
		
		Fabricante fabricante = null;
		
		if(fabricanteRequest.getFabricanteId() > 0) {
			Optional<Fabricante> optfabricante = fabricanteRepository.findById(fabricanteRequest.getFabricanteId());
			if(!optfabricante.isEmpty()) {
				fabricante = optfabricante.get();
				fabricante.setNomeFantasia(fabricanteRequest.getNomeFantasia());
				fabricante.setRazaoSocial(fabricanteRequest.getRazaoSocial());
				fabricante.setDataCriacao(fabricanteRequest.getDataCriacao());
			}
		}else {		
			fabricante = mapperFabricanteRequestToModel(fabricanteRequest);
		}
		
		fabricanteRepository.save(fabricante);
		
		FabricanteResponse fabricanteResponse = mapperFabricanteModelToResponse(fabricante);
		LOGGER.info("saindo Fabricante salvar: fabricanteResponse[{}].", fabricanteResponse);
		
		return fabricanteResponse;
	}
	
	/**
	 * Lista todos os fabricantes
	 * @return
	 */
	public List<FabricanteResponse> listar() {
		
		List<Fabricante> lstFabricantes = new ArrayList();
		List<FabricanteResponse> lstFabricanteResponse = new ArrayList();
		
		lstFabricantes = (List<Fabricante>) fabricanteRepository.findAll();
		
		for (Fabricante fabricante : lstFabricantes) {
			lstFabricanteResponse.add(mapperFabricanteModelToResponse(fabricante));
		}

		return lstFabricanteResponse;
	}
	
	/**
	 * Busca um fabricante por seu id
	 * @param id
	 * @return
	 */
	public FabricanteResponse listarById(Integer id) {
		
		Optional<Fabricante> optFabricante = fabricanteRepository.findById(id);
		
		if(!optFabricante.isEmpty())
			return mapperFabricanteModelToResponse(optFabricante.get());
		else
			return null;
	}
	/**
	 * Busca um fabricante por seu id
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id) {
		
		Optional<Fabricante> optFabricante = fabricanteRepository.findById(id);
		
		if(!optFabricante.isEmpty()) {
			fabricanteRepository.delete(optFabricante.get());
			return true;
		}		
		else
			return false;
	}
	
	/**
	 * mapper de objetis de request para model. utilizado para construir objetos antes de salvar
	 * @param fabricanteRequest
	 * @return
	 */
	private Fabricante mapperFabricanteRequestToModel(FabricanteRequest fabricanteRequest) {
		LOGGER.info("mapperFabricanteRequestToModel: FabricanteRequest[{}].", fabricanteRequest);
		
		Fabricante fabricante;
		fabricante = Fabricante.builder()
				.nomeFantasia(fabricanteRequest.getNomeFantasia())
				.razaoSocial(fabricanteRequest.getRazaoSocial())
				.dataCriacao(fabricanteRequest.getDataCriacao()).build();
		
		LOGGER.info("mapperFabricanteRequestToModel: Fabricante[{}].", fabricante);
		return fabricante;
	}
	
	/**
	 * mapper de fabricantes, utilizado para transformar os dados retornados do banco para o objeto de response.
	 * @param fabricante
	 * @return
	 */
	private FabricanteResponse mapperFabricanteModelToResponse(Fabricante fabricante) {
		
		LOGGER.info("mapperFabricanteModelToResponse: Fabricante[{}].", fabricante);
		
		FabricanteResponse fabricanteResponse;
		
		fabricanteResponse = FabricanteResponse.builder()
		.fabricanteId(fabricante.getFabricanteId())
		.razaoSocial(fabricante.getRazaoSocial())
		.nomeFantasia(fabricante.getNomeFantasia())
		.dataCriacao(fabricante.getDataCriacao())
		.build();
		
		LOGGER.info("mapperFabricanteModelToResponse: FabricanteResponse[{}].", fabricanteResponse);
		
		return fabricanteResponse;
	}
	
	

}
