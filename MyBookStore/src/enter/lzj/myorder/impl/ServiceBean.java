package enter.lzj.myorder.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enter.lzj.myorder.domain.Form4Order;
import enter.lzj.myorder.service.Service;


@Transactional//注入事物管理器。
public class ServiceBean implements Service
{
	@Resource//将SessionFactory修饰过的工厂通过标签注入。
	private SessionFactory sessionFactory;

	public void save(Object person)
	{
		// 这种获取的session对象是有hibernate框架管理的session,不受spring容器管理。
		// Session session=sessionFactory.openSession();
		sessionFactory.getCurrentSession().save(person);
		// persist(person)比save方法更规范一些。
	}

	public void update(Object person)
	{
		sessionFactory.getCurrentSession().update(person);
		// merge（）方法比之update（）方法更规范。
	}

	public void delete(Object obj,String personID)
	{
		// 首先需要清楚hibernate的删除机制，需要给出删除的隐射对象，
		//这里我们可以用我们自己的查询的方法，但这里却没用，因load方法获取的更省资源。
		sessionFactory.getCurrentSession()
				.delete(sessionFactory.getCurrentSession().load(obj.getClass(),
						personID));
	}
	//对这些查询方法不需要事物管理，可以减轻负担。
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Object query(Object obj,String personID)
	{
		return  sessionFactory.getCurrentSession().get(obj.getClass(),
				personID);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Object> queryAll()
	{
		//这里的Fom4User与我们映射文件中的formbean对象的类名一致，不是数据库表名，切记！
		return sessionFactory.getCurrentSession().createQuery("from Form4Order").list();
	}
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Object> queryAll(String sql)
	{
		return sessionFactory.getCurrentSession().createQuery(sql).list();
	}
}
