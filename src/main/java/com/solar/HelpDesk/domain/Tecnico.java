package com.solar.HelpDesk.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Tecnico extends Pessoa{

    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(List<Chamado> chamados) {
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha);
    }


}
