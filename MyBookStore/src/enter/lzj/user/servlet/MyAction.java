package enter.lzj.user.servlet;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.commons.CommonUtils;
import enter.lzj.user.domain.Form4User;
import enter.lzj.user.service.Service;

public class MyAction extends MappingDispatchAction
{
	// 不难发现获取service对象的过程，使得struts和spring耦合在一起，我们可以通过注入的方式来获取service对象。
	// 1.需要将我们写的action注入spring容器,因为它要我们Action去获取Request对象才能得到spring容器。
	// 2.以及在struts配置一个由spring框架写的过程处理器org.springframework.web.struts.DelegatingRequestProcessor，
	// 3.替换原来的那个ActionServlet的代理处理器processorClass,也就是对原有的一个装饰，配合我们的注入，实质是获取我们在Action中配置的name属性，也就
	// 是在代理还没分配处理器action前获取这个信息，这就是它要求beans中注入我们的action对类的时候引用name一定要和struts中配置的对应action的路径一致，这样就可以找对myaction,然后找对
	// Request，然后找对spring容器，再从容器中找对已经注入好的service接口的子事例对象注入。
	// 4.下面的update模块已经注入方式解耦，思考应对下面的一个myaction出个多种类型的Action请求该如何实现注入。解决方案让我们的myaction拥有多个name;
	@Resource
	private Service userService;

	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		/*
		 * // 获取spring容器 wapp =
		 * WebApplicationContextUtils.getWebApplicationContext(request
		 * .getServletContext()); // 获取service Service se = (Service)
		 * wapp.getBean("personService");
		 */
		Form4User p = (Form4User) form;
		if (p.getUid() == null && p.getCode() == null)
		{
			String uuid = CommonUtils.uuid();
			p.setUid(uuid);
			String code = CommonUtils.uuid();
			p.setCode(code);
		}
		userService.save(p);
		return mapping.findForward("alive");
	}

	public ActionForward alive(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		Form4User p = (Form4User) form;
		String uuid = p.getUid();
		if (userService.query(uuid) != null)
		{
			return mapping.findForward("success");
		}
		userService.update(p);
		request.getSession().setAttribute("login_user", p);
		return null;
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		Form4User p = (Form4User) form;
		String sql = "from Form4User where username=\'" + p.getUsername()
				+ "\'and password=\'" + p.getPassword() + "\'";
		List<Form4User> list = userService.queryAll(sql);
		if (list.size() != 0)
		{
			p = list.get(0);
			p.setState(true);
			userService.update(p);
			request.getSession().setAttribute("login_user", p);
			return mapping.findForward("frame");
		}
		return mapping.findForward("fail");
	}

	public ActionForward muenbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		return mapping.findForward("muenbar");
	}
	public ActionForward exit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		request.getSession().invalidate();
		return mapping.findForward("frame");
	}

}
