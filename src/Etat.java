import java.util.ArrayList;

public class Etat
{

	private ArrayList<Composant> composants = new ArrayList<Composant>();

	public Etat(ArrayList<Composant> composants)
	{
		for (int i = 0; i < composants.size(); i++)
		{

			this.composants.add((Composant) composants.get(i).clone());
		}
	}

	public ArrayList<Composant> getComposants()
	{
		return this.composants;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Etat other = (Etat) obj;
		for (int i = 0; i < composants.size(); i++)
		{
			if (!composants.get(i).equals(other.composants.get(i)))
			{
					return false;
			}
		}

		return true;
	}

	public void affichier()
	{
		for(int i=0; i<composants.size();i++)
			{
				System.out.println("Etat");
				composants.get(i).affichier();
			}
	}
}
