package enter.lzj.filter.category.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enter.lzj.filter.category.domain.Form4Book;
import enter.lzj.filter.category.domain.Form4Category;
import enter.lzj.filter.category.service.Service;

@Transactional//注入事物管理器。
public class ServiceBean implements Service
{
	@Resource//将SessionFactory修饰过的工厂通过标签注入。
	private SessionFactory sessionFactory;

	public void save(Form4Category person)
	{
		// 这种获取的session对象是有hibernate框架管理的session,不受spring容器管理。
		// Session session=sessionFactory.openSession();
		sessionFactory.getCurrentSession().persist(person);
		// persist(person)比save方法更规范一些。
	}

	public void update(Form4Category person)
	{
		sessionFactory.getCurrentSession().update(person);
		// merge（）方法比之update（）方法更规范。
	}

	public void delete(Integer personID)
	{
		// 首先需要清楚hibernate的删除机制，需要给出删除的隐射对象，
		//这里我们可以用我们自己的查询的方法，但这里却没用，因load方法获取的更省资源。
		sessionFactory.getCurrentSession()
				.delete(sessionFactory.getCurrentSession().load(Form4Category.class,
						personID));
	}
	//对这些查询方法不需要事物管理，可以减轻负担。
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Form4Category query(Integer personID)
	{
		return (Form4Category) sessionFactory.getCurrentSession().get(Form4Category.class,
				personID);
	}
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Form4Category> queryAll()
	{
		return sessionFactory.getCurrentSession().createQuery("from Form4Category").list();
	}
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Form4Book> queryAll(String sql)
	{
		return sessionFactory.getCurrentSession().createQuery(sql).list();
	}
}
