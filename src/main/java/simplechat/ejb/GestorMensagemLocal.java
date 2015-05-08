package simplechat.ejb;

import java.util.Date;
import javax.ejb.Local;
import simplechat.ejb.Mensagem;


@Local
public interface GestorMensagemLocal {
 
    void sendMessage(Mensagem msg);
 
    Mensagem getFirstAfter(Date after);
 
}