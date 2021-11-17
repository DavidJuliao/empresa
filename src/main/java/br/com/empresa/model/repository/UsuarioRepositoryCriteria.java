package br.com.empresa.model.repository;

import br.com.empresa.model.entity.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Usuario> buscarTodos(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder(); //Criar clausulas: or, and, between
        CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class); //Montar estrutura select: from,where
        Root<Usuario> root = query.from(Usuario.class); //Acessar atributos entidade

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.or(builder.equal(root.get("nome"),"Pedro"),builder.equal(root.get("nome"),"João")));
        predicates.add(builder.or(builder.equal(root.get("nome"),"Pedro"),builder.equal(root.get("nome"),"João")));
//        Join<Usuario,Perfil> join = root.join("perfil");
        return entityManager
                .createQuery(query.where(predicates.toArray(new Predicate[0])))
                .getResultList();
    }
}
