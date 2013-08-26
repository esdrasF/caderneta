/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.dao;

import br.com.sga.util.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author DIGITACAOFUND
 */
public abstract class HibernateDAOImp<T, ID extends Serializable>
        implements InterfaceDAO<T, ID> {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Class<T> classe;
    private Session session;

    public HibernateDAOImp() {
        this.classe =
                (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getClasse() {
        return classe;
    }

    public void setClasse(Class<T> classe) {
        this.classe = classe;
    }

    public Session getSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(T entidade) {
        session.save(entidade);
    }

    @Override
    public void update(T entidade) {
        session.update(entidade);
    }

    @Override
    public void remove(T entidade) {
        session.delete(entidade);
    }

    @Override
    public T getEntityByID(Serializable id) {
        T entidade = (T) session.get(classe, id);
        return entidade;
    }

    @Override
    public List<T> getEntityes() {
        List<T> listEntidades = session.createCriteria(classe).list();
        return listEntidades;
    }

    @Override
    public T getEntityeByCriteria(DetachedCriteria criteria) {
        T entidade = (T) criteria.getExecutableCriteria(session).uniqueResult();
        return entidade;
    }

    @Override
    public List<T> getEntitiesByCriteria(DetachedCriteria criteria) {
        List<T> litEntidades = criteria.getExecutableCriteria(session).list();
        return litEntidades;
    }
}
