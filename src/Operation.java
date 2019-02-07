
public abstract class Operation
{
	private Propriete destination;

	public Operation(Propriete destination)
	{
		this.destination = destination;
	}

	protected Propriete getDestination()
	{
		return this.destination;
	}

	public abstract void executer(Composant c);

}
