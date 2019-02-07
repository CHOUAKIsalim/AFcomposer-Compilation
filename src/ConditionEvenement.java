
public class ConditionEvenement extends Evenement
{
	private Propriete proprieteCondition;
	private String valeurCondition;
	private String typeCondition;

	public ConditionEvenement(String nom, Propriete proprieteCondition, String valeurCondition, String typeCondition)
	{
		super(nom);
		this.proprieteCondition = proprieteCondition;
		this.valeurCondition = valeurCondition;
		this.typeCondition = typeCondition;
	}

	public int evaluerCondition()
	{
		if(typeCondition.compareTo("=")==0)
		{
			if(proprieteCondition.getValeur().compareTo(valeurCondition)==0)
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}
		else if (typeCondition.compareTo("<>")==0)
		{
			if(proprieteCondition.getValeur().compareTo(valeurCondition)==0)
			{
				return 0;
			}
			else 
			{
				return 1;
			}			
		}
		return 0;
	}

	@Override
	public void executer(Composant c)
	{
		if(this.evaluerCondition()==1)
		{
			super.executerOperations(c);
		}
	}
	
	
}
