package consultasModelo2;


import mapeamento.questão2.Area;
import mapeamento.questão2.Escritor;
import mapeamento.questão2.Revisor;
import persisterQuestao2.Persister2;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Startup
@Singleton
public class ConsultasJPQL2 {

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
        String jpql = "SELECT e.nome,p.titulo,a.nome FROM Escritor e, IN (e.publicacoes) p, IN(p.areas) a WHERE  e.id = 3";

        List<Object[]> resultado = em.createQuery(jpql).getResultList();
        resultado.forEach(
                (a) -> System.out.println(a[0]+" "+a[1]+" "+a[2])
        );
    }

    private void revisorComPublicacaoNaArea(EntityManager em) {
        String jpql = "SELECT p.titulo, r.nome FROM Revisor  r, IN (r.publicacoes) p WHERE EXISTS " +
                "(SELECT ar FROM p.areas ar WHERE ar.nome LIKE 'indústria')";

        List<Object[]> resultado = em.createQuery(jpql).getResultList();
        resultado.forEach(
                i-> System.out.println(i[0]+" - "+i[1])
        );
    }

    private void revisorComPublicacaoIniciadaEm(EntityManager em) {
        String jpql = "SELECT r FROM Revisor r, IN (r.publicacoes) p WHERE p.titulo LIKE 'Java%'";
        TypedQuery<Revisor> query = em.createQuery(jpql, Revisor.class);

        query.getResultList().forEach(
                i-> System.out.println(i.getNome())
        );

    }

    private void escritoresComMaisDeTresPremios(EntityManager em) {
        String jpql = "SELECT e.nome, COUNT(p) FROM Escritor e, IN (e.publicacoes) p WHERE e.premios > 3 GROUP BY e.nome";
        List<Object[]> resultado = em.createQuery(jpql).getResultList();
        resultado.forEach(
                i-> System.out.println(i[0]+" - "+i[1])
        );
    }


}
