package br.com.empresa.model.service;

import br.com.empresa.model.entity.Usuario;
import br.com.empresa.model.repository.UsuarioRepository;
import br.com.empresa.model.repository.spec.UsuarioSpec;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos(Boolean usarioInativo){
        return usuarioRepository.findAll(UsuarioSpec.builder().usuarioInativo(usarioInativo).build());
    }

    public List<Usuario> buscarTodosUltimate(Boolean usarioInativo){
        return usuarioRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(TRUE.equals(usarioInativo)){
                predicates.add(builder.lessThan(root.get("dataInativacao"), LocalDate.now()));
            }else if(FALSE.equals(usarioInativo)){
                predicates.add(builder.or(
                        builder.greaterThan(root.get("dataInativacao"), LocalDate.now()),
                        builder.isNull(root.get("dataInativacao"))));
            }


            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
