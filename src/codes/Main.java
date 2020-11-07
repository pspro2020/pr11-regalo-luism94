package codes;

public class Main {

	public static void main(String[] args) {
		try {
			//Objeto Monton comun a los hilos con su valor maximo
			MoneyPile moneyPile = new MoneyPile(10);
			//Objeto del hilo secundario del Hermano Mayor
			BigBrother bigBro = new BigBrother(moneyPile);
			//Hilo secundario del hermano mayor
			Thread broThread = new Thread(bigBro);
			//Array de hilos secundarios de los estudiantes
			Thread[] studentThreads = new Thread[5];
			for (int i = 0; i < 5; i++) {
				//Se crea el hilo con un objeto Estudiante nuevo que recibe un id y el monton de dinero
				studentThreads[i] = new Thread(new Student(i, moneyPile));;
			}
			//Se inicia el hilo del hermano mayor
			broThread.start();
			
			for (int i = 0; i < 5; i++) {
				//Se inician los hilos de los estudiantes
				studentThreads[i].start();
			} 
			
			//El hilo del hermano mayor se espera a la ejecucion de los hilos de los estudiantes
			broThread.join();
			
			for (int i = 0; i < 5; i++) {
				//Los hilos de los estudiantes se interrumpen despues de que todos terminen su ejecucion
				//o cuando la pila se llene
				studentThreads[i].interrupt();
			}

		} catch (InterruptedException e) {
			//Error de java, el hilo principal no se puede interrumpir
		}
	}
}
