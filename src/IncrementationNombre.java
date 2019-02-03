
public class IncrementationNombre extends Operation
{
	
	private String nombreSource;
	
	public IncrementationNombre(Propriete destination, String nombreSource)
	{
		super(destination);
		this.nombreSource = nombreSource;
	}

}
