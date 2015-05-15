package pt.uc.dei.aor.paj;

import java.util.LinkedList;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class ChatTeste {
	private LinkedList<String> conversa;

	 	@InjectMocks
	    GestorUser gestor;
	   
	    @Mock
	    Mensagem msg;
	   
	    @Mock
	    Chat chat;
	   
	    @Before
	    public void init() {
	        conversa=new LinkedList<String>();
	    }
	   
	    @Test
	    public void verificaAdicionaMensagem() {
	        conversa.add("Olá!");
	       
	        MatcherAssert.assertThat(conversa.contains("Olá!"), Matchers.is(Boolean.TRUE));
	       
	    }
	    
	    
}
