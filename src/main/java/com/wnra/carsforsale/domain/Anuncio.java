package com.wnra.carsforsale.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Anuncio {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(optional = false)
    private Usuario anunciante;

    @ElementCollection
    @Column(nullable = false)
    private Set<String> fotosUrl;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoNegociacao tipoNegociacao;

    public enum TipoNegociacao {
        VENDA, TROCA, AMBOS
    }
}
