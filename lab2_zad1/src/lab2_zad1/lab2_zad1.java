package lab2_zad1;

public class lab2_zad1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("---------------dekorator------------------\n");

	
		Publikacja k1 = new Ksiazka("Adam Mickiewicz", "Pan Tadeusz", 340);
		Publikacja k2 = new Ksiazka("Adam Mickiewicz", "Dziady", 130);
		
		System.out.println(k1);
		System.out.println(k2);
		
		k1 = new KsiazkaZOkladkaZwykla(k1);
		k2 = new KsiazkaZOkladkaTwarda(k2);
		
		System.out.println("");
		System.out.println(k1);
		System.out.println(k2);
		
		Publikacja kk1 = new KsiazkaZOkladkaZwykla(k1);
		Publikacja fakeBook = new KsiazkaZObwoluta(kk1);
		// wyj�tek! Nie mo�na ob�o�y� obwolut� ksi��ki, kt�ra nie posiada ok�adki
		 
			 
		 
		k2 = new KsiazkaZObwoluta(k2);
		System.out.println(k2);// a tu OK
		
		Publikacja odrzut = new KsiazkaZObwoluta(k2);
		// wyj�tek! Obwoluta mo�e by� jedna
		
		Publikacja dziadyZAutografemWieszcza =
		new KsiazkaZAutografem(k2, "Drogiej Hani - Adam Mickiewicz");
		System.out.println(dziadyZAutografemWieszcza);
		
		// wypisuje: | Adam Mickiewicz | Dziady | 130 | Ok�adka twarda | Drogiej Hani - AdamMickiewicz |
		Publikacja dziadyZDwomaAutografami = new KsiazkaZAutografem(dziadyZAutografemWieszcza, "Haniu, to nieprawda, Dziady napisa�em ja,Julek S�owacki!");
		// wyj�tek! Autograf mo�e by� tylko jeden
		
		
		
		System.out.println("\n\n\n---------------fabryka abstrakcyjna------------------\n");
		
		Wydawnictwo w = Wydawnictwo.getInstance("Jozef Ignacy Kraszewski");
		Ksiazka k = w.createBook("Maslaw", 280);
		System.out.println(k);
		
		Wydawnictwo a = Wydawnictwo.getInstance("Henryk Sienkiewicz");
		Ksiazka a1 = a.createBook("Pan Wo�odyjowski", 769);
		System.out.println(a1);
		
		Wydawnictwo b = Wydawnictwo.getInstance("Stephen King");
		Ksiazka b1 = b.createBook("Martwa strefa", 1320);
		System.out.println(b1);
		
		Wydawnictwo c = Wydawnictwo.getInstance("Jan Kochanowski");
		Ksiazka c1 = c.createBook("Szachy", 78);
		System.out.println(c1);
		
		Publikacja c2 = new KsiazkaZOkladkaZwykla(c1);
		System.out.println(c2);
		
		
		
	}
}
