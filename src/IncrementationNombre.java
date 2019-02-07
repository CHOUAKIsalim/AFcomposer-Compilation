
public class IncrementationNombre extends Operation
{
	
	private String nombreSource;
	
	public IncrementationNombre(Propriete destination, String nombreSource)
	{
		super(destination);
		this.nombreSource = nombreSource;
	}

	@Override
	public void executer(Composant c)
	{
		c.getProprietes().get(super.getDestination().getNom()).setValeur(Integer.parseInt(c.getProprietes().get(super.getDestination().getNom()).getValeur())+Integer.parseInt(nombreSource)+"");

	}

}
