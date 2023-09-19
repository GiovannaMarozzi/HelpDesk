package com.help.helpDesk.resources;

import com.help.helpDesk.domain.Tecnico;
import com.help.helpDesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tecnico> findByID(@PathVariable Integer id){
        Tecnico tecnico = service.findById(id);
        return ResponseEntity.ok().body(tecnico);
//        return null;

    }
}
