package br.uninga.arboviroses.service;

import br.uninga.arboviroses.model.Quarteirao;
import br.uninga.arboviroses.repository.IRepositoryQuarteirao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class QuarteiraoService {
    @Autowired
    private IRepositoryQuarteirao repositoryQuarteirao;

    public Quarteirao Cadastrar(Quarteirao quarteirao){
        return repositoryQuarteirao.save(quarteirao);
    }

    public List<Quarteirao> Listar(){
        return repositoryQuarteirao.findAll();
    }

    public Optional<Quarteirao> BuscarPorId(Long idQuarteirao){
        return repositoryQuarteirao.findById(idQuarteirao);
    }

    public void ExcluirPorId(Long idQuarteirao){
        repositoryQuarteirao.deleteById(idQuarteirao);
    }

    public Quarteirao Atualizar(Long idQuarteirao, Quarteirao quarteirao){
        Optional<Quarteirao> quarteiraoService = BuscarPorId(idQuarteirao);

        if (quarteiraoService.isPresent()) {
            Quarteirao _quarteirao = quarteiraoService.get();
            _quarteirao.setLocalidade(quarteirao.getLocalidade());
            _quarteirao.setNumero(quarteirao.getNumero());
            _quarteirao.setObservacao(quarteirao.getObservacao());
            return repositoryQuarteirao.save(_quarteirao);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            //return new Localidade();
        }
    }
}