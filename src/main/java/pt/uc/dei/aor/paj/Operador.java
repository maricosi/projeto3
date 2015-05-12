package pt.uc.dei.aor.paj;

public class Operador implements Comparable<Operador>{

	private String descricao;
	private String op;
	private int quant = 0;
	//AtomicInteger quant = new AtomicInteger(0);

	

	public Operador(String op, String descricao) {
		this.op = op;
		this.setDescricao(descricao);
	}

	public void add(){
		this.quant++;
		//quant.incrementAndGet();
	}

	public String getOp() {
		return op;
	}


	public int getQuant() {
		//return quant.get();
		return quant;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int compareTo(Operador o) {
		if (o == null){
			return -1;
		}else if(o.quant > this.quant){
			return 1;
		}else if (o.quant < this.quant){
			return -1;
		}else {
			return (this.descricao.compareTo(o.descricao));
		}

	}

}