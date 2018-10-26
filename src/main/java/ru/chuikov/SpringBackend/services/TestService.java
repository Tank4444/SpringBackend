package ru.chuikov.SpringBackend.services;

import java.util.List;

import ru.chuikov.SpringBackend.entity.test;

public interface TestService {
	   public test findUniqueBy (String propertyName, Object value);
	   public List<test> findBy (String propertyName, Object value);
	   public List<test> getByIds (String IDS);
	   public void insert (test entity) ;
	   public void update (test entity) ;
}
