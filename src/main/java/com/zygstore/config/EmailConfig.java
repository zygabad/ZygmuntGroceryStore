package com.zygstore.config;

import java.util.Properties;


import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class EmailConfig {
    private Session session;
    private String hostName;
    private String username;
    private String password;
    private int port;
    private boolean auth;

    public EmailConfig(String hostName, String username, String password, int port, boolean auth) {
        this.hostName = hostName;
        this.username = username;
        this.password = password;
        this.port = port;
        this.auth = auth;
        this.session = createSession();
    }

    public final Session getSession() {
        return session;
    }

    private Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", hostName);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", auth);

        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public String getHostName() {
        return hostName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public boolean isAuth() {
        return auth;
    }
}
