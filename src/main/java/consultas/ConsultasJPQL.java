package consultas;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import mapeamento.Autor;
import mapeamento.Livro;

@Startup
@Singleton
public class ConsultasJPQL {
	
	@PostConstruct
	public void init() {
        EntityManager em = Persistence
        	.createEntityManagerFactory("PersistenciaConsultas")
            .createEntityManager();
        livrosDosAutoresQueNaoNasceramNoDia(em);
        
	}

	private void livrosDosAutoresQueNaoNasceramNoDia(EntityManager em) {
		String jpql = "SELECT DISTINCT l FROM Autor a, IN (a.livros) l WHERE a.dataNasc = :data";
		LocalDate data = LocalDate.of(1982, 11, 21);

		TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
		query.setParameter("data", data);

		List<Livro> livros = query.getResultList();

		livros.forEach((l) -> {
			System.out.println(l.getTitulo());
		});
	
	}
	

}
