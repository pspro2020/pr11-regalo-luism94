package codes;

import java.time.LocalDateTime;

public class BigBrother implements Runnable {
	
	private final MoneyPile money;
	
	public BigBrother(MoneyPile money) {
		this.money = money;
	}

	@Override
	public void run() {
		try {
			//Se muestra un mensaje por pantalla de que el hilo del hermano mayor esta esperando a que se llene el monton
			System.out.println(String.format(Messages.BIG_BRO_WAITS, LocalDateTime.now().format(Messages.TIME_FORMATTER)));
			//Se llena el monton de dinero por parte de los 
			money.waitingToBeFilled();
			//Se muestra un mensaje por pantalla antes de que se termine la ejecucion del hilo del hermano mayor
			System.out.println(String.format(Messages.BIG_BRO_LEAVES, LocalDateTime.now().format(Messages.TIME_FORMATTER)));

		} catch (InterruptedException e) {
			//Cuando el hilo es interrumpido se muestra un mensaje por pantalla y se termina su ejecucion
			System.out.println(String.format(Messages.BIG_BRO_INTERRUPTED, LocalDateTime.now().format(Messages.TIME_FORMATTER)));
			return;
		}
	}



	
}
