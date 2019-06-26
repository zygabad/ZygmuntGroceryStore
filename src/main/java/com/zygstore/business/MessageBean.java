package com.zygstore.business;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

@ManagedBean(name = "messageBean", eager = true)
@SessionScoped
public class MessageBean {

    public String generateinfoMessage() {
        return "Testowy message";
    }
}
