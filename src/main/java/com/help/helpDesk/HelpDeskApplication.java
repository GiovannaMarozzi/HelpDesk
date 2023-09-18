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
public class HelpDeskApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelpDeskApplication.class, args);
    }

}
