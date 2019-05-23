package lab1_zad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap; 

public class lab1_zad3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		String znaki;
		
		System.out.print("Wpisz liczbe 3-cyfrowa dodatnia lub ujemna: ");
		znaki = napis();
		System.out.print("\n"+znaki+" -> "+konwertowanie_i_sprawdzanie(znaki));
	}
	
	//---------------------------------------------------------------------------------------------------------------		
		static String napis() throws IOException
		{
			String wynik;
			BufferedReader odczyt = new BufferedReader(new InputStreamReader(System.in));
			wynik = odczyt.readLine();
			return wynik;
		}
	//---------------------------------------------------------------------------------------------------------------
		static String konwertowanie_i_sprawdzanie(String napis)
		{
			try
			{
				int liczba = Integer.parseInt(napis);
				if( !((liczba/1000) == 0) ) {	throw new NumberFormatException();	}
				if(   (liczba/100 ) == 0  ) {	throw new NumberFormatException();	}
			}
			catch(NumberFormatException e)
			{	return "Wpisana wartosc nie spelnia oczekiwan !!!";		}
			
			HashMap<String, String> mapa = tworzenie_mapy();
			
			
			String wynik = "";
			for(int i=0 ; i<napis.length() ; i++) 
			{
				//System.out.println(napis.substring(i, i+1));
				wynik = wynik.concat(mapa.get(napis.substring(i, i+1)));
				if(i < (napis.length()-1))
				{	wynik = wynik.concat(" ");	}
			}
			
			mapa.clear();
			
			return wynik;
		}
	//---------------------------------------------------------------------------------------------------------------
		static HashMap<String, String> tworzenie_mapy()
		{
			HashMap<String, String> mapka = new HashMap<>();
			
		  //mapka.put(key, value);
			mapka.put("-", "minus");
			mapka.put("0", "zero");
			mapka.put("1", "jeden");
			mapka.put("2", "dwa");
			mapka.put("3", "trzy");
			mapka.put("4", "cztery");
			mapka.put("5", "piec");
			mapka.put("6", "szesc");
			mapka.put("7", "siedem");
			mapka.put("8", "osiem");
			mapka.put("9", "dziewiec");
			
			return mapka;
		}

}