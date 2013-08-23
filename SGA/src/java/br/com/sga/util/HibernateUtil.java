/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author DIGITACAOFUND
 */
public class HibernateUtil {

    private static Logger log = LoggerFactory.getLogger(HibernateUtil.class);
    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            log.debug("Criando a SessionFactory.....");
            SESSION_FACTORY = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable e) {
            log.error("Falha ao tentar criar a SessionFactory.", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        log.debug("Retornando a SessionFactory criada.");
        return SESSION_FACTORY;
    }
}
