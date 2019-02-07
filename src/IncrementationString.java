
public class IncrementationString extends Operation
{
	private String stringSource;

	public IncrementationString(Propriete destination, String stringSource)
	{
		super(destination);
		this.stringSource = stringSource;
	}

	@Override
	public void executer(Composant c)
	{
		super.getDestination().setValeur(super.getDestination().getValeur() + stringSource);
	}

}
