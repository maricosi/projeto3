package pt.uc.dei.aor.paj;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Cronometro implements Serializable {


	private static final long serialVersionUID = 1L;
	private static long tempo_inicial;  
	private static long tempo_final;  
	private static long diftempo;  


	/** 
	 * Inicia a contagem temporal 
	 */  
	public static void start() {  
		tempo_inicial = System.nanoTime();  
		tempo_final = 0;  
		diftempo = 0;  
	}  

	/** 
	 * Calcula a diferença temporal 
	 */  
	public static void stop() {  
		tempo_final = System.nanoTime();  
		diftempo = (tempo_final - tempo_inicial)/1000;  
	}  

	/** 
	 * Retorna o diferença de tempo medida 
	 * @return tempo em milisegundos 
	 */  
	public static long tempoResposta() {  
		return diftempo;  
	}  


}