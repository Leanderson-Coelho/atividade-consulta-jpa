package persisterQuestao2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import mapeamento.questão2.Area;
import mapeamento.questão2.Escritor;
import mapeamento.questão2.Publicacao;
import mapeamento.questão2.Revisor;



public class Persister2 {
    
    public Persister2() {}
    
    public void initPersistence(EntityManager em) {
        
        List<Publicacao> publicacoes = new ArrayList<>();
        List<Area> area = new ArrayList<>();
        Publicacao publicacao = new Publicacao();
        
        Escritor escritor1 = new Escritor(5,publicacoes,1,"Jose",LocalDate.of(1997, 1, 1));
        Escritor escritor2 = new Escritor(1,publicacoes,3,"Ana",LocalDate.of(1998, 1, 1));
        Escritor escritor3 = new Escritor(2,publicacoes,5,"Carlos",LocalDate.of(1999, 1, 1));
        Escritor escritor4 = new Escritor(7,publicacoes,7,"Caio",LocalDate.of(1994, 1, 1));
        Escritor escritor5 = new Escritor(2,publicacoes,9,"Maria",LocalDate.of(1995, 5, 1));
        
        Revisor revisor1 = new Revisor("7.7",publicacoes,2,"Joao",LocalDate.of(1996, 5, 6));
        Revisor revisor2 = new Revisor("3.7",publicacoes,4,"Carla",LocalDate.of(1997, 5, 6));
        Revisor revisor3 = new Revisor("5.7",publicacoes,6,"Vitoria",LocalDate.of(1998, 5, 6));
        Revisor revisor4 = new Revisor("6.7",publicacoes,8,"Pedro",LocalDate.of(1999, 5, 6));
        Revisor revisor5 = new Revisor("9.7",publicacoes,10,"Katarina",LocalDate.of(1991, 5, 6));
        
        Area area1 = new Area(1,"indústria",publicacao);
        Area area2 = new Area(2,"TI",publicacao);
        Area area3 = new Area(3,"Agronegocio",publicacao);
        Area area4 = new Area(4,"Financias",publicacao);
        Area area5 = new Area(5,"Ciencias",publicacao);
        
        Publicacao publicacao1 = new Publicacao(1,"Sondagem Industrial",area,revisor1,escritor1);
        Publicacao publicacao2 = new Publicacao(2,"Java beans",area,revisor2,escritor2);
        Publicacao publicacao3 = new Publicacao(3,"O agronegócio da soja nos contextos mundial e brasileiro",area,revisor3,escritor3);
        Publicacao publicacao4 = new Publicacao(4,"A sub-reação a recompras de ações no mercado aberto",area,revisor4,escritor4);
        Publicacao publicacao5 = new Publicacao(5,"Projeto de Ciência para o Brasil",area,revisor5,escritor5);
        
        publicacoes.add(publicacao1);
        escritor1.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao1);
        
        publicacoes.add(publicacao2);
        escritor2.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao2);
        
        publicacoes.add(publicacao3);
        escritor3.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao3);
        
        publicacoes.add(publicacao4);
        escritor4.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao4);
        
        publicacoes.add(publicacao5);
        escritor5.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao5);
        
        
        publicacoes.add(publicacao1);
        revisor1.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao1);
        
        publicacoes.add(publicacao2);
        revisor2.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao2);
        
        publicacoes.add(publicacao3);
        revisor3.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao3);
        
        publicacoes.add(publicacao4);
        revisor4.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao4);
        
        publicacoes.add(publicacao5);
        revisor5.setPublicacoes(publicacoes);
        publicacoes.remove(publicacao5);
        
        area1.setPublicacao(publicacao1);
        area2.setPublicacao(publicacao2);
        area3.setPublicacao(publicacao3);
        area4.setPublicacao(publicacao4);
        area5.setPublicacao(publicacao5);
        
        area.add(area1);
        publicacao1.setAreas(area);
        area.remove(area1);
        
        area.add(area2);
        publicacao2.setAreas(area);
        area.remove(area2);
        
        area.add(area3);
        publicacao3.setAreas(area);
        area.remove(area3);
        
        area.add(area4);
        publicacao4.setAreas(area);
        area.remove(area4);
        
        area.add(area5);
        publicacao5.setAreas(area);
        area.remove(area5);
       
        em.persist(revisor1);
        em.persist(revisor2);
        em.persist(revisor3);
        em.persist(revisor4);
        em.persist(revisor5);
        
        em.persist(escritor1);
        em.persist(escritor2);
        em.persist(escritor3);
        em.persist(escritor4);
        em.persist(escritor5);
        
        em.persist(area1);
        em.persist(area2);
        em.persist(area3);
        em.persist(area4);
        em.persist(area5);
        
        em.persist(publicacao1);
        em.persist(publicacao2);
        em.persist(publicacao3);
        em.persist(publicacao4);
        em.persist(publicacao5);
    }
    
}
