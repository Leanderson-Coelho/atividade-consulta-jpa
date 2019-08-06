package mapeamento;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-05T17:55:55")
@StaticMetamodel(Aluno.class)
public class Aluno_ extends PessoaUm_ {

    public static volatile SingularAttribute<Aluno, String> matricula;
    public static volatile SingularAttribute<Aluno, LocalDate> dataIngresso;
    public static volatile SingularAttribute<Aluno, String> turma;

}