//package br.uninga.arboviroses.controller;
//
//import br.uninga.arboviroses.model.CadPNCD;
//import br.uninga.arboviroses.model.Usuario;
//import br.uninga.arboviroses.service.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//    @RestController
//    @RequestMapping(value = "/api/v1/usuario")
//public class UsuarioController {
//
//    private final UsuarioService usuarioService;
//
//    public UsuarioController(UsuarioService usuarioService) {
//        this.usuarioService = usuarioService;
//    }
//
//    @PostMapping
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public Usuario Criar (@RequestBody Usuario usuario) throws Exception {
//     return usuarioService.criar(usuario);
//    }
//
//    @GetMapping()
//    @ResponseStatus(code = HttpStatus.OK)
//    public boolean VerificarSenha(@RequestBody Usuario usuario){
//        return  usuarioService.VerificarSenha(usuario);
//    }
//}
