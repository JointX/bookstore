package enter.lzj.user.service;


import java.util.List;

import enter.lzj.car.daomain.Form4Car;
import enter.lzj.user.domain.Form4User;

public interface Service
{

	public abstract void save(Form4User person);

	public abstract void update(Form4User person);

	public abstract void delete(String personID);

	public abstract Form4User query(String uuid);

	public abstract List<?> queryAll();
	public abstract List<Form4User> queryAll(String sql);
}