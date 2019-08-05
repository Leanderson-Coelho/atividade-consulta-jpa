package mapeamento;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mapeamento.Livro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-01T16:22:18")
@StaticMetamodel(Autor.class)
public class Autor_ extends PessoaUm_ {

    public static volatile ListAttribute<Autor, Livro> livros;
    public static volatile SingularAttribute<Autor, String> instituicaoVinculada;

}