package simplechat.ejb;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.context.RequestContext;

import simplechat.ejb.GestorMensagemLocal;
 

@ManagedBean
@ViewScoped
public class MensagemControlo implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
    GestorMensagemLocal mm;
 
    private final List<Mensagem> messages;
    private Date lastUpdate;
    private Mensagem message;
 
    /**
     * Creates a new instance of MessageBean
     */
    public MensagemControlo() {
        messages = Collections.synchronizedList(new LinkedList<Mensagem>());
        lastUpdate = new Date(0);
        message = new Mensagem();
    }
 
    public Date getLastUpdate() {
        return lastUpdate;
    }
 
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
 
    public Mensagem getMessage() {
        return message;
    }
 
    public void setMessage(Mensagem message) {
        this.message = message;
    }
 
    public void sendMessage(AjaxBehaviorEvent evt) {
        mm.sendMessage(message);
    }
 
    public void firstUnreadMessage(ActionEvent evt) {
       RequestContext ctx = RequestContext.getCurrentInstance();
 
       Mensagem m = mm.getFirstAfter(lastUpdate);
 
       ctx.addCallbackParam("ok", m!=null);
       if(m==null)
           return;
 
       lastUpdate = m.getDateSent();
 
       ctx.addCallbackParam("user", m.getUser());
       ctx.addCallbackParam("dateSent", m.getDateSent().toString());
       ctx.addCallbackParam("text", m.getMessage());
 
    }
 
}