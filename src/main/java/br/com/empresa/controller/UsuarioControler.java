package br.com.empresa.controller;

import br.com.empresa.model.repository.UsuarioRepositoryCriteria;
import br.com.empresa.model.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;

@Controller
@RequestMapping(path = "/usuarios")
public class UsuarioControler {

    private final UsuarioService usuarioService;
    private final UsuarioRepositoryCriteria usuarioRepositoryCriteria;

    public UsuarioControler(UsuarioService usuarioService, UsuarioRepositoryCriteria usuarioRepositoryCriteria) {
        this.usuarioService = usuarioService;
        this.usuarioRepositoryCriteria = usuarioRepositoryCriteria;
    }

    @Transactional
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity buscar(@RequestParam(value = "usuarioInativo", required = false) Boolean usuarioAtivo){

        return ResponseEntity.ok(usuarioService.buscarTodosUltimate(usuarioAtivo));
    }
}
