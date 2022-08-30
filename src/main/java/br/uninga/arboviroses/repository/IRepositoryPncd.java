package br.uninga.arboviroses.repository;

import br.uninga.arboviroses.model.Pncd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryPncd extends JpaRepository<Pncd, Long> {
}
