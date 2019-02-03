
public class ConditionEvenement extends Evenement
{
	private Propriete proprieteCondition;
	private String valeurCondition;
	private String typeCondition;
	
	public int evaluerCondition()
	{
		if(typeCondition.compareTo("=")==0)
		{
			
		}
		else if (typeCondition.compareTo("<>")==0)
		{
			
		}
		return 1;
	}
	
	public ConditionEvenement(String nom, Propriete proprieteCondition, String valeurCondition, String typeCondition)
	{
		super(nom);
		this.proprieteCondition = proprieteCondition;
		this.valeurCondition = valeurCondition;
		this.typeCondition = typeCondition;
	}
	
}
