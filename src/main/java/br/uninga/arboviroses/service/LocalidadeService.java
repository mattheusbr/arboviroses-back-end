package br.uninga.arboviroses.service;

import br.uninga.arboviroses.model.Localidade;
import br.uninga.arboviroses.repository.IRepositoryLocalidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    @Autowired
    private IRepositoryLocalidade repositoryLocalidade;

    public Localidade Cadastrar(Localidade localidade){
        return repositoryLocalidade.save(localidade);
    }

    public List<Localidade> Listar(){
        return repositoryLocalidade.findAll();
    }

    public Optional<Localidade> BuscarPorId(Long idLocalidade){
        return repositoryLocalidade.findById(idLocalidade);
    }

    public void ExcluirPorId(Long idLocalidade){
        repositoryLocalidade.deleteById(idLocalidade);
    }

    public Localidade Atualizar(Long idLocalidade, Localidade localidade){
        Optional<Localidade> localidadeService = BuscarPorId(idLocalidade);

        if (localidadeService.isPresent()) {
            Localidade _localidade = localidadeService.get();
            _localidade.setCategoria(localidade.getCategoria());
            _localidade.setDescricao(localidade.getDescricao());
            _localidade.setExtrato(localidade.getExtrato());
            _localidade.setZona(localidade.getZona());

            return repositoryLocalidade.save(_localidade);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
