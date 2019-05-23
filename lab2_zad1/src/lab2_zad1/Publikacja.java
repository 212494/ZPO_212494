package lab2_zad1;

public abstract class Publikacja // abstrakcyjny produkt
{
	
	protected String autor;
	protected String tytul;
	protected int liczba_stron_publikacji;
	
	protected String okladka = "";
	protected String obwoluta = "";
	protected String autograf = "";
	
	protected String wspolny_string()
	{
		return "| "+autor+" | "+tytul+" | "+Integer.toString(liczba_stron_publikacji)
				+" |";
	}
	
	public String get_opis_calk() 
	{	return wspolny_string();	}
	
	public String toString() 
	{	return get_opis_calk();	}
}

class Ksiazka extends Publikacja // ksiazka - baza
{
	Ksiazka(String a, String t, int lsp)
	{
		autor = a;
		tytul = t;
		liczba_stron_publikacji = lsp;
	}
}

abstract class abstrakcyjna_dekoracja extends Publikacja // abstakcyjny dekorator
{
	protected Publikacja ksiazka ;
	
	public abstrakcyjna_dekoracja( Publikacja ksiazka ) // konstruktor
	{	this.ksiazka = ksiazka;	}
	
	public abstrakcyjna_dekoracja( Ksiazka ksiazka )
	{
		this.ksiazka = ksiazka;
	}
	
	public String get_opis_calk()
	{	return ksiazka+okladka+obwoluta+autograf;	}
}

//--------------------------------------------------------------------------
// dodatki

class KsiazkaZOkladkaZwykla extends abstrakcyjna_dekoracja
{		
	public KsiazkaZOkladkaZwykla(Publikacja ksiazka) 
	{		
		super(ksiazka);
				
		try {
			if (ksiazka.okladka.length() != 0)
			{	throw new NumberFormatException();	}
			
			okladka = okladka.concat(" Okladka zwykla |");
			
		}
		catch( NumberFormatException e )
		{	System.out.print("\nOKLADKA MOZE BYC TYLKO JEDNA\n");	}		
	}
}

class KsiazkaZOkladkaTwarda extends abstrakcyjna_dekoracja
{	
	public KsiazkaZOkladkaTwarda(Publikacja ksiazka) 
	{		
		super(ksiazka);	
		
		try {
			if (ksiazka.okladka.length() != 0)
			{	throw new NumberFormatException();	}
			
			okladka = " Okladka twarda |";
			
		}
		catch( NumberFormatException e )
		{	System.out.print("\nOKLADKA MOZE BYC TYLKO JEDNA\n");	}		
	}
}

class KsiazkaZObwoluta extends abstrakcyjna_dekoracja
{	
	public KsiazkaZObwoluta(Publikacja ksiazka) 
	{			
		super(ksiazka);
		
		try {
			if(ksiazka.obwoluta.length() != 0)
			{	throw new ArithmeticException();	}
			else if (ksiazka.okladka.length() == 0)
			{	throw new NumberFormatException();	}
			
			obwoluta = " Z obwoluta |";
			
		}
		catch( NumberFormatException e )
		{	System.out.print("\nNIE MOZNA OBLOZYC OBWOLUTA KSIAZKI BEZ OKLADKI\n");	}		
		catch( ArithmeticException e )
		{	System.out.print("\nOBWOLUTA MOZE BYC TYLKO JEDNA\n");	}
	}
}

class KsiazkaZAutografem extends abstrakcyjna_dekoracja
{	
	public KsiazkaZAutografem(Publikacja ksiazka, String text) 
	{		
		super(ksiazka);
		
		try {
			if(ksiazka.autograf.length() != 0)
			{	throw new ArithmeticException();	}
			else if (text.length() == 0)
			{	throw new NumberFormatException();	}
			
			autograf = " "+text+" |";
			
		}
		catch( NumberFormatException e )
		{	System.out.print("\nBRAK AUTOGRAFU\n");	}		
		catch( ArithmeticException e )
		{	System.out.print("\nAUTOGRAF MOZE BYC TYLKO JEDEN\n");	}	
	}
}














