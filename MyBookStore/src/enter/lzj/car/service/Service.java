package enter.lzj.car.service;


import java.util.List;

import enter.lzj.car.daomain.Form4Car;

public interface Service
{

	public abstract void save(Form4Car person);

	public abstract void update(Form4Car person);

	public abstract void delete(String personID);

	public abstract Form4Car query(String uuid);

	public abstract List<?> queryAll();
	public abstract List<?> queryAll(String sql);
}