package Pauletta;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class cliente extends Thread{
	private int numCliente;
	private Semaphore semaforoArtista;
	private Semaphore semaforoSedie;
	private Random rnd = new Random();
	
	public cliente(int numCliente, Semaphore semaforoSedie, Semaphore semaforoArtista)
	{
		this.numCliente = numCliente;
		this.semaforoArtista = semaforoArtista;
		this.semaforoSedie = semaforoSedie;
	}
	
	public void run()
	{
		try {
			System.out.println("Arriva il cliente " + numCliente);
			if(semaforoSedie.tryAcquire(artista.tempoAttesaMax, TimeUnit.SECONDS))
			//prova ad acquisire il semaforo nel tempo prestabilito
			{
				System.out.println("cliente " + numCliente + " ha una sedia");
				while(true)
				{
					if(semaforoArtista.tryAcquire())
					{
						ritratto();
						System.out.println("cliente " + numCliente + " ha fatto il ritratto");
						semaforoArtista.release();
						semaforoSedie.release();
						break;
					}
				}
			} else {
				System.out.println("cliente " + numCliente + " ha aspettato troppo");
			}
		}
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void ritratto() throws InterruptedException
	{
		int tempoRitratto = rnd.nextInt(4000) + 1000;
		Thread.sleep(tempoRitratto);
	}
}