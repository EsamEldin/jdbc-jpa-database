package com.usemy.hibernate.jpa.course.jdbcjpadatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.usemy.hibernate.jpa.course.jdbcjpadatabase.entity.Person;
import com.usemy.hibernate.jpa.course.jdbcjpadatabase.jdbc.PersonJdbcDao;
import com.usemy.hibernate.jpa.course.jdbcjpadatabase.jpa.PersonJpaRepository;

@SpringBootApplication
public class JdbcJpaDatabaseApplication implements CommandLineRunner {

    private Logger logger=LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    PersonJdbcDao personDao;
    
    @Autowired
    PersonJpaRepository personJpa;
    
    public static void main(String[] args) {
		SpringApplication.run(JdbcJpaDatabaseApplication.class, args);
	}

    /* (non-Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {
       
        
        logger.info("All users -> {}",personDao.findAll());  
        logger.info("User id 10001 -> {}",personDao.findById(1001));  
        
        logger.info("inserting id 1004 -> {}",personDao.insert(new Person(1004,"tara","Berlin",new Date())));
        logger.info("updating id 1001 -> {}",personDao.update(new Person(1001,"taraaaaaa","Berlinaaaa",new Date())));
        
        logger.info("User id using jpa 10001 -> {}",personJpa.findById(1001));
        logger.info("inserting id 1005 -> {}",personJpa.insert(new Person(1005,"mona","cairo",new Date())));
        
        logger.info("find all users namedquery -> {}",personJpa.findAll());
    }
	
}
