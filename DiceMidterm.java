// Nam Nguyen
// Cmpr 112

public abstract class DiceMidterm 
{
	@SuppressWarnings("unused")
	private int rolls;
	
	public DiceMidterm(int bounces)
	{
		rolls = bounces;
	}
	
	public abstract int Throw();	
}
