package com.qintess.demo.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qintess.demo.entity.CasaDeShow;
import com.qintess.demo.entity.Cliente;
import com.qintess.demo.entity.Evento;
import com.qintess.demo.entity.Ingresso;
import com.qintess.demo.repositories.CasaDeShowRepository;
import com.qintess.demo.repositories.ClienteRepository;
import com.qintess.demo.repositories.EventoRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	//Esta é apenas uma classe de teste.
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	CasaDeShowRepository casaDeShowRepository;

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente = new Cliente("Felipe", "Lino", "493.669.018-08", "f.lino1934@hotmail.com", "(13)98137-5682");
		Cliente cliente2 = new Cliente("Sarah", "Lino", "494.669.019-09", "sarah@hotmail.com", "(13)98137-5682");

		Evento evento = new Evento(new Date(), "Rua carlos gomes 977", 57.0, 100, "Atualizações do java");
		Evento evento2 = new Evento(new Date(), "Guilhermina ", 12.0, 100, "Pataty Patata");
		
		//de agr
		
		Ingresso ingresso = new Ingresso(2);

		// como o evento ja salval o propio cliente, não foi preciso salvar o cliente
		// sozinho

		CasaDeShow casaDeShow = new CasaDeShow("Casa de eventos Morumbi", "11-704-190", "Rua carlos gomes", 120,"Espaço de médio porte para palestras e reuniões", 230.0);
		CasaDeShow casaDeShow2 = new CasaDeShow("Casa de shows do MAranhão", "11-704-190", "Rua  gomes", 1200,
				"Espaço para shows", 230.0);
		
		
		
		evento.addCliente(cliente);
		evento.addCliente(cliente2);
		evento2.addCliente(cliente);
		casaDeShow.addEvento(evento);
		casaDeShow.addEvento(evento2);
		evento2.addIngresso(ingresso);
		casaDeShowRepository.saveAll(Arrays.asList(casaDeShow,casaDeShow2));

		// eventoRepository.saveAll(Arrays.asList(evento, evento2));

	}

}
