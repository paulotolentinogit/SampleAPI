package br.com.paulotolentino.sampleapi.model;

import java.util.Date;

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
 * Model para a tabela FABRICANTE
 * @author Paulo Tolentino
 *
 */
@Entity
@Table(name = "FABRICANTE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Fabricante {

    @Id
    @NotNull
    @Column(name = "FABRICANTE_ID")
    @SequenceGenerator(name = "fabricanteSeqGenerator", sequenceName = "SEQ_FABRICANTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fabricanteSeqGenerator")
    private Integer fabricanteId;
    
    @NotNull
    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;
    
    @NotNull
    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;
    
    @NotNull
    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;
    
    

}
