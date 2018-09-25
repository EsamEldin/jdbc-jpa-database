package com.usemy.hibernate.jpa.course.jdbcjpadatabase.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.usemy.hibernate.jpa.course.jdbcjpadatabase.entity.Person;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Repository
@Transactional // prefered more to be used with service layer
public class PersonJpaRepository {
    
    @PersistenceContext
    EntityManager entityManager;
    
    
    // here 
    public List<Person> findAll(){
       TypedQuery<Person> namedQuery=entityManager.createNamedQuery("find_all_persons", Person.class);
       return namedQuery.getResultList();
    }
    
    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }
    
    public Person update(Person person){
        return entityManager.merge(person);
    }
    
    public Person insert(Person person){
        return entityManager.merge(person);
    }
    public void delete(int id){
        Person person=findById(id);
        
        entityManager.remove(person);
    }
    
    
    

}
