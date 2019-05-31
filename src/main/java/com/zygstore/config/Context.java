package com.zygstore.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class Context {
    private String CLASSPATH;
    private ClassPathXmlApplicationContext ctx;

    public Context(String CLASSPATH) {
        this.CLASSPATH = CLASSPATH;
    }

    public ClassPathXmlApplicationContext getCtx() {
        return new ClassPathXmlApplicationContext(CLASSPATH);
    }
}
