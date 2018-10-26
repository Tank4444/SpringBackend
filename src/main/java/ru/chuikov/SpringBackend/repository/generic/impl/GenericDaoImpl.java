package ru.chuikov.SpringBackend.repository.generic.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import ru.chuikov.SpringBackend.repository.generic.GenericDao;

@Repository
@Scope("prototype")
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	private Class<T> clas;

	@Autowired
	private SessionFactory sessionFactory;

	public void setClas(final Class<T> clasToSet) {
		clas = clasToSet;
	}

	// Функции по заданию
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public T findUniqueBy(String propertyName, Object value) {
		Criteria criteria = getCurrentSession().createCriteria(clas);
		criteria.add(Restrictions.eq(propertyName, value));
		return (T) criteria.uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<T> findBy(String propertyName, Object value) {
		Criteria criteria = getCurrentSession().createCriteria(clas);
		criteria.add(Restrictions.eq(propertyName, value));
		return criteria.list();
	}

	@Override
	public List<T> getByIds(String IDS) {
		List<T> result = new ArrayList<T>();
		T resp;
		for (String str : IDS.split(" ")) {
			resp = findUniqueBy("id",Long.parseLong(str));
			if (resp != null)
				result.add(resp);
		}
		return result;
	}

	@Override
	public void insert(T entity) {
		getCurrentSession().persist(entity);
	}

	@Override
	public void update(T entity) {
		getCurrentSession().merge(entity);
		//getCurrentSession().saveOrUpdate(entity);
	}

	// CRUD операции
	public T findOne(final long id) {
		return (T) getCurrentSession().get(clas, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clas.getName()).list();
	}

	public void save(final T entity) {
		getCurrentSession().persist(entity);
	}

	public void delete(final T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(final long id) {
		final T entity = findOne(id);
		delete(entity);
	}

}
