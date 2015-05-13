package pt.uc.dei.aor.paj;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;



@Named
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = -2921010109456538382L;

	//	@Inject Mensagem chat;
	@Inject Verificacaologin verifica;
	//conjunto de utilizadores inscritos
	private ArrayList <Verificacaologin> utilizadores;
	//private Utilizador utilizadores;
	//2 utilizadores inscritos por defeito

	//private int numTentativas;
	private String user, password, mensagem;
	//variável auxiliar que vai ficar true quando o utilizador fica logado
	private boolean isLogged=false;

	//construtor cria a ArrayList dos utilizadores e acrescenta os dois por defeito
	
	
	public Login() {
		super();
		this.utilizadores = new ArrayList<Verificacaologin>();
		Verificacaologin ut1=new Verificacaologin();
		Verificacaologin ut2=new Verificacaologin();
		ut1.setUsername("Rita");
		ut1.setPassword("123");
		ut2.setUsername("Marisa");
		ut2.setPassword("456");
		this.utilizadores.add(ut1);
		this.utilizadores.add(ut2);
		//this.numTentativas=0;
	}

	public Login(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	//verifica se o utilizador com aquele username já existe ou nao
	public boolean verifyUser(String username){
		boolean existe=false;
		for(Verificacaologin p:utilizadores){
			if(p.getUsername().equals(username))
				existe=true;
		}
		return existe;
	}

	//verifica se o utilizador com aquele username já existe ou nao
	public boolean verifyPass(String pass, String username){
		boolean existe=false;
		for(Verificacaologin p:utilizadores){
			if(p.getUsername().equals(username) && p.getPassword().equals(pass))
				existe=true;
		}
		return existe;
	}

	//mensagem de loginSucess ou RegistoSucess
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	//logar para utilizador existente
	//estava void
	public String logar()throws IOException{

		//if (this.numTentativas<=3){

		if(verifyPass(this.password, this.user)){
			this.mensagem = "Bem Vindo ao Sistema "+this.user+"!";
			//	chat.setUtilizador(this.user);
			this.user="";
			this.password="";
			isLogged=true;
			verifica.setLogged(isLogged);
			//				this.numTentativas=0;
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/basic.xhtml");
			return "basic.xhtml";

		}else {
			//	this.numTentativas++;
		
			this.mensagem = "Utilizador ou senha Inválidos!";
			this.user="";
			this.password="";
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
			return "login.xhtml";
		}
	}

	public void logout() throws IOException {
		this.isLogged = false;
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
	}	


	//Acrescenta novo utilizador caso não exista
	public String novoUtilizador()throws IOException{
		boolean existe=false;

		existe=verifyUser(this.user);
		if (!existe){
			Verificacaologin ut=new Verificacaologin();
			ut.setUsername(this.user);
			ut.setPassword(this.password);
			this.utilizadores.add(ut);
			//	chat.setUtilizador(this.user);
			this.mensagem="Utilizador registado com sucesso!";
			this.user="";
			this.password="";
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
			return "login.xhtml";
			//this.logged=true;
		}else{
			this.mensagem="Utilizador já existente, escolha novo username";
			this.user="";
			//	chat.setUtilizador(this.user);
			this.password="";
			return "login";
		}
	}


}