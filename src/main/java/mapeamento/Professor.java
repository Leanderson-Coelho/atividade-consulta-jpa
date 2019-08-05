package mapeamento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Professor extends PessoaUm {

    private Float salario;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Telefone> telefones;

    public Professor() {
        super();
    }

    public Professor(String nome, String cpf, Integer idade, Endereco endereco, LocalDate dataNasc, Float salario,
            List<Telefone> telefones) {
        super(nome, cpf, idade, endereco, dataNasc);
        this.salario = salario;
        this.telefones = telefones;
    }

    public Professor(String nome, String cpf, Integer idade, Endereco endereco, LocalDate dataNasc, Float salario) {
        super(nome, cpf, idade, endereco, dataNasc);
        this.salario = salario;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Professor{" + "salario=" + salario + ", telefones=" + telefones + '}';
    }
    
}
