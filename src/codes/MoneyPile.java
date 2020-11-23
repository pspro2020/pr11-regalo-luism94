package codes;

import java.util.concurrent.CountDownLatch;

public class MoneyPile {
	//Objeto de Cuenta Atras para suspender el hilo del hermano mayor
	private CountDownLatch count;
	
	public MoneyPile(int maxValue) {
		//Se recibe el valor maximo de la cuenta atras por parametro del constructor del monton de dinero
		count = new CountDownLatch(maxValue);
		
	}

	//Metodo para los hilos de los estudiantes para colocar el dinero en el monton
	public void putInMoney(int money) {
		//Como el valor del dinero es entero, decremento el valor de la cuenta atras tantas veces
		//como la cantidad de dinero que se coloque dentro de la pila
		for (int i = 0; i < money; i++) {
			count.countDown();
		}
	}

	//Metodo para el hilo del hermano mayor para que se suspenda mientras la cuentra atras no llegue a 0
	public void waitingToBeFilled() throws InterruptedException {
		count.await();
	}
}
