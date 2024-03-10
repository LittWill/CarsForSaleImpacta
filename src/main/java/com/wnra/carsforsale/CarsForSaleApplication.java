package com.wnra.carsforsale;

import com.wnra.carsforsale.domain.*;
import com.wnra.carsforsale.repository.AnuncioRepository;
import com.wnra.carsforsale.repository.MarcaRepository;
import com.wnra.carsforsale.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class CarsForSaleApplication implements CommandLineRunner {

	private final AnuncioRepository anuncioRepository;

	private final MarcaRepository marcaRepository;

	private final UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarsForSaleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Marca nissan = Marca.builder().nome("Nissan").fotoUrl("https://www.freepnglogos.com/uploads/nissan-logo-2.png").dataCriacao(LocalDateTime.now()).build();

		Usuario wilson = Usuario.builder()
				.email("wilson@email.com")
				.dataCadastro(LocalDateTime.now())
				.primeiroNome("Wilson").ultimoNome("de Almeida")
				.endereco(Endereco.builder()
						.cep("05892335")
						.cidade("São Paulo")
						.estado("SP")
						.numero("1001")
						.endereco("Travessa Maria Isabel Novais Braga")
						.build()).build();

		Anuncio nissanMarch = Anuncio.builder()
				.anunciante(wilson)
				.tipoNegociacao(Anuncio.TipoNegociacao.VENDA)
				.descricao("Descrição")
				.dataPublicacao(LocalDateTime.now())
				.valor(BigDecimal.valueOf(35500))
				.fotosUrl(Set.of("https://img.olx.com.br/images/30/300317824381804.jpg", "https://img.olx.com.br/images/44/449381582842839.jpg"))
				.veiculo(Veiculo.builder()
						.marca(nissan)
						.ano("2016")
						.cor("Cinza")
						.modelo("MARCH Rio2016 1.6 Flex Fuel 5p")
						.tipoCombustivel(Veiculo.TipoCombustivel.FLEX)
						.kmRodados(50000.)
						.build())
				.build();

		marcaRepository.saveAll(List.of(nissan));
		usuarioRepository.save(wilson);
		anuncioRepository.save(nissanMarch);
	}
}
