package lab2_zad2;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class lab2_zad2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		
		//-------------------------------------------------------------------------------
		LocalDate druga_wojna_poczatek = LocalDate.of(1939, 9, 1);
		LocalDate druga_wojna_koniec   = LocalDate.of(1945, 5, 8);
		
		System.out.print("II wojna swiatow trwala "
				+(druga_wojna_poczatek.until(druga_wojna_koniec, ChronoUnit.DAYS)+1) // +1 bo trzeba doliczyc 8.5.1945
				+" dni\n\n"); 
		
		//-------------------------------------------------------------------------------
		LocalDate a = LocalDate.of(2016, 1, 1);
		a = a.plus(68-1, ChronoUnit.DAYS); // -1 bo zaczynamy od 1.1.2016
		System.out.print("68-my dzien 2016 roku to: "+a.getDayOfMonth()+" "+a.getMonth());

		//-------------------------------------------------------------------------------
		
		BufferedReader odczyt = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\n\n\nWpisz rok swoich urodzin: ");
		int rok = Integer.parseInt(odczyt.readLine());		
		
		System.out.print("Wpisz miesiac swoich urodzin: ");
		int miesiac = Integer.parseInt(odczyt.readLine());	
		
		System.out.print("Wpisz dzien swoich urodzin: ");
		int dzien = Integer.parseInt(odczyt.readLine());	
		
		LocalDate teraz = LocalDate.now();
		LocalDate urodziny = LocalDate.of(rok, miesiac, dzien);
		
		int ilosc29luty = 0;
		
		if(	(urodziny.getYear()%4) == 0)	//	czy rok przestepny
		{
			if( (urodziny.getMonthValue() <= 2) )	// czy przed 29 lutym
			{	ilosc29luty++;	}
		}
		
		
		if( (teraz.getYear()%4 == 0) )	//	czy rok przestepny
		{
			if( (teraz.getMonthValue() > 2) )
			{	ilosc29luty++;	}
			
			else if( (teraz.getMonthValue() == 2) && (teraz.getDayOfMonth() == 29) ) 
			{	ilosc29luty++;	}
		}
		
		int i = urodziny.getYear()+1;
		for( ; i<teraz.getYear() ; i++) 
		{
			if( (i%4) == 0 ) {	ilosc29luty++;	}
		}
		
		System.out.print("\nOd urodzin w: "+urodziny+" do teraz minelo: "+ilosc29luty
				+" dni 29-tych lutych.");
	}
}
