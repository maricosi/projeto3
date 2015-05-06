package pt.uc.dei.aor.paj;

import java.util.ArrayList;


public class Entrada {
	private String exp;	
	private String res;
	private long tempo;
	private ArrayList<Input> inputs;

		
	
	public Entrada(String exp, String res, ArrayList<Input> inputs, long tempo) {
		super();
		this.exp = exp;
		this.res = res;
		this.tempo=tempo;
		this.inputs = inputs;
		
	}

	public String getExp() {
		return exp;
	}

	public String getRes() {
		return res;
	}
	



	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

	public ArrayList<Input> getInputs(){
		return inputs;
	}


	






	
}
