package mvc.vo;

import java.util.ArrayList;

public class Member
{
	private String email;
	private String password;
	private String name;
	private String address;
	private String phoneNumber;
	private ArrayList<String> allergy;
	
	public Member() {}
	public Member(String email, String password, String name, String address, String phoneNumber, ArrayList<String> allergy)
	{
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.allergy = allergy;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<String> getAllergy()
	{
		return allergy;
	}
	public void setAllergy(ArrayList<String> allergy)
	{
		this.allergy = allergy;
	}	
}
