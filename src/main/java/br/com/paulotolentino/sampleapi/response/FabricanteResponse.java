package br.com.paulotolentino.sampleapi.response;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto para retornar os dados de fabricante para o usuario. que chamou a controller
 * @author Paulo Tolentino
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FabricanteResponse {

	private Integer fabricanteId;
	private String razaoSocial;
	private String nomeFantasia;
	private Date dataCriacao;
	
}
