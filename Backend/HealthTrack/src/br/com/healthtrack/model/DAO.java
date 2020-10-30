package br.com.healthtrack.model;

import java.util.List;

public interface DAO<T> {

	void create(T record);

	void destroy(int recordId);

	List<T> getAll();

	T searchById(int recordId);

	void update(T record);

}
