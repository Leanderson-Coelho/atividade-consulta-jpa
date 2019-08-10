package persisterQuestao2;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class App2 {

    @PersistenceContext
    EntityManager em;
    Persister2 persister = new Persister2();
    @PostConstruct
    private void init(){
    	persister.initPersistence(em);

    }

}
