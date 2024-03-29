package com.wnra.carsforsale.service;

import com.wnra.carsforsale.domain.Marca;
import com.wnra.carsforsale.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public Marca salvarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca buscarMarca(UUID id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar a marca de ID: " + id));
    }

    public List<Marca> buscarMarcas() {
        return marcaRepository.findAll();
    }

    public Marca atualizarMarca(UUID id, Marca atualizada) {
        if (marcaRepository.existsById(id)) {
            atualizada.setId(id);
            return atualizada;
        }

        throw new RuntimeException("Não foi possível encontrar a marca de ID: " + id);
    }

    public void deletarMarca(UUID id) {
        marcaRepository.deleteById(id);
    }

}
