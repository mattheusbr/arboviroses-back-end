package br.uninga.arboviroses.controller;

import br.uninga.arboviroses.model.Localidade;
import br.uninga.arboviroses.model.Quarteirao;
import br.uninga.arboviroses.service.LocalidadeService;
import br.uninga.arboviroses.service.QuarteiraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/quarteirao")
public class QuarteiraoController {

    @Autowired
    private QuarteiraoService quarteiraoService;

    @PostMapping
    public ResponseEntity<Quarteirao> Cadastrar(@RequestBody Quarteirao quarteirao) {
        try {
            return new ResponseEntity<>(quarteiraoService.Cadastrar(quarteirao), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Quarteirao>> Listar() {
        List<Quarteirao> quarteirao = quarteiraoService.Listar();

        if (quarteirao.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(quarteirao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarteirao> BuscarPorId(@PathVariable Long id) {
        Optional<Quarteirao> quarteirao = quarteiraoService.BuscarPorId(id);

        if (quarteirao.isPresent())
            return new ResponseEntity<>(quarteirao.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public ResponseEntity<HttpStatus> ExcluirPorId(@PathVariable Long id) {
        try{
            quarteiraoService.ExcluirPorId(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Quarteirao> Atualizar(@PathVariable Long id, @RequestBody Quarteirao quarteirao) {
        try {
            return new ResponseEntity<>(quarteiraoService.Atualizar(id, quarteirao), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
