package br.uninga.arboviroses.repository;

import br.uninga.arboviroses.model.TipoImovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryTipoImovel extends JpaRepository<TipoImovel, Long> {
}
