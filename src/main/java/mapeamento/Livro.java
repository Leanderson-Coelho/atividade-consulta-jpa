package mapeamento;

import conversores.ConversorLocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Livro {

    private String titulo;
    @Id
    private String ISBN;
    @Convert(converter = ConversorLocalDate.class)
    private LocalDate lancamento;
    @ManyToMany
    private List<Autor> autores;

    public Livro() {
    	this.autores = new ArrayList<>();
    }

    public Livro(String titulo, String isbn, LocalDate lancamento) {
        this.titulo = titulo;
        this.ISBN = isbn;
        this.lancamento = lancamento;
        this.autores = new ArrayList<>();
    }

	public Livro(String titulo, String iSBN, LocalDate lancamento, List<Autor> autores) {
		super();
		this.titulo = titulo;
		this.ISBN = iSBN;
		this.lancamento = lancamento;
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public LocalDate getLancamento() {
		return lancamento;
	}

	public void setLancamento(LocalDate lancamento) {
		this.lancamento = lancamento;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
    
	public void setAutor(Autor autor) {
		this.autores.add(autor);
	}

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", ISBN=" + ISBN + ", lancamento=" + lancamento + '}';
    }
    
}
