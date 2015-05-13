package pt.uc.dei.aor.paj;


import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class Utilizador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Login> utilizadores;



	public Utilizador() {
		super();
		this.utilizadores = new ArrayList<Login>();
		utilizadores.add(new Login("Rita","123"));
		utilizadores.add(new Login("Marisa","456"));
	}

	//verifica se o utilizador com aquele username já existe ou nao
	public boolean verifyPass(String pass, String username){
		boolean existe=false;
		for(Login p:utilizadores){
			if(p.getUser().equals(username) && p.getPassword().equals(pass))
				existe=true;
		}
		return existe;
	}
	
	public boolean verifyUser(String username){
		boolean existe=false;
		for(Login p:utilizadores){
			if(p.getUser().equals(username))
				existe=true;
		}
		return existe;
	}

	//Acrescenta novo utilizador caso não exista
	public boolean novoUtilizador(String pass, String username){
		boolean existe=false;
		boolean novoUtilizador=false;

		existe=verifyUser(username);
		if (!existe){
			utilizadores.add(new Login(username,pass));
			novoUtilizador=true;
			
		}else if(existe){
			novoUtilizador=false;
		}
		
		return novoUtilizador;
	}





}
