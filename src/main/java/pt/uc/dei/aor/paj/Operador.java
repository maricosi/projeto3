package pt.uc.dei.aor.paj;

import java.util.concurrent.atomic.AtomicInteger;

public class Operador {
	
	private String op;
	AtomicInteger quant = new AtomicInteger(0);
	//private int quant = 0;
	
	public Operador(String op) {
		this.op = op;
	}
	
	public void add(){
		
		quant.incrementAndGet();
	}

	public String getOp() {
		return op;
	}

	public int getQuant() {
		return quant.get();
	}

		
}
