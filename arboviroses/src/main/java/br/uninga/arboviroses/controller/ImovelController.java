package br.uninga.arboviroses.controller;

import br.uninga.arboviroses.model.Imovel;
import br.uninga.arboviroses.model.Localidade;
import br.uninga.arboviroses.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/imovel")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public ResponseEntity<Imovel> Cadastrar(@RequestBody Imovel imovel) {
        try {
            return new ResponseEntity<>(imovelService.Cadastrar(imovel), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Imovel>> Listar() {
        List<Imovel> imovel = imovelService.Listar();

        if (imovel.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(imovel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> BuscarPorId(@PathVariable Long id) {
        Optional<Imovel> imovel = imovelService.BuscarPorId(id);

        if (imovel.isPresent())
            return new ResponseEntity<>(imovel.get(), HttpStatus.OK);
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
    public ResponseEntity<Imovel> Atualizar(@PathVariable Long id, @RequestBody Imovel imovel) {
        try {
            return new ResponseEntity<>(imovelService.Atualizar(id, imovel), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
