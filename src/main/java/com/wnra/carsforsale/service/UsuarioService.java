package com.wnra.carsforsale.service;

import com.wnra.carsforsale.domain.Usuario;
import com.wnra.carsforsale.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
       return usuarioRepository.save(usuario);
    }
}
