package mapeamento.questão2;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mapeamento.questão2.Publicacao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-10T12:42:51")
@StaticMetamodel(Escritor.class)
public class Escritor_ extends PessoaDois_ {

    public static volatile CollectionAttribute<Escritor, Publicacao> publicacoes;
    public static volatile SingularAttribute<Escritor, Integer> premios;

}