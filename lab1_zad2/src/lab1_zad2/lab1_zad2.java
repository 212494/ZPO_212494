package lab1_zad2;

import java.io.IOException;

public class lab1_zad2{

	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		System.out.print("Podaj numer pesel:\t");
		
		pesel czlowiek = new pesel(napisy.napis());
		
		System.out.print("Wczytanie danych z numeru pesel: "+czlowiek.out_pesel_cyfry()+"\n");
		System.out.print("\tdata urodzenia: "+czlowiek.out_dzien_ur()+"."+czlowiek.out_miesiac_ur()+"."+czlowiek.out_rok_ur()+"r\n");
		System.out.print("\tplec: "+czlowiek.out_plec()+"\n");
		System.out.print("\tliczba porzadkowa: "+czlowiek.out_liczba_porzadkowa()+"\n");
		System.out.print("\tcyfra kontrolna: "+czlowiek.out_cyfra_kontrolna());
	
		
	}
}
