package pt.uc.dei.aor.paj;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class GestorUser {



	private ArrayList <Verificacaologin> users;

	public GestorUser() {
		super();
		this.users = new ArrayList<Verificacaologin>();
		users.add(new Verificacaologin("Rita", "123"));
		users.add(new Verificacaologin("Marisa", "456"));
	}

	public void addUser(Verificacaologin x){
		users.add(x);
	}

	public ArrayList<Verificacaologin> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Verificacaologin> users) {
		this.users = users;
	}

	public boolean logado(String user){
		boolean logado=false;
		for(Verificacaologin p:users){
			if(user.equals(p.getUsername())){
				logado=p.isLogged();
			}

		}
		return logado;
	}

	public void setlogado(String user,boolean flag){
		for(Verificacaologin p:users){
			if(user.equals(p.getUsername())){
				p.setLogged(flag);
			}
		}

	}
}