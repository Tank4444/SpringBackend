package ru.chuikov.SpringBackend.repository.generic;

import java.util.List;

public interface GenericDao<T> {
	   public T findUniqueBy (String propertyName, Object value);
	   public List<T> findBy (String propertyName, Object value);
	   public List<T> getByIds (String IDS);
	   public void insert (T entity) ;
	   public void update (T entity) ;
}
