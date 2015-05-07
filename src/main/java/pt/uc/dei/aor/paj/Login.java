package pt.uc.dei.aor.paj;


import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;


@Named("user") // or @ManagedBean(name="user")
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name = "";
	private String password;

	public String getName() { 
		return name; 
	}

	public void setName(String newValue) { 
		name = newValue;
	}

	public String getPassword() { 
		return password; 
	}

	public void setPassword(String newValue) { 

		password = newValue; 
	}

	public String getGreeting() {

		if (name.length() == 0) return "Insira o nome!!";
		else return "Benvindo, " + name + "!";

	}
}

