package lab1_zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class lab1_zad1 {
//---------------------------------------------------------------------------------------------------------------		
	private static String napis() throws IOException
	{
		String wynik;
		BufferedReader odczyt = new BufferedReader(new InputStreamReader(System.in));
		wynik = odczyt.readLine();
		return wynik;
	}
//---------------------------------------------------------------------------------------------------------------		
	private static String konwertowanie(int wartosc, int radix) // radix od 2 do 16 
	{
		int i = 0;
		int ilosc_waznych_bitow = 0;
		String wynik = "";
	
		int pomoc = wartosc;
		while(pomoc > 0) 
		{
			pomoc = pomoc / radix;
			ilosc_waznych_bitow = ilosc_waznych_bitow + 1;
		}
		
		
		int reszta [] = new int [ilosc_waznych_bitow];
		
		
		for(i=0 ; i<ilosc_waznych_bitow ; i++)
		{
			reszta[i] = wartosc % radix;
			wartosc = wartosc / radix;
		}
		
		
		for(i=ilosc_waznych_bitow-1 ; i>=0 ; i--)
		{
			if(reszta[i] >= 10)
			{
				wynik = wynik.concat(literowka(reszta[i]));
			}
			else
			{
				wynik = wynik.concat(Integer.toString(reszta[i]));
			}
		}
		
		return wynik;
	}
//---------------------------------------------------------------------------------------------------------------	
	private static String literowka (int objekt)
	{	
		String wynik = "";
		if(objekt>=10)
		{	
			switch (objekt) 
			{
			case 10:	wynik = "A";	break;
			case 11:	wynik = "B";	break;
			case 12:	wynik = "C";	break;
			case 13:	wynik = "D";	break;
			case 14:	wynik = "E";	break;
			case 15:	wynik = "F";	break;
			default:	wynik = "?";	break;
			}
		}
		return wynik;
	}
//---------------------------------------------------------------------------------------------------------------	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String typ = "";
		int liczba = 0b1101_1000;
		
		System.out.print("Na jaki system chcesz przekonwertowac liczbe: " + konwertowanie(liczba, 2)
						+"\n\tdziesietny"
						+"\n\ttrojkowy"
						+"\n\tszesnastkowy?"
						+"\n\n:");
		typ = napis();
		
	switch (typ)
	{
		case "dziesietny": 
			System.out.println("\nLiczba w systemie dziesietnym: " + konwertowanie(liczba, 10));
			break;
		
		case "trojkowy": 
			System.out.println("\nLiczba w systemie trojkowym: " + konwertowanie(liczba, 3));
			break;
		
		case "szesnastkowy":
			System.out.println("\nLiczba w systemie dziesietnym: " + konwertowanie(liczba, 16));
			break;
		
		default: System.out.println("\n Blad podczas wyboru");
	}
	
	
	
	}

}
