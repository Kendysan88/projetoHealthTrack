package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.exception.DBException;

public interface DAOInterface<T> {

	public void create(T record) throws DBException;
	public void destroy(int ...recordId) throws DBException;
	public List<T> getAll();
	public T searchById(int ...recordId);
	public void update(T record) throws DBException;

}
