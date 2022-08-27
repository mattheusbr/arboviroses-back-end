package br.uninga.arboviroses.controller;

import br.uninga.arboviroses.model.Localidade;
import br.uninga.arboviroses.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/localidade")
public class LocalidadeController {
    @Autowired
    private LocalidadeService localidadeService;

    @PostMapping
    public ResponseEntity<Localidade> Cadastrar(@RequestBody Localidade localidade) {
        try {
            return new ResponseEntity<>(localidadeService.Cadastrar(localidade), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Localidade>> Listar() {
        List<Localidade> localidade = localidadeService.Listar();

        if (localidade.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(localidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localidade> BuscarPorId(@PathVariable Long id) {
        Optional<Localidade> localidade = localidadeService.BuscarPorId(id);

        if (localidade.isPresent())
            return new ResponseEntity<>(localidade.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public ResponseEntity<HttpStatus> ExcluirPorId(@PathVariable Long id) {
        try{
            localidadeService.ExcluirPorId(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Localidade> Atualizar(@PathVariable Long id, @RequestBody Localidade localidade) {
        try {
            return new ResponseEntity<>(localidadeService.Atualizar(id, localidade), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
