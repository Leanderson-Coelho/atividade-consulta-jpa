package consultas;

import mapeamento.Autor;
import mapeamento.Livro;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.logging.Logger;

@Singleton
@Startup
public class ConsultasCriteria {

    @PostConstruct
    public void init(){
        EntityManager em = Persistence
                .createEntityManagerFactory("PersistenciaConsultas")
                .createEntityManager();

        livrosDosAutoresQueNaoNasceramNoDia(em);
    }

    private void livrosDosAutoresQueNaoNasceramNoDia(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);

        Root<Autor> autor = criteria.from(Autor.class);
        Join<Autor, Livro> livro = autor.join("livros");

        LocalDate data = LocalDate.of(1997, 1, 10);

        criteria.select(livro);

        em.createQuery(criteria).getResultList().forEach((l) -> System.out.println(l.getTitulo()));
        Logger.getLogger("ConsultasCriteria").info("Passou po");
    }
}
