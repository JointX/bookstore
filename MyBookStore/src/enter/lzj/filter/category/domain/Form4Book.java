package enter.lzj.filter.category.domain;

import org.apache.struts.action.ActionForm;

public class Form4Book extends ActionForm
{
	private String bid;
	private String bname;
	private String price;
	private String author;
	private String isdel;
	private String cid;
	private String image;
	public String getBid()
	{
		return bid;
	}
	public void setBid(String bid)
	{
		this.bid = bid;
	}
	public String getBname()
	{
		return bname;
	}
	public void setBname(String bname)
	{
		this.bname = bname;
	}
	public String getPrice()
	{
		return price;
	}
	public void setPrice(String price)
	{
		this.price = price;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getIsdel()
	{
		return isdel;
	}
	public void setIsdel(String isdel)
	{
		this.isdel = isdel;
	}
	public String getCid()
	{
		return cid;
	}
	public void setCid(String cid)
	{
		this.cid = cid;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
}
