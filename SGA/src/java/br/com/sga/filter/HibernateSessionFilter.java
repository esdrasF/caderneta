/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.filter;

import br.com.sga.util.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author DIGITACAOFUND
 */
public class HibernateSessionFilter implements Filter {
    
    private Logger log = LoggerFactory.getLogger(HibernateSessionFilter.class);
    private SessionFactory sf;

    @Override
    public void init(FilterConfig fc) throws ServletException {
        log.debug("Inicializando o filtro no método init().");
        log.debug("Instanciando a SessionFactory do HibernateUtil().");
        sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        log.debug("Entrou no método doFilter do filtro HibernateSessionFilter.");
        try {
            log.debug("Iniciando a transação.");
            this.sf.getCurrentSession().beginTransaction();
            log.debug("Passando a requisição para o próximo filtro.");
            fc.doFilter(sr, sr1);
            log.debug("Voltando ao filtro HibernaterSessionFilter.");
            log.debug("Comitando e fechando a sessão.");
            this.sf.getCurrentSession().getTransaction().commit();
        } catch (Throwable ex) {
            log.error("Falha na execução do filtro", ex);
            try {
                if (this.sf.getCurrentSession().getTransaction().isActive()) {
                    this.sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
            throw new ServletException();
        }
    }

    @Override
    public void destroy() {
    }
}
