package pt.uc.dei.aor.paj;

import java.util.concurrent.atomic.AtomicInteger;

public class Operador implements Comparable<Operador> {
	
	private String op;
	AtomicInteger quant = new AtomicInteger(0);
	
	
	
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
	
	public void quantZero(){
		this.quant.set(0);
	}

	public void setQuant() {
		this.quant.incrementAndGet();
	}

	@Override
	public String toString() {

		return op + " " + quant;
	}
	
	@Override
	public int compareTo(Operador o) {
		if (o == null)
			return -1;
		return (o.quant.get() > this.quant.get()) ? 1 : -1;
	}
}
