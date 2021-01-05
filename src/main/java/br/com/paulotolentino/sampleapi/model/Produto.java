package br.com.paulotolentino.sampleapi.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model para a tabela PRODUTO
 * @author Paulo Tolentino
 *
 */
@Entity
@Table(name = "PRODUTO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Produto {
	
    @Id
    @NotNull
    @Column(name = "PRODUTO_ID")
    @SequenceGenerator(name = "produtoSeqGenerator", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoSeqGenerator")
    private Integer produtoId;
    
    @NotNull
    @Column(name = "FABRICANTE_ID")
    private Integer fabricanteId;

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @NotNull
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    
    
}
