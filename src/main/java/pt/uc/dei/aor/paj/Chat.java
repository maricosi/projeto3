package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.ArrayList;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ApplicationScoped
public class Chat implements Serializable{

	private static final long serialVersionUID = 6173082123788942581L;
	@Inject 
	private Mensagem msg;
	private ArrayList<Mensagem> conversa;
	private String utilizador;
	private String mensagemUti;

		


	public Chat() {
		super();
		this.conversa = new ArrayList<Mensagem>();
	}
	
	public String getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}

	public synchronized ArrayList<Mensagem> getConversa() {
		return conversa;
	}

	public synchronized void actualizar() {
		Mensagem nmsg=new Mensagem();
		nmsg.setTxt(msg.getTxt());
		nmsg.setDataMsg(msg.getDate());
		nmsg.setUtilizador(msg.getUtilizador());
		this.conversa.add(0,nmsg);
		mensagemUti="";
	}

	public String getMensagemUti() {
		return mensagemUti;
	}

	public void setMensagemUti(String mensagemUti) {
		msg.setTxt(mensagemUti);
		this.mensagemUti = mensagemUti;
	}
	
	
	
	
}
