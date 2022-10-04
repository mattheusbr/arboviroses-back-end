package br.uninga.arboviroses.service;

import br.uninga.arboviroses.model.TipoImovel;
import br.uninga.arboviroses.repository.IRepositoryTipoImovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TipoImovelService {
    @Autowired
    private IRepositoryTipoImovel repositoryTipoImovel;

    public TipoImovel Cadastrar(TipoImovel tipoImovel){
        return repositoryTipoImovel.save(tipoImovel);
    }

    public List<TipoImovel> Listar(){
        return repositoryTipoImovel.findAll();
    }

    public Optional<TipoImovel> BuscarPorId(Long idTipoImovel){
        return repositoryTipoImovel.findById(idTipoImovel);
    }

    public void ExcluirPorId(Long idTipoImovel){
        repositoryTipoImovel.deleteById(idTipoImovel);
    }

    public TipoImovel Atualizar(Long idTipoImovel, TipoImovel tipoImovel){
        Optional<TipoImovel> tipoImovelService = BuscarPorId(idTipoImovel);

        if (tipoImovelService.isPresent()) {
            TipoImovel _tipoImovelService = tipoImovelService.get();
            _tipoImovelService.setSigla(tipoImovel.getSigla());
            _tipoImovelService.setDescricao(tipoImovel.getDescricao());
            return repositoryTipoImovel.save(_tipoImovelService);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
