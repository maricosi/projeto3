package pt.uc.dei.aor.paj;




import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class Utilizador {

	private ArrayList<Utilizador> utilizadores;
	private String username;
	private String password;

	
	public ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void setUtilizadores(ArrayList<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Utilizador(ArrayList<Utilizador> utilizadores) {
		super();
		this.utilizadores = utilizadores;
	}

	//verifica se o utilizador com aquele username já existe ou nao
	public boolean verifyPass(String pass, String username){
		boolean existe=false;
		for(Utilizador p:utilizadores){
			if(p.getUsername().equals(username) && p.getPassword().equals(pass))
				existe=true;
		}
		return existe;
	}

}
