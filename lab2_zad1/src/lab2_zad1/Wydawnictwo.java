package lab2_zad1;
import lab2_zad1.Ksiazka;

class Rodzaje_ksiazek
{
	static int numer_typu(String autor) 
	{		
		//	1	->	Powiesci Historyczne
		//	2	->	Thrillery
		//	3	->	Poematy
		
		switch (autor.toLowerCase())
		{
			case "jozef ignacy kraszewski":	return 1;
			case "henryk sienkiewicz":	return 1;
			
			case "thomas harris":	return 2;
			case "agatha christie":	return 2;
			case "stephen king":	return 2;
			
			case "adam mickiewicz":	return 3;
			case "jan kochanowski":	return 3;
			
			default: return -1;
		}
	}
}

public abstract class Wydawnictwo{

	private static final Wydawnictwo blad = null;

	public static Wydawnictwo getInstance(String autor) {
		
		int typ = 0;
		
		try {
			
			typ = Rodzaje_ksiazek.numer_typu(autor);	
			if(typ == -1) {	throw new IllegalAccessException(); }
		}
		catch( IllegalAccessException e ) 
		{
			System.out.print("\nBLAD!!!\nBrak takiego autora na liscie\n"
					+ "lub autor zle wpisany\n");
		}
		
		switch (typ) 
		{
			case 1: return new Wydawnictwo_powiesci_historycznych(autor);
			case 2:	return new Wydawnictwo_thrillerow(autor);
			case 3:	return new Wydawnictwo_poematow(autor);
			default: return blad;
		}
    }

	abstract public Ksiazka createBook(String tytul, int liczba_stron_publikacji);
}


//-----powiesc historyczna------------------------------------------------------------

class Wydawnictwo_powiesci_historycznych extends Wydawnictwo{
	String autor;

	public Wydawnictwo_powiesci_historycznych(String autor)
	{	this.autor = autor;	}

	public Ksiazka createBook(String tytul, int liczba_stron_publikacji)
	{	return new PowiescHistoryczna(autor, tytul, liczba_stron_publikacji);	}
}

class PowiescHistoryczna extends Ksiazka
{
	public PowiescHistoryczna(String autor, String tytul, int liczba_stron_publikacji)
	{	super(autor, tytul, liczba_stron_publikacji);	}
}

//-----thriller----------------------------------------------------------------------

class Wydawnictwo_thrillerow extends Wydawnictwo{
	String autor;

	public Wydawnictwo_thrillerow(String autor)
	{	this.autor = autor;	}

	public Ksiazka createBook(String tytul, int liczba_stron_publikacji)
	{	return new Thriller(autor,tytul,liczba_stron_publikacji);	}
}

class Thriller extends Ksiazka
{
	public Thriller(String autor, String tytul, int liczba_stron_publikacji)
	{	super(autor, tytul, liczba_stron_publikacji);	}
}

//-----poematy----------------------------------------------------------------------

class Wydawnictwo_poematow extends Wydawnictwo{
	 String autor;
	 
	public Wydawnictwo_poematow(String autor)
	{	this.autor=autor;	 }

	public Ksiazka createBook(String tytul, int liczba_stron_publikacji)
	{	return new Poemat(autor,tytul,liczba_stron_publikacji);	}
}

class Poemat extends Ksiazka
{
	public Poemat(String autor, String tytul, int liczba_stron_publikacji)
	{	super(autor, tytul, liczba_stron_publikacji);	}
}






