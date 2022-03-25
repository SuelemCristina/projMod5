package br.com.agencia.boaViagem.controller;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import br.com.agencia.boaViagem.model.ContatoModel;
import br.com.agencia.boaViagem.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/getAll")
    public java.util.List<ContatoModel> list(){
        return contatoService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody ContatoModel contato){
        contatoService.save(contato);
        return "New Contato Added";
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoModel> get(@PathVariable Integer id) {
        try {
            ContatoModel contato = contatoService.get(id);
            return new ResponseEntity<ContatoModel>(contato, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<ContatoModel>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoModel> update(@RequestBody ContatoModel newContato, @PathVariable Integer id) {
        try {
            contatoService.update(id, newContato);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<ContatoModel>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        contatoService.delete(id);
        return "Contato Excluido.";
    }



}
