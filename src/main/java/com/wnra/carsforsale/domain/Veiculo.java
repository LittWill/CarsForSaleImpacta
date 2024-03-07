package com.wnra.carsforsale.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Column(nullable = false)
    private String modelo;

    @ManyToOne(optional = false)
    private Marca marca;

    @Column(nullable = false)
    private Double kmRodados;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String ano;

    @Column(nullable = false)
    private TipoCombustivel tipoCombustivel;

    @Column(nullable = false)
    private String cor;

    public enum TipoCombustivel {
        GASOLINA, DIESEL, FLEX, ELETRICO, HIBRIDO
    }


}
