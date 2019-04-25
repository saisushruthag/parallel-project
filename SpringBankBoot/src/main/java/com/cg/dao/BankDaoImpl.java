package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.model.CustomerDetails;

@Repository
@Component("bankDao")
public class BankDaoImpl implements BankDao {

	@PersistenceContext
	EntityManager entityManager;
	public CustomerDetails register(CustomerDetails cd) {
		// TODO Auto-generated method stub
		//ApplicationContext context = new ;
		entityManager.persist(cd);
		return cd;
	}
	public int login(CustomerDetails c) {
		// TODO Auto-generated method stub
		int accountNo = 0;
		//ApplicationContext context=new ClassPathXmlApplicationContext("hibernate.cfg.xml");		
		//entityManager.persist(c);
		CustomerDetails cd = entityManager.find(CustomerDetails.class, c.getAccountNo());
		if(cd.getPassword().equals(c.getPassword())) {
			accountNo = c.getAccountNo(); 
		}
		return accountNo;
	}

	

}
