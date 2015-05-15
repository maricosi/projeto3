package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Estatistica implements Serializable {

	private static final long serialVersionUID = -8382190444479383697L;

	private ArrayList <Operador> operation = new ArrayList<>();


	public Estatistica() {

		operation.add( new Operador("+","Adição"));
		operation.add( new Operador("-","Subtracção"));
		operation.add( new Operador("/","Divisão"));
		operation.add( new Operador("*","Multiplicação"));
		operation.add( new Operador("sqrt","Multiplicação"));
		operation.add( new Operador("+/-" ,"Mudança de Sinal"));
		operation.add( new Operador("%","Percentagem"));
		operation.add( new Operador("sin","Seno"));
		operation.add( new Operador("cos","Coseno"));
		operation.add( new Operador("tan","Tangente"));
		operation.add( new Operador("1/x","Inverso"));
		operation.add( new Operador("x^2","Quadrado de um número"));
		operation.add( new Operador("^","Elevado a..."));
		operation.add( new Operador("pi","Pi"));
		operation.add( new Operador("e","Exponensial"));
		operation.add( new Operador("log10","Logaritmo base 10"));
		operation.add( new Operador("log2","Logaritmo base 2"));
		operation.add( new Operador("log","Logaritmo"));
		operation.add( new Operador("!","Factorial"));
		operation.add( new Operador("cbrt","Raiz Cúbica"));
		operation.add( new Operador("e^x","Exponensial elevado a..."));
		operation.add( new Operador("10^x","Dez elevado a um valor"));

	}

	private Operador getOperador(String op){

		for(Operador ops:operation){
			if(ops.getOp().equals(op)){
				return ops;
			}
		}

		return null;
	}

	public void recolheEstatistica(Expressao exp) {

		ArrayList<Input> inputs = exp.getInputs();

		for (Input input : inputs) {
			if (input.getTipo().contains("op")) {
				if (input.getConteudo().contains("+")){
					getOperador("+").add();
				}
				else if (input.getConteudo().contains("-")){
					getOperador("-").add();
				}

				else if (input.getConteudo().contains("*")){
					getOperador("*").add();
				}
				else if (input.getConteudo().contains("/")){
					getOperador("/").add();
				}
				else if (input.getConteudo().contains("sqrt")){
					getOperador("sqrt").add();
				}
				else if (input.getConteudo().contains("sin")){
					getOperador("sin").add();
				}
				else if (input.getConteudo().contains("cos")){
					getOperador("cos").add();
				}
				else if (input.getConteudo().contains("tan")){
					getOperador("tan").add();
				}
				else if (input.getConteudo().contains("log10")){
					getOperador("log10").add();
				}
				else if (input.getConteudo().contains("log2")){
					getOperador("log2").add();
				}
				else if (input.getConteudo().contains("log(")){
					getOperador("log").add();
				}
				else if (input.getConteudo().contains("!")){
					getOperador("!").add();
				}
				else if (input.getConteudo().contains("cbrt")){
					getOperador("cbrt").add();
				}
				else if (input.getConteudo().contains("e^")){
					getOperador("e^x").add();
				}
				else if (input.getConteudo().contains("10^")){
					getOperador("10^x").add();
				}
				else if (input.getConteudo().contains("^")){
					getOperador("^").add();
				}
			}

		}

	}

	public void recolheInput(Input in) {
		if (in.getTipo().contains("+/-")){
			getOperador("+/-").add();
		}
		else if (in.getTipo().contains("%")){
			getOperador("%").add();
		}
		else if (in.getTipo().contains("1/x")){
			getOperador("1/x").add();
		}
		else if (in.getTipo().contains("x^2")){
			getOperador("x^2").add();
		}
		else if (in.getTipo().contains("pi")){
			getOperador("pi").add();
		}
		else if (in.getTipo().contains("e")){
			getOperador("e").add();
		}
	}



	public synchronized ArrayList <Operador> getEntrada() {
		Collections.sort(operation);
		return operation;
	}
}