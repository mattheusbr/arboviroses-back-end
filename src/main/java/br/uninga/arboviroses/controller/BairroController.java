package br.uninga.arboviroses.controller;

import br.uninga.arboviroses.model.Bairro;
import br.uninga.arboviroses.service.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/bairro")
public class BairroController {
    @Autowired
    private BairroService bairroService;

    @PostMapping
    public ResponseEntity<Bairro> Cadastrar(@RequestBody Bairro bairro) {
        try {
            return new ResponseEntity<>(bairroService.Cadastrar(bairro), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Bairro>> Listar() {
        List<Bairro> bairro = bairroService.Listar();

        if (bairro.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(bairro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bairro> BuscarPorId(@PathVariable Long id) {
        Optional<Bairro> bairro = bairroService.BuscarPorId(id);

        if (bairro.isPresent())
            return new ResponseEntity<>(bairro.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public ResponseEntity<HttpStatus> ExcluirPorId(@PathVariable Long id) {
        try{
            bairroService.ExcluirPorId(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Bairro> Atualizar(@PathVariable Long id, @RequestBody Bairro bairro) {
        try {
            return new ResponseEntity<>(bairroService.Atualizar(id, bairro), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}