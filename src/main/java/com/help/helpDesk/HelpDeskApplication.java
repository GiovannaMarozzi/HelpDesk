package com.help.helpDesk;

import com.help.helpDesk.domain.Chamado;
import com.help.helpDesk.domain.Cliente;
import com.help.helpDesk.domain.Tecnico;
import com.help.helpDesk.enums.Perfil;
import com.help.helpDesk.enums.Prioridade;
import com.help.helpDesk.enums.Status;
import com.help.helpDesk.repository.ChamadoRepository;
import com.help.helpDesk.repository.ClienteRepository;
import com.help.helpDesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpDeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "123.456.789-11", "valdir@email.com", "123", null);
		tec1.addPerfil(Perfil.AMDMIN);

		Cliente cli1 = new Cliente(null, "Linus Torvalts", "147582635-48", "torvalts@email.com", "teste", null);

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		}
}
