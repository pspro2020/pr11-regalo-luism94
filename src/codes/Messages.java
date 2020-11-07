package codes;

import java.time.format.DateTimeFormatter;

public class Messages {
	//Clase estatica para mostrar mensajes por pantalla
	public static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static String BIG_BRO_WAITS = "%s ---> Big brother is waiting for the money...";
	public static String BIG_BRO_LEAVES = "%s ---> Big brother is going to the shop with the money";
	public static String STUDENT_DROPS_MONEY = "%s ---> Student %d puts %d€ in the pile";
	public static String STUDENT_INTERRUPTED = "%s ---> Student %d has been interrupted";
	public static String BIG_BRO_INTERRUPTED = "%s ---> Big bro has been interrupted";
}
