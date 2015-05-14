package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class Mensagem implements Serializable{

	private static final long serialVersionUID = -9174255723670902683L;
	private String utilizador;
	private String txt;
	private String date;

	public String getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}

	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
		setDate();
	}
	public String getDate() {
		return this.date;
	}
	public void setDate() {
		Date hora = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("hh:mm");
		this.date=formatador.format(hora)+"";
	}

}