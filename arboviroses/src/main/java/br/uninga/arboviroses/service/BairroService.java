package br.uninga.arboviroses.service;

import br.uninga.arboviroses.model.Bairro;
import br.uninga.arboviroses.repository.IRepositoryBairro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {
    @Autowired
    private IRepositoryBairro repositoryBairro;

    public Bairro Cadastrar(Bairro bairro){
        return repositoryBairro.save(bairro);
    }

    public List<Bairro> Listar(){
        return repositoryBairro.findAll();
    }

    public Optional<Bairro> BuscarPorId(Long idBairro){
        return repositoryBairro.findById(idBairro);
    }

    public void ExcluirPorId(Long idBairro){
        repositoryBairro.deleteById(idBairro);
    }

    public Bairro Atualizar(Long idBairro, Bairro bairro){
        Optional<Bairro> bairroService = BuscarPorId(idBairro);

        if (bairroService.isPresent()) {
            Bairro _bairro = bairroService.get();
            bairro.setDecricao(_bairro.getDecricao());

            return repositoryBairro.save(_bairro);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
