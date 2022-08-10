package br.uninga.arboviroses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uninga.arboviroses.model.CadPNCD;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryPNCD extends JpaRepository<CadPNCD, String>{

}
