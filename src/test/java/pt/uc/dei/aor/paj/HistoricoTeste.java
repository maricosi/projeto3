package pt.uc.dei.aor.paj;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HistoricoTeste {
	
	Historico historico;
	Input input;
	ArrayList<Input> inputarray;	
	Entrada ent;
	
	@Before
	public void init(){
		historico = new Historico();
	}
	
	@Test
	public void testGetEntradas(){
		assertThat(historico.getEntradas().size(), is(0));
	}
	
	@Test
	public void testaAdicionaEntrada(){
		input = new Input("nm", "2");
		inputarray = new ArrayList<>();
		inputarray.add(input);
		ent = new Entrada("5 + 5", "10",  inputarray, "0");		
		historico.adicionaEntrada(ent);
		
		assertThat(historico.getEntradas().size(), is(1));
	}
	
}