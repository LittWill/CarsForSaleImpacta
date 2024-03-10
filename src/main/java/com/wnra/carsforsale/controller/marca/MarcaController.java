package com.wnra.carsforsale.controller.marca;

import com.wnra.carsforsale.controller.marca.dto.EntradaMarcaDTO;
import com.wnra.carsforsale.controller.marca.dto.SaidaMarcaDTO;
import com.wnra.carsforsale.domain.Marca;
import com.wnra.carsforsale.mapper.MarcaMapper;
import com.wnra.carsforsale.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("marcas")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;

    private final MarcaMapper marcaMapper;

    @PostMapping
    public ResponseEntity<SaidaMarcaDTO> salvarMarca(@RequestBody EntradaMarcaDTO entradaMarcaDTO) {
        Marca marcaSalva = marcaService.salvarMarca(marcaMapper.paraEntidade(entradaMarcaDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaMapper.paraSaidaDTO(marcaSalva));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaidaMarcaDTO> buscarMarca(@PathVariable UUID id) {
        return ResponseEntity.ok(marcaMapper.paraSaidaDTO(marcaService.buscarMarca(id)));
    }

    @GetMapping
    public ResponseEntity<List<SaidaMarcaDTO>> buscarMarcas() {
        List<SaidaMarcaDTO> marcas = marcaService.buscarMarcas().stream().map(marcaMapper::paraSaidaDTO).toList();
        return ResponseEntity.ok(marcas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaidaMarcaDTO> atualizarMarca(@PathVariable UUID id,
                                                        @RequestBody EntradaMarcaDTO entradaMarcaDTO) {
        Marca marcaAtualizada = marcaService.atualizarMarca(id, marcaMapper.paraEntidade(entradaMarcaDTO));
        return ResponseEntity.ok(marcaMapper.paraSaidaDTO(marcaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMarca(@PathVariable UUID id) {
        marcaService.deletarMarca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
