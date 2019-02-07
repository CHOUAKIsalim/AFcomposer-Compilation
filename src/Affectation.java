
public class Affectation extends Operation
{
	
	private String valeur;
	
	public Affectation(Propriete destination, String valeur)
	{
		super(destination);
		this.valeur = valeur;
	}
	
	@Override
	public void executer(Composant c)
	{
		super.getDestination().setValeur(valeur);
	}

}
