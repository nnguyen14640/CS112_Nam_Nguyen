// Nam Nguyen
// Cmpr 112

public class OddOrEven 
{
	private int m_val;
	
	public OddOrEven(int input_number)
	{
		m_val = input_number;
	}
	
	public void setValue(int number)
	{
		m_val = number;
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
}
