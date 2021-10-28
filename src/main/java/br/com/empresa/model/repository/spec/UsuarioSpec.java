package br.com.empresa.model.repository.spec;

import br.com.empresa.model.entity.Usuario;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Builder
public class UsuarioSpec implements Specification<Usuario> {
    private final Boolean usuarioInativo;

    public UsuarioSpec(Boolean usuarioInativo) {
        this.usuarioInativo = usuarioInativo;
    }

    @Override
    public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if(TRUE.equals(usuarioInativo)){
            predicates.add(criteriaBuilder.lessThan(root.get("dataInativacao"), LocalDate.now()));
        }else if(FALSE.equals(usuarioInativo)){
            predicates.add(criteriaBuilder.or(
                    criteriaBuilder.greaterThan(root.get("dataInativacao"), LocalDate.now()),
                    criteriaBuilder.isNull(root.get("dataInativacao"))));
        }


        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
