package persister;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class App {

//    @Inject
    
    @PersistenceContext
	EntityManager em;
    Persister persister = new Persister();
    @PostConstruct
    private void init(){
//        persister.initPersistence(em);
    }


}
