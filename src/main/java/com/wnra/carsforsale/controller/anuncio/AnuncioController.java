package com.wnra.carsforsale.controller.anuncio;

import com.wnra.carsforsale.controller.anuncio.dto.EntradaAnuncioDTO;
import com.wnra.carsforsale.controller.anuncio.dto.SaidaAnuncioDTO;
import com.wnra.carsforsale.domain.Anuncio;
import com.wnra.carsforsale.mapper.AnuncioMapper;
import com.wnra.carsforsale.service.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("anuncios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AnuncioController {

    private final AnuncioService anuncioService;

    private final AnuncioMapper anuncioMapper;

    @PostMapping
    public ResponseEntity<SaidaAnuncioDTO> salvarAnuncio(@RequestBody EntradaAnuncioDTO entradaAnuncioDTO) {
        Anuncio anuncioSalvo = anuncioService.salvarAnuncio(anuncioMapper.paraEntidade(entradaAnuncioDTO));
        return ResponseEntity.ok(anuncioMapper.paraSaidaDTO(anuncioSalvo));
    }

    @GetMapping
    public ResponseEntity<List<SaidaAnuncioDTO>> listarAnuncios() {
        List<SaidaAnuncioDTO> anuncios = anuncioService.listarAnuncios().stream().map(anuncioMapper::paraSaidaDTO).toList();
        return ResponseEntity.ok(anuncios);
    }
}
