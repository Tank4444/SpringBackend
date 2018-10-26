package ru.chuikov.SpringBackend.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.SpringBackend.entity.test;
import ru.chuikov.SpringBackend.repository.TestRepository;
import ru.chuikov.SpringBackend.services.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestRepository testRepositoty;

	@Override
	public test findUniqueBy(String propertyName, Object value) {
		return testRepositoty.findUniqueBy(propertyName, value);
	}

	@Override
	public List<test> findBy(String propertyName, Object value) {
		return testRepositoty.findBy(propertyName, value);
	}

	@Override
	public List<test> getByIds(String IDS) {
		return testRepositoty.getByIds(IDS);
	}

	@Override
	public void insert(test entity) {
		testRepositoty.insert(entity);

	}

	@Override
	public void update(test entity) {
		testRepositoty.update(entity);

	}

}
