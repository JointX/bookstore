package enter.lzj.myorder.domain;

import org.apache.struts.action.ActionForm;

public class Form4Order extends ActionForm
{
	private String ouid;
	private String carid;
	private String username;
	private boolean state;
	private String image;
	private String bookname;
	public String getOuid()
	{
		return ouid;
	}
	public void setOuid(String ouid)
	{
		this.ouid = ouid;
	}
	public String getCarid()
	{
		return carid;
	}
	public void setCarid(String carid)
	{
		this.carid = carid;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public boolean isState()
	{
		return state;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public String getBookname()
	{
		return bookname;
	}
	public void setBookname(String bookname)
	{
		this.bookname = bookname;
	}
	
}
