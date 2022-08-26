package br.uninga.arboviroses.service;

import br.uninga.arboviroses.model.Imovel;
import br.uninga.arboviroses.repository.IRepositoryImovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {
    @Autowired
    private IRepositoryImovel repositoryImovel;

    public Imovel Cadastrar(Imovel imovel){
        return repositoryImovel.save(imovel);
    }

    public List<Imovel> Listar(){
        return repositoryImovel.findAll();
    }

    public Optional<Imovel> BuscarPorId(Long idImovel){
        return repositoryImovel.findById(idImovel);
    }

    public void ExcluirPorId(Long idImovel){
        repositoryImovel.deleteById(idImovel);
    }

    public Imovel Atualizar(Long idImovel, Imovel imovel){
        Optional<Imovel> imovelService = BuscarPorId(idImovel);

        if (imovelService.isPresent()) {
            Imovel _imovel = imovelService.get();
            _imovel.setBairro(imovel.getBairro());
            _imovel.setLogradouro(imovel.getLogradouro());
            _imovel.setNumero(imovel.getNumero());
            _imovel.setComplemento(imovel.getComplemento());
            _imovel.setTipoImovel(imovel.getTipoImovel());
            _imovel.setLocalidade(imovel.getLocalidade());
            _imovel.setQuarteirao(imovel.getQuarteirao());
            _imovel.setSequencia(imovel.getSequencia());
            _imovel.setTelefoneRecado(imovel.getTelefoneRecado());
            _imovel.setTipoImovel(imovel.getTipoImovel());
            _imovel.setObservacao(imovel.getObservacao());

            return repositoryImovel.save(_imovel);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            //return new Localidade();
        }
    }
}
