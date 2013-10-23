// Nam Nguyen
// Cmpr 112

import java.util.Random;

public class OddOrEven 
{
	private int m_val;
	private int m_Val;
	Random randomizer = new Random();
	
	public OddOrEven(int input_number)
	{
		m_val = input_number;
	}
	public OddOrEven()
	{
		m_Val = randomizer.nextInt(101);
	}
	
	public void setValue(int number)
	{
		m_val = number;
	}
	public void setRValue(int rNumber)
	{
		m_Val = rNumber;
	}
	
	public int getRValue()
	{
		return m_Val;
	}
	
	public String OddEven()
	{
		if(m_val % 2 == 0)
		{
			return "Even";
		}
		else
		{
			return "Odd";
		}
	}
	public String OddsOrEvens()
	{
		if(m_Val % 2 == 0)
		{
			return "Even";
		}
		else
		{
			return "Odd";
		}
	}
}
