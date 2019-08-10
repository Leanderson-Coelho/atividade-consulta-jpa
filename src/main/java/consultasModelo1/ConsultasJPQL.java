package consultasModelo1;

import mapeamento.AlunoVO;
import mapeamento.Livro;
import mapeamento.Professor;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


@Startup
@Singleton
public class ConsultasJPQL {
	
	@PostConstruct
	public void init() {
        EntityManager em = Persistence
        	.createEntityManagerFactory("PersistenciaConsultas")
            .createEntityManager();

//     	livrosDosAutoresQueNaoNasceramNoDia(em);
//    	professoresQuePossuemTelefoneEMoramNaRua(em);
//		alunosDaTurma2019_1(em);
//		professorQueTemTelefoneQueTerminaEm(em);
//		livrosDosAutoresDeCajazeirasComLancamentoEntre(em);
//		livrosDosAutoresQueComecamComALetra(em);
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

	private void professoresQuePossuemTelefoneEMoramNaRua(EntityManager em) {
		String jpql = "SELECT p FROM Professor p WHERE p.endereco.rua like 'Que atividade fácil' AND EXISTS " +
				"(SELECT t FROM p.telefones t) ";
		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);

		List<Professor> resultado = query.getResultList();

		resultado.forEach((p) ->
				System.out.println(p.getNome())
		);
	}

	private void alunosDaTurma2019_1(EntityManager em) {
		String jpql = "SELECT NEW mapeamento.AlunoVO(a.nome, a.cpf, a.idade) FROM Aluno a WHERE a.turma like '2019.1'";
		TypedQuery<AlunoVO> query = em.createQuery(jpql,AlunoVO.class);

		List<AlunoVO> resultado = query.getResultList();

		resultado.forEach((alunoVO) ->
				System.out.println(
						alunoVO.getNome()+" - "+
						alunoVO.getCpf()+" - "+
						alunoVO.getIdade()
				)
		);
	}

	private void professorQueTemTelefoneQueTerminaEm(EntityManager em) {
		String jpql = "SELECT p FROM Professor p WHERE EXISTS " +
				"( SELECT t FROM p.telefones t WHERE t.numero like '%8')";
		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);

		List<Professor> resultado = query.getResultList();

		resultado.forEach((p) ->
				System.out.println(p.getNome())
		);
	}

	private void livrosDosAutoresDeCajazeirasComLancamentoEntre(EntityManager em) {
		String jpql = "SELECT l FROM Livro l WHERE EXISTS" +
				"(SELECT a FROM l.autores a WHERE a.endereco.cidade = 'Cajazeiras') AND l.lancamento BETWEEN :inicio AND :fim";
		TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
		LocalDate inicio = LocalDate.of(2019, 1, 1);
		LocalDate fim = LocalDate.of(2019,12,12);

		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);


		List<Livro> resultado = query.getResultList();

		resultado.forEach((l)->
				System.out.println(l.getTitulo())
		);
	}

	private void livrosDosAutoresQueComecamComALetra(EntityManager em) {
		String jpql = "SELECT l FROM Livro l WHERE EXISTS " +
				"(SELECT a FROM l.autores a WHERE a.nome LIKE :letra)";
		TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);

		String letra = "J%";
		query.setParameter("letra", letra);

		List<Livro> resultado = query.getResultList();

		resultado.forEach((l)->
				System.out.println(l.getTitulo())
		);
	}

}
