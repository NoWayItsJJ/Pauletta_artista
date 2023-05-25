package Pauletta;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class artista {
	private static final int buffer = 4; //numero sedie
	public static final int tempoAttesaMax = 10; //tempo massimo di attesa
	
	private Semaphore semaforoArtista = new Semaphore(1); //semaforo che permette un solo ritratto alla volta
	private Semaphore semaforoSedie = new Semaphore(buffer); //semaforo che permette "buffer" accessi alle sedie
	
	public void process()
	{
		Random rnd = new Random();
		int numeroClienti = rnd.nextInt(10) + 1; //numero di clienti casuale tra 1 e 10
		
		System.out.println("I clienti sono " + numeroClienti);
		
		for(int i = 1; i <= numeroClienti; i++)
		{
			cliente cliente = new cliente(i, semaforoSedie, semaforoArtista);
			cliente.start();
		}
	}
}