package enter.lzj.myorder.servlet;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.itcast.commons.CommonUtils;
import enter.lzj.myorder.domain.Form4Order;
import enter.lzj.myorder.service.Service;
import enter.lzj.user.domain.Form4User;

public class Action4Order extends MappingDispatchAction
{
	@Resource
	private Service orderService;
	public ActionForward orderQueryAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		Form4User f=(Form4User) request.getSession().getAttribute("login_user");
		List<Form4Order> list=(List<Form4Order>) orderService.queryAll("from Form4Order where username=\'"+f.getUsername()+"\'");
		if(list.size()==0)
		{
			return mapping.findForward("no_order");
		}
		request.setAttribute("list", list);
		return mapping.findForward("my_order");
	}
	public ActionForward pay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		if(request.getSession().getAttribute("login_user")==null)
		{
			return mapping.findForward("pay_fail");
		}
		Form4Order f=(Form4Order) form;
		f.setOuid(CommonUtils.uuid());
		f.setState(true);
		orderService.save(f);
		return mapping.findForward("pay_success");
	}
}
