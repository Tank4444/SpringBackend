package ru.chuikov.SpringBackend.repository;

import java.util.List;

import ru.chuikov.SpringBackend.entity.test;

public interface TestRepository {
	public test findUniqueBy(String propertyName, Object value);

	public List<test> findBy(String propertyName, Object value);

	public List<test> getByIds(String IDS);

	public void insert(test entity);

	public void update(test entity);
}
