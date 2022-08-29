package br.uninga.arboviroses.service;

import br.uninga.arboviroses.model.Logradouro;
import br.uninga.arboviroses.repository.IRepositoryLogradouro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LogradouroService {
    @Autowired
    private IRepositoryLogradouro repositoryLogradouro;

    public Logradouro Cadastrar(Logradouro logradouro){
        return repositoryLogradouro.save(logradouro);
    }

    public List<Logradouro> Listar(){
        return repositoryLogradouro.findAll();
    }

    public Optional<Logradouro> BuscarPorId(Long idLocalidade){
        return repositoryLogradouro.findById(idLocalidade);
    }

    public void ExcluirPorId(Long idLocalidade){
        repositoryLogradouro.deleteById(idLocalidade);
    }

    public Logradouro Atualizar(Long idLogradouro, Logradouro logradouro){
        Optional<Logradouro> logradouroService = BuscarPorId(idLogradouro);

        if (logradouroService.isPresent()) {
            Logradouro _logradouro = logradouroService.get();
            _logradouro.setDecricao(_logradouro.getDecricao());

            return repositoryLogradouro.save(_logradouro);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
