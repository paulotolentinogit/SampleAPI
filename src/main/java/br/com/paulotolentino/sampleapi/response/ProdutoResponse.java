package br.com.paulotolentino.sampleapi.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto para retornar os dados de produto para o usuario. que chamou a controller
 * @author Paulo Tolentino
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProdutoResponse {


	private Integer produtoId;    
	private Integer fabricanteId;
	private String descricao;
	private Integer quantidade;
}
