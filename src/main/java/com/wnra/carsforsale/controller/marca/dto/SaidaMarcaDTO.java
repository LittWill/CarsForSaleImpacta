package com.wnra.carsforsale.controller.marca.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.wnra.carsforsale.domain.Marca}
 */
public record SaidaMarcaDTO(UUID id, String nome, LocalDateTime dataCriacao, String fotoUrl) implements Serializable {
}