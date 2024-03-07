package com.wnra.carsforsale.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

    @Embedded
    private Veiculo veiculo;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(optional = false)
    private Usuario anunciante;

    @ElementCollection
    @Column(nullable = false)
    private Set<String> fotosUrl;
}
