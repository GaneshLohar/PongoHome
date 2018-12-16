package com.pongo.DaoImpl;


import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pongo.Dao.AbstractDao;
import com.pongo.Dao.ObjectDao;



@Transactional
@Repository("objectDao")
public class ObjectDaoImpl extends AbstractDao implements ObjectDao
{
 
	@Override
	public void saveObject(Object entity) {
		persist(entity);
	}

	@Override
	public void deleteObject(Object entity) {
		delete(entity);
	}

	@Override
	public void updateObject(Object entity) {
		saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getObjectByParam(Class<T> entity, String param, Object paramValue) {
		Criteria criteria = getSession().createCriteria(entity)
				.add(Restrictions.eq(param, paramValue));
		return (T) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T listObject(Class<T> entity, String id) {
		Criteria criteria = getSession().createCriteria(entity)
				.addOrder(Order.desc(id));
		return (T) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T listObjectAsc(Class<T> entity, String id) {
		Criteria criteria = getSession().createCriteria(entity)
				.addOrder(Order.asc(id));
		return (T) criteria.list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public <T> T listObjectByParam(Class<T> entity, String param,
			String orderBy, Object obj) {
		Criteria criteria = getSession().createCriteria(entity)
				.add(Restrictions.eq(param, obj))
				.addOrder(Order.desc(orderBy));
		return (T) criteria.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getObjectById(Class<T> entity, Serializable id) {
		return (T) getSession().get(entity, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T listObjectForDashboard(Class<T> entity, String id) {
		Criteria criteria = getSession().createCriteria(entity)
				.addOrder(Order.desc(id))
				.setMaxResults(5);
		return (T) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T listObjectByParamAsc(Class<T> entity, String param,
			String orderBy, Object obj) {
		Criteria criteria = getSession().createCriteria(entity)
				.add(Restrictions.eq(param, obj))
				.addOrder(Order.asc(orderBy));
		return (T) criteria.list();
	}
}
