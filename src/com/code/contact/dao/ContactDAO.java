package com.code.contact.dao;

import java.util.List;

import com.code.contact.model.Contacts;

/**
 * @author Aqeel
 *
 */
public interface ContactDAO {
	public void saveOrUpdate(Contacts contact);
	public int delete(int contactId);
	public Contacts get(int contactId);
	public List<Contacts> list();
}
