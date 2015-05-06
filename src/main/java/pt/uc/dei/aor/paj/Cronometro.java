package pt.uc.dei.aor.paj;



import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Cronometro implements Serializable{


	private static final long serialVersionUID = 1L;
	private static long startValue;  
	private static long stopValue;  
	private static long timeDiff;  
	


	/** 
	 * Inicia a contagem temporal 
	 */  
	public static void start() {  
		startValue = System.currentTimeMillis();  
		stopValue = 0;  
		timeDiff = 0;  
	}  

	/** 
	 * Calcula a diferença temporal 
	 */  
	public static void stop() {  
		stopValue = System.currentTimeMillis();  
		timeDiff = stopValue - startValue; 
	
	}  

	/** 
	 * Retorna o diferença de tempo medida 
	 * @return tempo em milisegundos 
	 */  
	public static long elapsedTime() {  
		return timeDiff;  
	}

	public long getStartValue() {
		return startValue;
	}

	public static void setStartValue(long startValue) {
		Cronometro.startValue = startValue;
	}

	public long getStopValue() {
		return stopValue;
	}

	public static void setStopValue(long stopValue) {
		Cronometro.stopValue = stopValue;
	}

	public static long getTimeDiff() {
		return timeDiff;
	}

	public static void setTimeDiff(long timeDiff) {
		Cronometro.timeDiff = timeDiff;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}  

	

}
