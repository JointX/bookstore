package enter.lzj.car.daomain;

import org.apache.struts.action.ActionForm;

public class Form4Car extends ActionForm
{
	private String username;
	private String uuid;
	private String goods;
	private int numbers;
	private double price;
	private double totals;
	private String image;
	private String bookname;
	private String author;
	public int getNumbers()
	{
		return numbers;
	}
	public void setNumbers(int numbers)
	{
		this.numbers = numbers;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getTotals()
	{
		return totals;
	}
	public void setTotals(double totals)
	{
		this.totals = totals;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUuid()
	{
		return uuid;
	}
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
	public String getGoods()
	{
		return goods;
	}
	public void setGoods(String goods)
	{
		this.goods = goods;
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
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
}
