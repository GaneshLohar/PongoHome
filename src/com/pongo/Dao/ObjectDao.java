package com.pongo.Dao;

import java.io.Serializable;

public interface ObjectDao 
{
	public void saveObject(Object entity);
	
	public void deleteObject(Object entity);

	public void updateObject(Object entity);
	
	public <T> T getObjectByParam(Class<T> entity,String param,Object obj);
	
	public <T> T getObjectById(Class<T> entity,Serializable id);
	
	public<T> T listObject(Class<T> entity,String id);
	
	public<T> T listObjectAsc(Class<T> entity,String id);
	
	public<T> T listObjectForDashboard(Class<T> entity,String id);
	
	public<T> T listObjectByParam(Class<T> entity,String param,String orderBy,Object obj);
	
	public <T> T listObjectByParamAsc(Class<T> entity, String param, String orderBy, Object obj);
	
}