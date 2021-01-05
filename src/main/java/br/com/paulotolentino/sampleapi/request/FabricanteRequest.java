package br.com.paulotolentino.sampleapi.request;



import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto de request para enviar os dados de fabricante para controller
 * @author Paulo Tolentino
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FabricanteRequest {

	@ApiModelProperty(value = "id",required = false,position = 1)
	private Integer fabricanteId;
	
	@ApiModelProperty(value = "Razao Social",required = true,position = 2)
	@NotNull
	private String razaoSocial;
	
	@ApiModelProperty(value = "Nome Fantasia",required = true,position = 3)
	@NotNull
	private String nomeFantasia;
	
	@ApiModelProperty(value = "dataCriacao",required = true,position = 4, example = "2020-11-16T04:25:03Z")
	@NotNull
	private Date dataCriacao;
	
}
