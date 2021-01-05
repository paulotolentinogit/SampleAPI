package br.com.paulotolentino.sampleapi.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * API Response para acoes (add, update, delete)
 * @author Paulo Tolentino
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ApiModel
public class AcoesStatusResponse {

    @ApiModelProperty(value = "Resultados das ações")
    private String resultado;
}


