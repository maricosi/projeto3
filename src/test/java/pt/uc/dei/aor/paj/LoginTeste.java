package pt.uc.dei.aor.paj;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;



@RunWith(MockitoJUnitRunner.class)
public class LoginTeste {

	

	@Mock
	GestorUser gestor;
	
	@InjectMocks
	Login login;
	
	@Test
	public void testLogin() {
		
		Mockito.when(login.getPassword()).thenReturn("123");
		Mockito.when(login.getUser()).thenReturn("Maria");
		boolean st = login.verifyPass("123");
		Assert.assertEquals(st,"false");
	}
}
