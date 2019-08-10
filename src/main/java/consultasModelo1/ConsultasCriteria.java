package consultasModelo1;

import mapeamento.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.time.LocalDate;

@Singleton
@Startup
public class ConsultasCriteria {

    @PostConstruct
    public void init() {
        EntityManager em = Persistence
                .createEntityManagerFactory("PersistenciaConsultas")
                .createEntityManager();

//        livrosDosAutoresQueNaoNasceramNoDia(em);
//        professoresQuePossuemTelefoneEMoramNaRua(em);
//        alunosDaTurma2019_1(em);
//        professorQueTemTelefoneQueTerminaEm(em);
//        livrosDosAutoresDeCajazeirasComLancamentoEntre(em);
//        livrosDosAutoresQueComecamComALetra(em);
    }

    private void livrosDosAutoresQueNaoNasceramNoDia(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);

        Root<Autor> autor = criteria.from(Autor.class);
        Join<Autor, Livro> livro = autor.join("livros");

        LocalDate data = LocalDate.of(1997, 1, 10);

        criteria.select(livro);

        em.createQuery(criteria).getResultList().forEach((l) -> System.out.println(l.getTitulo()));
    }

    private void professoresQuePossuemTelefoneEMoramNaRua(EntityManager em) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Professor> criteria = builder.createQuery(Professor.class);

        Root<Professor> p = criteria.from(Professor.class);

        criteria.select(p).where(
                builder.and(
                        builder.equal(
                                p.get("endereco").get("rua"),
                                "Que atividade fácil"
                        ),
                        builder.isNotEmpty(
                                p.get("telefones")
                        )
                )
        );

        em.createQuery(criteria).getResultList().forEach((pf) -> System.out.println(pf.getNome()));
    }

    private void alunosDaTurma2019_1(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Aluno> criteria = builder.createQuery(Aluno.class);

        Root a = criteria.from(Aluno.class);

        criteria.select(a).where(
                builder.equal(a.get("turma"), "2019.1")
        );

        em.createQuery(criteria).getResultList().forEach((al) -> System.out.println(al.getNome()+" "+al.getTurma()));


    }

    private void professorQueTemTelefoneQueTerminaEm(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Professor> criteriaQuery = builder.createQuery(Professor.class);

        Root p = criteriaQuery.from(Professor.class);
        Join<Professor, Telefone> t = p.join("telefones");

        criteriaQuery.select(p).where(
                builder.like(t.get("numero"), "%8")
        );

        em.createQuery(criteriaQuery).getResultList().forEach((pf) -> System.out.println(pf.getNome()));
    }

    private void livrosDosAutoresDeCajazeirasComLancamentoEntre(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Livro> criteriaQuery = builder.createQuery(Livro.class);

        Root<Livro> l = criteriaQuery.from(Livro.class);
        Join<Livro, Autor> a = l.join("autores");

        LocalDate inicio = LocalDate.of(1996, 1, 13);
        LocalDate fim = LocalDate.of(1998, 1, 13);

        criteriaQuery.select(l).where(
                builder.and(
                    builder.equal(a.get("endereco").get("cidade"), "Cajazeiras"),
                    builder.between(l.get("lancamento"),inicio, fim)
                )
        );

        em.createQuery(criteriaQuery).getResultList().forEach((lv) -> System.out.println(lv.getTitulo()+ "  "+ lv.getLancamento()));
    }

    private void livrosDosAutoresQueComecamComALetra(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Livro> criteriaQuery = builder.createQuery(Livro.class);

        Root<Livro> l = criteriaQuery.from(Livro.class);
        Join<Livro, Autor> livroAutorJoin = l.join("autores");

        criteriaQuery.select(l).where(
                builder.like(livroAutorJoin.get("nome"),"F%")
        );

        em.createQuery(criteriaQuery).getResultList().forEach((lv) -> lv.getAutores().forEach(at -> System.out.println(at.getNome())));
    }



}
