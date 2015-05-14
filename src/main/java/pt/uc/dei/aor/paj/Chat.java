package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.LinkedList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
@Named
@ApplicationScoped
public class Chat implements Serializable{

	private static final long serialVersionUID = 6173082123788942581L;
	@Inject Mensagem msg;
	private LinkedList<String> conversa;
	private String utilizador;

		
	public String getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}

	public Chat() {
		super();
		this.conversa = new LinkedList<String>();
		this.conversa.add("Ola");
	}

	public LinkedList<String> getConversa() {
		return conversa;
	}

	public void actualizar() {
		
		this.conversa.addLast(msg.getDate()+" "+msg.getUtilizador()+":"+msg.getTxt());
	}
	
	
}
