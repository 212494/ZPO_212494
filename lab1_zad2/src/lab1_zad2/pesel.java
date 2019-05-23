package lab1_zad2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class napisy
{
	public static String napis() throws IOException
	{
		String wynik;
		BufferedReader odczyt = new BufferedReader(new InputStreamReader(System.in));
		wynik = odczyt.readLine();
		return wynik;
	}
}

//--------------------------------------------------------------------------------------------------

public class pesel {
	
	private Byte pesel_cyfry[];
	private int dzien_ur;
	private int miesiac_ur;
	private int rok_ur;
	private String plec;
	private int liczba_porzadkowa;
	private int cyfra_kontrolna;
	
//--------------------------------------------------------------------------------------------------	

	pesel(String znaki)
	{
		pesel_cyfry = sprawdzanie_i_konwertowanie(znaki);
		
		dzien_ur = wpis_dzien_ur(pesel_cyfry);
		miesiac_ur = wpis_miesiac_ur(pesel_cyfry);
		rok_ur = wpis_rok_ur(pesel_cyfry);
		plec = wpis_plec(pesel_cyfry);
		liczba_porzadkowa = wpis_liczba_porzadkowa(pesel_cyfry);
		cyfra_kontrolna = wpis_cyfra_kontrolna(pesel_cyfry);
	}
		
//--------------------------------------------------------------------------------------------------	
	private int wpis_dzien_ur(Byte tab[]) 
	{	
		int dzien = 0;
		dzien = ((tab[4]*10) + tab[5]);
		
		if((dzien>=1) && (dzien<=31)) {	return dzien;	}
		else {	return -2;	}// dane pozbawione sensu
	}
	
	private int wpis_miesiac_ur(Byte tab[])
	{
		int liczba = ((tab[2]*10) + tab[3]);
		 
		if((liczba > 0) && (liczba <= 12))		{	return liczba;	}
		else if((liczba>=21) && (liczba<=32))	{	return (liczba-20);	}
		else if((liczba>=41) && (liczba<=52))	{	return (liczba-40);	}
		else if((liczba>=61) && (liczba<=72))	{	return (liczba-60);	}
		else if((liczba>=81) && (liczba<=92))	{	return (liczba-80);	}
		else { return -2; } // dane pozbawione sensu
	}
	
	private int wpis_rok_ur(Byte tab[]) 
	{
		int stulecie = 0;
		int miesiac = wpis_miesiac_ur(tab);
		
		
		stulecie = ((tab[2]*10) + tab[3]) - miesiac;
		
		if(miesiac < 0) {	return -2;	}	// blad
		else if(stulecie == 0)	{	return (1900 + (tab[0]*10) + tab[1]);	}
		else if(stulecie == 20)	{	return (2000 + (tab[0]*10) + tab[1]);	}
		else if(stulecie == 40)	{	return (2100 + (tab[0]*10) + tab[1]);	}
		else if(stulecie == 60)	{	return (2200 + (tab[0]*10) + tab[1]);	}
		else if(stulecie == 80)	{	return (1800 + (tab[0]*10) + tab[1]);	}
		else { return -1; } // dane pozbawione sensu
	}
	
	private String wpis_plec(Byte tab[]) 
	{
		if(tab[9]>=0 && tab[9]<=9)
		{
			if((tab[9]%2) == 0) {	return "kobieta";	}
			else { return "mezcyzna";	}
		}
		else {	return "Blad danych";	}
	} 
	
	private int wpis_liczba_porzadkowa(Byte tab[]) 
	{
		int i;
		try {
			for(i=6;i<=9;i++) 
			{
				if(tab[i]<0 || tab[i]>9) {	throw new NumberFormatException();	}
			}
		}
		catch(NumberFormatException e) 
		{
			return -2;
		}
		
		return (tab[6]*1000 + tab[7]*100 + tab[8]*10 + tab[9]);
	}
	
	private int wpis_cyfra_kontrolna(Byte tab[])
	{	
		try {
				if(tab[10]<0 || tab[10]>9) {	throw new NumberFormatException();	}
		}
		catch(NumberFormatException e) 
		{
			return -2;
		}
		return tab[10];
	}
//--------------------------------------------------------------------------------------------------	
	
