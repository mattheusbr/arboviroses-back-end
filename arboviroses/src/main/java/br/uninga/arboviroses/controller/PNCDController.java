package br.uninga.arboviroses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uninga.arboviroses.model.CadPNCD;
import br.uninga.arboviroses.repository.IRepositoryPNCD;


@RestController
@RequestMapping(value = "/api/v1/pncd")
public class PNCDController {
	
	@Autowired
    private IRepositoryPNCD iRepositoryPNCD;
		
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CadPNCD cadastrar(@RequestBody CadPNCD caPncd) {
        return iRepositoryPNCD.save(caPncd);
    }
	
	@GetMapping
    public List<CadPNCD> listar() {
        return iRepositoryPNCD.findAll();
    }
		
	@GetMapping("/{id}")
    public ResponseEntity<CadPNCD>  buscarPorId(@PathVariable String id) {        
        CadPNCD obj = iRepositoryPNCD.findById(id).get();
        return ResponseEntity.ok(obj);
    }
	
	@DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable String id) {
		CadPNCD obj = iRepositoryPNCD.findById(id).get();
        
        iRepositoryPNCD.delete(obj);
    }
	
}
