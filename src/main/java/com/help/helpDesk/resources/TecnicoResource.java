package com.help.helpDesk.resources;

import com.help.helpDesk.domain.Tecnico;
import com.help.helpDesk.domain.dto.TecnicoDTO;
import com.help.helpDesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findByID(@PathVariable Integer id){
        Tecnico tecnico = service.findById(id);
        return ResponseEntity.ok().body(new TecnicoDTO(tecnico));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        List<Tecnico> list = service.findAll();
        List<TecnicoDTO> listDTO = list.stream().map(TecnicoDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@RequestBody TecnicoDTO tecnico){
        Tecnico newObj = service.create(tecnico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
