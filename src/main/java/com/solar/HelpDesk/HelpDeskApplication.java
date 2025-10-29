package com.solar.HelpDesk;

import com.solar.HelpDesk.domain.Chamado;
import com.solar.HelpDesk.domain.Cliente;
import com.solar.HelpDesk.domain.Tecnico;
import com.solar.HelpDesk.domain.enums.Perfil;
import com.solar.HelpDesk.domain.enums.Prioridade;
import com.solar.HelpDesk.domain.enums.Status;
import com.solar.HelpDesk.repositories.ChamadoRepository;
import com.solar.HelpDesk.repositories.ClienteRepository;
import com.solar.HelpDesk.repositories.TecnicoRepository;
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
        Tecnico tec1 = new Tecnico(null, "Thiago", "17434108754", "thiago@gmail.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Torvald", "578.609.970-96", "linus@gmail.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado01", "Primeiro chamado", cli1, tec1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
