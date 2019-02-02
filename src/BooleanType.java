
public class BooleanType extends TypePropriete
{

	private static BooleanType instance;
	
	private BooleanType() {};
	
	public static BooleanType getInstance() 
	{
        if (instance == null) 
        {
            synchronized(BooleanType.class) 
            {
                if (instance == null) 
                {
                    instance = new BooleanType();
                }
            }
        }

        return instance;
    }

	@Override
	public boolean compatible(String valeur)
	{
		if(valeur.toLowerCase().compareTo("true")==0 || valeur.toLowerCase().compareTo("false") == 0) return true;
		else return false;
	}

}
