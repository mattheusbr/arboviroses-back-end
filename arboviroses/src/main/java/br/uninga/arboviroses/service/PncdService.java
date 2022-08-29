package br.uninga.arboviroses.service;

import br.uninga.arboviroses.model.Pncd;
import br.uninga.arboviroses.repository.IRepositoryPncd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PncdService {
    @Autowired
    private IRepositoryPncd repositoryPncd;

    public Pncd Cadastrar(Pncd pncd){
        return repositoryPncd.save(pncd);
    }

    public List<Pncd> Listar(){
        return repositoryPncd.findAll();
    }

    public Optional<Pncd> BuscarPorId(Long idPncd){
        return repositoryPncd.findById(idPncd);
    }

    public void ExcluirPorId(Long idLocalidade){
        repositoryPncd.deleteById(idLocalidade);
    }

    public Pncd Atualizar(Long idPncd, Pncd pncd){
        Optional<Pncd> pncdService = BuscarPorId(idPncd);

        if (pncdService.isPresent()){
            Pncd _Pncd = pncdService.get();
            _Pncd.setData(_Pncd.getData());
            _Pncd.setHora(_Pncd.getHora());
            _Pncd.setA1(_Pncd.getA1());
            _Pncd.setB(_Pncd.getB());
            _Pncd.setC(_Pncd.getC());
            _Pncd.setD1(_Pncd.getD1());
            _Pncd.setD2(_Pncd.getD2());
            _Pncd.setE(_Pncd.getE());
            _Pncd.setTipo01(_Pncd.getTipo01());
            _Pncd.setQuantidade01(_Pncd.getQuantidade01());
            _Pncd.setTipo02(_Pncd.getTipo02());
            _Pncd.setQuantidade02(_Pncd.getQuantidade02());
            _Pncd.setTipodeImovel(_Pncd.getTipodeImovel());
            _Pncd.setNumero(_Pncd.getNumero());
            _Pncd.setComplemento(_Pncd.getComplemento());
            _Pncd.setSequencia(_Pncd.getSequencia());
            _Pncd.setNumerodeMoradores(_Pncd.getNumerodeMoradores());
            _Pncd.setTelefoneResidencial(_Pncd.getTelefoneResidencial());
            _Pncd.setTelefoneRecado(_Pncd.getTelefoneRecado());
            _Pncd.setNomeMorador(_Pncd.getNomeMorador());
            _Pncd.setCpf(_Pncd.getCpf());
            _Pncd.setDataNascimento(_Pncd.getDataNascimento());
            _Pncd.setNumerodoCartaoSus(_Pncd.getNumerodoCartaoSus());

            return repositoryPncd.save(_Pncd);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
