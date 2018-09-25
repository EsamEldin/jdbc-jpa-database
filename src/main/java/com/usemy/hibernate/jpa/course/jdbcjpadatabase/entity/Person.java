package com.usemy.hibernate.jpa.course.jdbcjpadatabase.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */

@Entity
@Table(name="Person")
/*
 @NamedQuery:It puts them in a more central place rather than scattered in code with random createQuery() calls; and
Build processes can validate the queries (really useful).
 */
@NamedQueries({
@NamedQuery(name="find_all_persons",query="select p from Person p"),
@NamedQuery(name="Person.name", query="from Person p where p.name = ?1")})
public class Person {
    
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    private String location;
    
    private Date birthDate;
    
    
    public Person(){}
    
    
    /**
     * @param id
     * @param name
     * @param location
     * @param birthDate
     */
    public Person(int id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public Date getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
    }
    
    
    
    

}
