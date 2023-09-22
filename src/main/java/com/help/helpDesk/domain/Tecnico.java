package com.help.helpDesk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.help.helpDesk.domain.dto.TecnicoDTO;
import com.help.helpDesk.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Tecnico extends Pessoa{
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(){
        super();
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico(TecnicoDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public String toString() {
        return "Tecnico{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", senha='" + getSenha() + '\'' +
                '}';
    }
}
