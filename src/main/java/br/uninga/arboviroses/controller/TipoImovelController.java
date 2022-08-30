package br.uninga.arboviroses.controller;

import br.uninga.arboviroses.model.TipoImovel;
import br.uninga.arboviroses.service.TipoImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1/tipoImovel")
public class TipoImovelController {
    @Autowired
    private TipoImovelService imovelService;

    @PostMapping
    public ResponseEntity<TipoImovel> Cadastrar(@RequestBody TipoImovel tipoImovel) {
        try {
            return new ResponseEntity<>(imovelService.Cadastrar(tipoImovel), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoImovel>> Listar() {
        List<TipoImovel> tipoImovel = imovelService.Listar();

        if (tipoImovel.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(tipoImovel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoImovel> BuscarPorId(@PathVariable Long id) {
        Optional<TipoImovel> tipoImovel = imovelService.BuscarPorId(id);

        if (tipoImovel.isPresent())
            return new ResponseEntity<>(tipoImovel.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public ResponseEntity<HttpStatus> ExcluirPorId(@PathVariable Long id) {
        try{
            imovelService.ExcluirPorId(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<TipoImovel> Atualizar(@PathVariable Long id, @RequestBody TipoImovel tipoImovel) {
        try {
            return new ResponseEntity<>(imovelService.Atualizar(id, tipoImovel), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
