package enter.lzj.user.domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class Form4User extends ValidatorForm
{
	private String uid;
	private String username;
	private String password;
	private String email;
	private String code;
	private boolean state;

	public Form4User()
	{
	}

	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public boolean isState()
	{
		return state;
	}

	public void setState(boolean state)
	{
		this.state = state;
	}

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1)
	{
		return super.validate(arg0, arg1);
	}

}