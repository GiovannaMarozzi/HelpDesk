package com.help.helpDesk.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Tecnico extends Pessoa{
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha);
        this.chamados = chamados;
    }
}
