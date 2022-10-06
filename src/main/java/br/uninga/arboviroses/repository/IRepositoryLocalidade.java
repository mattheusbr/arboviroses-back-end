package br.uninga.arboviroses.repository;

import br.uninga.arboviroses.model.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryLocalidade extends JpaRepository<Localidade, Long> {
}
