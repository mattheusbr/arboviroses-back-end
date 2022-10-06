package br.uninga.arboviroses.repository;

import br.uninga.arboviroses.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryImovel extends JpaRepository<Imovel, Long> {
}
