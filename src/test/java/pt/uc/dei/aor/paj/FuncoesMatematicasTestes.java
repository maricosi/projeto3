package pt.uc.dei.aor.paj;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pt.uc.dei.aor.paj.Calc;
import pt.uc.dei.aor.paj.Estatistica;

@RunWith(MockitoJUnitRunner.class)



public class FuncoesMatematicasTestes {
	
	@Mock
	Input input;
	
	@Mock
	Estatistica calcestatistica;
	
	@Mock
	Historico chistorico;
	
	@InjectMocks
	private Calc calc;
	private Entrada ent ;

	@Before
	
	public void setUp() {
	}
	
	@Test
	public void testRead(){
		calc.read("num9");
		
		assertEquals("9",calc.getExp());
	}
	
	
	@Test
	public void testaUsarResultadoMostrador(){
		ArrayList<Input> input = new ArrayList<Input>();
		ent = new Entrada("30*4+9-5","124",input ,"0.07");
		calc.reUseResult(ent);
		
		assertEquals("124",calc.getExp());
	}
	
	@Test
	public void testaDevolveExpressaoMostrador(){
		
		ArrayList<Input> input = new ArrayList<Input>();
		ent = new Entrada("30*4+9-5","124",input ,"0.05");
		calc.reUseExp(ent);
		
		assertEquals("30*4+9-5",calc.getExp());
	}
	
	@Test
	public void testaApagarUltimoDigito(){
		calc.read("num7");
		calc.read("num9");
		calc.read("num6");
		calc.clearLast();	
		
		assertEquals("",calc.getExp());
	}
	
	@Test
	public void testaVirgula() {
		calc.setExisteVirgula(true);	
		calc.clearAll();
	
		assertEquals(false,calc.isExisteVirgula());
	}
	
	@Test
	public void testaSoma(){

		calc.read("num0");
		calc.read("soma");
		calc.read("num1");
		calc.read("soma");
		calc.read("num2");
		
		calc.read("igual");
		
		assertEquals("3",calc.getExp());
	}
	
	@Test
	public void testaSubtraccao(){

		calc.read("num9");
		calc.read("sub");
		calc.read("num1");
		calc.read("num2");
		
		calc.read("igual");
		
		assertEquals("-3",calc.getExp());
	}
	
	@Test
	public void testaMultiplicacao(){

		calc.read("num7");
		calc.read("mult");
		calc.read("num3");
		
		calc.read("igual");
		
		assertEquals("21",calc.getExp());
	}
	
	@Test
	public void testaDivisao(){

		calc.read("num1");
		calc.read("num0");
		calc.read("div");
		calc.read("num5");
		
		calc.read("igual");
		
		assertEquals("2",calc.getExp());
	}
	
	@Test
	public void testaSeno(){
		calc.setGraus(true);
		calc.read("sen");
		calc.read("num0");
		calc.read("fechapar");
	
		calc.read("igual");
		
		assertEquals("0",calc.getExp());
	}
	
	@Test
	public void testaLog10(){
		
		calc.read("log10");
		calc.read("num5");
		calc.read("fechapar");
		
		calc.read("igual");
		
		assertEquals("0.6989700043360189",calc.getExp());
	}
	
	@Test
	public void testaFactorial(){
		calc.read("num1");
		calc.read("num0");
		calc.read("fact");
		
		calc.read("igual");
		
		assertEquals("3628800",calc.getExp());
	}
	
	@Test
	public void testaDivisaoZero(){
		calc.read("num1");
		calc.read("div");
		calc.read("num0");
		
		calc.read("igual");
		
		assertEquals("erros na expressao",calc.getExp());
	}
	
	 @Test
		public void testaRaizQuadrada(){
			calc.read("raizq");
			calc.read("num2");
			calc.read("num5");
			calc.read("fechapar");
			
			calc.read("igual");
			assertEquals("5",calc.getExp());
		}
	 
	   @Test
 		public void testPercent(){
 			calc.read("num5");
 			calc.read("num0");
 			calc.read("percent");
 			
 			calc.read("igual");
 			assertEquals("0.5",calc.getExp());
 				
 		}
	   
	   @Test
	    public void testaRaizNegativa() {
	        calc.read("raizq");
	        calc.read("sub");
	        calc.read("num9");
	        calc.read("fechapar");
	        
	        calc.read("igual");
	    	assertEquals("NaN",calc.getExp());
	        
	    }
	   
}
