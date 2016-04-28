package enter.lzj.car.servlet;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.itcast.commons.CommonUtils;
import enter.lzj.car.daomain.Form4Car;
import enter.lzj.car.service.Service;
import enter.lzj.user.domain.Form4User;

public class Action4Car extends MappingDispatchAction
{
	@Resource
	private Service carService;

	public ActionForward carQueryAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		String username = request.getParameter("username");
		List<?> list = carService.queryAll("from Form4Car where username=\'"
				+ username + "\'");
		if (list.size() != 0)
		{
			request.setAttribute("list", list);
			return mapping.findForward("carforward");
		}
		return mapping.findForward("carisnothing");
	}

	public ActionForward addCar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		Form4User p = (Form4User) request.getSession().getAttribute(
				"login_user");
		Form4Car f4 = (Form4Car) form;
		if (p == null)
		{

			return null;
		}
		if (carService.queryAll(
				"from Form4Car where username=\'" + f4.getUsername() + "\'")
				.size() == 0)
		{
			f4.setUuid(CommonUtils.uuid());
			f4.setTotals(f4.getPrice() * f4.getNumbers());
			/*
			 * System.out.println(f4.getAuthor() + ":" + f4.getBookname() + ":"
			 * + f4.getGoods() + ":" + f4.getImage() + ":" + f4.getNumbers() +
			 * ":" + f4.getTotals() + ":" + f4.getUuid() + ":" +
			 * f4.getUsername() + ":" + f4.getPrice());
			 */
			carService.save(f4);
			return mapping.findForward("car_add_success");
		}
		if (carService.queryAll(
				"from Form4Car where username=\'" + f4.getUsername() + "\'")
				.size() == 0)
		{
			f4.setUuid(CommonUtils.uuid());
			f4.setTotals(f4.getPrice() * f4.getNumbers());
			carService.save(f4);
			return mapping.findForward("car_add_success");
		}
		if (carService.queryAll(
				"from Form4Car where goods=\'" + f4.getGoods()
						+ "\' and username=\'" + f4.getUsername() + "\'")
				.size() == 0)
		{
			f4.setUuid(CommonUtils.uuid());
			f4.setTotals(f4.getPrice() * f4.getNumbers());
			carService.save(f4);
			return mapping.findForward("car_add_success");
		}
		Form4Car f = (Form4Car) carService.queryAll(
				"from Form4Car where goods=\'" + f4.getGoods()
						+ "\' and username=\'" + f4.getUsername() + "\'")
				.get(0);
		int in = f.getNumbers();
		int in1 = f4.getNumbers();
		double total = f.getTotals();
		double totals = f4.getPrice() * f4.getNumbers() + f.getTotals();
		f.setNumbers((in + in1));
		f.setTotals(totals);
		carService.update(f);
		return mapping.findForward("car_add_success");
	}
}
