package enter.lzj.filter.category.domain;

import org.apache.struts.action.ActionForm;

public class Form4Category extends ActionForm
{
	private String cid;
	private String cname;
	public String getCid()
	{
		return cid;
	}
	public void setCid(String cid)
	{
		this.cid = cid;
	}
	public String getCname()
	{
		return cname;
	}
	public void setCname(String cname)
	{
		this.cname = cname;
	}
}
