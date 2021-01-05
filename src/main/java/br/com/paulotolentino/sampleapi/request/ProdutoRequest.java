package br.com.paulotolentino.sampleapi.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto para enviar os dados de produto para a controller.
 * @author Paulo Tolentino
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProdutoRequest {

	@ApiModelProperty(value = "id",required = false,position = 1)
	private Integer produtoId; 
	
	@ApiModelProperty(value = "id",required = true,position = 2)
	private Integer fabricanteId;
	
	@ApiModelProperty(value = "descricao",required = true,position = 3)
	private String descricao;
	
	@ApiModelProperty(value = "quantidade",required = true,position = 4)
	private Integer quantidade;
}
