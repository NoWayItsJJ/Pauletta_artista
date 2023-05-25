package Pauletta;

import java.util.Random;
import java.util.concurrent.Semaphore;

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
}
