package com.help.helpDesk.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente extends Pessoa{
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha);
        this.chamados = chamados;
    }
}
