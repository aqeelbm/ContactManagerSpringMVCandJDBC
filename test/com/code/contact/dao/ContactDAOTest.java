package com.code.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.code.contact.model.Contacts;

/**
 * @author Aqeel
 *
 */
class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;

	
	
	
	@BeforeEach
	void doBeforeTest() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("workingwithmysql");
		
		dao = new ContactDAOImpl(dataSource);
	}
	
	
	
	@Test
	void testSaveOrUpdate() {
		Contacts contacts = new Contacts(5, "123", "123", "123", "123");
//		int result =
		dao.saveOrUpdate(contacts);
	}

	
	
	@Test
	void testDelete() {
		Integer id = 5;
		int result = dao.delete(id);
		
		assertNotNull(result);
	}

	
	
	@Test
	void testGet() {
		Integer id=0;
		Contacts contact = dao.get(id);
		
		assertNotNull(contact);
	}

	
	
	
	@Test
	void testList() {
		List<Contacts> ContactsList = dao.list();
		
		assertTrue(!ContactsList.isEmpty());
	}

}
