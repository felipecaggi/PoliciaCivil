/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author felipecaggi
 */
public class DAO {
    
    private final EntityManagerFactory factory;
    
    private static DAO dao;
    
    public DAO() {
        
        factory = Persistence.createEntityManagerFactory("policiaPU");      //Creates Entity Manager Factory from the settings defined in the persistence unit "policiaPU"
        
    }
    
    public static DAO getDao() {
        
        if (dao == null)
            dao = new DAO();
        
        return dao;
        
    }

    public boolean persist(Object object) {
        
        EntityManager manager = null;
        
        try {
            
            manager = factory.createEntityManager();         //Create a new application-managed EntityManager
            
            manager.getTransaction().begin();                 //Return the resource-level EntityTransaction object initialized
            
            manager.persist(object);                           //Make an instance managed and pesistent
            
            manager.getTransaction().commit();               //Commit the current resource transaction
            
            return true;
            
        } catch (IllegalStateException e) {                    //Signals that a method has been invoked at an illegal or inappropriate time
            
            if (manager.getTransaction() != null)
                manager.getTransaction().rollback();         //Roll back the current resource transaction
            
            return false;
            
        } finally {
            
            try {        
                
                manager.close();                               //Close the application-managed entity manager
                
            } catch (IllegalStateException e) {
                
                throw e;
                
            }
            
        }
        
    }
    
    public Object find(Object object, int id) {
        
        EntityManager manager = null;
        
        try {
            
            manager = factory.createEntityManager();            
            
            return manager.find(object.getClass(), id);        //Search entity by primary key and returns the corresponding object 
                        
        } catch (IllegalStateException e) {                       
            
            if (manager.getTransaction() != null)
                manager.getTransaction().rollback();            
            
            return null;
                        
        } finally {
            
            try {        
                
                manager.close();                                
                
            } catch (IllegalStateException e) {
                
                throw e;
                
            }
            
        }
        
    }

    public boolean merge(Object object) {
        
        EntityManager manager = null;
        
        try {
            
            manager = factory.createEntityManager();
            
            manager.getTransaction().begin();
            
            manager.merge(object);                             //Merge the state of the given entity into the current persistence context
            
            manager.getTransaction().commit();
            
            return true;
                        
        } catch (IllegalStateException e) {                       
            
            if (manager.getTransaction() != null)
                manager.getTransaction().rollback();            
            
            return false;
                        
        } finally {
            
            try {        
                
                manager.close();                                
                
            } catch (IllegalStateException e) {
                
                throw e;
                
            }
            
        }
        
    }
    
    public boolean remove(Object object) {
        
        EntityManager manager = null;
        
        try {
            
            manager = factory.createEntityManager();
            
            manager.getTransaction().begin();
            
            manager.remove(object);                             //Remove the entity instance
            
            manager.getTransaction().commit();
            
            return true;
                        
        } catch (IllegalStateException e) {                       
            
            if (manager.getTransaction() != null)
                manager.getTransaction().rollback();            
            
            return false;
                        
        } finally {
            
            try {        
                
                manager.close();                                
                
            } catch (IllegalStateException e) {
                
                throw e;
                
            }
            
        }
        
    }
    
    public List list(Object object) {
        
        EntityManager manager = null;
        
        try {
            
            manager = factory.createEntityManager();            
            
            return (List) manager.createQuery("from " + object.getClass().getName());        //Return query of all entities corresponding to the object
                        
        } catch (IllegalStateException e) {                       
            
            if (manager.getTransaction() != null)
                manager.getTransaction().rollback();            
            
            return null;
                        
        } finally {
            
            try {        
                
                manager.close();                                
                
            } catch (IllegalStateException e) {
                
                throw e;
                
            }
            
        }
        
    }
  
}