package carrera;

import java.util.ArrayList;

public class main {
	 

	public static void main(String[] args) throws InterruptedException   {
		// TODO Auto-generated method stub
		corredor c1 = new corredor("Allan",1,"Principiante");
		corredor c2 = new corredor("Solovino",2,"Principiante");
		corredor c3 = new corredor("Marcelino panyvino",3,"Experto");
		corredor c4 = new corredor("Santos",4,"Experto");
		corredor c5 = new corredor("Solareth",5,"Experto");
		corredor c6 = new corredor("Doctops",6,"Maestro");
		corredor c7 = new corredor("Panfilo",7,"Maestro");
		corredor c8 = new corredor("Supersu",8,"Profesional");
		corredor c9 = new corredor("Pancracio",9,"Profesional");
		corredor c10 = new corredor("Steve",10,"Profesional");
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		c7.start();
		c8.start();
		c9.start();
		c10.start();
		
		c1.join();
		c2.join();
		c3.join();
		c4.join();
		c5.join();
		c6.join();
		c7.join();
		c8.join();
		c9.join();
		c10.join();
		ArrayList<String> r = tabla.rank.rankingList;
		ArrayList<String> d = tabla.rank.deathList;
		System.out.println("");
		System.out.println("TABLA DE RANKING ("+r.size()+")");
		System.out.println("");
		
		
		
		for (int i=0; i<=r.size()-1; i++) {
			System.out.println(i+1+"._"+r.get(i));
		}
		
		System.out.println("");
		System.out.println("DEATH LIST ("+d.size()+")");
		System.out.println("");
		
		
		
		for (int i=0; i<=d.size()-1; i++) {
			System.out.println("*"+d.get(i));
		}
		
		
		
	}

}
