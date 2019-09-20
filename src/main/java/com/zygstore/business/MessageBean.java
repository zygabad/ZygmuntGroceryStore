package com.zygstore.business;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

@ManagedBean(name = "messageBean", eager = true)
@SessionScoped
public class MessageBean {
    private String message ="";

    public String doSomeAction(){
        if(this.message.equals("")){
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Message","Error Message"));
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal Message","Fatal Message"));
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN Message","WARN Message"));
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO Message","INFO Message"));
        }
        return "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
