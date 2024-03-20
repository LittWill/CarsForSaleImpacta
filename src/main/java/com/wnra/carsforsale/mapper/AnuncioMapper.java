package com.wnra.carsforsale.mapper;

import com.wnra.carsforsale.controller.anuncio.dto.EntradaAnuncioDTO;
import com.wnra.carsforsale.controller.anuncio.dto.SaidaAnuncioDTO;
import com.wnra.carsforsale.domain.Anuncio;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AnuncioMapper {
    Anuncio paraEntidade(EntradaAnuncioDTO entradaAnuncioDTO);

    SaidaAnuncioDTO paraSaidaDTO(Anuncio anuncio);

}