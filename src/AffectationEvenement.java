
public class AffectationEvenement extends Evenement
{

	public AffectationEvenement(String nom)
	{
		super(nom);
	}

	@Override
	public void executer(Composant c)
	{
		super.executerOperations(c);
	}

}
