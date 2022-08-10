package br.uninga.arboviroses.service;

import br.uninga.arboviroses.model.Usuario;
import br.uninga.arboviroses.repository.IRepositoryUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final BCryptPasswordEncoder crypt;
    private final IRepositoryUsuario repositoryUsuario;

    public UsuarioService(BCryptPasswordEncoder crypt, IRepositoryUsuario repositoryUsuario) {
        this.crypt = crypt;
        this.repositoryUsuario = repositoryUsuario;
    }

    public Usuario criar(Usuario usuario) throws Exception {

        if(repositoryUsuario.existsByLogin(usuario.getLogin()))
            throw new Exception("Usuario já existe");

        return repositoryUsuario.save(usuario);
    }

    public Boolean VerificarSenha(Usuario usuario) {
        String senha = repositoryUsuario.findByLogin(usuario.getLogin()).getSenha();
        return crypt.matches(senha, usuario.getSenha());
    }
}
