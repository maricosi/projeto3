package pt.uc.dei.aor.paj;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;





@RunWith(MockitoJUnitRunner.class)
public class LoginTeste {

	

	@Mock
	GestorUser gestor;
	
	@InjectMocks
	Login login;
	
	@Test
	public void testePassPequena(){
		boolean st = login.verifyPass("123");
		Assert.assertEquals(false, st);
	}
	
	@Test
	public void testePassGrande(){
		boolean st = login.verifyPass("123456");
		Assert.assertEquals(true, st);
	}
}
