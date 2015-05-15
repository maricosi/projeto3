package pt.uc.dei.aor.paj;

import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class EstatisticaTeste {

	Estatistica s;
	List<Operador> out;
	Expressao exp;
	Input input1 = new Input("nm", "9");
	Input input2 = new Input("nm", "3");
	Input input3 = new Input("op", " * ");
	Input input4 = new Input("nm", "27");	
	Input input5 = new Input("op", " / ");
	Input input6 = new Input("%", "%");
	Input input7 = new Input("!", "!");
	

	public EstatisticaTeste(){
		s = new Estatistica();
		exp = new Expressao();
	}
	
	@Test
	public void inicialmente_tem_22_elementos() {
		int result = s.getEntrada().size();
		assertThat(result, Matchers.is(Matchers.equalTo(22)));
	}

	@Before
	@Test
	public void testaInputsNaoNulos(){
		
		s.recolheInput(input6);
		s.recolheInput(input7);
		out = s.getEntrada();
		
		assertThat(out,notNullValue());
	}
	
	@Before
	@Test
	public void testaRecolheEstatistica(){
		exp.add(input1);
		exp.add(input2);
		exp.add(input3);
		exp.add(input4);
		exp.add(input5);
		s.recolheEstatistica(exp);
		out = s.getEntrada();
		
		assertThat(out, notNullValue());
	}
	
}