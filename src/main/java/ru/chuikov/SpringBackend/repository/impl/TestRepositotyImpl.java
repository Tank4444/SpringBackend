package ru.chuikov.SpringBackend.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.chuikov.SpringBackend.entity.test;
import ru.chuikov.SpringBackend.repository.TestRepository;
import ru.chuikov.SpringBackend.repository.generic.impl.GenericDaoImpl;

@Repository
@Transactional
public class TestRepositotyImpl extends GenericDaoImpl<test> implements TestRepository {
	// Для работы нового репозитория нужно добавить конструктор
	// В котром необходимо задать нужный класс
	public TestRepositotyImpl() {
		setClas(test.class);
	}
	
	public test findUniqueBy(String propertyName, Object value) {
		return super.findUniqueBy(propertyName, value);
	}

	public List<test> findBy(String propertyName, Object value) {
		return super.findBy(propertyName, value);
	}

	public List<test> getByIds(String IDS) {
		return super.getByIds(IDS);
	}

	public void insert(test entity) {
		super.insert(entity);
	}

	public void update(test entity) {
		super.update(entity);

	}
}
