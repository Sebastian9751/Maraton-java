package carrera;
import java.lang.Thread;
import java.util.Random;
public class corredor extends Thread implements tabla { 
	String nombre, nivel;
	int numero, velocidad, a;
	String data ;
	public corredor(String name, int numero, String nivel) {
		this.nombre = name;
		this.nivel = nivel;
		this.numero = numero;
		if(nivel=="Principiante") {
			this.velocidad=880;
		}else if(nivel=="Experto"){
			this.velocidad=750;
		}else if(nivel=="Maestro") {
			this.velocidad=650;
		}else if(nivel=="Profesional") {
			this.velocidad=550;
		}	
	}
	public String getN() {
		return this.nombre;
	}
	public String estado(long st) {
		if(st >=50) {		
			this.data = "Ideal";
		}else if(st <50 ) {
			this.velocidad = velocidad+((this.velocidad*50)/100);
			this.data ="lesionado";
		}else if(st<10) {
			this.velocidad = velocidad+((this.velocidad*10)/100);
			this.data ="Cansado";
		}else if(st<=15) {
			this.velocidad = 4500;
			this.data ="Fracturado";
		}
		return this.data;
	}
	
	public int recuperacion(int velocidad, long random) {
		a= (int) (random/100);
		this.velocidad = velocidad -a;
		return a;
	}
	
	public void run() {
		System.out.println(getN()+" salio del inicio");
		for(int i=0; i<10; i++) {
			long status= (long)(Math.random() * 100);
			long descanso= (long)(Math.random() * 2000);
			if(i==0) {
				try {
					sleep(2000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				if(i%3!=0) {estado(status);}
				if(velocidad>=3500) {
					if(velocidad>=4500) {
						rank.deathList.add("(Fracturado) "+getN()+" nivel:"+this.nivel+" "+" abandona en el km : "+i);
						System.out.println("!!!!!!!!!!!!!!!!!! "+getN()+" HA ABANDONADO LA CARRERA POR FRACTURA ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
					}else {
						rank.deathList.add("(Cansancio) "+getN()+" nivel:"+this.nivel+" "+" abandona en el km : "+i);
						System.out.println("////////////////// "+getN()+" HA ABANDONADO LA CARRERA POR CANSANCIO ////////////////");
					}
					break;
					}
				if(i%3!=0) {
					System.out.println(getN()+" ha avanzado "+ i+" km velocidad: "+this.velocidad+" estado: "+this.data+"\n");
	
				}
				try {
					sleep(this.velocidad);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				if(i%3==0) { 
					recuperacion(this.velocidad, descanso);
					try {
						System.out.println("****** "+getN()+" va en el km "+ i+" y se detuvo "+descanso
								+"ms para tomar un descanso"+" (estado: "+this.data+") | velocidad "+this.velocidad+" aumento "+a+" puntos | ******\n");
						Thread.sleep(descanso);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}
			}
		}
		if(velocidad<3500) {
		System.out.println(getN()+" ha llegado a la meta ");
		rank.rankingList.add(getN()+" Nivel:"+this.nivel+" "+" Numero de corredor: "+this.numero);}
	}
}
