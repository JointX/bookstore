package enter.lzj.filter.category.service;


import java.util.List;

import enter.lzj.filter.category.domain.Form4Book;
import enter.lzj.filter.category.domain.Form4Category;

public interface Service
{

	public abstract void save(Form4Category person);

	public abstract void update(Form4Category person);

	public abstract void delete(Integer personID);

	public abstract Form4Category query(Integer personID);

	public abstract List<Form4Category> queryAll();
	public abstract List<Form4Book> queryAll(String sql);

}