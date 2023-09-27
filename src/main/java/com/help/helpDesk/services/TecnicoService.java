package com.help.helpDesk.services;

import com.help.helpDesk.domain.Pessoa;
import com.help.helpDesk.domain.Tecnico;
import com.help.helpDesk.domain.dto.TecnicoDTO;
import com.help.helpDesk.repository.PessoaRepository;
import com.help.helpDesk.repository.TecnicoRepository;
import com.help.helpDesk.services.exceptions.DataIntegrityViolationException;
import com.help.helpDesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO tecnico) {
        tecnico.setId(null);
        validaPorCpfEEmail(tecnico);
        Tecnico newObjs = new Tecnico(tecnico);
        return repository.save(newObjs);
    }

    private void validaPorCpfEEmail(TecnicoDTO tecnico) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(tecnico.getCpf());

        if (obj.isPresent() && obj.get().getId() != tecnico.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        obj = pessoaRepository.findByEmail(tecnico.getEmail());
        if (obj.isPresent() && obj.get().getId() != tecnico.getId()){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
        }

    }
}
