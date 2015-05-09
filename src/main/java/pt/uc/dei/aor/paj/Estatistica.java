package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class Estatistica implements Serializable{
	
	
	private static final long serialVersionUID = -8382190444479383697L;
		
	HashMap<String, Operador> operation = new HashMap<String, Operador>();
	ValueComparate bvc =  new ValueComparate(operation);
	TreeMap<String, Operador> sorted_ops = new TreeMap<String, Operador>(bvc);
	
	private List<Entry<String, Operador>> entrada;
	
	public Estatistica() {
	
		operation.put("Adição", new Operador("+"));
		operation.put("Subtracção", new Operador("-"));
		operation.put("Divisão", new Operador("/"));
		operation.put("Multiplicação", new Operador("*"));
		operation.put("Raiz Quadrada", new Operador("sqrt"));
		operation.put("Mudança de Sinal", new Operador("+/-"));
		operation.put("Percentagem", new Operador("%"));
		operation.put("Seno", new Operador("sin"));
		operation.put("Coseno", new Operador("cos"));
		operation.put("Tangente", new Operador("tan"));
		operation.put("Inverso", new Operador("1/x"));
		operation.put("Quadrado de um número", new Operador("x^2"));
		operation.put("Elevado a...", new Operador("^"));
		operation.put("Pi", new Operador("pi"));
		operation.put("Exponensial", new Operador("e"));
		operation.put("Logaritmo base 10", new Operador("log10"));
		operation.put("Logaritmo base 2", new Operador("log2"));
		operation.put("Logaritmo ", new Operador("log"));
		operation.put("Factorial", new Operador("!"));
		operation.put("Raiz Cúbica", new Operador("cbrt"));
		operation.put("Exponensial elevado a um valor", new Operador("e^x"));
		operation.put("Dez elevado a um valor", new Operador("10^x"));
		
		
			
	}
	
	public void recolheEstatistica(Expressao exp){
		
		ArrayList<Input> inputs = exp.getInputs();
		
		for (Input input : inputs) {
			if(input.getTipo().contains("op")){
				if(input.getConteudo().contains("+")){
				//	operation.get("Adição").add();
					operation.get("Adição").setQuant();
				}
				else if(input.getConteudo().contains("-")){
				//	operation.get("Subtracção").add();
					operation.get("Subtracção").setQuant();
					
				}
				else if(input.getConteudo().contains("*"))
					operation.get("Multiplicação").add();
				else if(input.getConteudo().contains("/"))
					operation.get("Divisão").add();
				else if(input.getConteudo().contains("sqrt"))
					operation.get("Raiz Quadrada").add();
				else if(input.getConteudo().contains("sin"))
					operation.get("Seno").add();
				else if(input.getConteudo().contains("cos"))
					operation.get("Coseno").add();
				else if(input.getConteudo().contains("tan"))
					operation.get("Tangente").add();
				else if(input.getConteudo().contains("log10"))
					operation.get("Logaritmo base 10").add();
				else if(input.getConteudo().contains("log2"))
					operation.get("Logaritmo base 2").add();
				else if(input.getConteudo().contains("log("))
					operation.get("Logaritmo").add();
				else if(input.getConteudo().contains("!"))
					operation.get("Factorial").add();
				else if(input.getConteudo().contains("cbrt"))
					operation.get("Raíz Cúbica").add();
				else if(input.getConteudo().contains("e^"))
					operation.get("Exponensial elevado a um valor").add();					
				else if(input.getConteudo().contains("10^"))
					operation.get("Dez elavado a um valor").add();
				else if(input.getConteudo().contains("^"))
					operation.get("Elevado a...").add();
			}
			
		
		}
		sorted_ops.putAll(operation);
	
		
		
	}
	
	public void recolheInput(Input in){
		if(in.getTipo().contains("+/-"))
			operation.get("Mudança de Sinal").add();
		else if(in.getTipo().contains("%"))
			operation.get("Percentagem").add();
		else if(in.getTipo().contains("1/x"))
			operation.get("Inverso").add();
		else if(in.getTipo().contains("x^2"))
			operation.get("Quadrado de um número").add();
		else if(in.getTipo().contains("pi"))
			operation.get("Pi").add();
		else if(in.getTipo().contains("e"))
			operation.get("Exponensial").add();
		
		sorted_ops.putAll(operation);
	}

	public List<Entry<String, Operador>> getEntrada() {
		
		
		entrada = new ArrayList<Entry<String, Operador>>(operation.entrySet());
		
		return entrada;
	}
	public void limpaEstatistica(){
		
	operation.entrySet().clear();
	
	operation.put("Adição", new Operador("+"));
	operation.put("Subtracção", new Operador("-"));
	operation.put("Divisão", new Operador("/"));
	operation.put("Multiplicação", new Operador("*"));
	operation.put("Raiz Quadrada", new Operador("sqrt"));
	operation.put("Mudança de Sinal", new Operador("+/-"));
	operation.put("Percentagem", new Operador("%"));
	operation.put("Seno", new Operador("sin"));
	operation.put("Coseno", new Operador("cos"));
	operation.put("Tangente", new Operador("tan"));
	operation.put("Inverso", new Operador("1/x"));
	operation.put("Quadrado de um número", new Operador("x^2"));
	operation.put("Elevado a...", new Operador("^"));
	operation.put("Pi", new Operador("pi"));
	operation.put("Exponensial", new Operador("e"));
	operation.put("Logaritmo base 10", new Operador("log10"));
	operation.put("Logaritmo base 2", new Operador("log2"));
	operation.put("Logaritmo ", new Operador("log"));
	operation.put("Factorial", new Operador("!"));
	operation.put("Raiz Cúbica", new Operador("cbrt"));
	operation.put("Exponensial elevado a um valor", new Operador("e^x"));
	operation.put("Dez elevado a um valor", new Operador("10^x"));
	
	}
}