	long out_pesel_cyfry()
	{
		int i;
		long wynik1 = 0;
		
		for(i=0 ; i<pesel_cyfry.length ; i++)
		{
			wynik1 = wynik1 + pesel_cyfry[i] * (long)(Math.pow(10, pesel_cyfry.length-i-1));
		}
		
		return wynik1;
	}
	
	int out_dzien_ur()
	{	
		try
		{
			if(dzien_ur == -2) {	throw new ArithmeticException();	}
			else {	return dzien_ur;	}
		}	
		catch (ArithmeticException e)
		{
			System.out.print("Dane pozbawione sensu");
			return dzien_ur;
		}
		
	}
	
	int out_miesiac_ur()
	{	
		try
		{
			if(miesiac_ur == -2) {	throw new ArithmeticException();	}
			else {	return miesiac_ur;	}
		}	
		catch (ArithmeticException e)
		{
			System.out.print("Dane pozbawione sensu");
			return miesiac_ur;
		}
	}
	
	int out_rok_ur()
	{
		try
		{
			if(rok_ur == -1) {	throw new NumberFormatException();	}
			else if(rok_ur == -2) {	throw new ArithmeticException();	}
			else {	return rok_ur;	}
		}	
		catch (NumberFormatException e)
		{
			System.out.print("Dane pozbawione sensu");
			return rok_ur;
		}
		catch (ArithmeticException e)
		{
			System.out.print("Blad danych");
			return rok_ur;
		}
	}
	
	String out_plec() {	return plec;	}
	
	int out_liczba_porzadkowa()
	{
		
		try
		{
			if(liczba_porzadkowa == -2) {	throw new ArithmeticException();	}
			else {	return liczba_porzadkowa;	}
		}	
		catch (ArithmeticException e)
		{
			System.out.print("Dane pozbawione sensu");
			return liczba_porzadkowa;
		}	
	}
	
	int out_cyfra_kontrolna()
	{
		try
		{
			if(cyfra_kontrolna == -2) {	throw new ArithmeticException();	}
			else {	return cyfra_kontrolna;	}
		}	
		catch (ArithmeticException e)
		{
			System.out.print("Dane pozbawione sensu");
			return cyfra_kontrolna;
		}		
	}
	
//--------------------------------------------------------------------------------------------------
	private Byte[] sprawdzanie_i_konwertowanie(String znaki)
	{
		long na_long;
		int i;
		int ilosc_cyfr = 0;
		final int rozmiar = 11 ;
		Byte na_byte[] = new Byte[rozmiar];
		
		try {
			
			na_long = Long.parseLong(znaki);
						
			long pomoc = na_long;
			while(pomoc > 0) 
			{
				pomoc = pomoc / 10;
				ilosc_cyfr = ilosc_cyfr + 1;
			}
			if(ilosc_cyfr > rozmiar || ilosc_cyfr < rozmiar - 1) // 1-sza cyfra pesel moze byc 0
			{	throw new NumberFormatException();	}
			
			for(i=1 ; i<=rozmiar ; i++)
			{
				na_byte[rozmiar-i] = (byte) (na_long % 10);
				na_long = na_long / 10;
			}
			
			if(czy_cyfra_kontrolna_jest_ok(na_byte) == false) {	throw new NumberFormatException();	}
			
		}
		catch( NumberFormatException e ) 
		{
			System.out.println("\n\nPodana wartosc nie jest numerem PESEL !!!\n");
			for(i=0 ; i<rozmiar ; i++) {	na_byte[i] = -1;	}
		}

		return na_byte;
	}
//--------------------------------------------------------------------------------------------------	
	private Boolean czy_cyfra_kontrolna_jest_ok(Byte pesel[])
	{
		int i;
		int suma = 0;
		int mnoznik = 0;
		for(i=0 ; i<pesel.length-1 ; i++)
		{
			switch (i) 
			{
				case 3 :
				case 7 :	mnoznik = 1; break;
				case 2 :
				case 6 :	mnoznik = 3; break;
				case 1 :
				case 5 :
				case 9 :	mnoznik = 7; break;
				case 0 :
				case 4 :
				case 8 :	mnoznik = 9; break;
			}
			suma = suma + (pesel[i]*mnoznik);
		}
		
		if( (suma % 10) == pesel[10] ) {	return true;	}
		else {	return false;	}
	}
//--------------------------------------------------------------------------------------------------
}




