package com.help.helpDesk.services;

import com.help.helpDesk.domain.Tecnico;
import com.help.helpDesk.repository.TecnicoRepository;
import com.help.helpDesk.services.exceptions.ObjectNotFoundException;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+id));
    }
}
