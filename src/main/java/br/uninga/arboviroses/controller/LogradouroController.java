package br.uninga.arboviroses.controller;

import br.uninga.arboviroses.model.Logradouro;
import br.uninga.arboviroses.service.LogradouroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/logradouro")
public class LogradouroController {
    @Autowired
    private LogradouroService logradouroService;

    @PostMapping
    public ResponseEntity<Logradouro> Cadastrar(@RequestBody Logradouro logradouro) {
        try {
            return new ResponseEntity<>(logradouroService.Cadastrar(logradouro), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Logradouro>> Listar() {
        List<Logradouro> logradouro = logradouroService.Listar();

        if (logradouro.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(logradouro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Logradouro> BuscarPorId(@PathVariable Long id) {
        Optional<Logradouro> logradouro = logradouroService.BuscarPorId(id);

        if (logradouro.isPresent())
            return new ResponseEntity<>(logradouro.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public ResponseEntity<HttpStatus> ExcluirPorId(@PathVariable Long id) {
        try{
            logradouroService.ExcluirPorId(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Logradouro> Atualizar(@PathVariable Long id, @RequestBody Logradouro logradouro) {
        try {
            return new ResponseEntity<>(logradouroService.Atualizar(id, logradouro), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
