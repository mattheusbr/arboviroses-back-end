package br.uninga.arboviroses.controller;

import br.uninga.arboviroses.model.Pncd;
import br.uninga.arboviroses.service.PncdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/pncd")
public class PncdController {
    @Autowired
    private PncdService pncdService;

    @PostMapping
    public ResponseEntity<Pncd> Cadastrar(@RequestBody Pncd pncd) {
        try {
            return new ResponseEntity<>(pncdService.Cadastrar(pncd), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Pncd>> Listar() {
        List<Pncd> localidade = pncdService.Listar();

        if (localidade.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(localidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pncd> BuscarPorId(@PathVariable Long id) {
        Optional<Pncd> pncd = pncdService.BuscarPorId(id);

        if (pncd.isPresent())
            return new ResponseEntity<>(pncd.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public ResponseEntity<HttpStatus> ExcluirPorId(@PathVariable Long id) {
        try{
            pncdService.ExcluirPorId(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pncd> Atualizar(@PathVariable Long id, @RequestBody Pncd pncd) {
        try {
            return new ResponseEntity<>(pncdService.Atualizar(id, pncd), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
