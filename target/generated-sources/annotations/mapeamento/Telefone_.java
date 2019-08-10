package mapeamento;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mapeamento.TelefoneType;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-10T12:42:51")
@StaticMetamodel(Telefone.class)
public class Telefone_ { 

    public static volatile SingularAttribute<Telefone, TelefoneType> tipo;
    public static volatile SingularAttribute<Telefone, String> numero;
    public static volatile SingularAttribute<Telefone, Integer> id;

}