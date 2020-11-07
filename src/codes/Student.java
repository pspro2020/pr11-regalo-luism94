package codes;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable {
	
	private MoneyPile moneyPile;
	private int id;
	
	public Student(int id, MoneyPile moneyPile) {
		this.id = id;
		this.moneyPile = moneyPile;
	}

	@Override
	public void run() {
		//Instrucciones de los hilos de los estudiantes
		try {
			//El estudiante coge su dinero
			int money = getMoney();
			//Se muestra un mensaje por pantalla con la hora actual
			System.out.println(String.format(Messages.STUDENT_DROPS_MONEY, LocalDateTime.now().format(Messages.TIME_FORMATTER), id, money));
			//El estudiante coloca el dinero en el monton
			moneyPile.putInMoney(money);
		} catch (InterruptedException e) {
			//Cuando el hilo es interrumpido se muestra un mensaje por pantalla y se termina su ejecucion
			System.out.println(String.format(Messages.STUDENT_INTERRUPTED, LocalDateTime.now().format(Messages.TIME_FORMATTER), id));
			return;
		}
		
	}

	private int getMoney() throws InterruptedException {
		//Se genera un valor entero para el dinero y otro para el tiempo de espera
		//El hilo espera esa cantidad en segundos antes de retornar el valor del dinero
		Random rndm = new Random();
		int waitingTime = rndm.nextInt(8) + 3;
		TimeUnit.SECONDS.sleep(waitingTime);
		return rndm.nextInt(4) + 2;
	}

}
