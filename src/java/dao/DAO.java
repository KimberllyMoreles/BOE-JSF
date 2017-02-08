package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAO<T> {

    private EntityManager em;
    
    public DAO() {
        if (this.em == null) {
            this.em = Persistence.createEntityManagerFactory("BOEPU").createEntityManager();       
        }
    }
   
    public void insert(T object){  
        this.em.getTransaction().begin();
        this.em.persist(object);
        this.em.getTransaction().commit();
    }
    
    public void update(T object){
        this.em.getTransaction().begin();
        this.em.merge(object);
        this.em.getTransaction().commit();        
    }    
    
    public void delete(T object){
        this.em.getTransaction().begin();
        this.em.remove(object);
        this.em.getTransaction().commit();        
    }
    
    public T get(Class<T> c, long id){
        return this.em.find(c, id);
    }
    
    public List<T> getAll(Class<T> c, String sql){
        Query query = this.em.createNamedQuery(sql, c);
        return query.getResultList();
    }
    
    public void close(){
        this.em.close();
    }
}
