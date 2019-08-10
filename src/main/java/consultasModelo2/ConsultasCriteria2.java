package consultasModelo2;

import mapeamento.questão2.Area;
import mapeamento.questão2.Escritor;
import mapeamento.questão2.Publicacao;
import mapeamento.questão2.Revisor;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

@Singleton
@Startup
public class ConsultasCriteria2 {
    @PostConstruct
    public void init() {

        EntityManager em = Persistence
                .createEntityManagerFactory("PersistenciaConsultas")
                .createEntityManager();

//        pessoaQueTemIdIgual(em);
//        revisorComPublicacaoNaArea(em);
//        revisorComPublicacaoIniciadaEm(em);
//        escritoresComMaisDeTresPremios(em);
    }

    private void pessoaQueTemIdIgual(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root e = query.from(Escritor.class);
        Join<Escritor, Publicacao> escritorPublicacaoJoin = e.join("publicacoes");
        Join<Publicacao, Area> publicacaoAreaJoin = escritorPublicacaoJoin.join("areas");

        query.multiselect(
                e.get("nome"),
                escritorPublicacaoJoin.get("titulo"),
                publicacaoAreaJoin.get("nome")
        ).where(
                builder.equal(e.get("id"), 3)
        );

        em.createQuery(query).getResultList().forEach(
                o -> System.out.println(o[0] + " - " + o[1] + " - " + o[2])
        );
    }

    private void revisorComPublicacaoNaArea(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Subquery<Area> subquery = query.subquery(Area.class);
        Root<Publicacao> p = subquery.from(Publicacao.class);

        Join<Publicacao, Area> publicacaoAreaJoin = p.join("areas");
        Join<Publicacao, Revisor> publicacaoRevisorJoin = p.join("revisor");

        subquery.select(publicacaoAreaJoin).where(
                builder.equal(publicacaoAreaJoin.get("nome"), "indústria")
        );

        query.multiselect(
                p.get("titulo"),
                publicacaoRevisorJoin.get("nome")
        ).where(
                builder.exists(
                        subquery
                )
        );
        em.createQuery(query).getResultList().forEach(
                i -> System.out.println(i[0] + " - " + i[1])
        );
    }

    private void revisorComPublicacaoIniciadaEm(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Revisor> query = builder.createQuery(Revisor.class);

        Root<Revisor> r = query.from(Revisor.class);
        Join<Revisor, Publicacao> pJoin = r.join("publicacoes");
        query.select(r).where(
                builder.like(pJoin.get("titulo"), "Java%")
        );
        em.createQuery(query).getResultList().forEach(
                rv -> System.out.println(rv.getNome())
        );
    }

    private void escritoresComMaisDeTresPremios(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root<Escritor> r = query.from(Escritor.class);
        Join<Escritor, Publicacao> pJoin = r.join("publicacoes");

        query.multiselect(
                r.get("nome"),
                builder.count(pJoin)
        ).where(
                builder.greaterThan(r.get("premios"), 3)
        ).groupBy(
                r.get("nome")
        );
        em.createQuery(query).getResultList().forEach(
                i -> System.out.println(i[0]+" - "+i[1])
        );
    }
}
