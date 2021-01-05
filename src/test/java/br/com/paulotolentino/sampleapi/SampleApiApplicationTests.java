package br.com.paulotolentino.sampleapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.paulotolentino.sampleapi.repository.FabricanteRepository;
import br.com.paulotolentino.sampleapi.request.FabricanteRequest;
import br.com.paulotolentino.sampleapi.response.FabricanteResponse;
import br.com.paulotolentino.sampleapi.service.ApiParceiro;
import br.com.paulotolentino.sampleapi.service.FabricanteService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SampleApiApplicationTests {

	@InjectMocks
	FabricanteService fabricanteService;
	
	@Mock
	FabricanteRepository fabricanteRepository;
	
	@InjectMocks
	ApiParceiro apiParceiro;
	
	@Mock
	RestTemplate restTemplate;
	
	@Test
	void mappersTest() {
		
		FabricanteRequest fr = FabricanteRequest.builder()
				.nomeFantasia("Coca Cola SA")
				.razaoSocial("Coca Cola Venda LTDA")
				.fabricanteId(0)
				.dataCriacao(new Date())
				.build();
		
		FabricanteResponse fabResp = fabricanteService.salvar(fr);
		
		assertEquals(fr.getNomeFantasia(), fabResp.getNomeFantasia());
		assertEquals(fr.getRazaoSocial(), fabResp.getRazaoSocial());
	}
	
	@Test
	void servicoTest() {
		
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("existe", HttpStatus.OK);
		
		when(restTemplate.exchange(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<String>>any()))
             .thenReturn(responseEntity);
		
		Boolean resultado = apiParceiro.PesquisaNomeFantasia("Coca Cola SA");
		
		assertEquals(Boolean.TRUE, resultado);
	}

}
