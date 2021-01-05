package br.com.paulotolentino.sampleapi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ApiParceiro {

	private static final Logger LOGGER = LogManager.getLogger(ApiParceiro.class.getName());
	
	public RestTemplate restTemplate = new RestTemplateBuilder().build();
	
	public Boolean PesquisaNomeFantasia(String nomeFantasia) {
		
		LOGGER.info("Entrando PesquisaNomeFantasia: nomeFantasia[{}].", nomeFantasia);
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://servicoparceiro.com.br")
				.pathSegment("pesquisa", nomeFantasia)
				.queryParam("existe","false");
		
		String uri = uriBuilder.build().toUri().toString();
		
		String ret = restTemplate.exchange(uri, HttpMethod.GET, null, String.class).getBody();
		
		LOGGER.info("Saindo PesquisaNomeFantasia: ret[{}].", ret);
		
		return ret.equals("existe");
	}
}
