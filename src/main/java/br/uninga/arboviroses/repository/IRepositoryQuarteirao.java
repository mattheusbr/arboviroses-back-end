package br.uninga.arboviroses.repository;

import br.uninga.arboviroses.model.Quarteirao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryQuarteirao extends JpaRepository<Quarteirao, Long> {
}
