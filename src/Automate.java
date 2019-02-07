import java.util.ArrayList;

public class Automate
{

	private ArrayList<Etat> etats = new ArrayList<Etat>();

	private ArrayList<Transition> transitions = new ArrayList<Transition>(); 
	
	public Automate()
	{
		
	}
	
	public Automate(ArrayList<Etat> etats, ArrayList<Transition> transitions)
	{
		this.etats = etats;
		this.transitions = transitions;
	}
}
