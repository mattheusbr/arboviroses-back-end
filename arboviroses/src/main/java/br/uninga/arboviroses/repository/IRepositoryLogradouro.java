package br.uninga.arboviroses.repository;

import br.uninga.arboviroses.model.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryLogradouro extends JpaRepository<Logradouro, Long> {
}
