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
	@Inject 
	Verificacaologin verifica;
	//conjunto de utilizadores inscritos
	private ArrayList <Verificacaologin> utilizadores;
	


	private String user, password, mensagem;

	
	@Inject
	private Historico histLogout;
	@Inject
	private GestorUser basedados;
	
	public Login() {
		super();
		this.utilizadores = new ArrayList<Verificacaologin>();
		Verificacaologin ut1=new Verificacaologin();
		Verificacaologin ut2=new Verificacaologin();
		ut1.setUsername("XXX");
		ut1.setPassword("123");
		ut2.setUsername("Mar");
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
		int nuser=basedados.getUsers().size();
		
		for(int i=0; i<nuser;i++){
			if(basedados.getUsers().get(i).getUsername().equals(username)){
				existe=true;
			}
		}
		
//		for(basedados.getUsers() p: basedados){
//			if(p.getUsername().equals(username))
//				existe=true;
//		}
		return existe;
	}

	//verifica se o utilizador com aquele username já existe ou nao
	public boolean verifyPass(String pass, String username){
		boolean existe=false;
		int nuser=basedados.getUsers().size();
		for(int i=0; i<nuser;i++){
			if(basedados.getUsers().get(i).getUsername().equals(username) && basedados.getUsers().get(i).getPassword().equals(pass)){
				existe=true;
			}
		}
		
		/*for(Verificacaologin p:utilizadores){
			if(p.getUsername().equals(username) && p.getPassword().equals(pass))
				existe=true;
		}*/
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

		if(verifyPass(this.password, this.user)&& !basedados.logado(user)){
			this.mensagem = "Bem Vindo ao Sistema "+this.user+"!";
			//	chat.setUtilizador(this.user);
			
			basedados.setlogado(user,true);
			this.user="";
			this.password="";
			//				this.numTentativas=0;
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/basic.xhtml");
			return "basic.xhtml";
		}else if(verifyPass(this.password, this.user)&& basedados.logado(user)){
			this.mensagem = "Utilizador já tem uma sessão ligada!";
			this.user="";
			this.password="";
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
			return "login.xhtml";
			
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

	public void logout(String user) throws IOException {
		
		basedados.setlogado(user,false);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		mensagem="";
		histLogout.getEntradas().clear();
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
	
	public String novoUser()throws IOException{
		boolean existe=false;

		existe=verifyUser(this.user);
		if (!existe){
			Verificacaologin ut=new Verificacaologin();
			ut.setUsername(this.user);
			ut.setPassword(this.password);
			basedados.addUser(ut);
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