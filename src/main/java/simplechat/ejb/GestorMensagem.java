
package simplechat.ejb;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import simplechat.ejb.Mensagem;
 
@Singleton
@Startup
public class GestorMensagem implements GestorMensagemLocal {
 
    private final List<Mensagem> message = Collections.synchronizedList(new LinkedList<Mensagem>());
 
    @Override
    public void sendMessage(Mensagem msg) {
        message.add(msg);
        msg.setDateSent(new Date());
    }
 
    @Override
    public Mensagem getFirstAfter(Date after) {
        if(message.isEmpty())
            return null;
        if(after == null)
            return message.get(0);
        for(Mensagem m :message) {
            if(m.getDateSent().after(after))
                return m;
        }
        return null;
    }
 
}
