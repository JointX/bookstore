package enter.lzj.myorder.service;


import java.util.List;

import enter.lzj.myorder.domain.Form4Order;


public interface Service
{

	public abstract void save(Object person);

	public abstract void update(Object person);

	public abstract void delete(Object obj,String personID);

	public abstract Object query(Object obj,String uuid);

	public abstract List<?> queryAll();
	public abstract List<?> queryAll(String sql);
}