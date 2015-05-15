package pt.uc.dei.aor.paj;

import java.io.IOException;
import java.io.Serializable;





import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;



@Named
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = -2921010109456538382L;

	@Inject 
	private Mensagem chat;
	private String user, password, mensagem, mensagem2;
	@Inject
	private Historico histLogout;
	@Inject
	private GestorUser basedados;



	public Login() {
		super();
		this.user="";
		this.password="";
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
		return existe;
	}

	public boolean verifyPass(String pass){
		boolean existe=false;
		if(pass.length()<=5){
			existe=false;
		} else if(pass.length()>5){
			existe=true;
		}
		return existe;
	}

	//verifica se o utilizador com aquele username já existe ou nao
	public boolean verifyPassUser(String pass, String username){
		boolean existe=false;
		int nuser=basedados.getUsers().size();
		for(int i=0; i<nuser;i++){
			if(basedados.getUsers().get(i).getUsername().equals(username) && basedados.getUsers().get(i).getPassword().equals(pass)){
				existe=true;
			}
		}
		return existe;
	}

	//mensagem de loginSucess ou RegistoSucess
	public String getMensagem() {
		return mensagem;
	}

/*	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}*/

	public String getUser() {
		return user;
	}

	public String getMensagem2() {
		return mensagem2;
	}

	public String getPassword() {
		return password;
	}

	//logar para utilizador existente
	//estava void
	public String logar()throws IOException{

		//if (this.numTentativas<=3){

		if(verifyPassUser(this.password, this.user)&& !basedados.logado(user)){
			this.mensagem = "Bem Vindo ao Sistema "+this.user+"!";
			chat.setUtilizador(this.user);
			basedados.setlogado(user,true);
			
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			HttpSession sessao= (HttpSession) ec.getSession(true);
			sessao.setAttribute("loggedin", true);
			ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
			return "index.xhtml";
		}else if(verifyPassUser(this.password, this.user)&& basedados.logado(user)){
			this.mensagem = "Utilizador já tem uma sessão ligada!";
			this.user="";
			this.password="";
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
			return "login.xhtml";

		}else {
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
	public String novoUser()throws IOException{
		boolean existe=false;
		boolean conteudoPass=false;

		existe=verifyUser(this.user);
		conteudoPass=verifyPass(this.password);

		if (!existe && conteudoPass ){
			Verificacaologin ut=new Verificacaologin();
			ut.setUsername(this.user);
			ut.setPassword(this.password);
			basedados.addUser(ut);
			chat.setUtilizador(this.user);
			this.mensagem="Utilizador registado com sucesso!";
			this.user="";
			this.password="";
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
			return "index.xhtml";
		} else if(!existe && !conteudoPass ){
			this.mensagem="Password invalida!!";
			this.password="";
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
			return "login.xhtml";

		}else{
			this.mensagem="Utilizador já existente, escolha novo username";
			this.user="";
			//chat.setUtilizador(this.user);
			this.password="";
			return "login.xhtml";
		}
	}




}