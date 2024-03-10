package com.wnra.carsforsale.repository;

import com.wnra.carsforsale.domain.Anuncio;
import com.wnra.carsforsale.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, UUID> {
}
