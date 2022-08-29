package br.uninga.arboviroses.repository;

import br.uninga.arboviroses.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryBairro extends JpaRepository<Bairro, Long> {
}
