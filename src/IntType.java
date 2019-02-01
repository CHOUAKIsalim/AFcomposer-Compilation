
public class IntType extends PropertyType
{

	private static IntType instance;
	
	private IntType() {};
	
	public static IntType getInstance() 
	{
        if (instance == null) 
        {
            synchronized(IntType.class) 
            {
                if (instance == null) 
                {
                    instance = new IntType();
                }
            }
        }

        return instance;
    }
	
	@Override
	public boolean isCompatible(String valeur)
	{

		return false;
	}

}
