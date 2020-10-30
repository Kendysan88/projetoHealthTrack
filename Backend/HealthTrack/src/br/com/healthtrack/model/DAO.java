package br.com.healthtrack.model;

import java.util.List;

public interface DAO<T> {

	public void create(T record);
	public void destroy(int recordId);
	public List<T> getAll();
	public T searchById(int recordId);
	public void update(T record);

}
