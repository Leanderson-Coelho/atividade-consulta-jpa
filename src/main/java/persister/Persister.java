package persister;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mapeamento.Aluno;
import mapeamento.Autor;
import mapeamento.Endereco;
import mapeamento.Livro;
import mapeamento.Professor;
import mapeamento.Telefone;
import mapeamento.TelefoneType;


public class Persister {
	
	public Persister() {}
	
	public void initPersistence(EntityManager em) {
		Aluno aluno1 = new Aluno("João", "12345", 22, new Endereco("Rua1", "Bairro1", "Cidade1", "12345-121"), LocalDate.of(1997, 1, 10), "199712001012", LocalDate.of(1997, 1, 10), "2019.1");
		Aluno aluno2 = new Aluno("Maria", "12346", 22, new Endereco("Rua2", "Bairro2", "Cidade2", "12345-122"), LocalDate.of(1997, 1, 10), "199712001013", LocalDate.of(1997, 1, 10), "2019.1");
		Aluno aluno3 = new Aluno("Zé", "12347", 22, new Endereco("Rua3", "Bairro3", "Cidade3", "12345-123"), LocalDate.of(1997, 1, 10), "199712001014", LocalDate.of(1997, 1, 10), "ADS");
		Aluno aluno4 = new Aluno("Juzé", "12348", 22, new Endereco("Rua4", "Bairro4", "Cidade4", "12345-124"), LocalDate.of(1997, 1, 10), "199712001015", LocalDate.of(1997, 1, 10), "ADS");
		Aluno aluno5 = new Aluno("Juão", "12349", 22, new Endereco("Rua5", "Bairro5", "Cidade5", "12345-125"), LocalDate.of(1997, 1, 10), "199712001016", LocalDate.of(1997, 1, 10), "ADS");
		
		Livro livro1 = new Livro("Un livru legual", "19741", LocalDate.of(1997, 1, 13));
		Livro livro2 = new Livro("Mangá em portugues", "19742", LocalDate.of(1997, 1, 11));
		Livro livro3 = new Livro("Ágnam em japonês", "19743", LocalDate.of(1997, 1, 1));
		Livro livro4 = new Livro(":)", "19744", LocalDate.of(1997, 1, 1));
		Livro livro5 = new Livro(":(", "19745", LocalDate.of(1997, 1, 6));
		
		List<Livro> livros1 = new ArrayList<>();
		List<Livro> livros2 = new ArrayList<>();
		
		livros1.addAll(Arrays.asList(livro2, livro3));
		livros2.addAll(Arrays.asList(livro4, livro5));
		
		Autor autor1 = new Autor("José das Couves Pinto", "12315", 22, new Endereco("Rua1", "Bairro1", "Cidade1", "12345-121"), LocalDate.of(1997, 1, 10), "SeiLá");
		Autor autor2 = new Autor("Francisco Tripa", "12325", 22, new Endereco("Rua1", "Bairro1", "Cidade1", "12345-121"), LocalDate.of(1997, 1, 10), "ComoAssim?");
		Autor autor3 = new Autor("Jose Esoj", "12335", 22, new Endereco("Rua1", "Bairro1", "Cidade1", "12345-121"), LocalDate.of(1997, 1, 10), "SeiLá");
		Autor autor4 = new Autor("Maria Airam", "12355", 22, new Endereco("Rua1", "Bairro1", "Cidade1", "12345-121"), LocalDate.of(1997, 1, 10), "ComoAssim?");
		Autor autor5 = new Autor("João Oãoj", "12365", 22, new Endereco("Rua1", "Bairro1", "Cidade1", "12345-121"), LocalDate.of(1997, 1, 10), "Sei Lá... 3?");
		
		autor3.setLivros(livros1);
		autor4.setLivros(livros1);
		autor5.setLivros(livros1);
		
		autor1.setLivros(livros2);
		
		autor2.setLivro(livro1);
		
		List<Autor> autores1 = new ArrayList<>();
		
		autores1.addAll(Arrays.asList(autor3, autor4, autor5));
		
		livro2.setAutores(autores1);
		livro3.setAutores(autores1);
		
		livro4.setAutor(autor1);
		livro5.setAutor(autor1);
		
		livro1.setAutor(autor2);
		
		
		List<Telefone> telefones1 = new ArrayList<>();
                telefones1.add(new Telefone("(83) 99951-5113", TelefoneType.RESIDENCIAL));
                telefones1.add(new Telefone("(83) 99951-5113", TelefoneType.COMERCIAL));
		List<Telefone> telefones2 = new ArrayList<>();
                telefones2.add(new Telefone("(83) 99951-5113", TelefoneType.RESIDENCIAL));
                telefones2.add(new Telefone("(83) 99951-5113", TelefoneType.COMERCIAL));
		List<Telefone> telefones3 = new ArrayList<>();
                telefones3.add(new Telefone("(83) 99951-5113", TelefoneType.RESIDENCIAL));
                telefones3.add(new Telefone("(83) 99951-5113", TelefoneType.COMERCIAL));
		List<Telefone> telefones4 = new ArrayList<>();
                telefones4.add(new Telefone("(83) 99951-5113", TelefoneType.RESIDENCIAL));
                telefones4.add(new Telefone("(83) 99951-5113", TelefoneType.COMERCIAL));
		
                
                
                
                
                Professor professor1 = new Professor("Semnome", "23456", 22, new Endereco("Que atividade fácil", "Bairro", "Nárnia", "12345-123"), LocalDate.of(1997, 1, 29), 6000f, telefones1);
		Professor professor2 = new Professor("Testerson", "23457", 22, new Endereco("Que atividade fácil", "Bairro", "Nárnia", "12345-123"), LocalDate.of(1997, 1, 29), 3000f, telefones2);
		Professor professor3 = new Professor("Agadoisó", "23458", 22, new Endereco("Que atividade fácil", "Bairro", "Nárnia", "12345-123"), LocalDate.of(1997, 1, 29), 12000f, telefones3);
		Professor professor4 = new Professor("Janeiro de Noventaesete", "23459", 22, new Endereco("Que atividade fácil", "Bairro", "Nárnia", "12345-123"), LocalDate.of(1997, 1, 29), 10000f, telefones4);
		Professor professor5 = new Professor("Comnome", "23450", 22, new Endereco("Que atividade fácil", "Bairro", "Nárnia", "12345-123"), LocalDate.of(1997, 1, 29), 5000f);
		
		
		em.persist(aluno1);
		em.persist(aluno2);
		em.persist(aluno3);
		em.persist(aluno4);
		em.persist(aluno5);
	
		em.persist(livro1);
		em.persist(livro2);
		em.persist(livro3);
		em.persist(livro4);
		em.persist(livro5);
		
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);
		em.persist(autor4);
		em.persist(autor5);
		
		em.persist(professor1);
		em.persist(professor2);
		em.persist(professor3);
		em.persist(professor4);
		em.persist(professor5);
		
		
		
		
	}
	
	
}
