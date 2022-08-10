package br.uninga.arboviroses.repository;

import br.uninga.arboviroses.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryUsuario extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
    boolean existsByLogin(String login);

}
